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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;

/**
 * CollectionProductOperation realises the Collection::product() library operation.
 */
public class CollectionProductOperation extends AbstractBinaryOperation
{
	public static final @NonNull CollectionProductOperation INSTANCE = new CollectionProductOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable CollectionValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal, @Nullable Object argVal) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceVal, argVal); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull CollectionValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal, @Nullable Object argVal) {
		CollectionValue sourceValue = asCollectionValue(sourceVal);
		CollectionValue argumentValue = asCollectionValue(argVal);
		CollectionTypeId collTypeId = (CollectionTypeId)returnTypeId;
		TupleTypeId tupleTypeId = (TupleTypeId) collTypeId.getElementTypeId();
		Set<TupleValue> product = sourceValue.product(argumentValue, tupleTypeId);
        if (product != null) {
        	return executor.getIdResolver().createSetOfAll(collTypeId, product);
        }
        else {
        	throw new InvalidValueException(PivotMessages.MissingResult, "product"); //$NON-NLS-1$
        }
	}
}
