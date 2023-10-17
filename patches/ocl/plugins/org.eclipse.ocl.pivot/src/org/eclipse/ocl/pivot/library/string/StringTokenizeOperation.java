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
package org.eclipse.ocl.pivot.library.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractPolyOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SequenceValue;

/**
 * StringTokenizeOperation realises the String::tokenize() library operations.
 */
public class StringTokenizeOperation extends AbstractPolyOperation
{
	public static final @NonNull StringTokenizeOperation INSTANCE = new StringTokenizeOperation();
	private static final @NonNull String DELIMS = " \t\n\r\f"; //$NON-NLS-1$

	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		String delims = DELIMS;
		boolean returnDelims = false;
		TypeId typeId = callExp.getTypeId();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		if (arguments.size() > 0) {
			if (arguments.size() > 1) {
				if (arguments.size() > 2) {
					throw new InvalidValueException(PivotMessages.InvalidArgument, arguments.get(2));
				}
				OCLExpression argument1 = arguments.get(1);
				assert argument1 != null;
				Object secondArgument = executor.evaluate(argument1);
				returnDelims = asBoolean(secondArgument);
			}
			OCLExpression argument0 = arguments.get(0);
			assert argument0 != null;
			Object firstArgument = executor.evaluate(argument0);
			delims = asString(firstArgument);
		}
		return evaluate(executor, (CollectionTypeId)typeId, sourceValue, delims, returnDelims);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable SequenceValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SequenceValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(executor, (CollectionTypeId)returnTypeId, sourceValue, DELIMS, false);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable SequenceValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, argumentValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SequenceValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object argumentValue) {
		String delims = asString(argumentValue);
		return evaluate(executor, (CollectionTypeId)returnTypeId, sourceValue, delims, false);
	}

	/** @deprecated use Executor
	 * @since 1.1*/
	@Deprecated
	@Override
	public @Nullable SequenceValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue, firstArgumentValue, secondArgumentValue);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SequenceValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		String delims = asString(firstArgumentValue);
		boolean returnDelims = asBoolean(secondArgumentValue);
		return evaluate(executor, (CollectionTypeId)returnTypeId, sourceValue, delims, returnDelims);
	}

	/*	public @NonNull SequenceValue evaluate(@NonNull Executor executor, @NonNull DomainCallExp callExp, @Nullable Object sourceValue, @NonNull Object... argumentValues) {
		String delims = DELIMS;
		boolean returnDelims = false;
		if (argumentValues.length > 0) {
			if (argumentValues.length > 1) {
				if (argumentValues.length > 2) {
					throw new InvalidValueException(EvaluatorMessages.InvalidArgument, argumentValues[2]);
				}
				Object argumentValue1 = argumentValues[1];
				assert argumentValue1 != null;
				returnDelims = asBoolean(argumentValue1);
			}
			Object argumentValue0 = argumentValues[0];
			assert argumentValue0 != null;
			delims = asString(argumentValue0);
		}
		return evaluate(executor, (CollectionTypeId)ClassUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceValue, delims, returnDelims);
	} */

	private @NonNull SequenceValue evaluate(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId, @Nullable Object sourceValue, @NonNull String delims, boolean returnDelims) {
		String sourceString = asString(sourceValue);
		StringTokenizer tokenizer = new StringTokenizer(sourceString, delims, returnDelims);
		List<Object> results = new ArrayList<Object>();
		while (tokenizer.hasMoreTokens()) {
			@SuppressWarnings("null") @NonNull String nextToken = tokenizer.nextToken();
			results.add(nextToken);
		}
		return createSequenceValue(returnTypeId, results);
	}

	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		return cachedEvaluate(executor, caller, boxedSourceAndArgumentValues);
	}

	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
		String delims = DELIMS;
		boolean returnDelims = false;


		if (sourceAndArgumentValues.length > 1) {
			if (sourceAndArgumentValues.length > 2) {
				if (sourceAndArgumentValues.length > 3) {
					throw new InvalidValueException(PivotMessages.InvalidArgument, sourceAndArgumentValues[3]);
				}
				Object argument1 = sourceAndArgumentValues[2];
				//				assert argument1 != null;
				returnDelims = asBoolean(argument1);
				//				Object secondArgument = executor.evaluate(argument1);
				//				returnDelims = asBoolean(secondArgument);
			}
			Object argument0 = sourceAndArgumentValues[1];
			//			assert argument0 != null;
			//			Object firstArgument = executor.evaluate(argument0);
			delims = asString(argument0);
		}
		return evaluate(executor, (CollectionTypeId)ClassUtil.nonNullPivot(caller.getTypeId()), sourceAndArgumentValues[0], delims, returnDelims);





		/*		if (sourceAndArgumentValues.length > 1) {
			if (sourceAndArgumentValues.length > 2) {
				if (sourceAndArgumentValues.length > 3) {
					throw new InvalidValueException(PivotMessages.InvalidArgument, sourceAndArgumentValues[3]);
				}
				Object argumentValue1 = sourceAndArgumentValues[2];
				assert argumentValue1 != null;
				returnDelims = asBoolean(argumentValue1);
			}
			Object argumentValue0 = sourceAndArgumentValues[1];
			assert argumentValue0 != null;
			delims = asString(argumentValue0);
		}
		return evaluate(executor, (CollectionTypeId)ClassUtil.nonNullPivot(callExp.getType()).getTypeId(), sourceAndArgumentValues[0], delims, returnDelims);
		//		return super.basicEvaluate(executor, callExp, sourceAndArgumentValues);
		 */	}
}
