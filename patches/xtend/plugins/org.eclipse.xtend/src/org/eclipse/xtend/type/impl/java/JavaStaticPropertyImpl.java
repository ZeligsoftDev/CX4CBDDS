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

import java.lang.reflect.Field;

import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class JavaStaticPropertyImpl extends StaticPropertyImpl {

    private Field field;

    public JavaStaticPropertyImpl(final Type owner, final String name, final Type returnType, final Field field) {
        super(owner, name, returnType);
        this.field = field;
    }

    public Object get() {
        try {
            return field.get(null);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}