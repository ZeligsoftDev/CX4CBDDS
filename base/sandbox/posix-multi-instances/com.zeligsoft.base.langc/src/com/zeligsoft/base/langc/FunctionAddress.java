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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.FunctionAddress#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getFunctionAddress()
 * @model
 * @generated
 */
public interface FunctionAddress extends Expression {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see com.zeligsoft.base.langc.LangCPackage#getFunctionAddress_Function()
	 * @model required="true"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.FunctionAddress#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

} // FunctionAddress
