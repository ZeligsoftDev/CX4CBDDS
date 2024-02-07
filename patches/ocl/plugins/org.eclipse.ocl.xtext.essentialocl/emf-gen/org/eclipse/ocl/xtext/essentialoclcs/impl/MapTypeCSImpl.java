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
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

import org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;

import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl#getOwnedKeyType <em>Owned Key Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.MapTypeCSImpl#getOwnedValueType <em>Owned Value Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapTypeCSImpl extends TypedRefCSImpl implements MapTypeCS
{
	/**
	 * The number of structural features of the '<em>Map Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAP_TYPE_CS_FEATURE_COUNT = TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedKeyType() <em>Owned Key Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedKeyType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedKeyType;

	/**
	 * The cached value of the '{@link #getOwnedValueType() <em>Owned Value Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedValueType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedValueType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapTypeCSImpl()
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
		return EssentialOCLCSPackage.Literals.MAP_TYPE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedKeyType()
	{
		return ownedKeyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedKeyType(TypedRefCS newOwnedKeyType, NotificationChain msgs)
	{
		TypedRefCS oldOwnedKeyType = ownedKeyType;
		ownedKeyType = newOwnedKeyType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, oldOwnedKeyType, newOwnedKeyType);
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
	public void setOwnedKeyType(TypedRefCS newOwnedKeyType)
	{
		if (newOwnedKeyType != ownedKeyType)
		{
			NotificationChain msgs = null;
			if (ownedKeyType != null)
				msgs = ((InternalEObject)ownedKeyType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedKeyType != null)
				msgs = ((InternalEObject)newOwnedKeyType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedKeyType(newOwnedKeyType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, newOwnedKeyType, newOwnedKeyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedValueType()
	{
		return ownedValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedValueType(TypedRefCS newOwnedValueType, NotificationChain msgs)
	{
		TypedRefCS oldOwnedValueType = ownedValueType;
		ownedValueType = newOwnedValueType;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, oldOwnedValueType, newOwnedValueType);
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
	public void setOwnedValueType(TypedRefCS newOwnedValueType)
	{
		if (newOwnedValueType != ownedValueType)
		{
			NotificationChain msgs = null;
			if (ownedValueType != null)
				msgs = ((InternalEObject)ownedValueType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedValueType != null)
				msgs = ((InternalEObject)newOwnedValueType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedValueType(newOwnedValueType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, newOwnedValueType, newOwnedValueType));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return basicSetOwnedKeyType(null, msgs);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return basicSetOwnedValueType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				return getName();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return getOwnedKeyType();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return getOwnedValueType();
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				setName((String)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedKeyType((TypedRefCS)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				setOwnedValueType((TypedRefCS)newValue);
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				setName(NAME_EDEFAULT);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedKeyType((TypedRefCS)null);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				setOwnedValueType((TypedRefCS)null);
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return ownedKeyType != null;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return ownedValueType != null;
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitMapTypeCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //MapTypeCSImpl
