/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclstdlib.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.xtext.oclstdlib.cs2as.OCLstdlibCS2AS;

public class OCLstdlibCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource) {
		return new OCLstdlibCS2AS(environmentFactory, this, asResource);
	}

	@Override
	public @NonNull String getASContentType() {
		return ASResource.OCLSTDLIB_CONTENT_TYPE;
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return OCLstdlibASResourceFactory.getInstance();
	}

	@Override
	public @NonNull String getEditorName() {
		return "OCL Standard Library";
	}
}
