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

package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

/**
 * A specialized visitor that is used for evaluation an
 * {@linkplain OCLExpression OCL expression} by walking its AST.
 *
 * The Evaluator interface is deprecated. Its facilities should be obtained by getEvaluator().
 */
public interface EvaluationVisitor extends Visitor<Object>, Evaluator
{
	/**
	 * @since 1.1
	 */
	public interface EvaluationVisitorExtension extends EvaluationVisitor
	{
		@NonNull Executor getExecutor();

		/**
		 * Return the result of visiting visitable with the outer undecoratedVisitor.
		 */
		@Nullable Object visit(@NonNull Visitable visitable);
	}

	/** @deprecated no longer used */
	@Deprecated
	@Override
	@NonNull EvaluationVisitor createNestedEvaluator();

	@Override
	@Nullable Object evaluate(@NonNull OCLExpression body);

	/**
     * Obtains the environment factory that created me.
     *
	 * @return the environment factory
	 */
	@NonNull EnvironmentFactory getEnvironmentFactory();

	/**
     * Obtains the evaluation environment that keeps track of variable values
     * and knows how to call operations, navigate properties, etc.
     *
	 * @return the evaluation environment
	 */
	@Override
	@NonNull EvaluationEnvironment getEvaluationEnvironment();

	/** @deprecated use getExecutor */
	@Deprecated
	@NonNull EvaluationVisitor getEvaluator();

	/** @deprecated moved to Evaluator */
	@Deprecated
	@NonNull MetamodelManager getMetamodelManager();

	/** @deprecated moved to Evaluator */
	@Override
	@Deprecated
	@NonNull ModelManager getModelManager();

	@Nullable Monitor getMonitor();

	/** @deprecated moved to Evaluator */
	@Deprecated
	@Override
	@NonNull StandardLibrary getStandardLibrary();

	@Override
	boolean isCanceled();

	@Override
	void setCanceled(boolean isCanceled);

	void setMonitor(@Nullable Monitor monitor);

    /**
     * Configures the specified decorated visitor to correctly handle the
     * invocation of recursive <code>visitXxx(...)</code> calls.  In particular,
     * the tail of a chain of decorators is informed (if it is an
     * {@link AbstractEvaluationVisitor} of the head decorator of the chain,
     * so that recursive visitation follows the entire decorator chain at
     * every step.
     *
     * @param evaluationVisitor the evaluationVisitor that is not decorated/
     */
	void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor);
}
