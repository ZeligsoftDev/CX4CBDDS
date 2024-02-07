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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.StructuralFeatureCS;
import org.eclipse.ocl.xtext.basecs.StructuredClassCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#isIsInterface <em>Is Interface</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#getOwnedMetaclass <em>Owned Metaclass</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl#getOwnedSuperTypes <em>Owned Super Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuredClassCSImpl extends ClassCSImpl implements StructuredClassCS {
	/**
	 * The number of structural features of the '<em>Structured Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURED_CLASS_CS_FEATURE_COUNT = ClassCSImpl.CLASS_CS_FEATURE_COUNT + 6;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInterface() <em>Is Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean isInterface = IS_INTERFACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedMetaclass() <em>Owned Metaclass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMetaclass()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedMetaclass;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCS> ownedOperations;

	/**
	 * The cached value of the '{@link #getOwnedProperties() <em>Owned Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> ownedProperties;

	/**
	 * The cached value of the '{@link #getOwnedSuperTypes() <em>Owned Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> ownedSuperTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.STRUCTURED_CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAbstract()
	{
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract)
	{
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInterface()
	{
		return isInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInterface(boolean newIsInterface)
	{
		boolean oldIsInterface = isInterface;
		isInterface = newIsInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, oldIsInterface, isInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedRefCS> getOwnedSuperTypes() {
		if (ownedSuperTypes == null)
		{
			ownedSuperTypes = new EObjectContainmentEList<TypedRefCS>(TypedRefCS.class, this, 15);
		}
		return ownedSuperTypes;
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
	public EList<OperationCS> getOwnedOperations() {
		if (ownedOperations == null)
		{
			ownedOperations = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, 13, 15);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StructuralFeatureCS> getOwnedProperties() {
		if (ownedProperties == null)
		{
			ownedProperties = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, 14, 11);
		}
		return ownedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedMetaclass()
	{
		return ownedMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMetaclass(TypedRefCS newOwnedMetaclass, NotificationChain msgs)
	{
		TypedRefCS oldOwnedMetaclass = ownedMetaclass;
		ownedMetaclass = newOwnedMetaclass;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 12, oldOwnedMetaclass, newOwnedMetaclass);
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
	public void setOwnedMetaclass(TypedRefCS newOwnedMetaclass)
	{
		if (newOwnedMetaclass != ownedMetaclass)
		{
			NotificationChain msgs = null;
			if (ownedMetaclass != null)
				msgs = ((InternalEObject)ownedMetaclass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			if (newOwnedMetaclass != null)
				msgs = ((InternalEObject)newOwnedMetaclass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (12), null, msgs);
			msgs = basicSetOwnedMetaclass(newOwnedMetaclass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, newOwnedMetaclass, newOwnedMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 13:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperations()).basicAdd(otherEnd, msgs);
			case 14:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperties()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 12:
				return basicSetOwnedMetaclass(null, msgs);
			case 13:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case 14:
				return ((InternalEList<?>)getOwnedProperties()).basicRemove(otherEnd, msgs);
			case 15:
				return ((InternalEList<?>)getOwnedSuperTypes()).basicRemove(otherEnd, msgs);
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
			case 10:
				return isIsAbstract();
			case 11:
				return isIsInterface();
			case 12:
				return getOwnedMetaclass();
			case 13:
				return getOwnedOperations();
			case 14:
				return getOwnedProperties();
			case 15:
				return getOwnedSuperTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case 10:
				setIsAbstract((Boolean)newValue);
				return;
			case 11:
				setIsInterface((Boolean)newValue);
				return;
			case 12:
				setOwnedMetaclass((TypedRefCS)newValue);
				return;
			case 13:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case 14:
				getOwnedProperties().clear();
				getOwnedProperties().addAll((Collection<? extends StructuralFeatureCS>)newValue);
				return;
			case 15:
				getOwnedSuperTypes().clear();
				getOwnedSuperTypes().addAll((Collection<? extends TypedRefCS>)newValue);
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
			case 10:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case 11:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case 12:
				setOwnedMetaclass((TypedRefCS)null);
				return;
			case 13:
				getOwnedOperations().clear();
				return;
			case 14:
				getOwnedProperties().clear();
				return;
			case 15:
				getOwnedSuperTypes().clear();
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
			case 10:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case 11:
				return isInterface != IS_INTERFACE_EDEFAULT;
			case 12:
				return ownedMetaclass != null;
			case 13:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case 14:
				return ownedProperties != null && !ownedProperties.isEmpty();
			case 15:
				return ownedSuperTypes != null && !ownedSuperTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitStructuredClassCS(this);
	}
} //ClassCSImpl
