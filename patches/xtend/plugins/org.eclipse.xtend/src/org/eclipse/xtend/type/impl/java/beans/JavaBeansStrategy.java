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

package org.eclipse.xtend.type.impl.java.beans;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.type.baseimpl.FeatureImpl;
import org.eclipse.internal.xtend.type.baseimpl.StaticPropertyImpl;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xtend.type.impl.java.JavaOperationImpl;
import org.eclipse.xtend.type.impl.java.JavaPropertyImpl;
import org.eclipse.xtend.type.impl.java.JavaStaticPropertyImpl;
import org.eclipse.xtend.type.impl.java.JavaTypeStrategy;
import org.eclipse.xtend.type.impl.java.TypeFinder;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Karsten Thoms (bugfixing, documentation)
 * @author Bernd Kolb
 */
public class JavaBeansStrategy implements JavaTypeStrategy {

	private static Map<Class<?>, PropertyDescriptor[]> propertyDescCache = new HashMap<Class<?>, PropertyDescriptor[]>();

	/**
	 * Collect all features provided by a Java Class:
	 * <ul>
	 * <li>Properties
	 * <li>Declared public methods
	 * <li>Static fields
	 * <li>Java5 enumeration literals for defined enum types
	 * </ul>
	 */
	public Feature[] getFeatures(final TypeFinder typeFinder, final Class<?> clazz, final Type t) {
		final List<FeatureImpl> result = new ArrayList<FeatureImpl>();

		final Set<Method> usedMethods = new HashSet<Method>();

		PropertyDescriptor[] pdArr;
		if (propertyDescCache.containsKey(clazz)) {
			pdArr = propertyDescCache.get(clazz);
		}
		else {
			try {
				pdArr = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			}
			catch (IntrospectionException e1) {
				pdArr = new PropertyDescriptor[0];
			}
			propertyDescCache.put(clazz, pdArr);
		}
		for (int i = 0; i < pdArr.length; i++) {
			final PropertyDescriptor pd = pdArr[i];
			final Method m = pd.getReadMethod() != null ? pd.getReadMethod() : pd.getWriteMethod();
			if (m != null && clazz.equals(m.getDeclaringClass())) {
				if (pd.getReadMethod() != null)
					usedMethods.add(pd.getReadMethod());
				// Problem: pd.getPropertyType() does not allow to get information about generics. When having a generic collection as property type
				// the property type is just of the collection interface, e.g. java.util.List
				result.add(new JavaPropertyImpl(t, pd.getName(), typeFinder.builtinAwareGetTypeForClass(pd
						.getPropertyType()), pd.getReadMethod(), pd.getWriteMethod()));
			}
		}

		Set<Class<?>> classSet = null;

		if (Modifier.isPublic(clazz.getModifiers())) {
			classSet = Collections.<Class<?>> singleton(clazz);
		}
		else {
			classSet = getSuperClasses(clazz);
		}

		// Methods
		for (final Class<?> c : classSet) {
			final Method[] meths = c.getDeclaredMethods();
			for (int i = 0; i < meths.length; i++) {
				final Method method = meths[i];
				if (Modifier.isPublic(method.getModifiers()) && !usedMethods.contains(method)) {
					// leave the accessor methods in: they don't hurt, and this
					// way we can e.g. call "set" methods
					try {
						// special handling for accessor method for boolean
						// properties, whose return type is
						// the wrapper type 'Boolean' (not 'boolean')
						if (isNonStandardBooleanProperty(method)) {
							handleNonStandardBooleanProperty(typeFinder, t, result, pdArr, method);
						}
						else {
							Type returnType = typeFinder.builtinAwareGetTypeForClass(method.getReturnType());
							result.add(new JavaOperationImpl(t, method.getName(), returnType, createTypes(method
									.getParameterTypes(), typeFinder), method));
						}
					}
					catch (final RuntimeException e) {
						// ignore
					}
				}
			}
		}

		// staticProps
		for (final Class<?> c : classSet) {
			final Field[] fields = c.getFields();
			for (int i = 0; i < fields.length; i++) {
				final Field field = fields[i];
				final int mod = field.getModifiers();
				if (Modifier.isPublic(mod) && Modifier.isStatic(mod) && Modifier.isFinal(mod)) {
					result.add(new JavaStaticPropertyImpl(t, field.getName(), typeFinder
							.builtinAwareGetTypeForClass(field.getType()), field));
				}
			}
		}

		// Java 5 enums
		for (final Class<?> c : classSet) {
			final Object[] enumValues = c.getEnumConstants();
			if (enumValues != null) {
				for (Object o : enumValues) {
					final Enum<?> curEnum = (Enum<?>) o;
					result.add(new StaticPropertyImpl(t, curEnum.name(), t) {
						public Object get() {
							return curEnum;
						}
					});
				}
			}
		}
		return result.toArray(new Feature[result.size()]);
	}

	/**
	 * Tests if this method is a getter for boolean property (beginning with 'is') whose return type is of the wrapper
	 * type 'java.lang.Boolean'. JavaBeans won't recognize this as an accessor method for a property.
	 *
	 * @param method
	 *            The method to check
	 * @return <code>true</code>: the method begins with 'is', the return type is 'java.lang.Boolean' and the method has
	 *         no arguments.
	 */
	private boolean isNonStandardBooleanProperty(final Method method) {
		return method.getName().startsWith("is") && method.getReturnType().getName().equals(Boolean.class.getName())
				&& method.getParameterTypes().length == 0;
	}

	/**
	 * Adds a JavaPropertyImpl to the list of features for properties of type 'java.lang.Boolean', which has a getter
	 * method beginning with 'is'.
	 * <p>
	 * If this non-standard property has a setter method than it was already added as a JavaProperty. But this instance
	 * is immutable, so the original has to be removed and another one be added.
	 *
	 * @param typeFinder
	 *            Helper to resolve the Built-In type 'oaw::Boolean'
	 * @param t
	 *            The type for which the property is defined
	 * @param result
	 *            The original feature list.
	 * @param pdArr
	 *            Property descriptors of the class
	 * @param method
	 *            The method to handle
	 */
	private void handleNonStandardBooleanProperty(final TypeFinder typeFinder, final Type t,
			final List<FeatureImpl> result, final PropertyDescriptor[] pdArr, final Method method) {
		// extract the property name
		String propName = method.getName().substring(2);
		if (propName.length() > 1 && propName.matches("\\p{Upper}\\p{Lower}.*")) {
			propName = StringHelper.firstLower(propName);
		}

		// search the property definition which has the setter method
		JavaPropertyImpl setMethod = null;
		Method writeMethod = null;
		for (FeatureImpl feature : result) {
			if (feature.getName().equals(propName)) {
				setMethod = (JavaPropertyImpl) feature;
				for (PropertyDescriptor pd : pdArr) {
					if (pd.getName().equals(propName)) {
						writeMethod = pd.getWriteMethod();
						break;
					}
				}
				break;
			}
		}
		if (setMethod != null)
			result.remove(setMethod);
		JavaPropertyImpl prop = new JavaPropertyImpl(t, propName,
				typeFinder.builtinAwareGetTypeForClass(Boolean.class), method, writeMethod);
		result.add(prop);
	}

	protected Type[] createTypes(final Class<?>[] parameterTypes, final TypeFinder tf) {
		final Type[] result = new Type[parameterTypes.length];
		for (int i = 0; i < parameterTypes.length; i++) {
			result[i] = tf.builtinAwareGetTypeForClass(parameterTypes[i]);
			if (result[i] == null)
				throw new NullPointerException();
		}
		return result;
	}

	private Set<Class<?>> getSuperClasses(Class<?> clazz) {
		final Set<Class<?>> superClasses = new HashSet<Class<?>>(2);
		final Class<?> superClass = clazz.getSuperclass();
		if (superClass != null) {
			superClasses.add(superClass);
		}

		final Class<?>[] superInterfaces = clazz.getInterfaces();
		if (superInterfaces != null) {
			for (Class<?> i : superInterfaces) {
				superClasses.add(i);
			}
		}
		return superClasses;
	}
}
