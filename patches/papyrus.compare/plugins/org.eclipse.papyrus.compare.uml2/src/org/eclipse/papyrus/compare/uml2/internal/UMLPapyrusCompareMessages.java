/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Utility class to access externalized Strings for UML Papyrus Compare.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public final class UMLPapyrusCompareMessages {
	/** Full qualified path to the properties file in which to seek the keys. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.compare.uml2.internal.messages"; //$NON-NLS-1$

	/** Contains the locale specific {@link String}s needed by this plug-in. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private UMLPapyrusCompareMessages() {
		// prevents instantiation
	}

	/**
	 * Returns a specified {@link String} from the resource bundle.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @return The String from the resource bundle associated with <code>key</code>.
	 */
	public static String getString(final String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (final MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Returns a String from the resource bundle bound with the given arguments.
	 * 
	 * @param key
	 *            Key of the String we seek.
	 * @param arguments
	 *            Arguments for the String formatting.
	 * @return formatted {@link String}.
	 * @see MessageFormat#format(String, Object[])
	 */
	public static String getString(final String key, final Object... arguments) {
		if (arguments == null) {
			return getString(key);
		}
		return MessageFormat.format(getString(key), arguments);
	}
}
