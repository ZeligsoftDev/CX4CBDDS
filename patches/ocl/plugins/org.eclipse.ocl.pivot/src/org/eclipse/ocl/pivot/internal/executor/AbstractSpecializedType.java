/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.executor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorClass;
import org.eclipse.ocl.pivot.library.LibraryFeature;

public abstract class AbstractSpecializedType extends AbstractExecutorClass
{
	protected final org.eclipse.ocl.pivot.@NonNull Class containerType;

	public AbstractSpecializedType(@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class containerType) {
		super(name, 0);
		this.containerType = containerType;
	}

	public org.eclipse.ocl.pivot.Class getContainerType() {
		return containerType;
	}

	@Override
	public boolean isOrdered() {
		return containerType.isOrdered();
	}

	@Override
	public boolean isUnique() {
		return containerType.isUnique();
	}

	@Override
	public @NonNull Operation lookupActualOperation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		return containerType.lookupActualOperation(standardLibrary, apparentOperation);
	}

	@Override
	public @NonNull LibraryFeature lookupImplementation(@NonNull StandardLibrary standardLibrary, @NonNull Operation apparentOperation) {
		return containerType.lookupImplementation(standardLibrary, apparentOperation);
	}
}