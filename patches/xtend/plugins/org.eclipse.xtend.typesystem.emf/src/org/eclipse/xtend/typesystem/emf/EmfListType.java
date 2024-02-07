/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *     QNX Software Systems - EmfListType rejects lists of data types
 *******************************************************************************/
package org.eclipse.xtend.typesystem.emf;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.internal.xtend.type.baseimpl.types.ListTypeImpl;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.Type;

public class EmfListType extends ListTypeImpl {

	public EmfListType(final Type innerType, final TypeSystem ts, final String name) {
		super(innerType, ts, name);
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public Object convert(Object src, Class<?> targetType) {
		if (src instanceof EList)
            return src;

		if (src instanceof Collection) {
			return new BasicEList((Collection)src);
		}

		return super.convert(src, targetType);
	}
}
