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
package org.eclipse.ocl.xtext.basecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.internal.scoping.ScopeFilter;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl#getOwnedPathElements <em>Owned Path Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl#getReferredElement <em>Referred Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.PathNameCSImpl#getScopeFilter <em>Scope Filter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathNameCSImpl extends ElementCSImpl implements PathNameCS
{
	/**
	 * The number of structural features of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PATH_NAME_CS_FEATURE_COUNT = ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected ElementCS context;

	/**
	 * This is true if the Context reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean contextESet;

	/**
	 * The cached value of the '{@link #getOwnedPathElements() <em>Owned Path Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PathElementCS> ownedPathElements;

	/**
	 * The default value of the '{@link #getScopeFilter() <em>Scope Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeFilter()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeFilter SCOPE_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScopeFilter() <em>Scope Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeFilter()
	 * @generated
	 * @ordered
	 */
	protected ScopeFilter scopeFilter = SCOPE_FILTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNameCSImpl()
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
		return BaseCSPackage.Literals.PATH_NAME_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathElementCS> getOwnedPathElements()
	{
		if (ownedPathElements == null)
		{
			ownedPathElements = new EObjectContainmentWithInverseEList<PathElementCS>(PathElementCS.class, this, 3, 3);
		}
		return ownedPathElements;
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
			case 3:
				return ((InternalEList<?>)getOwnedPathElements()).basicRemove(otherEnd, msgs);
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
			case 2:
				return getContext();
			case 3:
				return getOwnedPathElements();
			case 4:
				if (resolve) return getReferredElement();
				return basicGetReferredElement();
			case 5:
				return getScopeFilter();
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
			case 2:
				setContext((ElementCS)newValue);
				return;
			case 3:
				getOwnedPathElements().clear();
				getOwnedPathElements().addAll((Collection<? extends PathElementCS>)newValue);
				return;
			case 5:
				setScopeFilter((ScopeFilter)newValue);
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
			case 2:
				unsetContext();
				return;
			case 3:
				getOwnedPathElements().clear();
				return;
			case 5:
				setScopeFilter(SCOPE_FILTER_EDEFAULT);
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
			case 2:
				return isSetContext();
			case 3:
				return ownedPathElements != null && !ownedPathElements.isEmpty();
			case 4:
				return basicGetReferredElement() != null;
			case 5:
				return SCOPE_FILTER_EDEFAULT == null ? scopeFilter != null : !SCOPE_FILTER_EDEFAULT.equals(scopeFilter);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitPathNameCS(this);
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
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPathElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementCS getContext()
	{
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(ElementCS newContext)
	{
		ElementCS oldContext = context;
		context = newContext;
		boolean oldContextESet = contextESet;
		contextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldContext, context, !oldContextESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetContext()
	{
		ElementCS oldContext = context;
		boolean oldContextESet = contextESet;
		context = null;
		contextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, 2, oldContext, null, oldContextESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetContext()
	{
		return contextESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScopeFilter getScopeFilter()
	{
		return scopeFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScopeFilter(ScopeFilter newScopeFilter)
	{
		ScopeFilter oldScopeFilter = scopeFilter;
		scopeFilter = newScopeFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldScopeFilter, scopeFilter));
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
	 * @generated NOT
	 */
	public Element basicGetReferredElement()
	{
		if (ownedPathElements == null) {
			return null;
		}
		int iMax = ownedPathElements.size();
		if (iMax <= 0) {
			return null;
		}
		return ownedPathElements.get(iMax-1).basicGetReferredElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getReferredElement()
	{
		if (ownedPathElements == null) {
			return null;
		}
		int iMax = ownedPathElements.size();
		if (iMax <= 0) {
			return null;
		}
		for (int i = 0; i < iMax-1; i++) {
			Element element = ownedPathElements.get(i).getReferredElement();
			if ((element == null) || element.eIsProxy()) {
				return null;
			}
		}
		Element element = ownedPathElements.get(iMax-1).getReferredElement();
		if ((element == null) || element.eIsProxy()) {
			return null;
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getPivot() {
		return getReferredElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void resetPivot() {}
} //QualifiedElementRefCSImpl
