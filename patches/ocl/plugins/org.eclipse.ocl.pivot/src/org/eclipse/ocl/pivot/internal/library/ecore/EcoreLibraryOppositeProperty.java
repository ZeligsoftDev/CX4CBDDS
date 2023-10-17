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
package org.eclipse.ocl.pivot.internal.library.ecore;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractProperty;

/** 
 * An EcoreLibraryOppositeProperty provides the LibraryProperty to implement a
 * PropertyCallExp using the inverse navigation of an EStructuralFeature.
 */
public class EcoreLibraryOppositeProperty extends AbstractProperty
{
	protected final EStructuralFeature eFeature;

	public EcoreLibraryOppositeProperty(EStructuralFeature eFeature) {
		this.eFeature = eFeature;
	}

	@Override
	public @NonNull Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		throw new UnsupportedOperationException();		// WIP
	}
}