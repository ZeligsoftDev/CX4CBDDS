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
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapAtOperation realises the Map::notEmpty() library operation.
 */
public class MapNotEmptyOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull MapNotEmptyOperation INSTANCE = new MapNotEmptyOperation();

	@Override
	public @Nullable Object evaluate(@Nullable Object source) {
		MapValue mapValue = asMapValue(source);
		return mapValue.notEmpty();
	}
}
