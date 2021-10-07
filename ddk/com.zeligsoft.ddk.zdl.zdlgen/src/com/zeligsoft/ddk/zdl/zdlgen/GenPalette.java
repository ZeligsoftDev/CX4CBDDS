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
 * A representation of the model object '<em><b>Gen Palette</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getOwnedDrawers <em>Owned Drawer</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getDrawers <em>Drawer</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPalette()
 * @model
 * @generated
 */
public interface GenPalette extends GenPaletteItem {

	/**
	 * Returns the value of the '<em><b>Owned Drawer</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenPalette#getDrawers() <em>Drawer</em>}'</li>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Drawer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Drawer</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPalette_OwnedDrawer()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenPaletteDrawer> getOwnedDrawers();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Drawer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedDrawers()
	 * @generated
	 */
	GenPaletteDrawer getOwnedDrawer(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Drawer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedDrawers()
	 * @generated
	 */
	GenPaletteDrawer getOwnedDrawer(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Drawer</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawer</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenPalette_Drawer()
	 * @model
	 * @generated
	 */
	EList<GenPaletteDrawer> getDrawers();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>' from the '<em><b>Drawer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDrawers()
	 * @generated
	 */
	GenPaletteDrawer getDrawer(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>' from the '<em><b>Drawer</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDrawers()
	 * @generated
	 */
	GenPaletteDrawer getDrawer(String name, boolean ignoreCase);

} // GenPalette
