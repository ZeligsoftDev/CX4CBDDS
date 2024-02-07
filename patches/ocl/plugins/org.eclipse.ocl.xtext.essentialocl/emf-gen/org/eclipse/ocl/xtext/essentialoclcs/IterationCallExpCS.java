/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.Iteration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getCoIterators <em>Co Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getIterators <em>Iterators</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getReferredIteration <em>Referred Iteration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS()
 * @model abstract="true"
 * @generated
 */
public interface IterationCallExpCS extends CallExpCS
{
	/**
	 * Returns the value of the '<em><b>Co Iterators</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Co Iterators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Co Iterators</em>' reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_CoIterators()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	EList<VariableCS> getCoIterators();

	/**
	 * Returns the value of the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Iteration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Iteration</em>' reference.
	 * @see #setReferredIteration(Iteration)
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_ReferredIteration()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	Iteration getReferredIteration();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.xtext.essentialoclcs.IterationCallExpCS#getReferredIteration <em>Referred Iteration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Iteration</em>' reference.
	 * @see #getReferredIteration()
	 * @generated
	 */
	void setReferredIteration(Iteration value);

	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.xtext.essentialoclcs.VariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterators</em>' reference list.
	 * @see org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage#getIterationCallExpCS_Iterators()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	EList<VariableCS> getIterators();

} // IterationCallExpCS
