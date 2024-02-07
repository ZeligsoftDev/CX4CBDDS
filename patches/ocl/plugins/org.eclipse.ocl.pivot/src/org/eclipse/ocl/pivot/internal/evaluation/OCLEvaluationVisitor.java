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

package org.eclipse.ocl.pivot.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;

/**
 * An evaluation visitor implementation for OCL expressions.
 */
public class OCLEvaluationVisitor extends BasicEvaluationVisitor
{
	/** @deprecated use ExecutorInternal */
	@Deprecated
	public OCLEvaluationVisitor(@NonNull EvaluationEnvironment evalEnv) {
		super(((EvaluationEnvironment.EvaluationEnvironmentExtension)evalEnv).getExecutor());
	}

	/**
	 * @since 1.1
	 */
	public OCLEvaluationVisitor(@NonNull ExecutorInternal executor) {
		super(executor);
	}
	
	/** @deprecated visitors do not nest any more */
	@Deprecated
	public EvaluationVisitor createNestedUndecoratedEvaluator(@NonNull NamedElement namedElement) {
		throw new UnsupportedOperationException();
	}

	/** @deprecated no longer used */
	@Deprecated
	protected Object evaluatePropertyCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty) {
		throw new UnsupportedOperationException();
	}
}
