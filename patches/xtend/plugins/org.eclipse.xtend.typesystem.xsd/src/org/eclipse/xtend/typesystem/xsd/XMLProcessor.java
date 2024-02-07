/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.xsd.util.XSDUtil;

public class XMLProcessor extends AbstractWorkflowComponent {

	private static final String COMPONENT_NAME = "XML Processor";

	private String uri;
	private String outUri;

	/**
	 * Sets the input URI.
	 *
	 * @param uri
	 *            the URI
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	public void checkConfiguration(Issues issues) {
	}

	/**
	 * Sets the output URI.
	 *
	 * @param outUri
	 *            the URI
	 */
	public void setOutUri(String outUri) {
		this.outUri = outUri;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		ResourceSet rs = new ResourceSetImpl();
		URI u = EcoreUtil2.getURI(uri);
		// GenericXMLResourceImpl r = new GenericXMLResourceImpl(u);
		Resource r = new GenericXMLResourceFactoryImpl().createResource(u);
		rs.getResources().add(r);

		try {
			r.load(new HashMap<String, Object>());
			if (outUri != null && !outUri.equals("")) {
				r.setURI(XSDUtil.strToURI(outUri));
			}

			EObject o = r.getContents().get(0);
			XMLMixedContentFormatter f = new XMLMixedContentFormatter();
			f.beautifyMixedContent(0, o);
			HashMap<String, Object> prop = new HashMap<String, Object>();
			prop.put(XMLResource.OPTION_FORMATTED, Boolean.TRUE);
			prop.put(XMLResource.OPTION_LINE_WIDTH, 40);
			r.save(prop);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
