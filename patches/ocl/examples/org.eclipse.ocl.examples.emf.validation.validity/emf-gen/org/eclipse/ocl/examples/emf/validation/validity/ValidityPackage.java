/*******************************************************************************
 * Copyright (c) 2013, 2020 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityFactory
 * @model kind="package"
 * @generated
 */
public interface ValidityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "validity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/validation/2013/Validity";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "validity";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValidityPackage eINSTANCE = org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode <em>Abstract Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode
	 * @generated
	 */
	EClass getAbstractNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isEnabled()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isGrayed <em>Grayed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grayed</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isGrayed()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_Grayed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isVisible()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_Visible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getLabel()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EAttribute getAbstractNode_Label();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getWorstResult <em>Worst Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Worst Result</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getWorstResult()
	 * @see #getAbstractNode()
	 * @generated
	 */
	EReference getAbstractNode_WorstResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode <em>Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode
	 * @generated
	 */
	EClass getConstrainingNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getParent()
	 * @see #getConstrainingNode()
	 * @generated
	 */
	EReference getConstrainingNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getChildren()
	 * @see #getConstrainingNode()
	 * @generated
	 */
	EReference getConstrainingNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getConstrainingObject <em>Constraining Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraining Object</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ConstrainingNode#getConstrainingObject()
	 * @see #getConstrainingNode()
	 * @generated
	 */
	EAttribute getConstrainingNode_ConstrainingObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode <em>Leaf Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode
	 * @generated
	 */
	EClass getLeafConstrainingNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintLocator <em>Constraint Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Locator</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintLocator()
	 * @see #getLeafConstrainingNode()
	 * @generated
	 */
	EAttribute getLeafConstrainingNode_ConstraintLocator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintResource <em>Constraint Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Resource</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintResource()
	 * @see #getLeafConstrainingNode()
	 * @generated
	 */
	EAttribute getLeafConstrainingNode_ConstraintResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintString <em>Constraint String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint String</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.LeafConstrainingNode#getConstraintString()
	 * @see #getLeafConstrainingNode()
	 * @generated
	 */
	EAttribute getLeafConstrainingNode_ConstraintString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Result Set</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getResultSet()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_ResultSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultValidatableNode <em>Result Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getResultValidatableNode()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_ResultValidatableNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getSeverity()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getDiagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getDiagnostic()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Diagnostic();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getValidatableNode <em>Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getValidatableNode()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_ValidatableNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getLeafConstrainingNode <em>Leaf Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leaf Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getLeafConstrainingNode()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_LeafConstrainingNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getResultConstrainingNode <em>Result Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getResultConstrainingNode()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_ResultConstrainingNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.Result#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Result#getException()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Exception();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode <em>Result Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode
	 * @generated
	 */
	EClass getResultConstrainingNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode#getResultValidatableNode <em>Result Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultConstrainingNode#getResultValidatableNode()
	 * @see #getResultConstrainingNode()
	 * @generated
	 */
	EReference getResultConstrainingNode_ResultValidatableNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet <em>Result Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Set</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet
	 * @generated
	 */
	EClass getResultSet();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Root</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getRoot()
	 * @see #getResultSet()
	 * @generated
	 */
	EReference getResultSet_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getResults()
	 * @see #getResultSet()
	 * @generated
	 */
	EReference getResultSet_Results();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultSet#getTimestamp()
	 * @see #getResultSet()
	 * @generated
	 */
	EAttribute getResultSet_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode <em>Result Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode
	 * @generated
	 */
	EClass getResultValidatableNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode#getResultConstrainingNode <em>Result Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ResultValidatableNode#getResultConstrainingNode()
	 * @see #getResultValidatableNode()
	 * @generated
	 */
	EReference getResultValidatableNode_ResultConstrainingNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode
	 * @generated
	 */
	EClass getRootNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getResultSets <em>Result Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result Sets</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode#getResultSets()
	 * @see #getRootNode()
	 * @generated
	 */
	EReference getRootNode_ResultSets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getConstrainingNodes <em>Constraining Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraining Nodes</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode#getConstrainingNodes()
	 * @see #getRootNode()
	 * @generated
	 */
	EReference getRootNode_ConstrainingNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.RootNode#getValidatableNodes <em>Validatable Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validatable Nodes</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootNode#getValidatableNodes()
	 * @see #getRootNode()
	 * @generated
	 */
	EReference getRootNode_ValidatableNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode <em>Root Constraining Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Constraining Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode
	 * @generated
	 */
	EClass getRootConstrainingNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode#getRootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Root Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootConstrainingNode#getRootNode()
	 * @see #getRootConstrainingNode()
	 * @generated
	 */
	EReference getRootConstrainingNode_RootNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode <em>Root Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode
	 * @generated
	 */
	EClass getRootValidatableNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode#getRootNode <em>Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Root Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.RootValidatableNode#getRootNode()
	 * @see #getRootValidatableNode()
	 * @generated
	 */
	EReference getRootValidatableNode_RootNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode <em>Validatable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validatable Node</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode
	 * @generated
	 */
	EClass getValidatableNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getParent()
	 * @see #getValidatableNode()
	 * @generated
	 */
	EReference getValidatableNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getChildren()
	 * @see #getValidatableNode()
	 * @generated
	 */
	EReference getValidatableNode_Children();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getConstrainedObject <em>Constrained Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constrained Object</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidatableNode#getConstrainedObject()
	 * @see #getValidatableNode()
	 * @generated
	 */
	EReference getValidatableNode_ConstrainedObject();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.emf.validation.validity.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator <em>Constraint Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Constraint Locator</em>'.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator
	 * @model instanceClass="org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator" serializeable="false"
	 * @generated
	 */
	EDataType getConstraintLocator();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object" serializeable="false"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource</em>'.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @model instanceClass="org.eclipse.emf.ecore.resource.Resource" serializeable="false"
	 * @generated
	 */
	EDataType getResource();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ValidityFactory getValidityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl <em>Abstract Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getAbstractNode()
		 * @generated
		 */
		EClass ABSTRACT_NODE = eINSTANCE.getAbstractNode();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__ENABLED = eINSTANCE.getAbstractNode_Enabled();

		/**
		 * The meta object literal for the '<em><b>Grayed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__GRAYED = eINSTANCE.getAbstractNode_Grayed();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__VISIBLE = eINSTANCE.getAbstractNode_Visible();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NODE__LABEL = eINSTANCE.getAbstractNode_Label();

		/**
		 * The meta object literal for the '<em><b>Worst Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_NODE__WORST_RESULT = eINSTANCE.getAbstractNode_WorstResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ConstrainingNodeImpl <em>Constraining Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ConstrainingNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getConstrainingNode()
		 * @generated
		 */
		EClass CONSTRAINING_NODE = eINSTANCE.getConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINING_NODE__PARENT = eINSTANCE.getConstrainingNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINING_NODE__CHILDREN = eINSTANCE.getConstrainingNode_Children();

		/**
		 * The meta object literal for the '<em><b>Constraining Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINING_NODE__CONSTRAINING_OBJECT = eINSTANCE.getConstrainingNode_ConstrainingObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.LeafConstrainingNodeImpl <em>Leaf Constraining Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.LeafConstrainingNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getLeafConstrainingNode()
		 * @generated
		 */
		EClass LEAF_CONSTRAINING_NODE = eINSTANCE.getLeafConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Constraint Locator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_CONSTRAINING_NODE__CONSTRAINT_LOCATOR = eINSTANCE.getLeafConstrainingNode_ConstraintLocator();

		/**
		 * The meta object literal for the '<em><b>Constraint Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_CONSTRAINING_NODE__CONSTRAINT_RESOURCE = eINSTANCE.getLeafConstrainingNode_ConstraintResource();

		/**
		 * The meta object literal for the '<em><b>Constraint String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_CONSTRAINING_NODE__CONSTRAINT_STRING = eINSTANCE.getLeafConstrainingNode_ConstraintString();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ResultImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getResult()
		 * @generated
		 */
		EClass RESULT = eINSTANCE.getResult();

		/**
		 * The meta object literal for the '<em><b>Result Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__RESULT_SET = eINSTANCE.getResult_ResultSet();

		/**
		 * The meta object literal for the '<em><b>Result Validatable Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__RESULT_VALIDATABLE_NODE = eINSTANCE.getResult_ResultValidatableNode();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__SEVERITY = eINSTANCE.getResult_Severity();

		/**
		 * The meta object literal for the '<em><b>Diagnostic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__DIAGNOSTIC = eINSTANCE.getResult_Diagnostic();

		/**
		 * The meta object literal for the '<em><b>Validatable Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__VALIDATABLE_NODE = eINSTANCE.getResult_ValidatableNode();

		/**
		 * The meta object literal for the '<em><b>Leaf Constraining Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__LEAF_CONSTRAINING_NODE = eINSTANCE.getResult_LeafConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Result Constraining Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__RESULT_CONSTRAINING_NODE = eINSTANCE.getResult_ResultConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__EXCEPTION = eINSTANCE.getResult_Exception();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultConstrainingNodeImpl <em>Result Constraining Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ResultConstrainingNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getResultConstrainingNode()
		 * @generated
		 */
		EClass RESULT_CONSTRAINING_NODE = eINSTANCE.getResultConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Result Validatable Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_CONSTRAINING_NODE__RESULT_VALIDATABLE_NODE = eINSTANCE.getResultConstrainingNode_ResultValidatableNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultSetImpl <em>Result Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ResultSetImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getResultSet()
		 * @generated
		 */
		EClass RESULT_SET = eINSTANCE.getResultSet();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_SET__ROOT = eINSTANCE.getResultSet_Root();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_SET__RESULTS = eINSTANCE.getResultSet_Results();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_SET__TIMESTAMP = eINSTANCE.getResultSet_Timestamp();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ResultValidatableNodeImpl <em>Result Validatable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ResultValidatableNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getResultValidatableNode()
		 * @generated
		 */
		EClass RESULT_VALIDATABLE_NODE = eINSTANCE.getResultValidatableNode();

		/**
		 * The meta object literal for the '<em><b>Result Constraining Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_VALIDATABLE_NODE__RESULT_CONSTRAINING_NODE = eINSTANCE.getResultValidatableNode_ResultConstrainingNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootNodeImpl <em>Root Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.RootNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getRootNode()
		 * @generated
		 */
		EClass ROOT_NODE = eINSTANCE.getRootNode();

		/**
		 * The meta object literal for the '<em><b>Result Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE__RESULT_SETS = eINSTANCE.getRootNode_ResultSets();

		/**
		 * The meta object literal for the '<em><b>Constraining Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE__CONSTRAINING_NODES = eINSTANCE.getRootNode_ConstrainingNodes();

		/**
		 * The meta object literal for the '<em><b>Validatable Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_NODE__VALIDATABLE_NODES = eINSTANCE.getRootNode_ValidatableNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootConstrainingNodeImpl <em>Root Constraining Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.RootConstrainingNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getRootConstrainingNode()
		 * @generated
		 */
		EClass ROOT_CONSTRAINING_NODE = eINSTANCE.getRootConstrainingNode();

		/**
		 * The meta object literal for the '<em><b>Root Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONSTRAINING_NODE__ROOT_NODE = eINSTANCE.getRootConstrainingNode_RootNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.RootValidatableNodeImpl <em>Root Validatable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.RootValidatableNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getRootValidatableNode()
		 * @generated
		 */
		EClass ROOT_VALIDATABLE_NODE = eINSTANCE.getRootValidatableNode();

		/**
		 * The meta object literal for the '<em><b>Root Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_VALIDATABLE_NODE__ROOT_NODE = eINSTANCE.getRootValidatableNode_RootNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.impl.ValidatableNodeImpl <em>Validatable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidatableNodeImpl
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getValidatableNode()
		 * @generated
		 */
		EClass VALIDATABLE_NODE = eINSTANCE.getValidatableNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATABLE_NODE__PARENT = eINSTANCE.getValidatableNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATABLE_NODE__CHILDREN = eINSTANCE.getValidatableNode_Children();

		/**
		 * The meta object literal for the '<em><b>Constrained Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATABLE_NODE__CONSTRAINED_OBJECT = eINSTANCE.getValidatableNode_ConstrainedObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.emf.validation.validity.Severity <em>Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.Severity
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

		/**
		 * The meta object literal for the '<em>Constraint Locator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getConstraintLocator()
		 * @generated
		 */
		EDataType CONSTRAINT_LOCATOR = eINSTANCE.getConstraintLocator();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em>Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getResource()
		 * @generated
		 */
		EDataType RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.ocl.examples.emf.validation.validity.impl.ValidityPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

	}

} //ValidationPackage
