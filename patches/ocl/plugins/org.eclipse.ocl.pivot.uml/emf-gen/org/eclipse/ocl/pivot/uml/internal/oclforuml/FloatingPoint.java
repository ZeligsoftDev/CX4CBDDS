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
 * A representation of the model object '<em><b>Floating Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies that a DataType behaves as a Real number and optionally defines the required precision of a mantissa and base 2 exponent floating point representation. An IEEE 754 double precision number may be specified with 11 exponentBits, 53 mantissaBits. 1.7976931348623157e+308 maximum, -1.7976931348623157e+308 minimum, 1.0000000000000002 epsilon.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getExponentBits <em>Exponent Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getMantissaBits <em>Mantissa Bits</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getOverflow <em>Overflow</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getRounding <em>Rounding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFloatingPoint()
 * @model
 * @generated
 */
public interface FloatingPoint
		extends Real {

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
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFloatingPoint_Overflow()
	 * @model default="invalid" required="true" ordered="false"
	 * @generated
	 */
	Overflow getOverflow();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getOverflow <em>Overflow</em>}' attribute.
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
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFloatingPoint_Rounding()
	 * @model default="nearest" required="true" ordered="false"
	 * @generated
	 */
	Rounding getRounding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getRounding <em>Rounding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounding</em>' attribute.
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.Rounding
	 * @see #getRounding()
	 * @generated
	 */
	void setRounding(Rounding value);

	/**
	 * Returns the value of the '<em><b>Exponent Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of bits used to represent the base 2 exponent and its polarity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exponent Bits</em>' attribute.
	 * @see #setExponentBits(int)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFloatingPoint_ExponentBits()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getExponentBits();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getExponentBits <em>Exponent Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent Bits</em>' attribute.
	 * @see #getExponentBits()
	 * @generated
	 */
	void setExponentBits(int value);

	/**
	 * Returns the value of the '<em><b>Mantissa Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of bits used to represent the mantissa and its polarity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mantissa Bits</em>' attribute.
	 * @see #setMantissaBits(int)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getFloatingPoint_MantissaBits()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMantissaBits();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.FloatingPoint#getMantissaBits <em>Mantissa Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mantissa Bits</em>' attribute.
	 * @see #getMantissaBits()
	 * @generated
	 */
	void setMantissaBits(int value);

} // FloatingPoint
