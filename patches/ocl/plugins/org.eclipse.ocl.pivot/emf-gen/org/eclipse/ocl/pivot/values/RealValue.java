/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getRealValue()
 * @generated
 */
public interface RealValue extends NumberValue
{
	/**
	 * @generated NOT
	 */
	@NonNull RealValue abs();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue addInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue addReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull Number asNumber();

	/**
	 * @generated NOT
	 */
	@NonNull BigDecimal bigDecimalValue();

	/**
	 * @generated NOT
	 */
	@NonNull BigInteger bigIntegerValue();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue commutatedAdd(@NonNull RealValue left);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue commutatedDivide(@NonNull RealValue left);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue commutatedMultiply(@NonNull RealValue left);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue commutatedSubtract(@NonNull RealValue left);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue divideInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue divideReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	double doubleValue();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue floor();

	/**
	 * @generated NOT
	 */
	@Nullable IntegerValue isIntegerValue();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue max(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue maxInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue maxReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
//	@NonNull RealValue maxUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue min(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue minInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
//	@NonNull RealValue minUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue multiplyInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue minReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue multiplyReal(@NonNull RealValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue round();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue negate();

	/**
	 * @generated NOT
	 */
	int signum();

	/**
	 * @generated NOT
	 */
	@NonNull RealValue subtractInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull RealValue subtractReal(@NonNull RealValue right);
} // RealValue
