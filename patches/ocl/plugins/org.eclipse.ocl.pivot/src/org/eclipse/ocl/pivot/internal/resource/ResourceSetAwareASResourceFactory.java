/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * ResourceSetAwareASResourceFactory provides additional ASResourceFactory capabilities to allow a reference
 * to an AS model element to be resolved after loading the AS resource from its CS equivalent.
 *
 * @since 1.10
 */
public abstract class ResourceSetAwareASResourceFactory extends AbstractASResourceFactory
{
	protected final @Nullable ResourceSet resourceSet;		// AS or CS or other ResourceSet for use by derived classes

	protected ResourceSetAwareASResourceFactory(@NonNull String asContentType, @NonNull String asFileExtension, @Nullable ResourceSet resourceSet) {
		super(asContentType, asFileExtension);
		this.resourceSet = resourceSet;
	}

	@Override
	public void configureResourceFactoryRegistry(@NonNull ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
		Map<String, Object> extensionFactoryRegistry = resourceFactoryRegistry.getExtensionToFactoryMap();
		String asFileExtension = getASfileExtension();
		Object resourceFactory = extensionFactoryRegistry.get(asFileExtension);
		if (resourceFactory == null) {
			extensionFactoryRegistry.put(asFileExtension, createResourceSetAwareASResourceFactory(resourceSet));
		}
		Map<String, Object> contentTypeFactoryRegistry = resourceFactoryRegistry.getContentTypeToFactoryMap();
		String contentType = getContentType();
		resourceFactory = contentTypeFactoryRegistry.get(contentType);
		if (resourceFactory == null) {
			extensionFactoryRegistry.put(contentType, this);
		}
		super.configureResourceFactoryRegistry(resourceSet);
	}

	/**
	 * Creates an instance of the resource, preferably by loading the AS, but if necessary and possible by
	 * using the csResourceSet to load the CS.
	 */
	protected Resource createResource(@NonNull ResourceSet resourceSet, @NonNull URI uri) {
		if (uri.isPlatform() || uri.isFile() || uri.isArchive()) { 		// not http:
			URIConverter uriConverter = resourceSet.getURIConverter();	// NB a (Standalone)PlatformURIHandlerImpl should be installed
			if (!uriConverter.exists(uri, null)) {						// If AS URI is missing
				URI csURI = getCSuri(uri);
				if (uriConverter.exists(csURI, null)) {					// If CS URI exists, create AS by loading CS
					ResourceSet csResourceSet = getCSResourceSet(resourceSet);
					CSResource csResource = (CSResource)csResourceSet.getResource(csURI, true);
					ASResource asResource = csResource.getASResource();
					configureResource(asResource);
					return asResource;
				}
			}
		}
		return super.createResource(uri);
	}

	protected @NonNull ResourceSet getCSResourceSet(@NonNull ResourceSet resourceSet) {
		EnvironmentFactoryAdapter environmentFactoryAdapter = EnvironmentFactoryAdapter.find(resourceSet);
		if (environmentFactoryAdapter != null) {
			EnvironmentFactory environmentFactory = environmentFactoryAdapter.getEnvironmentFactory();
			return environmentFactory.getResourceSet();
		}
		PivotMetamodelManager pivotMetamodelManager = PivotMetamodelManager.findAdapter(resourceSet);
		if (pivotMetamodelManager != null) {
			return pivotMetamodelManager.getEnvironmentFactory().getResourceSet();
		}
	//	ProjectManager projectManager = ProjectMap.findAdapter(resourceSet);
	//	if (projectManager == null) {
	//		projectManager = OCL.CLASS_PATH;
	//	}
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(null);
//		environmentFactory.getMetamodelManager();		// Create the AS ResourceSet adapter
		return environmentFactory.getResourceSet();		// Return the auto-created CS ResourceSet
	}

	protected abstract @NonNull URI getCSuri(@NonNull URI uri);

	@Override
	public @NonNull String toString() {
		if (resourceSet != null) {
			return "«resourceSetAware» " + contentType;
		}
		else {
			return super.toString();
		}
	}
}
