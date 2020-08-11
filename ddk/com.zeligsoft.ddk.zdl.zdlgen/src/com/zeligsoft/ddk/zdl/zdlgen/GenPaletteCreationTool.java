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
 * A representation of the model object '<em><b>Gen Palette Creation Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getElementTypeHint <em>Element Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getExpressions <em>Expression</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteCreationTool()
 * @model
 * @generated
 */
public interface GenPaletteCreationTool extends GenPaletteTool {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(GenPalettable)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteCreationTool_Type()
	 * @model ordered="false"
	 * @generated
	 */
	GenPalettable getType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(GenPalettable value);

	/**
	 * Returns the value of the '<em><b>Element Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Hint</em>' attribute.
	 * @see #setElementTypeHint(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteCreationTool_ElementTypeHint()
	 * @model ordered="false"
	 * @generated
	 */
	String getElementTypeHint();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteCreationTool#getElementTypeHint <em>Element Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Hint</em>' attribute.
	 * @see #getElementTypeHint()
	 * @generated
	 */
	void setElementTypeHint(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteCreationTool_Expression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // GenPaletteCreationTool
