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
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * EvaluatorSingleMapIterationManager supervises a single iterator map iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 *
 * @since 1.6
 */
public class EvaluatorSingleMapIterationManager extends AbstractEvaluatorIterableIterationManager<MapValue>
{
	class Nested extends EvaluatorSingleMapIterationManager
	{
		protected final @NonNull EvaluatorSingleMapIterationManager rootIterationManager;
		protected final int depth;

		protected Nested(@NonNull EvaluatorSingleMapIterationManager iterationManager, @NonNull MapValue value) {
			super(iterationManager, value);
			this.rootIterationManager = iterationManager.getRootIterationManager();
			this.depth = iterationManager.getDepth() + 1;
		}

		@Override
		public int getDepth() {
			return depth;
		}

		@Override
		public @NonNull EvaluatorSingleMapIterationManager getRootIterationManager() {
			return rootIterationManager;
		}
	}

	protected final @NonNull TypedElement referredKeyIterator;
	protected final @Nullable TypedElement referredValueIterator;
	protected final @NonNull MapValueIterator iterator;

	public EvaluatorSingleMapIterationManager(@NonNull Executor invokingExecutor,
			/*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull MapValue mapValue,
			@Nullable TypedElement accumulator, @Nullable Object accumulatorValue,
			@NonNull TypedElement referredKeyIterator, @Nullable TypedElement referredValueIterator) {
		super(invokingExecutor, callExp, body, mapValue, accumulator, accumulatorValue);
		this.referredKeyIterator = referredKeyIterator;
		this.referredValueIterator = referredValueIterator;
		this.iterator = new MapValueIterator(executor, mapValue, referredKeyIterator, referredValueIterator);
	}

	protected EvaluatorSingleMapIterationManager(@NonNull EvaluatorSingleMapIterationManager iterationManager, @NonNull MapValue mapValue) {
		super(iterationManager, mapValue);
		this.referredKeyIterator = iterationManager.referredKeyIterator;
		this.referredValueIterator = iterationManager.referredValueIterator;
		this.iterator = new MapValueIterator(executor, mapValue, referredKeyIterator, referredValueIterator);
	}

	@Override
	public boolean advanceIterators() {
		iterator.next();
		return hasCurrent();
	}

	@Override
	public @NonNull IterationManager createNestedIterationManager(@NonNull IterableValue value) {
		return new Nested(this, (MapValue)value);
	}

	@Override
	public @Nullable Object get() {
		return iterator.get();
	}

	public int getDepth() {
		return 0;
	}

	public @NonNull EvaluatorSingleMapIterationManager getRootIterationManager() {
		return this;
	}

	@Override
	public boolean hasCurrent() {
		return iterator.hasCurrent();
	}
}