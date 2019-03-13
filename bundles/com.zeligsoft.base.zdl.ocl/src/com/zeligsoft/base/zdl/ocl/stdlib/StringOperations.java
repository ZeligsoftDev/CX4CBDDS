/**
 * Copyright 2018 ADLINK Technology Limited.
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
package com.zeligsoft.base.zdl.ocl.stdlib;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * Implementations of the additional operations contributed to the
 * <tt>String</tt> type by the Zeligsoft OCL environment.
 * 
 * @author Christian W. Damus (Zeligsoft)
 */
class StringOperations {

	@SuppressWarnings("serial")
	private static final Map<String, Pattern> patternCache = new java.util.LinkedHashMap<String, Pattern>(
		16, 0.75f, true) { // 16 and 0.75 are the JDK defaults

		@Override
		protected boolean removeEldestEntry(Entry<String, Pattern> eldest) {
			// cache the 100 most recently used patterns.
			// TODO: adjust this limit based on the number of constraints that
			// use the regex-match operations? The problem is, that the
			// patterns may not be specified in the OCL expressions as constants
			return size() >= 100;
		}
	};

	/**
	 * Cannot be instantiated by clients.
	 */
	private StringOperations() {
		super();
	}

	/**
	 * <p>
	 * Performs a regular expression match. The compiled regex is cached on the
	 * assumption that the constraint will be invoked repeatedly.
	 * </p>
	 * <p>
	 * <b>Note</b> that if either the target string (<tt>self</tt>) or the
	 * <tt>regex</tt> is <code>null</code>, the result is false. A null
	 * string doesn't, conceptually, match any pattern and an absence of a
	 * pattern can't match any string.
	 * </p>
	 * 
	 * @param self
	 *            the string to match against the regex
	 * @param regex
	 *            the regex pattern to match
	 * 
	 * @return whether the string matches the expression, or <code>false</code>
	 *         if either <tt>self</tt> or <tt>regex</tt> is
	 *         <code>null</code>
	 */
	public static boolean matches(String self, String regex) {
		boolean result = false;

		if ((self != null) && (regex != null)) {
			Pattern pattern;

			synchronized (patternCache) {
				pattern = patternCache.get(regex);

				if (pattern == null) {
					patternCache.put(regex, Pattern.compile(regex));
					pattern = patternCache.get(regex); // access ordering
				}
			}

			// TODO: Should we cache the matchers, instead? (requires synch)
			result = pattern.matcher(self).matches();
		}

		return result;
	}

	public static String replaceAll(String self, String regex, String replacement) {
		if( self == null
		 || regex == null
		 || replacement == null )
			return self;
		return self.replaceAll(regex, replacement);
	}
}
