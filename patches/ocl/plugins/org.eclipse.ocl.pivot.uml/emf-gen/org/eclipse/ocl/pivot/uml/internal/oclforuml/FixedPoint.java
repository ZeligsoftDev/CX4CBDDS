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
 * A representation of the model object '<em><b>Fixed Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies that a DataType behaves as a Real number and optionally defines the precision of a fixed point Integer representation. A two bit number with the values {-4, -2, 0, +2} is specified as having three integerBits and -1 fractionalBIts.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#isBitTrue <em>Bit True</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getFractionalBits <em>Fractional Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getIntegerBits <em>Integer Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getOverflow <em>Overflow</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getRounding <em>Rounding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint()
 * @model
 * @generated
 */
public interface FixedPoint
		extends Real {

	/**
	 * Returns the value of the '<em><b>Bit True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies that an implementation precisely implements the specified number of fractionBits and so is bit-true. Alternatively a non-bit-true implementation may use a larger fractionalBits to suit the natural precision of a target platform. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bit True</em>' attribute.
	 * @see #setBitTrue(boolean)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint_BitTrue()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isBitTrue();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#isBitTrue <em>Bit True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bit True</em>' attribute.
	 * @see #isBitTrue()
	 * @generated
	 */
	void setBitTrue(boolean value);

	/**
	 * Returns the value of the '<em><b>Fractional Bits</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of bits used to represent the fractional ptrecision of the fixed point number. This may be negative if the fixed point quantum is greater than 1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fractional Bits</em>' attribute.
	 * @see #setFractionalBits(int)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint_FractionalBits()
	 * @model default="0" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getFractionalBits();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getFractionalBits <em>Fractional Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fractional Bits</em>' attribute.
	 * @see #getFractionalBits()
	 * @generated
	 */
	void setFractionalBits(int value);

	/**
	 * Returns the value of the '<em><b>Integer Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of bits used to represent the sign and non-fractional part of the fixed point number. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Integer Bits</em>' attribute.
	 * @see #setIntegerBits(int)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint_IntegerBits()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getIntegerBits();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getIntegerBits <em>Integer Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Bits</em>' attribute.
	 * @see #getIntegerBits()
	 * @generated
	 */
	void setIntegerBits(int value);

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
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint_Overflow()
	 * @model default="invalid" required="true" ordered="false"
	 * @generated
	 */
	Overflow getOverflow();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getOverflow <em>Overflow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overflow</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Overflow
	 * @see #getOverflow()
	 * @generated
	 */
	void setOverflow(Overflow value);

	/**
	 * Returns the value of the '<em><b>Rounding</b></em>' attribute.
	 * The default value is <code>"nearest"</code>.
	 * The literals are from the enumeration {@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The behavior when there is insufficient resolution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rounding</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding
	 * @see #setRounding(Rounding)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFixedPoint_Rounding()
	 * @model default="nearest" required="true" ordered="false"
	 * @generated
	 */
	Rounding getRounding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FixedPoint#getRounding <em>Rounding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding
	 * @see #getRounding()
	 * @generated
	 */
	void setRounding(Rounding value);

} // FixedPoint
