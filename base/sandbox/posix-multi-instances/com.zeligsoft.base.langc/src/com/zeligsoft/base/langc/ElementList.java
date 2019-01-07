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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.langc.m2t.IWritableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration Context</b></em>'.
 * @extends IWritableElement
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getElements <em>Elements</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getDeclIncludes <em>Decl Includes</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getDefnIncludes <em>Defn Includes</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getPublicDirectives <em>Public Directives</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.ElementList#getPrivateDirectives <em>Private Directives</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getElementList()
 * @model
 * @generated
 */
public interface ElementList extends EObject, IWritableElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.UserElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserElement> getElements();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(FileName)
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FileName getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.ElementList#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(FileName value);

	/**
	 * Returns the value of the '<em><b>Decl Includes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decl Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decl Includes</em>' containment reference.
	 * @see #setDeclIncludes(DependencyList)
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_DeclIncludes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DependencyList getDeclIncludes();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.ElementList#getDeclIncludes <em>Decl Includes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decl Includes</em>' containment reference.
	 * @see #getDeclIncludes()
	 * @generated
	 */
	void setDeclIncludes(DependencyList value);

	/**
	 * Returns the value of the '<em><b>Defn Includes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defn Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defn Includes</em>' containment reference.
	 * @see #setDefnIncludes(DependencyList)
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_DefnIncludes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DependencyList getDefnIncludes();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.langc.ElementList#getDefnIncludes <em>Defn Includes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defn Includes</em>' containment reference.
	 * @see #getDefnIncludes()
	 * @generated
	 */
	void setDefnIncludes(DependencyList value);

	/**
	 * Returns the value of the '<em><b>Public Directives</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.Directive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Directives</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Directives</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_PublicDirectives()
	 * @model containment="true"
	 * @generated
	 */
	EList<Directive> getPublicDirectives();

	/**
	 * Returns the value of the '<em><b>Private Directives</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.Directive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Private Directives</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Private Directives</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getElementList_PrivateDirectives()
	 * @model containment="true"
	 * @generated
	 */
	EList<Directive> getPrivateDirectives();

} // DeclarationContext
