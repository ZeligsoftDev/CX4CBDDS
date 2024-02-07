/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Part CS</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause <em>Owning Curly Bracket Clause</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowPartCS()
 * @model
 * @generated
 */
public interface ShadowPartCS
extends ModelElementCS, org.eclipse.ocl.pivot.utilities.Nameable {

	/**
	 * Returns the value of the '<em><b>Owning Curly Bracket Clause</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curly Bracket Clause</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Curly Bracket Clause</em>' container reference.
	 * @see #setOwningCurlyBracketClause(CurlyBracketedClauseCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowPartCS_OwningCurlyBracketClause()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts
	 * @model opposite="ownedParts" transient="false"
	 * @generated
	 */
	CurlyBracketedClauseCS getOwningCurlyBracketClause();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause <em>Owning Curly Bracket Clause</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Curly Bracket Clause</em>' container reference.
	 * @see #getOwningCurlyBracketClause()
	 * @generated
	 */
	void setOwningCurlyBracketClause(CurlyBracketedClauseCS value);

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowPartCS_ReferredProperty()
	 * @model
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Owned Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #setOwnedInitExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getShadowPartCS_OwnedInitExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwnedInitExpression <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Expression</em>' containment reference.
	 * @see #getOwnedInitExpression()
	 * @generated
	 */
	void setOwnedInitExpression(ExpCS value);

} // ConstructorPartCS
