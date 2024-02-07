/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.utilities;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;

public class OCLinEcoreASResourceImpl extends ASResourceImpl
{
	public OCLinEcoreASResourceImpl(@NonNull URI uri, @NonNull ASResourceFactory asResourceFactory) {
		super(uri, asResourceFactory);
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		@NonNull URI oclURI = uri.trimFileExtension();
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(this);
		BaseCSResource csResource = (BaseCSResource) environmentFactory.getResourceSet().createResource(oclURI);
		assert csResource != null;
		csResource.getCS2AS(environmentFactory, this);
		csResource.load(null);
		super.load(options);
	}
}