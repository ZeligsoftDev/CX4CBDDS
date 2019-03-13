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
 * A representation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.MenuItem#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.MenuItem#getDescription <em>Description</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.MenuItem#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuItem()
 * @model abstract="true"
 * @generated
 */
public interface MenuItem extends MenuObject {
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
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuItem_Name()
	 * @model dataType="org.eclipse.uml2.uml.String" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.MenuItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuItem_Description()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.MenuItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.base.toolingmodel.Menu#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Menu)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuItem_Container()
	 * @see com.zeligsoft.base.toolingmodel.Menu#getItem
	 * @model opposite="item" transient="false"
	 * @generated
	 */
	Menu getContainer();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.MenuItem#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Menu value);

} // MenuItem
