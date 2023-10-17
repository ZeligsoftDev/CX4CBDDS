/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.InstanceSpecification;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Profile;
import org.eclipse.ocl.pivot.ProfileApplication;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.ProfileImpl#getProfileApplications <em>Profile Applications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProfileImpl extends PackageImpl implements Profile
{
	/**
	 * The number of structural features of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROFILE_FEATURE_COUNT = PackageImpl.PACKAGE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROFILE_OPERATION_COUNT = PackageImpl.PACKAGE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getProfileApplications() <em>Profile Applications</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfileApplication> profileApplications;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileImpl()
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
		return PivotPackage.Literals.PROFILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ProfileApplication> getProfileApplications()
	{
		if (profileApplications == null)
		{
			profileApplications = new EObjectWithInverseResolvingEList<ProfileApplication>(ProfileApplication.class, this, 14, 4);
		}
		return profileApplications;
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
			case 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotatingComments()).basicAdd(otherEnd, msgs);
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComments()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedExtensions()).basicAdd(otherEnd, msgs);
			case 9:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClasses()).basicAdd(otherEnd, msgs);
			case 10:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedInstances()).basicAdd(otherEnd, msgs);
			case 11:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPackages()).basicAdd(otherEnd, msgs);
			case 12:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProfileApplications()).basicAdd(otherEnd, msgs);
			case 13:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((org.eclipse.ocl.pivot.Package)otherEnd, msgs);
			case 14:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProfileApplications()).basicAdd(otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
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
			case 0:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case 5:
				return ((InternalEList<?>)getOwnedConstraints()).basicRemove(otherEnd, msgs);
			case 9:
				return ((InternalEList<?>)getOwnedClasses()).basicRemove(otherEnd, msgs);
			case 10:
				return ((InternalEList<?>)getOwnedInstances()).basicRemove(otherEnd, msgs);
			case 11:
				return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
			case 12:
				return ((InternalEList<?>)getOwnedProfileApplications()).basicRemove(otherEnd, msgs);
			case 13:
				return basicSetOwningPackage(null, msgs);
			case 14:
				return ((InternalEList<?>)getProfileApplications()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
				return getOwnedConstraints();
			case 6:
				return getURI();
			case 7:
				return getImportedPackages();
			case 8:
				return getNsPrefix();
			case 9:
				return getOwnedClasses();
			case 10:
				return getOwnedInstances();
			case 11:
				return getOwnedPackages();
			case 12:
				return getOwnedProfileApplications();
			case 13:
				return getOwningPackage();
			case 14:
				return getProfileApplications();
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
	public void eSet(int featureID, Object newValue)
	{
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
			case 5:
				getOwnedConstraints().clear();
				getOwnedConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case 6:
				setURI((String)newValue);
				return;
			case 7:
				getImportedPackages().clear();
				getImportedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case 8:
				setNsPrefix((String)newValue);
				return;
			case 9:
				getOwnedClasses().clear();
				getOwnedClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
				return;
			case 10:
				getOwnedInstances().clear();
				getOwnedInstances().addAll((Collection<? extends InstanceSpecification>)newValue);
				return;
			case 11:
				getOwnedPackages().clear();
				getOwnedPackages().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case 12:
				getOwnedProfileApplications().clear();
				getOwnedProfileApplications().addAll((Collection<? extends ProfileApplication>)newValue);
				return;
			case 13:
				setOwningPackage((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case 14:
				getProfileApplications().clear();
				getProfileApplications().addAll((Collection<? extends ProfileApplication>)newValue);
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
	public void eUnset(int featureID)
	{
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
			case 5:
				getOwnedConstraints().clear();
				return;
			case 6:
				setURI(URI_EDEFAULT);
				return;
			case 7:
				getImportedPackages().clear();
				return;
			case 8:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case 9:
				getOwnedClasses().clear();
				return;
			case 10:
				getOwnedInstances().clear();
				return;
			case 11:
				getOwnedPackages().clear();
				return;
			case 12:
				getOwnedProfileApplications().clear();
				return;
			case 13:
				setOwningPackage((org.eclipse.ocl.pivot.Package)null);
				return;
			case 14:
				getProfileApplications().clear();
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
	public boolean eIsSet(int featureID)
	{
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
				return ownedConstraints != null && !ownedConstraints.isEmpty();
			case 6:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case 7:
				return importedPackages != null && !importedPackages.isEmpty();
			case 8:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case 9:
				return ownedClasses != null && !ownedClasses.isEmpty();
			case 10:
				return ownedInstances != null && !ownedInstances.isEmpty();
			case 11:
				return ownedPackages != null && !ownedPackages.isEmpty();
			case 12:
				return ownedProfileApplications != null && !ownedProfileApplications.isEmpty();
			case 13:
				return getOwningPackage() != null;
			case 14:
				return profileApplications != null && !profileApplications.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitProfile(this);
	}

} //ProfileImpl
