/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionTypeParameters;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;

public class CollectionTypeParametersImpl<T extends Type> implements CollectionTypeParameters<T>
{
	protected class Iterator implements java.util.Iterator<Object>
	{
		private int position = 0;

		@Override
		public boolean hasNext() {
			return position < 3;
		}

		@Override
		public Object next() {
			switch (position++) {
				case 0: return elementType;
				case 1: return lower;
				case 2: return upper;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private final int hashCode;
	private final @NonNull T elementType;
	private final boolean isNullFree;
	private final @NonNull IntegerValue lower;
	private final @NonNull UnlimitedNaturalValue upper;

	public CollectionTypeParametersImpl(@NonNull T elementType, boolean isNullFree, @Nullable IntegerValue lower, @Nullable UnlimitedNaturalValue upper) {
		this.elementType = elementType;
		this.isNullFree = isNullFree;
		this.lower = lower != null ? lower : ValueUtil.ZERO_VALUE;
		this.upper = upper != null ? upper : ValueUtil.UNLIMITED_VALUE;
		int hash = elementType.getTypeId().hashCode() + (isNullFree ? 9876 : 0);
		hash = 111 * hash + this.lower.hashCode();
		hash = 111 * hash + this.upper.hashCode();
		hashCode = hash;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CollectionTypeParametersImpl<?>)) {
			return false;
		}
		CollectionTypeParametersImpl<?> that = (CollectionTypeParametersImpl<?>)o;
		if (this.hashCode != that.hashCode){
			return false;
		}
		if (this.isNullFree != that.isNullFree) {
			return false;
		}
		if (this.elementType.getTypeId() != that.elementType.getTypeId()) {
			return false;
		}
		if (!this.lower.equals(that.lower)) {
			return false;
		}
		if (!this.upper.equals(that.upper)) {
			return false;
		}
		return true;
	}

	@Override
	public @NonNull T getElementType() {
		return elementType;
	}

	@Override
	public @NonNull IntegerValue getLower() {
		return lower;
	}

	@Override
	public @NonNull UnlimitedNaturalValue getUpper() {
		return upper;
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public boolean isNullFree() {
		return isNullFree;
	}

	@Override
	public @NonNull Iterator iterator() {
		return new Iterator();
	}

	public int parametersSize() {
		return 1;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		s.append(elementType);
		s.append(',');
		s.append(isNullFree);
		s.append(',');
		s.append(lower);
		s.append(',');
		s.append(upper);
		s.append(')');
		return s.toString();
	}
}