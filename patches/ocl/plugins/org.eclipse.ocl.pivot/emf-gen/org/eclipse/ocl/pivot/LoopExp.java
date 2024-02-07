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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.LoopExp#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LoopExp#getOwnedCoIterators <em>Owned Co Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LoopExp#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.LoopExp#getReferredIteration <em>Referred Iteration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getLoopExp()
 * @generated
 */
public interface LoopExp
extends CallExp {

	/**
	 * Returns the value of the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body</em>' containment reference.
	 * @see #setOwnedBody(OCLExpression)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLoopExp_OwnedBody()
	 * @generated
	 */
	OCLExpression getOwnedBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LoopExp#getOwnedBody <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body</em>' containment reference.
	 * @see #getOwnedBody()
	 * @generated
	 */
	void setOwnedBody(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Co Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.IteratorVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Co Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Co Iterators</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLoopExp_OwnedCoIterators()
	 * @generated
	 */
	List<IteratorVariable> getOwnedCoIterators();

	/**
	 * Returns the value of the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterators</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLoopExp_OwnedIterators()
	 * @generated
	 */
	List<Variable> getOwnedIterators();

	/**
	 * Returns the value of the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Iteration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Iteration</em>' reference.
	 * @see #setReferredIteration(Iteration)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getLoopExp_ReferredIteration()
	 * @generated
	 */
	Iteration getReferredIteration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.LoopExp#getReferredIteration <em>Referred Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Iteration</em>' reference.
	 * @see #getReferredIteration()
	 * @generated
	 */
	void setReferredIteration(Iteration value);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	default boolean validateMatchingMapCoIterators(DiagnosticChain diagnostics, Map<Object, Object> context) { return true; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateMatchingOrderedCollectionCoIterators(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	default boolean validateNoCoInitializers(DiagnosticChain diagnostics, Map<Object, Object> context) { return true; }

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	default boolean validateNoCollectionCoIterators(DiagnosticChain diagnostics, Map<Object, Object> context) { return true; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSourceIsCollection(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.6
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	default boolean validateSourceIsIterable(DiagnosticChain diagnostics, Map<Object, Object> context) { return true; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNoInitializers(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNoNotOrderedCollectionCoIterators(DiagnosticChain diagnostics, Map<Object, Object> context);

} // LoopExp
