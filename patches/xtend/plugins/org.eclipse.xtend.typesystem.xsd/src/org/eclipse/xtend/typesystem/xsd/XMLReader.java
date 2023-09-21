/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This workflow component loads an XML file into a dynamic Ecore model.
 * 
 * The XML format has to be specified via one or more XML Schemas. They are
 * transformed into dynamic eEore packages which are then uses as metamodels.
 * 
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLReader extends AbstractXMLWorkflowComponent {

	private static final String COMPONENT_NAME = "XML Reader";

	private Map<String, Object> options = new HashMap<String, Object>();

	private boolean useDocumentRoot = false;

	public void addOption(OptionsEntry entry) {
		options.put(entry.getKey(), entry.getValue());
	}

	// public static class UriCollector {
	// private String dir;
	// private String filter;
	// private String varName;
	// private String expression;
	//
	// public void setDir(String dir) {
	// this.dir = dir;
	// }
	//
	// public void setFilter(String filter) {
	// this.filter = filter;
	// }
	//
	// public void setVarName(String varName) {
	// this.varName = varName;
	// }
	//
	// public void setExpression(String expression) {
	// this.expression = expression;
	// }
	// public void checkConfiguration(Issues issues) {
	//			
	// }
	// }

	@Override
	public void checkConfiguration(Issues issues) {
		if (uri == null)
			issues.addError(this, "XML File (uri) not specified.");
		super.checkConfiguration(issues);
	}

	// private UriCollector uris;
	//
	// public void setUris(UriCollector uris) {
	// this.uris = uris;
	// }

	@Override
	public String getLogMessage() {
		return "Loading XML file " + uri;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		XMLReaderImpl reader = new XMLReaderImpl(resourceSet, getMetaModel());
		reader.setUri(uri);
		reader.setUseDocumentRoot(useDocumentRoot);
		reader.getOptions().putAll(options);
		EObject model = reader.readXML();
		ctx.set(getModelSlot(), model);
	}

	/**
	 * Specifies if the XML's DocumentRoot (which usually only contains
	 * namespace informations and the document's root element) itself or the
	 * root element should be stored to the model slot.
	 * 
	 * @param returnDocumentRoot
	 */
	public void setUseDocumentRoot(boolean returnDocumentRoot) {
		this.useDocumentRoot = returnDocumentRoot;
	}

	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}

}
