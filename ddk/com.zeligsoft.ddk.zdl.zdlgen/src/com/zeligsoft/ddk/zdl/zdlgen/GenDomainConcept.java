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
 * A representation of the model object '<em><b>Gen Domain Concept</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getCategory <em>Category</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getFeatures <em>Feature</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getDomainConcept <em>Domain Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getUmlMetaclasses <em>Uml Metaclass</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getGenerals <em>General</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getReferences <em>Reference</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getAttributes <em>Attribute</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed <em>Is RSM Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyMetaclass <em>Rhapsody Metaclass</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyStereotypeName <em>Rhapsody Stereotype Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNews <em>Rhapsody Add New</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyAddNewConcepts <em>Rhapsody Add New Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyDisplayName <em>Rhapsody Display Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyToAddNews <em>Rhapsody To Add New</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getOverrides <em>Override</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept()
 * @model
 * @generated
 */
public interface GenDomainConcept extends GenDomainClassifier, GenMenuTarget, GenPalettable {

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory
	 * @see #setCategory(GenDomainConceptCategory)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenDomainConceptCategory getCategory();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainConceptCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(GenDomainConceptCategory value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Feature()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainStructuralFeature> getFeatures();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} with the specified '<em><b>Name</b></em>' from the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getFeatures()
	 * @generated
	 */
	GenDomainStructuralFeature getFeature(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} with the specified '<em><b>Name</b></em>' from the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainStructuralFeature} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getFeatures()
	 * @generated
	 */
	GenDomainStructuralFeature getFeature(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Generalization</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainGeneralization}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalization</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalization</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Generalization()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainGeneralization> getGeneralizations();

	/**
	 * Returns the value of the '<em><b>Domain Concept</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Concept</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Concept</em>' reference.
	 * @see #setDomainConcept(org.eclipse.uml2.uml.Class)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_DomainConcept()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getDomainConcept();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getDomainConcept <em>Domain Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Concept</em>' reference.
	 * @see #getDomainConcept()
	 * @generated
	 */
	void setDomainConcept(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Uml Metaclass</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Metaclass</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Metaclass</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_UmlMetaclass()
	 * @model
	 * @generated
	 */
	EList<org.eclipse.uml2.uml.Class> getUmlMetaclasses();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>' from the '<em><b>Uml Metaclass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getUmlMetaclasses()
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getUmlMetaclass(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>' from the '<em><b>Uml Metaclass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getUmlMetaclasses()
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getUmlMetaclass(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_General()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<GenDomainConcept> getGenerals();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getGenerals()
	 * @generated
	 */
	GenDomainConcept getGeneral(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>General</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getGenerals()
	 * @generated
	 */
	GenDomainConcept getGeneral(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getFeatures() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Reference()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainReference> getReferences();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} with the specified '<em><b>Name</b></em>' from the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getReferences()
	 * @generated
	 */
	GenDomainReference getReference(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} with the specified '<em><b>Name</b></em>' from the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainReference} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getReferences()
	 * @generated
	 */
	GenDomainReference getReference(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getFeatures() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Attribute()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainAttribute> getAttributes();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} with the specified '<em><b>Name</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getAttributes()
	 * @generated
	 */
	GenDomainAttribute getAttribute(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} with the specified '<em><b>Name</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getAttributes()
	 * @generated
	 */
	GenDomainAttribute getAttribute(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Uri</em>' attribute.
	 * @see #setIconUri(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_IconUri()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getIconUri();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getIconUri <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Uri</em>' attribute.
	 * @see #getIconUri()
	 * @generated
	 */
	void setIconUri(String value);

	/**
	 * Returns the value of the '<em><b>Is RSM Suppressed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is RSM Suppressed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is RSM Suppressed</em>' attribute.
	 * @see #isSetIsRSMSuppressed()
	 * @see #unsetIsRSMSuppressed()
	 * @see #setIsRSMSuppressed(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_IsRSMSuppressed()
	 * @model unsettable="true" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isRSMSuppressed();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed <em>Is RSM Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is RSM Suppressed</em>' attribute.
	 * @see #isSetIsRSMSuppressed()
	 * @see #unsetIsRSMSuppressed()
	 * @see #isRSMSuppressed()
	 * @generated
	 */
	void setIsRSMSuppressed(boolean value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed <em>Is RSM Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRSMSuppressed()
	 * @see #isRSMSuppressed()
	 * @see #setIsRSMSuppressed(boolean)
	 * @generated
	 */
	void unsetIsRSMSuppressed();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMSuppressed <em>Is RSM Suppressed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is RSM Suppressed</em>' attribute is set.
	 * @see #unsetIsRSMSuppressed()
	 * @see #isRSMSuppressed()
	 * @see #setIsRSMSuppressed(boolean)
	 * @generated
	 */
	boolean isSetIsRSMSuppressed();

	/**
	 * Returns the value of the '<em><b>Is RSMUI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is RSMUI Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is RSMUI Read Only</em>' attribute.
	 * @see #isSetIsRSMUIReadOnly()
	 * @see #unsetIsRSMUIReadOnly()
	 * @see #setIsRSMUIReadOnly(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_IsRSMUIReadOnly()
	 * @model unsettable="true" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isRSMUIReadOnly();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is RSMUI Read Only</em>' attribute.
	 * @see #isSetIsRSMUIReadOnly()
	 * @see #unsetIsRSMUIReadOnly()
	 * @see #isRSMUIReadOnly()
	 * @generated
	 */
	void setIsRSMUIReadOnly(boolean value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRSMUIReadOnly()
	 * @see #isRSMUIReadOnly()
	 * @see #setIsRSMUIReadOnly(boolean)
	 * @generated
	 */
	void unsetIsRSMUIReadOnly();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMUIReadOnly <em>Is RSMUI Read Only</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is RSMUI Read Only</em>' attribute is set.
	 * @see #unsetIsRSMUIReadOnly()
	 * @see #isRSMUIReadOnly()
	 * @see #setIsRSMUIReadOnly(boolean)
	 * @generated
	 */
	boolean isSetIsRSMUIReadOnly();

	/**
	 * Returns the value of the '<em><b>Is RSM Properties UI Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is RSM Properties UI Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is RSM Properties UI Read Only</em>' attribute.
	 * @see #isSetIsRSMPropertiesUIReadOnly()
	 * @see #unsetIsRSMPropertiesUIReadOnly()
	 * @see #setIsRSMPropertiesUIReadOnly(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_IsRSMPropertiesUIReadOnly()
	 * @model unsettable="true" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isRSMPropertiesUIReadOnly();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is RSM Properties UI Read Only</em>' attribute.
	 * @see #isSetIsRSMPropertiesUIReadOnly()
	 * @see #unsetIsRSMPropertiesUIReadOnly()
	 * @see #isRSMPropertiesUIReadOnly()
	 * @generated
	 */
	void setIsRSMPropertiesUIReadOnly(boolean value);

	/**
	 * Unsets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsRSMPropertiesUIReadOnly()
	 * @see #isRSMPropertiesUIReadOnly()
	 * @see #setIsRSMPropertiesUIReadOnly(boolean)
	 * @generated
	 */
	void unsetIsRSMPropertiesUIReadOnly();

	/**
	 * Returns whether the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRSMPropertiesUIReadOnly <em>Is RSM Properties UI Read Only</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is RSM Properties UI Read Only</em>' attribute is set.
	 * @see #unsetIsRSMPropertiesUIReadOnly()
	 * @see #isRSMPropertiesUIReadOnly()
	 * @see #setIsRSMPropertiesUIReadOnly(boolean)
	 * @generated
	 */
	boolean isSetIsRSMPropertiesUIReadOnly();

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
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_IsRhapsodySuppressed()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isRhapsodySuppressed();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#isRhapsodySuppressed <em>Is Rhapsody Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Rhapsody Suppressed</em>' attribute.
	 * @see #isRhapsodySuppressed()
	 * @generated
	 */
	void setIsRhapsodySuppressed(boolean value);

	/**
	 * Returns the value of the '<em><b>Rhapsody Metaclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Metaclass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Metaclass</em>' attribute.
	 * @see #setRhapsodyMetaclass(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyMetaclass()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getRhapsodyMetaclass();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyMetaclass <em>Rhapsody Metaclass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody Metaclass</em>' attribute.
	 * @see #getRhapsodyMetaclass()
	 * @generated
	 */
	void setRhapsodyMetaclass(String value);

	/**
	 * Returns the value of the '<em><b>Rhapsody Stereotype Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Stereotype Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Stereotype Name</em>' attribute.
	 * @see #setRhapsodyStereotypeName(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyStereotypeName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getRhapsodyStereotypeName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyStereotypeName <em>Rhapsody Stereotype Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody Stereotype Name</em>' attribute.
	 * @see #getRhapsodyStereotypeName()
	 * @generated
	 */
	void setRhapsodyStereotypeName(String value);

	/**
	 * Returns the value of the '<em><b>Rhapsody Add New</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Add New</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Add New</em>' attribute list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyAddNew()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getRhapsodyAddNews();

	/**
	 * Returns the value of the '<em><b>Rhapsody Add New Concept</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Add New Concept</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Add New Concept</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyAddNewConcept()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenDomainConcept> getRhapsodyAddNewConcepts();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Rhapsody Add New Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRhapsodyAddNewConcepts()
	 * @generated
	 */
	GenDomainConcept getRhapsodyAddNewConcept(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Rhapsody Add New Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRhapsodyAddNewConcepts()
	 * @generated
	 */
	GenDomainConcept getRhapsodyAddNewConcept(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Rhapsody Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Display Name</em>' attribute.
	 * @see #setRhapsodyDisplayName(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyDisplayName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getRhapsodyDisplayName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept#getRhapsodyDisplayName <em>Rhapsody Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody Display Name</em>' attribute.
	 * @see #getRhapsodyDisplayName()
	 * @generated
	 */
	void setRhapsodyDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Rhapsody To Add New</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody To Add New</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody To Add New</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_RhapsodyToAddNew()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenDomainConcept> getRhapsodyToAddNews();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Rhapsody To Add New</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRhapsodyToAddNews()
	 * @generated
	 */
	GenDomainConcept getRhapsodyToAddNew(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Rhapsody To Add New</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRhapsodyToAddNews()
	 * @generated
	 */
	GenDomainConcept getRhapsodyToAddNew(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Override</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenAttributeOverride}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainConcept_Override()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<GenAttributeOverride> getOverrides();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenDomainConcept> allGenerals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenDomainConcept> allSpecifics();

} // GenDomainConcept
