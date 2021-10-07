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
 * A representation of the model object '<em><b>Gen Domain Specialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainBlocks <em>Domain Block</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainSpecialization <em>Domain Specialization</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainConcepts <em>Domain Concept</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getPluginName <em>Plugin Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getResourceName <em>Resource Name</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainModelLibraries <em>Domain Model Library</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibraryNamesPackage <em>Model Library Names Package</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibrarySourceFolder <em>Model Library Source Folder</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getMenuModelResource <em>Menu Model Resource</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getVersion <em>Version</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getCodeGenTarget <em>Code Gen Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJavaProject <em>Rhapsody Java Project</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJDTJavaLibrary <em>Rhapsody JDT Java Library</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getElementtypeConfigurationContainerUri <em>Elementtype Configuration Container Uri</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getExcludedPaletteItems <em>Excluded Palette Item</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getIncludedUMLMeni <em>Included UML Menus</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization()
 * @model
 * @generated
 */
public interface GenDomainSpecialization extends GenDomainPackageableElement {

	/**
	 * Returns the value of the '<em><b>Domain Block</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Block</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Block</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_DomainBlock()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainBlockReference> getDomainBlocks();

	/**
	 * Returns the value of the '<em><b>Elementtype Configuration Container Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elementtype Configuration Container Uri</em>' attribute.
	 * @see #setElementtypeConfigurationContainerUri(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_ElementtypeConfigurationContainerUri()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getElementtypeConfigurationContainerUri();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getElementtypeConfigurationContainerUri <em>Elementtype Configuration Container Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elementtype Configuration Container Uri</em>' attribute.
	 * @see #getElementtypeConfigurationContainerUri()
	 * @generated
	 */
	void setElementtypeConfigurationContainerUri(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false" classifierRequired="true" classifierOrdered="false"
	 * @generated
	 */
	String getUniqueName(GenDomainClassifier classifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenDomainClassifier> allClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" itemRequired="true" itemOrdered="false"
	 * @generated
	 */
	boolean isExcluded(GenPaletteItem item);

	/**
	 * Returns the value of the '<em><b>Domain Specialization</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainNamedElement#getDomainElement() <em>Domain Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Specialization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Specialization</em>' reference.
	 * @see #setDomainSpecialization(org.eclipse.uml2.uml.Class)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_DomainSpecialization()
	 * @model required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getDomainSpecialization();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainSpecialization <em>Domain Specialization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Specialization</em>' reference.
	 * @see #getDomainSpecialization()
	 * @generated
	 */
	void setDomainSpecialization(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Domain Concept</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Concept</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Concept</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_DomainConcept()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<GenDomainConcept> getDomainConcepts();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Domain Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDomainConcepts()
	 * @generated
	 */
	GenDomainConcept getDomainConcept(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>' from the '<em><b>Domain Concept</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDomainConcepts()
	 * @generated
	 */
	GenDomainConcept getDomainConcept(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Plugin Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Name</em>' attribute.
	 * @see #setPluginName(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_PluginName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	String getPluginName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getPluginName <em>Plugin Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Name</em>' attribute.
	 * @see #getPluginName()
	 * @generated
	 */
	void setPluginName(String value);

	/**
	 * Returns the value of the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Name</em>' attribute.
	 * @see #setResourceName(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_ResourceName()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	String getResourceName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getResourceName <em>Resource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Name</em>' attribute.
	 * @see #getResourceName()
	 * @generated
	 */
	void setResourceName(String value);

	/**
	 * Returns the value of the '<em><b>Domain Model Library</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModelLibraryReference}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Model Library</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Model Library</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_DomainModelLibrary()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainModelLibraryReference> getDomainModelLibraries();

	/**
	 * Returns the value of the '<em><b>Model Library Names Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Library Names Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Library Names Package</em>' attribute.
	 * @see #setModelLibraryNamesPackage(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_ModelLibraryNamesPackage()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getModelLibraryNamesPackage();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibraryNamesPackage <em>Model Library Names Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Library Names Package</em>' attribute.
	 * @see #getModelLibraryNamesPackage()
	 * @generated
	 */
	void setModelLibraryNamesPackage(String value);

	/**
	 * Returns the value of the '<em><b>Model Library Source Folder</b></em>' attribute.
	 * The default value is <code>"src"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Library Source Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Library Source Folder</em>' attribute.
	 * @see #setModelLibrarySourceFolder(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_ModelLibrarySourceFolder()
	 * @model default="src" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getModelLibrarySourceFolder();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getModelLibrarySourceFolder <em>Model Library Source Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Library Source Folder</em>' attribute.
	 * @see #getModelLibrarySourceFolder()
	 * @generated
	 */
	void setModelLibrarySourceFolder(String value);

	/**
	 * Returns the value of the '<em><b>Menu Model Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu Model Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu Model Resource</em>' attribute.
	 * @see #setMenuModelResource(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_MenuModelResource()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getMenuModelResource();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getMenuModelResource <em>Menu Model Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Menu Model Resource</em>' attribute.
	 * @see #getMenuModelResource()
	 * @generated
	 */
	void setMenuModelResource(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_Version()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Code Gen Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Gen Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Gen Target</em>' attribute.
	 * @see #setCodeGenTarget(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_CodeGenTarget()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getCodeGenTarget();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getCodeGenTarget <em>Code Gen Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Gen Target</em>' attribute.
	 * @see #getCodeGenTarget()
	 * @generated
	 */
	void setCodeGenTarget(String value);

	/**
	 * Returns the value of the '<em><b>Rhapsody Java Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Java Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Java Project</em>' attribute.
	 * @see #setRhapsodyJavaProject(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_RhapsodyJavaProject()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getRhapsodyJavaProject();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJavaProject <em>Rhapsody Java Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody Java Project</em>' attribute.
	 * @see #getRhapsodyJavaProject()
	 * @generated
	 */
	void setRhapsodyJavaProject(String value);

	/**
	 * Returns the value of the '<em><b>Rhapsody JDT Java Library</b></em>' attribute.
	 * The default value is <code>"RHAPSODY_API"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody JDT Java Library</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody JDT Java Library</em>' attribute.
	 * @see #setRhapsodyJDTJavaLibrary(String)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_RhapsodyJDTJavaLibrary()
	 * @model default="RHAPSODY_API" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getRhapsodyJDTJavaLibrary();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getRhapsodyJDTJavaLibrary <em>Rhapsody JDT Java Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody JDT Java Library</em>' attribute.
	 * @see #getRhapsodyJDTJavaLibrary()
	 * @generated
	 */
	void setRhapsodyJDTJavaLibrary(String value);

	/**
	 * Returns the value of the '<em><b>Excluded Palette Item</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Excluded Palette Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excluded Palette Item</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_ExcludedPaletteItem()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenPaletteItem> getExcludedPaletteItems();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} with the specified '<em><b>Name</b></em>' from the '<em><b>Excluded Palette Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getExcludedPaletteItems()
	 * @generated
	 */
	GenPaletteItem getExcludedPaletteItem(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} with the specified '<em><b>Name</b></em>' from the '<em><b>Excluded Palette Item</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass The Ecore class of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenPaletteItem} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getExcludedPaletteItems()
	 * @generated
	 */
	GenPaletteItem getExcludedPaletteItem(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Included UML Menus</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenUMLMenu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included UML Menus</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included UML Menus</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainSpecialization_IncludedUMLMenus()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenUMLMenu> getIncludedUMLMeni();

} // GenDomainSpecialization
