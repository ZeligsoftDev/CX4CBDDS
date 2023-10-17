/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class SequenceValueImpl extends CollectionValueImpl implements SequenceValue {
	/**
	 * The number of structural features of the '<em>Sequence Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_VALUE_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.SEQUENCE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SequenceValueImpl() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SequenceValueImpl(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> values) {
		super(typeId, values);
	}

    @Override
	public @NonNull OrderedCollectionValue append(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "append");
		}
    	List<Object> result = new ArrayList<Object>(elements);
        result.add(object);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

    @Override
	public @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects) {
    	List<Object> result = new ArrayList<Object>(elements);
        result.addAll(objects.getElements());
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

	@Override
	public @NonNull List<? extends Object> asList() {
		return getElements();
	}

    @Override
	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		return this;
	}

    @Override
	public @NonNull SequenceValue asSequenceValue() {
        return this;
    }

	@Override
	public @NonNull List<Object> asUnboxedObject(@NonNull IdResolver idResolver) {
		List<Object> unboxedValues = new ArrayList<Object>();
		for (Object boxedValue : elements) {
			unboxedValues.add(idResolver.unboxedValueOf(boxedValue));
		}
		return unboxedValues;
	}

    @Override
	public @Nullable Object at(int index) {
        index = index - 1;
        if (index < 0 || elements.size() <= index) {
        	throw new InvalidValueException(PivotMessages.IndexOutOfRange, index + 1, size());
		}
        return getElements().get(index);
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SequenceValue) || (obj instanceof OrderedSetValue)) {
			return false;
		}
		Iterator<? extends Object> theseElements = iterator();
		Iterator<? extends Object> thoseElements = ((SequenceValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Object thisValue = theseElements.next();
			Object thatValue = thoseElements.next();
			if (!ClassUtil.safeEquals(thisValue, thatValue)) {
				return false;
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	@Override
	public @NonNull SequenceValue excluding(@Nullable Object value) {
		List<Object> result = new ArrayList<Object>();
		if (value == null) {
			for (Object element : elements) {
				if (element != null) {
					result.add(element);
				}
			}
		}
		else {
			for (Object element : elements) {
				if (!value.equals(element)) {
					result.add(element);
				}
			}
		}
		if (result.size() < elements.size()) {
			return new SparseSequenceValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

	@Override
	public @NonNull SequenceValue excludingAll(@NonNull CollectionValue values) {
		List<Object> result = new ArrayList<Object>();
		for (Object element : elements) {
			boolean reject = false;
			if (element == null) {
				for (Object value : values) {
					if (value == null) {
						reject = true;
						break;
					}
				}
			}
			else {
				for (Object value : values) {
					if ((value != null) && value.equals(element)) {
						reject = true;
						break;
					}
				}
			}
			if (!reject) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SparseSequenceValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

    @Override
	public @Nullable Object first() {
        if (elements.size() <= 0) {
        	throw new InvalidValueException(PivotMessages.EmptyCollection, TypeId.SEQUENCE_NAME, "first");
        }
        return getElements().get(0);
    }

    @Override
	public @NonNull SequenceValue flatten() {
    	List<Object> flattened = new ArrayList<Object>();
    	if (flatten(flattened)) {
    		return new SparseSequenceValueImpl(getTypeId(), flattened);
    	}
    	else {
    		return this;
    	}
    }

//    @Override
//	public @NonNull CollectionTypeId getCollectionTypeId() {
//		return TypeId.SEQUENCE;
//	}

	@Override
	public @NonNull List<? extends Object> getElements() {
		return (List<? extends Object>) elements;
	}

	@Override
	public @NonNull String getKind() {
	    return TypeId.SEQUENCE_NAME;
	}

	@Override
	public @NonNull SequenceValue including(@Nullable Object value) {
		if (value instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "including");
		}
		List<Object> result = new ArrayList<Object>(elements);
		result.add(value);
		return new SparseSequenceValueImpl(getTypeId(), result);
	}

	@Override
	public @NonNull SequenceValue includingAll(@NonNull CollectionValue values) {
		List<Object> result = new ArrayList<Object>(elements);
		for (Object value : values) {
			result.add(value);
		}
		return new SparseSequenceValueImpl(getTypeId(), result);
	}

    @Override
	public @NonNull IntegerValue indexOf(@Nullable Object object) {
        int index = getElements().indexOf(object);
        if (index < 0) {
        	throw new InvalidValueException(PivotMessages.MissingValue, "indexOf");
        }
    	return ValueUtil.integerValueOf(index+1);
    }

    @Override
	public @NonNull SequenceValue insertAt(int index, @Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "insertAt");
		}
        index = index - 1;
        if (index < 0 || index > elements.size()) {
        	throw new InvalidValueException(PivotMessages.IndexOutOfRange, index + 1, size());
        }
		List<Object> result = new ArrayList<Object>(elements);
		result.add(index, object);
		return new SparseSequenceValueImpl(getTypeId(), result);
    }

	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

    @Override
	public @Nullable Object last() {
        int size = elements.size();
		if (size <= 0) {
			throw new InvalidValueException(PivotMessages.EmptyCollection, TypeId.SEQUENCE_NAME, "last");
        }
        return getElements().get(size-1);
    }

    @Override
	public @NonNull SequenceValue prepend(@Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "prepend");
		}
    	List<Object> result = new ArrayList<Object>();
        result.add(object);
        result.addAll(elements);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

    @Override
	public @NonNull SequenceValue prependAll(@NonNull OrderedCollectionValue objects) {
    	List<Object> result = new ArrayList<Object>(objects.getElements());
        result.addAll(elements);
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

	@Override
	public @NonNull SequenceValue reverse() {
		List<Object> elements = new ArrayList<Object>(this.elements);
		Collections.reverse(elements);
        return new SparseSequenceValueImpl(getTypeId(), elements);
    }

    @Override
	public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return new SparseSequenceValueImpl(getTypeId(), values);
    }

    /**
     * Implementation of the OCL
     * <tt>Sequence::subSequence(lower : Integer, upper : Integer) : Sequence(T)</tt>
     * operation.
     *
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the source collection with the object inserted at the index
     *
     * @throws IndexOutOfBoundsException if an index is out of bounds
     * @throws IllegalArgumentException if the lower bound is greater than the upper
     */
    @Override
	public @NonNull SequenceValue subSequence(int lower, int upper) {
        lower = lower - 1;
        upper = upper - 1;

        if (lower < 0) {
			throw new InvalidValueException(new IndexOutOfBoundsException("lower: " + (lower + 1))); //$NON-NLS-1$
        } else if (upper >= elements.size()) {
			throw new InvalidValueException(new IndexOutOfBoundsException(
				"upper: " + (upper + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size()));
        } else if (upper < lower) {
			throw new InvalidValueException(new IllegalArgumentException(
				"lower: " + (lower + 1) + ", upper: " //$NON-NLS-1$ //$NON-NLS-2$
					+ (upper + 1)));
        }

		List<Object> result = new ArrayList<Object>();
        int curr = 0;
        for (Object object : iterable()) {
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return new SparseSequenceValueImpl(getTypeId(), result);
    }

	@Override
	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append(TypeId.SEQUENCE_NAME);
		super.toString(s, lengthLimit);
	}
} //SequenceValueImpl
