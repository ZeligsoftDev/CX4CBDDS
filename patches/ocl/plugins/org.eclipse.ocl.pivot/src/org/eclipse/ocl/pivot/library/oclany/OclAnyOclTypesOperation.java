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
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * OclAnyOclTypesOperation realises the OclAny::oclTypes() library operation.
 * @since 1.1
 */
public class OclAnyOclTypesOperation extends AbstractUnaryOperation
{
	public static final @NonNull OclAnyOclTypesOperation INSTANCE = new OclAnyOclTypesOperation();

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		Type dynamicTypeOf = executor.getIdResolver().getDynamicTypeOf(sourceVal);
		return executor.getIdResolver().createSetOfEach((CollectionTypeId)returnTypeId, dynamicTypeOf);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @Nullable Type resolveReturnType(@NonNull EnvironmentFactory environmentFactory, @NonNull CallExp callExp, @Nullable Type returnType) {
		return environmentFactory.getStandardLibrary().getSetType();
	}
}
