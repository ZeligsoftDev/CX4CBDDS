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

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TupleTypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getCollectionValue()
 * @generated
 */
public interface CollectionValue extends IterableValue {
	/**
	 * @generated NOT
	 */
	interface Accumulator extends CollectionValue {
		boolean add(@Nullable Object value);
	}

	/**
	 * @generated NOT
	 */
	@NonNull Collection<? extends Object> asCollection();

	/**
	 * @generated NOT
	 */
	@Override
	@Nullable List<?> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass);

	/**
	 * @generated NOT
	 */
	@NonNull <T> List<T> asEcoreObjects(@NonNull IdResolver idResolver, @Nullable Class<T> instanceClass);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue count(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull Boolean excludes(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull Boolean excludesAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull CollectionValue excluding(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull CollectionValue excludingAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue flatten();

	/**
	 * @generated NOT
	 */
	boolean flatten(@NonNull Collection<Object> flattenedElements);

	/**
	 * @generated NOT
	 */
	@NonNull Collection<? extends Object> getElements();

	/**
	 * @generated NOT
	 */
	String getKind();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull CollectionTypeId getTypeId();

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includes(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includesAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue including(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue includingAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	int intSize();

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue intersection(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean isEmpty();

	boolean isOrdered();

	boolean isUnique();

	/**
	 * @generated NOT
	 */
	@NonNull Iterable<? extends Object> iterable();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull Iterator<@Nullable Object> iterator();

	/**
	 * @generated NOT
	 */
	@NonNull Boolean notEmpty();

	/**
	 * @generated NOT
	 */
	@Nullable Set<TupleValue> product(@NonNull CollectionValue c, @NonNull TupleTypeId tupleTypeId);

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue size();

	/**
	 * @generated NOT
	 */
	@NonNull OrderedCollectionValue sort(@NonNull Comparator<Object> comparator);

	/**
	 * @generated NOT
	 */
	@Nullable SequenceValue toSequenceValue();

	/**
	 * @generated NOT
	 */
	@NonNull CollectionValue union(@NonNull CollectionValue c);
} // CollectionValue
