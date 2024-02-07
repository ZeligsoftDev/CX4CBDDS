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

import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

/**
 * @generated NOT
 */
public class SparseOrderedSetValueImpl extends OrderedSetValueImpl
{
	public static @NonNull OrderedSet<Object> createOrderedSetOfEach(@Nullable Object @NonNull [] boxedValues) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
		for (Object boxedValue : boxedValues) {
			result.add(boxedValue);
		}
		return result;
	}

	public static class Accumulator extends SparseOrderedSetValueImpl implements OrderedSetValue.Accumulator
	{
		public Accumulator(@NonNull CollectionTypeId typeId) {
			super(typeId, new OrderedSetImpl<Object>());
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean add(@Nullable Object value) {
			return ((Collection<Object>)elements).add(value);
		}
	}

	public SparseOrderedSetValueImpl(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> boxedValues) {
		super(typeId, boxedValues);
	}

    @Override
	public @NonNull OrderedSetValue append(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
        	throw new InvalidValueException(PivotMessages.InvalidSource, "append");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.remove(object);  // appended object must be last
        result.add(object);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

    @Override
	public @Nullable Object first() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(PivotMessages.EmptyCollection, TypeId.ORDERED_SET_NAME, "first");
        }
        return elements.iterator().next();
    }

    @Override
	public @NonNull OrderedSetValue flatten() {
    	OrderedSet<Object> flattened = new OrderedSetImpl<Object>();
    	if (flatten(flattened)) {
    		return new SparseOrderedSetValueImpl(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }

//	@Override
//	protected @NonNull OrderedSet<? extends Object> getElements() {
//		return (OrderedSet<? extends Object>) elements;
//	}

	@Override
	public @NonNull OrderedSetValue including(@Nullable Object value) {
		if (value instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "including");
		}
		OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
		result.add(value);
		return new SparseOrderedSetValueImpl(getTypeId(), result);
	}

    @Override
	public @Nullable Object last() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(PivotMessages.EmptyCollection, TypeId.ORDERED_SET_NAME, "last");
        }
        Object result = null;
        for (Object next : elements) {
            result = next;
        }
        return result;
    }

    @Override
	public @NonNull OrderedSetValue prepend(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "prepend");
		}
    	OrderedSet<Object> result = new OrderedSetImpl<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public SequenceValue toSequenceValue() {
		return new SparseSequenceValueImpl(getSequenceTypeId(), SparseSequenceValueImpl.createSequenceOfEach(elements));
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append(TypeId.ORDERED_SET_NAME);
		super.toString(s, lengthLimit);
	}
}
