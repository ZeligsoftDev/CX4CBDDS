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
package org.eclipse.ocl.pivot.library.string;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedUnaryOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * CGStringGetSeverityOperation realises the String::getSeverity() library operation used as the
 * precursor to a validation.
 */
public class CGStringGetSeverityOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull CGStringGetSeverityOperation INSTANCE = new CGStringGetSeverityOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull IntegerValue evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), sourceValue); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull IntegerValue evaluate(@NonNull Executor executor, @Nullable Object sourceValue) {
		return ValueUtil.integerValueOf(executor.getSeverity(sourceValue));
	}
}
