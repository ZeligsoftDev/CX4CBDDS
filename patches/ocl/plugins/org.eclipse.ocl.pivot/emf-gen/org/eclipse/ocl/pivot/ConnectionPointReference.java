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
 * A representation of the model object '<em><b>Connection Point Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConnectionPointReference represents a usage (as part of a submachine State) of an entry/exit point Pseudostate defined in the StateMachine referenced by the submachine State.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.ConnectionPointReference#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ConnectionPointReference#getExits <em>Exits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState <em>Owning State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getConnectionPointReference()
 * @generated
 */
public interface ConnectionPointReference extends Vertex
{
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The entryPoint Pseudostates corresponding to this connection point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entries</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConnectionPointReference_Entries()
	 * @generated
	 */
	List<Pseudostate> getEntries();

	/**
	 * Returns the value of the '<em><b>Exits</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exitPoints kind Pseudostates corresponding to this connection point.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exits</em>' reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConnectionPointReference_Exits()
	 * @generated
	 */
	List<Pseudostate> getExits();

	/**
	 * Returns the value of the '<em><b>Owning State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.State#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The State in which the ConnectionPointReference is defined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning State</em>' container reference.
	 * @see #setOwningState(State)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getConnectionPointReference_OwningState()
	 * @see org.eclipse.ocl.pivot.State#getOwnedConnections
	 * @generated
	 */
	State getOwningState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.ConnectionPointReference#getOwningState <em>Owning State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning State</em>' container reference.
	 * @see #getOwningState()
	 * @generated
	 */
	void setOwningState(State value);

} // ConnectionPointReference
