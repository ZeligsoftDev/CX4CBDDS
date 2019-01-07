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
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.Function#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Function#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Function#getLinkage <em>Linkage</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Function#getDefaultImpl <em>Default Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(ElementReference)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getFunction_ReturnType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementReference getReturnType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.Function#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.NamedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedReference> getParameters();

	/**
	 * Returns the value of the '<em><b>Linkage</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link com.zeligsoft.cx.langc.LinkageSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkage</em>' attribute.
	 * @see com.zeligsoft.cx.langc.LinkageSpec
	 * @see #setLinkage(LinkageSpec)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getFunction_Linkage()
	 * @model default=""
	 * @generated
	 */
	LinkageSpec getLinkage();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.Function#getLinkage <em>Linkage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkage</em>' attribute.
	 * @see com.zeligsoft.cx.langc.LinkageSpec
	 * @see #getLinkage()
	 * @generated
	 */
	void setLinkage(LinkageSpec value);

	/**
	 * Returns the value of the '<em><b>Default Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Impl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Impl</em>' containment reference.
	 * @see #setDefaultImpl(FunctionImplementation)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getFunction_DefaultImpl()
	 * @model containment="true"
	 * @generated
	 */
	FunctionImplementation getDefaultImpl();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.Function#getDefaultImpl <em>Default Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Impl</em>' containment reference.
	 * @see #getDefaultImpl()
	 * @generated
	 */
	void setDefaultImpl(FunctionImplementation value);

} // Function
