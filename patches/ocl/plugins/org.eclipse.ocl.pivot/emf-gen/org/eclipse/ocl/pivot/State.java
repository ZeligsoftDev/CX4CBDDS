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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A State models a situation during which some (usually implicit) invariant condition holds.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.State#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#isIsOrthogonal <em>Is Orthogonal</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#isIsSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#isIsSubmachineState <em>Is Submachine State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedConnectionPoints <em>Owned Connection Points</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedConnections <em>Owned Connections</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedDeferrableTriggers <em>Owned Deferrable Triggers</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedDoActivity <em>Owned Do Activity</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedEntry <em>Owned Entry</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedExit <em>Owned Exit</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedRegions <em>Owned Regions</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getOwnedStateInvariant <em>Owned State Invariant</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getRedefinedState <em>Redefined State</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.State#getSubmachines <em>Submachines</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getState()
 * @generated
 */
public interface State
		extends Namespace, Vertex {

	/**
	 * Returns the value of the '<em><b>Is Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A state with isComposite=true is said to be a composite State. A composite State is a State that contains at least one Region.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Composite</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_IsComposite()
	 * @generated
	 */
	boolean isIsComposite();

	/**
	 * Returns the value of the '<em><b>Is Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A State with isOrthogonal=true is said to be an orthogonal composite State An orthogonal composite State contains two or more Regions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Orthogonal</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_IsOrthogonal()
	 * @generated
	 */
	boolean isIsOrthogonal();

	/**
	 * Returns the value of the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A State with isSimple=true is said to be a simple State A simple State does not have any Regions and it does not refer to any submachine StateMachine.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Simple</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_IsSimple()
	 * @generated
	 */
	boolean isIsSimple();

	/**
	 * Returns the value of the '<em><b>Is Submachine State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A State with isSubmachineState=true is said to be a submachine State Such a State refers to another StateMachine(submachine).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Submachine State</em>' attribute.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_IsSubmachineState()
	 * @generated
	 */
	boolean isIsSubmachineState();

	/**
	 * Returns the value of the '<em><b>Owned Connection Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Pseudostate}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Pseudostate#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit Pseudostates of a composite State. These can only be entry or exit Pseudostates, and they must have different names. They can only be defined for composite States.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Connection Points</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedConnectionPoints()
	 * @see org.eclipse.ocl.pivot.Pseudostate#getOwningState
	 * @generated
	 */
	List<Pseudostate> getOwnedConnectionPoints();

	/**
	 * Returns the value of the '<em><b>Owned Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ConnectionPointReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entry and exit connection points used in conjunction with this (submachine) State, i.e., as targets and sources, respectively, in the Region with the submachine State. A connection point reference references the corresponding definition of a connection point Pseudostate in the StateMachine referenced by the submachine State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Connections</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedConnections()
	 * @see org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState
	 * @generated
	 */
	List<ConnectionPointReference> getOwnedConnections();

	/**
	 * Returns the value of the '<em><b>Owned Deferrable Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Trigger}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Trigger#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of Triggers that are candidates to be retained by the StateMachine if they trigger no Transitions out of the State (not consumed). A deferred Trigger is retained until the StateMachine reaches a State configuration where it is no longer deferred.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Deferrable Triggers</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedDeferrableTriggers()
	 * @see org.eclipse.ocl.pivot.Trigger#getOwningState
	 * @generated
	 */
	List<Trigger> getOwnedDeferrableTriggers();

	/**
	 * Returns the value of the '<em><b>Owned Do Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed while being in the State. The execution starts when this State is entered, and ceases either by itself when done, or when the State is exited, whichever comes first.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Do Activity</em>' containment reference.
	 * @see #setOwnedDoActivity(Behavior)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedDoActivity()
	 * @generated
	 */
	Behavior getOwnedDoActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getOwnedDoActivity <em>Owned Do Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Do Activity</em>' containment reference.
	 * @see #getOwnedDoActivity()
	 * @generated
	 */
	void setOwnedDoActivity(Behavior value);

	/**
	 * Returns the value of the '<em><b>Owned Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed whenever this State is entered regardless of the Transition taken to reach the State. If defined, entry Behaviors are always executed to completion prior to any internal Behavior or Transitions performed within the State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Entry</em>' containment reference.
	 * @see #setOwnedEntry(Behavior)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedEntry()
	 * @generated
	 */
	Behavior getOwnedEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getOwnedEntry <em>Owned Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Entry</em>' containment reference.
	 * @see #getOwnedEntry()
	 * @generated
	 */
	void setOwnedEntry(Behavior value);

	/**
	 * Returns the value of the '<em><b>Owned Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional Behavior that is executed whenever this State is exited regardless of which Transition was taken out of the State. If defined, exit Behaviors are always executed to completion only after all internal and transition Behaviors have completed execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Exit</em>' containment reference.
	 * @see #setOwnedExit(Behavior)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedExit()
	 * @generated
	 */
	Behavior getOwnedExit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getOwnedExit <em>Owned Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Exit</em>' containment reference.
	 * @see #getOwnedExit()
	 * @generated
	 */
	void setOwnedExit(Behavior value);

	/**
	 * Returns the value of the '<em><b>Owned Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Region#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Regions owned directly by the State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Regions</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedRegions()
	 * @see org.eclipse.ocl.pivot.Region#getOwningState
	 * @generated
	 */
	List<Region> getOwnedRegions();

	/**
	 * Returns the value of the '<em><b>Owned State Invariant</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.Constraint#getOwningState <em>Owning State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies conditions that are always true when this State is the current State. In ProtocolStateMachines state invariants are additional conditions to the preconditions of the outgoing Transitions, and to the postcondition of the incoming Transitions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned State Invariant</em>' containment reference.
	 * @see #setOwnedStateInvariant(Constraint)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_OwnedStateInvariant()
	 * @see org.eclipse.ocl.pivot.Constraint#getOwningState
	 * @generated
	 */
	Constraint getOwnedStateInvariant();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getOwnedStateInvariant <em>Owned State Invariant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned State Invariant</em>' containment reference.
	 * @see #getOwnedStateInvariant()
	 * @generated
	 */
	void setOwnedStateInvariant(Constraint value);

	/**
	 * Returns the value of the '<em><b>Redefined State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State of which this State is a redefinition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Redefined State</em>' reference.
	 * @see #setRedefinedState(State)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_RedefinedState()
	 * @generated
	 */
	State getRedefinedState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getRedefinedState <em>Redefined State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redefined State</em>' reference.
	 * @see #getRedefinedState()
	 * @generated
	 */
	void setRedefinedState(State value);

	/**
	 * Returns the value of the '<em><b>Submachines</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.StateMachine#getSubmachineStates <em>Submachine States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The StateMachine that is to be inserted in place of the (submachine) State.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Submachines</em>' reference.
	 * @see #setSubmachines(StateMachine)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getState_Submachines()
	 * @see org.eclipse.ocl.pivot.StateMachine#getSubmachineStates
	 * @generated
	 */
	StateMachine getSubmachines();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.State#getSubmachines <em>Submachines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submachines</em>' reference.
	 * @see #getSubmachines()
	 * @generated
	 */
	void setSubmachines(StateMachine value);
} // State
