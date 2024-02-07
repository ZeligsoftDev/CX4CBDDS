/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.type;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.xsd.XSDMetaModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EFeatureMapEntryTypeImpl extends AbstractTypeImpl {

	private XSDMetaModel model;

	public EFeatureMapEntryTypeImpl(XSDMetaModel model, String name) {
		super(model.getTypeSystem(), name);
		this.model = model;
	}

	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] {
				new PropertyImpl(this, "value", getTypeSystem().getObjectType()) {
					public Object get(Object target) {
						FeatureMap.Entry ent = (FeatureMap.Entry) target;
						return ent.getValue();
					}
				}, new PropertyImpl(this, "feature", model.getEFeatureType()) {
					public Object get(Object target) {
						FeatureMap.Entry ent = (FeatureMap.Entry) target;
						return ent.getEStructuralFeature();
					}
				} };
	}

	public boolean isInstance(Object o) {
		return o instanceof FeatureMap.Entry;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException(
				"Feature map entries can not be instantiated outside EObjects");
	}

}
