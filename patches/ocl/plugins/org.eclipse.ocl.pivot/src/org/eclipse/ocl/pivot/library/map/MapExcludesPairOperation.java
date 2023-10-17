/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleTernaryOperation;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapExcludesPairOperation realises the Map::excludes(key, value) library operation.
 */
public class MapExcludesPairOperation extends AbstractSimpleTernaryOperation
{
	public static final @NonNull MapExcludesPairOperation INSTANCE = new MapExcludesPairOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object first, @Nullable Object key, @Nullable Object value) {
		MapValue mapValue = asMapValue(first);
		return mapValue.excludes(key, value);
	}
}
