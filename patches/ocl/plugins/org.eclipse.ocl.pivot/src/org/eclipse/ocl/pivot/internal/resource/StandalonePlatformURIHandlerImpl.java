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
package org.eclipse.ocl.pivot.internal.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.FileURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager.IProjectDescriptor;

/**
 * StandalonePlatformURIHandlerImpl resolves platform:/plugin and platform:/resource URIs identically.
 * If the first segment corresponds to a project folder discovered by a class path scan, the handler
 * delegates to the equivalent file alternatively it delegates to the standard URI handling for a JAR.
 *
 * @since 1.4
 */
public class StandalonePlatformURIHandlerImpl extends URIHandlerImpl
{
	public static void install(@NonNull URIConverter uriConverter, @Nullable StandaloneProjectMap projectManager) {
		List<URIHandler> uriHandlers = uriConverter.getURIHandlers();
		uriHandlers.add(0, new StandalonePlatformURIHandlerImpl(projectManager));
	}

	private static final @NonNull FileURIHandlerImpl fileHandler = new FileURIHandlerImpl();

	private final @Nullable StandaloneProjectMap projectManager;

	public StandalonePlatformURIHandlerImpl(@Nullable StandaloneProjectMap projectManager) {
		this.projectManager = projectManager;
		assert !EMFPlugin.IS_ECLIPSE_RUNNING;
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.isPlatform() && (projectManager != null);
	}

	@Override
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.contentDescription(fileURI, options);
		}
		return super.contentDescription(getPluginURI(uri), options);
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.createInputStream(fileURI, options);
		}
		return super.createInputStream(getPluginURI(uri), options);
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.createOutputStream(fileURI, options);
		}
		return super.createOutputStream(getPluginURI(uri), options);
	}

	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			fileHandler.delete(fileURI, options);
		}
		else {
			super.delete(getPluginURI(uri), options);
		}
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.exists(fileURI, options);
		}
		return super.exists(getPluginURI(uri), options);
	}

	@Override
	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			return fileHandler.getAttributes(fileURI, options);
		}
		return super.getAttributes(getPluginURI(uri), options);
	}

	/**
	 * Return a non-null File URI if the there is a corresponding classpath project.
	 */
	protected @Nullable URI getFileURI(@NonNull URI uri) {
		String bundleName = uri.segment(1);
		StandaloneProjectMap projectManager2 = projectManager;
		assert projectManager2 != null;
		IProjectDescriptor projectDescriptor = projectManager2.getProjectDescriptor(bundleName);
		if (projectDescriptor == null) {
			return null;
		}
		URI fileURI = projectDescriptor.getLocationURI();
		if (!fileURI.isFile()) {
			return null;
		}
		if (fileURI.hasTrailingPathSeparator()) {
			fileURI = fileURI.trimSegments(1);
		}
		for (int i = 2; i < uri.segmentCount(); i++) {
			fileURI = fileURI.appendSegment(uri.segment(i));
		}
		return fileURI;
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

	@Override
	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		assert uri != null;
		URI fileURI = getFileURI(uri);
		if (fileURI != null) {
			fileHandler.setAttributes(fileURI, attributes, options);
		}
		else {
			super.setAttributes(getPluginURI(uri), attributes, options);
		}
	}
}
