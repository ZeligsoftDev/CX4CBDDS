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

package org.eclipse.xtend.expression;

import java.util.Set;

import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;


/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public interface TypeSystem {
	Type getType(Object obj);

	Type getTypeForName(String name);

	Type[] getAllTypes();

	Type[] findTypesForPrefix(String prefix);

	Set<String> getNamespaces();

	Operation findOperation(String name, Object target, Object[] params);

	Property findProperty(String name, Object target);

	// Convenience shortcuts for access to built-in types

	Type getVoidType();

	Type getBooleanType();

	Type getIntegerType();

	Type getRealType();

	Type getStringType();

	Type getObjectType();

	Type getListType(Type innerType);

	Type getSetType(Type innerType);

	Type getCollectionType(Type innerType);

	Type getTypeType();

	Type getFeatureType();

	Type getPropertyType();

	Type getOperationType();

	Type getStaticPropertyType();

	/** Clears internal resources (caches). */
	void release();

}
