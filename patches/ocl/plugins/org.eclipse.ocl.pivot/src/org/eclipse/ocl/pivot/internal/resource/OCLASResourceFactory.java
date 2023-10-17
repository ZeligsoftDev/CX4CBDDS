/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ecore.EcoreASResourceFactory;
import org.eclipse.ocl.pivot.internal.library.RegisteredContribution;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.resource.ASResource;

/**
 * The <b>Resource Factory</b> for the pivot and extended pivot abstract syntax.
 */
public class OCLASResourceFactory extends ResourceSetAwareASResourceFactory
{
	/**
	 * @since 1.5
	 */
	public static class ASRegistry<@NonNull C extends RegisteredContribution<C>> //implements RegisteredContribution.Registry<C>
	{
		private final @NonNull Map<@NonNull URI, C>  map = new HashMap<>();

		//		@Override
		public @Nullable C get(@NonNull URI key) {
			@Nullable C contribution = map.get(key);
			return contribution != null ? contribution.getContribution() : null;
		}

		//		@Override
		public @Nullable C put(@NonNull URI key, @NonNull C contribution) {
			return map.put(key, contribution);
		}

		//		@Override
		public @Nullable C remove(@NonNull URI key) {
			return map.remove(key);
		}

		//		@Override
		public int size() {
			return map.size();
		}
	}

	/**
	 * The ResourceSetAware variant of the ASResourceFactory provides the local extension registration that
	 * creates the required resource unless an existing as or cs resource is available tobe opened
	 * re-using the parsing infrastructure for an earlier resource in the CSResourceSet.
	 *
	 * @since 1.10
	 */
	public static class ResourceSetAware extends OCLASResourceFactory
	{
		public ResourceSetAware(@NonNull ResourceSet csResourceSet) {
			super(csResourceSet);
		}

		@Override
		public Resource createResource(URI uri) {
			assert uri != null;
			//
			//	If it's a *.oclas suffixed standard library or metamodel, return the registered AS resource.
			//
			StandardLibraryContribution standardLibraryContribution = REGISTRY.get(uri);
			if (standardLibraryContribution != null) {
				return standardLibraryContribution.getResource();
			}
			if (uri.isPlatform() || uri.isFile() || uri.isArchive()) { // not http:
				//
				//	If *.xxxas exists use it.
				//
				assert resourceSet != null;
				if (resourceSet.getURIConverter().exists(uri, null)) {	// NB this expects a (Standalone)PlatformURIHandlerImpl to be installed
					return super.createResource(uri);
				}
			}
			URI nonASuri = uri.trimFileExtension();
			String nonASextension = nonASuri.fileExtension();
			ASResourceFactory asResourceFactory = nonASextension != null ? ASResourceFactoryRegistry.INSTANCE.getASResourceFactoryForExtension(nonASextension) : null;
			//
			//	Otherwise create a *.yyyas by converting the trimmed resource to YYY AS.
			//
			if (asResourceFactory == null) {			// Must be an Ecore Package registration possibly with a confusing 'extension'
				asResourceFactory = EcoreASResourceFactory.getInstance();
			}
			assert !(asResourceFactory instanceof OCLASResourceFactory);
			return asResourceFactory.createResource(uri);
		}
	}

	private static @Nullable OCLASResourceFactory CONTENT_TYPE_INSTANCE = null;

	/**
	 * @since 1.5
	 */
	public static @NonNull ASRegistry<@NonNull StandardLibraryContribution> REGISTRY = new ASRegistry<@NonNull StandardLibraryContribution>();

	public static synchronized @NonNull OCLASResourceFactory getInstance() {
		if (CONTENT_TYPE_INSTANCE == null) {
			CONTENT_TYPE_INSTANCE = getInstances(PivotPackage.eCONTENT_TYPE, ASResource.FILE_EXTENSION, null,
				OCLASResourceFactory.class);
		}
		assert CONTENT_TYPE_INSTANCE != null;
		return CONTENT_TYPE_INSTANCE;
	}

	private static final @NonNull ContentHandler PIVOT_CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		ASResource.CONTENT_TYPE, new String[]{ASResource.FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, PivotPackage.eNS_URI, null);

	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, PIVOT_CONTENT_HANDLER);
	}

	/**
	 * Creates an instance of the resource factory.
	 */
	public OCLASResourceFactory() {
		this(null);
	}

	/**
	 * @since 1.10
	 */
	protected OCLASResourceFactory(@Nullable ResourceSet resourceSet) {
		super(ASResource.CONTENT_TYPE, ASResource.FILE_EXTENSION, resourceSet);
	}

	@Override
	public Resource createResource(URI uri) {
		assert uri != null;
		//
		//	If it's a *.oclas suffixed standard library or metamodel, return the registered AS resource.
		//
		StandardLibraryContribution standardLibraryContribution = REGISTRY.get(uri);
		if (standardLibraryContribution != null) {
			return standardLibraryContribution.getResource();
		}
		return super.createResource(uri);
	}

	@Override
	protected @Nullable ASResourceFactory createResourceSetAwareASResourceFactory(@NonNull ResourceSet csResourceSet) {
		return new ResourceSetAware(csResourceSet);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}

	@Override
	protected @NonNull URI getCSuri(@NonNull URI uri) {
		return uri.trimFileExtension();
	}
}
