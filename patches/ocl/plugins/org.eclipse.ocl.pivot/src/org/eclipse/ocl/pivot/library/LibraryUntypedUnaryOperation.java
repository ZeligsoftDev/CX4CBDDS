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
package org.eclipse.ocl.pivot.library;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * LibraryUntypedUnaryOperation extends the invocation API of a unary operation to support using just
 * <br>
 * an evaluator and arguments.
 */
public interface LibraryUntypedUnaryOperation extends LibraryUnaryOperation, LibraryUntypedOperation
{
	/**
	 * @since 1.1
	 */
	public interface LibraryUntypedUnaryOperationExtension extends LibraryUntypedUnaryOperation, LibraryUnaryOperation.LibraryUnaryOperationExtension
	{
		@Nullable Object evaluate(@NonNull Executor executor, @Nullable Object sourceValue);
	}
	/** @deprecated use Executor */
	@Deprecated
	@Nullable Object evaluate(@NonNull Evaluator evaluator, @Nullable Object sourceValue);
}
