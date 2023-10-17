/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.options;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.preferences.PreferenceableOption;
import org.eclipse.ocl.pivot.utilities.Option;

/**
 * Abstract implementation of a configurable option that can also be a preference.
 */
public abstract class BasicOption<T> implements Option<T>, PreferenceableOption<T>
{
	protected final @NonNull String pluginId;
	protected final @NonNull String key;
	protected final T defaultValue;

	protected BasicOption(@NonNull String pluginId, @NonNull String key, T defaultValue) {
		this.pluginId = pluginId;
		this.key = key;
		this.defaultValue = defaultValue;
	}

	@Override
	public final @NonNull String getKey() {
		return key;
	}

	@Override
	public final T getDefaultValue() {
		return defaultValue;
	}

	@Override
	public final @NonNull String getPluginId() {
		return pluginId;
	}

	@Override
	public @NonNull String toString() {
		return key;
	}
}
