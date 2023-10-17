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

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * AbstractEvaluatorIterableIterationManager supervises an iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 *
 * This generic variant of AbstractEvaluatorIterationManager is suitable for Maps or Collections but is currently only used by the
 * derived single/multiple map iteration managers. The corresponding collection managers should exploit as soon as the API ripple is acceptable.
 *
 * @since 1.6
 */
public abstract class AbstractEvaluatorIterableIterationManager<IV extends IterableValue> extends AbstractIterationManager
{
	protected static abstract class AbstractValueIterator<IV extends IterableValue>
	{
		protected final EvaluationEnvironment evaluationEnvironment;
		protected final @NonNull IV iterableValue;
		private final @NonNull TypedElement iteratorVariable;
		private Iterator<? extends Object> javaIter;
		private Object iteratorValue;		// 'null' is a valid value so 'this' is used as end of iteration

		public AbstractValueIterator(@NonNull Executor executor, @NonNull IV iterableValue, @NonNull TypedElement iteratorVariable) {
			this.evaluationEnvironment = executor.getEvaluationEnvironment();
			this.iterableValue = iterableValue;
			this.iteratorVariable = iteratorVariable;
		}

		public @Nullable Object get() {
			return iteratorValue;
		}

		public boolean hasCurrent() {
			return iteratorValue != this;
		}

		public @Nullable Object next() {
			if (!javaIter.hasNext()) {
				iteratorValue = this;
			}
			else {
				iteratorValue = javaIter.next();
				evaluationEnvironment.replace(iteratorVariable, iteratorValue);
			}
			return iteratorValue;
		}

		public Object reset() {
			javaIter = iterableValue.iterator();
			return next();
		}

		@Override
		public String toString() {
			return String.valueOf(iteratorVariable) + " = " + (iteratorValue != this ? String.valueOf(iteratorValue) : "<<END>>");
		}
	}

	protected static class CollectionValueIterator extends AbstractValueIterator<CollectionValue>
	{
		public CollectionValueIterator(@NonNull Executor executor, @NonNull CollectionValue collectionValue, @NonNull TypedElement keyVariable) {
			super(executor, collectionValue, keyVariable);
			reset();
		}
	}

	protected static class MapValueIterator extends AbstractValueIterator<MapValue>
	{
		private final @Nullable TypedElement valueVariable;

		public MapValueIterator(@NonNull Executor executor, @NonNull MapValue mapValue, @NonNull TypedElement keyVariable, @Nullable TypedElement valueVariable) {
			super(executor, mapValue, keyVariable);
			this.valueVariable = valueVariable;
			reset();
		}

		@Override
		public @Nullable Object next() {
			Object keyValue = super.next();
			if (keyValue != this) {
				TypedElement valueVariable2 = valueVariable;
				if (valueVariable2 != null) {
					Object valueValue = iterableValue.at(keyValue);
					evaluationEnvironment.replace(valueVariable2, valueValue);
				}
			}
			return keyValue;
		}
	}

	protected final @NonNull IV iterableValue;
	protected final /*@NonNull*/ CallExp callExp;		// Null at root or when calling context unknown
	protected final @NonNull OCLExpression body;
	protected final @Nullable TypedElement accumulatorVariable;
	private @Nullable Object accumulatorValue;

	protected AbstractEvaluatorIterableIterationManager(@NonNull Executor executor, /*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull IV iterableValue,
			@Nullable TypedElement accumulatorVariable, @Nullable Object accumulatorValue) {
		super(executor);
		this.iterableValue = iterableValue;
		this.callExp = callExp;
		this.body = body;
		this.accumulatorVariable = accumulatorVariable;
		this.accumulatorValue = accumulatorValue;
		if (accumulatorVariable != null) {
			getEvaluationEnvironment().add(accumulatorVariable, accumulatorValue);
		}
		((Executor.ExecutorExtension)this.executor).pushEvaluationEnvironment(body, (Object)callExp);
	}

	public AbstractEvaluatorIterableIterationManager(@NonNull AbstractEvaluatorIterableIterationManager<IV> iterationManager, @NonNull IV iterableValue) {
		super(iterationManager.executor);
		this.callExp = iterationManager.callExp;
		this.body = iterationManager.body;
		this.iterableValue = iterableValue;
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.accumulatorVariable = iterationManager.accumulatorVariable;
		((Executor.ExecutorExtension)this.executor).pushEvaluationEnvironment(body, (Object)callExp);
	}

	@Override
	public void dispose() {
		executor.popEvaluationEnvironment();
	}

	@Override
	public @Nullable Object evaluateBody() {
		return executor.evaluate(body);
	}

	@Override
	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}

	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return executor.getEvaluationEnvironment();
	}

	@Override
	public boolean advanceIterators() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public @NonNull IterableValue getSourceIterable() {
		return iterableValue;
	}

	@Override
	public String toString() {
		return body.toString();
	}

	@Override
	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		TypedElement accumulatorVariable2 = accumulatorVariable;
		if (accumulatorVariable2 != null) {
			getEvaluationEnvironment().replace(accumulatorVariable2, accumulatorValue);
		}
		return null;					// carry on
	}
}