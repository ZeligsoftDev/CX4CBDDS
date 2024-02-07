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

import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;

public abstract class BuiltinBaseType extends AbstractTypeImpl {

    public BuiltinBaseType(final TypeSystem ts, final String name) {
        super(ts, name);
    }

}
