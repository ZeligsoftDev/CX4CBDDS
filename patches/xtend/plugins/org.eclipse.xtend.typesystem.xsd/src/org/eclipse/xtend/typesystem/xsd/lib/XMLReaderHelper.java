/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.lib;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.xsd.XMLReaderImpl;
import org.eclipse.xtend.typesystem.xsd.XSDMetaModel;
import org.eclipse.xtend.util.stdlib.AbstractStatefulExtensions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLReaderHelper extends AbstractStatefulExtensions<Object> {

	public EObject readDocumentRoot(EObject context, String xmlFileName) {
		return XMLReaderImpl.read(context, xmlFileName, true);
	}

	public EObject readDocumentRoot(String xmlFileName) {
		return XMLReaderImpl.read(xmlFileName, true);
	}

	public EObject readDocumentRoot(String xmlFileName, String metaModelID) {
		return XMLReaderImpl.read(xmlFileName, getXSDMetaModel(metaModelID), true);
	}

	public EObject readXML(EObject context, String xmlFileName) {
		return XMLReaderImpl.read(context, xmlFileName, false);
	}

	public EObject readXML(String xmlFileName) {
		return XMLReaderImpl.read(xmlFileName, false);
	}

	public EObject readXML(String xmlFileName, String metaModelID) {
		return XMLReaderImpl.read(xmlFileName, getXSDMetaModel(metaModelID), false);
	}

	protected XSDMetaModel getXSDMetaModel(String xsdMetaModelID) {
		List<MetaModel> metaModels = ((ExecutionContextImpl) exeCtx).getMetaModels();
		for (MetaModel mm : metaModels)
			if (mm instanceof XSDMetaModel && xsdMetaModelID.equals(((XSDMetaModel) mm).getID()))
				return (XSDMetaModel) mm;
		throw new WorkflowInterruptedException("No XSDMetaModel with ID '" + xsdMetaModelID + "' could be found.");
	}
}
