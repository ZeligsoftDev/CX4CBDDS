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
package org.eclipse.internal.xpand2.type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;

public class XpandTypesMetaModel implements MetaModel {

	private TypeSystem typeSystem;

	private final Map<String, AbstractTypeImpl> types = new HashMap<String, AbstractTypeImpl>();

	public XpandTypesMetaModel(final TypeSystem ts) {
		if (ts == null)
			throw new IllegalArgumentException("Typesystem must not be null!");
		typeSystem = ts;
		types.put(DefinitionType.TYPE_NAME, new DefinitionType(ts));
		types.put(IteratorType.TYPE_NAME, new IteratorType(ts));
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getTypeSystem()
	 */
	public TypeSystem getTypeSystem() {
		return typeSystem;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#setTypeSystem(org.eclipse.xtend.expression.TypeSystem)
	 */
	public void setTypeSystem(final TypeSystem typeSystem) {
		this.typeSystem = typeSystem;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getTypeForName(java.lang.String)
	 */
	public Type getTypeForName(final String typeName) {
		return types.get(typeName);
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getType(java.lang.Object)
	 */
	public Type getType(final Object obj) {
		for (final Iterator<AbstractTypeImpl> iter = types.values().iterator(); iter.hasNext();) {
			final Type t = iter.next();
			if (t.isInstance(obj))
				return t;
		}
		return null;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getKnownTypes()
	 */
	public Set<? extends Type> getKnownTypes() {
		return new HashSet<AbstractTypeImpl>(types.values());
	}

	/**
	 * Returns the name of the metamodel.
	 * 
	 * @return name of metamodel
	 */
	public String getName() {
		return "xpand";
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object arg0) {
		return arg0 instanceof XpandTypesMetaModel;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 4711;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getNamespaces()
	 */
	public Set<String> getNamespaces() {
		return new HashSet<String>();
	}
}
