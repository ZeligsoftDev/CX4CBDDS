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
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.xsd.util.Msg;
import org.eclipse.xtend.typesystem.xsd.util.XSDLog;
import org.eclipse.xtend.typesystem.xsd.util.XSDUtil;

public class XMLReaderImpl {

	private static Logger log = XSDLog.getLog(XMLReaderImpl.class);

	public static EObject read(EObject obj, String file, boolean useDocRoot) {
		log.info(Msg.create("Reading XML file ").uri(file).txt(". Context ")
				.uri(obj));
		if (!(obj.eResource() instanceof OawXMLResource))
			throw new WorkflowInterruptedException(
					"The supplied EObject for readXML('"
							+ file
							+ "') has not been loaded using the XSD Adapter's XMLReader.");

		OawXMLResource res = (OawXMLResource) obj.eResource();
		ResourceSet rs = (res.getResourceSet() == null) ? new ResourceSetImpl()
				: res.getResourceSet();
		XMLReaderImpl reader = new XMLReaderImpl(rs, res.getMetaModel());
		if (res.getURI() != null)
			reader.setBaseURI(res.getURI());
		return reader.readXML(file, useDocRoot);
	}

	public static EObject read(String file, boolean useDocRoot) {
		log.info(Msg.create("Reading XML file ").uri(file));
		ResourceSet rs = new ResourceSetImpl();
		XSDMetaModel mm = new XSDMetaModel();
		XMLReaderImpl reader = new XMLReaderImpl(rs, mm);
		return reader.readXML(file, useDocRoot);
	}

	public static EObject read(String file, XSDMetaModel metaModel, boolean useDocRoot) {
		log.info(Msg.create("Reading XML file ").uri(file).txt(". XSDMetaModel-ID '").txt(metaModel.getID()).txt("'"));
		XMLReaderImpl reader = new XMLReaderImpl(new ResourceSetImpl(), metaModel);
		return reader.readXML(file, useDocRoot);
	}

	private URI baseURI = null;

	private XSDMetaModel metaModel;

	private Map<String, Object> options = new HashMap<String, Object>();

	private ResourceSet resourceSet;

	private String uri;

	private boolean useDocumentRoot = false;

	public XMLReaderImpl(ResourceSet resourceSet, XSDMetaModel metaModel) {
		super();
		this.resourceSet = resourceSet;
		this.metaModel = metaModel;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public EObject readXML() {
		// metaModel.getXsdResources().clearErrors();
		resourceSet.setPackageRegistry(new EPackageRegistryImpl(metaModel
				.getXsdManager().getPackageRegistry()));
		URI xmlUri = resolveURI();
		XMLResource res = new OawXMLResource(xmlUri, metaModel);
		resourceSet.getResources().add(res);

		try {
			res.load(options);
		} catch (Throwable e) {
			throw new WorkflowInterruptedException(
					"Error loading XML file XML-File:" + xmlUri + ": " + e);
		}
		if (metaModel.getXsdManager().hasErrors())
			throw new WorkflowInterruptedException(
					"There were errors loading the XSD meta models.");

		if (res.getContents().size() < 1)
			throw new WorkflowInterruptedException(
					"Error loading XML file: contents is empty");

		EObject docroot = res.getContents().get(0);
		if (useDocumentRoot)
			return docroot;

		if (docroot.eContents().size() < 1)
			throw new WorkflowInterruptedException(
					"Error loading XML file: DocumentRoot is empty");

		return docroot.eContents().get(0);
	}

	private EObject readXML(String file, boolean useDocumentRoot) {
		setUri(file);
		setUseDocumentRoot(useDocumentRoot);
		return readXML();
	}

	private URI resolveURI() {
		if (baseURI == null)
			return EcoreUtil2.getURI(uri);
		return XSDUtil.resolve(resourceSet.getURIConverter(), baseURI, uri);
	}

	public void setBaseURI(URI baseURI) {
		this.baseURI = baseURI;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setUseDocumentRoot(boolean useDocumentRoot) {
		this.useDocumentRoot = useDocumentRoot;
	}

}
