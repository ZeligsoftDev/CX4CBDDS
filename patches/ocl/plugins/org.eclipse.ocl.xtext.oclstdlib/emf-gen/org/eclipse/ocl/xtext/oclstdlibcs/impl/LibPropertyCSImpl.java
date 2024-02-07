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

package org.eclipse.ocl.xtext.oclstdlibcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.AttributeCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibPropertyCSImpl#getOwnedOpposite <em>Owned Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibPropertyCSImpl
		extends AttributeCSImpl
		implements LibPropertyCS {

	/**
	 * The number of structural features of the '<em>Lib Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIB_PROPERTY_CS_FEATURE_COUNT = AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected JavaClassCS implementation;

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
	 * The cached value of the '{@link #getOwnedOpposite() <em>Owned Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOpposite()
	 * @generated
	 * @ordered
	 */
	protected LibOppositeCS ownedOpposite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibPropertyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSPackage.Literals.LIB_PROPERTY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaClassCS getImplementation() {
		if (implementation != null && implementation.eIsProxy())
		{
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (JavaClassCS)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassCS basicGetImplementation()
	{
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementation(JavaClassCS newImplementation)
	{
		JavaClassCS oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 1, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibOppositeCS getOwnedOpposite()
	{
		return ownedOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedOpposite(LibOppositeCS newOwnedOpposite, NotificationChain msgs)
	{
		LibOppositeCS oldOwnedOpposite = ownedOpposite;
		ownedOpposite = newOwnedOpposite;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2, oldOwnedOpposite, newOwnedOpposite);
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
	public void setOwnedOpposite(LibOppositeCS newOwnedOpposite)
	{
		if (newOwnedOpposite != ownedOpposite)
		{
			NotificationChain msgs = null;
			if (ownedOpposite != null)
				msgs = ((InternalEObject)ownedOpposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedOpposite != null)
				msgs = ((InternalEObject)newOwnedOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedOpposite(newOwnedOpposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2, newOwnedOpposite, newOwnedOpposite));
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
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2:
				return basicSetOwnedOpposite(null, msgs);
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
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 1:
				return isIsStatic();
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2:
				return getOwnedOpposite();
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
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)newValue);
				return;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 1:
				setIsStatic((Boolean)newValue);
				return;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2:
				setOwnedOpposite((LibOppositeCS)newValue);
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
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)null);
				return;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 1:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2:
				setOwnedOpposite((LibOppositeCS)null);
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
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0:
				return implementation != null;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 1:
				return isStatic != IS_STATIC_EDEFAULT;
			case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 2:
				return ownedOpposite != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (derivedFeatureID)
			{
				case AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0: return ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (baseFeatureID)
			{
				case ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0: return AttributeCSImpl.ATTRIBUTE_CS_FEATURE_COUNT + 0;
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
		if (visitor instanceof OCLstdlibCSVisitor) {
			return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibPropertyCS(this);
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
	public String toString() {
		return super.toString();
	}
} //LibPropertyCSImpl
