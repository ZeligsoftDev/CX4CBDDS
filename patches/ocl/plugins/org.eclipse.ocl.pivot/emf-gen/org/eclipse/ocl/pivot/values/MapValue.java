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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.MapTypeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getMapValue()
 * @generated
 */
public interface MapValue extends IterableValue {
	/**
	 * @generated NOT
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface Accumulator extends MapValue {
		@Deprecated /* @deprecated erroneous never-used signature */
		boolean add(@Nullable Object value);
		/**
		 * @since 1.6
		 */
		void add(@Nullable Object key, @Nullable Object value);
	}

	/**
	 * @generated NOT
	 */
	@NonNull Map<? extends Object, ? extends Object> asMap();

	/**
	 * @generated NOT
	 */
	@Override
	@Nullable List<?> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass);

	/**
	 * @generated NOT
	 */
	@Nullable <T> List<T> asEcoreObjects(@NonNull IdResolver idResolver, @Nullable Class<T> instanceClass);

	/**
	 * @generated NOT
	 */
	Object at(Object right);

	/**
	 * @generated NOT
	 */
	@NonNull Set<Map.Entry<Object, Object>> entrySet();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull Boolean excludes(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean excludes(@Nullable Object key, @Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull Boolean excludesAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean excludesMap(@NonNull MapValue m);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean excludesValue(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull MapValue excluding(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull MapValue excluding(@Nullable Object key, @Nullable Object value);

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull MapValue excludingAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull MapValue excludingMap(@NonNull MapValue m);

	/**
	 * @generated NOT
	 */
	@NonNull Set<Map.Entry<Object, Object>> getElements();

	/**
	 * @generated NOT
	 */
	@NonNull SetValue getKeys();

	/**
	 * @generated NOT
	 */
	@NonNull BagValue getValues();

	/**
	 * @generated NOT
	 */
	@Override
	@NonNull MapTypeId getTypeId();

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includes(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includes(@Nullable Object key, @Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includesAll(@NonNull CollectionValue c);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includesMap(@NonNull MapValue m);

	/**
	 * @generated NOT
	 */
	@NonNull Boolean includesValue(@Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull MapValue including(@NonNull MapTypeId returnTypeId, @Nullable Object key, @Nullable Object value);

	/**
	 * @generated NOT
	 */
	@NonNull MapValue includingMap(@NonNull MapTypeId returnTypeId, @NonNull MapValue m);

	/**
	 * @generated NOT
	 */
	int intSize();

	/**
	 * @generated NOT
	 */
	@NonNull Boolean isEmpty();

	/**
	 * @generated NOT
	 */
	@NonNull Set<Object> keySet();

	/**
	 * @generated NOT
	 */
	@NonNull Boolean notEmpty();

	/**
	 * @generated NOT
	 */
	@NonNull IntegerValue size();
} // MapValue
