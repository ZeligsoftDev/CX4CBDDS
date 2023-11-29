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
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TemplateableId;
import org.eclipse.ocl.pivot.internal.ids.TemplateParameterIdImpl.TemplateParameterIdSingletonScope;

public abstract class AbstractGeneralizedIdImpl<@NonNull T extends TemplateableId> extends AbstractTemplateableIdImpl<T> //implements TemplateableTypeId
{
	protected final @NonNull String name;

	/**
	 * Map from the property name to the propertyIds.
	 */
	private @Nullable TemplateParameterIdSingletonScope templateParameterIds = null;

	protected AbstractGeneralizedIdImpl(@NonNull Integer hashCode, int templateParameters, @NonNull String name) {
		super(hashCode, templateParameters);
		this.name = name;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @NonNull TemplateParameterId getTemplateParameterId(int index, @NonNull String name) {
		TemplateParameterIdSingletonScope templateParameterIds2 = templateParameterIds;
		if (templateParameterIds2 == null) {
			synchronized (this) {
				templateParameterIds2 = templateParameterIds;
				if (templateParameterIds2 == null) {
					templateParameterIds = templateParameterIds2 = new TemplateParameterIdSingletonScope();
				}
			}
		}
		return templateParameterIds2.getSingleton(this, index, name);
	}
}