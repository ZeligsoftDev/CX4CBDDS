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

import java.lang.Integer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Floating Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FloatingPointImpl#getExponentBits <em>Exponent Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FloatingPointImpl#getMantissaBits <em>Mantissa Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FloatingPointImpl#getOverflow <em>Overflow</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FloatingPointImpl#getRounding <em>Rounding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FloatingPointImpl
		extends RealImpl
		implements FloatingPoint {

	/**
	 * The default value of the '{@link #getExponentBits() <em>Exponent Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExponentBits()
	 * @generated
	 * @ordered
	 */
	protected static final int EXPONENT_BITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExponentBits() <em>Exponent Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExponentBits()
	 * @generated
	 * @ordered
	 */
	protected int exponentBits = EXPONENT_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMantissaBits() <em>Mantissa Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMantissaBits()
	 * @generated
	 * @ordered
	 */
	protected static final int MANTISSA_BITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMantissaBits() <em>Mantissa Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMantissaBits()
	 * @generated
	 * @ordered
	 */
	protected int mantissaBits = MANTISSA_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverflow() <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverflow()
	 * @generated
	 * @ordered
	 */
	protected static final Overflow OVERFLOW_EDEFAULT = Overflow.INVALID;

	/**
	 * The cached value of the '{@link #getOverflow() <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverflow()
	 * @generated
	 * @ordered
	 */
	protected Overflow overflow = OVERFLOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getRounding() <em>Rounding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRounding()
	 * @generated
	 * @ordered
	 */
	protected static final Rounding ROUNDING_EDEFAULT = Rounding.NEAREST;

	/**
	 * The cached value of the '{@link #getRounding() <em>Rounding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRounding()
	 * @generated
	 * @ordered
	 */
	protected Rounding rounding = ROUNDING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FloatingPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLforUMLPackage.Literals.FLOATING_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Overflow getOverflow() {
		return overflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverflow(Overflow newOverflow) {
		Overflow oldOverflow = overflow;
		overflow = newOverflow == null ? OVERFLOW_EDEFAULT : newOverflow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FLOATING_POINT__OVERFLOW, oldOverflow, overflow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rounding getRounding() {
		return rounding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRounding(Rounding newRounding) {
		Rounding oldRounding = rounding;
		rounding = newRounding == null ? ROUNDING_EDEFAULT : newRounding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FLOATING_POINT__ROUNDING, oldRounding, rounding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getExponentBits() {
		return exponentBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExponentBits(int newExponentBits) {
		int oldExponentBits = exponentBits;
		exponentBits = newExponentBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FLOATING_POINT__EXPONENT_BITS, oldExponentBits, exponentBits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMantissaBits() {
		return mantissaBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMantissaBits(int newMantissaBits) {
		int oldMantissaBits = mantissaBits;
		mantissaBits = newMantissaBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FLOATING_POINT__MANTISSA_BITS, oldMantissaBits, mantissaBits));
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
			case OCLforUMLPackage.FLOATING_POINT__EXPONENT_BITS:
				return getExponentBits();
			case OCLforUMLPackage.FLOATING_POINT__MANTISSA_BITS:
				return getMantissaBits();
			case OCLforUMLPackage.FLOATING_POINT__OVERFLOW:
				return getOverflow();
			case OCLforUMLPackage.FLOATING_POINT__ROUNDING:
				return getRounding();
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
			case OCLforUMLPackage.FLOATING_POINT__EXPONENT_BITS:
				setExponentBits((Integer)newValue);
				return;
			case OCLforUMLPackage.FLOATING_POINT__MANTISSA_BITS:
				setMantissaBits((Integer)newValue);
				return;
			case OCLforUMLPackage.FLOATING_POINT__OVERFLOW:
				setOverflow((Overflow)newValue);
				return;
			case OCLforUMLPackage.FLOATING_POINT__ROUNDING:
				setRounding((Rounding)newValue);
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
			case OCLforUMLPackage.FLOATING_POINT__EXPONENT_BITS:
				setExponentBits(EXPONENT_BITS_EDEFAULT);
				return;
			case OCLforUMLPackage.FLOATING_POINT__MANTISSA_BITS:
				setMantissaBits(MANTISSA_BITS_EDEFAULT);
				return;
			case OCLforUMLPackage.FLOATING_POINT__OVERFLOW:
				setOverflow(OVERFLOW_EDEFAULT);
				return;
			case OCLforUMLPackage.FLOATING_POINT__ROUNDING:
				setRounding(ROUNDING_EDEFAULT);
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
			case OCLforUMLPackage.FLOATING_POINT__EXPONENT_BITS:
				return exponentBits != EXPONENT_BITS_EDEFAULT;
			case OCLforUMLPackage.FLOATING_POINT__MANTISSA_BITS:
				return mantissaBits != MANTISSA_BITS_EDEFAULT;
			case OCLforUMLPackage.FLOATING_POINT__OVERFLOW:
				return overflow != OVERFLOW_EDEFAULT;
			case OCLforUMLPackage.FLOATING_POINT__ROUNDING:
				return rounding != ROUNDING_EDEFAULT;
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
		result.append(" (exponentBits: "); //$NON-NLS-1$
		result.append(exponentBits);
		result.append(", mantissaBits: "); //$NON-NLS-1$
		result.append(mantissaBits);
		result.append(", overflow: "); //$NON-NLS-1$
		result.append(overflow);
		result.append(", rounding: "); //$NON-NLS-1$
		result.append(rounding);
		result.append(')');
		return result.toString();
	}

} //FloatingPointImpl
