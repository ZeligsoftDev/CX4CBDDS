/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression <em>Owning Let Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS()
 * @model
 * @generated
 */
public interface LetVariableCS
		extends ExpCS, VariableCS {

	/**
	 * Returns the value of the '<em><b>Owning Let Expression</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedVariables <em>Owned Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Let Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Let Expression</em>' container reference.
	 * @see #setOwningLetExpression(LetExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS_OwningLetExpression()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.LetExpCS#getOwnedVariables
	 * @model opposite="ownedVariables" transient="false"
	 * @generated
	 */
	LetExpCS getOwningLetExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwningLetExpression <em>Owning Let Expression</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Let Expression</em>' container reference.
	 * @see #getOwningLetExpression()
	 * @generated
	 */
	void setOwningLetExpression(LetExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Round Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
	 * @see #setOwnedRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLetVariableCS_OwnedRoundBracketedClause()
	 * @model containment="true"
	 * @generated
	 */
	RoundBracketedClauseCS getOwnedRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
	 * @see #getOwnedRoundBracketedClause()
	 * @generated
	 */
	void setOwnedRoundBracketedClause(RoundBracketedClauseCS value);

} // VariableCS
