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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Interface of a tuple instance value.  OCL expressions resulting in tuples
 * yield instances of this interface.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getTupleValue()
 * @generated
 */
public interface TupleValue extends Value {
    /**
     * Obtains the tuple's type.
     *
     * @return its type
	 * @generated NOT
     */
	@Override
	@NonNull TupleTypeId getTypeId();

    /**
     * Queries the value of the specified tuple part.
     *
     * @param partId the tuple part (as an attribute)
     * @return the corresponding value
     * @throws InvalidValueException
     *
	 * @generated NOT
     */
	@Nullable Object getValue(@NonNull TuplePartId partId);

    /**
     * Queries the value of the specified tuple part at 0-based index corresponding to the position of the
     * required part-name in the alphabetically sorted list of all part-names.
     *
	 * @generated NOT
      */
	@Nullable Object getValue(int index);
} // TupleValue
