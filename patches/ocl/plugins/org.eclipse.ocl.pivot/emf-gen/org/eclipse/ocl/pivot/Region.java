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

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Region is a top-level part of a StateMachine or a composite State, that serves as a container for the Vertices and Transitions of the StateMachine. A StateMachine or composite State may contain multiple Regions representing behaviors that may occur in parallel.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Region#getExtendedRegion <em>Extended Region</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Region#getOwnedSubvertexes <em>Owned Subvertexes</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Region#getOwnedTransitions <em>Owned Transitions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Region#getOwningState <em>Owning State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Region#getOwningStateMachine <em>Owning State Machine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion()
 * @generated
 */
public interface Region extends Namespace
{
	/**
	 * Returns the value of the '<em><b>Extended Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region of which this region is an extension.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Region</em>' reference.
	 * @see #setExtendedRegion(Region)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion_ExtendedRegion()
	 * @generated
	 */
	Region getExtendedRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Region#getExtendedRegion <em>Extended Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Region</em>' reference.
	 * @see #getExtendedRegion()
	 * @generated
	 */
	void setExtendedRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Owned Subvertexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Vertex#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of Vertices that are owned by this Region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subvertexes</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion_OwnedSubvertexes()
	 * @see org.eclipse.ocl.pivot.Vertex#getOwningRegion
	 * @generated
	 */
	List<Vertex> getOwnedSubvertexes();

	/**
	 * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Transition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Transition#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of Transitions owned by the Region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Transitions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion_OwnedTransitions()
	 * @see org.eclipse.ocl.pivot.Transition#getOwningRegion
	 * @generated
	 */
	List<Transition> getOwnedTransitions();

	/**
	 * Returns the value of the '<em><b>Owning State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.State#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State that owns the Region. If a Region is owned by a State, then it cannot also be owned by a StateMachine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning State</em>' container reference.
	 * @see #setOwningState(State)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion_OwningState()
	 * @see org.eclipse.ocl.pivot.State#getOwnedRegions
	 * @generated
	 */
	State getOwningState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Region#getOwningState <em>Owning State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State</em>' container reference.
	 * @see #getOwningState()
	 * @generated
	 */
	void setOwningState(State value);

	/**
	 * Returns the value of the '<em><b>Owning State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.StateMachine#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The StateMachine that owns the Region. If a Region is owned by a StateMachine, then it cannot also be owned by a State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning State Machine</em>' container reference.
	 * @see #setOwningStateMachine(StateMachine)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getRegion_OwningStateMachine()
	 * @see org.eclipse.ocl.pivot.StateMachine#getOwnedRegions
	 * @generated
	 */
	StateMachine getOwningStateMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Region#getOwningStateMachine <em>Owning State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State Machine</em>' container reference.
	 * @see #getOwningStateMachine()
	 * @generated
	 */
	void setOwningStateMachine(StateMachine value);

} // Region
