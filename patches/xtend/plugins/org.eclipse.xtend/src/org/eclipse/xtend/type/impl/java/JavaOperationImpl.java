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

package org.eclipse.xtend.type.impl.java;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class JavaOperationImpl extends OperationImpl {

	private final Method method;

	public JavaOperationImpl(final Type owner, final String name, final Type type, final Type[] parameterTypes, final Method method) {
		super(owner, name, type, parameterTypes);
		this.method = method;
	}

	@Override
	public Object evaluateInternal(final Object target, final Object[] params) {
		try {
			final Object t = getOwner().convert(target, method.getDeclaringClass());
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					params[i] = getParameterTypes().get(i).convert(params[i], method.getParameterTypes()[i]);
				}
			}
			final Object resultRaw = method.invoke(t, params);
			if ((resultRaw != null) && resultRaw.getClass().isArray()) {
				return Arrays.asList((Object[]) resultRaw);
			}
			return resultRaw;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

}
