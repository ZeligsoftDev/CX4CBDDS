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

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.langc.m2t.IWritableType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * @extends IWritableType
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.Element#getWritten <em>Written</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject, IWritableType {

	/**
	 * Returns the value of the '<em><b>Written</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Written</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Written</em>' attribute.
	 * @see #setWritten(Boolean)
	 * @see com.zeligsoft.base.langc.LangCPackage#getElement_Written()
	 * @model default="false"
	 * @generated
	 */
	Boolean getWritten();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.Element#getWritten <em>Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Written</em>' attribute.
	 * @see #getWritten()
	 * @generated
	 */
	void setWritten(Boolean value);
	/* empty */
} // Element
