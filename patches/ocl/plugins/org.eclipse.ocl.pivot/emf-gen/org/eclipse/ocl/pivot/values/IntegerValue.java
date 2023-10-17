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

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getIntegerValue()
 * @generated
 */
public interface IntegerValue extends RealValue
{
	/**
	 * @generated NOT
	 */
	interface Accumulator extends IntegerValue {
		void setValue(@NonNull Integer value);
	}

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue addInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@Override
	int commutatedCompareToInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue commutatedDiv(@NonNull IntegerValue left);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue commutatedMod(@NonNull IntegerValue left);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue divInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue divUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull RealValue divideInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	int intValue();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue maxInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue minInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue modInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue modUnlimited(@NonNull UnlimitedValue right);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue multiplyInteger(@NonNull IntegerValue right);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue negate();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull IntegerValue subtractInteger(@NonNull IntegerValue right);
} // IntegerValue
