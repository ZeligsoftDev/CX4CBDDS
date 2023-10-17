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
package org.eclipse.ocl.pivot.values;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A value support wrapping/boxing a value whose Java implementation does not comply with OCL semantics, primarily
 * that equal values return true from Object.equals(Object) but also for variant metamodel elements.
 * <p>
 * A boxed value is not needed for Boolean and String that are well-behaved.
 * <p>
 * A boxed value is needed for Integer and Double, since in OCL 4 is equal to 4.0 and since multiple implementation
 * classes exist to support growth between unlimited numeric ranges.
 * <p>
 * A boxed value is needed for EnumerationLiterals since distinct Pivot, Ecore, UML variants may exist.
 * <p>
 * A boxed value is needed for types since distinct Pivot, Ecore, UML variants may exist.
 * <p>
 * A boxed value is useful/needed for collections to provide OCL polymorphism.
 * <p>
 * A boxed value is not needed for the large number of ordinary EObjects not in the above list.
 * <p>
 * asYYY returns a non-null YYY if self is convertible to an YYY and is not NullValue/InvalidValue
 * throws an InvalidValueException for a NullValue/InvalidValue. A Value object may be converted
 * if the conversion to YYY is exact and type conformant.
 * <p>
 * isYYY returns an YYY-related value if self is an YYY and is not a NullValue/InvalidValue, returns null otherwise.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getValue()
 * @generated
 */
public interface Value
{
	/**
	 * @generated NOT
	 */
	public static final String INVALID_NAME = "invalid";

	/**
	 * @generated NOT
	 */
	@NonNull BagValue asBagValue();

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue asCollectionValue();

	/**
	 * @generated NOT
	 */
	@NonNull Double asDouble();

	/**
	 * Return the Ecore representation of this value, which should be fully compatible with the Ecore return
	 * from a similarly typed eGet(). The instanceClass may be used to ensure that numeric values use the
	 * appropriate BigInteger/Long/Short/... class. If instanceClass is null for numerics, Double or Long
	 * are used.
	 * <p>
	 * A thrown exception for an invalid OCL value.
	 * <p>
	 * Java-null for a null OCL value
	 * <p>
	 * Objects for other things, List&lt;?&gt; for collections
	 *
	 * @generated NOT
	 */
	Object asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass);

	/**
	 * @generated NOT
	 */
	Element asElement();

	/**
	 * @generated NOT
	 */
	@NonNull Integer asInteger();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue asIntegerValue();

	/**
	 * @generated NOT
	 * @since 1.6
	 */
	default @NonNull IterableValue asIterableValue() {
		if (this instanceof MapValue) {
			return asMapValue();
		}
		else {
			return asCollectionValue();
		}
	}

	/**
	 * @generated NOT
	 */
	@NonNull MapValue asMapValue();

	/**
	 * @generated NOT
	 */
	@NonNull EObject asNavigableObject();

	/**
	 * @generated NOT
	 */
	@NonNull Object asObject();

	/**
	 * @generated NOT
	 */
	@NonNull ObjectValue asObjectValue();

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue asOrderedCollectionValue();

	/**
	 * @generated NOT
	 */
	@NonNull OrderedSetValue asOrderedSetValue();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue asRealValue();

	/**
	 * @generated NOT
	 */
	@NonNull SequenceValue asSequenceValue();

	/**
	 * @generated NOT
	 */
	@NonNull SetValue asSetValue();

	/**
	 * @generated NOT
	 */
	@NonNull TupleValue asTupleValue();

	/**
	 * Return the unboxed representation of this value.
	 * <p>
	 * A thrown exception for an invalid OCL value.
	 * <p>
	 * Java-null for a null OCL value
	 * <p>
	 * Objects for other things, Bag/Set/OrderedSet/List for collections
	 *
	 * @generated NOT
	 */
	Object asUnboxedObject(@NonNull IdResolver idResolver);

	/**
	 * @generated NOT
	 */
	@NonNull UniqueCollectionValue asUniqueCollectionValue();

	/**
	 * @generated NOT
	 */
	@NonNull UnlimitedNaturalValue asUnlimitedNaturalValue();

	/**
	 * @generated NOT
	 *
	 * @since 1.18
	 */
	@NonNull LiteralExp createLiteralExp();

	/**
	 * Return the type of this value determined from its content. In the case of collections
	 * this may differ from the constructed type. The actual type is used for validating
	 * oclAsType conversions.
	 * @throws InvalidValueException
	 * @generated NOT
	 */
	//	@NonNull DomainType getActualType(@NonNull DomainStandardLibrary standardLibrary);

	/**
	 *
	 * Return the type of this value determined from its construction context. In the case of collections
	 * this may differ from the actual type.
	 * @generated NOT
	 */
	//	@NonNull DomainType getType(@NonNull DomainStandardLibrary standardLibrary);
	@NonNull TypeId getTypeId();

	/**
	 * @generated NOT
	 */
	boolean isInvalid();

	/**
	 * @generated NOT
	 */
	boolean isUndefined();

	/**
	 * @generated NOT
	 */
	void toString(@NonNull StringBuilder s, int sizeLimit);
}
