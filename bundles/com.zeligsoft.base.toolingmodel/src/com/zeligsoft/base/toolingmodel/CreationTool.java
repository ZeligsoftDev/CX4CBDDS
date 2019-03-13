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
 * A representation of the model object '<em><b>Creation Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreationTool#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreationTool#getElementTypeHint <em>Element Type Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.CreationTool#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreationTool()
 * @model
 * @generated
 */
public interface CreationTool extends Tool {

	/**
	 * Returns the value of the '<em><b>Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concept</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept</em>' reference.
	 * @see #setConcept(org.eclipse.uml2.uml.Class)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreationTool_Concept()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.CreationTool#getConcept <em>Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concept</em>' reference.
	 * @see #getConcept()
	 * @generated
	 */
	void setConcept(org.eclipse.uml2.uml.Class value);

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
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreationTool_ElementTypeHint()
	 * @model
	 * @generated
	 */
	String getElementTypeHint();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.CreationTool#getElementTypeHint <em>Element Type Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Hint</em>' attribute.
	 * @see #getElementTypeHint()
	 * @generated
	 */
	void setElementTypeHint(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getCreationTool_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpression();

} // CreationTool
