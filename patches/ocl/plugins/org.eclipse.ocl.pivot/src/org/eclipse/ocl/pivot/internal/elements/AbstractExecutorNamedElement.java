/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.elements;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;

public class AbstractExecutorNamedElement extends AbstractExecutorElement implements NamedElement
{
	protected final @NonNull String name;

	protected AbstractExecutorNamedElement(@NonNull String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public final void setName(String value) {
		throw new UnsupportedOperationException();
	}
}