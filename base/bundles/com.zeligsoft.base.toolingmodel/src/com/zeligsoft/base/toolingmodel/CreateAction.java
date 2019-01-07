/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.base.toolingmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreateAction#getCreateConcept <em>Create Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreateAction#getTypeHint <em>Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreateAction#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreateAction()
 * @model
 * @generated
 */
public interface CreateAction extends MenuAction {
	/**
	 * Returns the value of the '<em><b>Create Concept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Concept</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Concept</em>' attribute.
	 * @see #setCreateConcept(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreateAction_CreateConcept()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getCreateConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.CreateAction#getCreateConcept <em>Create Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Concept</em>' attribute.
	 * @see #getCreateConcept()
	 * @generated
	 */
	void setCreateConcept(String value);

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
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreateAction_TypeHint()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getTypeHint();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.CreateAction#getTypeHint <em>Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Hint</em>' attribute.
	 * @see #getTypeHint()
	 * @generated
	 */
	void setTypeHint(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreateAction_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpression();

} // CreateAction
