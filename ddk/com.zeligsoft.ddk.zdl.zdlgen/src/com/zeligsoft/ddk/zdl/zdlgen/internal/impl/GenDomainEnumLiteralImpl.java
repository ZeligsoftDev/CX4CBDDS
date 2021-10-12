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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl#getDomainElement <em>Domain Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl#getDomainEnumLiteral <em>Domain Enum Literal</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainEnumLiteralImpl#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainEnumLiteralImpl extends GenDomainNamedElementImpl implements GenDomainEnumLiteral {

	/**
	 * The cached value of the '{@link #getDomainEnumLiteral() <em>Domain Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainEnumLiteral()
	 * @generated
	 * @ordered
	 */
	protected EnumerationLiteral domainEnumLiteral;

	/**
	 * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumeration()
	 * @generated
	 * @ordered
	 */
	protected GenDomainEnum enumeration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainEnumLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_ENUM_LITERAL;
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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL)) {
			return basicGetDomainEnumLiteral();
		}
		return super.basicGetDomainElement();
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
		if (eIsSet(ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION)) {
			return basicGetEnumeration();
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationLiteral getDomainEnumLiteral() {
		if (domainEnumLiteral != null && domainEnumLiteral.eIsProxy()) {
			InternalEObject oldDomainEnumLiteral = (InternalEObject) domainEnumLiteral;
			domainEnumLiteral = (EnumerationLiteral) eResolveProxy(oldDomainEnumLiteral);
			if (domainEnumLiteral != oldDomainEnumLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL, oldDomainEnumLiteral,
							domainEnumLiteral));
			}
		}
		return domainEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral basicGetDomainEnumLiteral() {
		return domainEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainEnumLiteral(EnumerationLiteral newDomainEnumLiteral) {
		EnumerationLiteral oldDomainEnumLiteral = domainEnumLiteral;
		domainEnumLiteral = newDomainEnumLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL, oldDomainEnumLiteral,
					domainEnumLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainEnum getEnumeration() {
		if (enumeration != null && enumeration.eIsProxy()) {
			InternalEObject oldEnumeration = (InternalEObject) enumeration;
			enumeration = (GenDomainEnum) eResolveProxy(oldEnumeration);
			if (enumeration != oldEnumeration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION, oldEnumeration, enumeration));
			}
		}
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainEnum basicGetEnumeration() {
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnumeration(GenDomainEnum newEnumeration) {
		GenDomainEnum oldEnumeration = enumeration;
		enumeration = newEnumeration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION,
					oldEnumeration, enumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL:
			if (resolve)
				return getDomainEnumLiteral();
			return basicGetDomainEnumLiteral();
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION:
			if (resolve)
				return getEnumeration();
			return basicGetEnumeration();
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
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL:
			setDomainEnumLiteral((EnumerationLiteral) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION:
			setEnumeration((GenDomainEnum) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL:
			setDomainEnumLiteral((EnumerationLiteral) null);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION:
			setEnumeration((GenDomainEnum) null);
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
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ELEMENT:
			return isSetDomainElement();
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL:
			return domainEnumLiteral != null;
		case ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION:
			return enumeration != null;
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
		return super.isSetDomainElement() || eIsSet(ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__DOMAIN_ENUM_LITERAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_DOMAIN_ENUM_LITERAL__ENUMERATION);
	}

} //GenDomainEnumLiteralImpl
