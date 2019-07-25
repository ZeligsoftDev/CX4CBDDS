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
 * A representation of the model object '<em><b>Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.Macro#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Macro#getReplacement <em>Replacement</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Macro#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getMacro()
 * @model
 * @generated
 */
public interface Macro extends Directive, BindableValue {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.Name}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getMacro_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Name> getParameters();

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' containment reference.
	 * @see #setReplacement(Expression)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getMacro_Replacement()
	 * @model containment="true"
	 * @generated
	 */
	Expression getReplacement();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.Macro#getReplacement <em>Replacement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' containment reference.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(Expression value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(Name)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getMacro_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Name getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.Macro#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Name value);

} // Macro
