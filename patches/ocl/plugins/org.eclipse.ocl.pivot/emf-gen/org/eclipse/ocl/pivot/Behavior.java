/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Behavior is a specification of how its context BehavioredClassifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Behavior#getOwningTransition <em>Owning Transition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getBehavior()
 * @generated
 */
public interface Behavior extends org.eclipse.ocl.pivot.Class
{

	/**
	 * Returns the value of the '<em><b>Owning Transition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Transition#getOwnedEffect <em>Owned Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transition</em>' container reference.
	 * @see #setOwningTransition(Transition)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getBehavior_OwningTransition()
	 * @see org.eclipse.ocl.pivot.Transition#getOwnedEffect
	 * @generated
	 */
	Transition getOwningTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Behavior#getOwningTransition <em>Owning Transition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transition</em>' container reference.
	 * @see #getOwningTransition()
	 * @generated
	 */
	void setOwningTransition(Transition value);
} // Behavior
