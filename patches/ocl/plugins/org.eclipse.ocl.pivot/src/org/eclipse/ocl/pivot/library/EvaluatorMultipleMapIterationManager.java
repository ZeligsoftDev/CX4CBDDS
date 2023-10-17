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
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * EvaluatorMultipleMapIterationManager supervises a multiple iterator map iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 *
 * @since 1.6
 */
public class EvaluatorMultipleMapIterationManager extends AbstractEvaluatorIterableIterationManager<MapValue>
{
	protected final MapValueIterator[] iterators;
	protected boolean hasCurrent;

	public EvaluatorMultipleMapIterationManager(@NonNull Executor invokingExecutor, /*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull MapValue mapValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue, @NonNull TypedElement[] referredKeyIterators, @Nullable TypedElement[] referredValueIterators) {
		super(invokingExecutor, callExp, body, mapValue, accumulator, accumulatorValue);
		int iMax = referredKeyIterators.length;
		MapValueIterator[] iterators = new MapValueIterator[iMax];
		for (int i = 0; i < iMax; i++) {
			TypedElement referredKeyIterator = referredKeyIterators[i];
			//	if (referredKeyIterator != null) {
			MapValueIterator valueIterator = new MapValueIterator(executor, mapValue, referredKeyIterator, referredValueIterators[i]);
			if (!valueIterator.hasCurrent()) {
				this.iterators = null;
				this.hasCurrent = false;
				return;
			}
			iterators[i] = valueIterator;
			//	}
		}
		this.iterators = iterators;
		this.hasCurrent = true;
	}

	@Override
	public boolean advanceIterators() {
		if (hasCurrent) {
			for (MapValueIterator advancingIterator : iterators) {
				advancingIterator.next();
				if (advancingIterator.hasCurrent()) {
					for (MapValueIterator previousIterator : iterators) {
						if (previousIterator == advancingIterator) {
							return true;
						}
						previousIterator.reset();
					}
				}
			}
			hasCurrent = false;
		}
		return false;
	}

	public @NonNull Object get(int i) {
		Object currentValue = iterators[i].get();
		if (currentValue == null) {
			throw new IllegalStateException("cannot get() after iteration complete"); //$NON-NLS-1$
		}
		return currentValue;
	}

	@Override
	public boolean hasCurrent() {
		return hasCurrent;
	}
}