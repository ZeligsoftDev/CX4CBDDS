/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem;

import java.util.Set;

import org.eclipse.xtend.expression.TypeSystem;


/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Peter Friese
 */
public interface MetaModel {

	/**
	 * Returns the underlying typesystem.
	 * 
	 * @return the typesystem
	 */
	TypeSystem getTypeSystem();

	/**
	 * Sets the underlying typesystem.
	 * 
	 * @param typeSystem
	 *            the typesystem
	 */
	void setTypeSystem(TypeSystem typeSystem);

	/**
	 * if this metamodel is responsible for a type with the given name, it
	 * returns the corresponding type. Otherwise returns <code>null</code>
	 * 
	 * @param typeName
	 *            name of type
	 * @return the corresponding type
	 */
	Type getTypeForName(String typeName);

	/**
	 * if this metamodel is responsible for a types which are responsible for
	 * the given object, it returns the corresponding type. Otherwise returns
	 * <code>null</code>
	 * 
	 * @param obj
	 *            object for which a corresponding object is requested
	 * @return the corresponding type
	 */
	Type getType(Object obj);

	/**
	 * returns all types this metamodel is responsible for
	 * 
	 * @return set of known types
	 */
	Set<? extends Type> getKnownTypes();

	/**
	 * Returns all namespaces provided by this metamodel.
	 * 
	 * @return A {@link Set} containing the names of all namespaces provided by
	 *         this metamodel.
	 */
	Set<String> getNamespaces();

}
