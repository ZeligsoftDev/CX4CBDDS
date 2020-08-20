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

import com.zeligsoft.ddk.zdl.zdlgen.GenMenu;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen UML Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl#getMenu <em>Menu</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenUMLMenuImpl#getUmlMetaclass <em>Uml Metaclass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenUMLMenuImpl extends GenDomainObjectImpl implements GenUMLMenu {
	/**
	 * The cached value of the '{@link #getMenu() <em>Menu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMenu()
	 * @generated
	 * @ordered
	 */
	protected GenMenu menu;

	/**
	 * The cached value of the '{@link #getUmlMetaclass() <em>Uml Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMetaclass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class umlMetaclass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenUMLMenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_UML_MENU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenMenu getMenu() {
		if (menu != null && menu.eIsProxy()) {
			InternalEObject oldMenu = (InternalEObject) menu;
			menu = (GenMenu) eResolveProxy(oldMenu);
			if (menu != oldMenu) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ZDLGenPackage.GEN_UML_MENU__MENU, oldMenu,
							menu));
			}
		}
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenMenu basicGetMenu() {
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMenu(GenMenu newMenu) {
		GenMenu oldMenu = menu;
		menu = newMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_UML_MENU__MENU, oldMenu, menu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getUmlMetaclass() {
		if (umlMetaclass != null && umlMetaclass.eIsProxy()) {
			InternalEObject oldUmlMetaclass = (InternalEObject) umlMetaclass;
			umlMetaclass = (org.eclipse.uml2.uml.Class) eResolveProxy(oldUmlMetaclass);
			if (umlMetaclass != oldUmlMetaclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ZDLGenPackage.GEN_UML_MENU__UML_METACLASS,
							oldUmlMetaclass, umlMetaclass));
			}
		}
		return umlMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetUmlMetaclass() {
		return umlMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUmlMetaclass(org.eclipse.uml2.uml.Class newUmlMetaclass) {
		org.eclipse.uml2.uml.Class oldUmlMetaclass = umlMetaclass;
		umlMetaclass = newUmlMetaclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_UML_MENU__UML_METACLASS,
					oldUmlMetaclass, umlMetaclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_UML_MENU__MENU:
			if (resolve)
				return getMenu();
			return basicGetMenu();
		case ZDLGenPackage.GEN_UML_MENU__UML_METACLASS:
			if (resolve)
				return getUmlMetaclass();
			return basicGetUmlMetaclass();
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
		case ZDLGenPackage.GEN_UML_MENU__MENU:
			setMenu((GenMenu) newValue);
			return;
		case ZDLGenPackage.GEN_UML_MENU__UML_METACLASS:
			setUmlMetaclass((org.eclipse.uml2.uml.Class) newValue);
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
		case ZDLGenPackage.GEN_UML_MENU__MENU:
			setMenu((GenMenu) null);
			return;
		case ZDLGenPackage.GEN_UML_MENU__UML_METACLASS:
			setUmlMetaclass((org.eclipse.uml2.uml.Class) null);
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
		case ZDLGenPackage.GEN_UML_MENU__MENU:
			return menu != null;
		case ZDLGenPackage.GEN_UML_MENU__UML_METACLASS:
			return umlMetaclass != null;
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
		if (baseClass == GenMenuTarget.class) {
			switch (derivedFeatureID) {
			case ZDLGenPackage.GEN_UML_MENU__MENU:
				return ZDLGenPackage.GEN_MENU_TARGET__MENU;
			default:
				return -1;
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
		if (baseClass == GenMenuTarget.class) {
			switch (baseFeatureID) {
			case ZDLGenPackage.GEN_MENU_TARGET__MENU:
				return ZDLGenPackage.GEN_UML_MENU__MENU;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GenUMLMenuImpl
