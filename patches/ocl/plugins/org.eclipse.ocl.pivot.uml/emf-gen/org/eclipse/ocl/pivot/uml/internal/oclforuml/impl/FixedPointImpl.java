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
import org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FixedPointImpl#isBitTrue <em>Bit True</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FixedPointImpl#getFractionalBits <em>Fractional Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FixedPointImpl#getIntegerBits <em>Integer Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FixedPointImpl#getOverflow <em>Overflow</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.FixedPointImpl#getRounding <em>Rounding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedPointImpl
		extends RealImpl
		implements FixedPoint {

	/**
	 * The default value of the '{@link #isBitTrue() <em>Bit True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBitTrue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIT_TRUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBitTrue() <em>Bit True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBitTrue()
	 * @generated
	 * @ordered
	 */
	protected boolean bitTrue = BIT_TRUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFractionalBits() <em>Fractional Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionalBits()
	 * @generated
	 * @ordered
	 */
	protected static final int FRACTIONAL_BITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFractionalBits() <em>Fractional Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionalBits()
	 * @generated
	 * @ordered
	 */
	protected int fractionalBits = FRACTIONAL_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegerBits() <em>Integer Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerBits()
	 * @generated
	 * @ordered
	 */
	protected static final int INTEGER_BITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntegerBits() <em>Integer Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerBits()
	 * @generated
	 * @ordered
	 */
	protected int integerBits = INTEGER_BITS_EDEFAULT;

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
	protected FixedPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLforUMLPackage.Literals.FIXED_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBitTrue() {
		return bitTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBitTrue(boolean newBitTrue) {
		boolean oldBitTrue = bitTrue;
		bitTrue = newBitTrue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FIXED_POINT__BIT_TRUE, oldBitTrue, bitTrue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFractionalBits() {
		return fractionalBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFractionalBits(int newFractionalBits) {
		int oldFractionalBits = fractionalBits;
		fractionalBits = newFractionalBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FIXED_POINT__FRACTIONAL_BITS, oldFractionalBits, fractionalBits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIntegerBits() {
		return integerBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntegerBits(int newIntegerBits) {
		int oldIntegerBits = integerBits;
		integerBits = newIntegerBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FIXED_POINT__INTEGER_BITS, oldIntegerBits, integerBits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FIXED_POINT__OVERFLOW, oldOverflow, overflow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.FIXED_POINT__ROUNDING, oldRounding, rounding));
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
			case OCLforUMLPackage.FIXED_POINT__BIT_TRUE:
				return isBitTrue();
			case OCLforUMLPackage.FIXED_POINT__FRACTIONAL_BITS:
				return getFractionalBits();
			case OCLforUMLPackage.FIXED_POINT__INTEGER_BITS:
				return getIntegerBits();
			case OCLforUMLPackage.FIXED_POINT__OVERFLOW:
				return getOverflow();
			case OCLforUMLPackage.FIXED_POINT__ROUNDING:
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
			case OCLforUMLPackage.FIXED_POINT__BIT_TRUE:
				setBitTrue((Boolean)newValue);
				return;
			case OCLforUMLPackage.FIXED_POINT__FRACTIONAL_BITS:
				setFractionalBits((Integer)newValue);
				return;
			case OCLforUMLPackage.FIXED_POINT__INTEGER_BITS:
				setIntegerBits((Integer)newValue);
				return;
			case OCLforUMLPackage.FIXED_POINT__OVERFLOW:
				setOverflow((Overflow)newValue);
				return;
			case OCLforUMLPackage.FIXED_POINT__ROUNDING:
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
			case OCLforUMLPackage.FIXED_POINT__BIT_TRUE:
				setBitTrue(BIT_TRUE_EDEFAULT);
				return;
			case OCLforUMLPackage.FIXED_POINT__FRACTIONAL_BITS:
				setFractionalBits(FRACTIONAL_BITS_EDEFAULT);
				return;
			case OCLforUMLPackage.FIXED_POINT__INTEGER_BITS:
				setIntegerBits(INTEGER_BITS_EDEFAULT);
				return;
			case OCLforUMLPackage.FIXED_POINT__OVERFLOW:
				setOverflow(OVERFLOW_EDEFAULT);
				return;
			case OCLforUMLPackage.FIXED_POINT__ROUNDING:
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
			case OCLforUMLPackage.FIXED_POINT__BIT_TRUE:
				return bitTrue != BIT_TRUE_EDEFAULT;
			case OCLforUMLPackage.FIXED_POINT__FRACTIONAL_BITS:
				return fractionalBits != FRACTIONAL_BITS_EDEFAULT;
			case OCLforUMLPackage.FIXED_POINT__INTEGER_BITS:
				return integerBits != INTEGER_BITS_EDEFAULT;
			case OCLforUMLPackage.FIXED_POINT__OVERFLOW:
				return overflow != OVERFLOW_EDEFAULT;
			case OCLforUMLPackage.FIXED_POINT__ROUNDING:
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
		result.append(" (bitTrue: "); //$NON-NLS-1$
		result.append(bitTrue);
		result.append(", fractionalBits: "); //$NON-NLS-1$
		result.append(fractionalBits);
		result.append(", integerBits: "); //$NON-NLS-1$
		result.append(integerBits);
		result.append(", overflow: "); //$NON-NLS-1$
		result.append(overflow);
		result.append(", rounding: "); //$NON-NLS-1$
		result.append(rounding);
		result.append(')');
		return result.toString();
	}

} //FixedPointImpl
