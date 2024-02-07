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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Real;
import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.RealImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.RealImpl#getEpsilon <em>Epsilon</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.RealImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.RealImpl#getMinimum <em>Minimum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealImpl
		extends EObjectImpl
		implements Real {

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The default value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected static final double EPSILON_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected double epsilon = EPSILON_EDEFAULT;

	/**
	 * This is true if the Epsilon attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean epsilonESet;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected double maximum = MAXIMUM_EDEFAULT;

	/**
	 * This is true if the Maximum attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maximumESet;

	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected double minimum = MINIMUM_EDEFAULT;

	/**
	 * This is true if the Minimum attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minimumESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLforUMLPackage.Literals.REAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy())
		{
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLforUMLPackage.REAL__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.REAL__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEpsilon() {
		return epsilon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEpsilon(double newEpsilon) {
		double oldEpsilon = epsilon;
		epsilon = newEpsilon;
		boolean oldEpsilonESet = epsilonESet;
		epsilonESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.REAL__EPSILON, oldEpsilon, epsilon, !oldEpsilonESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEpsilon() {
		double oldEpsilon = epsilon;
		boolean oldEpsilonESet = epsilonESet;
		epsilon = EPSILON_EDEFAULT;
		epsilonESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OCLforUMLPackage.REAL__EPSILON, oldEpsilon, EPSILON_EDEFAULT, oldEpsilonESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEpsilon() {
		return epsilonESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaximum(double newMaximum) {
		double oldMaximum = maximum;
		maximum = newMaximum;
		boolean oldMaximumESet = maximumESet;
		maximumESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.REAL__MAXIMUM, oldMaximum, maximum, !oldMaximumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMaximum() {
		double oldMaximum = maximum;
		boolean oldMaximumESet = maximumESet;
		maximum = MAXIMUM_EDEFAULT;
		maximumESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OCLforUMLPackage.REAL__MAXIMUM, oldMaximum, MAXIMUM_EDEFAULT, oldMaximumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMaximum() {
		return maximumESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimum(double newMinimum) {
		double oldMinimum = minimum;
		minimum = newMinimum;
		boolean oldMinimumESet = minimumESet;
		minimumESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.REAL__MINIMUM, oldMinimum, minimum, !oldMinimumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMinimum() {
		double oldMinimum = minimum;
		boolean oldMinimumESet = minimumESet;
		minimum = MINIMUM_EDEFAULT;
		minimumESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OCLforUMLPackage.REAL__MINIMUM, oldMinimum, MINIMUM_EDEFAULT, oldMinimumESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMinimum() {
		return minimumESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case OCLforUMLPackage.REAL__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case OCLforUMLPackage.REAL__EPSILON:
				return getEpsilon();
			case OCLforUMLPackage.REAL__MAXIMUM:
				return getMaximum();
			case OCLforUMLPackage.REAL__MINIMUM:
				return getMinimum();
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
		switch (featureID)
		{
			case OCLforUMLPackage.REAL__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
				return;
			case OCLforUMLPackage.REAL__EPSILON:
				setEpsilon((Double)newValue);
				return;
			case OCLforUMLPackage.REAL__MAXIMUM:
				setMaximum((Double)newValue);
				return;
			case OCLforUMLPackage.REAL__MINIMUM:
				setMinimum((Double)newValue);
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
		switch (featureID)
		{
			case OCLforUMLPackage.REAL__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
				return;
			case OCLforUMLPackage.REAL__EPSILON:
				unsetEpsilon();
				return;
			case OCLforUMLPackage.REAL__MAXIMUM:
				unsetMaximum();
				return;
			case OCLforUMLPackage.REAL__MINIMUM:
				unsetMinimum();
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
		switch (featureID)
		{
			case OCLforUMLPackage.REAL__BASE_DATA_TYPE:
				return base_DataType != null;
			case OCLforUMLPackage.REAL__EPSILON:
				return isSetEpsilon();
			case OCLforUMLPackage.REAL__MAXIMUM:
				return isSetMaximum();
			case OCLforUMLPackage.REAL__MINIMUM:
				return isSetMinimum();
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
		result.append(" (epsilon: "); //$NON-NLS-1$
		if (epsilonESet) result.append(epsilon); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", maximum: "); //$NON-NLS-1$
		if (maximumESet) result.append(maximum); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", minimum: "); //$NON-NLS-1$
		if (minimumESet) result.append(minimum); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //RealImpl
