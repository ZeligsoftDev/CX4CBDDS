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
package org.eclipse.internal.xtend.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.NumberFormat;

/**
 * This class is a collection of helper functions for string handling.
 * 
 * @author Arno Haase
 */
public class StringHelper {
	private static final NumberFormat _numFormat = NumberFormat.getNumberInstance();

	/**
	 * formats a number using the default locale settings.
	 */
	public static String prettyPrint(final long num) {
		return _numFormat.format(num);
	}

	/**
	 * formats a number using the default locale settings.
	 */
	public static String prettyPrint(final Number num) {
		return _numFormat.format(num);
	}

	/**
	 * formats a date using the default locale settings.
	 */
	public static String prettyPrint(final Date date) {
		return DateFormat.getDateTimeInstance().format(date);
	}

	/**
	 * returns a new string in which one search string is replaced by another.
	 */
	public static String replace(final String src, final String search, final String replace) {
		if (src == null) {
			return src;
		}
		if ((search == null) || (search.length() == 0)) {
			throw new IllegalArgumentException("Search string must not be empty");
		}

		String result = src;
		int ind = 0;
		while ((ind = result.indexOf(search, ind)) >= 0) {
			result = result.substring(0, ind) + replace + result.substring(ind + search.length());
			ind += replace.length();
		}

		return result;
	}

	/**
	 * replaces special characters that affect formatting with non-formatting character sequences.
	 * <ul>
	 * <li>\ -> \\
	 * <li>&lt;tab&gt; -> \t
	 * <li>&lt;CR&gt; -> \r
	 * <li>&lt;Newline&gt; -> \n
	 * </ul>
	 */
	public static String escape(final String src) {
		String result = replace(src, "\\", "\\\\");
		result = replace(result, "\t", "\\t");
		result = replace(result, "\r", "\\r");
		result = replace(result, "\n", "\\n");
		result = replace(result, "\"", "\\\"");

		return result;
	}

	/**
	 * undoes the operations of <code>escape</code>
	 */
	public static String unescape(final String src) {
		if (src == null) {
			return null;
		}

		final StringBuffer result = new StringBuffer();
		for (int i = 0; i < src.length(); i++) {
			final char curChar = src.charAt(i);

			if (curChar != '\\') {
				result.append(curChar);
				continue;
			}
			// increment i to skip to the character after '\\'
			i++;
			if (i >= src.length()) {
				throw new IllegalArgumentException("String ends with '\\'");
			}

			result.append(unescapeChar(src.charAt(i)));
		}

		return result.toString();
	}

	private static char unescapeChar(final char escapedChar) {
		switch (escapedChar) {
		case '\\':
			return '\\';
		case 'n':
			return '\n';
		case 'r':
			return '\r';
		case 't':
			return '\t';
		case '"':
			return '"';
		}
		throw new IllegalArgumentException("unsupported string format: '\\" + escapedChar + "' is not supported.");
	}

	/**
	 * truncates a string regardless of its length. This method is a workaround for a shortcoming of String.substring (int, int) that is unable to
	 * handle the case where the number of characters would extend beyond the end of the string.
	 */
	public static String truncate(final String str, final int maxLen) {
		if ((str == null) || (str.length() < maxLen)) {
			return str;
		}
		if (maxLen < 0) {
			return "";
		}
		return str.substring(0, maxLen);
	}

	/**
	 * same as String.substring, except that this version handles the case robustly when the index is out of bounds.
	 */
	public static String substring(final String str, final int beginIndex) {
		if (str == null) {
			return null;
		}
		if (beginIndex < 0) {
			return str;
		}
		if (beginIndex >= str.length()) {
			return "";
		}

		return str.substring(beginIndex);
	}

	/**
	 * same as {@link String#substring(int, int)}, except that this version handles the case robustly when one or both of the indexes is out of
	 * bounds.
	 */
	public static String substring(final String str, final int beginIndex, final int endIndex) {
		if (str == null) {
			return null;
		}
		if (beginIndex > endIndex) {
			return "";
		}
		int _beginIndex = beginIndex >= 0 ? beginIndex : 0;
		int _endIndex = endIndex <= str.length() ? endIndex : str.length();

		return str.substring(_beginIndex, _endIndex);
	}

	/**
	 * removes a number of characters from the beginning and the end of a string
	 */
	public static String strip(final String s, final int numStart, final int numEnd) {
		if (s == null) {
			return s;
		}

		return substring(s, numStart, s.length() - numEnd);
	}

	/**
	 * returns the number of occurrences of a character in a string
	 */
	public static int numMatches(final String s, final char ch) {
		if (s == null) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				result++;
			}
		}

		return result;
	}

	/**
	 * returns the number of occurrences of a substring in a string
	 */
	public static int numMatches(final String s, final String search) {
		if ((s == null) || (search == null) || "".equals(s) || "".equals(search)) {
			return 0;
		}

		int result = 0;
		int curIndex = 0;
		while (true) {
			curIndex = s.indexOf(search, curIndex);
			if (curIndex == -1) {
				break;
			}

			curIndex++;
			result++;
		}
		return result;
	}

	/**
	 * tests if a string starts with any one of a collection of prefixes
	 */
	public static boolean startsWithAny(final String str, final Collection<String> prefixes) {
		if (str == null) {
			return false;
		}

		for (String string : prefixes) {
			if (str.startsWith(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * tests if a string starts with any one of a collection of prefixes
	 */
	public static boolean startsWithAny(final String str, final String[] prefixes) {
		if (str == null) {
			return false;
		}

		for (String prefixe : prefixes) {
			if (str.startsWith(prefixe)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * tests if a string ends with any one of a collection of prefixes
	 */
	public static boolean endsWithAny(final String str, final Collection<String> prefixes) {
		if (str == null) {
			return false;
		}

		for (String string : prefixes) {
			if (str.endsWith(string)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * tests if a string ends with any one of a collection of prefixes
	 */
	public static boolean endsWithAny(final String str, final String[] prefixes) {
		if (str == null) {
			return false;
		}

		for (String prefixe : prefixes) {
			if (str.endsWith(prefixe)) {
				return true;
			}
		}
		return false;
	}

	public static String firstUpper(final String str) {
		if (str.length() > 0) {
			return str.substring(0, 1).toUpperCase().concat(str.substring(1));
		}
		return "";
	}

	public static String firstLower(final String str) {
		if (str.length() > 0) {
			return str.substring(0, 1).toLowerCase().concat(str.substring(1));
		}
		return "";
	}

	/**
	 * Splits a string around matches of the given delimiter character.
	 * <p>
	 * This method works similar to {@link String#split(String)} but does not treat the delimiter as a regular expression. This makes it perform
	 * better in most cases where this feature is not necessary. Furthermore this implies that trailing empty segments will not be part of the result.
	 * <p>
	 * Copied from org.eclipse.xtext.util.Strings
	 * 
	 * @param value
	 *            the string to split
	 * @param delimiter
	 *            the delimiting String (e.g. '.' or ':' or '::')
	 * 
	 * @return the list of strings computed by splitting the string around matches of the given delimiter without trailing empty segments. Never
	 *         <code>null</code> and the list does not contain any <code>null</code> values.
	 * 
	 * @throws NullPointerException
	 *             If the {@code value} is {@code null}
	 * @see String#split(String)
	 * @since 1.4
	 */
	public static List<String> split(final String value, final String delimiter) {
		List<String> result = new ArrayList<String>();
		int lastIndex = 0;
		int index = value.indexOf(delimiter, lastIndex);
		int pendingEmptyStrings = 0;
		while (index != -1) {
			String addMe = value.substring(lastIndex, index);
			if (addMe.length() == 0) {
				pendingEmptyStrings++;
			} else {
				while (pendingEmptyStrings > 0) {
					result.add("");
					pendingEmptyStrings--;
				}
				result.add(addMe);
			}
			lastIndex = index + delimiter.length();
			index = value.indexOf(delimiter, lastIndex);
		}
		if (lastIndex != value.length()) {
			while (pendingEmptyStrings > 0) {
				result.add("");
				pendingEmptyStrings--;
			}
			result.add(value.substring(lastIndex));
		}
		return result;
	}

}
