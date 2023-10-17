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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Set Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class OrderedSetValueImpl extends CollectionValueImpl implements OrderedSetValue {
	/**
	 * The number of structural features of the '<em>Ordered Set Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_SET_VALUE_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.ORDERED_SET_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected OrderedSetValueImpl() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OrderedSetValueImpl(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> elements) {
		super(typeId, elements);
		assert checkElementsAreUnique(this.elements);
	}

    @Override
	public @NonNull OrderedSetValue appendAll(@NonNull OrderedCollectionValue objects) {
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        Collection<? extends Object> thoseElements = objects.getElements();
		result.removeAll(thoseElements);  // appended objects must be last
        result.addAll(thoseElements);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

    @Override
	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		return this;
	}

	@Override
	public @NonNull OrderedSetValueImpl asOrderedSetValue() {
		return this;
	}

	@Override
	public @NonNull LinkedHashSet<Object> asUnboxedObject(@NonNull IdResolver idResolver) {
		LinkedHashSet<Object> unboxedValues = new LinkedHashSet<Object>();
		for (Object boxedValue : elements) {
			unboxedValues.add(idResolver.unboxedValueOf(boxedValue));
		}
		return unboxedValues;
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}

    @Override
	public @Nullable Object at(int index) {
        index = index - 1;
        if (index < 0 || index >= elements.size()) {
        	throw new InvalidValueException(PivotMessages.IndexOutOfRange, index + 1, size());
		}
        int curr = 0;
        for (Iterator<? extends Object> it = iterator(); it.hasNext();) {
        	Object object = it.next();
            if (curr++ == index) {
                return object;
            }
        }
        throw new InvalidValueException("Null collection content");
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedSetValue) || (obj instanceof NullValue)) {
			return false;
		}
		// This is probably a bug fix on LinkedHashSet that should consider ordering for equals
		Iterator<? extends Object> theseElements = iterator();
		Iterator<? extends Object> thoseElements = ((OrderedSetValue)obj).iterator();
		while (theseElements.hasNext() && thoseElements.hasNext()) {
			Object thisElement = theseElements.next();
			Object thatElement = thoseElements.next();
			if (thisElement == null) {
				if (thatElement != null) {
					return false;
				}
			}
			else {
				if (!thisElement.equals(thatElement)) {
					return false;
				}
			}
		}
		return !theseElements.hasNext() && !thoseElements.hasNext();
	}

	@Override
	public @NonNull OrderedSetValue excluding(@Nullable Object value) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
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
			return new SparseOrderedSetValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

	@Override
	public @NonNull OrderedSetValue excludingAll(@NonNull CollectionValue values) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>();
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
			return new SparseOrderedSetValueImpl(getTypeId(), result);
		}
		else {
			return this;
		}
	}

//    @Override
//	public @NonNull CollectionTypeId getCollectionTypeId() {
//		return TypeId.ORDERED_SET;
//	}

	@Override
	public @NonNull String getKind() {
	    return TypeId.ORDERED_SET_NAME;
	}

	@Override
	public @NonNull OrderedSetValue includingAll(@NonNull CollectionValue values) {
		OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
		for (Object value : values) {
			result.add(value);
		}
		return new SparseOrderedSetValueImpl(getTypeId(), result);
	}

    @Override
	public @NonNull IntegerValue indexOf(@Nullable Object object) {
        int index = 1;
        if (object == null) {
            for (Object next : elements) {
                if (next == null) {
                    return ValueUtil.integerValueOf(index);
                }
                index++;
            }
        }
        else {
            for (Object next : elements) {
                if (object.equals(next)) {
                    return ValueUtil.integerValueOf(index);
                }
                index++;
            }
        }
        throw new InvalidValueException(PivotMessages.MissingValue, "indexOf");
    }

    @Override
	public @NonNull OrderedSetValue insertAt(int index, @Nullable Object object) {
		if (object instanceof InvalidValueException) {
			throw new InvalidValueException(PivotMessages.InvalidSource, "insertAt");
		}
        index = index - 1;
        boolean isContained = elements.contains(object);
        int effectiveSize = elements.size() - (isContained ? 1 : 0);
        if ((index < 0) || (effectiveSize < index)) {
        	throw new InvalidValueException(PivotMessages.IndexOutOfRange, index + 1, size());
        }

        OrderedSet<Object> result = new OrderedSetImpl<Object>();
        int curr = 0;
        if (object == null) {
			for (Iterator<? extends Object> it = iterator(); it.hasNext();) {
				if (curr == index) {
					result.add(object);
				}
				Object next = it.next();
				if (next != null) {
					result.add(next);
					curr++;
				}
			}
		}
        else {
			for (Iterator<? extends Object> it = iterator(); it.hasNext();) {
				if (curr == index) {
					result.add(object);
				}
				Object next = it.next();
				if (!object.equals(next)) {
					result.add(next);
					curr++;
				}
			}
		}

        if (index == effectiveSize) {
        	// the loop finished before we could add the object
        	result.add(object);
        }
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public boolean isOrdered() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return true;
	}

    @Override
	public @NonNull OrderedSetValue minus(@NonNull UniqueCollectionValue set) {
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        result.removeAll(set.asCollection());
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

    @Override
	public @NonNull OrderedSetValue prependAll(@NonNull OrderedCollectionValue objects) {
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(objects.getElements());
        result.addAll(elements);
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

	@Override
	public @NonNull OrderedSetValue reverse() {
		List<? extends Object> elements = asList();
		Collections.reverse(elements);
        return new SparseOrderedSetValueImpl(getTypeId(), elements);
    }

    @Override
	public @NonNull OrderedSetValue sort(@NonNull Comparator<Object> comparator) {
    	List<Object> values = new ArrayList<Object>(elements);
    	Collections.sort(values, comparator);
    	return new SparseOrderedSetValueImpl(getTypeId(), values);
    }

    @Override
	public @NonNull OrderedSetValue subOrderedSet(int lower, int upper) {
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

        OrderedSet<Object> result = new OrderedSetImpl<Object>();
        int curr = 0;
        for (Iterator<? extends Object> it = elements.iterator(); it.hasNext();) {
        	Object object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

//	public @NonNull SequenceValue subSequence(int lower, int upper) {
//		return subOrderedSet(lower, upper);
//	}

    @Override
	public @NonNull OrderedSetValue symmetricDifference(@NonNull UniqueCollectionValue set) {
    	OrderedSet<Object> result = new OrderedSetImpl<Object>(elements);
        for (Object e : set.iterable()) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }
        return new SparseOrderedSetValueImpl(getTypeId(), result);
    }

//	public SequenceValue toSequenceValue() {
//		return this;
//	}
} //OrderedSetValueImpl
