/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink (CEA LIST) - Bug 392981
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.library.executor.LazyEcoreModelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

@Deprecated /* @deprecated use LazyEcoreModelManager */
public class PivotModelManager extends LazyEcoreModelManager
{
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;

	public PivotModelManager(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull EObject contextEObject) {
		super(contextEObject);
		this.environmentFactory = environmentFactory;
	}
}
