/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * AbstractAllInstancesOperation provides the common functionality for the allInstances() library operations.
 *
 * @since 1.18
 */
public abstract class AbstractAllInstancesOperation extends AbstractUnaryOperation
{

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull SetValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceVal);
	}

	@Override
	public abstract @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal);

	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		OCLExpression asSource = PivotUtil.getOwnedSource(callExp);
		Type asTypeValue = asSource.getTypeValue();
		if (asTypeValue != null) {
			return environmentFactory.getCompleteEnvironment().getSetType(asTypeValue, true, null, null);
		}
		else {
			return returnType;			// Shouldn't happen
		}
	}
}
