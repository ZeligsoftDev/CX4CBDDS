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

import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getDomainEnumLiteral <em>Domain Enum Literal</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainEnumLiteral()
 * @model
 * @generated
 */
public interface GenDomainEnumLiteral extends GenDomainNamedElement {

	/**
	 * Returns the value of the '<em><b>Domain Enum Literal</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Enum Literal</em>' reference.
	 * @see #setDomainEnumLiteral(EnumerationLiteral)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainEnumLiteral_DomainEnumLiteral()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EnumerationLiteral getDomainEnumLiteral();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getDomainEnumLiteral <em>Domain Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Enum Literal</em>' reference.
	 * @see #getDomainEnumLiteral()
	 * @generated
	 */
	void setDomainEnumLiteral(EnumerationLiteral value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum#getLiterals <em>Literal</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwner() <em>Owner</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(GenDomainEnum)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainEnumLiteral_Enumeration()
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnum#getLiterals
	 * @model opposite="literal" required="true" transient="false" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	GenDomainEnum getEnumeration();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainEnumLiteral#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(GenDomainEnum value);

} // GenDomainEnumLiteral
