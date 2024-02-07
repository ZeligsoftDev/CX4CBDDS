/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;

public class SpecializedMapTypeIdImpl extends AbstractSpecializedIdImpl<@NonNull MapTypeId> implements MapTypeId
{
	public SpecializedMapTypeIdImpl(@NonNull MapTypeId generalizedId, @NonNull BindingsId bindingsId) {
		super(generalizedId, bindingsId);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitMapTypeId(this);
	}

	@Override
	protected @NonNull MapTypeId createSpecializedId(@NonNull BindingsId templateBindings) {
		return new SpecializedMapTypeIdImpl(this, templateBindings);
	}

	@Override
	public @NonNull TypeId getKeyTypeId() {
		return (TypeId)templateBindings.getElementId(0);
	}

	@Override
	public @NonNull TypeId getValueTypeId() {
		return (TypeId)templateBindings.getElementId(1);
	}

	@Override
	public boolean isKeysAreNullFree() {
		return (boolean)templateBindings.getValue(0);
	}

	@Override
	public boolean isValuesAreNullFree() {
		return (boolean)templateBindings.getValue(1);
	}

    @Override
	public @NonNull MapTypeId specialize(@NonNull BindingsId templateBindings) {
    	return createSpecializedId(templateBindings);
	}
}