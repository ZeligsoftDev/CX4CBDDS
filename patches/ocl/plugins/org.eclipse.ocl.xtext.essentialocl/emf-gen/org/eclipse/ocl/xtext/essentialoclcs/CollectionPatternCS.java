/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getRestVariableName <em>Rest Variable Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCollectionPatternCS()
 * @model
 * @generated
 */
public interface CollectionPatternCS extends TypedRefCS
{
	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(CollectionTypeCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCollectionPatternCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	CollectionTypeCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(CollectionTypeCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCollectionPatternCS_OwnedParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<PatternExpCS> getOwnedParts();

	/**
	 * Returns the value of the '<em><b>Rest Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rest Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Variable Name</em>' attribute.
	 * @see #setRestVariableName(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCollectionPatternCS_RestVariableName()
	 * @model
	 * @generated
	 */
	String getRestVariableName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getRestVariableName <em>Rest Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Variable Name</em>' attribute.
	 * @see #getRestVariableName()
	 * @generated
	 */
	void setRestVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Pattern Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Pattern Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Pattern Guard</em>' containment reference.
	 * @see #setOwnedPatternGuard(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCollectionPatternCS_OwnedPatternGuard()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedPatternGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern Guard</em>' containment reference.
	 * @see #getOwnedPatternGuard()
	 * @generated
	 */
	void setOwnedPatternGuard(ExpCS value);

} // CollectionPatternCS
