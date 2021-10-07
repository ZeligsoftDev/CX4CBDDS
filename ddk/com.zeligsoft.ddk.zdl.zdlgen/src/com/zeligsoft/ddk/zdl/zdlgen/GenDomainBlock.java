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
 * A representation of the model object '<em><b>Gen Domain Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getClassifiers <em>Classifier</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getRelations <em>Relation</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getDomainBlock <em>Domain Block</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getImports <em>Import</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getMerges <em>Merge</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesSuppressed <em>Rsm Stereotypes Suppressed</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesUIReadOnly <em>Rsm Stereotypes UI Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesPropertiesUIReadOnly <em>Rsm Stereotypes Properties UI Read Only</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock()
 * @model
 * @generated
 */
public interface GenDomainBlock extends GenDomainPackageableElement {

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_Classifier()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainClassifier> getClassifiers();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} with the specified '<em><b>Name</b></em>' from the '<em><b>Classifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getClassifiers()
	 * @generated
	 */
	GenDomainClassifier getClassifier(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} with the specified '<em><b>Name</b></em>' from the '<em><b>Classifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getClassifiers()
	 * @generated
	 */
	GenDomainClassifier getClassifier(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_Relation()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainBlockRelation> getRelations();

	/**
	 * Returns the value of the '<em><b>Domain Block</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Block</em>' reference.
	 * @see #setDomainBlock(org.eclipse.uml2.uml.Package)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_DomainBlock()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getDomainBlock();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getDomainBlock <em>Domain Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Block</em>' reference.
	 * @see #getDomainBlock()
	 * @generated
	 */
	void setDomainBlock(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockImport}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getRelations() <em>Relation</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_Import()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainBlockImport> getImports();

	/**
	 * Returns the value of the '<em><b>Merge</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockMerge}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#getRelations() <em>Relation</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_Merge()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainBlockMerge> getMerges();

	/**
	 * Returns the value of the '<em><b>Rsm Stereotypes Suppressed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rsm Stereotypes Suppressed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rsm Stereotypes Suppressed</em>' attribute.
	 * @see #setRsmStereotypesSuppressed(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_RsmStereotypesSuppressed()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isRsmStereotypesSuppressed();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesSuppressed <em>Rsm Stereotypes Suppressed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rsm Stereotypes Suppressed</em>' attribute.
	 * @see #isRsmStereotypesSuppressed()
	 * @generated
	 */
	void setRsmStereotypesSuppressed(boolean value);

	/**
	 * Returns the value of the '<em><b>Rsm Stereotypes UI Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rsm Stereotypes UI Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rsm Stereotypes UI Read Only</em>' attribute.
	 * @see #setRsmStereotypesUIReadOnly(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_RsmStereotypesUIReadOnly()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isRsmStereotypesUIReadOnly();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesUIReadOnly <em>Rsm Stereotypes UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rsm Stereotypes UI Read Only</em>' attribute.
	 * @see #isRsmStereotypesUIReadOnly()
	 * @generated
	 */
	void setRsmStereotypesUIReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Rsm Stereotypes Properties UI Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rsm Stereotypes Properties UI Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rsm Stereotypes Properties UI Read Only</em>' attribute.
	 * @see #setRsmStereotypesPropertiesUIReadOnly(boolean)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlock_RsmStereotypesPropertiesUIReadOnly()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isRsmStereotypesPropertiesUIReadOnly();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#isRsmStereotypesPropertiesUIReadOnly <em>Rsm Stereotypes Properties UI Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rsm Stereotypes Properties UI Read Only</em>' attribute.
	 * @see #isRsmStereotypesPropertiesUIReadOnly()
	 * @generated
	 */
	void setRsmStereotypesPropertiesUIReadOnly(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<GenDomainClassifier> allClassifiers(GenAllDomainCassifiersMode mode);

} // GenDomainBlock
