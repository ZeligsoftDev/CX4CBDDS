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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * IterateIteration realizes the Collection::iterate() library iteration.
 */
public class IterateIteration extends AbstractIteration
{
	public static final @NonNull IterateIteration INSTANCE = new IterateIteration();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull Object createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createAccumulatorValue(ValueUtil.getExecutor(evaluator), accumulatorTypeId, bodyTypeId);
	}
	
	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Object createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		throw new UnsupportedOperationException();		// Never used since values are assigned directly as the accumulator
	}

	@Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyValue = iterationManager.evaluateBody();
		iterationManager.updateAccumulator(bodyValue);
		return CARRY_ON;
	}
}
