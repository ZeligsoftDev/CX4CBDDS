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
 * A representation of the model object '<em><b>Typed Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.TypedRefCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedRefCS()
 * @model abstract="true"
 * @generated
 */
public interface TypedRefCS extends TypeRefCS {

	/**
	 * Returns the value of the '<em><b>Owned Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Multiplicity</em>' containment reference.
	 * @see #setOwnedMultiplicity(MultiplicityCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getTypedRefCS_OwnedMultiplicity()
	 * @model containment="true"
	 * @generated
	 */
	MultiplicityCS getOwnedMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.TypedRefCS#getOwnedMultiplicity <em>Owned Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Multiplicity</em>' containment reference.
	 * @see #getOwnedMultiplicity()
	 * @generated
	 */
	void setOwnedMultiplicity(MultiplicityCS value);
} // TypedRefCS
