/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.LambdaLiteralExpCSImpl#getOwnedExpressionCS <em>Owned Expression CS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LambdaLiteralExpCSImpl extends LiteralExpCSImpl implements LambdaLiteralExpCS
{
	/**
	 * The number of structural features of the '<em>Lambda Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LAMBDA_LITERAL_EXP_CS_FEATURE_COUNT = LiteralExpCSImpl.LITERAL_EXP_CS_FEATURE_COUNT + 1;
	/**
	 * The cached value of the '{@link #getOwnedExpressionCS() <em>Owned Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpressionCS;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LambdaLiteralExpCSImpl()
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
		return EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedExpressionCS()
	{
		return ownedExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpressionCS(ExpCS newOwnedExpressionCS, NotificationChain msgs)
	{
		ExpCS oldOwnedExpressionCS = ownedExpressionCS;
		ownedExpressionCS = newOwnedExpressionCS;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8, oldOwnedExpressionCS, newOwnedExpressionCS);
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
	public void setOwnedExpressionCS(ExpCS newOwnedExpressionCS)
	{
		if (newOwnedExpressionCS != ownedExpressionCS)
		{
			NotificationChain msgs = null;
			if (ownedExpressionCS != null)
				msgs = ((InternalEObject)ownedExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8), null, msgs);
			if (newOwnedExpressionCS != null)
				msgs = ((InternalEObject)newOwnedExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8), null, msgs);
			msgs = basicSetOwnedExpressionCS(newOwnedExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8, newOwnedExpressionCS, newOwnedExpressionCS));
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				return basicSetOwnedExpressionCS(null, msgs);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				return getOwnedExpressionCS();
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				setOwnedExpressionCS((ExpCS)newValue);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				setOwnedExpressionCS((ExpCS)null);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				return ownedExpressionCS != null;
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitLambdaLiteralExpCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //LambdaLiteralExpCSImpl
