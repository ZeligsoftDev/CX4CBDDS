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
import org.eclipse.ocl.pivot.ids.SpecializedId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TemplateableId;

public abstract class AbstractSpecializedIdImpl<T extends TemplateableId> extends AbstractTemplateableIdImpl<T> implements SpecializedId
{
	protected final @NonNull T generalizedId;
	protected final @NonNull BindingsId templateBindings;

	public AbstractSpecializedIdImpl(@NonNull T generalizedId, @NonNull BindingsId templateBindings) {
		super(generalizedId.hashCode() + templateBindings.hashCode(), generalizedId.getTemplateParameters());
		this.generalizedId = generalizedId;
		this.templateBindings = templateBindings;
		int generalizedTemplateParameters = generalizedId.getTemplateParameters();
		int templateParameterCount = generalizedTemplateParameters;
		assert templateParameterCount > 0;
		assert templateParameterCount == templateBindings.elementIdSize();
	}

	@Override
	public @NonNull String getDisplayName() {
		StringBuilder s = new StringBuilder();
		s.append(generalizedId.getDisplayName());
		s.append("<");
		int elementIdSize = templateBindings.elementIdSize();
		for (int i = 0; i < elementIdSize; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append("$" + i + ":");
			s.append(templateBindings.getElementId(i));
		}
		for (int i = 0; i < templateBindings.valuesSize(); i++) {
			s.append(",");
			s.append("$" + (i + elementIdSize) + ":");
			s.append(templateBindings.getValue(i));
		}
		s.append(">");
		return s.toString();
	}

	@Override
	public @NonNull T getGeneralizedId() {
		return generalizedId;
	}

	@Override
	public @NonNull String getMetaTypeName() {
		return generalizedId.getMetaTypeName();
	}

	@Override
	public @NonNull String getName() {
		return generalizedId.getName();
	}

	@Override
	public @NonNull BindingsId getTemplateBindings() {
		return templateBindings;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId(int index, @NonNull String name) {
		throw new UnsupportedOperationException();
	}
}