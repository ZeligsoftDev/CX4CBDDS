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
package com.zeligsoft.base.langc;

import com.zeligsoft.base.langc.m2t.CodeWriter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.VariableDeclaration#getLinkage <em>Linkage</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.VariableDeclaration#getElement <em>Element</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.VariableDeclaration#getInitializer <em>Initializer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Linkage</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.base.langc.LinkageSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkage</em>' attribute.
	 * @see com.zeligsoft.base.langc.LinkageSpec
	 * @see #setLinkage(LinkageSpec)
	 * @see com.zeligsoft.base.langc.LangCPackage#getVariableDeclaration_Linkage()
	 * @model required="true"
	 * @generated
	 */
	LinkageSpec getLinkage();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.VariableDeclaration#getLinkage <em>Linkage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkage</em>' attribute.
	 * @see com.zeligsoft.base.langc.LinkageSpec
	 * @see #getLinkage()
	 * @generated
	 */
	void setLinkage(LinkageSpec value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(ElementReference)
	 * @see com.zeligsoft.base.langc.LangCPackage#getVariableDeclaration_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementReference getElement();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.VariableDeclaration#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(Expression)
	 * @see com.zeligsoft.base.langc.LangCPackage#getVariableDeclaration_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitializer();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.VariableDeclaration#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(Expression value);

	/**
	 * This is public to make it accessible from the var decl stmt's write method.
	 */
	public boolean writeDefn(CodeWriter code);

} // Variable
