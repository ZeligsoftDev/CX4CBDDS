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

package org.eclipse.internal.xtend.type.baseimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Type;

public abstract class OperationImpl extends FeatureImpl implements Operation {
	private static final List<Type> NO_TYPES = Collections.emptyList();
	private final List<Type> paramTypes;

	private final Type owner;

	public OperationImpl(final Type owner, final String name, final Type returnType, final Type... paramTypes) {
		super(name, returnType);
		this.paramTypes = (paramTypes == null) || (paramTypes.length == 0) ? NO_TYPES : Arrays.asList(paramTypes);
		this.owner = owner;
	}

	public final Object evaluate(final Object target, final Object[] params) {
		try {
			return evaluateInternal(target, params);
		} catch (final NullPointerException e) {
			if (target == null) {
				return null;
			}
			throw e;
		}
	}

	protected abstract Object evaluateInternal(Object target, Object[] params);

	public Type getOwner() {
		return owner;
	}

	public List<Type> getParameterTypes() {
		return paramTypes;
	}

	public Type getReturnType(final Type targetType, final Type[] paramTpes) {
		return getReturnType();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Operation) {
			final Operation op = (Operation) obj;
			boolean equals = getOwner().equals(op.getOwner()) && getName().equals(op.getName())
					&& (getParameterTypes().size() == op.getParameterTypes().size());

			if (equals) {
				final List<Type> typesA = getParameterTypes();
				final List<Type> typesB = op.getParameterTypes();
				for (int i = 0; (i < typesA.size()) && equals; i++) {
					final Type a = typesA.get(i);
					final Type b = typesB.get(i);
					equals = equals && a.equals(b);
				}
			}
			return equals;
		}
		return false;
	}

	private int hashCode = 0;

	@Override
	public int hashCode() {
		if (hashCode == 0) {
			hashCode = 17;
			hashCode = (hashCode * 37) + owner.hashCode();
			hashCode = (hashCode * 37) + getName().hashCode();
			for (int i = 0; i < paramTypes.size(); i++) {
				hashCode = (hashCode * 37) + paramTypes.get(i).hashCode();
			}
		}
		return hashCode;
	}

	@Override
	public String toString() {
		final StringBuffer buff = new StringBuffer();
		if (getReturnType() != null) {
			buff.append(getReturnType().toString());
		} else {
			buff.append("void");
		}
		buff.append(" ").append(getOwner().toString());
		buff.append(".").append(getName()).append("(");

		for (int i = 0, x = getParameterTypes().size(); i < x; i++) {
			final Type paramType = getParameterTypes().get(i);
			buff.append(paramType.toString());
			if ((i + 1) < x) {
				buff.append(",");
			}
		}
		buff.append(")");
		return buff.toString();
	}

	public String getDocumentation() {
		return "";
	}
}
