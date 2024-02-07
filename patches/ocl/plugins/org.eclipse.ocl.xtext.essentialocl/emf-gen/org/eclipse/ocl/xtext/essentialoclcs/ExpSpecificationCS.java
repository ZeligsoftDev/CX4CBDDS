/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.ocl.xtext.basecs.SpecificationCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exp Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpSpecificationCS()
 * @model
 * @generated
 */
public interface ExpSpecificationCS
		extends SpecificationCS {

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getExpSpecificationCS_OwnedExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(ExpCS value);

} // ExpConstraintCS
