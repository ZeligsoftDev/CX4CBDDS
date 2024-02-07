/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * PrecedenceManager encapsulates the knowledge about known precedences.
 * @since 1.5
 */
public class PrecedenceManager
{
	public static @NonNull Precedence NULL_PRECEDENCE = PivotFactory.eINSTANCE.createPrecedence();
	/**
	 * @since 1.5
	 */
	public static final int NULL_PRECEDENCE_ORDER = Integer.MAX_VALUE/2;
	public static @NonNull Precedence NAVIGATION_PRECEDENCE = PivotFactory.eINSTANCE.createPrecedence();
	/**
	 * @since 1.5
	 */
	public static final int NAVIGATION_PRECEDENCE_ORDER = Integer.valueOf(-1);
	public static @NonNull Precedence LEAF_PRECEDENCE = PivotFactory.eINSTANCE.createPrecedence();
	/**
	 * @since 1.5
	 */
	public static final int LEAF_PRECEDENCE_ORDER = Integer.valueOf(-2);
	static {
		NULL_PRECEDENCE.setName("NULL");
		//		NULL_PRECEDENCE.setOrder(NULL_PRECEDENCE_ORDER);			// Small enough to avoid wrap around during comparison
		NULL_PRECEDENCE.setAssociativity(AssociativityKind.LEFT);
		NAVIGATION_PRECEDENCE.setName("NAVIGATION");
		//		NAVIGATION_PRECEDENCE.setOrder(NAVIGATION_PRECEDENCE_ORDER);
		NAVIGATION_PRECEDENCE.setAssociativity(AssociativityKind.LEFT);
		LEAF_PRECEDENCE.setName("LEAF");
		//		LEAF_PRECEDENCE.setOrder(LEAF_PRECEDENCE_ORDER);
		LEAF_PRECEDENCE.setAssociativity(AssociativityKind.LEFT);
	}

	/**
	 * Map of precedence name to precedence objects. Multiple precedence objects
	 * may be associated with a single name since alternate contributions
	 * provide independent lists that must be successfully interleaved so that
	 * all same-named precedence objects get the same compiled ordering.
	 * <p>
	 * e.g. <tt> precedence A B D</tt> and <tt>precedence B C D</tt> merge to
	 * <tt>A B C D</tt> with duplicate precedence objects for B and D.
	 */
	private Map<@NonNull String, @NonNull List<@NonNull Precedence>> nameToPrecedencesMap = null;

	private Map<@NonNull String, String> infixToPrecedenceNameMap = null;

	private Map<@NonNull String, @NonNull String> prefixToPrecedenceNameMap = null;

	private Map<@NonNull Precedence, @NonNull Integer> precedence2order = null;

	/**
	 * Interleave the ownedPrecedences of the rootPackages to establish a merged
	 * ordering and assign the index in that ordering to each
	 * rootPackages.ownedPrecedences. Any inconsistent ordering and
	 * associativity is diagnosed.
	 */
	public @NonNull List<@NonNull String> compilePrecedences(@NonNull Iterable<@NonNull ? extends Library> libraries) {
		List<@NonNull String> errors = new ArrayList<>();
		List<@NonNull String> orderedPrecedences = new ArrayList<>();
		nameToPrecedencesMap = new HashMap<>();
		infixToPrecedenceNameMap = new HashMap<>();
		prefixToPrecedenceNameMap = new HashMap<>();
		precedence2order = new HashMap<>();
		for (@NonNull Library library : libraries) {
			List<@NonNull Precedence> precedences = ClassUtil.nullFree(library.getOwnedPrecedences());
			if (precedences.size() > 0) {
				compilePrecedencePackage(errors, library);
				int prevIndex = -1;
				List<Precedence> list = null;
				String name = null;
				for (@NonNull Precedence precedence : precedences) {
					name = precedence.getName();
					assert name != null;
					int index = orderedPrecedences.indexOf(name);
					if (index < 0) {
						index = prevIndex < 0 ? orderedPrecedences.size() : prevIndex + 1;
						orderedPrecedences.add(index, name);
						list = new ArrayList<>();
						nameToPrecedencesMap.put(name, list);
					} else {
						list = nameToPrecedencesMap.get(name);
						assert list != null;
						if (index <= prevIndex) {
							errors.add("Inconsistent precedence ordering for '" + name + "'");
						} else if ((prevIndex >= 0) && (index != prevIndex + 1)) {
							errors.add("Ambiguous precedence ordering for '" + name + "'");
						}
						if (precedence.getAssociativity() != list.get(0).getAssociativity()) {
							errors.add("Inconsistent precedence associativity for '" + name + "'");
						}
					}
					prevIndex = index;
					list.add(precedence);
				}
				if ((list != null) && (list.size() == 1) && (prevIndex != orderedPrecedences.size() - 1)) {
					errors.add("Ambiguous precedence ordering for '" + name + "' at tail");
				}
			}
		}
		precedence2order.put(NULL_PRECEDENCE, NULL_PRECEDENCE_ORDER);			// Small enough to avoid wrap around during comparison
		precedence2order.put(NAVIGATION_PRECEDENCE, NAVIGATION_PRECEDENCE_ORDER);
		precedence2order.put(LEAF_PRECEDENCE, LEAF_PRECEDENCE_ORDER);
		for (int i = 0; i < orderedPrecedences.size(); i++) {
			String name = orderedPrecedences.get(i);
			List<@NonNull Precedence> precedences = nameToPrecedencesMap.get(name);
			assert precedences != null;
			for (Precedence precedence : precedences) {
				precedence2order.put(precedence, i);
			}
		}
		return errors;
	}

	protected void compilePrecedenceOperation(@NonNull List<@NonNull String> errors, @NonNull Operation operation) {
		Precedence precedence = operation.getPrecedence();
		if (precedence != null) {
			List<@NonNull Parameter> parameters = ClassUtil.nullFree(operation.getOwnedParameters());
			if (parameters.size() == 0) {
				String newName = precedence.getName();
				String operatorName = operation.getName();
				assert (newName != null) && (operatorName != null);
				String oldName = prefixToPrecedenceNameMap.put(operatorName, newName);
				if ((oldName != null) && !oldName.equals(newName)) {
					errors.add("Conflicting precedences for prefix operation '" + operatorName + "'");
				}
			} else if (parameters.size() == 1) {
				String newName = precedence.getName();
				String operatorName = operation.getName();
				assert (newName != null) && (operatorName != null);
				String oldName = infixToPrecedenceNameMap.put(operatorName, newName);
				if ((oldName != null) && !oldName.equals(newName)) {
					errors.add("Conflicting precedences for infix operation '" + operatorName + "'");
				}
			}
		}
	}

	protected void compilePrecedencePackage(@NonNull List<@NonNull String> errors, @NonNull Library library) {
		//		for (org.eclipse.ocl.pivot.Package nestedPackage : pivotPackage.getNestedPackage()) {
		//			compilePrecedencePackage(errors, nestedPackage);
		//		}
		for (org.eclipse.ocl.pivot.Class type : library.getOwnedClasses()) {
			if ((type != null) && !PivotUtilInternal.isOrphanType(type)) {
				compilePrecedenceType(errors, type);
			}
		}
	}

	protected void compilePrecedenceType(@NonNull List<String> errors, org.eclipse.ocl.pivot.@NonNull Class pivotType) {
		for (Operation operation : pivotType.getOwnedOperations()) {
			if (operation != null) {
				compilePrecedenceOperation(errors, operation);
			}
		}
	}

	public void dispose() {
		nameToPrecedencesMap = null;
		infixToPrecedenceNameMap = null;
		prefixToPrecedenceNameMap = null;
	}

	public @Nullable Precedence getInfixPrecedence(@NonNull String operatorName) {
		String precedenceName = infixToPrecedenceNameMap.get(operatorName);
		if (precedenceName == null) {
			return null;
		}
		List<@NonNull Precedence> precedences = nameToPrecedencesMap.get(precedenceName);
		if (precedences == null) {
			return null;
		}
		return precedences.get(0);
	}

	/**
	 * @since 1.5
	 */
	public int getOrder(@NonNull Precedence precedence) {
		return ClassUtil.nonNullState(precedence2order.get(precedence));
	}

	public @Nullable Precedence getPrefixPrecedence(@NonNull String operatorName) {
		String precedenceName = prefixToPrecedenceNameMap.get(operatorName);
		if (precedenceName == null) {
			return null;
		}
		List<@NonNull Precedence> precedences = nameToPrecedencesMap.get(precedenceName);
		if (precedences == null) {
			return null;
		}
		return precedences.get(0);
	}
}