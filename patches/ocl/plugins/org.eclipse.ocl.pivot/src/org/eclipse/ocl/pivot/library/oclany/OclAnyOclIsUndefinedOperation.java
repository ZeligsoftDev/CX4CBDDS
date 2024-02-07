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
import org.eclipse.ocl.pivot.library.AbstractSimpleUnaryOperation;
import org.eclipse.ocl.pivot.values.NullValue;

/**
 * OclAnyOclIsUndefinedOperation realises the OclAny::oclIsUndefined() library operation.
 */
public class OclAnyOclIsUndefinedOperation extends AbstractSimpleUnaryOperation
{
	public static final @NonNull OclAnyOclIsUndefinedOperation INSTANCE = new OclAnyOclIsUndefinedOperation();

	@Override
	public @NonNull Boolean evaluate(@Nullable Object argument) {
		return (argument == null) || (argument instanceof NullValue);	// NB InvalidValue is a NullValue
	}
}
