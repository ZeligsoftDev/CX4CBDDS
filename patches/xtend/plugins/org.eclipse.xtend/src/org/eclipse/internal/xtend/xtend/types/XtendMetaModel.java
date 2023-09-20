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
package org.eclipse.internal.xtend.xtend.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;

public class XtendMetaModel implements MetaModel {
	private final AdviceContextType adviceContextType;
	private final Set<? extends Type> knownTypes;
	private static final Set<String> NAMESPACES = Collections.emptySet();

	private final Map<String, Type> types = new HashMap<String, Type>();

	public XtendMetaModel(final TypeSystem ts) {
		setTypeSystem(ts);
		adviceContextType = new AdviceContextType(ts);
		knownTypes = Collections.singleton(adviceContextType);
	}

	/**
	 * @see MetaModel#getKnownTypes()
	 */
	public Set<? extends Type> getKnownTypes() {
		return knownTypes;
	}

	/**
	 * Returns the name of the metamodel.
	 * 
	 * @return name of metamodel
	 */
	public String getName() {
		return "xtend";
	}

	/**
	 * @see MetaModel#getType(java.lang.Object)
	 */
	public Type getType(final Object obj) {
		return adviceContextType.isInstance(obj) ? adviceContextType : null;
	}

	/**
	 * @see MetaModel#getTypeForName(java.lang.String)
	 */
	public Type getTypeForName(final String typeName) {
		return adviceContextType.getName().equals(typeName) ? adviceContextType : null;
	}

	private TypeSystem ts = null;

	/**
	 * @see MetaModel#getTypeSystem()
	 */
	public TypeSystem getTypeSystem() {
		return ts;
	}

	/**
	 * @see MetaModel#setTypeSystem(TypeSystem)
	 */
	public void setTypeSystem(final TypeSystem typeSystem) {
		ts = typeSystem;
	}

	/**
	 * @see MetaModel#getNamespaces()
	 */
	public Set<String> getNamespaces() {
		return NAMESPACES;
	}
}
