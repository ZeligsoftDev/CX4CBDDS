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

import org.eclipse.uml2.uml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getOwnedModels <em>Owned Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels <em>Domain Model</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getReferencedModels <em>Referenced Model</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenModel()
 * @model
 * @generated
 */
public interface GenModel extends GenDomainObject {

	/**
	 * Returns the value of the '<em><b>Referenced Model</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels() <em>Domain Model</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenModel_ReferencedModel()
	 * @model ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainModel> getReferencedModels();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Referenced Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getReferencedModels()
	 * @generated
	 */
	GenDomainModel getReferencedModel(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Referenced Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getReferencedModels()
	 * @generated
	 */
	GenDomainModel getReferencedModel(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Owned Model</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel}.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getOwningGenModel <em>Owning Gen Model</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenModel#getDomainModels() <em>Domain Model</em>}'</li>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwnedObjects() <em>Owned Object</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Model</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Model</em>' containment reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenModel_OwnedModel()
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getOwningGenModel
	 * @model opposite="owningGenModel" containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<GenDomainModel> getOwnedModels();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedModels()
	 * @generated
	 */
	GenDomainModel getOwnedModel(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Owned Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getOwnedModels()
	 * @generated
	 */
	GenDomainModel getOwnedModel(String name, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Domain Model</b></em>' reference list.
	 * The list contents are of type {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel}.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Model</em>' reference list.
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenModel_DomainModel()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 * @generated
	 */
	EList<GenDomainModel> getDomainModels();

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Domain Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDomainModels()
	 * @generated
	 */
	GenDomainModel getDomainModel(String name);

	/**
	 * Retrieves the first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>' from the '<em><b>Domain Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getDomainModels()
	 * @generated
	 */
	GenDomainModel getDomainModel(String name, boolean ignoreCase);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" modelRequired="true" modelOrdered="false"
	 * @generated
	 */
	EList<Model> findUsedDomainModels(Model model);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model urisMany="true"
	 * @generated
	 */
	EList<Model> getDomainModels(EList<String> uris);

} // GenModel
