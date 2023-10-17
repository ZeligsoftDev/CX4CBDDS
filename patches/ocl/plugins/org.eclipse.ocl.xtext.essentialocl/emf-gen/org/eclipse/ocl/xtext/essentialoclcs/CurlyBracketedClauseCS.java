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
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Curly Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCurlyBracketedClauseCS()
 * @model
 * @generated
 */
public interface CurlyBracketedClauseCS extends ContextLessElementCS
{
	/**
	 * Returns the value of the '<em><b>Owning Name Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause <em>Owned Curly Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Name Exp</em>' container reference.
	 * @see #setOwningNameExp(AbstractNameExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCurlyBracketedClauseCS_OwningNameExp()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedCurlyBracketedClause
	 * @model opposite="ownedCurlyBracketedClause" transient="false"
	 * @generated
	 */
	AbstractNameExpCS getOwningNameExp();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Name Exp</em>' container reference.
	 * @see #getOwningNameExp()
	 * @generated
	 */
	void setOwningNameExp(AbstractNameExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause <em>Owning Curly Bracket Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCurlyBracketedClauseCS_OwnedParts()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS#getOwningCurlyBracketClause
	 * @model opposite="owningCurlyBracketClause" containment="true"
	 * @generated
	 */
	EList<ShadowPartCS> getOwnedParts();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getCurlyBracketedClauseCS_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // CurlyBracketedClauseCS
