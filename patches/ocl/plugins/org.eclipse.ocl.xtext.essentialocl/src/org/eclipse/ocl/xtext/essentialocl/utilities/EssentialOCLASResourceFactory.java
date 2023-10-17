/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.utilities;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.NotXMLContentHandlerImpl;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

public class EssentialOCLASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable EssentialOCLASResourceFactory INSTANCE = null;

	public static synchronized @NonNull EssentialOCLASResourceFactory getInstance() {
		if (INSTANCE == null) {
			//			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.ESSENTIALOCL_CONTENT_TYPE);
			//			if (asResourceRegistry != null) {
			//				INSTANCE = (EssentialOCLASResourceFactory) asResourceRegistry.getASResourceFactory();	// Create the registered singleton
			//			}
			//			else {
			INSTANCE = new EssentialOCLASResourceFactory();											// Create our own singleton
			//			}
			assert INSTANCE != null;
			INSTANCE.install(PivotConstants.ESSENTIAL_OCL_FILE_EXTENSION, null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	static {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY,
				new NotXMLContentHandlerImpl(new @NonNull String[]{PivotConstants.ESSENTIAL_OCL_FILE_EXTENSION}));
		}
	}

	public EssentialOCLASResourceFactory() {
		super(ASResource.ESSENTIALOCL_CONTENT_TYPE, null);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}
