/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.labels;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Option;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Registry;

/**
 * AbstractLabelGeneratorBuilder builds the formatted description on behalf of a
 * ILabelGenerator.Builder.
 */
public abstract class AbstractLabelGeneratorBuilder implements ILabelGenerator.Builder
{	
	protected final ILabelGenerator.@NonNull Registry registry;
	protected final @Nullable Object labelledObject;
	protected @Nullable Map<ILabelGenerator.Option<?>, Object> options = null;
	
	protected AbstractLabelGeneratorBuilder(ILabelGenerator.@NonNull Registry registry, @Nullable Object labelledObject, @Nullable Map<ILabelGenerator.Option<?>, Object> options) {
		this.registry = registry;
		this.labelledObject = labelledObject;
		this.options = options;
	}

	@Override
	public void appendObject(@Nullable Object object) {
		registry.buildSubLabelFor(this, object);
	}

	@Override
	public void buildLabelFor(@Nullable Object object) {
		registry.buildLabelFor(this, object);
	}

	@Override
	public @Nullable Object getLabelledObject() {
		return labelledObject;
	}

	@Override
	@SuppressWarnings("unchecked")
	public @Nullable <T> T getOption(ILabelGenerator.@NonNull Option<T> option) {
		return options != null ? (T) options.get(option) : null;
	}

	@Override
	public @NonNull Registry getRegistry() {
		return registry;
	}

	@Override
	public <T> boolean hasOption(ILabelGenerator.@NonNull Option<T> option) {
		return (options != null) && options.containsKey(option);
	}

	@Override
	public <T> void setOption(ILabelGenerator.@NonNull Option<T> option, @Nullable T value) {
		Map<Option<?>, Object> options2 = options;
		if (options2 == null)
			options = options2 = new HashMap<ILabelGenerator.Option<?>, Object>();
		options2.put(option, value);
	}

	@Override
	public abstract @NonNull String toString();
}