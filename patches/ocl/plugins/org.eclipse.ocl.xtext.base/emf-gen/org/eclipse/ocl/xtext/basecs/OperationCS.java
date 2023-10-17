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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedBodyExpressions <em>Owned Body Expressions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedExceptions <em>Owned Exceptions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPostconditions <em>Owned Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwnedPreconditions <em>Owned Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends FeatureCS, TemplateableElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(StructuredClassCS)
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwningClass()
	 * @see org.eclipse.ocl.xtext.basecs.StructuredClassCS#getOwnedOperations
	 * @model opposite="ownedOperations" transient="false"
	 * @generated
	 */
	StructuredClassCS getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.basecs.OperationCS#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(StructuredClassCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ParameterCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation <em>Owning Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwnedParameters()
	 * @see org.eclipse.ocl.xtext.basecs.ParameterCS#getOwningOperation
	 * @model opposite="owningOperation" containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.TypedRefCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Exceptions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwnedExceptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedRefCS> getOwnedExceptions();

	/**
	 * Returns the value of the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Preconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwnedPreconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPreconditions();

	/**
	 * Returns the value of the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Postconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwnedPostconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPostconditions();

	/**
	 * Returns the value of the '<em><b>Owned Body Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.SpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body Expressions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.basecs.BaseCSPackage#getOperationCS_OwnedBodyExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<SpecificationCS> getOwnedBodyExpressions();

} // OperationCS
