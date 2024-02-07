/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.preferences.PreferenceableOption;

/**
 * Implementation of the {@link PreferenceableOption} interface for boolean OCL options.
 *
 * @since 1.16
 */
public class BooleanOption extends BasicOption<@Nullable Boolean> implements PreferenceableOption<@Nullable Boolean>
{
	public BooleanOption(@NonNull String pluginId, @NonNull String key, @NonNull Boolean defaultValue) {
		super(pluginId, key, defaultValue);
	}

	@Override
	public @NonNull Boolean getValueOf(String string) {
		return Boolean.valueOf(string);
	}
}