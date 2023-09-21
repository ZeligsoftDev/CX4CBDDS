/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.EcoreBuilder;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OawEcoreBuilder implements EcoreBuilder {

	// protected ExtendedMetaData extendedMetaData;

	protected Logger log = XSDLog.getLog(getClass());

	private XSDManager xsdManager;

	public OawEcoreBuilder(XSDManager xsdManager) {
		super();
		this.xsdManager = xsdManager;
	}

	public Collection<? extends Resource> generate(Collection<URI> uris)
			throws Exception {
		// ArrayList<Resource> r = new ArrayList<Resource>();
		for (URI u : uris)
			xsdManager.loadAndGenerate(u);
		return Collections.emptyList();
	}

	public Collection<? extends Resource> generate(
			Map<String, URI> targetNamespaceToURI) throws Exception {
		if (targetNamespaceToURI == null)
			return Collections.emptyList();
		// ArrayList<Resource> res = new ArrayList<Resource>();
		ArrayList<URI> uris = new ArrayList<URI>();
		EPackage.Registry reg = xsdManager.getPackageRegistry();
		for (Map.Entry<String, URI> e : targetNamespaceToURI.entrySet()) {
			if (reg.containsKey(e.getKey()))
				// EPackage pkg = reg.getEPackage(e.getKey());
				// res.add(pkg.eResource());
				log.info("Already loaded EPackage requested. Namespace:"
						+ e.getKey());
			else
				uris.add(e.getValue());
		}
		if (uris.size() > 0) {
			log.info(Msg.create("Loading XSDSchema from ").uris(uris));
			// res.addAll(generate(uris));
			generate(uris);
			for (String ns : targetNamespaceToURI.keySet())
				if (!reg.containsKey(ns))
					log.warn(Msg.create("The requested namespace ").ns(ns).txt(
							" has not been loaded yet. ").txt(
							"It was probably not found in ").uri(
							targetNamespaceToURI.get(ns)));
		}
		return Collections.emptyList();
	}

	public Collection<? extends Resource> generate(URI uri) throws Exception {
		xsdManager.loadAndGenerate(uri);
		return Collections.emptyList();
	}

	public void setExtendedMetaData(ExtendedMetaData extendedMetaData) {
		// this.extendedMetaData = extendedMetaData;
	}

}