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
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.NavigationCallExpImpl#getNavigationSource <em>Navigation Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.NavigationCallExpImpl#getQualifiers <em>Qualifiers</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NavigationCallExpImpl
		extends FeatureCallExpImpl
		implements NavigationCallExp {

	/**
	 * The number of structural features of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATION_CALL_EXP_FEATURE_COUNT = FeatureCallExpImpl.FEATURE_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Navigation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATION_CALL_EXP_OPERATION_COUNT = FeatureCallExpImpl.FEATURE_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getNavigationSource() <em>Navigation Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigationSource()
	 * @generated
	 * @ordered
	 */
	protected Property navigationSource;

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> qualifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.NAVIGATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull List<OCLExpression> getQualifiers()
	{
		if (qualifiers == null)
		{
			qualifiers = new EObjectResolvingEList<OCLExpression>(OCLExpression.class, this, 14);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getNavigationSource() {
		if (navigationSource != null && navigationSource.eIsProxy())
		{
			InternalEObject oldNavigationSource = (InternalEObject)navigationSource;
			navigationSource = (Property)eResolveProxy(oldNavigationSource);
			if (navigationSource != oldNavigationSource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 13, oldNavigationSource, navigationSource));
			}
		}
		return navigationSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetNavigationSource() {
		return navigationSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNavigationSource(Property newNavigationSource) {
		Property oldNavigationSource = navigationSource;
		navigationSource = newNavigationSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 13, oldNavigationSource, navigationSource));
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
			case 0:
				return getAnnotatingComments();
			case 1:
				return getOwnedAnnotations();
			case 2:
				return getOwnedComments();
			case 3:
				return getOwnedExtensions();
			case 4:
				return getName();
			case 5:
				return isIsMany();
			case 6:
				return isIsRequired();
			case 7:
				if (resolve) return getType();
				return basicGetType();
			case 8:
				return getTypeValue();
			case 9:
				return isIsImplicit();
			case 10:
				return isIsSafe();
			case 11:
				return getOwnedSource();
			case 12:
				return isIsPre();
			case 13:
				if (resolve) return getNavigationSource();
				return basicGetNavigationSource();
			case 14:
				return getQualifiers();
		}
		return eDynamicGet(featureID, resolve, coreType);
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
			case 0:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 1:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case 2:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 3:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case 4:
				setName((String)newValue);
				return;
			case 6:
				setIsRequired((Boolean)newValue);
				return;
			case 7:
				setType((Type)newValue);
				return;
			case 8:
				setTypeValue((Type)newValue);
				return;
			case 9:
				setIsImplicit((Boolean)newValue);
				return;
			case 10:
				setIsSafe((Boolean)newValue);
				return;
			case 11:
				setOwnedSource((OCLExpression)newValue);
				return;
			case 12:
				setIsPre((Boolean)newValue);
				return;
			case 13:
				setNavigationSource((Property)newValue);
				return;
			case 14:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends OCLExpression>)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
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
			case 0:
				getAnnotatingComments().clear();
				return;
			case 1:
				getOwnedAnnotations().clear();
				return;
			case 2:
				getOwnedComments().clear();
				return;
			case 3:
				getOwnedExtensions().clear();
				return;
			case 4:
				setName(NAME_EDEFAULT);
				return;
			case 6:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case 7:
				setType((Type)null);
				return;
			case 8:
				setTypeValue((Type)null);
				return;
			case 9:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
				return;
			case 10:
				setIsSafe(IS_SAFE_EDEFAULT);
				return;
			case 11:
				setOwnedSource((OCLExpression)null);
				return;
			case 12:
				setIsPre(IS_PRE_EDEFAULT);
				return;
			case 13:
				setNavigationSource((Property)null);
				return;
			case 14:
				getQualifiers().clear();
				return;
		}
		eDynamicUnset(featureID);
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
			case 0:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case 1:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case 2:
				return ownedComments != null && !ownedComments.isEmpty();
			case 3:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 5:
				return isIsMany() != IS_MANY_EDEFAULT;
			case 6:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case 7:
				return type != null;
			case 8:
				return typeValue != null;
			case 9:
				return ((eFlags & IS_IMPLICIT_EFLAG) != 0) != IS_IMPLICIT_EDEFAULT;
			case 10:
				return ((eFlags & IS_SAFE_EFLAG) != 0) != IS_SAFE_EDEFAULT;
			case 11:
				return ownedSource != null;
			case 12:
				return ((eFlags & IS_PRE_EFLAG) != 0) != IS_PRE_EDEFAULT;
			case 13:
				return navigationSource != null;
			case 14:
				return qualifiers != null && !qualifiers.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNavigationCallExp(this);
	}
} //NavigationCallExpImpl
