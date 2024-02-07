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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.common.preferences.PreferenceableOption;

/**
 * Implementation of the {@link PreferenceableOption} interface for enum OCL options.
 */
public class EnumeratedOption<T extends Enum<T>> extends BasicOption<@Nullable T>
{
	protected final @NonNull Class<T> enumType;
	
	public EnumeratedOption(@NonNull String pluginId, @NonNull String key, @NonNull T defaultValue, @NonNull Class<T> enumType) {
		super(pluginId, key, defaultValue);
		this.enumType = enumType;
	}

	public final @NonNull Class<T> getEnumType() {
		return enumType;
	}		

	@Override
	public @Nullable T getValueOf(@Nullable String string) {
		if (string == null) {
			return null;
		}
		return Enum.valueOf(enumType, string);
	}
}