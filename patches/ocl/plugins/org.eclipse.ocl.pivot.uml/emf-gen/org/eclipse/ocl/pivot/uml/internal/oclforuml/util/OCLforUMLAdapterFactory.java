/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Real;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage
 * @generated
 */
public class OCLforUMLAdapterFactory
		extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCLforUMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLforUMLAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = OCLforUMLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLforUMLSwitch<@Nullable Adapter> modelSwitch = new OCLforUMLSwitch<@Nullable Adapter>()
		{
			@Override
			public Adapter caseBoundedInteger(BoundedInteger object)
			{
				return createBoundedIntegerAdapter();
			}
			@Override
			public Adapter caseInteger(org.eclipse.ocl.pivot.uml.internal.oclforuml.Integer object)
			{
				return createIntegerAdapter();
			}
			@Override
			public Adapter caseCollection(Collection object)
			{
				return createCollectionAdapter();
			}
			@Override
			public Adapter caseCollections(Collections object)
			{
				return createCollectionsAdapter();
			}
			@Override
			public Adapter caseFixedPoint(FixedPoint object)
			{
				return createFixedPointAdapter();
			}
			@Override
			public Adapter caseReal(Real object)
			{
				return createRealAdapter();
			}
			@Override
			public Adapter caseFloatingPoint(FloatingPoint object)
			{
				return createFloatingPointAdapter();
			}
			@Override
			public Adapter caseValidation(Validation object)
			{
				return createValidationAdapter();
			}
			@Override
			public Adapter caseValidations(Validations object)
			{
				return createValidationsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger <em>Bounded Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger
	 * @generated
	 */
	public Adapter createBoundedIntegerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Integer
	 * @generated
	 */
	public Adapter createIntegerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection
	 * @generated
	 */
	public Adapter createCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections
	 * @generated
	 */
	public Adapter createCollectionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint <em>Fixed Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint
	 * @generated
	 */
	public Adapter createFixedPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Real <em>Real</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Real
	 * @generated
	 */
	public Adapter createRealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint <em>Floating Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint
	 * @generated
	 */
	public Adapter createFloatingPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation <em>Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation
	 * @generated
	 */
	public Adapter createValidationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations <em>Validations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations
	 * @generated
	 */
	public Adapter createValidationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OCLforUMLAdapterFactory
