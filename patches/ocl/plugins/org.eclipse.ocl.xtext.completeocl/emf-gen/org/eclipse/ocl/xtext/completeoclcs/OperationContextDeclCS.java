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
package org.eclipse.ocl.xtext.completeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedBodies <em>Owned Bodies</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPostconditions <em>Owned Postconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedPreconditions <em>Owned Preconditions</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedResult <em>Owned Result</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS
		extends FeatureContextDeclCS, TemplateableElementCS {

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_ReferredOperation()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ParameterCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_OwnedParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterCS> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Result</em>' containment reference.
	 * @see #setOwnedResult(VariableCS)
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_OwnedResult()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	VariableCS getOwnedResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS#getOwnedResult <em>Owned Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Result</em>' containment reference.
	 * @see #getOwnedResult()
	 * @generated
	 */
	void setOwnedResult(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Preconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_OwnedPreconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPreconditions();

	/**
	 * Returns the value of the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.basecs.ConstraintCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Postconditions</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_OwnedPostconditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintCS> getOwnedPostconditions();

	/**
	 * Returns the value of the '<em><b>Owned Bodies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bodies</em>' containment reference list.
	 * @see org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage#getOperationContextDeclCS_OwnedBodies()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpSpecificationCS> getOwnedBodies();

} // OperationContextDeclCS
