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
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.RoundBracketedClauseCSImpl#getOwningNameExp <em>Owning Name Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoundBracketedClauseCSImpl extends ContextLessElementCSImpl implements RoundBracketedClauseCS
{
	/**
	 * The number of structural features of the '<em>Round Bracketed Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ROUND_BRACKETED_CLAUSE_CS_FEATURE_COUNT = ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 2;
	/**
	 * The cached value of the '{@link #getOwnedArguments() <em>Owned Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigatingArgCS> ownedArguments;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundBracketedClauseCSImpl()
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
		return EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS;
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
				msgs = ((InternalEObject)newOwningNameExp).eInverseAdd(this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11, AbstractNameExpCS.class, msgs);
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
	@SuppressWarnings("null")
	public @NonNull EList<NavigatingArgCS> getOwnedArguments()
	{
		if (ownedArguments == null)
		{
			ownedArguments = new EObjectContainmentWithInverseEList<NavigatingArgCS>(NavigatingArgCS.class, this, ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 0, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);
		}
		return ownedArguments;
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
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedArguments()).basicAdd(otherEnd, msgs);
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
				return ((InternalEList<?>)getOwnedArguments()).basicRemove(otherEnd, msgs);
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
				return eInternalContainer().eInverseRemove(this, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 11, AbstractNameExpCS.class, msgs);
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
				return getOwnedArguments();
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwningNameExp();
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
				getOwnedArguments().clear();
				getOwnedArguments().addAll((Collection<? extends NavigatingArgCS>)newValue);
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwningNameExp((AbstractNameExpCS)newValue);
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
				getOwnedArguments().clear();
				return;
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				setOwningNameExp((AbstractNameExpCS)null);
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
				return ownedArguments != null && !ownedArguments.isEmpty();
			case ContextLessElementCSImpl.CONTEXT_LESS_ELEMENT_CS_FEATURE_COUNT + 1:
				return getOwningNameExp() != null;
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitRoundBracketedClauseCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //RoundBracketedClauseCSImpl
