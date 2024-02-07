/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.AbstractEMFWorkflowComponent;
import org.eclipse.xtend.typesystem.MetaModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractXMLWorkflowComponent extends
		AbstractEMFWorkflowComponent {

	private List<MetaModel> allMetaModels = new ArrayList<MetaModel>();

	private XSDMetaModel xsdMetaModel;

	public void addMetaModel(MetaModel metaModel) {
		if (metaModel instanceof XSDMetaModel)
			this.xsdMetaModel = (XSDMetaModel) metaModel;
		this.allMetaModels.add(metaModel);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (xsdMetaModel == null)
			issues.addError(this, "An XSDMetaModel needs to be specified");
		super.checkConfiguration(issues);
	}

	public List<MetaModel> getAllMetaModels() {
		return allMetaModels;
	}

	public XSDMetaModel getMetaModel() {
		return xsdMetaModel;
	}
}
