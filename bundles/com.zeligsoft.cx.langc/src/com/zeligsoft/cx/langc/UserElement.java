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

import com.zeligsoft.cx.langc.m2t.IWritableElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Element</b></em>'.
 * @extends IWritableElement
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.UserElement#getKind <em>Kind</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.UserElement#getDefn <em>Defn</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getUserElement()
 * @model abstract="true"
 * @generated
 */
public interface UserElement extends Element, IWritableElement {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.cx.langc.ElementKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.zeligsoft.cx.langc.ElementKind
	 * @see #setKind(ElementKind)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getUserElement_Kind()
	 * @model
	 * @generated
	 */
	ElementKind getKind();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.UserElement#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.zeligsoft.cx.langc.ElementKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ElementKind value);

	/**
	 * Returns the value of the '<em><b>Defn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defn</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defn</em>' reference.
	 * @see #setDefn(FileName)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getUserElement_Defn()
	 * @model
	 * @generated
	 */
	FileName getDefn();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.UserElement#getDefn <em>Defn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defn</em>' reference.
	 * @see #getDefn()
	 * @generated
	 */
	void setDefn(FileName value);

} // UserElement
