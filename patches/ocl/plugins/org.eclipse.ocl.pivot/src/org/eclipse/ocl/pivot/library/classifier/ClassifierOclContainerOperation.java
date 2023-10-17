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
package org.eclipse.ocl.pivot.library.classifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.library.AbstractUntypedUnaryOperation;

/**
 * ClassifierOclContainerOperation realises the Classifier::oclContainer() library operation.
 */
public class ClassifierOclContainerOperation extends AbstractUntypedUnaryOperation
{
	public static final @NonNull ClassifierOclContainerOperation INSTANCE = new ClassifierOclContainerOperation();

	/**
	 * @since 1.1
	 */
	@Override
	public @Nullable Object evaluate(@NonNull Executor executor, @Nullable Object sourceVal) {
		EObject object = asNavigableObject(sourceVal, "oclContainer()", executor); //$NON-NLS-1$
		return object.eContainer();
	}
}
