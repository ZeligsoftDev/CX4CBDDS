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
package org.eclipse.ocl.xtext.basecs;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation <em>Owning Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getParameterCS()
 * @model
 * @generated
 */
public interface ParameterCS extends TypedElementCS {

	/**
	 * Returns the value of the '<em><b>Owning Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Operation</em>' container reference.
	 * @see #setOwningOperation(OperationCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getParameterCS_OwningOperation()
	 * @see org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedParameters
	 * @model opposite="ownedParameters" transient="false"
	 * @generated
	 */
	OperationCS getOwningOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation <em>Owning Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Operation</em>' container reference.
	 * @see #getOwningOperation()
	 * @generated
	 */
	void setOwningOperation(OperationCS value);
} // ParameterCS
