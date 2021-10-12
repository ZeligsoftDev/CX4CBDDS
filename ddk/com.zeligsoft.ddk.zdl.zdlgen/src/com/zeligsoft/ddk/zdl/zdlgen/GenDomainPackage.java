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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getElements <em>Element</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getDomainPackage <em>Domain Package</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainPackage()
 * @model
 * @generated
 */
public interface GenDomainPackage extends GenDomainPackageableElement {

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainPackage_Element()
	 * @model containment="true"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainPackageableElement> getElements();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getElements()
	 * @generated
	 */
	GenDomainPackageableElement getElement(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getElements()
	 * @generated
	 */
	GenDomainPackageableElement getElement(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Domain Package</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Package</em>' reference.
	 * @see #setDomainPackage(org.eclipse.uml2.uml.Package)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainPackage_DomainPackage()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getDomainPackage();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage#getDomainPackage <em>Domain Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Package</em>' reference.
	 * @see #getDomainPackage()
	 * @generated
	 */
	void setDomainPackage(org.eclipse.uml2.uml.Package value);

} // GenDomainPackage
