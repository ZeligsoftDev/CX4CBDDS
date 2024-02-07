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
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectionIntersectionOperation realises the Collection::intersection() library operation.
 */
public class CollectionIntersectionOperation extends AbstractSimpleBinaryOperation
{
	public static final @NonNull CollectionIntersectionOperation INSTANCE = new CollectionIntersectionOperation();

	@Override
	public @NonNull CollectionValue evaluate(@Nullable Object left, @Nullable Object right) {
		CollectionValue leftCollectionValue = asCollectionValue(left);
		CollectionValue rightCollectionValue = asCollectionValue(right);
		return leftCollectionValue.intersection(rightCollectionValue);
	}

	/**
	 *	Special case processing for return types based on the source collection element types.
	 *
	 * @since 1.18
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		return resolveCollectionSourceReturnType(environmentFactory, callExp, returnType);
	}
}
