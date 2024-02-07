/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.FileURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;

/**
 * PlatformURIHandlerImpl resolves platform:/plugin and platform:/resource URIs identically.
 * If the first segment corresponds to a Platform project, the handler
 * delegates to a standard PlatformResourceHandle
 * alternatively if the first segment corresponds to a Platform bundle whose location is a file, the handler
 * delegates to the equivalent file alternatively it delegates to the standard URI handling for a JAR.
 *
 * @since 1.4
 *
 * @deprecated No longer required now that a ResourceSetAwareASResourceFactory can provide a ResourceSet
 */
@Deprecated
public class PlatformURIHandlerImpl extends URIHandlerImpl
{
	private static final @NonNull PlatformURIHandlerImpl INSTANCE = new PlatformURIHandlerImpl();

	private static final @NonNull FileURIHandlerImpl fileHandler = new FileURIHandlerImpl();
	private static final @NonNull PlatformResourceURIHandlerImpl resourceHandler = new PlatformResourceURIHandlerImpl();

	public static void install(@NonNull URIConverter uriConverter) {
		List<URIHandler> uriHandlers = uriConverter.getURIHandlers();
		uriHandlers.add(0, INSTANCE);
	}

	protected PlatformURIHandlerImpl() {
		assert EMFPlugin.IS_ECLIPSE_RUNNING;
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.isPlatform();
	}

	@Override
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			return resourceHandler.contentDescription(resourceURI, options);
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.contentDescription(fileURI, options);
		}
		return super.contentDescription(getPluginURI(uri), options);
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			return resourceHandler.createInputStream(resourceURI, options);
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.createInputStream(fileURI, options);
		}
		return super.createInputStream(getPluginURI(uri), options);
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			return resourceHandler.createOutputStream(resourceURI, options);
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.createOutputStream(fileURI, options);
		}
		return super.createOutputStream(getPluginURI(uri), options);
	}

	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			resourceHandler.delete(resourceURI, options);
			return;
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			fileHandler.delete(fileURI, options);
			return;
		}
		super.delete(getPluginURI(uri), options);
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			return resourceHandler.exists(resourceURI, options);
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.exists(fileURI, options);
		}
		return super.exists(getPluginURI(uri), options);
	}

	@Override
	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			return resourceHandler.getAttributes(resourceURI, options);
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.getAttributes(fileURI, options);
		}
		return super.getAttributes(getPluginURI(uri), options);
	}

	/**
	 * Return a non-null File URI if the there is a corresponding bundle whose realization is a folder.
	 */
	protected @Nullable URI getFileURI(@NonNull URI uri) {
		String bundleName = uri.segment(1);
		Bundle bundle = Platform.getBundle(bundleName);
		String location = bundle.getLocation();
		URI locationURI = URI.createURI(location);
		if (locationURI.hasOpaquePart()) {
			locationURI = URI.createURI(locationURI.opaquePart());
		}
		if (!locationURI.isFile()) {
			return null;
		}
		if (locationURI.hasTrailingPathSeparator()) {
			locationURI = locationURI.trimSegments(1);
		}
		for (int i = 2; i < uri.segmentCount(); i++) {
			locationURI = locationURI.appendSegment(uri.segment(i));
		}
		return locationURI;
	}

	/**
	 * Return a corresponding non-null platform:/plugin URI.
	 */
	protected @NonNull URI getPluginURI(@NonNull URI uri) {
		if (uri.isPlatformPlugin()) {
			return uri;
		}
		else {
			return URI.createPlatformPluginURI(uri.toPlatformString(false), false);
		}
	}

	/**
	 * Return a non-null platform:/resource URI if the there is a corresponding workspace project.
	 * If null, the caller should try getFileURI to resolve in a corresponding bundle.
	 */
	protected @Nullable URI getResourceURI(@NonNull URI uri) {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource project = workspaceRoot.findMember(uri.segment(1));
		if (project == null) {
			return null;
		}
		if (uri.isPlatformResource()) {
			return uri;
		}
		else {
			return URI.createPlatformResourceURI(uri.toPlatformString(false), false);
		}
	}

	@Override
	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI resourceURI = getResourceURI(uri);
		if (resourceURI != null) {
			resourceHandler.setAttributes(resourceURI, attributes, options);
			return;
		}
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			fileHandler.setAttributes(fileURI, attributes, options);
			return;
		}
		else {
			super.setAttributes(getPluginURI(uri), attributes, options);
		}
	}
}
