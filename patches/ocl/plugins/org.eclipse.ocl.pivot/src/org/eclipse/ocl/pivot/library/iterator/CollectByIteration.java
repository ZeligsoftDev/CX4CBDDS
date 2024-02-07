/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * CollectByIteration realizes the Collection::collectBy() library iteration.
 *
 * @since 1.6
 */
public class CollectByIteration extends AbstractIteration
{
	public static final @NonNull CollectByIteration INSTANCE = new CollectByIteration();

	@Override
	public MapValue.@NonNull Accumulator createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createMapAccumulatorValue((MapTypeId) accumulatorTypeId);
	}

	@Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object keyVal = iterationManager.get();
		Object bodyVal = iterationManager.evaluateBody();
		MapValue.Accumulator accumulatorValue = (MapValue.Accumulator)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		accumulatorValue.add(keyVal, bodyVal);
		return CARRY_ON;
	}
}
