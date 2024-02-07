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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;

/**
 * EvaluatorMultipleIterationManager supervises a multiple iterator collection iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 */
public class EvaluatorMultipleIterationManager extends AbstractEvaluatorIterationManager
{
	protected final ValueIterator[] iterators;
	protected boolean hasCurrent;

	/** @deprecated supply a callExp */
	@Deprecated
	public EvaluatorMultipleIterationManager(@NonNull Evaluator invokingExecutor, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue, TypedElement... referredIterators) {
		this(ValueUtil.getExecutor(invokingExecutor), null, body, collectionValue, accumulator, accumulatorValue);
	}

	/**
	 * @since 1.18
	 */
	public EvaluatorMultipleIterationManager(@NonNull Executor invokingExecutor, /*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue, TypedElement... referredIterators) {
		this(invokingExecutor, callExp, body, collectionValue, accumulator, accumulatorValue, referredIterators, null);
	}

	/**
	 * @since 1.18
	 */
	public EvaluatorMultipleIterationManager(@NonNull Executor invokingExecutor, /*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue, @NonNull TypedElement @NonNull [] referredIterators, @Nullable TypedElement @Nullable[] coIterators) {
		super(invokingExecutor, callExp, body, collectionValue, accumulator, accumulatorValue);
		int iMax = referredIterators.length;
		ValueIterator[] iterators = new ValueIterator[iMax];
		for (int i = 0; i < iMax; i++) {
			TypedElement referredIterator = referredIterators[i];
			if (referredIterator != null) {
				ValueIterator valueIterator = new ValueIterator(executor, collectionValue, referredIterator, coIterators != null ? coIterators[i] : null);
				if (!valueIterator.hasCurrent()) {
					this.iterators = null;
					this.hasCurrent = false;
					return;
				}
				iterators[i] = valueIterator;
			}
		}
		this.iterators = iterators;
		this.hasCurrent = true;
	}

	@Override
	public boolean advanceIterators() {
		if (hasCurrent) {
			for (ValueIterator advancingIterator : iterators) {
				advancingIterator.next();
				if (advancingIterator.hasCurrent()) {
					for (ValueIterator previousIterator : iterators) {
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