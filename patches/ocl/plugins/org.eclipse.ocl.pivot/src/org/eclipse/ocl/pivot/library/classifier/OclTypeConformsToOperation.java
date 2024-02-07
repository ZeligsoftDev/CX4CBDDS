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
package org.eclipse.ocl.pivot.library.classifier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedBinaryOperation;

/**
 * OclTypeConformsToOperation realises the OclType::conformsTo(OclType) library operation.
 */
public class OclTypeConformsToOperation extends AbstractUntypedBinaryOperation
{
	public static final @NonNull OclTypeConformsToOperation INSTANCE = new OclTypeConformsToOperation();

	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @Nullable Boolean evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceVal, @Nullable Object argVal) {
		return evaluate(getExecutor(evaluator), sourceVal, argVal);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull Boolean evaluate(@NonNull Executor executor, @Nullable Object sourceVal, @Nullable Object argVal) {
		StandardLibrary standardLibrary = executor.getStandardLibrary();
		Type thisType = asType(sourceVal);
		Type thatType = asType(argVal);
		boolean result = thisType.conformsTo(standardLibrary, thatType);
		return result;
	}
}
