/*******************************************************************************
 * Copyright (c) 2005 - 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem.xsd.type;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EFeatureType extends AbstractTypeImpl {

	public EFeatureType(TypeSystem typeSystem, String name) {
		super(typeSystem, name);
	}

	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] {
				new PropertyImpl(this, "name", getTypeSystem().getStringType()) {
					public Object get(Object target) {
						EStructuralFeature f = (EStructuralFeature) target;
						return f.getName();
					}
				},
				new OperationImpl(this, "toString", getTypeSystem()
						.getStringType()) {
					@Override
					protected Object evaluateInternal(Object target,
							Object[] params) {
						EStructuralFeature f = (EStructuralFeature) target;
						return f.getName();
					}
				} };
	}

	public boolean isInstance(Object o) {
		return o instanceof EStructuralFeature;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException(
				"EFeatures can not be instantiated manually");
	}

}
