/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.LambdaTypeId;
import org.eclipse.ocl.pivot.ids.ParametersId;

public class SpecializedLambdaTypeIdImpl extends AbstractSpecializedIdImpl<LambdaTypeId> implements LambdaTypeId
{
	public SpecializedLambdaTypeIdImpl(@NonNull LambdaTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitLambdaTypeId(this);
	}

	@Override
	protected @NonNull LambdaTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedLambdaTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull ParametersId getParametersId() {
		return generalizedId.getParametersId();
	}

	/**
	 * @since 1.7
	 */
	@Override
	public boolean isTemplated() {
		return generalizedId.isTemplated();
	}

	@Override
	public @NonNull LambdaTypeId specialize(@NonNull BindingsId templateBindings) {
		return createSpecializedId(templateBindings);
	}
}