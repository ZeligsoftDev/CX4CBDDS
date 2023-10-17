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
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IterableValue;

/**
 * EvaluatorSingleIterationManager supervises a single iterator collection iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 */
public class EvaluatorSingleIterationManager extends AbstractEvaluatorIterationManager
{
	class Nested extends EvaluatorSingleIterationManager
	{
		protected final @NonNull EvaluatorSingleIterationManager rootIterationManager;
		protected final int depth;

		protected Nested(@NonNull EvaluatorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
			super(iterationManager, value);
			this.rootIterationManager = iterationManager.getRootIterationManager();
			this.depth = iterationManager.getDepth() + 1;
		}

		@Override
		public int getDepth() {
			return depth;
		}

		@Override
		public @NonNull EvaluatorSingleIterationManager getRootIterationManager() {
			return rootIterationManager;
		}

		@Override
		public @NonNull CollectionValue getSourceCollection() {
			return rootIterationManager.getSourceCollection();
		}
	}

	protected final @NonNull TypedElement referredIterator;
	protected final @NonNull ValueIterator iterator;

	/** @deprecated supply a callExp */
	@Deprecated
	public EvaluatorSingleIterationManager(@NonNull Evaluator invokingEvaluator,
			@NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue,
			@NonNull TypedElement referredIterator) {
		this(ValueUtil.getExecutor(invokingEvaluator), null, body, collectionValue, accumulator, accumulatorValue, referredIterator);
	}

	/**
	 * @since 1.1
	 */
	@Deprecated /* @deprecated specify indexIterator */
	public EvaluatorSingleIterationManager(@NonNull Executor invokingExecutor,
			/*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue,
			@NonNull TypedElement referredIterator) {
		this(invokingExecutor, callExp, body, collectionValue, accumulator, accumulatorValue, referredIterator, null);
	}


	/**
	 * @since 1.18
	 */
	public EvaluatorSingleIterationManager(@NonNull Executor invokingExecutor,
			/*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue,
			@NonNull TypedElement referredIterator, @Nullable TypedElement coIterator) {
		super(invokingExecutor, callExp, body, collectionValue, accumulator, accumulatorValue);
		this.referredIterator = referredIterator;
		this.iterator = new ValueIterator(executor, collectionValue, referredIterator, coIterator);
	}

	protected EvaluatorSingleIterationManager(@NonNull EvaluatorSingleIterationManager iterationManager, @NonNull CollectionValue value) {
		super(iterationManager, value);
		this.referredIterator = iterationManager.referredIterator;
		this.iterator = new ValueIterator(executor, collectionValue, referredIterator, null);		// FIXME
	}

	@Override
	public boolean advanceIterators() {
		iterator.next();
		return hasCurrent();
	}

	/**
	 * @since 1.6
	 */
	@Override
	public @NonNull IterationManager createNestedIterationManager(@NonNull IterableValue value) {
		return new Nested(this, (CollectionValue)value);
	}

	@Override
	public @Nullable Object get() {
		return iterator.get();
	}

	public int getDepth() {
		return 0;
	}

	public @NonNull EvaluatorSingleIterationManager getRootIterationManager() {
		return this;
	}

	@Override
	public boolean hasCurrent() {
		return iterator.hasCurrent();
	}
}