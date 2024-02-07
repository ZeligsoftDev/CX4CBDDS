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
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.VariableCSImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableCSImpl
		extends NamedElementCSImpl
		implements VariableCS {

	/**
	 * The number of structural features of the '<em>Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_CS_FEATURE_COUNT = NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The cached value of the '{@link #getOwnedInitExpression() <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInitExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedInitExpression;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.VARIABLE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedType() {
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType,
			NotificationChain msgs) {
		TypedRefCS oldOwnedType = ownedType;
		ownedType = newOwnedType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1, oldOwnedType, newOwnedType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedType(TypedRefCS newOwnedType) {
		if (newOwnedType != ownedType)
		{
			NotificationChain msgs = null;
			if (ownedType != null)
				msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1, newOwnedType, newOwnedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedInitExpression() {
		return ownedInitExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInitExpression(ExpCS newOwnedInitExpression, NotificationChain msgs)
	{
		ExpCS oldOwnedInitExpression = ownedInitExpression;
		ownedInitExpression = newOwnedInitExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0, oldOwnedInitExpression, newOwnedInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedInitExpression(ExpCS newOwnedInitExpression) {
		if (newOwnedInitExpression != ownedInitExpression)
		{
			NotificationChain msgs = null;
			if (ownedInitExpression != null)
				msgs = ((InternalEObject)ownedInitExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0), null, msgs);
			if (newOwnedInitExpression != null)
				msgs = ((InternalEObject)newOwnedInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0), null, msgs);
			msgs = basicSetOwnedInitExpression(newOwnedInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0, newOwnedInitExpression, newOwnedInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				return basicSetOwnedInitExpression(null, msgs);
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				return basicSetOwnedType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				return getOwnedInitExpression();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwnedType();
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				setOwnedInitExpression((ExpCS)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwnedType((TypedRefCS)newValue);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				setOwnedInitExpression((ExpCS)null);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwnedType((TypedRefCS)null);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				return ownedInitExpression != null;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				return ownedType != null;
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
		if (visitor instanceof EssentialOCLCSVisitor) {
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitVariableCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //VariableCSImpl
