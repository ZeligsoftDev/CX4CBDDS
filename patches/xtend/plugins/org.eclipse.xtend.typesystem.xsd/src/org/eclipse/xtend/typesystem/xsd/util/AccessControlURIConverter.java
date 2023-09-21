/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AccessControlURIConverter implements URIConverter {

	public static class AccessDeniedException extends IOException {

		private static final long serialVersionUID = -5476458803177882220L;

		public AccessDeniedException() {
			super();
		}

		public AccessDeniedException(String s) {
			super(s);
		}

	}

	private URIConverter delegate;

	private Set<String> denySchemes = null;

	private static Logger log = XSDLog.getLog(AccessControlURIConverter.class);

	private Pattern denyRegex = null;

	public AccessControlURIConverter() {
		this(new ExtensibleURIConverterImpl());
	}

	public AccessControlURIConverter(URIConverter delegate) {
		super();
		this.delegate = delegate;
	}

	protected void checkAccess(URI uri) throws AccessDeniedException {
		if (!mayAccess(uri))
			throw new AccessDeniedException("Access denied to " + uri);
	}

	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options)
			throws IOException {
		checkAccess(uri);
		return delegate.contentDescription(uri, options);
	}

	public InputStream createInputStream(URI uri) throws IOException {
		checkAccess(uri);
		return delegate.createInputStream(uri);
	}

	public InputStream createInputStream(URI uri, Map<?, ?> options)
			throws IOException {
		checkAccess(uri);
		return delegate.createInputStream(uri, options);
	}

	public OutputStream createOutputStream(URI uri) throws IOException {
		checkAccess(uri);
		return delegate.createOutputStream(uri);
	}

	public OutputStream createOutputStream(URI uri, Map<?, ?> options)
			throws IOException {
		checkAccess(uri);
		return delegate.createOutputStream(uri, options);
	}

	public void delete(URI uri, Map<?, ?> options) throws IOException {
		checkAccess(uri);
		delegate.delete(uri, options);
	}

	public boolean exists(URI uri, Map<?, ?> options) {
		return mayAccess(uri) && delegate.exists(uri, options);
	}

	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		if (!mayAccess(uri))
			return Collections.emptyMap();
		return delegate.getAttributes(uri, options);
	}

	public EList<ContentHandler> getContentHandlers() {
		return delegate.getContentHandlers();
	}

	public URIHandler getURIHandler(URI uri) {
		return delegate.getURIHandler(uri);
	}

	public EList<URIHandler> getURIHandlers() {
		return delegate.getURIHandlers();
	}

	public Map<URI, URI> getURIMap() {
		return delegate.getURIMap();
	}

	protected boolean mayAccess(URI uri) {
		boolean r = mayAccessInternal(uri);
		if (log.isInfoEnabled())
			log
					.info("Accessing '" + uri + "' -> "
							+ (r ? "granted" : "denied"));
		return r;
	}

	protected boolean mayAccessInternal(URI uri) {
		if (denySchemes != null && uri.scheme() != null
				&& denySchemes.contains(uri.scheme().toLowerCase()))
			return false;
		if (denyRegex != null && denyRegex.matcher(uri.toString()).matches())
			return false;
		return true;
	}

	public URI normalize(URI uri) {
		return delegate.normalize(uri);
	}

	public void setAttributes(URI uri, Map<String, ?> attributes,
			Map<?, ?> options) throws IOException {
		if (mayAccess(uri))
			delegate.setAttributes(uri, attributes, options);

	}

	public void setDenyRegex(String regex) {
		denyRegex = Pattern.compile(regex);
	}

	public void setDenySchemes(String[] schemes) {
		denySchemes = new HashSet<String>();
		for (String s : schemes)
			denySchemes.add(s.trim().toLowerCase());
	}

}
