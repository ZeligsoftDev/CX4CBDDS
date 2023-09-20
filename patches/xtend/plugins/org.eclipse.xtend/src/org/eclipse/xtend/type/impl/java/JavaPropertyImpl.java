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

import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class JavaPropertyImpl extends PropertyImpl {

    private Method readMethod;

    private Method writeMethod;

    public JavaPropertyImpl(final Type owner, final String name, final Type returnType, final Method readMethod,
            final Method writeMethod) {
        super(owner, name, returnType);
        this.readMethod = readMethod;
        this.writeMethod = writeMethod;
    }

    public Object get(final Object target) {
        try {
            final Object resultRaw = readMethod.invoke(target, (Object[])null);
            if (resultRaw != null && resultRaw.getClass().isArray()) {
                return Arrays.asList ((Object[]) resultRaw);
            }
            return resultRaw;
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void set(final Object target, final Object newValue) {
        if (writeMethod == null)
            throw new UnsupportedOperationException("Property " + getName() + " is not writable!");
        try {
            writeMethod.invoke(target, new Object[] { newValue });
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
