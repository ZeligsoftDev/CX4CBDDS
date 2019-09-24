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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Oaw Xtend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.OawXtend#getExtensionFile <em>Extension File</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getOawXtend()
 * @model
 * @generated
 */
public interface OawXtend extends OawBaseExpression {
	/**
	 * Returns the value of the '<em><b>Extension File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension File</em>' attribute.
	 * @see #setExtensionFile(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getOawXtend_ExtensionFile()
	 * @model required="true"
	 * @generated
	 */
	String getExtensionFile();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.OawXtend#getExtensionFile <em>Extension File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension File</em>' attribute.
	 * @see #getExtensionFile()
	 * @generated
	 */
	void setExtensionFile(String value);

} // OawXtend
