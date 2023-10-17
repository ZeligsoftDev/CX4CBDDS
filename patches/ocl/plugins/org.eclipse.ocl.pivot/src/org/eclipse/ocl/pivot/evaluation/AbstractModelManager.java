/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.evaluation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The abstract implementation of the ModelManager API for Objects supports use of EObject as the basis of models.
 * Derived or future implementations may support plain Java Objects or optimized object representations.
 *
 * @since 1.1
 */
public abstract class AbstractModelManager implements ModelManager.ModelManagerExtension
{
	/**
	 * @since 1.7
	 */
	public static int CONSTRUCTION_COUNT = 0;

	public AbstractModelManager() {
		CONSTRUCTION_COUNT++;
	}

	@Override
	public void dispose() {}

	@SuppressWarnings("null")
	@Override
	public @NonNull TreeIterator<? extends Object> eAllContents(@NonNull Object object) {
		return ((EObject)object).eAllContents();
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull EClass eClass(@NonNull Object object) {
		return ((EObject)object).eClass();
	}

	@Override
	public @Nullable Object eContainer(@NonNull Object object) {
		return ((EObject)object).eContainer();
	}

	@Override
	public @Nullable Object eGet(@NonNull Object object, @NonNull EStructuralFeature eFeature) {
		return ((EObject)object).eGet(eFeature);
	}
}
