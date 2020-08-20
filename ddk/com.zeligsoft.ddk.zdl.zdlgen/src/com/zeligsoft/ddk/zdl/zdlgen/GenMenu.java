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
 * A representation of the model object '<em><b>Gen Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getExtends <em>Extends</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getItems <em>Item</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenu()
 * @model
 * @generated
 */
public interface GenMenu extends GenMenuItem {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenu_Item()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenMenuItem> getItems();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(GenMenu)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenu_Extends()
	 * @model ordered="false"
	 * @generated
	 */
	GenMenu getExtends();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenu#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(GenMenu value);

} // GenMenu
