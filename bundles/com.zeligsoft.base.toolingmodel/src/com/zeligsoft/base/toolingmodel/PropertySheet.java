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
 * A representation of the model object '<em><b>Property Sheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySheet#getDomainModelURI <em>Domain Model URI</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySheet#getPropertySource <em>Property Source</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.PropertySheet#getPropertyDefinition <em>Property Definition</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySheet()
 * @model
 * @generated
 */
public interface PropertySheet extends PropertiesObject {

	/**
	 * Returns the value of the '<em><b>Domain Model URI</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Model URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Model URI</em>' attribute.
	 * @see #setDomainModelURI(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySheet_DomainModelURI()
	 * @model default=""
	 * @generated
	 */
	String getDomainModelURI();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.PropertySheet#getDomainModelURI <em>Domain Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Model URI</em>' attribute.
	 * @see #getDomainModelURI()
	 * @generated
	 */
	void setDomainModelURI(String value);

	/**
	 * Returns the value of the '<em><b>Property Source</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.PropertySource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Source</em>' containment reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySheet_PropertySource()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PropertySource> getPropertySource();

	/**
	 * Returns the value of the '<em><b>Property Definition</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.PropertyDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Definition</em>' containment reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getPropertySheet_PropertyDefinition()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PropertyDefinition> getPropertyDefinition();

} // PropertySheet
