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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.Validator;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.ListTypeImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.xsd.XSDMetaModel;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EFeatureMapTypeImpl extends AbstractTypeImpl {

	private static Logger log = LogManager.getLogger(EFeatureMapTypeImpl.class);

	static {
		if (cacheBugExists())
			log.warn("There is a bug in the internal object cache of Xpand. "
					+ "Therefore feature maps (which are needed to handle "
					+ "mixed XML content) will be just partially functional. "
					+ "Please update to the latest version of Xpand.");
	}

	// public enum FeatureType {
	// ELEMENTS(ExtendedMetaData.ELEMENT_FEATURE,
	// ExtendedMetaData.ELEMENT_WILDCARD_FEATURE,
	// ExtendedMetaData.GROUP_FEATURE), ATTRIBUTES(
	// ExtendedMetaData.ATTRIBUTE_FEATURE,
	// ExtendedMetaData.ATTRIBUTE_WILDCARD_FEATURE), ALL(ELEMENTS,
	// ATTRIBUTES);
	// private int[] kinds;
	//
	// private FeatureType(int... kinds) {
	// this.kinds = kinds;
	// }
	//
	// private FeatureType(FeatureType... kinds) {
	// int size = 0;
	// for (FeatureType t : kinds)
	// size += t.kinds.length;
	// this.kinds = new int[size];
	// int pos = 0;
	// for (FeatureType t : kinds) {
	// System.arraycopy(t.kinds, 0, this.kinds, pos, t.kinds.length);
	// pos += t.kinds.length;
	// }
	// }
	//
	// public boolean isKind(int kind) {
	// for (int k : kinds)
	// if (k == kind)
	// return true;
	// return false;
	// }
	//
	// public String getName() {
	// return name().substring(0, 1) + name().substring(1).toLowerCase();
	// }
	//
	// public List<EStructuralFeature> getFeatures(XSDMetaModel model,
	// EClass cls) {
	// ExtendedMetaData emd = model.getXsdManager().getExtendedMetadata();
	// ArrayList<EStructuralFeature> r = new ArrayList<EStructuralFeature>();
	// for (EStructuralFeature f : cls.getEAllStructuralFeatures())
	// if (!f.isDerived() && isKind(emd.getFeatureKind(f)))
	// r.add(f);
	// return r;
	// }
	// }

	public static boolean cacheBugExists() {
		TypeSystemImpl ts = new TypeSystemImpl();
		ts.registerMetaModel(new XSDMetaModel());
		EObject cls = EcoreFactory.eINSTANCE.createEObject();

		Type t1 = ts.getType(new ArrayList<Object>());
		Type t2 = ts.getType(new BasicFeatureMap((InternalEObject) cls, 1));
		return t1.equals(t2);
	}

	public static boolean isFeatureMap(ETypedElement element) {
		return element != null
				&& element.eContainer() instanceof EClass
				&& element.getEType() != null
				&& element.getEType().getInstanceClass() == FeatureMap.Entry.class;
	}

	protected XSDMetaModel model;

	protected EClass owner;

	public EFeatureMapTypeImpl(final XSDMetaModel model, final String name,
			final EClass owner) {
		super(model.getTypeSystem(), name);
		this.owner = owner;
		this.model = model;
	}

	@Override
	public Feature[] getContributedFeatures() {
		List<Feature> features = new ArrayList<Feature>();
		for (final EStructuralFeature feature : getMapFeatures()) {
			Type type = model.getTypeForETypedElement(feature);
			if (type == null)
				type = getTypeSystem().getObjectType();
			if (!(type instanceof ListTypeImpl))
				type = getTypeSystem().getListType(type);
			features.add(new PropertyImpl(this, feature.getName(), type) {
				public Object get(Object target) {
					FeatureMap map = (FeatureMap) target;
					return map.list(feature);
				}
			});
		}
		features.add(new OperationImpl(this, "add", getTypeSystem()
				.getBooleanType(), model.getEFeatureType(), getTypeSystem()
				.getObjectType()) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				return map.add(f, params[1]);
			}
		});
		features.add(new OperationImpl(this, "set", getTypeSystem()
				.getVoidType(), model.getEFeatureType(), getTypeSystem()
				.getObjectType()) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				map.set(f, params[1]);
				return null;
			}
		});
		features.add(new OperationImpl(this, "unset", getTypeSystem()
				.getVoidType(), model.getEFeatureType()) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				map.unset(f);
				return null;
			}
		});
		features.add(new OperationImpl(this, "isSet", getTypeSystem()
				.getBooleanType(), model.getEFeatureType()) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				return map.isSet(f);
			}
		});
		features.add(new OperationImpl(this, "list", getTypeSystem()
				.getListType(getTypeSystem().getObjectType()), model
				.getEFeatureType()) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				return map.list(f);
			}
		});
		features.add(new OperationImpl(this, "addAll", getTypeSystem()
				.getBooleanType(), model.getEFeatureType(), getTypeSystem()
				.getCollectionType(getTypeSystem().getObjectType())) {
			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature f = (EStructuralFeature) params[0];
				@SuppressWarnings("rawtypes")
				Collection o = (Collection) params[1];
				return map.addAll(f, o);
			}
		});
		// for (final FeatureType ft : FeatureType.values()) {
		// final String name = "add" + ft.getName() + "From";
		features.add(new OperationImpl(this, "addFrom", getTypeSystem()
				.getVoidType(), model.getEobjectType()) {

			@Override
			protected Object evaluateInternal(Object target, Object[] params) {
				FeatureMap map = (FeatureMap) target;
				EStructuralFeature.Setting s = (EStructuralFeature.Setting) map;
				EObject o = (EObject) params[0];
				Validator v = FeatureMapUtil.getValidator(s.getEObject()
						.eClass(), s.getEStructuralFeature());
				for (EStructuralFeature f : o.eClass()
						.getEAllStructuralFeatures())
					if (!f.isDerived() && o.eIsSet(f)) {
						Object val = o.eGet(f);
						if (val instanceof FeatureMap) {
							for (FeatureMap.Entry e : new ArrayList<FeatureMap.Entry>(
									(FeatureMap) val))
								if (v.isValid(e.getEStructuralFeature()))
									add(map, e.getEStructuralFeature(), e
											.getValue());
						} else if (v.isValid(f))
							add(map, f, val);
					}
				return null;
			}

			@SuppressWarnings("rawtypes")
			private void add(FeatureMap map, EStructuralFeature f, Object val) {
				if (f.isMany() && val instanceof Collection) {
					map.addAll(f, (Collection) val);
				} else
					map.add(f, val);
			}
		});
		// }
		return features.toArray(new Feature[features.size()]);
	}

	@SuppressWarnings("unchecked")
	protected List<EStructuralFeature> getMapFeatures() {
		// List<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		// for (EStructuralFeature f : owner.getEStructuralFeatures())
		// if (!isFeatureMap(f))
		// list.add(f);
		// return list;
		return Collections.EMPTY_LIST;
	}

	@Override
	protected Set<? extends Type> internalGetSuperTypes() {
		Type f = model.getEFeatureMapEntryType();
		return Collections.singleton(getTypeSystem().getListType(f));
	}

	public boolean isInstance(final Object o) {
		return o instanceof FeatureMap;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException(
				"Feature maps can not be instantiated outside EObjects");
	}

	public EClass getOwner() {
		return owner;
	}

}
