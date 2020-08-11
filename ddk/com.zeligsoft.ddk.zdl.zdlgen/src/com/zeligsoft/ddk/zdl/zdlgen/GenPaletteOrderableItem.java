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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Palette Orderable Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteOrderableItem#getPrecedents <em>Precedent</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteOrderableItem()
 * @model abstract="true"
 * @generated
 */
public interface GenPaletteOrderableItem
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Precedent</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteOrderableItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedent</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteOrderableItem_Precedent()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<GenPaletteOrderableItem> getPrecedents();

} // GenPaletteOrderableItem
