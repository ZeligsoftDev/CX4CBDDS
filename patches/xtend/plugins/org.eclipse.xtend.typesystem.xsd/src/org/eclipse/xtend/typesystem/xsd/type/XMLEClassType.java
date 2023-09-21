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
import java.util.Arrays;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EClassType;
import org.eclipse.xtend.typesystem.xsd.XSDMetaModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XMLEClassType extends EClassType {

	private class CompositeTypeAwareSetter extends OperationImpl {

		private EStructuralFeature feature;
		private HashMap<Type, EDataType> members = new HashMap<Type, EDataType>();

		public CompositeTypeAwareSetter(EStructuralFeature feature, Type type) {
			super(XMLEClassType.this, "set"
					+ StringHelper.firstUpper(feature.getName()),
					XMLEClassType.this, type);
			this.feature = feature;
			ExtendedMetaData em = ExtendedMetaData.INSTANCE;
			collectMemberTypes(em, (EDataType) feature.getEType());
			// log.info("Created " + getClass() + " for " + feature.getName()
			// + " with " + members);
		}

		private void collectMemberTypes(ExtendedMetaData em, EDataType type) {
			for (EDataType v : em.getMemberTypes(type)) {
				if (!(v instanceof EEnum)) {
					Type k = model.getTypeForEClassifier(v);
					if (k != null)
						members.put(k, v);
					else
						log.warn("Couldn't resolve type for " + getTypeName(v));
				}
				collectMemberTypes(em, v);
			}
		}

		@Override
		protected Object evaluateInternal(final Object target,
				final Object[] params) {
			try {
				Object newValue = params[0];
				if (newValue != null)
					for (Type t : members.keySet())
						if (t.isInstance(newValue))
							newValue = t.convert(newValue, members.get(t)
									.getInstanceClass());
				((EObject) target).eSet(feature, newValue);
				return target;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private final static Logger log = LogManager.getLogger(XMLEClassType.class);
	private EClass clazz;
	private XSDMetaModel model;

	public XMLEClassType(XSDMetaModel model, String name, EClass class1) {
		super(model, name, class1);
		this.clazz = class1;
		this.model = model;
	}

	@Override
	public Feature[] getContributedFeatures() {
		ArrayList<Feature> r = new ArrayList<Feature>(Arrays.asList(super
				.getContributedFeatures()));

		// setter
		for (EStructuralFeature f : clazz
				.getEStructuralFeatures()) {
			if (f.isChangeable() && !f.isMany()
					&& f.getEType() instanceof EDataType) {
				EDataType dt = (EDataType) f.getEType();
				if (ExtendedMetaData.INSTANCE.getMemberTypes(dt).size() != 0) {
					Type t = model.getTypeForETypedElement(f);
					if (t != null)
						replaceOperation(r, new CompositeTypeAwareSetter(f, t));
				}
			}
		}

		for (final EStructuralFeature f : clazz.getEStructuralFeatures()) {
			r.add(new StaticPropertyImpl(this, f.getName(), model
					.getEFeatureType()) {
				public Object get() {
					return f;
				}
			});
		}
		return r.toArray(new Feature[r.size()]);
	}

	private String getTypeName(EClassifier type) {
		if (type == null)
			return "null";
		return type.getName();
	}

	private void replaceOperation(ArrayList<Feature> list, Operation op) {
		for (int i = 0; i < list.size(); i++) {
			Feature f = list.get(i);
			if (f instanceof Operation
					&& f.getName().equals(op.getName())
					&& ((Operation) f).getParameterTypes().equals(
							op.getParameterTypes())) {
				// log.info("replacing " + f + " with " + op);
				list.set(i, op);
				return;
			}
		}
	}
}
