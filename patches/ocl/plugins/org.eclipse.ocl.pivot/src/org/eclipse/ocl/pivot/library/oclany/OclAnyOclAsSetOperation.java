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
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * OclAnyOclAsSetOperation realises the OclAny::oclAsSet() library operation.
 */
public class OclAnyOclAsSetOperation extends AbstractUnaryOperation
{
	public static final @NonNull OclAnyOclAsSetOperation INSTANCE = new OclAnyOclAsSetOperation();
	
	/** @deprecated use Executor */
	@Deprecated
	@Override
	public @NonNull SetValue evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		return evaluate(getExecutor(evaluator), returnTypeId, sourceValue); 
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		if (sourceVal instanceof InvalidValueException) {
			throw (InvalidValueException)sourceVal;
		}
		else if (sourceVal == null) {
			return executor.getIdResolver().createSetOfEach((CollectionTypeId)returnTypeId);
		}
		else {
			return executor.getIdResolver().createSetOfEach((CollectionTypeId)returnTypeId, sourceVal);
		}
	}
}
