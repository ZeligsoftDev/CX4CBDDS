/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bounded Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies that a DataType behaves as an Integer number with explicit precision and overflow handling. A 16 bit number may be specified using a maximum of 32767 and minimum of -32768. 
 * Specifies how an out of range numeric result is to be handled.
 * Specifies that an out of range result is invalid. This is the default.
 * Specifies that an out of range result should be saturated to the nearest maximum/minimum value.
 * Specifies that an out of range result should be wrapped around to give a value modulo the maximum-minimum+1.
 * Specifies additional characteristics that affect the behavior of evaluations.
 * Specifies how the resolution of a numeric result is to be reduced.
 * Values are rounded down if the residue is less than half an epsilon, rounded up if the residue is greater than or equal to half an epsilon.
 * Values are always rounded up. This is also known as round to plus infinity.
 * Values are always rounded down. This is also known as truncate or round to minus infinity.
 * Values are rounded down if the residue is less than half an epsilon, rounded up if the residue is greater than half an epsilon. Residues of exactly half an epsilon are rounded to yield an even result with respect to the least significant bit of the result.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger#getOverflow <em>Overflow</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getBoundedInteger()
 * @model
 * @generated
 */
public interface BoundedInteger
		extends org.eclipse.ocl.pivot.uml.internal.oclforuml.Integer {

	/**
	 * Returns the value of the '<em><b>Overflow</b></em>' attribute.
	 * The default value is <code>"invalid"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The behavior when a maximum/minimum value is exceeded.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Overflow</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow
	 * @see #setOverflow(Overflow)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getBoundedInteger_Overflow()
	 * @model default="invalid" required="true" ordered="false"
	 * @generated
	 */
	Overflow getOverflow();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.BoundedInteger#getOverflow <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overflow</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow
	 * @see #getOverflow()
	 * @generated
	 */
	void setOverflow(Overflow value);

} // BoundedInteger
