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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TypeRefCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter Substitution CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl#getOwnedActualParameter <em>Owned Actual Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.TemplateParameterSubstitutionCSImpl#getOwningBinding <em>Owning Binding</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateParameterSubstitutionCSImpl extends ModelElementCSImpl implements TemplateParameterSubstitutionCS {
	/**
	 * The number of structural features of the '<em>Template Parameter Substitution CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_PARAMETER_SUBSTITUTION_CS_FEATURE_COUNT = ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;
	/**
	 * The cached value of the '{@link #getOwnedActualParameter() <em>Owned Actual Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedActualParameter()
	 * @generated
	 * @ordered
	 */
	protected TypeRefCS ownedActualParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateParameterSubstitutionCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemplateBindingCS getOwningBinding() {
		if (eContainerFeatureID() != (6)) return null;
		return (TemplateBindingCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningBinding(TemplateBindingCS newOwningBinding, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningBinding, 6, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningBinding(TemplateBindingCS newOwningBinding) {
		if (newOwningBinding != eInternalContainer() || (eContainerFeatureID() != (6) && newOwningBinding != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningBinding))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningBinding != null)
				msgs = ((InternalEObject)newOwningBinding).eInverseAdd(this, 4, TemplateBindingCS.class, msgs);
			msgs = basicSetOwningBinding(newOwningBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, newOwningBinding, newOwningBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 *
	public TemplateParameterCS getFormalTemplateParameter() {
		TemplateBindingCS templateBinding = getOwningTemplateBinding();
		int index = templateBinding.getOwnedParameterSubstitution().indexOf(this);
		if (index < 0) {
			return null;
		}
		TemplateBindableElementCS templateBindableElement = templateBinding.getOwningTemplateBindableElement();
		TemplateSignatureCS templateSignature = templateBindableElement.getTemplateSignature();
		if (templateSignature == null) {
			return null;
		}
		List<TemplateParameterCS> ownedTemplateParameters = templateSignature.getOwnedTemplateParameter();
		if (index >= ownedTemplateParameters.size()) {
			return null;
		}
		return ownedTemplateParameters.get(index);
	} */

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeRefCS getOwnedActualParameter()
	{
		return ownedActualParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedActualParameter(TypeRefCS newOwnedActualParameter, NotificationChain msgs)
	{
		TypeRefCS oldOwnedActualParameter = ownedActualParameter;
		ownedActualParameter = newOwnedActualParameter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 5, oldOwnedActualParameter, newOwnedActualParameter);
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
	public void setOwnedActualParameter(TypeRefCS newOwnedActualParameter)
	{
		if (newOwnedActualParameter != ownedActualParameter)
		{
			NotificationChain msgs = null;
			if (ownedActualParameter != null)
				msgs = ((InternalEObject)ownedActualParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (5), null, msgs);
			if (newOwnedActualParameter != null)
				msgs = ((InternalEObject)newOwnedActualParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (5), null, msgs);
			msgs = basicSetOwnedActualParameter(newOwnedActualParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, newOwnedActualParameter, newOwnedActualParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 6:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningBinding((TemplateBindingCS)otherEnd, msgs);
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
			case 5:
				return basicSetOwnedActualParameter(null, msgs);
			case 6:
				return basicSetOwningBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case 6:
				return eInternalContainer().eInverseRemove(this, 4, TemplateBindingCS.class, msgs);
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
			case 5:
				return getOwnedActualParameter();
			case 6:
				return getOwningBinding();
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
			case 5:
				setOwnedActualParameter((TypeRefCS)newValue);
				return;
			case 6:
				setOwningBinding((TemplateBindingCS)newValue);
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
			case 5:
				setOwnedActualParameter((TypeRefCS)null);
				return;
			case 6:
				setOwningBinding((TemplateBindingCS)null);
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
			case 5:
				return ownedActualParameter != null;
			case 6:
				return getOwningBinding() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitTemplateParameterSubstitutionCS(this);
	}
} //TemplateParameterSubstitutionCSImpl
