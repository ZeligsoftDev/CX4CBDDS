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
 * A representation of the model object '<em><b>Gen Domain Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum#getLiterals <em>Literal</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainEnum()
 * @model
 * @generated
 */
public interface GenDomainEnum extends GenDomainDataType {

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainEnum_Literal()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainEnumLiteral> getLiterals();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} with the specified '<em><b>Name</b></em>' from the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getLiterals()
	 * @generated
	 */
	GenDomainEnumLiteral getLiteral(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} with the specified '<em><b>Name</b></em>' from the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getLiterals()
	 * @generated
	 */
	GenDomainEnumLiteral getLiteral(String name, boolean ignoreCase);

} // GenDomainEnum
