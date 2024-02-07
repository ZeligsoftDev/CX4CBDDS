/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.BuiltInTypeId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPackage;
import org.eclipse.ocl.pivot.library.logical.BooleanAllInstancesOperation;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * @since 1.18
 */
public class EcoreExecutorBooleanType extends EcoreExecutorPrimitiveType implements BooleanType
{
	public EcoreExecutorBooleanType(@NonNull BuiltInTypeId typeId, @NonNull ExecutorPackage evaluationPackage, int flags) {
		super(typeId, evaluationPackage, flags);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull SetValue allInstances(@NonNull Executor executor, @NonNull CollectionTypeId returnTypeId) {
		return BooleanAllInstancesOperation.allInstances();
	}
}