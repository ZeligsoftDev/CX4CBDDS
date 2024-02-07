/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.annotations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.ocl.pivot.annotations.Ecore_OCL_EStructuralFeature;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore OCL EStructural Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.annotations.impl.Ecore_OCL_EStructuralFeatureImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Ecore_OCL_EStructuralFeatureImpl extends MinimalEObjectImpl.Container implements Ecore_OCL_EStructuralFeature {
	/**
	 * The number of structural features of the '<em>Ecore OCL EStructural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ECORE_OCL_ESTRUCTURAL_FEATURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Ecore OCL EStructural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ECORE_OCL_ESTRUCTURAL_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The default value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected static final String DERIVATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDerivation() <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivation()
	 * @generated
	 * @ordered
	 */
	protected String derivation = DERIVATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ecore_OCL_EStructuralFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotAnnotationsPackage.Literals.ECORE_OCL_ESTRUCTURAL_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDerivation() {
		return derivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerivation(String newDerivation) {
		String oldDerivation = derivation;
		derivation = newDerivation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 0, oldDerivation, derivation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 0:
				return getDerivation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case 0:
				setDerivation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case 0:
				setDerivation(DERIVATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case 0:
				return DERIVATION_EDEFAULT == null ? derivation != null : !DERIVATION_EDEFAULT.equals(derivation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (derivation: ");
		result.append(derivation);
		result.append(')');
		return result.toString();
	}
} //Ecore_OCL_EStructuralFeatureImpl
