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
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OnlyIteration realizes the Collection::only() library iteration.
 */
public class OnlyIteration extends AbstractIteration
{
	public static final @NonNull OnlyIteration INSTANCE = new OnlyIteration();

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
		return new MutableObject(null);
	}
	
	@Override
	protected @NonNull Object resolveTerminalValue(@NonNull IterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		Object object = accumulatorValue.get();
		if (object != null) {
			return object;		// Normal something found result.
		}
		else {
			throw new InvalidValueException("No matching content for 'only'"); //$NON-NLS-1$
		}
	}
	
	@Override
    protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(PivotMessages.UndefinedBody, "only"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			return CARRY_ON;									// Carry on for nothing found
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(PivotMessages.NonBooleanBody, "only"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			MutableObject accumulatorValue = (MutableObject)iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			Object object = accumulatorValue.get();
			if (object != null) {
				throw new InvalidValueException("Multiple matching content for 'only'"); //$NON-NLS-1$
			}
			else {
				Object value = iterationManager.get();		
				accumulatorValue.set(value);
				return CARRY_ON;									// Carry on after first find
			}
		}
	}
}
