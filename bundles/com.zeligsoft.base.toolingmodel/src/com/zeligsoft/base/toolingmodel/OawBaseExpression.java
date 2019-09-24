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
package com.zeligsoft.base.toolingmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Oaw Base Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.OawBaseExpression#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getOawBaseExpression()
 * @model abstract="true"
 * @generated
 */
public interface OawBaseExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getOawBaseExpression_Metamodel()
	 * @model
	 * @generated
	 */
	EList<String> getMetamodel();

} // OawBaseExpression
