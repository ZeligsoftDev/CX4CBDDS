/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.internal.xtend.util;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;

/**
 * A cache for Strings which allows that its values might by garbage collected.
 */
public class StringCache {
	private static final WeakCache2<String, String> cache = new WeakCache2<String, String>();

	private static final String[] SHORT_STRINGS = new String[128];
	static {
		char[] chars = new char[128];
		for (char c = 0; c < 128; ++c) {
			chars[c] = c;
		}
		String string = new String(chars);
		for (char c = 0; c < 128; ++c) {
			SHORT_STRINGS[c] = string.substring(c, c + 1);
		}
	}

	/**
	 * Retrieves a String value from the cache.
	 * 
	 * @param s
	 *            A string
	 * @param createNew
	 *            If <code>true</code> the string will be put into the cache if it was not cached before.
	 * @return The cached instance, or <code>s</code> when it was not cached before.
	 */
	public static String getx(final String s, final boolean createNew) {
		if (SyntaxConstants.NS_DELIM.equals(s)) {
			return SyntaxConstants.NS_DELIM;
		}
		if (s.length() == 1) {
			char c = s.charAt(0);
			if (c < 128) {
				return SHORT_STRINGS[c];
			}
		}
		String result = cache.get(s);
		if (result == null) {
			result = s;
			if (createNew) {
				putx(s);
			}
		}
		return result;
	}

	private static final WeakInterningHashSet<String> CACHE = new WeakInterningHashSet<String>();

	public static String get(final String s) {
		return CACHE.intern(s);
	}

	public static void putx(final String s) {
		// key must be a new instance, otherwise the WeakReference cannot be released, since the instance
		// is referenced as key
		cache.put(new String(s), s);
	}

}
