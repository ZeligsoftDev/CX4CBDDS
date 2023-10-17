/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (CEA LIST) - Bug 425799 - validity view
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.Executor.ExecutorExtension;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * An instance of ConstrainedOperation supports evaluation of
 * an operation defined by constraints.
 */
public class ConstrainedOperation extends AbstractOperation
{
	protected final @NonNull ExpressionInOCL expressionInOCL;

	public ConstrainedOperation(@NonNull ExpressionInOCL expressionInOCL) {
		this.expressionInOCL = expressionInOCL;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		PivotUtil.checkExpression(expressionInOCL);
		EvaluationEnvironment nestedEvaluationEnvironment = ((ExecutorExtension)executor).pushEvaluationEnvironment(expressionInOCL, caller);
		nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(expressionInOCL.getOwnedContext()), boxedSourceAndArgumentValues[0]);
		List<Variable> parameters = expressionInOCL.getOwnedParameters();
		if (!parameters.isEmpty()) {
			for (int i = 0; i < parameters.size(); i++) {
				Object value = boxedSourceAndArgumentValues[i+1];
				nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(parameters.get(i)), value);
			}
		}
		try {
			OCLExpression bodyExpression = expressionInOCL.getOwnedBody();
			assert bodyExpression != null;
			return executor.evaluate(bodyExpression);
		}
		finally {
			executor.popEvaluationEnvironment();
		}
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		assert !PivotUtil.getReferredOperation(callExp).isIsValidating();
		List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
		@Nullable Object[] boxedSourceAndArgumentValues = new @Nullable Object[1+arguments.size()];
		boxedSourceAndArgumentValues[0]= sourceValue;
		for (int i = 0; i < arguments.size(); i++) {
			OCLExpression argument = arguments.get(i);
			assert argument != null;
			boxedSourceAndArgumentValues[1+i] = executor.evaluate(argument);
		}
		return evaluate(executor, callExp, boxedSourceAndArgumentValues);
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(expressionInOCL.eContainer());
	}
}