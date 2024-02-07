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
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.TypedRefCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.TypeNameExpCSImpl#getOwnedPatternGuard <em>Owned Pattern Guard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeNameExpCSImpl
		extends TypedRefCSImpl
		implements TypeNameExpCS {

	/**
	 * The number of structural features of the '<em>Type Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_NAME_EXP_CS_FEATURE_COUNT = TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 4;
	/**
	 * The cached value of the '{@link #getOwnedCurlyBracketedClause() <em>Owned Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCurlyBracketedClause()
	 * @generated
	 * @ordered
	 */
	protected CurlyBracketedClauseCS ownedCurlyBracketedClause;
	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;
	/**
	 * The cached value of the '{@link #getOwnedPatternGuard() <em>Owned Pattern Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPatternGuard()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedPatternGuard;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeNameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedPathName() {
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs)
	{
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, oldOwnedPathName, newOwnedPathName);
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
	public void setOwnedPathName(PathNameCS newOwnedPathName) {
		if (newOwnedPathName != ownedPathName)
		{
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2, newOwnedPathName, newOwnedPathName));
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
				return basicSetOwnedCurlyBracketedClause(null, msgs);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return basicSetOwnedPathName(null, msgs);
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3:
				return basicSetOwnedPatternGuard(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedElement getNamedElement() {
		return getElement();
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
				return getElement();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return getOwnedCurlyBracketedClause();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return getOwnedPathName();
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3:
				return getOwnedPatternGuard();
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedCurlyBracketedClause((CurlyBracketedClauseCS)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3:
				setOwnedPatternGuard((ExpCS)newValue);
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
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				setOwnedCurlyBracketedClause((CurlyBracketedClauseCS)null);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				setOwnedPathName((PathNameCS)null);
				return;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3:
				setOwnedPatternGuard((ExpCS)null);
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
				return getElement() != null;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1:
				return ownedCurlyBracketedClause != null;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 2:
				return ownedPathName != null;
			case TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3:
				return ownedPatternGuard != null;
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
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitTypeNameExpCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Type getElement() {
		if (ownedPathName == null) {
			return null;
		}
		return (Type) ownedPathName.getReferredElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CurlyBracketedClauseCS getOwnedCurlyBracketedClause()
	{
		return ownedCurlyBracketedClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCurlyBracketedClause(CurlyBracketedClauseCS newOwnedCurlyBracketedClause, NotificationChain msgs)
	{
		CurlyBracketedClauseCS oldOwnedCurlyBracketedClause = ownedCurlyBracketedClause;
		ownedCurlyBracketedClause = newOwnedCurlyBracketedClause;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, oldOwnedCurlyBracketedClause, newOwnedCurlyBracketedClause);
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
	public void setOwnedCurlyBracketedClause(CurlyBracketedClauseCS newOwnedCurlyBracketedClause)
	{
		if (newOwnedCurlyBracketedClause != ownedCurlyBracketedClause)
		{
			NotificationChain msgs = null;
			if (ownedCurlyBracketedClause != null)
				msgs = ((InternalEObject)ownedCurlyBracketedClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedCurlyBracketedClause != null)
				msgs = ((InternalEObject)newOwnedCurlyBracketedClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedCurlyBracketedClause(newOwnedCurlyBracketedClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 1, newOwnedCurlyBracketedClause, newOwnedCurlyBracketedClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedPatternGuard()
	{
		return ownedPatternGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPatternGuard(ExpCS newOwnedPatternGuard, NotificationChain msgs)
	{
		ExpCS oldOwnedPatternGuard = ownedPatternGuard;
		ownedPatternGuard = newOwnedPatternGuard;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3, oldOwnedPatternGuard, newOwnedPatternGuard);
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
	public void setOwnedPatternGuard(ExpCS newOwnedPatternGuard)
	{
		if (newOwnedPatternGuard != ownedPatternGuard)
		{
			NotificationChain msgs = null;
			if (ownedPatternGuard != null)
				msgs = ((InternalEObject)ownedPatternGuard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3), null, msgs);
			if (newOwnedPatternGuard != null)
				msgs = ((InternalEObject)newOwnedPatternGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3), null, msgs);
			msgs = basicSetOwnedPatternGuard(newOwnedPatternGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypedRefCSImpl.TYPED_REF_CS_FEATURE_COUNT + 3, newOwnedPatternGuard, newOwnedPatternGuard));
	}
} //TypeNameExpCSImpl
