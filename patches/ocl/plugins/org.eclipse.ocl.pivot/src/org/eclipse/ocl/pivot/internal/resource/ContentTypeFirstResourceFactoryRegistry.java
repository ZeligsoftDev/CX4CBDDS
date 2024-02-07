/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * ContentTypeFirstResourceFactoryRegistry is the same as ResourceSetImpl$2 except that
 * any contentType match in this or the global registry wins. This ensures that a create
 * creates without any attempt to see whether the resource exists under the AS or CS URI.
 *
 * @since 1.10
 */
public class ContentTypeFirstResourceFactoryRegistry extends ResourceFactoryRegistryImpl
{
	public static Resource createResource(@NonNull ResourceSet asResourceSet, @NonNull URI uri, @NonNull String contentType)
	{
		Resource.Factory resourceFactory = null;
		Map<String, Object> contentTypeToFactoryMap = asResourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap();
		if (contentTypeToFactoryMap != null) {
			resourceFactory = getContentTypeResourceFactory(contentTypeToFactoryMap, contentType);
		}
		if (resourceFactory != null)
		{
			Resource resource = resourceFactory.createResource(uri);
			assert resource != null;
			asResourceSet.getResources().add(resource);
			return resource;
		}
		else {
			return asResourceSet.createResource(uri, contentType);
		}
	}

	protected static Resource.@Nullable Factory getContentTypeResourceFactory(@NonNull Map<String, Object> contentTypeIdentifierToFactoryMap, @NonNull String contentTypeIdentifier) {
		Object factory = contentTypeIdentifierToFactoryMap.get(contentTypeIdentifier);
		if (factory == null) {
			factory = Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap().get(contentTypeIdentifier);
		}
		return ResourceFactoryRegistryImpl.convert(factory);
	}

	private final @NonNull ResourceSet asResourceSet;

	public ContentTypeFirstResourceFactoryRegistry(@NonNull ResourceSet asResourceSet) {
		this.asResourceSet = asResourceSet;
	}

	@Override
	protected Resource.Factory delegatedGetFactory(URI uri, String contentTypeIdentifier) {
		return convert(getFactory(uri, Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap(),
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap(), Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap(),
			contentTypeIdentifier, false));
	}

	@Override
	protected Map<?, ?> getContentDescriptionOptions() {
		Map<Object, Object> contentDescriptionOptions = new HashMap<>(asResourceSet.getLoadOptions());
		contentDescriptionOptions.put(ContentHandler.OPTION_REQUESTED_PROPERTIES, CONTENT_TYPE_REQUESTED_PROPERTIES);
		return contentDescriptionOptions;
	}

	@Override
	protected Object getFactory(URI uri, Map<String, Object> protocolToFactoryMap, Map<String, Object> extensionToFactoryMap,
			Map<String, Object> contentTypeIdentifierToFactoryMap, String contentTypeIdentifier, boolean delegate) {
		if (contentTypeIdentifier != null) {
			assert contentTypeIdentifierToFactoryMap != null;
			Object resourceFactory = getContentTypeResourceFactory(contentTypeIdentifierToFactoryMap, contentTypeIdentifier);
			if (resourceFactory != null) {
				return resourceFactory;
			}
		}
		return super.getFactory(uri, protocolToFactoryMap, extensionToFactoryMap,
			contentTypeIdentifierToFactoryMap, contentTypeIdentifier, delegate);
	}

	@Override
	protected URIConverter getURIConverter() {
		return asResourceSet.getURIConverter();
	}
}