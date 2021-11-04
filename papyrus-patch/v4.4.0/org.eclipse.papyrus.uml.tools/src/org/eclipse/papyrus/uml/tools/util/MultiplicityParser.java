/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.util;

/**
 * A Helper class to helper manipulating UML multiplicities as Strings
 *
 * @author Camille Letavernier
 *
 */
public class MultiplicityParser {

	/**
	 * The 0..* multiplicity (Any)
	 */
	public static final String ANY = "0..*"; //$NON-NLS-1$

	/**
	 * The * multiplicity (Any)
	 * Equivalent to 0..*
	 */
	public static final String STAR = "*"; //$NON-NLS-1$

	/***
	 * The 1 multiplicity (One)
	 */
	public static final String ONE = "1"; //$NON-NLS-1$

	/**
	 * The 0..1 multiplicity (Optional)
	 */
	public static final String OPTIONAL = "0..1"; //$NON-NLS-1$

	/**
	 * The 1..* multiplicity (One or more)
	 */
	public static final String ONE_OR_MORE = "1..*"; //$NON-NLS-1$

	/**
	 * The multiplicity separator (..)
	 */
	public static final String SEPARATOR = ".."; //$NON-NLS-1$

	/**
	 * Parse the multiplicity and returns an array of int values [lower, upper]
	 *
	 * @param value
	 *            A string representing a multiplicity. Example of valid formats: 1, 0..12, 1..*, *
	 * @return
	 * 		null if the string value cannot be parsed
	 */
	public static int[] getBounds(String value) {
		if (value == null) {
			return new int[] { 1, 1 }; // Default multiplicity is 1
		}

		if (!(value instanceof String)) {
			return null;
		}

		String multiplicityValue = value;
		if (!multiplicityValue.matches("([0-9]+\\.\\.)?([1-9][0-9]*|\\*)")) { // ([0-9]+..)?([1-9][0-9]*|\\*)
			return null;
		}

		int lower, upper;

		if (multiplicityValue.equals(ANY) || multiplicityValue.equals(STAR)) {
			lower = 0;
			upper = -1;
		} else if (multiplicityValue.equals(OPTIONAL)) {
			lower = 0;
			upper = 1;
		} else if (multiplicityValue.equals(ONE_OR_MORE)) {
			lower = 1;
			upper = -1;
		} else if (multiplicityValue.equals(ONE)) {
			lower = 1;
			upper = 1;
		} else {
			try {
				if (multiplicityValue.contains(SEPARATOR)) {
					lower = Integer.parseInt(multiplicityValue.substring(0, multiplicityValue.indexOf(SEPARATOR)));
					String upperString = multiplicityValue.substring(multiplicityValue.indexOf(SEPARATOR) + SEPARATOR.length(), multiplicityValue.length());
					if (STAR.equals(upperString)) {
						upper = -1;
					} else {
						upper = Integer.parseInt(upperString);
					}
				} else {
					lower = upper = Integer.parseInt(multiplicityValue);
				}
			} catch (NumberFormatException ex) {
				return null;
			}
		}

		return new int[] { lower, upper };
	}

	public static String getMultiplicity(int lower, int upper) {
		if (lower == 0 && upper == -1) {
			return ANY;
		} else if (lower == 0 && upper == 1) {
			return OPTIONAL;
		} else if (lower == 1 && upper == -1) {
			return ONE_OR_MORE;
		} else if (lower == 1 && upper == 1) {
			return ONE;
		} else if (lower == upper) {
			return Integer.toString(lower);
		} else {
			return lower + SEPARATOR + (upper < 0 ? STAR : upper);
		}
	}

	/**
	 * Tests whether the string value is a valid representation of a UML Multiplicity
	 *
	 * @param value
	 *            A string representing a multiplicity
	 * @return
	 * 		True if the string multiplicity has a valid format
	 */
	public static boolean isValidMultiplicity(String value) {
		int[] lowerUpper = getBounds(value);
		if (lowerUpper == null || lowerUpper.length < 2) {
			return false;
		}

		int lower = lowerUpper[0], upper = lowerUpper[1];
		return isValidMultiplicity(lower, upper);
	}

	public static boolean isValidMultiplicity(int lower, int upper) {
		if (lower < 0) {
			return false;
		}

		if ((upper > 0 && upper < lower) || upper == 0) {
			return false;
		}

		return true;
	}

}
