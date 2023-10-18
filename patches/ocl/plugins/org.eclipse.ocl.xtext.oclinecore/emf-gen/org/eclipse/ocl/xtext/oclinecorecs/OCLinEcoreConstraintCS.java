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
package org.eclipse.ocl.xtext.oclinecorecs;

import org.eclipse.ocl.xtext.basecs.ConstraintCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS#isIsCallable <em>Is Callable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage#getOCLinEcoreConstraintCS()
 * @model
 * @generated
 */
public interface OCLinEcoreConstraintCS extends ConstraintCS {

	/**
	 * Returns the value of the '<em><b>Is Callable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Callable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Callable</em>' attribute.
	 * @see #setIsCallable(boolean)
	 * @see org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreCSPackage#getOCLinEcoreConstraintCS_IsCallable()
	 * @model
	 * @generated
	 */
	boolean isIsCallable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclinecorecs.OCLinEcoreConstraintCS#isIsCallable <em>Is Callable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Callable</em>' attribute.
	 * @see #isIsCallable()
	 * @generated
	 */
	void setIsCallable(boolean value);

} // ConstraintCS
