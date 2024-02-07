/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.basecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.DataTypeCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl#isIsPrimitive <em>Is Primitive</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.DataTypeCSImpl#isIsSerializable <em>Is Serializable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeCSImpl extends ClassCSImpl implements DataTypeCS
{
	/**
	 * The number of structural features of the '<em>Data Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_CS_FEATURE_COUNT = ClassCSImpl.CLASS_CS_FEATURE_COUNT + 2;
	/**
	 * The default value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRIMITIVE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected boolean isPrimitive = IS_PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SERIALIZABLE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsSerializable() <em>Is Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSerializable()
	 * @generated
	 * @ordered
	 */
	protected boolean isSerializable = IS_SERIALIZABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return BaseCSPackage.Literals.DATA_TYPE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPrimitive()
	{
		return isPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPrimitive(boolean newIsPrimitive)
	{
		boolean oldIsPrimitive = isPrimitive;
		isPrimitive = newIsPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, oldIsPrimitive, isPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsSerializable()
	{
		return isSerializable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsSerializable(boolean newIsSerializable)
	{
		boolean oldIsSerializable = isSerializable;
		isSerializable = newIsSerializable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, oldIsSerializable, isSerializable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case 10:
				return isIsPrimitive();
			case 11:
				return isIsSerializable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case 10:
				setIsPrimitive((Boolean)newValue);
				return;
			case 11:
				setIsSerializable((Boolean)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case 10:
				setIsPrimitive(IS_PRIMITIVE_EDEFAULT);
				return;
			case 11:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case 10:
				return isPrimitive != IS_PRIMITIVE_EDEFAULT;
			case 11:
				return isSerializable != IS_SERIALIZABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitDataTypeCS(this);
	}
} //DataTypeCSImpl
