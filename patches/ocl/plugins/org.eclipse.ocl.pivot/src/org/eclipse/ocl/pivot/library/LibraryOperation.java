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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 */
public interface LibraryOperation extends LibraryIterationOrOperation
{
	/**
	 * @since 1.1
	 */
	public interface LibraryOperationExtension extends LibraryOperation
	{
		/**
		 * Return the result of evaluating callExp and its arguments upon sourceValue within the environment
		 * provided by evaluator. An invalid return may be indicated by throwing an exception,
		 * returning Java null, or returning OCL invalid.
		 * <p>
		 * This invocation evaluates the arguments as required. Derived implementations may implement short circuit processing
		 * to skip redundant evaluation of later arguments.
		 * <p>
		 * Invocations may bypass dispatch if a derived LibraryOperation such as LibrarySimpleBinaryOperation
		 * makes its internal evaluate signature available for use after a type test and cast.
		 */
		@Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue);
	}

	/**
	 * @since 1.3
	 */
	public interface LibraryOperationExtension2 extends LibraryOperationExtension
	{
		/**
		 * Return the cached evaluation from sourceAndArgumentValues, using newInstance(sourceAndArgumentValues) to
		 * create a new evaluation instance if necessary.
		 */
		@Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues);

		/**
		 * Evaluate this operation using the boxedSourceAndArgumentValues in conjunction with the executor. The call
		 * to this operation is provided by the caller. The impementation of the evaluate API and related methods may
		 * that the caller has checked that source and arguments conform to this operation's declaration.
		 *
		 * @throws InvalidValueException for a well-behaved failure such as an invalid value
		 * @throws EvaluationHaltedException for an external abort request
		 * @throws for an uncontrolled failure that should be treated as invalid
		 */
		@Nullable Object evaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Nullable Object dispatch(@NonNull Evaluator evaluator, @NonNull OperationCallExp callExp, @Nullable Object sourceValue);
}
