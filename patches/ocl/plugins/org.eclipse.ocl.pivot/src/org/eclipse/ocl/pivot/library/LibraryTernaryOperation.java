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
import org.eclipse.ocl.pivot.ids.TypeId;

/**
 * LibraryTernaryOperation defines the invocation API of a ternary operation using
 * <br>
 * either an evaluator call expression, source and argument array
 * <br>
 * or an evaluator return type id and arguments.
 */
public interface LibraryTernaryOperation extends LibraryOperation
{
	/**
	 * @since 1.1
	 */
	public interface LibraryTernaryOperationExtension extends LibraryTernaryOperation, LibraryOperationExtension
	{
		/**
		 * Return the result of evaluating the operation on source with arg1 and arg2.
		 * An invalid return may be indicated by throwing an exception returning Java null or OCL invalid.
		 */
		@Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue);
	}

	/** @deprecated use Executor */
	@Deprecated
	@Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue);
}
