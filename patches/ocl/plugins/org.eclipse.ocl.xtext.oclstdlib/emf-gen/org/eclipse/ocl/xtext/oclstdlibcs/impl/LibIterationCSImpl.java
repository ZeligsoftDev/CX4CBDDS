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
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.JavaImplementationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.util.OCLstdlibCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Iteration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl#isIsInvalidating <em>Is Invalidating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl#isIsValidating <em>Is Validating</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl#getOwnedAccumulators <em>Owned Accumulators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.impl.LibIterationCSImpl#getOwnedIterators <em>Owned Iterators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibIterationCSImpl
		extends OperationCSImpl
		implements LibIterationCS {

	/**
	 * The number of structural features of the '<em>Lib Iteration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LIB_ITERATION_CS_FEATURE_COUNT = OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 5;

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
	 * The default value of the '{@link #isIsInvalidating() <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvalidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVALIDATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInvalidating() <em>Is Invalidating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvalidating()
	 * @generated
	 * @ordered
	 */
	protected boolean isInvalidating = IS_INVALIDATING_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsValidating() <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsValidating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VALIDATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsValidating() <em>Is Validating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsValidating()
	 * @generated
	 * @ordered
	 */
	protected boolean isValidating = IS_VALIDATING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedAccumulators() <em>Owned Accumulators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccumulators()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedAccumulators;

	/**
	 * The cached value of the '{@link #getOwnedIterators() <em>Owned Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedIterators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibIterationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSPackage.Literals.LIB_ITERATION_CS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParameterCS> getOwnedIterators()
	{
		if (ownedIterators == null)
		{
			ownedIterators = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4);
		}
		return ownedIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParameterCS> getOwnedAccumulators()
	{
		if (ownedAccumulators == null)
		{
			ownedAccumulators = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3);
		}
		return ownedAccumulators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInvalidating()
	{
		return isInvalidating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInvalidating(boolean newIsInvalidating)
	{
		boolean oldIsInvalidating = isInvalidating;
		isInvalidating = newIsInvalidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 1, oldIsInvalidating, isInvalidating));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsValidating()
	{
		return isValidating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsValidating(boolean newIsValidating)
	{
		boolean oldIsValidating = isValidating;
		isValidating = newIsValidating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 2, oldIsValidating, isValidating));
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
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedAccumulators()).basicRemove(otherEnd, msgs);
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getOwnedIterators()).basicRemove(otherEnd, msgs);
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
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 1:
				return isIsInvalidating();
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 2:
				return isIsValidating();
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3:
				return getOwnedAccumulators();
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4:
				return getOwnedIterators();
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
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)newValue);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 1:
				setIsInvalidating((Boolean)newValue);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 2:
				setIsValidating((Boolean)newValue);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3:
				getOwnedAccumulators().clear();
				getOwnedAccumulators().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4:
				getOwnedIterators().clear();
				getOwnedIterators().addAll((Collection<? extends ParameterCS>)newValue);
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
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0:
				setImplementation((JavaClassCS)null);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 1:
				setIsInvalidating(IS_INVALIDATING_EDEFAULT);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 2:
				setIsValidating(IS_VALIDATING_EDEFAULT);
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3:
				getOwnedAccumulators().clear();
				return;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4:
				getOwnedIterators().clear();
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
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0:
				return implementation != null;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 1:
				return isInvalidating != IS_INVALIDATING_EDEFAULT;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 2:
				return isValidating != IS_VALIDATING_EDEFAULT;
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 3:
				return ownedAccumulators != null && !ownedAccumulators.isEmpty();
			case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 4:
				return ownedIterators != null && !ownedIterators.isEmpty();
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
				case OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0: return ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0;
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
				case ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 0: return OperationCSImpl.OPERATION_CS_FEATURE_COUNT + 0;
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
			return (R) ((OCLstdlibCSVisitor<?>)visitor).visitLibIterationCS(this);
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
} //LibIterationCSImpl
