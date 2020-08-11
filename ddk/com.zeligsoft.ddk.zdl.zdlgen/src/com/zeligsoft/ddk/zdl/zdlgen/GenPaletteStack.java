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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Palette Stack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack#getActiveTool <em>Active Tool</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteStack()
 * @model
 * @generated
 */
public interface GenPaletteStack extends GenPaletteToolContainer, GenPaletteTool {

	/**
	 * Returns the value of the '<em><b>Active Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Tool</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Tool</em>' reference.
	 * @see #setActiveTool(GenPaletteTool)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteStack_ActiveTool()
	 * @model ordered="false"
	 * @generated
	 */
	GenPaletteTool getActiveTool();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack#getActiveTool <em>Active Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Tool</em>' reference.
	 * @see #getActiveTool()
	 * @generated
	 */
	void setActiveTool(GenPaletteTool value);

} // GenPaletteStack
