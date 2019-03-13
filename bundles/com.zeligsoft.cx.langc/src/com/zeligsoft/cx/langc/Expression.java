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

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.cx.codegen.io.IWritable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * @extends IWritable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.Expression#getType <em>Type</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.Expression#getPrecendence <em>Precendence</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject, IWritable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getExpression_Type()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Returns the value of the '<em><b>Precendence</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Return the level of precedence as described at http://www.difranco.net/cop2220/op-prec.htm.
	 * This value is used when determining the parenthesis.  42 is the highest 50 is unknown. 
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precendence</em>' attribute.
	 * @see com.zeligsoft.cx.langc.LangCPackage#getExpression_Precendence()
	 * @model default="50" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getPrecendence();

} // Expression
