/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * CollectionSelectByKindOperation realises the Collection::selectByType() library operation.
 */
public class CollectionSelectByKindOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull CollectionSelectByKindOperation INSTANCE = new CollectionSelectByKindOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull CollectionValue evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		return evaluate(getExecutor(evaluator), sourceVal, argVal); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull CollectionValue evaluate(@NonNull Executor executor, @Nullable Object sourceVal, @Nullable Object argVal) {
		CollectionValue collectionValue = asCollectionValue(sourceVal);
		Type requiredElementType = asType(argVal);
    	StandardLibrary standardLibrary = executor.getStandardLibrary();
		boolean changedContents = false;
		Collection<Object> newElements = new ArrayList<Object>();
        IdResolver idResolver = executor.getIdResolver();
		for (Object element : collectionValue.iterable()) {
			if (element == null) {
        		changedContents = true;
			}
			else {
				Type elementType = idResolver.getDynamicTypeOf(element);
				if (elementType.conformsTo(standardLibrary, requiredElementType)) {
	        		newElements.add(element);
	        	}
	        	else {
	        		changedContents = true;
	        	}
			}
        }
        if (changedContents) {
        	return idResolver.createCollectionOfAll(collectionValue.isOrdered(), collectionValue.isUnique(), collectionValue.getTypeId(), newElements);
        }
        else {
        	return collectionValue;
        }
	}
}
