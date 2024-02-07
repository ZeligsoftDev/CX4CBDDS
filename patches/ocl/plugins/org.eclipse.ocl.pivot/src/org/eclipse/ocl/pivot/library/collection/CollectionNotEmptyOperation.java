/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectionNotEmptyOperation realises the Collection::notEmpty() library operation.
 */
public class CollectionNotEmptyOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull CollectionNotEmptyOperation INSTANCE = new CollectionNotEmptyOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object argument) {
		CollectionValue collectionValue = asCollectionValue(argument);
		return collectionValue.notEmpty();
	}
}
