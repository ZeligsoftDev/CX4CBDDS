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
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.MultiplicityCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl#getOwnedCollectionMultiplicity <em>Owned Collection Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CollectionTypeCSImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTypeCSImpl
extends TypedRefCSImpl
implements CollectionTypeCS {

	/**
	 * The number of structural features of the '<em>Collection Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TYPE_CS_FEATURE_COUNT = TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3;

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
	 * The cached value of the '{@link #getOwnedCollectionMultiplicity() <em>Owned Collection Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCollectionMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityCS ownedCollectionMultiplicity;

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
	protected CollectionTypeCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
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
	public MultiplicityCS getOwnedCollectionMultiplicity()
	{
		return ownedCollectionMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCollectionMultiplicity(MultiplicityCS newOwnedCollectionMultiplicity, NotificationChain msgs)
	{
		MultiplicityCS oldOwnedCollectionMultiplicity = ownedCollectionMultiplicity;
		ownedCollectionMultiplicity = newOwnedCollectionMultiplicity;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, oldOwnedCollectionMultiplicity, newOwnedCollectionMultiplicity);
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
	public void setOwnedCollectionMultiplicity(MultiplicityCS newOwnedCollectionMultiplicity)
	{
		if (newOwnedCollectionMultiplicity != ownedCollectionMultiplicity)
		{
			NotificationChain msgs = null;
			if (ownedCollectionMultiplicity != null)
				msgs = ((InternalEObject)ownedCollectionMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedCollectionMultiplicity != null)
				msgs = ((InternalEObject)newOwnedCollectionMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedCollectionMultiplicity(newOwnedCollectionMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, newOwnedCollectionMultiplicity, newOwnedCollectionMultiplicity));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, oldOwnedType, newOwnedType);
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
				msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, newOwnedType, newOwnedType));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return basicSetOwnedCollectionMultiplicity(null, msgs);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				return getName();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return getOwnedCollectionMultiplicity();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				setName((String)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedCollectionMultiplicity((MultiplicityCS)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				setName(NAME_EDEFAULT);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedCollectionMultiplicity((MultiplicityCS)null);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 0:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return ownedCollectionMultiplicity != null;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitCollectionTypeCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //CollectionTypeCSImpl
