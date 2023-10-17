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
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.Iterator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIterationManager;
import org.eclipse.ocl.pivot.library.LibraryTernaryOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IterableValue;

/**
 * ExecutorDoubleIterationManager supervises a double iterator collection iteration evaluation for which the iteration context is
 * maintained in dedicated variables typically allocated by the code generator.
 *
 * @deprecated Replaced by ExecutorMultipleIterationManager
 */
@Deprecated
public class ExecutorDoubleIterationManager extends AbstractIterationManager
{
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryTernaryOperation body;
	private @Nullable Object accumulatorValue;
	protected final @NonNull CollectionValue collectionValue;
	private @NonNull Iterator<? extends Object> iteratorValue1;
	private final @NonNull Iterator<? extends Object> iteratorValue2;
	private Object currentValue1;
	private Object currentValue2;

	/** @deprecated use Executor */
	@Deprecated
	public ExecutorDoubleIterationManager(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @NonNull LibraryTernaryOperation body,
			@Nullable CollectionValue collectionValue, @Nullable Object accumulatorValue) {
		this(ValueUtil.getExecutor(evaluator), returnTypeId, body, collectionValue, accumulatorValue);
	}

	/**
	 * @since 1.1
	 */
	public ExecutorDoubleIterationManager(@NonNull Executor executor, @NonNull TypeId returnTypeId, @NonNull LibraryTernaryOperation body,
			@Nullable CollectionValue collectionValue, @Nullable Object accumulatorValue) {
		super(executor);
		this.returnTypeId = returnTypeId;
		this.body = body;
		this.accumulatorValue = accumulatorValue;
		this.collectionValue = ValueUtil.asCollectionValue(collectionValue);
		this.iteratorValue1 = this.collectionValue.iterator();
		this.iteratorValue2 = this.collectionValue.iterator();
		currentValue1 = iteratorValue1.hasNext() ? iteratorValue1.next() : iteratorValue1;
		currentValue2 = iteratorValue2.hasNext() ? iteratorValue2.next() : iteratorValue2;
	}

	@Override
	public boolean advanceIterators() {
		if (iteratorValue1.hasNext()) {
			currentValue1 = iteratorValue1.next();
			return true;
		}
		else if (iteratorValue2.hasNext()) {
			currentValue2 = iteratorValue2.next();
			iteratorValue1 = collectionValue.iterator();
			if (iteratorValue1.hasNext()) {
				currentValue1 = iteratorValue1.next();
				return true;
			}
		}
		currentValue1 = iteratorValue1;
		currentValue2 = iteratorValue2;
		return false;
	}

	@Override
	public @Nullable Object evaluateBody() {
		return ((LibraryTernaryOperation.LibraryTernaryOperationExtension)body).evaluate(executor, returnTypeId, accumulatorValue,
			ClassUtil.nonNullState(currentValue1), ClassUtil.nonNullState(currentValue2));
	}

	@Override
	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
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
	public boolean hasCurrent() {
		return currentValue1 != iteratorValue1;
	}

	@Override
	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}