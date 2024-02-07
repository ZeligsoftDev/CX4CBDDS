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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ImplicitOppositeCS;
import org.eclipse.ocl.xtext.basecs.ReferenceCS;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl#getReferredKeys <em>Referred Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl#getReferredOpposite <em>Referred Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.impl.ReferenceCSImpl#getOwnedImplicitOpposites <em>Owned Implicit Opposites</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceCSImpl extends StructuralFeatureCSImpl implements ReferenceCS
{
	/**
	 * The number of structural features of the '<em>Reference CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_CS_FEATURE_COUNT = StructuralFeatureCSImpl.STRUCTURAL_FEATURE_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getReferredKeys() <em>Referred Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> referredKeys;

	/**
	 * The cached value of the '{@link #getReferredOpposite() <em>Referred Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOpposite()
	 * @generated
	 * @ordered
	 */
	protected Property referredOpposite;

	/**
	 * The cached value of the '{@link #getOwnedImplicitOpposites() <em>Owned Implicit Opposites</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImplicitOpposites()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplicitOppositeCS> ownedImplicitOpposites;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceCSImpl()
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
		return BaseCSPackage.Literals.REFERENCE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredOpposite()
	{
		if (referredOpposite != null && referredOpposite.eIsProxy())
		{
			InternalEObject oldReferredOpposite = (InternalEObject)referredOpposite;
			referredOpposite = (Property)eResolveProxy(oldReferredOpposite);
			if (referredOpposite != oldReferredOpposite)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 13, oldReferredOpposite, referredOpposite));
			}
		}
		return referredOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredOpposite()
	{
		return referredOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOpposite(Property newReferredOpposite)
	{
		Property oldReferredOpposite = referredOpposite;
		referredOpposite = newReferredOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 13, oldReferredOpposite, referredOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImplicitOppositeCS> getOwnedImplicitOpposites()
	{
		if (ownedImplicitOpposites == null)
		{
			ownedImplicitOpposites = new EObjectContainmentEList<ImplicitOppositeCS>(ImplicitOppositeCS.class, this, 14);
		}
		return ownedImplicitOpposites;
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
			case 14:
				return ((InternalEList<?>)getOwnedImplicitOpposites()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getReferredKeys()
	{
		if (referredKeys == null)
		{
			referredKeys = new EObjectResolvingEList<Property>(Property.class, this, 12);
		}
		return referredKeys;
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
			case 12:
				return getReferredKeys();
			case 13:
				if (resolve) return getReferredOpposite();
				return basicGetReferredOpposite();
			case 14:
				return getOwnedImplicitOpposites();
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
			case 12:
				getReferredKeys().clear();
				getReferredKeys().addAll((Collection<? extends Property>)newValue);
				return;
			case 13:
				setReferredOpposite((Property)newValue);
				return;
			case 14:
				getOwnedImplicitOpposites().clear();
				getOwnedImplicitOpposites().addAll((Collection<? extends ImplicitOppositeCS>)newValue);
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
			case 12:
				getReferredKeys().clear();
				return;
			case 13:
				setReferredOpposite((Property)null);
				return;
			case 14:
				getOwnedImplicitOpposites().clear();
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
			case 12:
				return referredKeys != null && !referredKeys.isEmpty();
			case 13:
				return referredOpposite != null;
			case 14:
				return ownedImplicitOpposites != null && !ownedImplicitOpposites.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return visitor.visitReferenceCS(this);
	}
} //ReferenceCSImpl
