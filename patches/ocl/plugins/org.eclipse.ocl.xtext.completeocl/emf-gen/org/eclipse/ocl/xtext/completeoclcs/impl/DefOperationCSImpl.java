/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.util.CompleteOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl#getOwnedSignature <em>Owned Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.impl.DefOperationCSImpl#getOwnedParameters <em>Owned Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefOperationCSImpl
		extends DefCSImpl
		implements DefOperationCS {

	/**
	 * The number of structural features of the '<em>Def Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DEF_OPERATION_CS_FEATURE_COUNT = DefCSImpl.DEF_CS_FEATURE_COUNT + 2;
	/**
	 * The cached value of the '{@link #getOwnedSignature() <em>Owned Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignatureCS ownedSignature;
	/**
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedParameters;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSPackage.Literals.DEF_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateSignatureCS getOwnedSignature()
	{
		return ownedSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSignature(TemplateSignatureCS newOwnedSignature, NotificationChain msgs)
	{
		TemplateSignatureCS oldOwnedSignature = ownedSignature;
		ownedSignature = newOwnedSignature;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3, oldOwnedSignature, newOwnedSignature);
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
	public void setOwnedSignature(TemplateSignatureCS newOwnedSignature)
	{
		if (newOwnedSignature != ownedSignature)
		{
			NotificationChain msgs = null;
			if (ownedSignature != null)
				msgs = ((InternalEObject)ownedSignature).eInverseRemove(this, 6, TemplateSignatureCS.class, msgs);
			if (newOwnedSignature != null)
				msgs = ((InternalEObject)newOwnedSignature).eInverseAdd(this, 6, TemplateSignatureCS.class, msgs);
			msgs = basicSetOwnedSignature(newOwnedSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3, newOwnedSignature, newOwnedSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParameterCS> getOwnedParameters() {
		if (ownedParameters == null)
		{
			ownedParameters = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4);
		}
		return ownedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				if (ownedSignature != null)
					msgs = ((InternalEObject)ownedSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3), null, msgs);
				return basicSetOwnedSignature((TemplateSignatureCS)otherEnd, msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return basicSetOwnedSignature(null, msgs);
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getOwnedParameters()).basicRemove(otherEnd, msgs);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return getOwnedSignature();
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4:
				return getOwnedParameters();
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setOwnedSignature((TemplateSignatureCS)newValue);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4:
				getOwnedParameters().clear();
				getOwnedParameters().addAll((Collection<? extends ParameterCS>)newValue);
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				setOwnedSignature((TemplateSignatureCS)null);
				return;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4:
				getOwnedParameters().clear();
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
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3:
				return ownedSignature != null;
			case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 4:
				return ownedParameters != null && !ownedParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == TemplateableElementCS.class)
		{
			switch (derivedFeatureID)
			{
				case TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3: return 2;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == TemplateableElementCS.class)
		{
			switch (baseFeatureID)
			{
				case 2: return TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof CompleteOCLCSVisitor) {
			return (R) ((CompleteOCLCSVisitor<?>)visitor).visitDefOperationCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //DefOperationCSImpl
