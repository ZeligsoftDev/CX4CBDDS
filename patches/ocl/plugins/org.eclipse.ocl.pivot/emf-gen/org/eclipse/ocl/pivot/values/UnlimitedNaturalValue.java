/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
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
 * A representation of the model object '<em><b>Unlimited Natural Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getUnlimitedNaturalValue()
 * @generated
 */
public interface UnlimitedNaturalValue extends NumberValue {
	/**
	 * @generated NOT
	 */
	int intValue();

	/**
	 * @generated NOT
	 */
	boolean isUnlimited();

	/**
	 * @generated NOT
	 */
	boolean isUnlimitedNatural();

	/**
	 * @generated NOT
	 */
	@NonNull UnlimitedNaturalValue max(@NonNull UnlimitedNaturalValue right);

	/**
	 * @generated NOT
	 */
	@NonNull UnlimitedNaturalValue maxUnlimited(@NonNull UnlimitedNaturalValue right);

	/**
	 * @generated NOT
	 */
	@NonNull UnlimitedNaturalValue min(@NonNull UnlimitedNaturalValue right);

	/**
	 * @generated NOT
	 */
	@NonNull UnlimitedNaturalValue minUnlimited(@NonNull UnlimitedNaturalValue right);
} // UnlimitedNaturalValue
