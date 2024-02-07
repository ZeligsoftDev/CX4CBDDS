/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * AbstractPolyOperation supports arguments with a variety of argument lengths operations.
 */
public abstract class AbstractPolyOperation extends AbstractOperation implements
LibraryUnaryOperation.LibraryUnaryOperationExtension,
LibraryBinaryOperation.LibraryBinaryOperationExtension,
LibraryTernaryOperation.LibraryTernaryOperationExtension
{
	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		TypeId typeId = callExp.getTypeId();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		if (arguments.size() == 0) {
			return evaluate(executor, typeId, sourceValue);
		}
		OCLExpression argument0 = arguments.get(0);
		assert argument0 != null;
		Object firstArgument = executor.evaluate(argument0);
		if (arguments.size() == 1) {
			return evaluate(executor, typeId, sourceValue, firstArgument);
		}
		OCLExpression argument1 = arguments.get(1);
		assert argument1 != null;
		Object secondArgument = executor.evaluate(argument1);
		if (arguments.size() == 2) {
			return evaluate(executor, typeId, sourceValue, firstArgument, secondArgument);
		}
		Object[] argumentValues = new Object[arguments.size()];
		argumentValues[0] = firstArgument;
		argumentValues[1] = secondArgument;
		for (int i = 2; i < arguments.size(); i++) {
			OCLExpression argument = arguments.get(i);
			assert argument != null;
			argumentValues[i] = executor.evaluate(argument);
		}
		return evaluate(executor, typeId, sourceValue, argumentValues);
	}

	/** @deprecated use Executor
	 * @since 1.1
	 */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
	}

	/** @deprecated use Executor
	 * @since 1.1
	 */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object argVal) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, argVal);
	}

	/** @deprecated use Executor
	 * @since 1.1
	 */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		TypeId typeId = caller.getTypeId();
		if (boxedSourceAndArgumentValues.length == 1) {
			return evaluate(executor, typeId, boxedSourceAndArgumentValues[0]);
		}
		if (boxedSourceAndArgumentValues.length == 2) {
			return evaluate(executor, typeId, boxedSourceAndArgumentValues[0], boxedSourceAndArgumentValues[1]);
		}
		if (boxedSourceAndArgumentValues.length == 3) {
			return evaluate(executor, typeId, boxedSourceAndArgumentValues[0], boxedSourceAndArgumentValues[1], boxedSourceAndArgumentValues[2]);
		}
		return evaluate(executor, typeId, boxedSourceAndArgumentValues);
	}
}
