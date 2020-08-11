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
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Model Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainModelLibraryImpl#getDomainModelLibrary <em>Domain Model Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainModelLibraryImpl extends GenDomainPackageableElementImpl implements GenDomainModelLibrary {

	/**
	 * The cached value of the '{@link #getDomainModelLibrary() <em>Domain Model Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelLibrary()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package domainModelLibrary;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainModelLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_MODEL_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getDomainElement() {
		NamedElement domainElement = basicGetDomainElement();
		return domainElement != null && domainElement.eIsProxy()
				? (NamedElement) eResolveProxy((InternalEObject) domainElement)
				: domainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement basicGetDomainElement() {
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY)) {
			return basicGetDomainModelLibrary();
		}
		return super.basicGetDomainElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Package getDomainModelLibrary() {
		if (domainModelLibrary != null && domainModelLibrary.eIsProxy()) {
			InternalEObject oldDomainModelLibrary = (InternalEObject) domainModelLibrary;
			domainModelLibrary = (org.eclipse.uml2.uml.Package) eResolveProxy(oldDomainModelLibrary);
			if (domainModelLibrary != oldDomainModelLibrary) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY, oldDomainModelLibrary,
							domainModelLibrary));
			}
		}
		return domainModelLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetDomainModelLibrary() {
		return domainModelLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainModelLibrary(org.eclipse.uml2.uml.Package newDomainModelLibrary) {
		org.eclipse.uml2.uml.Package oldDomainModelLibrary = domainModelLibrary;
		domainModelLibrary = newDomainModelLibrary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY, oldDomainModelLibrary,
					domainModelLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY:
			if (resolve)
				return getDomainModelLibrary();
			return basicGetDomainModelLibrary();
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY:
			setDomainModelLibrary((org.eclipse.uml2.uml.Package) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY:
			setDomainModelLibrary((org.eclipse.uml2.uml.Package) null);
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
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY:
			return domainModelLibrary != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDomainElement() {
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_MODEL_LIBRARY__DOMAIN_MODEL_LIBRARY);
	}

} //GenDomainModelLibraryImpl
