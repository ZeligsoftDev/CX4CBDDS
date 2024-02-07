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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OclVoidTypeId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.ComparableValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.ObjectValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.UnlimitedValue;
import org.eclipse.ocl.pivot.values.Value;

/**
 * @generated NOT
 */
public abstract class UndefinedValueImpl extends EvaluationException implements NullValue
{
	private static final long serialVersionUID = 1L;

	private static class Iterator implements java.util.Iterator<@Nullable Object>
	{
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			return null;
		}

		@Override
		public void remove() {
		}
	}

	public UndefinedValueImpl(String message) {
		super(message);
	}

	public UndefinedValueImpl(String messageTemplate, Object... bindings) {
		super(messageTemplate, bindings);
	}

	public UndefinedValueImpl(@NonNull Throwable e, String message) {
		super(e, message);
	}

	public UndefinedValueImpl(@NonNull Throwable e, String messageTemplate, Object... bindings) {
		super(e, messageTemplate, bindings);
	}

	@Override
	public @NonNull NullValue abs() {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue addInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue addReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull OrderedCollectionValue append(@Nullable Object object) {
		return toInvalidValue();
	}

	@Override
	public @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects) {
		return toInvalidValue();
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName());
	}

	@Override
	public @NonNull Collection<Object> asCollection() {
		throw new InvalidValueException("Collection value required");
	}

	@Override
	public @NonNull CollectionValue asCollectionValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName());
	}

	@Override
	public @NonNull Double asDouble() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, "Double", getTypeName());
	}

	@Override
	public @NonNull <T> List<T> asEcoreObjects(@NonNull IdResolver idResolver, @Nullable Class<T> elementClass) {
		throw new InvalidValueException(this, "asEcoreObjects");
	}

	@Override
	public @NonNull Integer asInteger() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	@Override
	public @NonNull IntegerValue asIntegerValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName());
	}

	/**
	 * @since 1.6
	 */
	@Override
	public @NonNull IterableValue asIterableValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ITERABLE_NAME, getTypeName());
	}

	public @NonNull List<Object> asList() {
		throw new InvalidValueException("List value required");
	}

	@Override
	public @NonNull MapValue asMapValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.MAP_NAME, getTypeName());
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, "Object", getTypeName());
	}

	@Override
	public @NonNull Number asNumber() {
		throw new InvalidValueException("undefined value has no Number value");
	}

	@Override
	public @NonNull Object asObject() {
		return toInvalidValue();
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, "Object", getTypeName());
	}

	@Override
	public @NonNull OrderedCollectionValue asOrderedCollectionValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ORDERED_COLLECTION_NAME, getTypeName());
	}

	@Override
	public @NonNull OrderedSetValue asOrderedSetValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName());
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName());
	}

	@Override
	public @NonNull SequenceValue asSequenceValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName());
	}

	@Override
	public @NonNull SetValue asSetValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName());
	}

	@Override
	public @NonNull TupleValue asTupleValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.TUPLE_NAME, getTypeName());
	}

	@Override
	public @NonNull UniqueCollectionValue asUniqueCollectionValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, "Unique Collection", getTypeName());
	}

	@Override
	public @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName());
	}

	@Override
	public @Nullable Value at(int index) {
		return toInvalidValue();
	}

	@Override
	public @NonNull BigDecimal bigDecimalValue() {
		throw new InvalidValueException("undefined value has no BigDecimal value");
	}

	@Override
	public @NonNull BigInteger bigIntegerValue() {
		throw new InvalidValueException("undefined value has no BigInteger value");
	}

	@Override
	public @NonNull RealValue commutatedAdd(@NonNull RealValue left) {
		return toInvalidValue();
	}

	@Override
	public @NonNull IntegerValue commutatedDiv(@NonNull IntegerValue left) {
		return toInvalidValue();
	}

	@Override
	public @NonNull RealValue commutatedDivide(@NonNull RealValue left) {
		return toInvalidValue();
	}

	@Override
	public @NonNull IntegerValue commutatedMod(@NonNull IntegerValue left) {
		return toInvalidValue();
	}

	@Override
	public @NonNull RealValue commutatedMultiply(@NonNull RealValue left) {
		return toInvalidValue();
	}

	@Override
	public @NonNull RealValue commutatedSubtract(@NonNull RealValue left) {
		return toInvalidValue();
	}

	@Override
	public int commutatedCompareTo(@NonNull ComparableValue<?> left) {
		return ValueUtil.throwUnsupportedCompareTo(left, this);
	}

	@Override
	public int commutatedCompareToInteger(@NonNull IntegerValue left) {
		return ValueUtil.throwUnsupportedCompareTo(left, this);
	}

	@Override
	public int commutatedCompareToReal(@NonNull RealValue left) {
		return ValueUtil.throwUnsupportedCompareTo(left, this);
	}

	@Override
	public int compareTo(@Nullable NumberValue right) {
		return ValueUtil.throwUnsupportedCompareTo(this, right);
	}

	@Override
	public @NonNull IntegerValue count(@Nullable Object value) {
		return toInvalidValue();
	}

	public @NonNull CollectionValue createNew() {
		return toInvalidValue();
	}

	public @NonNull NullValue div(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue divInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue divUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull RealValue divideInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue divideReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public double doubleValue() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	@Override
	public @NonNull Boolean excludes(@Nullable Object value) {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}


	@Override
	public @NonNull Boolean excludesAll(@NonNull CollectionValue c) {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	@Override
	public @NonNull CollectionValue excluding(@Nullable Object value) {
		return toInvalidValue();
	}

	@Override
	public @NonNull CollectionValue excludingAll(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	@Override
	public @Nullable Value first() {
		return toInvalidValue();
	}

	@Override
	public @NonNull CollectionValue flatten() {
		return toInvalidValue();
	}

	@Override
	public boolean flatten(@NonNull Collection<Object> flattenedElements) {
		return false;
	}

	@Override
	public @NonNull NullValue floor() {
		return toInvalidValue();
	}

	public Type getElement() {
		return null;
	}

	@Override
	public @NonNull List<? extends Object> getElements() {
		throw new InvalidValueException("bad getElements()");
	}

	public @NonNull Type getInstanceType() {
		throw new InvalidValueException("undefined value has no instance type");
	}

	@Override
	public String getKind() {
		return TypeId.COLLECTION_NAME;		// FIXME UOE ??
	}

	@Override
	public Object getObject() {
		return null;
	}

	@Override
	public abstract @NonNull OclVoidTypeId getTypeId();

	public @NonNull String getTypeName() {
		return getTypeId().getDisplayName();
	}

	@Override
	public @NonNull Value getValue(@NonNull TuplePartId partId) {
		return toInvalidValue();
	}

	@Override
	public @NonNull Object getValue(int index) {
		return toInvalidValue();
	}

	@Override
	public @NonNull Boolean includes(@Nullable Object value) {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	@Override
	public @NonNull Boolean includesAll(@NonNull CollectionValue c) {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	@Override
	public @NonNull CollectionValue including(@Nullable Object value) {
		return toInvalidValue();
	}

	@Override
	public @NonNull CollectionValue includingAll(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	@Override
	public @NonNull IntegerValue indexOf(@Nullable Object object) {
		return toInvalidValue();
	}

	@Override
	public @NonNull SequenceValue insertAt(int index, @Nullable Object object) {
		return toInvalidValue();
	}

	@Override
	public int intSize() {
		return 0;
	}

	@Override
	public @NonNull CollectionValue intersection(@NonNull CollectionValue c) {
		return toInvalidValue();
	}

	@Override
	public @NonNull Boolean isEmpty() {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	public boolean isFalse() {
		return false;
	}

	@Override
	public @Nullable IntegerValue isIntegerValue() {
		return null;
	}

	@Override
	public boolean isOrdered() {
		return false;
	}

	public boolean isTrue() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	@Override
	public boolean isUnlimited() {
		return false;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return false;
	}

	@Override
	public @Nullable UnlimitedNaturalValue isUnlimitedNaturalValue() {
		return null;
	}

	@Override
	public @NonNull Iterable<? extends Object> iterable() {
		return Collections.<Object>emptyList();
	}

	@Override
	public @NonNull Iterator iterator() {
		return new Iterator();
	}

	@Override
	public @Nullable Value last() {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue max(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue max(@NonNull UnlimitedNaturalValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue maxInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue maxReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue maxUnlimited(@NonNull UnlimitedNaturalValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue min(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue min(@NonNull UnlimitedNaturalValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue minInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue minReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue minUnlimited(@NonNull UnlimitedNaturalValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue minus(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue modInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue modUnlimited(@NonNull UnlimitedValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue multiplyInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue multiplyReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue negate() {
		return toInvalidValue();
	}

	@Override
	public @NonNull Boolean notEmpty() {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	@Override
	public @NonNull OrderedCollectionValue prepend(@Nullable Object object) {
		return toInvalidValue();
	}

	@Override
	public @NonNull OrderedCollectionValue prependAll(@NonNull OrderedCollectionValue objects) {
		return toInvalidValue();
	}

	@Override
	public @Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId) {
		return null;
	}

	@Override
	public @NonNull OrderedCollectionValue reverse() {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue round() {
		return toInvalidValue();
	}

	@Override
	public int signum() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	@Override
	public @NonNull IntegerValue size() {
		return toInvalidValue();
	}

	@Override
	public @NonNull SequenceValue sort(@NonNull Comparator<Object> comparator) {
		return toInvalidValue();
	}

	public @NonNull String stringValue() {
		throw new InvalidValueException("undefined value has no String value");
	}

	@Override
	public @NonNull NullValue subOrderedSet(int lower, int upper) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue subSequence(int lower, int upper) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue subtractInteger(@NonNull IntegerValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue subtractReal(@NonNull RealValue right) {
		return toInvalidValue();
	}

	@Override
	public @NonNull NullValue symmetricDifference(@NonNull UniqueCollectionValue set) {
		return toInvalidValue();
	}

	protected @NonNull NullValue toInvalidValue() {
		throw new InvalidValueException(PivotMessages.ConvertibleValueRequired, "Invalid");
	}

	@Override
	public @NonNull SequenceValue toSequenceValue() {
		return this;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}

	@Override
	public @NonNull CollectionValue union(@NonNull CollectionValue c) {
		return this;
	}
}
