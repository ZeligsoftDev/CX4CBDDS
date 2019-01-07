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
 * A representation of the model object '<em><b>Property Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySource#getDefinition <em>Definition</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySource#getConceptName <em>Concept Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySource#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySource()
 * @model
 * @generated
 */
public interface PropertySource extends PropertiesObject {

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.PropertyDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySource_Definition()
	 * @model required="true"
	 * @generated
	 */
	EList<PropertyDefinition> getDefinition();

	/**
	 * Returns the value of the '<em><b>Concept Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concept Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept Name</em>' attribute.
	 * @see #setConceptName(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySource_ConceptName()
	 * @model
	 * @generated
	 */
	String getConceptName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertySource#getConceptName <em>Concept Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concept Name</em>' attribute.
	 * @see #getConceptName()
	 * @generated
	 */
	void setConceptName(String value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * The default value is <code>"7326"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySource_Order()
	 * @model default="7326"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertySource#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

} // PropertySource
