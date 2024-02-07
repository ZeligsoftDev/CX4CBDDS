/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.osgi.util.NLS;


public class StringUtil
{
	private static final String maxIntValue = Integer.toString(Integer.MAX_VALUE);
	private static final int maxIntSize = maxIntValue.length();
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();

	/**
	 * Table mapping the four bits of a nibble to the corresponding uppercase hex ASCII character.
	 */
	private static final char[] nibble2uchex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * @since 1.13
	 */
	public static @NonNull String defaultIndentation = "    ";

	/**
	 * @since 1.13
	 */
	public static void appendIndentation(@NonNull StringBuilder s, int depth) {
		appendIndentation(s, depth, defaultIndentation);
	}
	/**
	 * @since 1.13
	 */
	public static void appendIndentation(@NonNull StringBuilder s, int depth, @NonNull String string) {
		if (depth >= 0) {
			s.append("\n");
		}
		for (int i = 0; i < depth; i++) {
			s.append(string);
		}
	}

	/**
	 * Append a multiplicity string such as "[1..5]" to a StringBuilder.
	 * <br>
	 * Shortforms such as "[?]",  "[+]",  "[*]",  "[1]",  "[2..*]" are used if possible.
	 * <br>
	 * A -ve upper signals unlimited.
	 */
	public static void appendMultiplicity(@NonNull StringBuilder s, long lower, long upper, boolean isNullFree) {
		s.append("[");
		if (upper < 0) {
			if (lower == 1) {
				s.append("+");
			}
			else {
				if (lower != 0) {
					s.append(lower);
					s.append("..");
				}
				s.append("*");
			}
		}
		else if ((lower == 0) && (upper == 1)) {
			s.append("?");
		}
		else {
			s.append(lower);
			if (lower != upper) {
				s.append("..");
				s.append(upper);
			}
		}
		s.append("|");
		s.append(isNullFree ? "1" : "?");
		s.append("]");
	}
	/**
	 * @deprecated add isNullFree argument
	 */
	@Deprecated
	public static void appendMultiplicity(@NonNull StringBuilder s, long lower, long upper) {
		appendMultiplicity(s, lower, upper, false);
	}

	public static @NonNull String bind(String messageTemplate, Object... bindings) {
		@SuppressWarnings("null") @NonNull String result = NLS.bind(messageTemplate, bindings);
		return result;
	}

	/**
	 * Return the decoding of oclString as a sequence of Unicode characters. THe surrounding quotes
	 * should have been removed from oclString by the caller. This inverts the convertToOCLSTring method.
	 * Return oclSting if there are no encoded characters.
	 */
	public static @NonNull String convertFromOCLString(@NonNull String oclString) {
		StringBuilder s = null;					// Lazily created if encoding actually necessary.
		int iMax = oclString.length();
		for (int i = 0; i < iMax; i++) {
			char c = oclString.charAt(i);
			if (c == '\\') {
				if (s == null) {
					s = new StringBuilder(iMax);
					s.append(oclString, 0, i);	// Seed the lazy buffer with the characters so far.
				}
				int iStart = i;
				if (++i < iMax) {
					c = oclString.charAt(i);
					switch (c) {
						case 't': s.append('\t'); break;
						case 'n': s.append('\n'); break;
						case 'r': s.append('\r'); break;
						case 'f': s.append('\f'); break;
						case 'b': s.append('\b'); break;
						case 'u': {
							if (i+4 < iMax) {
								int value = 0;
								for (int j = 0; j < 4; j++) {
									c = oclString.charAt(++i);
									if (('0' <= c) && (c <= '9')) {
										value = (16 * value) + c - '0';
									}
									else if (('A' <= c) && (c <= 'F')) {
										value = (16 * value) + c - 'A' + 10;
									}
									else if (('a' <= c) && (c <= 'f')) {
										value = (16 * value) + c - 'a' + 10;
									}
									else {
										throw new IllegalArgumentException("Malformed Unicode escape: " + oclString.substring(iStart, i+1 - iStart) + ".");
									}
								}
								s.append((char)value);
							}
							break;
						}
						default:					// Any other character, especially quotes, backslash are de-escaped.
							s.append(c);
					}
				}
			}
			else if (s != null) {
				s.append(c);
			}
		}
		return s != null ? s.toString() : oclString;
	}

	/**
	 * Return the encoding of theString that once surrounded by single quotes is a valid OCL string.
	 * Returns null for a null theString. Returns theString if no-encoding necessary.
	 */
	public static String convertToOCLString(String theString) {
		if (theString == null) {
			return null;
		}
		StringBuilder s = null;				// Lazily created if encoding actually necessary.
		int iMax = theString.length();
		for (int i = 0; i < iMax; i++) {
			char c = theString.charAt(i);
			switch (c) {
				case '\t': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\t"); break;
				case '\n': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\n"); break;
				case '\r': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\r"); break;
				case '\f': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\f"); break;
				case '\b': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\b"); break;
				case '\'': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\\'"); break;
				case '\\': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\\\"); break;
				//				case '"': s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\\""); break;
				default:
					if (((c < 0x0020) || (c > 0x007e))) {
						s = convertToOCLStringLazyStringBuilder(s, theString, i, "\\u");
						s.append(nibble2uchex[(c >> 12) & 0xF]);
						s.append(nibble2uchex[(c >> 8) & 0xF]);
						s.append(nibble2uchex[(c >> 4) & 0xF]);
						s.append(nibble2uchex[c & 0xF]);
					} else if (s != null) {
						s.append(c);
					}
			}
		}
		return s != null ? s.toString() : theString;
	}

	private static @NonNull StringBuilder convertToOCLStringLazyStringBuilder(@Nullable StringBuilder s, @NonNull String theString, int theIndex, @NonNull String suffix) {
		if (s == null) {
			int length = theString.length();
			length += 1 + length / 10;			// Guess at 10% excess encoded characters
			if (length < 0) {
				s = new StringBuilder();		// In the unlikely event of a numeric wraparound use simple growth.
			}
			else {
				s = new StringBuilder(length);
			}
			s.append(theString, 0, theIndex);	// Seed the lazy buffer with the characters so far.
		}
		s.append(suffix);
		return s;
	}

	public static @NonNull Number createNumberFromString(@NonNull String aValue) throws NumberFormatException {
		if ("*".equals(aValue)) {
			return Unlimited.INSTANCE;
		}
		int len = aValue.length();
		if ((len < maxIntSize) || ((len == maxIntSize) && (maxIntValue.compareTo(aValue) >= 0))) {
			Integer result = Integer.valueOf(aValue);
			assert result != null;
			return result;
		}
		else if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
			Long result = Long.valueOf(aValue);
			assert result != null;
			return result;
		}
		else {
			return new BigInteger(aValue);
		}
	}

	public static @NonNull String formatMultiplicity(@Nullable ETypedElement typedElement) {
		if (typedElement == null)
			return "";
		int lower = typedElement.getLowerBound();
		int upper = typedElement.getUpperBound();
		if (lower == upper)
			return "" + Integer.toString(lower);
		else if (lower == 0) {
			if (upper < 0)
				return "*";
			else if (upper == 1)
				return "?";
		}
		else if (lower == 1) {
			if (upper < 0)
				return "+";
		}
		return Integer.toString(lower) + ".." + (upper >= 0 ? Integer.toString(upper) : "*");
	}

	public static @NonNull String formatOrdered(@Nullable ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isOrdered() && typedElement.isMany()) : false;
		return isOrdered ? "{ordered}" : "";
	}

	public static@NonNull  String formatString(@Nullable String name) {
		return name != null ? name : "<null>";
	}

	public static @NonNull String formatUnique(@Nullable ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isUnique() && typedElement.isMany()) : false;
		return isOrdered ? "{unique}" : "";
	}

	public static String getIndentation(int depth, @NonNull String string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			s.append(string);
		}
		return s.toString();
	}

	/**
	 * Return a composite string comprising each element od strings separated by separator.
	 * A null strings is returned as a null string. An empty strings as an empty string.
	 *
	 * @param strings strings to be spliced
	 * @param separator between elements
	 * @return spliced string
	 */
	public static String splice(List<String> strings, String separator) {
		if (strings == null)
			return null;
		int iMax = strings.size();
		if (iMax <= 0)
			return "";
		if (iMax == 1)
			return strings.get(0);
		StringBuilder s = new StringBuilder();
		s.append(strings.get(0));
		for (int i = 1; i < iMax; i++) {
			s.append(separator);
			s.append(strings.get(i));
		}
		return s.toString();
	}

	/**
	 * Return the uppercase hex ASCII character for the least significant 4 bits of value.
	 */
	@Deprecated /* @deprecated this routine is no longer used */
	public static char toHex(int value) {
		int nibble = value & 0xF;
		return nibble2uchex[nibble];
	}
}
