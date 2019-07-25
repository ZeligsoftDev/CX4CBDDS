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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FileDependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.FileDependency#getFilename <em>Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getFileDependency()
 * @model abstract="true"
 * @generated
 */
public interface FileDependency extends Dependency {

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' reference.
	 * @see #setFilename(FileName)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getFileDependency_Filename()
	 * @model required="true"
	 * @generated
	 */
	FileName getFilename();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.FileDependency#getFilename <em>Filename</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' reference.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(FileName value);
} // FileDependency
