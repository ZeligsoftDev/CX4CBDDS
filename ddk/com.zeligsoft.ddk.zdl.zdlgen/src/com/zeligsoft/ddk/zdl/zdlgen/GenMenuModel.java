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
package com.zeligsoft.ddk.zdl.zdlgen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Menu Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getItems <em>Items</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuModel#getUmlMeni <em>Uml Menus</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuModel()
 * @model
 * @generated
 */
public interface GenMenuModel extends GenDomainObject {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuModel_Items()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<GenMenuItem> getItems();

	/**
	 * Returns the value of the '<em><b>Uml Menus</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Menus</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Menus</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuModel_UmlMenus()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<GenUMLMenu> getUmlMeni();

} // GenMenuModel
