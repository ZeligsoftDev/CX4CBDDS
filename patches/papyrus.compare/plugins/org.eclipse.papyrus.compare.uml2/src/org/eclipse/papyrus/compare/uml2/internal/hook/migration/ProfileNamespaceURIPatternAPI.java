/*******************************************************************************
 * Copyright (c) 2016, 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *     Martin Fleck - bug 515041
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class is a reflective facade for the ProfileNamespaceURIPattern API provided in Papyrus for profile
 * migration. In order to also support the automatic profile migration in EMF Compare for Eclipse Luna and
 * upwards and to allow the code to compile, we need to call the Papyrus API reflectively.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public final class ProfileNamespaceURIPatternAPI {
	/**
	 * Fully qualified name of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static final String REGISTRY_CLASS = "org.eclipse.papyrus.uml.modelrepair.internal.uripattern.ProfileNamespaceURIPatternRegistry"; //$NON-NLS-1$

	/**
	 * Name of the instance field of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static final String REGISTRY_FIELD_INSTANCE = "INSTANCE"; //$NON-NLS-1$

	/**
	 * Name of the register method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static final String REGISTRY_METHOD_REGISTER = "register"; //$NON-NLS-1$

	/**
	 * Name of the unregister method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static final String REGISTRY_METHOD_UNREGISTER = "unregister"; //$NON-NLS-1$

	/**
	 * Name of the tryFindComparison method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static final String REGISTRY_METHOD_TRY_FIND_COMPARISON = "tryFindComparison"; //$NON-NLS-1$

	/**
	 * Fully qualified name of the ProfileNamespaceURIPattern class.
	 */
	private static final String PATTERN_CLASS = "org.eclipse.papyrus.uml.modelrepair.internal.uripattern.ProfileNamespaceURIPattern"; //$NON-NLS-1$

	/**
	 * Fully qualified name of the ProfileNamespaceURIPatternComparison class.
	 */
	private static final String COMPARISON_CLASS = "org.eclipse.papyrus.uml.modelrepair.internal.uripattern.ProfileNamespaceURIPatternComparison"; //$NON-NLS-1$

	/**
	 * Name of the isEqualVersionlessNamespaceURI method of the ProfileNamespaceURIPatternComparison class.
	 */
	private static final String COMPARISON_METHOD_IS_EQUAL_VERSIONLESS_NAMESPACE_URI = "isEqualVersionlessNamespaceURI"; //$NON-NLS-1$

	/**
	 * Name of the isPresent method of the Optional class from Guava.
	 */
	private static final String OPTIONAL_METHOD_IS_PRESENT = "isPresent"; //$NON-NLS-1$

	/**
	 * Name of the get method of the Optional class from Guava.
	 */
	private static final String OPTIONAL_METHOD_GET = "get"; //$NON-NLS-1$

	/**
	 * ProfileNamespaceURIPatternRegistry singleton instance.
	 */
	private static Object registryInstance;

	/**
	 * Register method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static Method registryRegisterMethod;

	/**
	 * Unregister method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static Method registryUnregisterMethod;

	/**
	 * TryFindComparison method of the ProfileNamespaceURIPatternRegistry class.
	 */
	private static Method registryTryFindComparisonMethod;

	/**
	 * ProfileNamespaceURIPattern class.
	 */
	private static Class<?> patternClass;

	/**
	 * IsEqualVersionlessNamespaceURI method of the ProfileNamespaceURIPatternComparison class.
	 */
	private static Method comparisonIsEqualVersionlessNamespaceURIMethod;

	static {
		try {
			final Class<?> registryClass = Class.forName(REGISTRY_CLASS);
			patternClass = Class.forName(PATTERN_CLASS);
			final Class<?> comparisonClass = Class.forName(COMPARISON_CLASS);

			final Field registryInstanceField = registryClass.getField(REGISTRY_FIELD_INSTANCE);
			registryInstance = registryInstanceField.get(null);
			registryTryFindComparisonMethod = registryClass.getMethod(REGISTRY_METHOD_TRY_FIND_COMPARISON,
					String.class, String.class);

			registryRegisterMethod = registryClass.getMethod(REGISTRY_METHOD_REGISTER, patternClass);
			registryUnregisterMethod = registryClass.getMethod(REGISTRY_METHOD_UNREGISTER, patternClass);

			comparisonIsEqualVersionlessNamespaceURIMethod = comparisonClass
					.getMethod(COMPARISON_METHOD_IS_EQUAL_VERSIONLESS_NAMESPACE_URI);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException | NoSuchMethodException e) {
			// do nothing
		}
	}

	/**
	 * Hide default constructor in utility class.
	 */
	private ProfileNamespaceURIPatternAPI() {
	}

	/**
	 * Silently failing method for calling a method. Any exception thrown through the invocation of the method
	 * are silently ignored.
	 * 
	 * @param method
	 *            the method to be invoked
	 * @param object
	 *            the object the underlying method is invoked from
	 * @param args
	 *            the arguments used for the method call
	 * @return result of the method call or null if the method invocation has failed
	 */
	protected static Object callMethod(Method method, Object object, Object... args) {
		try {
			return method.invoke(object, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// do nothing
		}
		return null;
	}

	/**
	 * Returns true if the ProfileNamespaceURIPattern API is available, false otherwise.
	 * 
	 * @return true if the ProfileNamespaceURIPattern API is available, false otherwise.
	 */
	public static boolean isAvailable() {
		// check if last assigned field is available
		return comparisonIsEqualVersionlessNamespaceURIMethod != null;
	}

	/**
	 * Reflectively creates a new profile namespace URI pattern with the given namespace URI pattern. The URI
	 * pattern is a Regex that can split namespace URIs into the profile-identifying part (without version)
	 * and the versioning part. The created pattern uses the default versioning formatting producing a
	 * comma-separated version string.
	 *
	 * @param pattern
	 *            pattern used to split the namespace URI
	 * @return newly created pattern object or null if the API is not available
	 */
	public static Object createPattern(String pattern) {
		if (!isAvailable()) {
			return null; // avoid error preemptively
		}
		Object patternObject = null;
		try {
			Constructor<?> patternConstructor = patternClass.getConstructor(String.class);
			patternObject = patternConstructor.newInstance(pattern);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// do nothing
		}
		return patternObject;
	}

	/**
	 * Reflectively adds the provided profile namespace URI pattern to the registry.
	 *
	 * @param profileNamespaceURIPattern
	 *            pattern to be registered
	 */
	public static void registerPattern(Object profileNamespaceURIPattern) {
		if (!isAvailable() || profileNamespaceURIPattern == null) {
			return; // avoid error preemptively
		}
		callMethod(registryRegisterMethod, registryInstance, profileNamespaceURIPattern);
	}

	/**
	 * Reflectively removes the given profile namespace URI patterns from the registry. If the pattern can not
	 * be found, the registry remains unchanged.
	 *
	 * @param profileNamespaceURIPattern
	 *            pattern to be unregistered, if present
	 */
	public static void unregisterPattern(Object profileNamespaceURIPattern) {
		if (!isAvailable() || profileNamespaceURIPattern == null) {
			return; // avoid error preemptively
		}
		callMethod(registryUnregisterMethod, registryInstance, profileNamespaceURIPattern);
	}

	/**
	 * Reflectively uses the Profile Namespace URI Pattern mechanism to determine whether the two provided
	 * namespace URIs are the same not considering versioning information in the URI. This method only returns
	 * true if both URIs match a pattern and their comparison is valid.
	 * 
	 * @param lhsNamespaceUri
	 *            left-hand side namespace URI of the comparison
	 * @param rhsNamespaceUri
	 *            right-hand side namespace URI of the comparison
	 * @return true if the two namespace URIs can be compared and refer to the same versionless URI, false
	 *         otherwise
	 */
	public static boolean isEqualVersionlessNamespaceURI(String lhsNamespaceUri, String rhsNamespaceUri) {
		if (!isAvailable()) {
			return false; // avoid error preemptively
		}
		Object optionalComparison = callMethod(registryTryFindComparisonMethod, registryInstance,
				lhsNamespaceUri, rhsNamespaceUri);
		if (optionalComparison == null) {
			return false;
		}
		// use reflection to query result due to potentially incompatible Guava versions, cf. bug 515041
		try {
			Method isPresentMethod = optionalComparison.getClass().getMethod(OPTIONAL_METHOD_IS_PRESENT);
			isPresentMethod.setAccessible(true);
			Object isPresent = isPresentMethod.invoke(optionalComparison);
			if (isPresent != null && Boolean.parseBoolean(isPresent.toString())) {
				Method getMethod = optionalComparison.getClass().getMethod(OPTIONAL_METHOD_GET);
				getMethod.setAccessible(true);
				Object comparison = getMethod.invoke(optionalComparison);
				if (comparison != null) {
					Object isEqual = callMethod(comparisonIsEqualVersionlessNamespaceURIMethod, comparison);
					return isEqual != null && new Boolean(isEqual.toString()).booleanValue();
				}
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// do nothing
		}
		return false;
	}

}
