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
package org.eclipse.ocl.xtext.oclstdlibcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.StructuredClassCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.MetaclassNameCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibClassCSImpl#getMetaclassName <em>Metaclass Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibClassCSImpl
		extends StructuredClassCSImpl
		implements LibClassCS {

	/**
	 * The number of structural features of the '<em>Lib Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIB_CLASS_CS_FEATURE_COUNT = StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 2;
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
	 * The cached value of the '{@link #getMetaclassName() <em>Metaclass Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaclassName()
	 * @generated
	 * @ordered
	 */
	protected MetaclassNameCS metaclassName;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSPackage.Literals.LIB_CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaClassCS getImplementation()
	{
		if (implementation != null && implementation.eIsProxy())
		{
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (JavaClassCS)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaclassNameCS getMetaclassName() {
		if (metaclassName != null && metaclassName.eIsProxy())
		{
			InternalEObject oldMetaclassName = (InternalEObject)metaclassName;
			metaclassName = (MetaclassNameCS)eResolveProxy(oldMetaclassName);
			if (metaclassName != oldMetaclassName)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1, oldMetaclassName, metaclassName));
			}
		}
		return metaclassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaclassNameCS basicGetMetaclassName()
	{
		return metaclassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetaclassName(MetaclassNameCS newMetaclassName) {
		MetaclassNameCS oldMetaclassName = metaclassName;
		metaclassName = newMetaclassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1, oldMetaclassName, metaclassName));
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
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1:
				if (resolve) return getMetaclassName();
				return basicGetMetaclassName();
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
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)newValue);
				return;
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1:
				setMetaclassName((MetaclassNameCS)newValue);
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
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)null);
				return;
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1:
				setMetaclassName((MetaclassNameCS)null);
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
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0:
				return implementation != null;
			case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 1:
				return metaclassName != null;
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
		if (baseClass == JavaImplementationCS.class)
		{
			switch (derivedFeatureID)
			{
				case StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0: return ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0;
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
		if (baseClass == JavaImplementationCS.class)
		{
			switch (baseFeatureID)
			{
				case ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0: return StructuredClassCSImpl.STRUCTURED_CLASS_CS_FEATURE_COUNT + 0;
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
			return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibClassCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //LibClassCSImpl
