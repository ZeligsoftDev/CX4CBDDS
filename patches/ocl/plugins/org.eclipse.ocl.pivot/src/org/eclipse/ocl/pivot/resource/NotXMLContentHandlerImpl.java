/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.impl.ContentHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A NotXMLContentHandlerImpl may be used to register non-XML extensions such as Xtext DSL extensions as non-XML
 * thereby inhibiting the unnecessary and failing analysis as XML to determine a content description.
 *
 * @since 1.10
 */
public class NotXMLContentHandlerImpl extends ContentHandlerImpl
{
	/**
	 * A describer that {@link #createContentHandler(Map) creates} a {@link RootXMLContentHandlerImpl} instance.
	 */
	public static class Describer extends ContentHandlerImpl.Describer
	{
		/**
		 * Creates a {@link NotXMLContentHandlerImpl} instance.
		 */
		@Override
		protected ContentHandler createContentHandler(Map<String, String> parameters) {
			String rawExtensions = parameters.get(RootXMLContentHandlerImpl.EXTENSIONS);
			return new NotXMLContentHandlerImpl(rawExtensions != null ? rawExtensions.split(" ") : new @NonNull String [0]);
		}

		@Override
		public void setInitializationData(IConfigurationElement configurationElement, String propertyName, Object data) throws CoreException {
			String fileExtensions = configurationElement.getAttribute("file-extensions");
			contentHandler = new NotXMLContentHandlerImpl(fileExtensions != null ? fileExtensions.split(",") : new @NonNull String [0]);
		}
	}

	/**
	 * The file extensions for which this handler applies.
	 */
	protected @NonNull String @NonNull [] extensions;

	public NotXMLContentHandlerImpl(@NonNull String @NonNull [] extensions) {
		this.extensions = extensions;
	}

	/**
	 * Returns true if the {@link #extensions} are null or empty, of if the URI's {@link URI#fileExtension() file extension} matches one of the extension's values.
	 */
	@Override
	public boolean canHandle(URI uri) {
		String fileExtension = uri.fileExtension();
		if (fileExtension != null) {
			for (String extension : extensions) {
				if (fileExtension.equals(extension)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> contentDescription(URI uri, InputStream inputStream, Map<?, ?> options, Map<Object, Object> context) {
		Map<String, Object> contentDescription = createContentDescription(ContentHandler.Validity.VALID);
		contentDescription.put(ContentHandler.CONTENT_TYPE_PROPERTY, null);
		return contentDescription;
	}
}