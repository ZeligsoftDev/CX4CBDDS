/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * AbstractSimpleUnaryOperation defines the default implementation of a unary operation redirecting the
 * invocation to the argument-only form.
 */
public abstract class AbstractSimpleUnaryOperation extends AbstractUntypedUnaryOperation implements LibrarySimpleUnaryOperation.LibrarySimpleUnaryOperationExtension
{
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		return dispatch(getExecutor(evaluator), callExp, sourceValue);
	}

	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		return evaluate(sourceValue);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(sourceValue);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable /*@Thrown*/ Object evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @Nullable Object sourceValue) {
		return evaluate(sourceValue);
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		if (boxedSourceAndArgumentValues.length == 1) {
			return evaluate(boxedSourceAndArgumentValues[0]);
		}
		else {
			return super.evaluate(executor, caller, boxedSourceAndArgumentValues);
		}
	}

	// Redundant declaration needed for API compatibility.
	@Override
	public abstract @Nullable /*@Thrown*/ Object evaluate(@Nullable Object sourceValue);
}
