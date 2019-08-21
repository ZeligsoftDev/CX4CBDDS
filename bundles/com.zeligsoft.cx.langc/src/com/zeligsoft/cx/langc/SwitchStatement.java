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
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.SwitchStatement#getClauses <em>Clauses</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.SwitchStatement#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.SwitchClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clauses</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSwitchStatement_Clauses()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchClause> getClauses();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSwitchStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.SwitchStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

} // SwitchStatement
