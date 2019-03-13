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
 * A representation of the model object '<em><b>Linkable Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.LinkableArtifact#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.LinkableArtifact#getFunctionImplementations <em>Function Implementations</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.LinkableArtifact#getRootElements <em>Root Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getLinkableArtifact()
 * @model
 * @generated
 */
public interface LinkableArtifact extends EObject {
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
	 * @see com.zeligsoft.cx.langc.LangCPackage#getLinkableArtifact_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.LinkableArtifact#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Function Implementations</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.FunctionImplementation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Implementations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Implementations</em>' reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getLinkableArtifact_FunctionImplementations()
	 * @model
	 * @generated
	 */
	EList<FunctionImplementation> getFunctionImplementations();

	/**
	 * Returns the value of the '<em><b>Root Elements</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.UserElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Elements</em>' reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getLinkableArtifact_RootElements()
	 * @model
	 * @generated
	 */
	EList<UserElement> getRootElements();

} // LinkableArtifact
