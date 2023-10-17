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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorNamedElement;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.library.UnsupportedOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.IndexableIterable;

public abstract class AbstractInheritance extends AbstractExecutorNamedElement implements CompleteInheritance
{
	public static class FragmentIterable implements IndexableIterable<@NonNull InheritanceFragment>
	{
		protected class Iterator implements java.util.Iterator<@NonNull InheritanceFragment>
		{
			private int index = firstIndex;

			@Override
			public boolean hasNext() {
				return index < lastIndex;
			}

			@Override
			public @NonNull InheritanceFragment next() {
				return array[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}

		private final @NonNull InheritanceFragment @NonNull [] array;
		private final int firstIndex;
		private final int lastIndex;

		public FragmentIterable(@NonNull InheritanceFragment @NonNull [] array) {
			this.array = array;
			this.firstIndex = 0;
			this.lastIndex = array.length;
		}

		public FragmentIterable(@NonNull InheritanceFragment @NonNull [] array, int firstIndex, int lastIndex) {
			this.array = array;
			this.firstIndex = firstIndex;
			this.lastIndex = lastIndex;
		}

		@Override
		public @NonNull InheritanceFragment get(int index) {
			return ClassUtil.nonNullState(array[firstIndex + index]);
		}

		@Override
		public java.util.@NonNull Iterator<@NonNull InheritanceFragment> iterator() {
			return new Iterator();
		}

		@Override
		public int size() {
			return lastIndex - firstIndex;
		}

		@Override
		public String toString() {
			StringBuilder s = null;
			for (int i = firstIndex; i < lastIndex; i++) {
				if (s == null) {
					s = new StringBuilder();
					s.append("[");
				}
				else {
					s.append(", ");
				}
				s.append(array[i]);
			}
			if (s == null) {
				return "";
			}
			s.append("]");
			return s.toString();
		}
	}

	public static final int ORDERED = 1 << 0;
	public static final int UNIQUE = 1 << 1;
	public static final int OCL_ANY = 1 << 2;
	public static final int OCL_VOID = 1 << 3;
	public static final int OCL_INVALID = 1 << 4;			// NB. OCL_INVALID assumed greater than OCL_VOID by isSuper/SubInheritanceOf
	/**
	 * @since 1.1
	 */
	public static final int ABSTRACT = 1 << 5;

	/**
	 * A simple public static method that may be used to force class initialization.
	 */
	public static void initStatics() {}

	protected final int flags;
	//	protected @Nullable Map<String, DomainOperation> operationMap = null;
	//	protected @Nullable Map<String, DomainProperty> propertyMap = null;

	public AbstractInheritance(@NonNull String name, int flags) {
		super(name);
		this.flags = flags;
	}

	@Override
	public @NonNull CompleteInheritance getCommonInheritance(@NonNull CompleteInheritance thatInheritance) {
		if (this == thatInheritance) {
			return this;
		}
		if ((flags & (OCL_ANY|OCL_VOID|OCL_INVALID)) != 0) {
			if ((flags & OCL_ANY) != 0) {
				return this;
			}
			else if ((flags & OCL_INVALID) != 0) {
				return thatInheritance;
			}
			else {
				return thatInheritance.isUndefined() ? this : thatInheritance;
			}
		}
		int thatDepth = thatInheritance.getDepth();
		if ((thatDepth ==  1) && thatInheritance.isUndefined()) {
			return this;
		}
		int thisDepth = getDepth();
		int staticDepth = Math.min(thisDepth, thatDepth);
		for ( ; staticDepth > 0; --staticDepth) {
			int iMax = getIndex(staticDepth+1);
			int jMax = thatInheritance.getIndex(staticDepth+1);
			CompleteInheritance commonInheritance = null;
			int commonInheritances = 0;
			for (int i = getIndex(staticDepth); i < iMax; i++) {
				CompleteInheritance thisBaseInheritance = getFragment(i).getBaseInheritance();
				for (int j = thatInheritance.getIndex(staticDepth); j < jMax; j++) {
					CompleteInheritance thatBaseInheritance = thatInheritance.getFragment(j).getBaseInheritance();
					if (thisBaseInheritance == thatBaseInheritance) {
						commonInheritances++;
						commonInheritance = thisBaseInheritance;
						break;
					}
				}
				if (commonInheritances > 1) { 				// More than one so must go less deep to find uniqueness
					break;
				}
			}
			if (commonInheritances == 1) {					// Must be unique to avoid arbitrary choice for e.g. Sequence{1, 2.0, '3'}->elementType
				assert commonInheritance != null;
				return commonInheritance;
			}
		}
		return getFragment(0).getBaseInheritance();	// Always OclAny at index 0
	}

	@Override
	public @Nullable InheritanceFragment getFragment(@NonNull CompleteInheritance thatInheritance) {
		int staticDepth = thatInheritance.getDepth();
		if (staticDepth <= getDepth()) {
			int iMax = getIndex(staticDepth+1);
			for (int i = getIndex(staticDepth); i < iMax; i++) {
				InheritanceFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == thatInheritance) {
					return fragment;
				}
			}
		}
		return null;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getType() {
		return getPivotClass();
	}

	public final boolean isInvalid() {
		return (flags & OCL_INVALID) != 0;
	}

	@Override
	public final boolean isOclAny() {
		return (flags & OCL_ANY) != 0;
	}

	@Override
	public boolean isSubInheritanceOf(@NonNull CompleteInheritance thatInheritance) {
		int theseFlags = flags & (OCL_VOID|OCL_INVALID);
		int thoseFlags = ((AbstractInheritance)thatInheritance).flags & (OCL_VOID|OCL_INVALID);
		if ((theseFlags == 0) && (thoseFlags == 0)) {
			return getFragment(thatInheritance) != null;
		}
		else {
			return theseFlags >= thoseFlags;
		}
	}

	@Override
	public boolean isSuperInheritanceOf(@NonNull CompleteInheritance thatInheritance) {
		int theseFlags = flags & (OCL_VOID|OCL_INVALID);
		int thoseFlags = ((AbstractInheritance)thatInheritance).flags & (OCL_VOID|OCL_INVALID);
		if ((theseFlags == 0) && (thoseFlags == 0)) {
			return thatInheritance.getFragment(this) != null;
		}
		else {
			return theseFlags <= thoseFlags;
		}
	}

	@Override
	public final boolean isUndefined() {
		return (flags & (OCL_VOID|OCL_INVALID)) != 0;
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		getDepth();
		CompleteInheritance apparentInheritance = apparentOperation.getInheritance(standardLibrary);
		int apparentDepth = ClassUtil.nonNullModel(apparentInheritance).getDepth();
		if (apparentDepth+1 < getIndexes()) {				// null and invalid may fail here
			int iMax = getIndex(apparentDepth+1);
			for (int i = getIndex(apparentDepth); i < iMax; i++) {
				InheritanceFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == apparentInheritance) {
					Operation actualOperation = fragment.getActualOperation(apparentOperation);
					return actualOperation;
				}
			}
		}
		return apparentOperation;	// invoke apparent op for null and invalid
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		getDepth();
		CompleteInheritance apparentInheritance = apparentOperation.getInheritance(standardLibrary);
		int apparentDepth = ClassUtil.nonNullModel(apparentInheritance).getDepth();
		if (apparentDepth+1 < getIndexes()) {				// null and invalid may fail here
			int iMax = getIndex(apparentDepth+1);
			for (int i = getIndex(apparentDepth); i < iMax; i++) {
				InheritanceFragment fragment = getFragment(i);
				if (fragment.getBaseInheritance() == apparentInheritance) {
					return fragment.getImplementation(apparentOperation);
				}
			}
		}
		LibraryFeature implementation = PivotUtilInternal.getImplementation(apparentOperation);	// invoke apparent op for null and invalid
		if (implementation == null) {
			implementation = UnsupportedOperation.INSTANCE;
		}
		return implementation;
	}

	@Override
	public @Nullable Operation lookupLocalOperation(@NonNull StandardLibrary standardLibrary, @NonNull String operationName, CompleteInheritance... argumentTypes) {
		for (Operation localOperation : getPivotClass().getOwnedOperations()) {
			if (localOperation.getName().equals(operationName)) {
				ParametersId firstParametersId = localOperation.getParametersId();
				int iMax = firstParametersId.size();
				if (iMax == argumentTypes.length) {
					int i = 0;
					for (; i < iMax; i++) {
						TypeId firstParameterId = firstParametersId.get(i);
						assert firstParameterId != null;
						@NonNull Type secondParameterType = argumentTypes[i].getPivotClass();
						if (firstParameterId != secondParameterType.getTypeId()) {
							break;
						}
					}
					if (i >= iMax) {
						return localOperation;
					}
				}
			}
		}
		return null;
	}
}
