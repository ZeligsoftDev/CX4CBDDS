/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;

public class FinalAnalysis
{
	/**
	 * @since 1.3
	 */
	public static final @NonNull TracingOption FINAL_ANALYSIS = new TracingOption(PivotPlugin.PLUGIN_ID, "finalAnalysis");

	protected final @NonNull CompleteModelInternal completeModel;
	/* @Deprecated - not needed - compute from completeModel */
	@Deprecated
	protected final @NonNull PivotMetamodelManager metamodelManager;

	/**
	 * Map from a CompleteClass to all its sub CompleteClasses.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> superCompleteClass2subCompleteClasses = new HashMap<>();

	/**
	 * Map from an Operation to all its overrides, including itself. In the degenerate common case of no overrides, the single entry set is replaced by null.
	 */
	private final @NonNull Map<@NonNull Operation, @Nullable Set<@NonNull Operation>> operation2overrides = new HashMap<>();

	public FinalAnalysis(@NonNull CompleteModelInternal completeModel) {
		this.completeModel = completeModel;
		PivotMetamodelManager metamodelManager = completeModel.getMetamodelManager();
		this.metamodelManager = metamodelManager;
		for (@NonNull CompletePackage completePackage :  completeModel.getAllCompletePackages()) {
			for (@NonNull CompleteClass subCompleteClass :  ClassUtil.nullFree(completePackage.getOwnedCompleteClasses())) {
				for (@NonNull CompleteClass superCompleteClass : subCompleteClass.getSuperCompleteClasses()) {
					Set<@NonNull CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(superCompleteClass);
					if (subCompleteClasses == null) {
						subCompleteClasses = new HashSet<>();
						superCompleteClass2subCompleteClasses.put(superCompleteClass, subCompleteClasses);
					}
					subCompleteClasses.add(subCompleteClass);
				}
			}
		}
		for (@NonNull CompleteClass superCompleteClass : superCompleteClass2subCompleteClasses.keySet()) {
			Set<@NonNull CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(superCompleteClass);
			assert subCompleteClasses != null;
			for (@NonNull Operation domainOperation : superCompleteClass.getOperations(null)) {
				String opName = domainOperation.getName();
				ParametersId parametersId = domainOperation.getParametersId();
				LibraryFeature domainImplementation = metamodelManager.getImplementation(domainOperation);
				Set<@NonNull Operation> overrides = operation2overrides.get(domainOperation);
				for (@NonNull CompleteClass subCompleteClass : subCompleteClasses) {
					if (subCompleteClass != superCompleteClass) {
						for (@NonNull Operation subOperation : subCompleteClass.getOperations(null)) {
							if (opName.equals(subOperation.getName()) && parametersId.equals(subOperation.getParametersId()) && completeModel.getCompleteClass(PivotUtil.getOwningClass(subOperation)).conformsTo(superCompleteClass)) {
								LibraryFeature subImplementation = metamodelManager.getImplementation(subOperation);
								if ((domainImplementation != subImplementation)
										|| (domainOperation.getBodyExpression() != subOperation.getBodyExpression())
										|| (domainOperation.getTypeId() != subOperation.getTypeId())) {
									if (overrides == null) {
										overrides = new HashSet<>();
										overrides.add(domainOperation);
									}
									overrides.add(subOperation);
								}
							}
						}
					}
				}
				operation2overrides.put(domainOperation, overrides);
			}
		}
		if (FINAL_ANALYSIS.isActive()) {
			StringBuilder s = new StringBuilder();
			print(s);
			FINAL_ANALYSIS.println(s.toString());
		}
	}

	/**
	 * Return the overrides of operation. If there are no overrides the original operation is returned.
	 *
	 * @since 1.1
	 */
	public @NonNull Iterable<@NonNull Operation> getOverrides(@NonNull Operation operation) {
		Set<@NonNull Operation> overrides = operation2overrides.get(operation);
		return overrides != null ? overrides : Collections.singletonList(operation);
	}

	/**
	 * Return the overrides of operation that are applicable to a source type of completeClass. If there are no overrides
	 * the original operation is returned.
	 *
	 * @since 1.1
	 */
	public @NonNull Iterable<@NonNull Operation> getOverrides(@NonNull Operation operation, @NonNull CompleteClass completeClass) {
		Set<@NonNull Operation> overrides = operation2overrides.get(operation);
		if (overrides == null) {
			return Collections.singletonList(operation);
		}
		List<@NonNull Operation> results = new ArrayList<>();
		StandardLibraryInternal standardLibrary = completeModel.getStandardLibrary();
		CompleteInheritance requiredInheritance = completeClass.getCompleteInheritance();
		for (@NonNull Operation override : overrides) {
			CompleteInheritance overrideInheritance = override.getInheritance(standardLibrary);
			if ((overrideInheritance != null) && requiredInheritance.isSuperInheritanceOf(overrideInheritance)) {
				results.add(override);
			}
		}
		if (results.size() <= 0) {
			results.add(operation);
		}
		return results;
	}

	/**
	 * Return true if no classes derive from completeClass.
	 *
	 * @param completeClass
	 * @return
	 */
	public boolean isFinal(@NonNull CompleteClass completeClass) {
		Set<@NonNull CompleteClass> subCompleteClasses = superCompleteClass2subCompleteClasses.get(completeClass);
		return (subCompleteClasses != null) && (subCompleteClasses.size() <= 1);
	}

	/**
	 * Return true if no derived classes override operation.
	 *
	 * @param completeClass
	 * @return
	 */
	public boolean isFinal(@NonNull Operation operation) {
		Set<@NonNull Operation> overrides = operation2overrides.get(operation);
		return overrides == null;
	}

	public @Nullable Operation isFinal(@NonNull Operation operation, @NonNull CompleteClass completeClass) {
		Set<@NonNull Operation> overrides = operation2overrides.get(operation);
		if (overrides == null) {
			return operation;
		}
		Operation candidate = null;
		StandardLibraryInternal standardLibrary = completeModel.getStandardLibrary();
		CompleteInheritance requiredInheritance = completeClass.getCompleteInheritance();
		for (@NonNull Operation override : overrides) {
			CompleteInheritance overrideInheritance = override.getInheritance(standardLibrary);
			if ((overrideInheritance != null) && requiredInheritance.isSuperInheritanceOf(overrideInheritance)) {
				if (candidate != null) {
					return null;
				}
				candidate = override;
			}
		}
		return candidate;
	}

	public void print(@NonNull StringBuilder s) {
		List<@NonNull CompleteClass> completeClasses = new ArrayList<>(superCompleteClass2subCompleteClasses.keySet());
		Collections.sort(completeClasses, NameUtil.NAMEABLE_COMPARATOR);
		s.append("Final types");
		for (@NonNull CompleteClass completeClass : completeClasses) {
			assert completeClass != null;
			if (isFinal(completeClass)) {
				s.append("\n\t");
				s.append(completeClass.getName());
			}
		}
		s.append("\nNon-final types");
		for (@NonNull CompleteClass completeClass : completeClasses) {
			assert completeClass != null;
			if (!isFinal(completeClass)) {
				s.append("\n\t");
				s.append(completeClass.getName());
			}
		}
		List<@NonNull Operation> allOperations = new ArrayList<>(operation2overrides.keySet());
		Collections.sort(allOperations, NameUtil.TO_STRING_COMPARATOR);
		for (@NonNull Operation asOperation : allOperations) {
			Set<@NonNull Operation> overrides = operation2overrides.get(asOperation);
			if (overrides != null) {
				List<@NonNull Operation> allOverrides = new ArrayList<>(overrides);
				Collections.sort(allOverrides, NameUtil.TO_STRING_COMPARATOR);
				s.append("\n" + asOperation);
				for (@NonNull Operation asOverride : allOverrides) {
					s.append("\n\t" + asOverride);
				}
			}
		}

	}

}
