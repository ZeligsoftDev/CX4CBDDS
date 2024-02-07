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
package org.eclipse.ocl.pivot.library.oclinvalid;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractAllInstancesOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;

/**
 * OclInvalidAllInstancesOperation realises the OclInvalid::allInstances() library operation.
 */
public class OclInvalidAllInstancesOperation extends AbstractAllInstancesOperation
{
	@Deprecated /* @deprecated invoke the polymorphic InvalidTypeImpl.allInstances() */
	public static final @NonNull OclInvalidAllInstancesOperation INSTANCE = new OclInvalidAllInstancesOperation();

	/**
	 * @since 1.18
	 */
	public static @NonNull SetValue allInstances() {
		throw new InvalidValueException(PivotMessages.InvalidLiteral);
	}

	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceVal) {
		return allInstances();
	}
}
