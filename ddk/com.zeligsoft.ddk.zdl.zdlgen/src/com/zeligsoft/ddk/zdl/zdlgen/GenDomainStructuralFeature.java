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

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getUmlMetaattribute <em>Uml Metaattribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getConcept <em>Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getDomainAttribute <em>Domain Attribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainStructuralFeature()
 * @model abstract="true"
 * @generated
 */
public interface GenDomainStructuralFeature extends GenDomainNamedElement, GenDomainAttributePresentation {

	/**
	 * Returns the value of the '<em><b>Uml Metaattribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Metaattribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Metaattribute</em>' reference.
	 * @see #setUmlMetaattribute(Property)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainStructuralFeature_UmlMetaattribute()
	 * @model
	 * @generated
	 */
	Property getUmlMetaattribute();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getUmlMetaattribute <em>Uml Metaattribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Metaattribute</em>' reference.
	 * @see #getUmlMetaattribute()
	 * @generated
	 */
	void setUmlMetaattribute(Property value);

	/**
	 * Returns the value of the '<em><b>Domain Attribute</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Attribute</em>' reference.
	 * @see #setDomainAttribute(Property)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainStructuralFeature_DomainAttribute()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Property getDomainAttribute();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getDomainAttribute <em>Domain Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Attribute</em>' reference.
	 * @see #getDomainAttribute()
	 * @generated
	 */
	void setDomainAttribute(Property value);

	/**
	 * Returns the value of the '<em><b>Is Rhapsody Suppressed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Rhapsody Suppressed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Rhapsody Suppressed</em>' attribute.
	 * @see #setIsRhapsodySuppressed(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainStructuralFeature_IsRhapsodySuppressed()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isRhapsodySuppressed();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Rhapsody Suppressed</em>' attribute.
	 * @see #isRhapsodySuppressed()
	 * @generated
	 */
	void setIsRhapsodySuppressed(boolean value);

	/**
	 * Returns the value of the '<em><b>Concept</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwner() <em>Owner</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concept</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept</em>' reference.
	 * @see #setConcept(GenDomainConcept)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainStructuralFeature_Concept()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	GenDomainConcept getConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature#getConcept <em>Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concept</em>' reference.
	 * @see #getConcept()
	 * @generated
	 */
	void setConcept(GenDomainConcept value);

} // GenDomainStructuralFeature
