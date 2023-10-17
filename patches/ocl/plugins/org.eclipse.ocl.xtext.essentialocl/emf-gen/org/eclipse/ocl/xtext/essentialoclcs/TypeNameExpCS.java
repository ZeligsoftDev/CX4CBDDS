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

import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getTypeNameExpCS()
 * @model
 * @generated
 */
public interface TypeNameExpCS
		extends TypedRefCS {

	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getTypeNameExpCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getTypeNameExpCS_Element()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getElement();

	/**
	 * Returns the value of the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Curly Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
	 * @see #setOwnedCurlyBracketedClause(CurlyBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getTypeNameExpCS_OwnedCurlyBracketedClause()
	 * @model containment="true"
	 * @generated
	 */
	CurlyBracketedClauseCS getOwnedCurlyBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
	 * @see #getOwnedCurlyBracketedClause()
	 * @generated
	 */
	void setOwnedCurlyBracketedClause(CurlyBracketedClauseCS value);

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
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getTypeNameExpCS_OwnedPatternGuard()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedPatternGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS#getOwnedPatternGuard <em>Owned Pattern Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Pattern Guard</em>' containment reference.
	 * @see #getOwnedPatternGuard()
	 * @generated
	 */
	void setOwnedPatternGuard(ExpCS value);

} // TypeNameExpCS
