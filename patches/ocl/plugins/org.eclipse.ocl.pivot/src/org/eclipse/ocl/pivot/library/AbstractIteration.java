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
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.IterationManager;

/**
 * AbstractIteration realizes shared characteristics of library iterations by providing a
 * default iteration algorithm with a call-back at each iteration step.
 */
public abstract class AbstractIteration extends AbstractIterationOrOperation implements LibraryIteration.LibraryIterationExtension
{
	/**
	 * An out-of-band value that can be returned by {@link #updateAccumulator} to signal
	 * that the iteration should carry on rather than terminate using the returned value.
	 */
	protected static final @NonNull Object CARRY_ON = new Object() {
		@Override
		public String toString() {
			return "<<CARRY_ON>>";
		}
	};

	/**
	 * A MutableObject may be used as an iteration accumulatior containing a single changing value.
	 */
	public static class MutableObject
	{
		private @Nullable Object value;

		public MutableObject(@Nullable Object value) {
			this.value = value;
		}

		public @Nullable Object get() {
			return value;
		}

		public void set(@Nullable Object value) {
			this.value = value;
		}
	}

	/**
	 * The default iteration algorithm steps through the iteration domain by invoking
	 * {@link IterationManager#hasCurrent()} and {@link IterationManager#advanceIterators()}.
	 * At each step {@link #updateAccumulator(IterationManager)} is invoked to update the
	 * accumulator for that step. A non-null return causes a premature exit and forms the
	 * return from the overall evaluation. If all steps complete {@link #resolveTerminalValue(IterationManager)}
	 * is invoked to provide the return value.
	 * <p>
	 * Derived classes may override this method to change the iteration algorithm or override
	 * the call-backs to customize the default iteration.
	 */
	@Override
	public @Nullable Object evaluateIteration(@NonNull IterationManager iterationManager) {
		try {
			while (true) {
				if (!iterationManager.hasCurrent()) {
					return resolveTerminalValue(iterationManager);
				}
				Object resultVal = updateAccumulator(iterationManager);
				if (resultVal != CARRY_ON) {
					return resultVal;
				}
				iterationManager.advanceIterators();
			}
		}
		finally {
			iterationManager.dispose();
		}
	}

	/**
	 * Return the final result at the end of an iteration over all the source elements. The
	 * default implementation just returns the accumulator. Derived iterations should
	 * override.
	 * <br>
	 * This method is bypassed if the iteration ends prematurely.
	 *
	 * @param iterationManager the iteration context
	 * @return the result
	 */
	protected @Nullable Object resolveTerminalValue(@NonNull IterationManager iterationManager) {
		return iterationManager.getAccumulatorValue();
	}

	/**
	 * Update the accumulatorValue with the bodyValue resulting from the current iteration
	 * for which the iterators define the context in the environment.
	 *
	 * @param iterationManager the iteration context
	 * @return non-CARRY_ON premature result of iteration, or CARRY_ON if complete
	 */
	protected abstract @Nullable Object updateAccumulator(@NonNull IterationManager iterationManager);
}
