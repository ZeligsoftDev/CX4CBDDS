/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtend.typesystem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.internal.xtend.type.baseimpl.PolymorphicResolver;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.xtend.expression.TypeSystem;

public abstract class AbstractTypeImpl implements Type {

	private final static Logger log = LogManager.getLogger(AbstractTypeImpl.class);

	private final TypeSystem typeSystem;

	private final String _name;

	public AbstractTypeImpl(final TypeSystem typeSystem, final String name) {
		this.typeSystem = typeSystem;
		_name = name;
	}

	public final TypeSystem getTypeSystem() {
		return typeSystem;
	}

	public final String getName() {
		return _name;
	}

	public abstract Feature[] getContributedFeatures();

	private Set<Callable> allFeatures = null;

	/**
	 * Return all features defined by the type
	 */
	public final Set<Callable> getAllFeatures() {
		if (allFeatures == null) {
			allFeatures = new HashSet<Callable>(Arrays.asList(getContributedFeatures()));
			for (Type type : getSuperTypes()) {
				if (type != null) {
					allFeatures.addAll(type.getAllFeatures());
				} else {
					log.error("A supertype of " + getName() + " is null!");
				}
			}
		}
		return allFeatures;
	}

	public StaticProperty getStaticProperty(final String name) {
		return PolymorphicResolver.getStaticProperty(getAllFeatures(), name, this);
	}

	private final Cache<String, Property> propertyCache = new Cache<String, Property>() {

		@Override
		protected Property createNew(final String name) {
			return PolymorphicResolver.getProperty(getAllFeatures(), name, AbstractTypeImpl.this);
		}
	};

	public Property getProperty(final String name) {
		return propertyCache.get(name);
	}

	public Callable getFeature(final String name, final Type[] parameterTypes) {
		Property property = null;
		if ((parameterTypes == null) || (parameterTypes.length == 0)) {
			property = getProperty(name);
		}
		final Operation operation = getOperation(name, parameterTypes);
		if ((property != null) && (operation != null)) {
			if (property.getOwner().equals(operation.getOwner())) {
				throw new RuntimeException();
			} else if (property.getOwner().isAssignableFrom(operation.getOwner())) {
				return operation;
			} else {
				return property;
			}
		} else if (property != null) {
			return property;
		} else {
			return operation;
		}
	}

	private static class Signature {
		private static final Type[] EMPTY = new Type[0];

		protected final String name;
		protected final Type[] parameterTypes;

		Signature(final String name, final Type[] parameterTypes) {
			this.name = name;
			this.parameterTypes = parameterTypes == null ? EMPTY : parameterTypes;
		}

		@Override
		public int hashCode() {
			int result = name == null ? 0 : name.hashCode();
			for (Type type : parameterTypes) {
				result *= 31;
				if (type != null) {
					result += type.hashCode();
				}
			}
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj == this) {
				return true;
			}

			if (!(obj instanceof Signature)) {
				return false;
			}

			Signature signature = (Signature) obj;
			String otherName = signature.name;
			if ((name != otherName) && (name != null) && !name.equals(otherName)) {
				return false;
			}

			int length = parameterTypes.length;
			Type[] otherParameterTypes = signature.parameterTypes;
			if (length != otherParameterTypes.length) {
				return false;
			}

			for (int i = 0; i < length; ++i) {
				Type type = parameterTypes[i];
				Type otherType = otherParameterTypes[i];
				if ((type != otherType) && (type != null) && !type.equals(otherType)) {
					return false;
				}
			}

			return true;
		}
	}

	private final Cache<Signature, Operation> operationsCache = new Cache<Signature, Operation>() {

		@Override
		protected Operation createNew(final Signature signature) {
			return PolymorphicResolver.getOperation(getAllFeatures(), signature.name, AbstractTypeImpl.this, Arrays.asList(signature.parameterTypes));
		}
	};

	public Operation getOperation(final String name, final Type[] parameterTypes) {
		return operationsCache.get(new Signature(name, parameterTypes));
	}

	public Set<? extends StaticProperty> getAllStaticProperties() {
		return PolymorphicResolver.select(getAllFeatures(), StaticProperty.class);
	}

	public Set<? extends Property> getAllProperties() {
		return PolymorphicResolver.select(getAllFeatures(), Property.class);
	}

	public Set<? extends Operation> getAllOperations() {
		return PolymorphicResolver.select(getAllFeatures(), Operation.class);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Type) {
			return getName().equals(((Type) obj).getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

	public final boolean isAssignableFrom(final Type t) {
		if (t == null) {
			return false;
		}
		if (equals(t)) {
			return true;
		}
		if (t.equals(getTypeSystem().getVoidType())) {
			return true;
		}
		return internalIsAssignableFrom(t);
	}

	protected boolean internalIsAssignableFrom(final Type t) {
		for (Type type : t.getSuperTypes()) {
			if (isAssignableFrom(type)) {
				return true;
			}
		}
		return false;
	}

	public Object convert(final Object src, final Class<?> targetType) {
		if (src == null) {
			return null;
		}
		if (targetType.isInstance(src)) {
			return src;
		}
		throw new IllegalArgumentException(getName() + " is not responsible for java type " + targetType.getName());
	}

	public String getDocumentation() {
		return "";
	}

	private Set<? extends Type> superTypes = null;

	public Set<? extends Type> getSuperTypes() {
		if (superTypes == null) {
			superTypes = internalGetSuperTypes();
		}
		return superTypes;
	}

	protected Set<? extends Type> internalGetSuperTypes() {
		return Collections.singleton(getTypeSystem().getObjectType());
	}

	public boolean isAbstract() {
		return false;
	}
}
