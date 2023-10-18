/**
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLFactory;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Real;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLforUMLFactoryImpl
		extends EFactoryImpl
		implements OCLforUMLFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLforUMLFactory init() {
		try
		{
			OCLforUMLFactory theOCLforUMLFactory = (OCLforUMLFactory)EPackage.Registry.INSTANCE.getEFactory(OCLforUMLPackage.eNS_URI);
			if (theOCLforUMLFactory != null)
			{
				return theOCLforUMLFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLforUMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLforUMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case OCLforUMLPackage.BOUNDED_INTEGER: return createBoundedInteger();
			case OCLforUMLPackage.INTEGER: return createInteger();
			case OCLforUMLPackage.COLLECTION: return createCollection();
			case OCLforUMLPackage.COLLECTIONS: return createCollections();
			case OCLforUMLPackage.FIXED_POINT: return createFixedPoint();
			case OCLforUMLPackage.REAL: return createReal();
			case OCLforUMLPackage.FLOATING_POINT: return createFloatingPoint();
			case OCLforUMLPackage.VALIDATION: return createValidation();
			case OCLforUMLPackage.VALIDATIONS: return createValidations();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
			case OCLforUMLPackage.OVERFLOW:
				return createOverflowFromString(eDataType, initialValue);
			case OCLforUMLPackage.ROUNDING:
				return createRoundingFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
			case OCLforUMLPackage.OVERFLOW:
				return convertOverflowToString(eDataType, instanceValue);
			case OCLforUMLPackage.ROUNDING:
				return convertRoundingToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BoundedInteger createBoundedInteger() {
		BoundedIntegerImpl boundedInteger = new BoundedIntegerImpl();
		return boundedInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.uml.internal.oclforuml.Integer createInteger() {
		IntegerImpl integer = new IntegerImpl();
		return integer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection createCollection() {
		CollectionImpl collection = new CollectionImpl();
		return collection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collections createCollections() {
		CollectionsImpl collections = new CollectionsImpl();
		return collections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FixedPoint createFixedPoint() {
		FixedPointImpl fixedPoint = new FixedPointImpl();
		return fixedPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Real createReal() {
		RealImpl real = new RealImpl();
		return real;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FloatingPoint createFloatingPoint() {
		FloatingPointImpl floatingPoint = new FloatingPointImpl();
		return floatingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Validation createValidation() {
		ValidationImpl validation = new ValidationImpl();
		return validation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Validations createValidations() {
		ValidationsImpl validations = new ValidationsImpl();
		return validations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Overflow createOverflowFromString(EDataType eDataType,
			String initialValue) {
		Overflow result = Overflow.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOverflowToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rounding createRoundingFromString(EDataType eDataType,
			String initialValue) {
		Rounding result = Rounding.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoundingToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLforUMLPackage getOCLforUMLPackage() {
		return (OCLforUMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLforUMLPackage getPackage() {
		return OCLforUMLPackage.eINSTANCE;
	}

} //OCLforUMLFactoryImpl
