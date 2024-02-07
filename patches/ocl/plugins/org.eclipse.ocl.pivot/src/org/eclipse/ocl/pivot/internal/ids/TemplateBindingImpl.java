/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ids;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.TemplateBinding;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;


public class TemplateBindingImpl extends AbstractTypeId implements TemplateBinding
{
	private TemplateParameter templateParameter;
	private TemplateParameterId templateParameterId;

	public TemplateBindingImpl(@NonNull TemplateParameter templateParameter) {
		this.templateParameter = templateParameter;
	}

	@Override
	public <R> R accept(@NonNull IdVisitor<R> visitor) {
		return visitor.visitTemplateBinding(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		String string = String.valueOf(templateParameter != null ? templateParameter : templateParameterId);
		assert string != null;
		return string;
	}

	@Override
	public @NonNull TemplateParameter getTemplateParameter() {
		return ClassUtil.nonNullState(templateParameter);
	}

	@Override
	public int hashCode() {
		return templateParameter.hashCode();
	}

	@Override
	public void install(@NonNull TemplateParameterId templateParameterId) {
		this.templateParameterId = templateParameterId;
		this.templateParameter = null;
	}

    @Override
	public @NonNull TypeId specialize(@NonNull BindingsId templateBindings) {
    	int index = templateParameterId.getIndex();
		ElementId templateBinding = templateBindings.getElementId(index);
		if (templateBinding instanceof TemplateBinding) {
			return new TemplateBindingImpl(((TemplateBinding)templateBinding).getTemplateParameter());
		}
		else {
			assert templateBinding != null;
			return (TypeId) templateBinding;
		}
	}
}
