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
package org.eclipse.ocl.xtext.completeoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.DefCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl#getOwnedSpecification <em>Owned Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefCSImpl#getOwningClassifierContextDecl <em>Owning Classifier Context Decl</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DefCSImpl
		extends TypedElementCSImpl
		implements DefCS {

	/**
	 * The number of structural features of the '<em>Def CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DEF_CS_FEATURE_COUNT = TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean isStatic = IS_STATIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedSpecification() <em>Owned Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSpecification()
	 * @generated
	 * @ordered
	 */
	protected ExpSpecificationCS ownedSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.DEF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassifierContextDeclCS getOwningClassifierContextDecl() {
		if (eContainerFeatureID() != (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2)) return null;
		return (ClassifierContextDeclCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpSpecificationCS getOwnedSpecification() {
		return ownedSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSpecification(ExpSpecificationCS newOwnedSpecification, NotificationChain msgs)
	{
		ExpSpecificationCS oldOwnedSpecification = ownedSpecification;
		ownedSpecification = newOwnedSpecification;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1, oldOwnedSpecification, newOwnedSpecification);
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
	public void setOwnedSpecification(ExpSpecificationCS newOwnedSpecification) {
		if (newOwnedSpecification != ownedSpecification)
		{
			NotificationChain msgs = null;
			if (ownedSpecification != null)
				msgs = ((InternalEObject)ownedSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedSpecification != null)
				msgs = ((InternalEObject)newOwnedSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedSpecification(newOwnedSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1, newOwnedSpecification, newOwnedSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsStatic()
	{
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsStatic(boolean newIsStatic)
	{
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0, oldIsStatic, isStatic));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return basicSetOwnedSpecification(null, msgs);
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return eBasicSetContainer(null, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return eInternalContainer().eInverseRemove(this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2, ClassifierContextDeclCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return isIsStatic();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwnedSpecification();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return getOwningClassifierContextDecl();
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				setIsStatic((Boolean)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwnedSpecification((ExpSpecificationCS)newValue);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwnedSpecification((ExpSpecificationCS)null);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 0:
				return isStatic != IS_STATIC_EDEFAULT;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1:
				return ownedSpecification != null;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2:
				return getOwningClassifierContextDecl() != null;
		}
		return super.eIsSet(featureID);
	}
} //DefCSImpl
