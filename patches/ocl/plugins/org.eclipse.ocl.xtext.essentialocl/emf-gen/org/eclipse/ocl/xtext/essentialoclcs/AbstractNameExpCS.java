/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#isIsPre <em>Is Pre</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedSquareBracketedClauses <em>Owned Square Bracketed Clauses</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceTypeValue <em>Source Type Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNameExpCS extends ExpCS
{
	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Is Pre</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pre</em>' attribute.
	 * @see #setIsPre(boolean)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_IsPre()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsPre();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#isIsPre <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pre</em>' attribute.
	 * @see #isIsPre()
	 * @generated
	 */
	void setIsPre(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Curly Bracketed Clause</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Curly Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
	 * @see #setOwnedCurlyBracketedClause(CurlyBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_OwnedCurlyBracketedClause()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp
	 * @model opposite="owningNameExp" containment="true"
	 * @generated
	 */
	CurlyBracketedClauseCS getOwnedCurlyBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Curly Bracketed Clause</em>' containment reference.
	 * @see #getOwnedCurlyBracketedClause()
	 * @generated
	 */
	void setOwnedCurlyBracketedClause(CurlyBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Owned Round Bracketed Clause</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Round Bracketed Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
	 * @see #setOwnedRoundBracketedClause(RoundBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_OwnedRoundBracketedClause()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp
	 * @model opposite="owningNameExp" containment="true"
	 * @generated
	 */
	RoundBracketedClauseCS getOwnedRoundBracketedClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Round Bracketed Clause</em>' containment reference.
	 * @see #getOwnedRoundBracketedClause()
	 * @generated
	 */
	void setOwnedRoundBracketedClause(RoundBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Owned Square Bracketed Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Square Bracketed Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Square Bracketed Clauses</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_OwnedSquareBracketedClauses()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS#getOwningNameExp
	 * @model opposite="owningNameExp" containment="true" upper="2"
	 * @generated
	 */
	EList<SquareBracketedClauseCS> getOwnedSquareBracketedClauses();

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sourceType propagates the known type of a source expression for use by subsequent analysis of for instance operation arguments.
	 * For explicit source invocations, sourceType provides the true source type after resolution of implicit set or implicit collect.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Type</em>' reference.
	 * @see #setSourceType(Type)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_SourceType()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	Type getSourceType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceType <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' reference.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(Type value);

	/**
	 * Returns the value of the '<em><b>Source Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sourceTypeValue propates the known value of a source expression when the type is itself a type. This is used during analysis of for instance allInstances() and oclType().
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Type Value</em>' reference.
	 * @see #setSourceTypeValue(Type)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getAbstractNameExpCS_SourceTypeValue()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	Type getSourceTypeValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getSourceTypeValue <em>Source Type Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type Value</em>' reference.
	 * @see #getSourceTypeValue()
	 * @generated
	 */
	void setSourceTypeValue(Type value);

} // AbstractNameExpCS
