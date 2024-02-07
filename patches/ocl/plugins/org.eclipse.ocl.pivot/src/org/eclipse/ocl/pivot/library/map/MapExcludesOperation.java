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
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapExcludesOperation realises the Map::excludes(key) library operation.
 */
public class MapExcludesOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull MapExcludesOperation INSTANCE = new MapExcludesOperation();

	@Override
	public @Nullable Object evaluate(@Nullable Object left, @Nullable Object right) {
		MapValue mapValue = asMapValue(left);
		return mapValue.excludes(right);
	}
}
