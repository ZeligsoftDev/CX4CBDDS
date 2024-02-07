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

public abstract class UnscopedId extends AbstractTypeId
{
	protected final @NonNull String name;
	protected final int hashCode;

	/**
	 * @since 1.18
	 */
	protected UnscopedId() {
		this.name = "";
		this.hashCode = 0;
	}

	protected UnscopedId(@Nullable String name) {
		this.name = name != null ? name : "";
		this.hashCode = name.hashCode();
	}

	/**
	 * @since 1.18
	 */
	protected UnscopedId(int hashCode, @Nullable String name) {
		this.name = name != null ? name : "";
		this.hashCode = hashCode;
	}

	@Override
	public @NonNull String getDisplayName() {
		return name;
	}

	public @NonNull String getName() {
		return name;
	}

	@Override
	public final int hashCode() {
		return hashCode;
	}
}