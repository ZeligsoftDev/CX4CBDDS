/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.as2cs.AS2CS;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.xtext.oclinecore.as2cs.OCLinEcoreAS2CS;
import org.eclipse.ocl.xtext.oclinecore.cs2as.OCLinEcoreCS2AS;

public class OCLinEcoreCSResource extends EssentialOCLCSResource
{
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		return super.basicSetResourceSet(resourceSet, notifications);
	}

	@Override
	public @NonNull AS2CS createAS2CS(@NonNull Map<@NonNull ? extends BaseCSResource, @NonNull ? extends ASResource> cs2asResourceMap,
			@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new OCLinEcoreAS2CS(cs2asResourceMap, environmentFactory);
	}

	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource) {
		return new OCLinEcoreCS2AS(environmentFactory, this, asResource);
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		if (getContents().size() > 0) {
			super.doSave(outputStream, options);	// Avoid NPE or ISE from XtextResource
		}
	}

	@Override
	public @NonNull String getASContentType() {
		return ASResource.OCLINECORE_CONTENT_TYPE;
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return OCLinEcoreASResourceFactory.getInstance();
	}

	@Override
	public @NonNull String getEditorName() {
		return "OCL in Ecore";
	}
}
