/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * AbstractSimpleTernaryOperation defines the default implementation of a ternary operation redirecting the
 * invocation to the argument-only form.
 */
public abstract class AbstractSimpleTernaryOperation extends AbstractUntypedTernaryOperation implements LibrarySimpleTernaryOperation.LibrarySimpleTernaryOperationExtension
{
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		return dispatch(getExecutor(evaluator), callExp, sourceValue);
	}

	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		assert !PivotUtil.getReferredOperation(callExp).isIsValidating();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		OCLExpression argument0 = arguments.get(0);
		OCLExpression argument1 = arguments.get(1);
		assert argument0 != null;
		assert argument1 != null;
		Object firstArgument = executor.evaluate(argument0);
		Object secondArgument = executor.evaluate(argument1);
		return evaluate(sourceValue, firstArgument, secondArgument);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable /*@Thrown*/ Object evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(getExecutor(evaluator), sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		if (boxedSourceAndArgumentValues.length == 3) {
			return evaluate(boxedSourceAndArgumentValues[0], boxedSourceAndArgumentValues[1], boxedSourceAndArgumentValues[2]);
		}
		else {
			return super.evaluate(executor, caller, boxedSourceAndArgumentValues);
		}
	}

	// Redundant declaration needed for API compatibility.
	@Override
	public abstract @Nullable /*@Thrown*/ Object evaluate(@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue);
}
