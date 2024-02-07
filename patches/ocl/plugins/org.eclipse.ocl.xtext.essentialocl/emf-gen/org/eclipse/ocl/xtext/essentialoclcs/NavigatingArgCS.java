/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigating Arg CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedNameExpression <em>Owned Name Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause <em>Owning Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedCoIterator <em>Owned Co Iterator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS()
 * @model
 * @generated
 */
public interface NavigatingArgCS
		extends ModelElementCS {

	/**
	 * Returns the value of the '<em><b>Owning Round Bracketed Clause</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Round Bracketed Clause</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Round Bracketed Clause</em>' container reference.
	 * @see #setOwningRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwningRoundBracketedClause()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments
	 * @model opposite="ownedArguments" transient="false"
	 * @generated
	 */
	RoundBracketedClauseCS getOwningRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause <em>Owning Round Bracketed Clause</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Round Bracketed Clause</em>' container reference.
	 * @see #getOwningRoundBracketedClause()
	 * @generated
	 */
	void setOwningRoundBracketedClause(RoundBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.xtext.essentialoclcs.NavigationRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigationRole
	 * @see #setRole(NavigationRole)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Role()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	NavigationRole getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigationRole
	 * @see #getRole()
	 * @generated
	 */
	void setRole(NavigationRole value);

	/**
	 * Returns the value of the '<em><b>Owned Co Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Co Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Co Iterator</em>' containment reference.
	 * @see #setOwnedCoIterator(VariableCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwnedCoIterator()
	 * @model containment="true"
	 * @generated
	 */
	VariableCS getOwnedCoIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedCoIterator <em>Owned Co Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Co Iterator</em>' containment reference.
	 * @see #getOwnedCoIterator()
	 * @generated
	 */
	void setOwnedCoIterator(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Owned Name Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Name Expression</em>' containment reference.
	 * @see #setOwnedNameExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwnedNameExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedNameExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedNameExpression <em>Owned Name Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Name Expression</em>' containment reference.
	 * @see #getOwnedNameExpression()
	 * @generated
	 */
	void setOwnedNameExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(TypedRefCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwnedType()
	 * @model containment="true"
	 * @generated
	 */
	TypedRefCS getOwnedType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(TypedRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #setOwnedInitExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getNavigatingArgCS_OwnedInitExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwnedInitExpression <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #getOwnedInitExpression()
	 * @generated
	 */
	void setOwnedInitExpression(ExpCS value);

} // NavigatingArgCS
