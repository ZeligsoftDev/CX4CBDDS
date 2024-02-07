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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.ContextLessElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Round Bracketed Clause CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getRoundBracketedClauseCS()
 * @model
 * @generated
 */
public interface RoundBracketedClauseCS extends ContextLessElementCS
{
	/**
	 * Returns the value of the '<em><b>Owning Name Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause <em>Owned Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Name Exp</em>' container reference.
	 * @see #setOwningNameExp(AbstractNameExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getRoundBracketedClauseCS_OwningNameExp()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.AbstractNameExpCS#getOwnedRoundBracketedClause
	 * @model opposite="ownedRoundBracketedClause" transient="false"
	 * @generated
	 */
	AbstractNameExpCS getOwningNameExp();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS#getOwningNameExp <em>Owning Name Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Name Exp</em>' container reference.
	 * @see #getOwningNameExp()
	 * @generated
	 */
	void setOwningNameExp(AbstractNameExpCS value);

	/**
	 * Returns the value of the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause <em>Owning Round Bracketed Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Arguments</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getRoundBracketedClauseCS_OwnedArguments()
	 * @see org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS#getOwningRoundBracketedClause
	 * @model opposite="owningRoundBracketedClause" containment="true"
	 * @generated
	 */
	@NonNull EList<NavigatingArgCS> getOwnedArguments();

} // RoundBracketedClauseCS
