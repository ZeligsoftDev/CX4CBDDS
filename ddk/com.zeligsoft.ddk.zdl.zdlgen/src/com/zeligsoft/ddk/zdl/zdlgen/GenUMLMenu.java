/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen UML Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu#getUmlMetaclass <em>Uml Metaclass</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenUMLMenu()
 * @model
 * @generated
 */
public interface GenUMLMenu extends GenDomainObject, GenMenuTarget {
	/**
	 * Returns the value of the '<em><b>Uml Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Metaclass</em>' reference.
	 * @see #setUmlMetaclass(org.eclipse.uml2.uml.Class)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenUMLMenu_UmlMetaclass()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getUmlMetaclass();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu#getUmlMetaclass <em>Uml Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Metaclass</em>' reference.
	 * @see #getUmlMetaclass()
	 * @generated
	 */
	void setUmlMetaclass(org.eclipse.uml2.uml.Class value);

} // GenUMLMenu
