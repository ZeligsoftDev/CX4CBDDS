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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.xtend.expression.TypeNameUtil;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.type.impl.java.beans.JavaBeansStrategy;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class JavaMetaModel implements MetaModel, TypeFinder {
	private String _name = null;

	private JavaTypeStrategy _strategy;

	private TypeSystem typeSystem;

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
		if (typeSystem != null) {
			this.typeSystem = typeSystem;
		}
	}

	public JavaMetaModel() {
		_strategy = new JavaBeansStrategy();
	}

	public JavaMetaModel(final String name, final JavaTypeStrategy strategy) {
		_name = name;
		_strategy = strategy;
	}

	private final Cache<Class<?>, Type> cache = new Cache<Class<? extends Object>, Type>() {
		@Override
		protected Type createNew(final Class<?> clazz) {
			final JavaTypeImpl impl = new JavaTypeImpl(JavaMetaModel.this, clazz, getName(clazz), _strategy);
			if (List.class.isAssignableFrom(clazz))
				return typeSystem.getListType(typeSystem.getObjectType());
			else if (Set.class.isAssignableFrom(clazz))
				return typeSystem.getSetType(typeSystem.getObjectType());
			else if (Collection.class.isAssignableFrom(clazz))
				return typeSystem.getCollectionType(typeSystem.getObjectType());
			return impl;
		}
	};

	private String getName(final Class<?> class1) {
		return TypeNameUtil.getName(class1);
	}

	private final Class<? extends JavaMetaModel> NOCLASS = getClass();

	private final Cache<String, Class<?>> classCache = new Cache<String, Class<? extends Object>>() {
		@Override
		protected Class<?> createNew(final String typeName) {
			// try to load the requested class by its name
			final String classname = typeName.replaceAll(SyntaxConstants.NS_DELIM, ".");
			try {
				final Class<?> loadedClass = ResourceLoaderFactory.createResourceLoader().loadClass(classname);
				return loadedClass == null ? NOCLASS : loadedClass;
			}
			catch (final Exception e1) {
				// FIXME: This catch block should really be removed - the
				// built-in ResosurceLoader implementation
				// never throws an exception, and contributed implementations
				// should comply to this contract
				return NOCLASS;
			}
		}
	};

	/**
	 * @see org.eclipse.xtend.type.impl.java.TypeFinder#builtinAwareGetTypeForName(java.lang.String)
	 */
	public Type builtinAwareGetTypeForName(final String typeName) {
		Type type = typeSystem.getTypeForName(typeName);
		if (type == null) {
			type = getTypeForName(typeName);
		}
		return type;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getTypeForName(java.lang.String)
	 */
	public Type getTypeForName(final String typeName) {
		final Class<?> clazz = classCache.get(typeName);
		if (clazz == NOCLASS)
			return null;
		return getTypeForClass(clazz);
	}

	/**
	 * @see org.eclipse.xtend.type.impl.java.TypeFinder#builtinAwareGetType(java.lang.Object)
	 */
	public Type builtinAwareGetType(final Object obj) {
		Type type = typeSystem.getType(obj);
		if (type == null) {
			type = getType(obj);
		}
		return type;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getType(java.lang.Object)
	 */
	public Type getType(final Object obj) {
		if (obj == null)
			return null;
		return getTypeForClass(obj.getClass());
	}

	/**
	 * @see org.eclipse.xtend.type.impl.java.TypeFinder#builtinAwareGetTypeForClass(java.lang.Class)
	 */
	public Type builtinAwareGetTypeForClass(final Class<?> clazz) {
		Type type = typeSystem.getTypeForName(getName(clazz));
		if (type == null) {
			type = getTypeForClass(clazz);
		}
		return type;
	}

	/**
	 * Returns the corresponding type for an <code>EClass</code> object.
	 *
	 * @param clazz
	 *            the <code>EClass</code> object
	 * @return the corresponding type
	 */
	public Type getTypeForClass(final Class<?> clazz) {
		return cache.get(clazz);
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getKnownTypes()
	 */
	public Set<Type> getKnownTypes() {
		final Collection<Type> col = cache.getValues();
		return (Set<Type>) (col instanceof Set ? col : new HashSet<Type>(col));
	}

	/**
	 * Returns the metamodel name.
	 *
	 * @return the metamodel name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Sets the type strategy.
	 *
	 * @param strategy
	 *            the type strategy
	 */
	public void setTypeStrategy(final JavaTypeStrategy strategy) {
		_strategy = strategy;
	}

	public Set<String> getNamespaces() {
		// TODO: provide real implementation
		return new HashSet<String>();
	}
}
