/**
 * Copyright 2022 Zeligsoft (2009) Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides some Java reflection utilities to complement those in the Java standard library.
 * 
 * @author Ernesto Posse
 */
public final class JavaReflectionUtil {
	
	/**
	 * Returns a list of all the super-classes of the given class, without the class itself.
	 * 
	 * <p>The list is ordered starting from {@link Object} going down the inheritance chain to the parent class
	 * of the given {@code klass}.
	 * 
	 * @param klass - a {@link Class}
	 * @return A {@link List} of {@link Class}es.
	 */
	public static List<Class<?>> getAllSuperclassesDown(Class<?> klass) {
		List<Class<?>> superClasses = new ArrayList<>();
		if (klass != null && klass != Object.class) {
			Class<?> superClass = klass.getSuperclass();
			if (superClass != null) {
				superClasses.addAll(getAllSuperclassesDown(superClass));
				superClasses.add(superClass);
			}
		}
		return superClasses;
	}
	
	/**
	 * Returns a list of all the super-classes of the given class, without the class itself.
	 * 
	 * <p>The list is ordered starting from the given {@code klass} going up the inheritance chain to {@link Object}.
	 * 
	 * @param klass - a {@link Class}
	 * @return A {@link List} of {@link Class}es.
	 */
	public static List<Class<?>> getAllSuperclassesUp(Class<?> klass) {
		List<Class<?>> superClasses = new ArrayList<>();
		if (klass != null && klass != Object.class) {
			Class<?> superClass = klass.getSuperclass();
			if (superClass != null) {
				superClasses.add(superClass);
				superClasses.addAll(getAllSuperclassesUp(superClass));
			}
		}
		return superClasses;
	}
	
	/**
	 * Returns a set of all the interfaces implemented by the given {@code klass} (which may itself be an interface).
	 * 
	 * <p> The set is ordered, starting with the left-most immediate interface implemented, and follows the 
	 * graph defined by "implements" and "extends" in a depth-first order, so the last elements are interfaces
	 * that do not extend any other interface. The set also includes all interfaces of all its superclasses.
	 * 
	 * @param klass - a {@link Class}
	 * @return A {@link Set} of {@link Class}es.
	 */
	public static Set<Class<?>> getAllInterfaces(Class<?> klass) {
		Set<Class<?>> allInterfaces = new LinkedHashSet<Class<?>>();
		if (klass != null) {
			Class<?> superClass = klass.getSuperclass();
			if (superClass != null) {
				allInterfaces.addAll(getAllInterfaces(superClass));
			}
			Class<?>[] interfaces = klass.getInterfaces();
			if (interfaces != null && interfaces.length > 0) {
				for (Class<?> i : interfaces) {
					allInterfaces.add(i);
					allInterfaces.addAll(getAllInterfaces(i));
				}
			}
		}
		return allInterfaces;
	}

	/**
	 * Returns true if {@code classX} is the same class as class named {@code classYCanonicalName} or 
	 * {@code classX} is a subclass of a class named {@code classYCanonicalName}.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see #isSubclassOf
	 * 
	 * @param classX - a {@link Class}
	 * @param classYCanonicalName - a {@link String}; the *canonical* name of a class.
	 * @return A {@code boolean}
	 */
	public static boolean isEqualOrSubclassOf(Class<?> classX, String classYCanonicalName) {
		return classX.getCanonicalName().equals(classYCanonicalName) 
				|| isSubclassOf(classX, classYCanonicalName);
	}
	
	/**
	 * Returns true if {@code classX} is the same class as class {@code classY} or 
	 * {@code classX} is a subclass of class {@code classY}.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see #isSubclassOf
	 * 
	 * @param classX - a {@link Class}
	 * @param classY - a {@link Class}
	 * @return A {@code boolean}
	 */
	public static boolean isEqualOrSubclassOf(Class<?> classX, Class<?> classY) {
		return classX.getCanonicalName().equals(classY.getCanonicalName()) 
				|| isSubclassOf(classX, classY);
	}
	
	/**
	 * Returns true if {@code classX} is a subclass of class named {@code classYCanonicalName} but not the same class.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #isEqualOrSubclassOf}, {@link #isSubclassOf(Class, Class)}
	 * 
	 * @param classX - a {@link Class}
	 * @param classYCanonicalName - a {@link String}; the *canonical* name of a class.
	 * @return A {@code boolean}
	 */
	public static boolean isSubclassOf(Class<?> classX, String classYCanonicalName) {
		List<Class<?>> allSuperclassesOfX = getAllSuperclassesUp(classX);
		for (Class<?> superClass : allSuperclassesOfX) {
			String superClassCanonicalName = superClass.getCanonicalName();
			if (superClassCanonicalName.equals(classYCanonicalName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if {@code classX} is a subclass of class {@code classY} but not the same class.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #isEqualOrSubclassOf}, {@link #isSubclassOf(Class, String)}
	 * 
	 * @param classX - a {@link Class}
	 * @param classY - a {@link Class}
	 * @return A {@code boolean}
	 */
	public static boolean isSubclassOf(Class<?> classX, Class<?> classY) {
		return isSubclassOf(classX, classY.getCanonicalName());
	}

	/**
	 * Returns true if {@code classOrInterfaceX} is the same interface as interface named {@code interfaceYcanonicalName} or 
	 * {@code classOrInterfaceX} implements interface named {@code interfaceYcanonicalName}.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes/interfaces involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #implementsInterface}
	 * 
	 * @param classOrInterfaceX - a {@link Class}
	 * @param interfaceYcanonicalName - a {@link String} with the canonical name of an interface
	 * @return A {@code boolean}
	 */
	public static boolean isEqualOrImplementsInterface(Class<?> classOrInterfaceX, String interfaceYCanonicalName) {
		return classOrInterfaceX.getCanonicalName().equals(interfaceYCanonicalName) 
				|| implementsInterface(classOrInterfaceX, interfaceYCanonicalName);
	}
	
	/**
	 * Returns true if {@code classOrInterfaceX} is the same interface as interface {@code interfaceY} or 
	 * {@code classOrInterfaceX} implements interface {@code interfaceY}.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes/interfaces involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #implementsInterface}
	 * 
	 * @param classOrInterfaceX - a {@link Class}
	 * @param interfaceY - a {@link Class} such that interfaceY.isInterface() returns {@code true}
	 * @return A {@code boolean}
	 */
	public static boolean isEqualOrImplementsInterface(Class<?> classOrInterfaceX, Class<?> interfaceY) {
		return classOrInterfaceX.getCanonicalName().equals(interfaceY.getCanonicalName()) 
				|| implementsInterface(classOrInterfaceX, interfaceY);
	}
	
	/**
	 * Returns true if {@code classOrInterfaceX} implements interface named {@code interfaceYCanonicalName} but is not the same.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes/interfaces involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #implementsInterface}
	 * 
	 * @param classOrInterfaceX - a {@link Class}
	 * @param interfaceYCanonicalName - a {@link String} with the canonical name of an interface
	 * @return A {@code boolean}
	 */
	public static boolean implementsInterface(Class<?> classOrInterfaceX, String interfaceYCanonicalName) {
		Set<Class<?>> allInterfacesOfX = getAllInterfaces(classOrInterfaceX);
		for (Class<?> interfaceOfX : allInterfacesOfX) {
			String interfaceOfXCanonicalName = interfaceOfX.getCanonicalName();
			if (interfaceOfXCanonicalName.equals(interfaceYCanonicalName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if {@code classOrInterfaceX} implements interface {@code interfaceY} but is not the same.
	 * 
	 * <p>The test is performed by comparing the canonical names of the classes/interfaces involved, so it would return
	 * true even if the classes where loaded by different {@link ClassLoader}s.
	 * 
	 * @see {@link #implementsInterface}
	 * 
	 * @param classOrInterfaceX - a {@link Class}
	 * @param classY - a {@link Class} such that interfaceY.isInterface() returns {@code true}
	 * @return A {@code boolean}
	 */
	public static boolean implementsInterface(Class<?> classOrInterfaceX, Class<?> interfaceY) {
		if (!interfaceY.isInterface()) {
			return false;
		}
		return implementsInterface(classOrInterfaceX, interfaceY.getCanonicalName());
	}

}
