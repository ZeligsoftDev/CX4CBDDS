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
 * A representation of the model object '<em><b>Gen Domain Model Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary#getDomainModelLibrary <em>Domain Model Library</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainModelLibrary()
 * @model
 * @generated
 */
public interface GenDomainModelLibrary extends GenDomainPackageableElement {

	/**
	 * Returns the value of the '<em><b>Domain Model Library</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Model Library</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Model Library</em>' reference.
	 * @see #setDomainModelLibrary(org.eclipse.uml2.uml.Package)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainModelLibrary_DomainModelLibrary()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getDomainModelLibrary();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibrary#getDomainModelLibrary <em>Domain Model Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Model Library</em>' reference.
	 * @see #getDomainModelLibrary()
	 * @generated
	 */
	void setDomainModelLibrary(org.eclipse.uml2.uml.Package value);

} // GenDomainModelLibrary
