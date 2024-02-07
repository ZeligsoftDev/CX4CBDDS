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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lambda Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS <em>Owned Expression CS</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS()
 * @model
 * @generated
 */
public interface LambdaLiteralExpCS extends LiteralExpCS
{
	/**
	 * Returns the value of the '<em><b>Owned Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression CS</em>' containment reference.
	 * @see #setOwnedExpressionCS(ExpCS)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getLambdaLiteralExpCS_OwnedExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS#getOwnedExpressionCS <em>Owned Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression CS</em>' containment reference.
	 * @see #getOwnedExpressionCS()
	 * @generated
	 */
	void setOwnedExpressionCS(ExpCS value);

} // LambdaLiteralExpCS
