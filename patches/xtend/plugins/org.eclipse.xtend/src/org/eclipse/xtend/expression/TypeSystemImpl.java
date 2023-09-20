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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.type.baseimpl.BuiltinMetaModel;
import org.eclipse.internal.xtend.util.WeakCache;
import org.eclipse.internal.xtend.xtend.types.XtendMetaModel;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 */
public class TypeSystemImpl implements TypeSystem {
	private static final Type[] NO_TYPES = new Type[0];
	private final Map<String, Map<List<String>, Type>> TYPE_CACHE = new HashMap<String, Map<List<String>, Type>>();
	private WeakReference<Type[]> allTypes;
	private WeakReference<Set<String>> namespaces;
	protected BuiltinMetaModel builtin;

	protected final List<MetaModel> metaModels = new ArrayList<MetaModel>();

	public TypeSystemImpl() {
		setBuiltinMetamodel(new BuiltinMetaModel(this));
		registerMetaModel(new XtendMetaModel(this));
	}

	public void setBuiltinMetamodel(final BuiltinMetaModel builtinMetaModel) {
		builtin = builtinMetaModel;
		registerMetaModel(builtin);
	}

	public final void registerMetaModel(final MetaModel metaModel) {
		if (metaModels.contains(metaModel)) {
			return;
		}
		metaModel.setTypeSystem(this);
		metaModels.add(metaModel);
		release();
	}

	public List<MetaModel> getMetaModels() {
		// TODO: Make unmodifiable. Unfortunately there are usages that rely on
		// the fact thatthe reference is returned.
		return metaModels;
	}

	private Type[] toTypes(final Object[] params) {
		if (params.length == 0) {
			return NO_TYPES;
		}
		final Type[] types = new Type[params.length];
		for (int i = 0; i < types.length; i++) {
			types[i] = getType(params[i]);
		}
		return types;
	}

	public Operation findOperation(final String name, final Object target, final Object[] params) {
		final Type t = getType(target);
		final Operation op = t.getOperation(name, toTypes(params));
		return op;
	}

	public Property findProperty(final String name, final Object target) {
		final Type t = getType(target);
		final Property prop = t.getProperty(name);
		return prop;
	}

	public Type getObjectType() {
		return builtin.getObjectType();
	}

	public Type getVoidType() {
		return builtin.getVoidType();
	}

	public Type getBooleanType() {
		return builtin.getBooleanType();
	}

	public Type getIntegerType() {
		return builtin.getIntegerType();
	}

	public Type getRealType() {
		return builtin.getRealType();
	}

	public Type getStringType() {
		return builtin.getStringType();
	}

	public Type getTypeType() {
		return builtin.getTypeType();
	}

	public Type getCollectionType(final Type innerType) {
		final Type t = innerType != null ? innerType : getObjectType();
		return builtin.getCollectionType(t);
	}

	public Type getListType(final Type innerType) {
		final Type t = innerType != null ? innerType : getObjectType();
		return builtin.getListType(t);
	}

	public Type getSetType(final Type innerType) {
		final Type t = innerType != null ? innerType : getObjectType();
		return builtin.getSetType(t);
	}

	private final WeakCache<Object, Type> typeCache = new WeakCache<Object, Type>() {

		@Override
		public Type get(final Object key) {
			if (key instanceof Collection) {
				return createNew(key);
			}
			return super.get(key);
		}

		@Override
		protected Type createNew(final Object obj) {
			Type bestMatch = null;
			for (int i = 0; i < metaModels.size(); i++) {
				final MetaModel curMeta = metaModels.get(i);
				Type t = curMeta.getType(obj);
				if (t != null) {
					if ((bestMatch == null) || bestMatch.isAssignableFrom(t)) {
						bestMatch = t;
					}
				}
			}
			return bestMatch;
		}

	};

	public Type getType(final Object obj) {
		return typeCache.get(obj);
	}

	private Type internalGetTypeForName(final String name) {
		if (name == null) {
			return null;
		}
		String trimmedName = name.trim();
		if (trimmedName.length() == 0) {
			return null;
		}
		final String typeName = TypeNameUtil.getTypeName(trimmedName);
		if (typeName == null) {
			return null;
		}
		final String collectionTypeName = TypeNameUtil.getCollectionTypeName(trimmedName);
		ParameterizedType t = null;
		if (collectionTypeName != null) {
			t = (ParameterizedType) builtin.getTypeForName(collectionTypeName);
			if (t == null) {
				return null;
			}
		}
		Type r = null;
		// FIXME This loop can potentially return wrong results depending on the
		// installed metamodels and the order of these models in the
		// list "metamodels".
		for (int i = 0, size = metaModels.size(); (i < size) && (r == null); i++) {
			final MetaModel curMeta = metaModels.get(i);
			r = curMeta.getTypeForName(typeName);
		}
		if (r == null) {
			return null;
		} else if (t == null) {
			return r;
		} else {
			return t.cloneWithInnerType(r);
		}
	}

	public Type getFeatureType() {
		return builtin.getFeatureType();
	}

	public Type getPropertyType() {
		return builtin.getPropertyType();
	}

	public Type getOperationType() {
		return builtin.getOperationType();
	}

	public Type getTypeForName(final String typeName) {
		if (typeName == null) {
			return null;
		}
		return getTypeForName(typeName, new String[0]);
	}

	public Type getTypeForName(final String typeName, final String[] importedNamespaces) {
		// Shortcut: return null if typename was not specified
		if ((typeName == null) || "".equals(typeName.trim())) {
			return null;
		}
		Map<List<String>, Type> cacheMap = TYPE_CACHE.get(typeName);
		if (cacheMap == null) {
			// creating new cacheMap entry for this typeName
			cacheMap = new HashMap<List<String>, Type>();
			TYPE_CACHE.put(typeName, cacheMap);
		}

		List<String> importedNamespacesList = Arrays.asList(importedNamespaces);
		Type type = cacheMap.get(importedNamespacesList);
		if (type == null) {
			if (cacheMap.containsKey(importedNamespacesList)) {
				// null entry cached for typeName and importedNamespaces!
				return null;
			}
			if (typeName.indexOf(SyntaxConstants.NS_DELIM) >= 0) {
				type = internalGetTypeForName(typeName);
			} else {
				final List<String> possibleNames = getPossibleNames(typeName, importedNamespaces);
				for (String name : possibleNames) {
					type = internalGetTypeForName(name);
					if (type != null) {
						break;
					}
				}
			}
			if (type != null) {
				cacheMap.put(importedNamespacesList, type);
			}
		}
		return type;
	}

	public Type[] findTypesForPrefix(final String prefix) {
		return findTypesForPrefix(prefix, new String[0]);
	}

	public Type[] findTypesForPrefix(final String prefix, final String[] importedNamespaces) {
		List<String> possibleNames = null;
		if (prefix.indexOf(SyntaxConstants.NS_DELIM) >= 0) {
			possibleNames = new ArrayList<String>();
			possibleNames.add(prefix);
		} else {
			possibleNames = getPossibleNames(prefix, importedNamespaces);
		}
		final Set<Type> result = new HashSet<Type>();
		for (final String name : possibleNames) {
			final String typeName = TypeNameUtil.getTypeName(name);
			if (typeName == null) {
				return new Type[0];
			}
			final String colTypeName = TypeNameUtil.getCollectionTypeName(name);
			ParameterizedType colType = null;
			if (colTypeName != null) {
				colType = (ParameterizedType) builtin.getTypeForName(colTypeName);
				if (colType == null) {
					return new Type[0];
				}
			}

			for (int i = 0; i < metaModels.size(); i++) {
				final MetaModel curMeta = metaModels.get(i);
				result.addAll(filterTypes(typeName, curMeta.getKnownTypes(), colType));
			}
		}
		return result.toArray(new Type[result.size()]);
	}

	public Type[] getAllTypes() {
		Type[] types = allTypes != null ? allTypes.get() : null;
		if (types == null) {
			final List<Type> result = new ArrayList<Type>();
			for (int i = 0; i < metaModels.size(); i++) {
				final MetaModel curMeta = metaModels.get(i);
				result.addAll(curMeta.getKnownTypes());
			}
			types = result.toArray(new Type[result.size()]);
			allTypes = new WeakReference<Type[]>(types);
		}
		return types;
	}

	public Set<String> getNamespaces() {
		Set<String> result = namespaces != null ? namespaces.get() : null;
		if (result == null) {
			result = new HashSet<String>();
			for (MetaModel metaModel : metaModels) {
				result.addAll(metaModel.getNamespaces());
			}
			namespaces = new WeakReference<Set<String>>(result);
		}
		return result;
	}

	public List<String> getPossibleNames(final String name, final String[] importedNs) {
		final String typeName = TypeNameUtil.getTypeName(name);
		final String collectionTypeName = TypeNameUtil.getCollectionTypeName(name);

		final List<String> result = new ArrayList<String>(importedNs.length + 1);
		result.add(name);

		for (final String string : importedNs) {
			final StringBuffer s = new StringBuffer();
			if (collectionTypeName != null) {
				s.append(collectionTypeName).append("[");
			}
			s.append(string).append(SyntaxConstants.NS_DELIM).append(typeName);
			if (collectionTypeName != null) {
				s.append("]");
			}
			result.add(s.toString());
		}
		return result;
	}

	private Set<Type> filterTypes(final String prefix, final Set<? extends Type> knownTypes, final ParameterizedType colType) {
		final Set<Type> result = new HashSet<Type>();
		for (final Type t : knownTypes) {
			if (prefix.equals("") || t.getName().startsWith(prefix)) {
				if (colType != null) {
					ParameterizedType _colType = (ParameterizedType) builtin.getTypeForName(colType.getName());
					_colType = _colType.cloneWithInnerType(t);
					result.add(_colType);
				} else {
					result.add(t);
				}
			}
		}
		return result;
	}

	public Type getStaticPropertyType() {
		return builtin.getStaticPropertyType();
	}

	public void release() {
		TYPE_CACHE.clear(); // contains static type information about the meta models ('type.name' -> 'type')
		typeCache.clear(); // contains dynamic type information ('element' -> 'type')
		allTypes = null;
		namespaces = null;
	}

	/**
	 * If re-using this type system once in a while for multiple generator runs, clearing the dynamic type information is required, as types of
	 * objects may have changed in the meantime (i.g. by applying/removing stereotypes etc).
	 * 
	 * @since 2.0
	 */
	public void clearCaches() {
		typeCache.clear(); // contains dynamic type information ('element' -> 'type')
	}

}
