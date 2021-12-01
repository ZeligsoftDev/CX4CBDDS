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
 * A representation of the model object '<em><b>Gen Menu Create Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getTypeHint <em>Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getCreateConcept <em>Create Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getExpressions <em>Expression</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuCreateAction()
 * @model
 * @generated
 */
public interface GenMenuCreateAction extends GenMenuAction {
	/**
	 * Returns the value of the '<em><b>Type Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Hint</em>' attribute.
	 * @see #setTypeHint(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuCreateAction_TypeHint()
	 * @model ordered="false"
	 * @generated
	 */
	String getTypeHint();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getTypeHint <em>Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Hint</em>' attribute.
	 * @see #getTypeHint()
	 * @generated
	 */
	void setTypeHint(String value);

	/**
	 * Returns the value of the '<em><b>Create Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Concept</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Concept</em>' reference.
	 * @see #setCreateConcept(GenDomainConcept)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuCreateAction_CreateConcept()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenDomainConcept getCreateConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuCreateAction#getCreateConcept <em>Create Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Concept</em>' reference.
	 * @see #getCreateConcept()
	 * @generated
	 */
	void setCreateConcept(GenDomainConcept value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenMenuCreateAction_Expression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // GenMenuCreateAction
