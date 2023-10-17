/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.values.MapEntry;

/**
 * @generated NOT
 */
public class MapEntryImpl implements MapEntry
{
	protected final @Nullable Object key;	// not invalid
	protected final @Nullable Object value;	// not  invalid

	public MapEntryImpl(@Nullable Object key, @Nullable Object value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public @Nullable Object getKey() {
		return key;
	}

	@Override
	public @Nullable Object getValue() {
		return value;
	}
}