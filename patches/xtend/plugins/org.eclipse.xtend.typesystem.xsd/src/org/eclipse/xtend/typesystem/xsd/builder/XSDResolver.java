/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.eclipse.xsd.util.XSDSchemaLocationResolver;
import org.eclipse.xsd.util.XSDSchemaLocator;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;
import org.eclipse.xtend.typesystem.xsd.util.XSDUtil;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XSDResolver extends AdapterImpl implements
		XSDSchemaLocationResolver, XSDSchemaLocator {

	protected Logger log = XSDLog.getLog(getClass());

	private XSDSchema findSchema(ResourceSet rs, String ns) {
		for (Resource r : rs.getResources())
			for (EObject o : r.getContents())
				if (o instanceof XSDSchema) {
					XSDSchema s = (XSDSchema) o;
					if (ns == null && s.getTargetNamespace() == null)
						return s;
					if (ns != null && ns.equals(s.getTargetNamespace()))
						return s;
				}
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == XSDSchemaLocationResolver.class
				|| type == XSDSchemaLocator.class;
	}

	public XSDSchema locateSchema(XSDSchema xsdSchema, String namespaceURI,
			String rawSchemaLocationURI, String resolvedSchemaLocationURI) {
		if (xsdSchema.eResource() == null
				|| xsdSchema.eResource().getResourceSet() == null)
			return null;

		// do some logging
		boolean equalNS = xsdSchema.getTargetNamespace() != null
				&& xsdSchema.getTargetNamespace().equals(namespaceURI);
		if (equalNS)
			log.info(Msg.create("Including ").uri(rawSchemaLocationURI).txt(
					" from ").schema(xsdSchema));
		else
			log.info(Msg.create("Importing ").uri(rawSchemaLocationURI).txt(
					" (").ns(namespaceURI).txt(") from ").schema(xsdSchema));

		// strategy:
		// 1. check if the file has been loaded
		// 2. if not, try to load the file
		// 3. if that fails too, look for an already loaded schema which has
		// the desired namespace
		ResourceSet rs = xsdSchema.eResource().getResourceSet();
		Throwable loadErr = null;
		XSDSchema schema = null;
		try {
			schema = tryLoadSchema(resolvedSchemaLocationURI, rs);
		} catch (IOException exception) {
			loadErr = exception;
		}

		if (schema == null) {
			schema = findSchema(rs, namespaceURI);
			Msg msg = Msg.create("Could not load ").uri(rawSchemaLocationURI)
					.txt(".");
			Msg err = Msg.create(" Error:").err(loadErr);
			if (schema != null)
				log.warn(msg.txt(" Taking ").schema(schema).txt(
						" instead, since they have the same namespace.").txt(
						err));
			else
				log.error(msg.txt(err));
		}

		// fix the namespace, if it has not been set
		if (schema != null
				&& (schema.getTargetNamespace() == null || schema
						.getTargetNamespace().equals(""))) {
			log.warn(Msg.create("XSDSchema ").uri(schema).txt(
					" has no namespace. Setting it to ").ns(namespaceURI));
			schema.setTargetNamespace(namespaceURI);
		}

		return schema;
	}

	public String resolveSchemaLocation(XSDSchema xsdSchema,
			String namespaceURI, String schemaLocationURI) {
		if (schemaLocationURI != null && !"".equals(schemaLocationURI)) {
			// handler.setBaseURI(xsdSchema.eResource().getURI());
			// URI r = handler.resolve(URI.createURI(schemaLocationURI));
			URI r = XSDUtil.resolve(xsdSchema.eResource(), schemaLocationURI);
			return r.toString();
		}
		return XSDConstants.resolveSchemaLocation(
				xsdSchema.getSchemaLocation(), namespaceURI, schemaLocationURI);
	}

	private XSDSchema tryLoadSchema(String resolvedSchemaLocationURI,
			ResourceSet rs) throws IOException {
		URI uri = URI.createURI(resolvedSchemaLocationURI == null ? ""
				: resolvedSchemaLocationURI);
		Resource resolvedResource = rs.getResource(uri, false);
		if (resolvedResource == null) {
			InputStream inputStream = rs.getURIConverter().createInputStream(
					uri);
			resolvedResource = rs.createResource(URI.createURI("*.xsd"));
			resolvedResource.setURI(uri);
			resolvedResource.load(inputStream, rs.getLoadOptions());
		} else if (!resolvedResource.isLoaded())
			resolvedResource.load(rs.getLoadOptions());
		if (resolvedResource instanceof XSDResourceImpl)
			return ((XSDResourceImpl) resolvedResource).getSchema();
		return null;
	}
}