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
package com.zeligsoft.cx.langc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.CodeBlock#getStatements <em>Statements</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.CodeBlock#isForceBraces <em>Force Braces</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlock()
 * @model
 * @generated
 */
public interface CodeBlock extends Statement {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlock_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

	/**
	 * Returns the value of the '<em><b>Force Braces</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force Braces</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force Braces</em>' attribute.
	 * @see #setForceBraces(boolean)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlock_ForceBraces()
	 * @model required="true"
	 * @generated
	 */
	boolean isForceBraces();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.CodeBlock#isForceBraces <em>Force Braces</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force Braces</em>' attribute.
	 * @see #isForceBraces()
	 * @generated
	 */
	void setForceBraces(boolean value);

} // CodeBlock
