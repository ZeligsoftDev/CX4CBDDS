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
package org.eclipse.ocl.pivot;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Parameter is a specification of an argument used to pass information into or out of an invocation of a BehavioralFeature.  Parameters can be treated as ConnectableElements within Collaborations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Parameter#isIsTypeof <em>Is Typeof</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Parameter#getOwningOperation <em>Owning Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getParameter()
 * @generated
 */
public interface Parameter extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Is Typeof</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Typeof</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Typeof</em>' attribute.
	 * @see #setIsTypeof(boolean)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getParameter_IsTypeof()
	 * @generated
	 */
	boolean isIsTypeof();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Parameter#isIsTypeof <em>Is Typeof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Typeof</em>' attribute.
	 * @see #isIsTypeof()
	 * @generated
	 */
	void setIsTypeof(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Operation#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Operation owning this parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Operation</em>' container reference.
	 * @see #setOwningOperation(Operation)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getParameter_OwningOperation()
	 * @see org.eclipse.ocl.pivot.Operation#getOwnedParameters
	 * @generated
	 */
	Operation getOwningOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Parameter#getOwningOperation <em>Owning Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Operation</em>' container reference.
	 * @see #getOwningOperation()
	 * @generated
	 */
	void setOwningOperation(Operation value);

} // Parameter
