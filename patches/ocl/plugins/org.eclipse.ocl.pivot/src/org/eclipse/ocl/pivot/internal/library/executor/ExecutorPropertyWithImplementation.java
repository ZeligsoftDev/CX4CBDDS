/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.LibraryProperty;

public class ExecutorPropertyWithImplementation extends ExecutorProperty
{
	protected final @NonNull LibraryProperty implementation;
	
	public ExecutorPropertyWithImplementation(@NonNull  String name, @NonNull Type executorType, int propertyIndex, @NonNull LibraryProperty implementation) {
		super(name, executorType, propertyIndex);
		this.implementation = implementation;
	}

	@Override
	public @NonNull LibraryProperty getImplementation() {
		return implementation;
	}
}