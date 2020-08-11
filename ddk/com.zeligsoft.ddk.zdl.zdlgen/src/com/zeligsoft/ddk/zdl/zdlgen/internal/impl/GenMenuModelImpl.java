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

import com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem;
import com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Menu Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl#getItems <em>Items</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenMenuModelImpl#getUmlMeni <em>Uml Menus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenMenuModelImpl extends GenDomainObjectImpl implements GenMenuModel {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<GenMenuItem> items;

	/**
	 * The cached value of the '{@link #getUmlMeni() <em>Uml Menus</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMeni()
	 * @generated
	 * @ordered
	 */
	protected EList<GenUMLMenu> umlMeni;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMenuModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_MENU_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenMenuItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<GenMenuItem>(GenMenuItem.class, this,
					ZDLGenPackage.GEN_MENU_MODEL__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenUMLMenu> getUmlMeni() {
		if (umlMeni == null) {
			umlMeni = new EObjectContainmentEList<GenUMLMenu>(GenUMLMenu.class, this,
					ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS);
		}
		return umlMeni;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_MODEL__ITEMS:
			return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
		case ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS:
			return ((InternalEList<?>) getUmlMeni()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_MODEL__ITEMS:
			return getItems();
		case ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS:
			return getUmlMeni();
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
		switch (featureID) {
		case ZDLGenPackage.GEN_MENU_MODEL__ITEMS:
			getItems().clear();
			getItems().addAll((Collection<? extends GenMenuItem>) newValue);
			return;
		case ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS:
			getUmlMeni().clear();
			getUmlMeni().addAll((Collection<? extends GenUMLMenu>) newValue);
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
		case ZDLGenPackage.GEN_MENU_MODEL__ITEMS:
			getItems().clear();
			return;
		case ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS:
			getUmlMeni().clear();
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
		case ZDLGenPackage.GEN_MENU_MODEL__ITEMS:
			return items != null && !items.isEmpty();
		case ZDLGenPackage.GEN_MENU_MODEL__UML_MENUS:
			return umlMeni != null && !umlMeni.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GenMenuModelImpl
