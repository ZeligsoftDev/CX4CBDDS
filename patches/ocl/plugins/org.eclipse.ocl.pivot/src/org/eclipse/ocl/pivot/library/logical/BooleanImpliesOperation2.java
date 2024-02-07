/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library.logical;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractSimpleBinaryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;

/**
 * BooleanImpliesOperation2 realises the 2-valued implies() library operation.
 *
 * @since 1.3
 */
public class BooleanImpliesOperation2 extends AbstractSimpleBinaryOperation
{
	public static final @NonNull BooleanImpliesOperation2 INSTANCE = new BooleanImpliesOperation2();

	@Override
	public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
		if (sourceValue == Boolean.FALSE) {
			return TRUE_VALUE;
		}
		Boolean sourceBoolean = ValueUtil.asBoolean(sourceValue);
		OCLExpression argument = PivotUtil.getOwnedArgument(callExp, 0);
		Object argumentValue = executor.evaluate(argument);
		Boolean argBoolean = ValueUtil.asBoolean(argumentValue);
		return evaluate(sourceBoolean, argBoolean);
	}

	@Override
	public @NonNull Boolean evaluate(@Nullable Object left, @Nullable Object right) {
		if ((left == Boolean.FALSE) || (right == Boolean.TRUE)) {
			return TRUE_VALUE;
		}
		else  {
			return FALSE_VALUE;
		}
	}
}
