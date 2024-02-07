/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * <p>
 * This copy of org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl is only ever used if
 * an attempt to read a *.xtextbin file is made that bypasses the GrammarProvider that provides a
 * direct Java serialization. This class therefore exists solely to avoid an undefined reference
 * from the xxxStandaloneSetupGenerated.createInjectorAndDoEMFRegistration after rewriting by
 * BackportToXtext_2_3_1.
 */
public class BinaryGrammarResourceFactoryImpl implements Factory {

	@Override
	public Resource createResource(URI uri) {
		XMIResourceImpl resource = new XMIResourceImpl(uri);

		// make it a binary resource
		resource.getDefaultLoadOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_BINARY, Boolean.TRUE);

		// don't do any resolution, since the only external references point to Ecore elements from EPackages in the registry.
		XMLResource.URIHandler uriHandler = new XMLResource.URIHandler() {

			@Override
			public void setBaseURI(URI uri) {
			}

			@Override
			public URI resolve(URI uri) {
				return uri;
			}

			@Override
			public URI deresolve(URI uri) {
				return uri;
			}
		};
		resource.getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
		resource.getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, uriHandler);
		return resource;
	}

}
