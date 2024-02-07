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
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * MapSelectIteration realizes the Map::select() library iteration.
 *
 * @since 1.6
 */
public class MapSelectIteration extends AbstractIteration
{
	public static final @NonNull MapSelectIteration INSTANCE = new MapSelectIteration();

	@Override
	public MapValue.@NonNull Accumulator createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createMapAccumulatorValue((MapTypeId)accumulatorTypeId);
	}

	@Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();
		assert !(bodyVal instanceof InvalidValueException);
		if (bodyVal == null) {
			throw new InvalidValueException(PivotMessages.UndefinedBody, "select"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == TRUE_VALUE) {
			Object key = iterationManager.get();
			MapValue mapValue = (MapValue)((IterationManager.IterationManagerExtension2)iterationManager).getSourceIterable();
			Object value = mapValue.at(key);
			MapValue.Accumulator accumulatorValue = (MapValue.Accumulator)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;												// createAccumulatorValue is @NonNull
			accumulatorValue.add(key, value);
		}
		else if (bodyVal != Boolean.FALSE) {
			throw new InvalidValueException(PivotMessages.NonBooleanBody, "select"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		return CARRY_ON;
	}
}
