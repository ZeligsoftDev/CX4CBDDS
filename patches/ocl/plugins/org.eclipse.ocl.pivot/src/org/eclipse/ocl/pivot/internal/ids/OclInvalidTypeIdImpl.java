/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OclInvalidTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class OclInvalidTypeIdImpl extends OclVoidTypeIdImpl implements OclInvalidTypeId
{
	public OclInvalidTypeIdImpl(@NonNull String name) {
		super(name);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitInvalidId(this);
	}

	@Override
	public @Nullable String getLiteralName() {
		if (this == TypeId.OCL_INVALID) {
			return "OCL_INVALID";
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return TypeId.INVALID_TYPE_NAME;
	}
}