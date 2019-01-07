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

import com.zeligsoft.cx.codegen.io.CodeWriter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.ElementReference#getElement <em>Element</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.ElementReference#getCvQualifier <em>Cv Qualifier</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.ElementReference#getPointerSpec <em>Pointer Spec</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.ElementReference#getArrayBounds <em>Array Bounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getElementReference()
 * @model
 * @generated
 */
public interface ElementReference extends BindableValue {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Element)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getElementReference_Element()
	 * @model required="true"
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.ElementReference#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Cv Qualifier</b></em>' attribute.
	 * The default value is <code>"unqualified"</code>.
	 * The literals are from the enumeration {@link com.zeligsoft.cx.langc.CVQualifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cv Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cv Qualifier</em>' attribute.
	 * @see com.zeligsoft.cx.langc.CVQualifier
	 * @see #setCvQualifier(CVQualifier)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getElementReference_CvQualifier()
	 * @model default="unqualified"
	 * @generated
	 */
	CVQualifier getCvQualifier();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.ElementReference#getCvQualifier <em>Cv Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cv Qualifier</em>' attribute.
	 * @see com.zeligsoft.cx.langc.CVQualifier
	 * @see #getCvQualifier()
	 * @generated
	 */
	void setCvQualifier(CVQualifier value);

	/**
	 * Returns the value of the '<em><b>Pointer Spec</b></em>' attribute list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.Pointer}.
	 * The literals are from the enumeration {@link com.zeligsoft.cx.langc.Pointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointer Spec</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointer Spec</em>' attribute list.
	 * @see com.zeligsoft.cx.langc.Pointer
	 * @see com.zeligsoft.cx.langc.LangCPackage#getElementReference_PointerSpec()
	 * @model default="invalid" unique="false"
	 * @generated
	 */
	EList<Pointer> getPointerSpec();

	/**
	 * Returns the value of the '<em><b>Array Bounds</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.cx.langc.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Bounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Bounds</em>' containment reference list.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getElementReference_ArrayBounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArrayBounds();

	/**
	 * @param name may be null
	 */
	boolean write(CodeWriter code, String name);

} // ElementReference
