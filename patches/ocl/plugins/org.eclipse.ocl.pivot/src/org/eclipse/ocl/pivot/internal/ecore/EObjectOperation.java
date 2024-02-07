/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.Executor.ExecutorExtension;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * An EObjectOperation provides the standard LibraryOperation to implement an EOperation defined by an OCL specification.
 * The specification is resolved lazily and so an invalid specification may throw an InvalidValueException at run-time.
 */
public class EObjectOperation extends AbstractOperation
{
	protected final @NonNull Operation operation;
	protected final @NonNull EOperation eFeature;
	protected final @NonNull ExpressionInOCL specification;

	public EObjectOperation(@NonNull Operation operation, @NonNull EOperation eFeature, @NonNull ExpressionInOCL specification) {
		this.operation = operation;
		this.eFeature = eFeature;
		this.specification = specification;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] boxedSourceAndArgumentValues) {
		if (specification.getOwnedBody() == null) {
			try {
				EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) executor.getEnvironmentFactory();
				environmentFactory.parseSpecification(specification);
			} catch (ParserException e) {
				throw new InvalidValueException(e, "parse failure", executor.getEvaluationEnvironment(), boxedSourceAndArgumentValues[0], caller);
			}
		}
		ExpressionInOCL query = specification;
		EvaluationEnvironment nestedEvaluationEnvironment = ((ExecutorExtension)executor).pushEvaluationEnvironment(query, caller);
		nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(query.getOwnedContext()), boxedSourceAndArgumentValues[0]);
		List<Variable> parameterVariables = query.getOwnedParameters();
		int iMax = Math.min(parameterVariables.size(), boxedSourceAndArgumentValues.length-1);
		for (int i = 0; i < iMax; i++) {
			nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(parameterVariables.get(i)), boxedSourceAndArgumentValues[i+1]);
		}
		try {
			return executor.evaluate(ClassUtil.nonNullPivot(query.getOwnedBody()));
		}
		finally {
			executor.popEvaluationEnvironment();
		}
	}

	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		assert !PivotUtil.getReferredOperation(callExp).isIsValidating();
		List<@NonNull OCLExpression> arguments = ClassUtil.nullFree(callExp.getOwnedArguments());
		@Nullable Object[] sourceAndArgumentValues = new @Nullable Object[1+arguments.size()];
		int argumentIndex = 0;
		sourceAndArgumentValues[argumentIndex++] = sourceValue;
		for (@NonNull OCLExpression argument : arguments) {
			sourceAndArgumentValues[argumentIndex++] = executor.evaluate(argument);
		}
		return evaluate(executor, callExp, sourceAndArgumentValues);
	}
}