/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.type.baseimpl.types;

import java.util.Collections;
import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
@SuppressWarnings("unchecked")
public class ObjectTypeImpl extends BuiltinBaseType {

	public ObjectTypeImpl(final TypeSystem ts, final String name) {
		super(ts, name);
	}

	@Override
	public Feature[] getContributedFeatures() {
		return new Feature[] { new OperationImpl(this, "==", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return new Boolean(target == params[0]);
				}
				return new Boolean(target.equals(params[0]));
			}
		}, new OperationImpl(this, "!=", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return new Boolean(target != params[0]);
				}
				return new Boolean(!target.equals(params[0]));
			}
		}, new OperationImpl(this, ">", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return Boolean.FALSE;
				}
				if (params[0] == null) {
					return Boolean.FALSE;
				}
				return new Boolean(((Comparable<Object>) target).compareTo(params[0]) > 0);
			}
		}, new OperationImpl(this, ">=", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return params[0] == null ? Boolean.TRUE : Boolean.FALSE;
				}
				if (params[0] == null) {
					return Boolean.FALSE;
				}
				return new Boolean(((Comparable<Object>) target).compareTo(params[0]) >= 0);
			}
		}, new OperationImpl(this, "<", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return Boolean.FALSE;
				}
				if (params[0] == null) {
					return Boolean.FALSE;
				}
				return new Boolean(((Comparable<Object>) target).compareTo(params[0]) < 0);
			}
		}, new OperationImpl(this, "<=", getTypeSystem().getBooleanType(), new Type[] { ObjectTypeImpl.this }) {
			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return params[0] == null ? Boolean.TRUE : Boolean.FALSE;
				}
				if (params[0] == null) {
					return Boolean.FALSE;
				}
				return new Boolean(((Comparable<Object>) target).compareTo(params[0]) <= 0);
			}
		}, new PropertyImpl(this, "metaType", getTypeSystem().getTypeType()) {
			@Override
			public String getDocumentation() {
				return "returns this object's meta type.";
			}

			public Object get(final Object target) {
				return getTypeSystem().getType(target);
			}
		}, new OperationImpl(this, "toString", getTypeSystem().getStringType()) {
			@Override
			public String getDocumentation() {
				return "returns the String representation of this object. (Calling Java's toString() method)";
			}

			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				return target != null ? target.toString() : "null";
			}
		}, new OperationImpl(this, "compareTo", getTypeSystem().getIntegerType(), new Type[] { this }) {
			@Override
			public String getDocumentation() {
				return "Compares this object with the specified object for order.  Returns a negative "
						+ "integer, zero, or a positive integer as this object is less than, equal to, " + "or greater than the specified object.";
			}

			@Override
			public Object evaluateInternal(final Object target, final Object[] params) {
				if (target == null) {
					return params[0] == null ? new Long(0) : new Long(-1);
				}
				if (params[0] == null) {
					return new Long(1);
				}
				if (target instanceof Comparable) {
					return new Long(((Comparable<Object>) target).compareTo(params[0]));
				}
				final TypeSystem ts = getTypeSystem();
				Operation op = ts.findOperation("toString", target, null);
				final String s1 = (String) op.evaluate(target, null);
				op = ts.findOperation("toString", params[0], null);
				final String s2 = (String) op.evaluate(params[0], null);

				return new Long(s1.compareTo(s2));
			}
		} };
	}

	public boolean isInstance(final Object o) {
		return true;
	}

	public Object newInstance() {
		return new Object();
	}

	@Override
	public Set<Type> getSuperTypes() {
		return Collections.EMPTY_SET;
	}

}
