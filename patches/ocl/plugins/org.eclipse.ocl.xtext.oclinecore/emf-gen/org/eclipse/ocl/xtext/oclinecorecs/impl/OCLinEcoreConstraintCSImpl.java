/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecorecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.ConstraintCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage;
import org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS;
import org.eclipse.ocl.xtext.oclinecorecs.util.OCLinEcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclinecorecs.impl.OCLinEcoreConstraintCSImpl#isIsCallable <em>Is Callable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OCLinEcoreConstraintCSImpl extends ConstraintCSImpl implements OCLinEcoreConstraintCS {
	/**
	 * The number of structural features of the '<em>OC Lin Ecore Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OC_LIN_ECORE_CONSTRAINT_CS_FEATURE_COUNT = ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 1;
	/**
	 * The default value of the '{@link #isIsCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCallable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CALLABLE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsCallable() <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCallable()
	 * @generated
	 * @ordered
	 */
	protected boolean isCallable = IS_CALLABLE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLinEcoreConstraintCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCallable()
	{
		return isCallable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCallable(boolean newIsCallable)
	{
		boolean oldIsCallable = isCallable;
		isCallable = newIsCallable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0, oldIsCallable, isCallable));
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
			case ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0:
				return isIsCallable();
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
			case ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0:
				setIsCallable((Boolean)newValue);
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
			case ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0:
				setIsCallable(IS_CALLABLE_EDEFAULT);
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
			case ConstraintCSImpl.CONSTRAINT_CS_FEATURE_COUNT + 0:
				return isCallable != IS_CALLABLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof OCLinEcoreCSVisitor) {
			return (R) ((OCLinEcoreCSVisitor<?>)visitor).visitOCLinEcoreConstraintCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //ConstraintCSImpl
