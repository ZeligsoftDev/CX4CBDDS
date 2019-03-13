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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textual Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getWidth <em>Width</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getNumRows <em>Num Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getTextualDefinition()
 * @model
 * @generated
 */
public interface TextualDefinition extends PrimitiveDefinition {

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * The default value is <code>"150"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(short)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getTextualDefinition_Width()
	 * @model default="150"
	 * @generated
	 */
	short getWidth();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(short value);

	/**
	 * Returns the value of the '<em><b>Num Rows</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Rows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Rows</em>' attribute.
	 * @see #setNumRows(short)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getTextualDefinition_NumRows()
	 * @model default="1"
	 * @generated
	 */
	short getNumRows();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.TextualDefinition#getNumRows <em>Num Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Rows</em>' attribute.
	 * @see #getNumRows()
	 * @generated
	 */
	void setNumRows(short value);

} // TextualDefinition
