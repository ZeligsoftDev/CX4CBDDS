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
package org.eclipse.ocl.xtext.basecs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedMessageSpecification <em>Owned Message Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedSpecification <em>Owned Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getConstraintCS()
 * @model
 * @generated
 */
public interface ConstraintCS extends NamedElementCS
{
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see #setStereotype(String)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getConstraintCS_Stereotype()
	 * @model dataType="org.eclipse.ocl.pivot.String"
	 * @generated
	 */
	String getStereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(String value);

	/**
	 * Returns the value of the '<em><b>Owned Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Specification</em>' containment reference.
	 * @see #setOwnedSpecification(SpecificationCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getConstraintCS_OwnedSpecification()
	 * @model containment="true"
	 * @generated
	 */
	SpecificationCS getOwnedSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedSpecification <em>Owned Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Specification</em>' containment reference.
	 * @see #getOwnedSpecification()
	 * @generated
	 */
	void setOwnedSpecification(SpecificationCS value);

	/**
	 * Returns the value of the '<em><b>Owned Message Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Message Specification</em>' containment reference.
	 * @see #setOwnedMessageSpecification(SpecificationCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getConstraintCS_OwnedMessageSpecification()
	 * @model containment="true"
	 * @generated
	 */
	SpecificationCS getOwnedMessageSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.ConstraintCS#getOwnedMessageSpecification <em>Owned Message Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Message Specification</em>' containment reference.
	 * @see #getOwnedMessageSpecification()
	 * @generated
	 */
	void setOwnedMessageSpecification(SpecificationCS value);

} // ConstraintCS
