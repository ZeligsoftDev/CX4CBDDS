/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Model Library Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl#getDomainModelLibraryReference <em>Domain Model Library Reference</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryReferenceImpl#getResourceName <em>Resource Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainModelLibraryReferenceImpl extends GenDomainObjectImpl implements GenDomainModelLibraryReference {

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected GenDomainModelLibrary target;

	/**
	 * The cached value of the '{@link #getDomainSpecialization() <em>Domain Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecialization()
	 * @generated
	 * @ordered
	 */
	protected GenDomainSpecialization domainSpecialization;

	/**
	 * The cached value of the '{@link #getDomainModelLibraryReference() <em>Domain Model Library Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelLibraryReference()
	 * @generated
	 * @ordered
	 */
	protected Dependency domainModelLibraryReference;

	/**
	 * The default value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceName() <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceName()
	 * @generated
	 * @ordered
	 */
	protected String resourceName = RESOURCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainModelLibraryReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject getOwner() {
		GenDomainObject owner = basicGetOwner();
		return owner != null && owner.eIsProxy() ? (GenDomainObject) eResolveProxy((InternalEObject) owner) : owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject basicGetOwner() {
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION)) {
			return basicGetDomainSpecialization();
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainModelLibrary getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (GenDomainModelLibrary) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainModelLibrary basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(GenDomainModelLibrary newTarget) {
		GenDomainModelLibrary oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Dependency getDomainModelLibraryReference() {
		if (domainModelLibraryReference != null && domainModelLibraryReference.eIsProxy()) {
			InternalEObject oldDomainModelLibraryReference = (InternalEObject) domainModelLibraryReference;
			domainModelLibraryReference = (Dependency) eResolveProxy(oldDomainModelLibraryReference);
			if (domainModelLibraryReference != oldDomainModelLibraryReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE,
							oldDomainModelLibraryReference, domainModelLibraryReference));
			}
		}
		return domainModelLibraryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetDomainModelLibraryReference() {
		return domainModelLibraryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainModelLibraryReference(Dependency newDomainModelLibraryReference) {
		Dependency oldDomainModelLibraryReference = domainModelLibraryReference;
		domainModelLibraryReference = newDomainModelLibraryReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE,
					oldDomainModelLibraryReference, domainModelLibraryReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourceName(String newResourceName) {
		String oldResourceName = resourceName;
		resourceName = newResourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME, oldResourceName, resourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainSpecialization getDomainSpecialization() {
		if (domainSpecialization != null && domainSpecialization.eIsProxy()) {
			InternalEObject oldDomainSpecialization = (InternalEObject) domainSpecialization;
			domainSpecialization = (GenDomainSpecialization) eResolveProxy(oldDomainSpecialization);
			if (domainSpecialization != oldDomainSpecialization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION,
							oldDomainSpecialization, domainSpecialization));
			}
		}
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainSpecialization basicGetDomainSpecialization() {
		return domainSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainSpecialization(GenDomainSpecialization newDomainSpecialization) {
		GenDomainSpecialization oldDomainSpecialization = domainSpecialization;
		domainSpecialization = newDomainSpecialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION, oldDomainSpecialization,
					domainSpecialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION:
			if (resolve)
				return getDomainSpecialization();
			return basicGetDomainSpecialization();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE:
			if (resolve)
				return getDomainModelLibraryReference();
			return basicGetDomainModelLibraryReference();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME:
			return getResourceName();
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET:
			setTarget((GenDomainModelLibrary) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((GenDomainSpecialization) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE:
			setDomainModelLibraryReference((Dependency) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME:
			setResourceName((String) newValue);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET:
			setTarget((GenDomainModelLibrary) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION:
			setDomainSpecialization((GenDomainSpecialization) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE:
			setDomainModelLibraryReference((Dependency) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME:
			setResourceName(RESOURCE_NAME_EDEFAULT);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__TARGET:
			return target != null;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION:
			return domainSpecialization != null;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_MODEL_LIBRARY_REFERENCE:
			return domainModelLibraryReference != null;
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__RESOURCE_NAME:
			return RESOURCE_NAME_EDEFAULT == null ? resourceName != null : !RESOURCE_NAME_EDEFAULT.equals(resourceName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (resourceName: "); //$NON-NLS-1$
		result.append(resourceName);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY_REFERENCE__DOMAIN_SPECIALIZATION);
	}

} //GenDomainModelLibraryReferenceImpl
