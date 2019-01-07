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
 * A representation of the model object '<em><b>Menu Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.MenuInstance#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.MenuInstance#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuInstance()
 * @model
 * @generated
 */
public interface MenuInstance extends MenuObject {
	/**
	 * Returns the value of the '<em><b>Concept</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concept</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept</em>' attribute.
	 * @see #setConcept(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuInstance_Concept()
	 * @model dataType="org.eclipse.uml2.uml.String" required="true"
	 * @generated
	 */
	String getConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.MenuInstance#getConcept <em>Concept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concept</em>' attribute.
	 * @see #getConcept()
	 * @generated
	 */
	void setConcept(String value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.base.toolingmodel.MenuItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference list.
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getMenuInstance_Item()
	 * @model
	 * @generated
	 */
	EList<MenuItem> getItem();

} // MenuInstance
