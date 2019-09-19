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
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isVisible <em>Visible</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getContentHint <em>Content Hint</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getSection <em>Section</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends NamedElement, PropertiesObject {

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertyDefinition_ReadOnly()
	 * @model default="false"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see #setVisible(boolean)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertyDefinition_Visible()
	 * @model default="true"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#isVisible <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible</em>' attribute.
	 * @see #isVisible()
	 * @generated
	 */
	void setVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Content Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Hint</em>' attribute.
	 * @see #setContentHint(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertyDefinition_ContentHint()
	 * @model
	 * @generated
	 */
	String getContentHint();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getContentHint <em>Content Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Hint</em>' attribute.
	 * @see #getContentHint()
	 * @generated
	 */
	void setContentHint(String value);

	/**
	 * Returns the value of the '<em><b>Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' attribute.
	 * @see #setSection(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertyDefinition_Section()
	 * @model
	 * @generated
	 */
	String getSection();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertyDefinition#getSection <em>Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' attribute.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(String value);

} // PropertyDefinition
