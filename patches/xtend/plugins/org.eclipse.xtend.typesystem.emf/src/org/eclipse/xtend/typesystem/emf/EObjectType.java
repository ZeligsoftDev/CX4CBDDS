/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.typesystem.emf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

public class EObjectType extends AbstractTypeImpl {

	public EObjectType(final TypeSystem ts) {
		super(ts, "emf::EObject");
	}

	@Override
	public String getDocumentation() {
		return "base type for all ecore based metamodels (added by oAW4 emftools)";
	}

	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] {
				new PropertyImpl(EObjectType.this, "eContainer",
						EObjectType.this) {

					public Object get(final Object target) {
						return ((EObject) target).eContainer();
					}

					@Override
					public void set(final Object target, final Object newValue) {
						throw new UnsupportedOperationException();
					}
				},
				new PropertyImpl(EObjectType.this, "eContents", getTypeSystem()
						.getListType(EObjectType.this)) {

					public Object get(final Object target) {
						return ((EObject) target).eContents();
					}

					@Override
					public void set(final Object target, final Object newValue) {
						throw new UnsupportedOperationException();
					}
				},
				new PropertyImpl(EObjectType.this, "eRootContainer",
						EObjectType.this) {

					public Object get(final Object target) {
						return EcoreUtil.getRootContainer((EObject) target);
					}

					@Override
					public void set(final Object target, final Object newValue) {
						throw new UnsupportedOperationException();
					}
				},

				new PropertyImpl(EObjectType.this, "eAllContents",
						getTypeSystem().getSetType(EObjectType.this)) {

					public Object get(final Object target) {
						final HashSet<EObject> allCont = new HashSet<EObject>();
						final Iterator<EObject> iter = ((EObject) target).eAllContents();
						while (iter.hasNext()) {
							allCont.add(iter.next());
						}
						return allCont;
					}

					@Override
					public void set(final Object target, final Object newValue) {
						throw new UnsupportedOperationException();
					}
				},

				new OperationImpl(EObjectType.this, "toString", getTypeSystem()
						.getSetType(EObjectType.this)) {
					@Override
					protected Object evaluateInternal(Object target,
							Object[] params) {
						if (target instanceof DynamicEObjectImpl) {
							return EObjectType.toString((EObject) target);
						}
						return target.toString();
					}

				} };
	}

	public boolean isInstance(final Object o) {
		return o instanceof EObject;
	}

	public Object newInstance() {
		throw new UnsupportedOperationException("newInstance on " + getName());
	}

	@Override
	public Set<Type> getSuperTypes() {
		return Collections.singleton(getTypeSystem().getObjectType());
	}

	public static StringBuffer toString(EObject x) {
		if (x == null) {
			return new StringBuffer("null");
		}
		StringBuffer buff = new StringBuffer(x.eClass().getEPackage().getName()).append("::").append(x.eClass().getName()).append("(");
		Iterator<EStructuralFeature> iter = x.eClass()
				.getEAllStructuralFeatures().iterator();
		while (iter.hasNext()) {
			EStructuralFeature f = iter.next();
			if (f instanceof EAttribute) {
				buff.append(f.getName()).append("=").append(x.eGet(f));
			}
			if (f instanceof EReference) {
				Object o = x.eGet(f);
				if (((EReference) f).isContainment()) {
					buff.append(f.getName()).append("=").append(toString(o));
				} else {
					buff.append(f.getName()).append("=").append(shortString(o));
				}
			}
			if (iter.hasNext())
				buff.append(",");
		}
		return buff.append(")");
	}

	private static StringBuffer toString(Object o) {
		if (o instanceof Collection<?>) {
			StringBuffer buff = new StringBuffer("{");
			Iterator<?> iter = ((Collection<?>) o).iterator();
			while (iter.hasNext()) {
				Object x = iter.next();
				if (x instanceof EObject) {
					buff.append(toString((EObject) x));
				} else {
					buff.append("nonEMF:").append(x);
				}
				if (iter.hasNext())
					buff.append(",");
			}
			buff.append("}");
			return buff;
		}
		if (o instanceof EObject)
			return toString((EObject) o);
		return new StringBuffer();
	}

	private static String shortString(Object o) {
		if (o instanceof Collection<?>) {
			StringBuffer buff = new StringBuffer("{");
			for (Object x : ((Collection<?>) o)) {
				if (x instanceof EObject)
					buff.append(shortString((EObject) x));
			}
			buff.append("}");
			return buff.toString();
		}
		if (o instanceof EObject)
			return shortString((EObject) o);
		return "";
	}

	public static String shortString(EObject x) {
		if (x == null) {
			return "null";
		}
		if (x.eClass().getEStructuralFeature("name") != null) {
			return x.eGet(x.eClass().getEStructuralFeature("name")) + " : "
					+ x.eClass().getName();
		}
		return "unnamed : " + x.eClass().getName();
	}

}
