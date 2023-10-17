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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.IterationManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractIterationManager;
import org.eclipse.ocl.pivot.library.LibraryBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryTernaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;

/**
 * ExecutorSingleMapIterationManager supervises a single iterator map iteration evaluation for which the iteration context is
 * maintained in dedicated variables typically allocated by the code generator.
 *
 * @since 1.6
 */
public class ExecutorSingleMapIterationManager extends AbstractIterationManager
{
	class Nested extends ExecutorSingleMapIterationManager
	{
		protected final @NonNull ExecutorSingleMapIterationManager rootIterationManager;
		protected final int depth;

		protected Nested(@NonNull ExecutorSingleMapIterationManager iterationManager, @NonNull MapValue mapValue) {
			super(iterationManager, mapValue);
			this.rootIterationManager = iterationManager.getRootIterationManager();
			this.depth = iterationManager.getDepth() + 1;
		}

		@Override
		public int getDepth() {
			return depth;
		}

		@Override
		public @NonNull ExecutorSingleMapIterationManager getRootIterationManager() {
			return rootIterationManager;
		}

		@Override
		public @NonNull CollectionValue getSourceCollection() {
			return rootIterationManager.getSourceCollection();
		}
	}

	protected final @NonNull MapValue mapValue;
	protected final @NonNull TypeId returnTypeId;
	protected final @NonNull LibraryBinaryOperation body;
	private @Nullable Object accumulatorValue;
	protected final @NonNull Iterator<? extends Object> iteratorValue;
	private Object currentKeyValue;		// 'null' is a valid value so 'iteratorValue' is used as end of iteration
	private Object currentValueValue;	// 'null' is a valid value

	public ExecutorSingleMapIterationManager(@NonNull Executor executor, @NonNull TypeId returnTypeId, @NonNull LibraryBinaryOperation body,
			@Nullable MapValue mapValue, @Nullable Object accumulatorValue) {
		super(executor);
		this.mapValue = ValueUtil.asMapValue(mapValue);
		this.returnTypeId = returnTypeId;
		this.body = body;
		updateAccumulator(accumulatorValue);
		this.iteratorValue = this.mapValue.iterator();
		advanceIterators();
	}

	protected ExecutorSingleMapIterationManager(@NonNull ExecutorSingleMapIterationManager iterationManager, @NonNull MapValue mapValue) {
		super(iterationManager.getExecutor());
		this.mapValue = mapValue;
		this.returnTypeId = iterationManager.returnTypeId;
		this.body = iterationManager.body;
		this.accumulatorValue = iterationManager.accumulatorValue;
		this.iteratorValue = mapValue.iterator();
		advanceIterators();
	}

	@Override
	public boolean advanceIterators() {
		currentKeyValue = iteratorValue.hasNext() ? iteratorValue.next() : iteratorValue;
		currentValueValue = mapValue.at(currentKeyValue);
		return currentKeyValue != iteratorValue;
	}

	@Override
	public @NonNull IterationManager createNestedIterationManager(@NonNull IterableValue value) {
		return new Nested(this, (MapValue)value);
	}

	@Override
	public @Nullable Object evaluateBody() {
		return ((LibraryTernaryOperation.LibraryTernaryOperationExtension)body).evaluate(executor, returnTypeId, accumulatorValue, get(), getValue());
	}

	@Override
	public @Nullable Object get() {
		return currentKeyValue;
	}

	@Override
	public @Nullable Object getAccumulatorValue() {
		return accumulatorValue;
	}

	public int getDepth() {
		return 0;
	}

	public @NonNull ExecutorSingleMapIterationManager getRootIterationManager() {
		return this;
	}

	@Override
	public @NonNull IterableValue getSourceIterable() {
		return mapValue;
	}

	//	@Override
	public @Nullable Object getValue() {
		return currentValueValue;
	}

	@Override
	public boolean hasCurrent() {
		return currentKeyValue != iteratorValue;
	}

	@Override
	public @Nullable Object updateAccumulator(Object newValue) {
		this.accumulatorValue = newValue;
		return null;					// carry on
	}
}