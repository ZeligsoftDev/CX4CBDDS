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
package org.eclipse.ocl.pivot.library.oclany;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationLogger;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractPolyOperation;

/**
 * OclAnyOclLogOperation realises the OclAny::oclLog() library operation.
 */
public class OclAnyOclLogOperation extends AbstractPolyOperation
{
	public static final @NonNull OclAnyOclLogOperation INSTANCE = new OclAnyOclLogOperation();

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		try {
			EvaluationLogger log = executor.getLogger();
			if (log != null) {
				log.append(getSourceText(sourceVal));
			}
		}
		catch (Exception e) {}
		catch (AssertionError e) {}
		return sourceVal;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceVal, @Nullable Object argVal) {
		try {
			String message = asString(argVal);
			EvaluationLogger log = executor.getLogger();
			if (log != null) {
				log.append(message + getSourceText(sourceVal));
			}
		}
		catch (Exception e) {}
		catch (AssertionError e) {}
		return sourceVal;
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId,
			@Nullable Object sourceValue, @Nullable Object firstArgumentValue, @Nullable Object secondArgumentValue) {
		throw new UnsupportedOperationException();
	}

	protected @NonNull String getSourceText(@Nullable Object sourceVal) {
		if (sourceVal == null) {
			return "null"; //$NON-NLS-1$
		}
		String string = sourceVal.toString();
		if (string == null) {
			return "null"; //$NON-NLS-1$
		}
		return string;
	}
}
