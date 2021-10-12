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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Palette Tool Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getOwnedTools <em>Owned Tool</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTools <em>Tool</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTargetDiagrams <em>Target Diagram</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteToolContainer()
 * @model abstract="true"
 * @generated
 */
public interface GenPaletteToolContainer extends GenPaletteItem {

	/**
	 * Returns the value of the '<em><b>Owned Tool</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer#getTools() <em>Tool</em>}'</li>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tool</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tool</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteToolContainer_OwnedTool()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenPaletteTool> getOwnedTools();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedTools()
	 * @generated
	 */
	GenPaletteTool getOwnedTool(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Tool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedTools()
	 * @generated
	 */
	GenPaletteTool getOwnedTool(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Tool</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteToolContainer_Tool()
	 * @model
	 * @generated
	 */
	EList<GenPaletteTool> getTools();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>' from the '<em><b>Tool</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTools()
	 * @generated
	 */
	GenPaletteTool getTool(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>' from the '<em><b>Tool</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTools()
	 * @generated
	 */
	GenPaletteTool getTool(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Target Diagram</b></em>' attribute list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind}.
	 * The literals are from the enumeration {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Diagram</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Diagram</em>' attribute list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPaletteToolContainer_TargetDiagram()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenPaletteDiagramKind> getTargetDiagrams();

} // GenPaletteToolContainer
