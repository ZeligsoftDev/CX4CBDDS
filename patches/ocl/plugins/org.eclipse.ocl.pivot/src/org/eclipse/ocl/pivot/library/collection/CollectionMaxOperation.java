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
import org.eclipse.ocl.pivot.library.numeric.NumericMaxOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * CollectionMaxOperation realises the Collection::max() library operation.
 */
public class CollectionMaxOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull CollectionMaxOperation INSTANCE = new CollectionMaxOperation();

	@Override
	public @NonNull Object evaluate(@Nullable Object sourceVal) {
		CollectionValue collectionValue = asCollectionValue(sourceVal);
		// FIXME Bug 301351 Look for user-defined max
		Object result = null;
        for (Object element : collectionValue.iterable()) {
        	if (result == null) {
        		result = element;
        	}
        	else if (element != null) {
        		result = NumericMaxOperation.INSTANCE.evaluate(result, element);
        	}
        }
		if (result == null) {
        	throw new InvalidValueException(PivotMessages.EmptyCollection, collectionValue.getKind(), "max"); //$NON-NLS-1$
		}
		return result;
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
