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
package org.eclipse.ocl.xtext.oclstdlibcs;

import org.eclipse.ocl.xtext.basecs.NamedElementCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precedence CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS#isIsRightAssociative <em>Is Right Associative</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getPrecedenceCS()
 * @model
 * @generated
 */
public interface PrecedenceCS
		extends NamedElementCS {

	/**
	 * Returns the value of the '<em><b>Is Right Associative</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Associative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Right Associative</em>' attribute.
	 * @see #setIsRightAssociative(boolean)
	 * @see org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage#getPrecedenceCS_IsRightAssociative()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsRightAssociative();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS#isIsRightAssociative <em>Is Right Associative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Right Associative</em>' attribute.
	 * @see #isIsRightAssociative()
	 * @generated
	 */
	void setIsRightAssociative(boolean value);

} // PrecedenceCS
