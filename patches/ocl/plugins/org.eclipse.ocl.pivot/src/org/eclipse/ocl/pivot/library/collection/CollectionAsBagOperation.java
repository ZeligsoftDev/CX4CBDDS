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
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.values.BagValue;

/**
 * CollectionAsBagOperation realises the Collection::asBag() library operation.
 */
public class CollectionAsBagOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull CollectionAsBagOperation INSTANCE = new CollectionAsBagOperation();

	@Override
	public @NonNull BagValue evaluate(@Nullable Object argument) {
		return asBagValue(argument);
	}

	/**
	 *	Special case processing for return collection types based on the source collection types and multiplicities.
	 *
	 * @since 1.18
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		return resolveCollectionAsCollectionReturnType(environmentFactory, callExp, returnType);
	}
}
