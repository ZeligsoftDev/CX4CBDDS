/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.type;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtend.typesystem.xsd.XSDMetaModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLFeatureMapTypeImpl extends EFeatureMapTypeImpl {

	public XMLFeatureMapTypeImpl(XSDMetaModel model, String name,
			EClass owner) {
		super(model, name, owner);
	}

	@Override
	protected List<EStructuralFeature> getMapFeatures() {
		List<EStructuralFeature> r = new ArrayList<EStructuralFeature>();
		XMLTypePackage p = XMLTypePackage.eINSTANCE;
		r.add(p.getXMLTypeDocumentRoot_CDATA());
		r.add(p.getXMLTypeDocumentRoot_Comment());
		r.add(p.getXMLTypeDocumentRoot_ProcessingInstruction());
		r.add(p.getXMLTypeDocumentRoot_Text());
		return r;
	}

	// protected Set<? extends Type> internalGetSuperTypes() {
	// Type t = new EFeatureMapTypeImpl(model, "EFeatureMap", owner);
	// return Collections.singleton(t);
	// }
}
