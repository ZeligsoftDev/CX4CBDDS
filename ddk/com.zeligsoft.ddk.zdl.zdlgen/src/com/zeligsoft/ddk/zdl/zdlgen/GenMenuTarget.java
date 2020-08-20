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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Menu Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget#getMenu <em>Menu</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuTarget()
 * @model abstract="true"
 * @generated
 */
public interface GenMenuTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Menu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu</em>' reference.
	 * @see #setMenu(GenMenu)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuTarget_Menu()
	 * @model ordered="false"
	 * @generated
	 */
	GenMenu getMenu();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuTarget#getMenu <em>Menu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Menu</em>' reference.
	 * @see #getMenu()
	 * @generated
	 */
	void setMenu(GenMenu value);

} // GenMenuTarget
