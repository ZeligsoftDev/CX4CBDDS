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

package org.eclipse.internal.xtend.type.baseimpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.type.baseimpl.types.BooleanTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.CollectionTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.FeatureTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.IntegerTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.ListTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.ObjectTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.OperationTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.PropertyTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.RealTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.SetTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.StaticPropertyTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.StringTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.TypeTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.VoidType;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public final class BuiltinMetaModel implements MetaModel {

	public static final String OBJECT = "Object";

	// Datatypes
	public final static String STRING = "String";

	public final static String BOOLEAN = "Boolean";

	public final static String INTEGER = "Integer";

	public final static String REAL = "Real";

	// Collection types
	public final static String COLLECTION = "Collection";

	public final static String SET = "Set";

	public final static String LIST = "List";

	// reflection layer types
	public static final String TYPE = "xpand2::Type";

	public static final String FEATURE = "xpand2::Feature";

	public static final String PROPERTY = "xpand2::Property";

	public static final String OPERATION = "xpand2::Operation";

	private static final String STATIC_PROPERTY = "xpand2::StaticProperty";

	public static final String VOID = "Void";

	// singleton instances
	private Type stringType = null;

	private Type booleanType = null;

	private Type integerType = null;

	private Type realType = null;

	private Type objectType = null;

	private Type typeType = null;

	private Type featureType = null;

	private Type propertyType = null;

	private Type operationType = null;

	private Type staticPropertyType = null;

	private Type voidType = null;

	private ParameterizedType collectionOfObjectType = null;

	private ParameterizedType listOfObjectType = null;

	private ParameterizedType setOfObjectType = null;

	private final Map<String, Type> _builtinTypes = new HashMap<String, Type>();

	private TypeSystem typeSystem;

	public TypeSystem getTypeSystem() {
		return typeSystem;
	}

	public BuiltinMetaModel(final TypeSystem typeSystem) {
		this.typeSystem = typeSystem;

		stringType = new StringTypeImpl(getTypeSystem(), BuiltinMetaModel.STRING);

		booleanType = new BooleanTypeImpl(getTypeSystem(), BuiltinMetaModel.BOOLEAN);

		integerType = new IntegerTypeImpl(getTypeSystem(), BuiltinMetaModel.INTEGER);

		realType = new RealTypeImpl(getTypeSystem(), BuiltinMetaModel.REAL);

		objectType = new ObjectTypeImpl(getTypeSystem(), BuiltinMetaModel.OBJECT);

		typeType = new TypeTypeImpl(getTypeSystem(), BuiltinMetaModel.TYPE);

		featureType = new FeatureTypeImpl(getTypeSystem(), BuiltinMetaModel.FEATURE);

		propertyType = new PropertyTypeImpl(getTypeSystem(), BuiltinMetaModel.PROPERTY);

		staticPropertyType = new StaticPropertyTypeImpl(getTypeSystem(), BuiltinMetaModel.STATIC_PROPERTY);

		operationType = new OperationTypeImpl(getTypeSystem(), BuiltinMetaModel.OPERATION);

		voidType = new VoidType(getTypeSystem(), BuiltinMetaModel.VOID);

		collectionOfObjectType = new CollectionTypeImpl(objectType, getTypeSystem(), BuiltinMetaModel.COLLECTION);

		listOfObjectType = new ListTypeImpl(objectType, getTypeSystem(), BuiltinMetaModel.LIST);

		setOfObjectType = new SetTypeImpl(objectType, getTypeSystem(), BuiltinMetaModel.SET);

		_builtinTypes.put(BuiltinMetaModel.OBJECT, objectType);
		_builtinTypes.put(convert(Object.class.getName()), objectType);

		_builtinTypes.put(BuiltinMetaModel.VOID, voidType);

		_builtinTypes.put(BuiltinMetaModel.STRING, stringType);
		_builtinTypes.put(convert(String.class.getName()), stringType);
		_builtinTypes.put(convert(StringBuffer.class.getName()), stringType);
		_builtinTypes.put(Character.TYPE.getName(), stringType);
		_builtinTypes.put(convert(Character.class.getName()), stringType);

		_builtinTypes.put(BuiltinMetaModel.BOOLEAN, booleanType);
		_builtinTypes.put(Boolean.TYPE.getName(), booleanType);
		_builtinTypes.put(convert(Boolean.class.getName()), booleanType);

		_builtinTypes.put(BuiltinMetaModel.INTEGER, integerType);
		_builtinTypes.put(Integer.TYPE.getName(), integerType);
		_builtinTypes.put(convert(Integer.class.getName()), integerType);
		_builtinTypes.put(convert(Long.class.getName()), integerType);
		_builtinTypes.put(convert(Short.class.getName()), integerType);
		_builtinTypes.put(convert(Byte.class.getName()), integerType);
		_builtinTypes.put(convert(BigInteger.class.getName()), integerType);

		_builtinTypes.put(BuiltinMetaModel.REAL, realType);
		_builtinTypes.put(Double.TYPE.getName(), realType);
		_builtinTypes.put(Float.TYPE.getName(), realType);
		_builtinTypes.put(convert(Double.class.getName()), realType);
		_builtinTypes.put(convert(Float.class.getName()), realType);
		_builtinTypes.put(convert(BigDecimal.class.getName()), realType);

		_builtinTypes.put(BuiltinMetaModel.TYPE, typeType);
		_builtinTypes.put(BuiltinMetaModel.FEATURE, featureType);
		_builtinTypes.put(BuiltinMetaModel.PROPERTY, propertyType);
		_builtinTypes.put(BuiltinMetaModel.OPERATION, operationType);
		_builtinTypes.put(BuiltinMetaModel.STATIC_PROPERTY, staticPropertyType);

		_builtinTypes.put(BuiltinMetaModel.COLLECTION, getCollectionType(objectType));
		_builtinTypes.put(Collection.class.getName(), getCollectionType(objectType));
		_builtinTypes.put(convert(Collection.class.getName()), getCollectionType(objectType));
		_builtinTypes.put(BuiltinMetaModel.SET, getSetType(objectType));
		_builtinTypes.put(Set.class.getName(), getSetType(objectType));
		_builtinTypes.put(convert(Set.class.getName()), getSetType(objectType));
		_builtinTypes.put(BuiltinMetaModel.LIST, getListType(objectType));
		_builtinTypes.put(List.class.getName(), getListType(objectType));
		_builtinTypes.put(convert(List.class.getName()), getListType(objectType));

		_knownTypes = new HashSet<Type>(_builtinTypes.values());
	}

	/**
	 * Returns the name of the metamodel.
	 * 
	 * @return name of metamodel
	 */
	public String getName() {
		return "built-in";
	}

	/**
	 * Returns the type for objects.
	 * 
	 * @return type for objects
	 */
	public final Type getObjectType() {
		return objectType;
	}

	/**
	 * Returns the type for boolean objects.
	 * 
	 * @return type for boolean objects
	 */
	public final Type getBooleanType() {
		return booleanType;
	}

	/**
	 * Returns the type for integer objects.
	 * 
	 * @return type for integer objects
	 */
	public final Type getIntegerType() {
		return integerType;
	}

	/**
	 * Returns the type for real objects.
	 * 
	 * @return type for real objects
	 */
	public Type getRealType() {
		return realType;
	}

	/**
	 * Returns the type for string objects.
	 * 
	 * @return type for string objects
	 */
	public final Type getStringType() {
		return stringType;
	}

	/**
	 * Returns the type for type objects.
	 * 
	 * @return type for type objects
	 */
	public final Type getTypeType() {
		return typeType;
	}

	/**
	 * Returns the type for feature objects.
	 * 
	 * @return type for feature objects
	 */
	public final Type getFeatureType() {
		return featureType;
	}

	/**
	 * Returns the type for property objects.
	 * 
	 * @return type for property objects
	 */
	public final Type getPropertyType() {
		return propertyType;
	}

	/**
	 * Returns the type for operation objects.
	 * 
	 * @return type for operation objects
	 */
	public final Type getOperationType() {
		return operationType;
	}

	/**
	 * Returns the type for static property objects.
	 * 
	 * @return type for static property objects
	 */
	public Type getStaticPropertyType() {
		return staticPropertyType;
	}

	private final Map<Type, CollectionTypeImpl> collectionTypeCache = new HashMap<Type, CollectionTypeImpl>();

	/**
	 * Returns the type for collection objects.
	 * 
	 * @return type for collection objects
	 */
	public final ParameterizedType getCollectionType(final Type innerType) {
		if (innerType == getObjectType()) {
			return collectionOfObjectType;
		}

		CollectionTypeImpl result = collectionTypeCache.get(innerType);
		if (result == null) {
			result = new CollectionTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.COLLECTION);
			collectionTypeCache.put(innerType, result);
		}
		return result;
	}

	private final Map<Type, ListTypeImpl> listTypeCache = new HashMap<Type, ListTypeImpl>();

	/**
	 * Returns the type for list objects.
	 * 
	 * @return type for list objects
	 */
	public final ParameterizedType getListType(final Type innerType) {
		if (innerType == getObjectType()) {
			return listOfObjectType;
		}

		ListTypeImpl result = listTypeCache.get(innerType);
		if (result == null) {
			result = new ListTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.LIST);
			listTypeCache.put(innerType, result);
		}
		return result;
	}

	private final Map<Type, SetTypeImpl> setTypeCache = new HashMap<Type, SetTypeImpl>();

	/**
	 * Returns the type for set objects.
	 * 
	 * @return type for set objects
	 */
	public final ParameterizedType getSetType(final Type innerType) {
		if (innerType == getObjectType()) {
			return setOfObjectType;
		}

		SetTypeImpl result = setTypeCache.get(innerType);
		if (result == null) {
			result = new SetTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.SET);
			setTypeCache.put(innerType, result);
		}
		return result;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getType(java.lang.Object)
	 */
	public Type getType(final Object obj) {
		if (obj == null) {
			return getVoidType();
		}
		if (obj instanceof Set) {
			return getSetType(getObjectType());
		}
		if (obj instanceof List) {
			return getListType(getObjectType());
		}
		if (obj instanceof Collection) {
			return getCollectionType(getObjectType());
		}
		// datatypes
		if (stringType.isInstance(obj)) {
			return stringType;
		}
		if (integerType.isInstance(obj)) {
			return integerType;
		}
		if (booleanType.isInstance(obj)) {
			return booleanType;
		}
		if (realType.isInstance(obj)) {
			return realType;
		}
		if (typeType.isInstance(obj)) {
			return typeType;
		}
		if (propertyType.isInstance(obj)) {
			return propertyType;
		}
		if (operationType.isInstance(obj)) {
			return operationType;
		}
		if (staticPropertyType.isInstance(obj)) {
			return staticPropertyType;
		}

		return objectType;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getTypeForName(java.lang.String)
	 */
	public Type getTypeForName(final String typeName) {
		return _builtinTypes.get(typeName);
	}

	HashSet<Type> _knownTypes;

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getKnownTypes()
	 */
	public Set<Type> getKnownTypes() {
		return _knownTypes;
	}

	private final static String convert(final String javaclassname) {
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < javaclassname.length(); i++) {
			final char c = javaclassname.charAt(i);
			if (c == '.') {
				sb.append(SyntaxConstants.NS_DELIM);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Returns the type for void objects.
	 * 
	 * @return type for void objects
	 */
	public Type getVoidType() {
		return voidType;
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#setTypeSystem(org.eclipse.xtend.expression.TypeSystem)
	 */
	public void setTypeSystem(final TypeSystem typeSystem) {
		if (typeSystem != null) {
			this.typeSystem = typeSystem;
		}
	}

	/**
	 * @see org.eclipse.xtend.typesystem.MetaModel#getNamespaces()
	 */
	public Set<String> getNamespaces() {
		// TODO: provide real implementation
		return new HashSet<String>();
	}
}
