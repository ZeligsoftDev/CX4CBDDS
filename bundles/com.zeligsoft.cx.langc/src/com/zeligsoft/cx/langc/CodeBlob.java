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
 * A representation of the model object '<em><b>Code Blob</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.CodeBlob#getText <em>Text</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.CodeBlob#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.CodeBlob#getMarkerComment <em>Marker Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlob()
 * @model
 * @generated
 */
public interface CodeBlob extends CodeBlock {
	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference.
	 * @see #setDependencies(DependencyBlob)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlob_Dependencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DependencyBlob getDependencies();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.CodeBlob#getDependencies <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' containment reference.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(DependencyBlob value);

	/**
	 * Returns the value of the '<em><b>Marker Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marker Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marker Comment</em>' attribute.
	 * @see #setMarkerComment(String)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlob_MarkerComment()
	 * @model
	 * @generated
	 */
	String getMarkerComment();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.CodeBlob#getMarkerComment <em>Marker Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marker Comment</em>' attribute.
	 * @see #getMarkerComment()
	 * @generated
	 */
	void setMarkerComment(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getCodeBlob_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.CodeBlob#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // CodeBlob
