/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TemplateableTypeId;

/**
 * @since 1.18
 */
public class SpecializedDataTypeIdImpl extends SpecializedTypeIdImpl implements DataTypeId
{
	public SpecializedDataTypeIdImpl(@NonNull TemplateableTypeId generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId, templateBindings);
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitDataTypeId(this);
	}
}