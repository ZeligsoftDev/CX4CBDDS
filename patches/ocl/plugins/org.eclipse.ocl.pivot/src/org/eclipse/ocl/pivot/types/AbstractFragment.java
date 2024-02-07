/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.types;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public abstract class AbstractFragment implements InheritanceFragment
{
	public final @NonNull CompleteInheritance derivedInheritance;
	public final @NonNull CompleteInheritance baseInheritance;

	public AbstractFragment(@NonNull CompleteInheritance derivedInheritance, @NonNull CompleteInheritance baseInheritance) {
		this.derivedInheritance = derivedInheritance;
		this.baseInheritance = baseInheritance;
	}

	/**
	 * Return the actualOperation that has the same signature as apparentOperation.
	 */
	@Override
	public @NonNull Operation getActualOperation(@NonNull Operation apparentOperation) {
		Operation localOperation = getLocalOperation(apparentOperation);
		if (localOperation == null) {
			if (derivedInheritance == baseInheritance) {
				localOperation = apparentOperation;
			}
		}
		if (localOperation == null) {				// Non-trivial, search up the inheritance tree for an inherited operation
			Operation bestOverload = null;
			CompleteInheritance bestInheritance = null;
			int bestDepth = -1;
			int minDepth = baseInheritance.getDepth();
			for (int depth = derivedInheritance.getDepth()-1; depth >= minDepth; depth--) {
				Iterable<InheritanceFragment> derivedSuperFragments = derivedInheritance.getSuperFragments(depth);
				for (InheritanceFragment derivedSuperFragment : derivedSuperFragments) {
					CompleteInheritance superInheritance = derivedSuperFragment.getBaseInheritance();
					InheritanceFragment superFragment = superInheritance.getFragment(baseInheritance);
					if (superFragment != null) {
						Operation overload = superFragment.getLocalOperation(apparentOperation);
						if (overload != null) {
							if (bestInheritance == null) {				// First candidate
								bestDepth = depth;
								bestInheritance = superInheritance;
								bestOverload = overload;
							}
							else if (depth == bestDepth) {				// Sibling candidate
								bestOverload = null;
								depth = -1;
								break;
							}
							else if (!bestInheritance.isSubInheritanceOf(superInheritance)) {	// Non-occluded child candidate
								bestOverload = null;
								depth = -1;
								break;
							}
						}
					}
				}
			}
			if (bestOverload != null) {
				localOperation = bestOverload;
			}
			else if (bestInheritance == null) {
				localOperation = apparentOperation;		// FIXME Missing operation
			}
			else {
				throw new InvalidValueException(PivotMessages.AmbiguousOperation, apparentOperation, derivedInheritance);
			}
		}
		//		if (localOperation == null) {
		//			localOperation = INVALID;
		//		}
		//		if (localOperation == null) {
		//			localOperation = apparentOperation;
		//		}
		return localOperation;
	}

	@Override
	public final @NonNull InheritanceFragment getBaseFragment() {
		return baseInheritance.getSelfFragment();
	}

	@Override
	public final @NonNull CompleteInheritance getBaseInheritance() {
		return baseInheritance;
	}

	@Override
	public final @NonNull CompleteInheritance getDerivedInheritance() {
		return derivedInheritance;
	}

	/**
	 * Return true if anOperation overloads an existing operation.
	 *
	protected boolean isOverload(DomainOperation anOperation) {
		int depth = derivedInheritance.getDepth();
		for (int i = 0; i <= depth-1; i++) {
			for (DomainInheritance superInheritance : derivedInheritance.getSuperInheritances(depth)) {
				DomainFragment baseFragment = superInheritance.getSelfFragment();
				for (DomainOperation baseOperation : baseFragment.getOperations()) {
					if (isOverload(anOperation, baseOperation)) {
						return true;
					}
				}
			}
		}
		return false;
	} */

	/*	public DomainOperation lookupOperation(DomainStandardLibrary standardLibrary, DomainType staticType, String operationName, DomainType[] argumentTypes) {
		for (DomainOperation operation : getOperations()) {		// FIXME binary search
			if (operation.getName().equals(operationName)) {
				boolean gotIt = true;
				IndexableIterable<? extends DomainType> parameterTypeArguments = operation.getParameterType();
//				ExecutorTypeArgument[] parameterTypeArguments = operation.getParameterType();
				if (parameterTypeArguments.size() == argumentTypes.length) {
					for (int i = 0; i < parameterTypeArguments.size(); i++) {
						DomainType argumentType = argumentTypes[i];
						DomainType parameterTypeArgument = parameterTypeArguments.get(i);
//						if (parameterTypeArgument instanceof ExecutorType) {
							DomainType parameterType;
							if (parameterTypeArgument == standardLibrary.getOclSelfType()) {
								parameterType = staticType;
							}
							else {
								parameterType = parameterTypeArgument;
							}
							if (!argumentType.conformsTo(standardLibrary, parameterType)) {
								gotIt = false;
								break;
							}

//						}
//						else {
//							// FIXME
//						}
					}
				}
				if (gotIt) {
					return operation;
				}
			}
		}
		return null;
	} */

	@Override
	public @NonNull String toString() {
		return derivedInheritance.toString() + "__" + baseInheritance.toString(); //$NON-NLS-1$
	}
}