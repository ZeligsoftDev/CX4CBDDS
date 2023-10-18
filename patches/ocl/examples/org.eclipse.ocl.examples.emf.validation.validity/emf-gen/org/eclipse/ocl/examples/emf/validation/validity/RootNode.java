/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getResultSets <em>Result Sets</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getConstrainingNodes <em>Constraining Nodes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getValidatableNodes <em>Validatable Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getRootNode()
 * @model
 * @generated
 */
public interface RootNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Sets</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getRootNode_ResultSets()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot
	 * @model opposite="root" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<ResultSet> getResultSets();

	/**
	 * Returns the value of the '<em><b>Constraining Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode#getRootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraining Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraining Nodes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getRootNode_ConstrainingNodes()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode#getRootNode
	 * @model opposite="rootNode" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<RootConstrainingNode> getConstrainingNodes();

	/**
	 * Returns the value of the '<em><b>Validatable Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode#getRootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ValidatableNodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validatable Nodes</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getRootNode_ValidatableNodes()
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode#getRootNode
	 * @model opposite="rootNode" containment="true" ordered="false"
	 * @generated
	 */
	@NonNull EList<RootValidatableNode> getValidatableNodes();

} // Root
