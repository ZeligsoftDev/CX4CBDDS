/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;

/**
 * IterationManager defines the supervisor for an iteration. It provides a body, one or more
 * iterators and an accumulator, which may be updated by evaluating the body.
 */
public interface IterationManager
{
	/**
	 * @since 1.1
	 */
	public interface IterationManagerExtension extends IterationManager
	{
		@NonNull Executor getExecutor();
	}

	/**
	 * @since 1.6
	 */
	public interface IterationManagerExtension2 extends IterationManagerExtension
	{
		/**
		 * Create a nested iteration supervisor.
		 * <br>
		 * This method supports the closure iteration for which there is only a single iterator,
		 * and so this method need only be supported by single iterator managers.
		 *
		 * @param value the nested iteration domain
		 * @return the iteration space
		 * @throws InvalidValueException
		 */
		@NonNull IterationManager createNestedIterationManager(@NonNull IterableValue value);

		/**
		 * Return the source iteravle over which this iteration iterates.
		 */
		@NonNull IterableValue getSourceIterable();
	}

	/**
	 * Advance the iterators to the next iteration, returning false once all possible
	 * iterator states have been exhausted.
	 */
	boolean advanceIterators();

	/**
	 * Create a nested iteration supervisor.
	 * <br>
	 * This method supports the closure iteration for which there is only a single iterator,
	 * and so this method need only be supported by single iterator managers.
	 *
	 * @param value the nested iteration domain
	 * @return the iteration space
	 * @throws InvalidValueException
	 *
	 * @deprecated use IterationManagerExtension2 and IterableValue
	 */
	@Deprecated
	@NonNull IterationManager createNestedIterationManager(@NonNull CollectionValue value);

	void dispose();

	/**
	 * Evaluate the iteration body for the current iterators and return the evaluation result.
	 * <br>
	 * This is used by non-iterate iteration that intervene between the body evaluation
	 * and accumulator update.
	 */
	@Nullable Object evaluateBody();

	/**
	 * Get the current state of the iterator.
	 * <br>
	 * This is only supported for single iterator iterations.
	 */
	@Nullable Object get();

	/**
	 * Get the current state of the accumulator.
	 */
	@Nullable Object getAccumulatorValue();

	/** @deprecated use getExecutor() */
	@Deprecated
	@NonNull Evaluator getEvaluator();

	/**
	 * Return the source collection over which this (nested) iteration iterates.
	 *
	 * @deprecated replaced by getSourceIterable
	 */
	@Deprecated
	@NonNull CollectionValue getSourceCollection();

	@NonNull StandardLibrary getStandardLibrary();

	/**
	 * Return true if the iterators have a step to be evaluated.
	 */
	boolean hasCurrent();

	/**
	 * Update the accumulator with the result of a body iteration.
	 * <br>
	 * This implements the body of an iterate iteration for which the accumulator value may
	 * be assigned to a completely independent value.
	 *
	 * Returns null for the iteration to continue, non-null to terminate.
	 * @throws InvalidValueException
	 */
	@Nullable Object updateAccumulator(Object newValue);
}
