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
 * CollectionIsEmptyOperation realises the Collection::isEmpty() library operation.
 */
public class CollectionIsEmptyOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull CollectionIsEmptyOperation INSTANCE = new CollectionIsEmptyOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object argument) {
		CollectionValue collectionValue = asCollectionValue(argument);
		return collectionValue.isEmpty();
	}
}
