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
 * A representation of the model object '<em><b>Integral Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.IntegralLiteral#getValue <em>Value</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.IntegralLiteral#getBytes <em>Bytes</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.IntegralLiteral#isSigned <em>Signed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getIntegralLiteral()
 * @model
 * @generated
 */
public interface IntegralLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getIntegralLiteral_Value()
	 * @model required="true"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.IntegralLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

	/**
	 * Returns the value of the '<em><b>Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bytes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bytes</em>' attribute.
	 * @see #setBytes(byte)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getIntegralLiteral_Bytes()
	 * @model required="true"
	 * @generated
	 */
	byte getBytes();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.IntegralLiteral#getBytes <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bytes</em>' attribute.
	 * @see #getBytes()
	 * @generated
	 */
	void setBytes(byte value);

	/**
	 * Returns the value of the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signed</em>' attribute.
	 * @see #setSigned(boolean)
	 * @see com.zeligsoft.cx.langc.LangCPackage#getIntegralLiteral_Signed()
	 * @model required="true"
	 * @generated
	 */
	boolean isSigned();

	/**
	 * Sets the value of the '{@link com.zeligsoft.cx.langc.IntegralLiteral#isSigned <em>Signed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signed</em>' attribute.
	 * @see #isSigned()
	 * @generated
	 */
	void setSigned(boolean value);

} // IntegralLiteral
