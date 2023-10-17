/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;

public interface MapTypeParameters<K extends Type, V extends Type> extends Iterable<Object>
{
	/**
	 * @since 1.7
	 */
	default org.eclipse.ocl.pivot.@Nullable Class getEntryClass() {
		return null;
	}

	@NonNull K getKeyType();
	@NonNull V getValueType();
	/**
	 * @since 1.6
	 */
	default boolean isKeysAreNullFree() {
		return true;
	}

	/**
	 * @since 1.6
	 */
	default boolean isValuesAreNullFree() {
		return true;
	}
}