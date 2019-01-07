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
 * A representation of the model object '<em><b>Switch Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.SwitchClause#isFallthrough <em>Fallthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getSwitchClause()
 * @model
 * @generated
 */
public interface SwitchClause extends CodeBlock {

	/**
	 * Returns the value of the '<em><b>Fallthrough</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fallthrough</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallthrough</em>' attribute.
	 * @see #setFallthrough(boolean)
	 * @see com.zeligsoft.base.langc.LangCPackage#getSwitchClause_Fallthrough()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFallthrough();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.SwitchClause#isFallthrough <em>Fallthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallthrough</em>' attribute.
	 * @see #isFallthrough()
	 * @generated
	 */
	void setFallthrough(boolean value);
} // SwitchClause
