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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionKind;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class CollectionValueImpl extends ValueImpl implements CollectionValue {
	@SuppressWarnings("serial")
	private static final class UnmodifiableEcoreObjects extends EcoreEList.UnmodifiableEList<Object>
	{
		private static final /*@NonNull*/ EStructuralFeature unhangeableStructuralFeature;
		static {
			unhangeableStructuralFeature = EcoreFactory.eINSTANCE.createEAttribute();
			unhangeableStructuralFeature.setName("unchangeable");
			unhangeableStructuralFeature.setEType(EcorePackage.Literals.EOBJECT);
			unhangeableStructuralFeature.setLowerBound(0);
			unhangeableStructuralFeature.setUpperBound(-1);
			unhangeableStructuralFeature.setChangeable(false);
		}
		private UnmodifiableEcoreObjects(int size, Object[] data) {
			super(null, unhangeableStructuralFeature, size, data);
		}

		@Override
		protected boolean useEquals() {
			return false;
		}
	}

	/**
	 * Optimized iterator over an Array for use in OCL contents where the array is known to be stable
	 * and any call to next() is guarded by hasNext().
	 */
	private static class ArrayIterator<T> implements Iterator<T>
	{
		protected final T @NonNull [] elements;
		protected final int size;
		private int index;

		/**
		 * Returns new array iterator over the given object array
		 */
		public ArrayIterator(T @NonNull [] elements, int size) {
			this.elements = elements;
			index = 0;
			this.size = size;
		}

		/**
		 * Returns true if this iterator contains more elements.
		 */
		@Override
		public boolean hasNext() {
			return index < size;
		}

		/**
		 * Returns the next element of this iterator.
		 */
		@Override
		public T next() {
			return elements[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Optimized iterator over a List for use in OCL contents where the list is known to be stable
	 * and any call to next() is guarded by hasNext().
	 */
	private static class ListIterator<T> implements Iterator<T>
	{
		protected final @NonNull List<T> elements;
		protected final int size;
		private int index;

		/**
		 * Returns new array iterator over the given object array
		 */
		public ListIterator(@NonNull List<T> elements) {
			this.elements = elements;
			index = 0;
			this.size = elements.size();
		}

		/**
		 * Returns true if this iterator contains more elements.
		 */
		@Override
		public boolean hasNext() {
			return index < size;
		}

		/**
		 * Returns the next element of this iterator.
		 */
		@Override
		public T next() {
			return elements.get(index++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Optimized iterator over a List for use in OCL contents where the list is known to be stable
	 * and any call to next() is guarded by hasNext().
	 */
	private static class NullIterator implements Iterator<@Nullable Object>
	{
		/**
		 * Returns new array iterator over the given object array
		 */
		public NullIterator() {}

		/**
		 * Returns true if this iterator contains more elements.
		 */
		@Override
		public boolean hasNext() {
			return false;
		}

		/**
		 * Returns the next element of this iterator.
		 */
		@Override
		public Object next() {
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static @NonNull NullIterator EMPTY_ITERATOR = new NullIterator();

	/**
	 * A simple public static method that may be used to force class initialization.
	 */
	public static void initStatics() {}

	/**
	 * The number of structural features of the '<em>Collection Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_VALUE_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.COLLECTION_VALUE;
	}

	protected final @NonNull CollectionTypeId typeId;
	protected final @NonNull Collection<? extends Object> elements;		// Using Value instances where necessary to ensure correct equals semantics
	private int hashCode = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CollectionValueImpl() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected CollectionValueImpl(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> values) {
		this.typeId = typeId;
		this.elements = values;
		assert checkElementsAreValues(values);
	}

	protected boolean checkElementsAreUnique(Iterable<? extends Object> elements) {
		Set<Object> knownElements = new HashSet<Object>();
		for (Object element : elements) {
			assert knownElements.add(element);
		}
		return true;
	}

	private boolean checkElementsAreValues(Iterable<? extends Object> elements) {
		for (Object element : elements) {
			assert ValueUtil.isBoxed(element);
			//			if (element instanceof Collection<?>) {
			//				assert isNormalized((Iterable<?>)element);
			//				assert checkElementsAreValues((Iterable<?>)element);
			//			}
		}
		return true;
	}

	/**
	 * Add a value to a working collection, returning true if the working
	 * collection is changed by the addition.
	 * <p>
	 * The default implementation is appropriate for non-unique collections and
	 * must be overridden to support OCL rather than Java uniqueness semantics.
	 */
	//	protected boolean add(C values, Value value) {
	//		return values.add(value);
	//	}

	@Override
	public @NonNull BagValue asBagValue() {
		Iterable<? extends Object> iterable = elements;
		return new BagValueImpl(getBagTypeId(), new BagImpl<Object>(iterable));
	}

	@Override
	public @NonNull Collection<? extends Object> asCollection() {
		return elements;
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		return this;
	}

	@Override
	public @NonNull List<Object> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		Object[] unboxedValues = new Object[elements.size()];
		int i= 0;
		for (Object element : elements) {
			if (element instanceof Value)
				unboxedValues[i++] = ((Value)element).asEcoreObject(idResolver, instanceClass);
			else if (element instanceof EnumerationLiteralId) {
				unboxedValues[i++] = idResolver.unboxedValueOf(element);
			}
			else {
				unboxedValues[i++] = element;
			}
		}
		return new UnmodifiableEcoreObjects(i, unboxedValues);
	}

	@Override
	@SuppressWarnings("unchecked")			// FIXME check element types
	public @NonNull <T> List<T> asEcoreObjects(@NonNull IdResolver idResolver, @Nullable Class<T> instanceClass) {
		return (List<T>) asEcoreObject(idResolver, instanceClass);
	}

	/**
	 * @since 1.6
	 */
	@Override
	public @NonNull IterableValue asIterableValue() {
		return this;
	}

	public @NonNull List<? extends Object> asList() {
		return new ArrayList<Object>(elements);
	}

	@Override
	public @NonNull Object asObject() {
		return elements;
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		OrderedSet<Object> uniqueElements = new OrderedSetImpl<Object>();
		for (Object element : elements) {
			uniqueElements.add(element);
		}
		return new SparseOrderedSetValueImpl(getOrderedSetTypeId(), uniqueElements);
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		return new SparseSequenceValueImpl(getSequenceTypeId(), new ArrayList<Object>(elements));
	}

	@Override
	public @NonNull SetValue asSetValue() {
		Set<Object> uniqueElements = new HashSet<Object>();
		for (Object element : elements) {
			uniqueElements.add(element);
		}
		return new SetValueImpl(getSetTypeId(), uniqueElements);
	}

	/**
	 * Implementation of the OCL
	 * <tt>Collection::count(object : T) : Integer</tt>
	 * operation.
	 *
	 * @param value an object
	 * @return the number of occurrences of the object in the collection
	 * @throws InvalidValueException
	 */
	@Override
	public @NonNull IntegerValue count(@Nullable Object value) {
		long count = 0;
		if (value == null) {
			for (Object next : elements) {
				if (next == null) {
					count++;
				}
			}
		}
		else {
			for (Object next : elements) {
				if (value.equals(next)) {
					count++;
				}
			}
		}
		return ValueUtil.integerValueOf(count);
	}

	@Override
	public @NonNull LiteralExp createLiteralExp() {
		CollectionLiteralExp literalExp = PivotFactory.eINSTANCE.createCollectionLiteralExp();
		literalExp.setKind(CollectionKind.getByName(getKind()));
		List<CollectionLiteralPart> ownedParts = literalExp.getOwnedParts();
		for (Object element : getElements()) {
			CollectionItem part = PivotFactory.eINSTANCE.createCollectionItem();
			part.setOwnedItem(ValueUtil.createLiteralExp(element));
			ownedParts.add(part);
		}
		return literalExp;
	}

	/**
	 * Implementation of the OCL
	 * <tt>Collection::excludes(object : T) : Boolean</tt>
	 * operation.
	 *
	 * @param value an object
	 * @return whether the collection does not include the object
	 */
	@Override
	public @NonNull Boolean excludes(@Nullable Object value) {
		if (value == null) {
			for (Object next : elements) {
				if (next == null) {
					return false;
				}
			}
		}
		else {
			for (Object next : elements) {
				if (value.equals(next)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Implementation of the OCL
	 * <tt>Collection::excludesAll(c : Collection(T)) : Boolean</tt>
	 * operation.
	 *
	 * @param c another collection
	 * @return whether the source collection does not contain any of the
	 *     elements of the other
	 */
	@Override
	public @NonNull Boolean excludesAll(@NonNull CollectionValue c) {
		for (Object e1 : elements) {
			if (e1 == null) {
				for (Object e2 : c.iterable()) {
					if (e2 == null) {
						return false;
					}
				}
			}
			else {
				for (Object e2 : c.iterable()) {
					if (e1.equals(e2)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Returns true if any element flattened.
	 * @throws InvalidValueException
	 */
	@Override
	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
		boolean flattened = false;
		for (Object element : elements) {
			CollectionValue collectionElement = ValueUtil.isCollectionValue(element);
			if (collectionElement != null) {
				flattened = true;
				collectionElement.flatten(flattenedElements);
			}
			else {
				flattenedElements.add(element);
			}
		}
		return flattened;
	}

	/*	@Override
	public @NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary) {
		DomainType actualType2 = actualType;
		if (actualType2 == null) {
			DomainType elementType = null;
			for (Object value : elements) {
				assert value != null;
				DomainType valueType;
				if (value instanceof Value) {
					valueType = ((Value)value).getActualType(standardLibrary);
				}
				else {
					valueType = valueFactory.typeOf(value);
				}
				if (elementType == null) {
					elementType = valueType;
				}
				else {
					elementType = elementType.getCommonType(standardLibrary, valueType);
				}
			}
			if (elementType == null) {
				actualType2 = actualType = type;
			}
			else {
				DomainCollectionType containerType = ((DomainCollectionType)type).getContainerType();
				assert containerType != null;
				actualType2 = actualType = standardLibrary.getCollectionType(containerType, elementType, null, null);
			}
		}
		return actualType2;
	} */

	public @NonNull CollectionTypeId getBagTypeId() {
		return TypeId.BAG.getSpecializedId(typeId);
	}

	public @NonNull TypeId getElementTypeId() {
		return getTypeId().getElementTypeId();
	}

	@Override
	public @NonNull Collection<? extends Object> getElements() {
		return elements;
	}

	public @NonNull Collection<? extends Object> getObject() {
		return elements;
	}

	public @NonNull CollectionTypeId getOrderedSetTypeId() {
		return TypeId.ORDERED_SET.getSpecializedId(typeId);
	}

	public @NonNull CollectionTypeId getSequenceTypeId() {
		return TypeId.SEQUENCE.getSpecializedId(typeId);
	}

	public @NonNull CollectionTypeId getSetTypeId() {
		return TypeId.SET.getSpecializedId(typeId);
	}

	@Override
	public @NonNull CollectionTypeId getTypeId() {
		return typeId;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public final int hashCode() {		// Need hash to be independent of the Set/List/OrderedSet/Bag actually in use as elements
		if (hashCode == 0) {
			synchronized (this) {
				if (hashCode == 0) {
					hashCode = computeCollectionHashCode(isOrdered(), isUnique(), elements);
				}
			}
		}
		return hashCode;
	}

	@Override
	public @NonNull Boolean includes(@Nullable Object value) {
		return elements.contains(value) != false;			// FIXME redundant test to suppress warning
	}

	/**
	 * Implementation of the OCL
	 * <tt>Collection::includesAll(c : Collection(T)) : Boolean</tt>
	 * operation.
	 *
	 * @param c another collection
	 * @return whether the source collection includes all of the elements
	 *     of the other
	 */
	@Override
	public @NonNull Boolean includesAll(@NonNull CollectionValue c) {
		for (Object e1 : c.iterable()) {
			boolean gotIt = false;
			if (e1 == null) {
				for (Object e2 : elements) {
					if (e2 == null) {
						gotIt = true;
						break;
					}
				}
			}
			else {
				for (Object e2 : elements) {
					if (e1.equals(e2)) {
						gotIt = true;
						break;
					}
				}
			}
			if (!gotIt) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int intSize() {
		return elements.size();
	}

	@Override
	public @NonNull CollectionValue intersection(@NonNull CollectionValue that) {
		assert !this.isUndefined() && !that.isUndefined();
		Collection<? extends Object> theseElements = this.asCollection();
		Collection<? extends Object> thoseElements = that.asCollection();
		int thisSize = theseElements.size();
		int thatSize = thoseElements.size();
		if (this instanceof UniqueCollectionValue || that instanceof UniqueCollectionValue) {
			@NonNull CollectionTypeId typeId = getSetTypeId();
			if ((thisSize == 0) || (thatSize == 0)) {
				return new SetValueImpl(typeId, ValueUtil.EMPTY_SET);
			}
			Set<Object> results;
			// loop over the smaller collection and add only elements
			// that are in the larger collection
			if (thisSize <= thatSize) {
				results = new HashSet<Object>(theseElements);
				results.retainAll(thoseElements);
			}
			else {
				results = new HashSet<Object>(thoseElements);
				results.retainAll(theseElements);
			}
			return new SetValueImpl(typeId, results.size() > 0 ? results : ValueUtil.EMPTY_SET);
		}
		else {
			@NonNull CollectionTypeId typeId = getBagTypeId();
			if ((thisSize == 0) || (thatSize == 0)) {
				return new BagValueImpl(typeId, ValueUtil.EMPTY_BAG);
			}
			Bag<Object> results = new BagImpl<Object>();
			// loop over the smaller collection and add only elements
			// that are in the larger collection
			Set<Object> minElements = new HashSet<Object>(thisSize < thatSize ? theseElements : thoseElements);
			for (Object e : minElements) {
				IntegerValue leftCount = this.count(e);
				IntegerValue rightCount = that.count(e);
				for (int i = Math.min(leftCount.asInteger(), rightCount.asInteger()); i > 0; i--) {
					results.add(e);
				}
			}
			return new BagValueImpl(typeId, results.size() > 0 ? results : ValueUtil.EMPTY_BAG);
		}
	}

	//	@Override
	//	public @NonNull CollectionValue isCollectionValue() {
	//		return this;
	//	}

	@Override
	public @NonNull Boolean isEmpty() {
		return intSize() == 0;
	}

	@Override
	public @NonNull Iterable<? extends Object> iterable() {
		return elements;
	}

	@Override
	public @NonNull Iterator<@Nullable Object> iterator() {
		if (elements instanceof BasicEList) {
			@SuppressWarnings("unchecked")
			BasicEList<Object> castElements = (BasicEList<Object>)elements;
			@SuppressWarnings("null")@Nullable Object[] data = castElements.data();
			return data != null ? new ArrayIterator<@Nullable Object>(data, elements.size()) : EMPTY_ITERATOR;
		}
		if (elements instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<@Nullable Object> castElements = (List<@Nullable Object>)elements;
			return new ListIterator<@Nullable Object>(castElements);
		}
		@SuppressWarnings("unchecked") @NonNull Iterator<@Nullable Object> result = (@NonNull Iterator<@Nullable Object>)elements.iterator();
		return result;
	}

	@Override
	public @NonNull Boolean notEmpty() {
		return intSize() != 0;
	}

	@Override
	public @NonNull Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {
		Set<TupleValue> result = new HashSet<TupleValue>();
		for (Object next1 : iterable()) {
			for (Object next2 : c.iterable()) {
				result.add(new TupleValueImpl(tupleTypeId, next1, next2));
			}
		}
		return result;
	}

	@Override
	public @NonNull IntegerValue size() {
		return ValueUtil.integerValueOf(intSize());
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toString(s, 100);
		return s.toString();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int lengthLimit) {
		s.append("{");
		boolean isFirst = true;
		for (Object element : this.iterable()) {
			if (!isFirst) {
				s.append(",");
			}
			if ((lengthLimit < 0) || (s.length() < lengthLimit)) {
				ValueUtil.toString(element, s, lengthLimit);
			}
			else {
				s.append("...");
				break;
			}
			isFirst = false;
		}
		s.append("}");
	}

	@Override
	public @NonNull CollectionValue union(@NonNull CollectionValue that) {
		assert !this.isUndefined() && !that.isUndefined();
		Collection<? extends Object> theseElements = this.asCollection();
		Collection<? extends Object> thoseElements = that.asCollection();
		if (this instanceof UniqueCollectionValue && that instanceof UniqueCollectionValue) {
			if (theseElements.isEmpty()) {
				return that.asSetValue();
			}
			else if (thoseElements.isEmpty()) {
				return this.asSetValue();
			}
			else {
				Set<Object> result = new HashSet<Object>(theseElements);
				result.addAll(thoseElements);
				return new SetValueImpl(getSetTypeId(), result);
			}
		}
		else {
			if (theseElements.isEmpty()) {
				return that.asBagValue();
			}
			else if (thoseElements.isEmpty()) {
				return this.asBagValue();
			}
			else {
				Iterable<? extends Object> iterable = theseElements;
				Bag<Object> result = new BagImpl<Object>(iterable);
				result.addAll(thoseElements);
				return new BagValueImpl(getBagTypeId(), result);
			}
		}
	}
} //CollectionValueImpl
