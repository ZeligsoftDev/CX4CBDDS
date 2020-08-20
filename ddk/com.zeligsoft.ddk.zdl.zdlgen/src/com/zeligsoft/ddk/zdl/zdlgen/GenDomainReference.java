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

import org.eclipse.uml2.uml.Association;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getSource <em>Source</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getDomainReference <em>Domain Reference</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainReference()
 * @model
 * @generated
 */
public interface GenDomainReference extends GenDomainStructuralFeature, GenPalettable {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GenDomainConcept)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainReference_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenDomainConcept getTarget();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GenDomainConcept value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getConcept() <em>Concept</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(GenDomainConcept)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainReference_Source()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	GenDomainConcept getSource();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(GenDomainConcept value);

	/**
	 * Returns the value of the '<em><b>Domain Reference</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Reference</em>' reference.
	 * @see #setDomainReference(Association)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainReference_DomainReference()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Association getDomainReference();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference#getDomainReference <em>Domain Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Reference</em>' reference.
	 * @see #getDomainReference()
	 * @generated
	 */
	void setDomainReference(Association value);

} // GenDomainReference
