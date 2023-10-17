/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerRange;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.Value;

/**
 * @generated NOT
 */
public class RangeSequenceValueImpl extends SequenceValueImpl
{
	public RangeSequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		super(typeId, range);
	}

	@Override
	public @NonNull SequenceValue append(@Nullable Object value) {
		IntegerRange theElements = getElements();
		IntegerValue nextValue = theElements.getLast().addInteger(ONE_VALUE);
		if (nextValue.equals(value)) {
			IntegerRange range = createRange(theElements.getFirst(), nextValue);
			return new RangeSequenceValueImpl(getTypeId(), range);
		}
		else {
			List<Object> elements = createElements();
			elements.add(value);
			return new SparseSequenceValueImpl(getTypeId(), elements);
		}
	}

	@Override
	public @NonNull IntegerValue count(@Nullable Object value) {
		IntegerValue integerValue = ValueUtil.isIntegerValue(value);
		if (integerValue != null) {
			if (elements.contains(integerValue)) {
				return ONE_VALUE;
			}
		}
		return ZERO_VALUE;
	}

	protected @NonNull List<Object> createElements() {
		List<Object> elements = new ArrayList<Object>(intSize());
		for (Object value : iterable()) {
			elements.add(value);
		}
		return elements;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RangeSequenceValueImpl) {
			RangeSequenceValueImpl that = (RangeSequenceValueImpl)obj;
			return this.elements.equals(that.elements);
		}
		else {
			return super.equals(obj);
		}
	}

	@Override
	public @Nullable Value first() {
		return getElements().getFirst();
	}

	@Override
	public @NonNull SequenceValue flatten() {
		return this;
	}

	@Override
	public @NonNull IntegerRange getElements() {
		return (IntegerRange) elements;
	}

	@Override
	public @NonNull SequenceValue including(@Nullable Object value) {
		return append(value);
	}

	@Override
	public @Nullable Value last() {
		return getElements().getLast();
	}

	@Override
	public @NonNull SequenceValue prepend(@Nullable Object value) {
		IntegerRange theElements = getElements();
		IntegerValue previousValue = theElements.getFirst().subtractInteger(ONE_VALUE);
		if (previousValue.equals(value)) {
			IntegerRange range = createRange(previousValue, theElements.getLast());
			return new RangeSequenceValueImpl(getTypeId(), range);
		}
		else {
			List<Object> elements = createElements();
			elements.add(0, value);
			return new SparseSequenceValueImpl(getTypeId(), elements);
		}
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("Sequence{");
		IntegerRange theElements = getElements();
		s.append(theElements.getFirst());
		s.append("..");
		s.append(theElements.getLast());
		s.append("}");
		s.toString();
	}
}