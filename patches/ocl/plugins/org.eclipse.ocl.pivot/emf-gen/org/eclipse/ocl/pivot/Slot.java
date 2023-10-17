/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Slot designates that an entity modeled by an InstanceSpecification has a value or values for a specific StructuralFeature.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.Slot#getDefiningProperty <em>Defining Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Slot#getOwnedValues <em>Owned Values</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.Slot#getOwningInstance <em>Owning Instance</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getSlot()
 * @generated
 */
public interface Slot extends Element
{
	/**
	 * Returns the value of the '<em><b>Defining Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The StructuralFeature that specifies the values that may be held by the Slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Defining Property</em>' reference.
	 * @see #setDefiningProperty(Property)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getSlot_DefiningProperty()
	 * @generated
	 */
	Property getDefiningProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Slot#getDefiningProperty <em>Defining Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defining Property</em>' reference.
	 * @see #getDefiningProperty()
	 * @generated
	 */
	void setDefiningProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Owned Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.ValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value or values held by the Slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Values</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getSlot_OwnedValues()
	 * @generated
	 */
	List<ValueSpecification> getOwnedValues();

	/**
	 * Returns the value of the '<em><b>Owning Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSlots <em>Owned Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The InstanceSpecification that owns this Slot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Instance</em>' container reference.
	 * @see #setOwningInstance(InstanceSpecification)
	 * @see org.eclipse.ocl.pivot.PivotPackage#getSlot_OwningInstance()
	 * @see org.eclipse.ocl.pivot.InstanceSpecification#getOwnedSlots
	 * @generated
	 */
	InstanceSpecification getOwningInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.Slot#getOwningInstance <em>Owning Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Instance</em>' container reference.
	 * @see #getOwningInstance()
	 * @generated
	 */
	void setOwningInstance(InstanceSpecification value);

} // Slot
