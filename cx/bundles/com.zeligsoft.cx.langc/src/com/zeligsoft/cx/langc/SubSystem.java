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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.SubSystem#getFiles <em>Files</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.SubSystem#getFolders <em>Folders</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.SubSystem#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.SubSystem#getPublicFolders <em>Public Folders</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getSubSystem()
 * @model
 * @generated
 */
public interface SubSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Files</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.ElementList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSubSystem_Files()
	 * @model
	 * @generated
	 */
	EList<ElementList> getFiles();

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.FolderName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSubSystem_Folders()
	 * @model containment="true"
	 * @generated
	 */
	EList<FolderName> getFolders();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSubSystem_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.SubSystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Public Folders</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.FolderName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Folders</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getSubSystem_PublicFolders()
	 * @model containment="true"
	 * @generated
	 */
	EList<FolderName> getPublicFolders();

} // SubSystem
