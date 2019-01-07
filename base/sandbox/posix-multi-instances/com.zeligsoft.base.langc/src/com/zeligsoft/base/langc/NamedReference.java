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

import com.zeligsoft.base.langc.m2t.IWritable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Reference</b></em>'.
 * @extends IWritable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.NamedReference#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.NamedReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getNamedReference()
 * @model
 * @generated
 */
public interface NamedReference extends EObject, IWritable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #setName(Name)
	 * @see com.zeligsoft.base.langc.LangCPackage#getNamedReference_Name()
	 * @model required="true"
	 * @generated
	 */
	Name getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.NamedReference#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Name value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(ElementReference)
	 * @see com.zeligsoft.base.langc.LangCPackage#getNamedReference_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.NamedReference#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ElementReference value);

} // NamedReference
