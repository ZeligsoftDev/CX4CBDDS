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
 * A representation of the model object '<em><b>OCL Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The OCLValue interface must be implemented by any datatype for which Java's Object.equals is inappropriate
 * when OCL datatype equivalence is required.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getOCLValue()
 * @generated
 */
public interface OCLValue
{
	/**
	 * Return true if this is an equivalent OCL value to thatValue.
	 * <p>
	 * Note that the caller must check that the argument is an OCLValue and should also
	 * check for the shortcut case that this == thatValue. Implementations are therefore
	 * wasting time if they re-implement the shortcut.
	 *
	 * @generated NOT
	 */
	boolean oclEquals(@NonNull OCLValue thatValue);

	/**
	 * @generated NOT
	 */
	int oclHashCode();
}
