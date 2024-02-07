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
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIteration;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * ForAllIteration realizes the Collection::forAll() library iteration.
 */
public class ForAllIteration extends AbstractIteration
{
	public static final @NonNull ForAllIteration INSTANCE = new ForAllIteration();

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
		return new MutableObject(Boolean.TRUE);
	}

	@Override
	protected @Nullable Object resolveTerminalValue(@NonNull IterationManager iterationManager) {
		MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
		assert accumulatorValue != null;
		Object object = accumulatorValue.get();
		if ((object == null) || (object == Boolean.TRUE)) {
			return object;
		}
		throw (InvalidValueException)object;
	}

	@Override
	protected @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager) {
		try {
			Object bodyVal = iterationManager.evaluateBody();
			if (bodyVal == Boolean.FALSE) {
				return Boolean.FALSE;							// Abort after a find
			}
			else if (bodyVal == Boolean.TRUE) {
				return CARRY_ON;						// Carry on for nothing found
			}
			else if (bodyVal == null) {
				MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
				assert accumulatorValue != null;
				if (accumulatorValue.get() == Boolean.TRUE) {
					accumulatorValue.set(null);
				}
				return CARRY_ON;						// Carry on for nothing found
			}
			else {
				throw new InvalidValueException(PivotMessages.NonBooleanBody, "exists"); 	// Non boolean body is invalid //$NON-NLS-1$
			}
		}
		catch (EvaluationHaltedException e) {
			throw e;
		}
		catch (InvalidValueException e) {
			MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.set(e);
			return CARRY_ON;							// Carry on for nothing found
		}
		catch (Exception e) {
			MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.set(ValueUtil.createInvalidValue(e));
			return CARRY_ON;							// Carry on for nothing found
		}
		catch (AssertionError e) {
			MutableObject accumulatorValue = (MutableObject) iterationManager.getAccumulatorValue();
			assert accumulatorValue != null;
			accumulatorValue.set(ValueUtil.createInvalidValue(e));
			return CARRY_ON;							// Carry on for nothing found
		}
	}
}
