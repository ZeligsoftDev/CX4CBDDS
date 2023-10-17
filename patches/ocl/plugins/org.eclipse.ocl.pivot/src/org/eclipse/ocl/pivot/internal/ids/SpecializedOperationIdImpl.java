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
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class SpecializedOperationIdImpl extends AbstractSpecializedIdImpl<OperationId> implements OperationId
{
	public SpecializedOperationIdImpl(@NonNull OperationId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitOperationId(this);
	}

	@Override
	protected @NonNull OperationId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedOperationIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return generalizedId.getParametersId();
	}

	@Override
	public @NonNull TypeId getParent() {
		return generalizedId.getParent();
	}
}