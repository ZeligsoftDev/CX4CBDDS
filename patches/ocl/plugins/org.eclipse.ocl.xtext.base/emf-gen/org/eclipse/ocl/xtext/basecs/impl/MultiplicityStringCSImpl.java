/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Multiplicity CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.MultiplicityStringCSImpl#getStringBounds <em>String Bounds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicityStringCSImpl extends MultiplicityCSImpl implements MultiplicityStringCS
{
	/**
	 * The number of structural features of the '<em>Multiplicity String CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLICITY_STRING_CS_FEATURE_COUNT = MultiplicityCSImpl.MULTIPLICITY_CS_FEATURE_COUNT + 1;

	/**
	 * The default value of the '{@link #getStringBounds() <em>String Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringBounds()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_BOUNDS_EDEFAULT = "1"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getStringBounds() <em>String Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringBounds()
	 * @generated
	 * @ordered
	 */
	protected String stringBounds = STRING_BOUNDS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityStringCSImpl()
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
		return BaseCSPackage.Literals.MULTIPLICITY_STRING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStringBounds()
	{
		return stringBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStringBounds(String newStringBounds)
	{
		String oldStringBounds = stringBounds;
		stringBounds = newStringBounds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldStringBounds, stringBounds));
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
			case 3:
				return getStringBounds();
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
			case 3:
				setStringBounds((String)newValue);
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
			case 3:
				setStringBounds(STRING_BOUNDS_EDEFAULT);
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
			case 3:
				return STRING_BOUNDS_EDEFAULT == null ? stringBounds != null : !STRING_BOUNDS_EDEFAULT.equals(stringBounds);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitMultiplicityStringCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getLower() {
		if ("?".equals(stringBounds)) {
			return 0;
		}
		else if ("+".equals(stringBounds)) {
			return 1;
		}
		else if ("*".equals(stringBounds)) {
			return 0;
		}
		else {
			return 1;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getUpper() {
		if ("?".equals(stringBounds)) {
			return 1;
		}
		else if ("+".equals(stringBounds)) {
			return -1;
		}
		else if ("*".equals(stringBounds)) {
			return -1;
		}
		else {
			return 1;
		}
	}
} //StringMultiplicityCSImpl
