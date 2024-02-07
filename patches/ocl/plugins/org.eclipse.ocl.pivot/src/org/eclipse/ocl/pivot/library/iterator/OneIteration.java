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
 * OneIteration realizes the Collection::one() library iteration.
 */
public class OneIteration extends AbstractIteration
{
	public static class MutableBoolean 
	{
		private boolean value = false;
		
		public boolean isSet() {
			return value;
		}
		
		public void set() {
			this.value = true;
		}
	}

	public static final @NonNull OneIteration INSTANCE = new OneIteration();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull MutableBoolean createAccumulatorValue(@NonNull Evaluator evaluator, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return createAccumulatorValue(ValueUtil.getExecutor(evaluator), accumulatorTypeId, bodyTypeId);
	}
	
	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull MutableBoolean createAccumulatorValue(@NonNull Executor executor, @NonNull TypeId accumulatorTypeId, @NonNull TypeId bodyTypeId) {
		return new MutableBoolean();
	}

	@Override
	protected @NonNull
	Object resolveTerminalValue(@NonNull IterationManager iterationManager) {
		MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		return accumulatorValue.isSet() != false;			// FIXME redundant test to suppress warning
	}

	@Override
    protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		Object bodyVal = iterationManager.evaluateBody();		
		if (bodyVal == null) {
			throw new InvalidValueException(PivotMessages.UndefinedBody, "one"); 	// Null body is invalid //$NON-NLS-1$
		}
		else if (bodyVal == Boolean.FALSE) {
			return CARRY_ON;								// Carry on for nothing found
		}
		else if (bodyVal != Boolean.TRUE) {
			throw new InvalidValueException(PivotMessages.NonBooleanBody, "one"); 	// Non boolean body is invalid //$NON-NLS-1$
		}
		else {
			MutableBoolean accumulatorValue = (MutableBoolean) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			if (accumulatorValue.isSet()) {
				return Boolean.FALSE;						// Abort after second find
			}
			else {
				accumulatorValue.set();
				return CARRY_ON;							// Carry on after first find
			}
		}
	}
}
