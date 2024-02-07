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
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.OCLValue;
import org.eclipse.ocl.pivot.values.ObjectValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated not
 */
public abstract class NumberValueImpl extends Number implements NumberValue  {
	private static final long serialVersionUID = 1L;

	static class EmptyIterator implements Iterator<Value>
	{
		@Override
		public boolean hasNext() {
			return false;
		}
		@Override
		public Value next() {
			throw new NoSuchElementException();
		}
		@Override
		public void remove() {
			throw new IllegalStateException();
		}
	}

	/**
	 * The number of structural features of the '<em>Number Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NUMBER_VALUE_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected abstract EClass eStaticClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberValueImpl() {
		super();
	}

	@Override
	public @NonNull BagValue asBagValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName());
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
	public Object asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		//
		//	This partial implementation returns null to signal to the derived invoker to make a type-dependent guess
		//
		if ((instanceClass == Double.class) || (instanceClass == double.class)) {
			return doubleValue();
		}
		else if ((instanceClass == Float.class) || (instanceClass == float.class)) {
			return floatValue();
		}
		else if ((instanceClass == Short.class) || (instanceClass == short.class)) {
			return shortValue();
		}
		else if ((instanceClass == Integer.class) || (instanceClass == int.class)) {
			return intValue();
		}
		else if ((instanceClass == Long.class) || (instanceClass == long.class)) {
			return longValue();
		}
		else if (instanceClass == BigDecimal.class) {
			return BigDecimal.valueOf(doubleValue());
		}
		else if (instanceClass == BigInteger.class) {
			return BigInteger.valueOf(longValue());
		}
		else {					// instanceClass is null, leave derived class to make a best guess
			return null;
		}
	}

	@Override
	public Element asElement() {
		return null;
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

	@Override
	public @NonNull MapValue asMapValue() {
		throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.MAP_NAME, getTypeName());
	}

	@Override
	public @NonNull EObject asNavigableObject() {
		Object object = asObject();
		if (object instanceof EObject) {
			return (EObject) object;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "Object", getTypeName());
		}
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

	//	public @NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary) {
	//		return getType(standardLibrary);
	//	}

	public @NonNull String getTypeName() {
		return getTypeId().getDisplayName();
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	@Override
	public boolean isUndefined() {
		return false;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	@Override
	public int oclHashCode() {
		return hashCode();
	}

	@Override
	public void toString(@NonNull StringBuilder s, int sizeLimit) {
		s.append(toString());
	}
} //NumberValueImpl
