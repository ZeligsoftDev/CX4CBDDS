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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.langc.System#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.System#getPublicFolders <em>Public Folders</em>}</li>
 *   <li>{@link com.zeligsoft.base.langc.System#getArtifacts <em>Artifacts</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.langc.LangCPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Systems</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.SubSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Systems</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getSystem_SubSystems()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubSystem> getSubSystems();

	/**
	 * Returns the value of the '<em><b>Public Folders</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.FolderName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Folders</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Folders</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getSystem_PublicFolders()
	 * @model containment="true"
	 * @generated
	 */
	EList<FolderName> getPublicFolders();

	/**
	 * Returns the value of the '<em><b>Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.langc.LinkableArtifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifacts</em>' containment reference list.
	 * @see com.zeligsoft.base.langc.LangCPackage#getSystem_Artifacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkableArtifact> getArtifacts();

} // System
