/*******************************************************************************
 * Copyright (c) 2010, 2021 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.ProblemAware;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.Query;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * @since 1.14
 */
public class BasicQueryImpl implements Query, ProblemAware
{
	private final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull ExpressionInOCL query;
	private final @NonNull OCLExpression expression;
	private ModelManager modelManager = null;
	private EvaluationEnvironment evaluationEnvironment = null;
	private Diagnostic evalProblems;
	private BasicDiagnostic batchEvalProblems;

	public BasicQueryImpl(@NonNull EnvironmentFactory environmentFactory, @NonNull ExpressionInOCL query) {
		this.environmentFactory = environmentFactory;
		this.query = query;
		this.expression = ClassUtil.nonNullState(query.getOwnedBody());
//		this.modelManager = ocl.getModelManager();
	}

	@Override
	public boolean checkBoxed(@Nullable Object boxedObject) {
		if (resultType() != environmentFactory.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					PivotMessagesInternal.BooleanQuery_ERROR_);
			HelperUtil.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}

		Object result = evaluateBoxed(boxedObject);
		return result == ValueUtil.TRUE_VALUE;
	}

	@Override
	public boolean checkBoxed(@NonNull Iterable<?> boxedObjects) {
		if (resultType() != environmentFactory.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					PivotMessagesInternal.BooleanQuery_ERROR_);
			HelperUtil.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		for (Object boxedObject : boxedObjects) {
			Object result = evaluateBoxed(boxedObject);
			if (result != ValueUtil.TRUE_VALUE) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkEcore(@Nullable Object ecoreObject) {
		if (resultType() != environmentFactory.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					PivotMessagesInternal.BooleanQuery_ERROR_);
			HelperUtil.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}

		Object result = evaluateEcore(null, ecoreObject);
		return result == ValueUtil.TRUE_VALUE;
	}

	@Override
	public boolean checkEcore(@NonNull Iterable<?> ecoreObjects) {
		if (resultType() != environmentFactory.getStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					PivotMessagesInternal.BooleanQuery_ERROR_);
			HelperUtil.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		for (Object ecoreObject : ecoreObjects) {
			Object result = evaluateEcore(null, ecoreObject);
			if (result != ValueUtil.TRUE_VALUE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Assigns collected interim diagnostics of batch evaluation to the
	 * resulting evaluation problems.
	 */
	private void commitBatchEvaluateProblems() {
		evalProblems = batchEvalProblems;
		batchEvalProblems = null;
	}

	@Override
	public @Nullable Object evaluateBoxed(@Nullable Object boxedValue) {
		Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
		try {
			if (savedExecutor != null) {
				ThreadLocalExecutor.setExecutor(null);		// New evaluation needs new root EvaluationEnvironment and so new Executor, but old modelManager
			}
			// lazily create the evaluation environment, if not already done by
			//    the client.  Initialize it with the "self" context variable
			EvaluationEnvironment myEnv = getEvaluationEnvironment(environmentFactory.getIdResolver().unboxedValueOf(boxedValue));
			Variable contextVariable = ClassUtil.nonNullState(query.getOwnedContext());
			myEnv.add(contextVariable, boxedValue);
	//		Variable resultVariable = specification.getResultVariable();
	//		if (resultVariable != null) {
	//			myEnv.add(resultVariable, null);
	//		}

			EvaluationVisitor ev = environmentFactory.createEvaluationVisitor(myEnv);

			Object boxedResult;

			try {
				boxedResult = expression.accept(ev);
			} catch (EvaluationHaltedException e) {
				evalProblems = e.getDiagnostic();
	//			result = valueFactory.createInvalidValue(obj, null, evalProblems.toString(), e);
				throw e;
	//		} finally {
	//			myEnv.remove(specification.getContextVariable());
	//			if (resultVariable != null) {
	//				myEnv.add(resultVariable, null);
	//			}
		}
		return boxedResult;
	}
	finally {
		ThreadLocalExecutor.setExecutor(savedExecutor);		// Restore invoker's executor
	}
	}

	@Override
	public @NonNull List<?> evaluateBoxed(@NonNull Iterable<?> boxedObjects) {
		List<Object> boxedResults = new ArrayList<Object>();
		try {
			for (Object boxedObject : boxedObjects) {
				boxedResults.add(evaluateBoxed(boxedObject));
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}
		return boxedResults;
	}

	@Override
	public @Nullable Object evaluateEcore(@Nullable Object ecoreObject) throws EvaluationException {
		return evaluateEcore(null, ecoreObject);
	}

	@Override
	public @Nullable Object evaluateEcore(@Nullable Class<?> instanceClass, @Nullable Object ecoreObject) throws EvaluationException {
		evalProblems = null;
		IdResolver idResolver = environmentFactory.getIdResolver();
		Object boxedValue = idResolver.boxedValueOf(ecoreObject);
		Object boxedResult = evaluateBoxed(boxedValue);
		return idResolver.ecoreValueOf(instanceClass, boxedResult);
	}

	@Override
	public @NonNull EList<?> evaluateEcore(@NonNull Iterable<?> ecoreObjects) throws EvaluationException {
		return evaluateEcore(null, ecoreObjects);
	}

	@Override
	public @NonNull EList<?> evaluateEcore(@Nullable Class<?> instanceClass, @NonNull Iterable<?> ecoreObjects) {
		EList<Object> ecoreResults = new BasicEList<Object>();
		try {
			for (Object ecoreObject : ecoreObjects) {
				ecoreResults.add(evaluateEcore(instanceClass, ecoreObject));
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}
		return ecoreResults;
	}

	@Override
	public @Nullable Object evaluateUnboxed(@Nullable Object unboxedObject) throws EvaluationException {
		evalProblems = null;
		IdResolver idResolver = environmentFactory.getIdResolver();
		Object boxedValue = idResolver.boxedValueOf(unboxedObject);
		Object boxedResult = evaluateBoxed(boxedValue);
		return idResolver.unboxedValueOf(boxedResult);
	}

	@Override
	public @NonNull EvaluationEnvironment getEvaluationEnvironment(@Nullable Object unboxedObject) {
		EvaluationEnvironment evaluationEnvironment2 = evaluationEnvironment;
		if (evaluationEnvironment2 == null) {
			ModelManager modelManager2 = modelManager;
			if (modelManager2 == null) {
				modelManager = modelManager2 = environmentFactory.createModelManager(unboxedObject);
			}
			evaluationEnvironment = evaluationEnvironment2 = environmentFactory.createEvaluationEnvironment(query, modelManager2);
		}
		return evaluationEnvironment2;
	}

	@Override
	public @NonNull OCLExpression getExpression() {
		return expression;
	}

	@Override
	public @NonNull OCL getOCL() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Diagnostic getProblems() {
		return evalProblems;
	}

	/**
	 * Handles problems of single evaluation performed on behalf of batch
	 * evaluate invocation.
	 */
	private void handleNextEvaluateProblems() {
		Diagnostic nextEvalProblems = getProblems();
		if (nextEvalProblems != null) {
			if (batchEvalProblems == null) {
				BasicDiagnostic rootDiagnostic = new BasicDiagnostic(
					nextEvalProblems.getSeverity(), PivotPlugin.PLUGIN_ID,
					nextEvalProblems.getCode(), nextEvalProblems.getMessage(),
					null);

				batchEvalProblems = rootDiagnostic;
			}

			batchEvalProblems.add(nextEvalProblems);
		}
	}

	@Override
	public String queryText() {
		return expression.toString();
	}

	@Override
	public @NonNull <T> List<T> rejectEcore(@NonNull Iterable<T> ecoreObjects) {
		List<T> result = new BasicEList<T>();
		try {
			for (T ecoreObject : ecoreObjects) {
				if (!checkEcore(ecoreObject)) {
					result.add(ecoreObject);
				}
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}
		return result;
	}

	@Override
	public Type resultType() {
		return expression.getType();
	}

	@Override
	public @NonNull <T> List<T> selectEcore(@NonNull Iterable<T> ecoreObjects) {
		List<T> result = new BasicEList<T>();
		try {
			for (T ecoreObject : ecoreObjects) {
				if (checkEcore(ecoreObject)) {
					result.add(ecoreObject);
				}
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
		}
		return result;
	}

	@Override
    public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("Query["); //$NON-NLS-1$
		result.append(queryText());
		result.append(']');

		return result.toString();
	}
}
