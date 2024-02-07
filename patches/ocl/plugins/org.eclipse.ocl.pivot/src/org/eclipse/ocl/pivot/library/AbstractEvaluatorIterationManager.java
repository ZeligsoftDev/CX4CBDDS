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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IterableValue;

/**
 * AbstractEvaluatorIterationManager supervises a collection iteration evaluation for which the iteration context is
 * maintained in the executor's evaluationEnvironment for access by the body expression evaluation.
 *
 * As soon as the API ripple is acceptable, this collection-only variant of AbstractEvaluatorIterableIterationManager
 * should be replaced by the generic collection/map capability.
 */
public abstract class AbstractEvaluatorIterationManager extends AbstractIterationManager
{
	protected static class ValueIterator
	{
		private final EvaluationEnvironment evaluationEnvironment;
		private final @NonNull CollectionValue collectionValue;
		private final @NonNull TypedElement variable;
		private final @Nullable TypedElement coVariable;
		private Iterator<? extends Object> javaIter;
		private Object value;		// 'null' is a valid value so 'this' is used as end of iteration
		private int coIndex = 1;

		/** @deprecated use Executor */
		@Deprecated
		public ValueIterator(@NonNull Evaluator evaluator, @NonNull CollectionValue collectionValue, @NonNull TypedElement variable) {
			this(ValueUtil.getExecutor(evaluator), collectionValue, variable);
		}

		/**
		 * @since 1.1
		 */
		@Deprecated /* @deprected specify coVariable */
		public ValueIterator(@NonNull Executor executor, @NonNull CollectionValue collectionValue, @NonNull TypedElement variable) {
			this(executor, collectionValue, variable, null);
		}

		/**
		 * @since 1.18
		 */
		public ValueIterator(@NonNull Executor executor, @NonNull CollectionValue collectionValue, @NonNull TypedElement variable, @Nullable TypedElement coVariable) {
			this.evaluationEnvironment = executor.getEvaluationEnvironment();
			this.collectionValue = collectionValue;
			this.variable = variable;
			this.coVariable = coVariable;
			reset();
		}

		public @Nullable Object get() {
			return value;
		}

		public boolean hasCurrent() {
			return value != this;
		}

		public @Nullable Object next() {
			if (!javaIter.hasNext()) {
				value = this;
			}
			else {
				value = javaIter.next();
				evaluationEnvironment.replace(variable, value);
				TypedElement coVariable2 = coVariable;
				if (coVariable2 != null) {
					evaluationEnvironment.replace(coVariable2, ValueUtil.integerValueOf(coIndex++));
				}
				//				System.out.println(name + " = " + value);
			}
			return value;
		}

		public Object reset() {
			javaIter = collectionValue.iterator();
			coIndex = 1;
			return next();
		}

		@Override
		public String toString() {
			return String.valueOf(variable) + " = " + (value != this ? String.valueOf(value) : "<<END>>");
		}
	}

	/** @deprecated use Executor */
	@Deprecated
	protected static @NonNull ValueIterator @Nullable [] createIterators(@NonNull TypedElement @NonNull [] referredIterators, @NonNull Evaluator evaluator, @NonNull CollectionValue collectionValue) {
		return createIterators(referredIterators, ValueUtil.getExecutor(evaluator), collectionValue);
	}

	/**
	 * @since 1.1
	 */
	protected static @NonNull ValueIterator @Nullable [] createIterators(@NonNull TypedElement @NonNull [] referredIterators, @NonNull Executor executor, @NonNull CollectionValue collectionValue) {
		int iMax = referredIterators.length;
		@NonNull ValueIterator @Nullable [] iterators = new @NonNull ValueIterator[iMax];
		for (int i = 0; i < iMax; i++) {
			TypedElement referredIterator = referredIterators[i];
			ValueIterator valueIterator = new ValueIterator(executor, collectionValue, referredIterator);
			if (!valueIterator.hasCurrent()) {
				return null;
			}
			iterators[i] = valueIterator;
		}
		return iterators;
	}

	protected final @NonNull CollectionValue collectionValue;
	/**
	 * @since 1.1
	 */
	protected final /*@NonNull*/ CallExp callExp;		// Null at root or when calling context unknown
	protected final @NonNull OCLExpression body;
	protected final @Nullable TypedElement accumulatorVariable;
	private @Nullable Object accumulatorValue;

	/** deprecated supply a callExp */
	@Deprecated
	public AbstractEvaluatorIterationManager(@NonNull Evaluator evaluator, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulatorVariable, @Nullable Object accumulatorValue) {
		this(ValueUtil.getExecutor(evaluator), null, body, collectionValue, accumulatorVariable, accumulatorValue);
	}

	/**
	 * @since 1.1
	 */
	protected AbstractEvaluatorIterationManager(@NonNull Executor executor, /*@NonNull*/ CallExp callExp, @NonNull OCLExpression body, @NonNull CollectionValue collectionValue,
			@Nullable TypedElement accumulatorVariable, @Nullable Object accumulatorValue) {
		super(executor);
		this.collectionValue = collectionValue;
		this.callExp = callExp;
		this.body = body;
		this.accumulatorVariable = accumulatorVariable;
		this.accumulatorValue = accumulatorValue;
		if (accumulatorVariable != null) {
			getEvaluationEnvironment().add(accumulatorVariable, accumulatorValue);
		}
		((Executor.ExecutorExtension)this.executor).pushEvaluationEnvironment(body, (Object)callExp);
	}

	public AbstractEvaluatorIterationManager(@NonNull AbstractEvaluatorIterationManager iterationManager, @NonNull CollectionValue collectionValue) {
		super(iterationManager.executor);
		this.callExp = iterationManager.callExp;
		this.body = iterationManager.body;
		this.collectionValue = collectionValue;
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

	public @NonNull CollectionValue getCollectionValue() {
		return collectionValue;
	}

	public @NonNull EvaluationEnvironment getEvaluationEnvironment() {
		return executor.getEvaluationEnvironment();
	}

	@Override
	public @NonNull CollectionValue getSourceCollection() {
		return collectionValue;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public @NonNull IterableValue getSourceIterable() {
		return collectionValue;
	}

	@Override
	public String toString() {
		//		return body.eContainer().toString();
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