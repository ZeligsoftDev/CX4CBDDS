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
package org.eclipse.ocl.pivot.library.iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.CollectionValue.Accumulator;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * RejectIteration realizes the Collection::reject() library iteration.
 */
public class RejectIteration extends AbstractIteration
{
	public static final @NonNull RejectIteration INSTANCE = new RejectIteration();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public CollectionValue.@NonNull Accumulator createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createAccumulatorValue(ValueUtil.getExecutor(evaluator), accumulatorTypeId, bodyTypeId);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public CollectionValue.@NonNull Accumulator createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createCollectionAccumulatorValue((CollectionTypeId)accumulatorTypeId);
	}

	/**
	 *	Special case processing for return types based on the source collection element types.
	 *
	 * @since 1.15
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		return resolveCollectionSourceReturnType(environmentFactory, callExp, returnType);
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();
		if (bodyVal == null) {
			throw new InvalidValueException(PivotMessages.UndefinedBody, "reject"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			Object value = iterationManager.get();
			Accumulator accumulatorValue = (CollectionValue.Accumulator)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;												// createAccumulatorValue is @NonNull
			accumulatorValue.add(value);
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(PivotMessages.NonBooleanBody, "reject"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		return CARRY_ON;
	}
}
