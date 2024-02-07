/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Collection Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getOrderedCollectionValue()
 * @generated
 */
public interface OrderedCollectionValue extends CollectionValue {

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue append(@Nullable Object object);

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue appendAll(@NonNull OrderedCollectionValue objects);

	/**
	 * @generated NOT
	 */
	@Nullable Object at(int index);

	/**
	 * @generated NOT
	 */
	@Nullable Object first();

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue insertAt(int index, @Nullable Object object);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue indexOf(@Nullable Object object);

	/**
	 * @generated NOT
	 */
	@Nullable Object last();

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue prepend(@Nullable Object object);

	/**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue prependAll(@NonNull OrderedCollectionValue objects);

    /**
	 * @generated NOT
	 */
    @NonNull OrderedCollectionValue reverse();
} // OrderedCollectionValue
