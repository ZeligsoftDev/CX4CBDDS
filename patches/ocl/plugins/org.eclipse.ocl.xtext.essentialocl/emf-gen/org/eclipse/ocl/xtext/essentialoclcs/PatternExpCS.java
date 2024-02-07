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

import org.eclipse.ocl.xtext.basecs.TypeRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getOwnedPatternType <em>Owned Pattern Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getPatternVariableName <em>Pattern Variable Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getPatternExpCS()
 * @model
 * @generated
 */
public interface PatternExpCS extends ExpCS
{
	/**
	 * Returns the value of the '<em><b>Pattern Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Variable Name</em>' attribute.
	 * @see #setPatternVariableName(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getPatternExpCS_PatternVariableName()
	 * @model
	 * @generated
	 */
	String getPatternVariableName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getPatternVariableName <em>Pattern Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Variable Name</em>' attribute.
	 * @see #getPatternVariableName()
	 * @generated
	 */
	void setPatternVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Pattern Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Pattern Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Pattern Type</em>' containment reference.
	 * @see #setOwnedPatternType(TypeRefCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getPatternExpCS_OwnedPatternType()
	 * @model containment="true"
	 * @generated
	 */
	TypeRefCS getOwnedPatternType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS#getOwnedPatternType <em>Owned Pattern Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern Type</em>' containment reference.
	 * @see #getOwnedPatternType()
	 * @generated
	 */
	void setOwnedPatternType(TypeRefCS value);

} // PatternExpCS
