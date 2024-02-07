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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.ContextLessElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Curly Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl#getOwningNameExp <em>Owning Name Exp</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.CurlyBracketedClauseCSImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CurlyBracketedClauseCSImpl extends ContextLessElementCSImpl implements CurlyBracketedClauseCS
{
	/**
	 * The number of structural features of the '<em>Curly Bracketed Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CURLY_BRACKETED_CLAUSE_CS_FEATURE_COUNT = ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ShadowPartCS> ownedParts;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CurlyBracketedClauseCSImpl()
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
		return EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractNameExpCS getOwningNameExp()
	{
		if (eContainerFeatureID() != (ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1)) return null;
		return (AbstractNameExpCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningNameExp(AbstractNameExpCS newOwningNameExp, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningNameExp, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningNameExp(AbstractNameExpCS newOwningNameExp)
	{
		if (newOwningNameExp != eInternalContainer() || (eContainerFeatureID() != (ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1) && newOwningNameExp != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningNameExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningNameExp != null)
				msgs = ((InternalEObject)newOwningNameExp).eInverseAdd(this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9, AbstractNameExpCS.class, msgs);
			msgs = basicSetOwningNameExp(newOwningNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1, newOwningNameExp, newOwningNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ShadowPartCS> getOwnedParts()
	{
		if (ownedParts == null)
		{
			ownedParts = new EObjectContainmentWithInverseEList<ShadowPartCS>(ShadowPartCS.class, this, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		}
		return ownedParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue)
	{
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2, oldValue, value));
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedParts()).basicAdd(otherEnd, msgs);
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningNameExp((AbstractNameExpCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return basicSetOwningNameExp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9, AbstractNameExpCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				return getOwnedParts();
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwningNameExp();
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2:
				return getValue();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				getOwnedParts().clear();
				getOwnedParts().addAll((Collection<? extends ShadowPartCS>)newValue);
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwningNameExp((AbstractNameExpCS)newValue);
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2:
				setValue((String)newValue);
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
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				getOwnedParts().clear();
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwningNameExp((AbstractNameExpCS)null);
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2:
				setValue(VALUE_EDEFAULT);
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
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0:
				return ownedParts != null && !ownedParts.isEmpty();
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwningNameExp() != null;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitCurlyBracketedClauseCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //CurlyBracketedClauseCSImpl
