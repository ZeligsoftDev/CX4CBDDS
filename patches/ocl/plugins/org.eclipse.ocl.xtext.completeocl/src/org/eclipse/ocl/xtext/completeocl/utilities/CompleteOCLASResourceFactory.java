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
package org.eclipse.ocl.xtext.completeocl.utilities;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.NotXMLContentHandlerImpl;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

public class CompleteOCLASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable CompleteOCLASResourceFactory INSTANCE = null;

	public static synchronized @NonNull CompleteOCLASResourceFactory getInstance() {
		if (INSTANCE == null) {
			//			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.COMPLETE_OCL_CONTENT_TYPE);
			//			if (asResourceRegistry != null) {
			//				INSTANCE = (CompleteOCLASResourceFactory) asResourceRegistry.getASResourceFactory();	// Create the registered singleton
			//			}
			//			else {
			INSTANCE = new CompleteOCLASResourceFactory();											// Create our own singleton
			//			}
			assert INSTANCE != null;
			INSTANCE.install(PivotConstants.OCL_FILE_EXTENSION, null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	static {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY,
				new NotXMLContentHandlerImpl(new @NonNull String[]{PivotConstants.OCL_FILE_EXTENSION}));
		}
	}

	public CompleteOCLASResourceFactory() {
		super(ASResource.COMPLETE_OCL_CONTENT_TYPE, null);
	}

	@SuppressWarnings("deprecation")
	@Override
	public org.eclipse.ocl.pivot.utilities.@NonNull AS2XMIidVisitor createAS2XMIidVisitor(org.eclipse.ocl.pivot.internal.utilities.@NonNull AS2XMIid as2id) {
		return new CompleteOCLAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull Resource createResource(URI uri) {
		assert uri != null;
		ASResource asResource = new CompleteOCLASResourceImpl(uri, this);
		configureResource(asResource);
		return asResource;
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}
