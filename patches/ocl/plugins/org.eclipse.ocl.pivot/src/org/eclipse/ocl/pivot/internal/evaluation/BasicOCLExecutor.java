/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

/**
 * @since 1.1
 */
public class BasicOCLExecutor extends AbstractExecutor implements OCLExecutor
{
	protected final @NonNull ModelManager modelManager;

	public BasicOCLExecutor(EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory, @NonNull ModelManager modelManager) {
		super(environmentFactory);
		this.modelManager = modelManager;
	}

	@Override
	public void dispose() {
		if (modelManager instanceof ModelManager.ModelManagerExtension) {
			((ModelManager.ModelManagerExtension)modelManager).dispose();
		}
		super.dispose();
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		return modelManager;
	}
}
