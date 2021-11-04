/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.profile.definition;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Representation of the version number for a profile
 */
public class Version {

	/** major version number */
	protected int major;

	/** minor version number */
	protected int minor;

	/** micro version number */
	protected int micro;

	/** separator for the version string */
	private final static String SEPARATOR = ".";

	/** The empty version "0.0.0". Equivalent to calling <code>new Version(0,0,0)</code> */
	public static final Version emptyVersion = new Version(0, 0, 0);

	/**
	 * Creates a new Version
	 *
	 * @param major
	 *            the major version value (should be positive)
	 * @param minor
	 *            the minor version value (should be positive)
	 * @param micro
	 *            the micro version value (should be positive)
	 */
	public Version(int major, int minor, int micro) {
		this.major = major;
		this.minor = minor;
		this.micro = micro;
	}

	/**
	 * Creates a new Version, parsing a string value
	 *
	 * @param value
	 *            the string representing the version
	 */
	public Version(String value) throws IllegalArgumentException {
		try {
			StringTokenizer st = new StringTokenizer(value, SEPARATOR, true);
			major = Integer.parseInt(st.nextToken());

			if (st.hasMoreTokens()) {
				st.nextToken(); // consume delimiter
				minor = Integer.parseInt(st.nextToken());

				if (st.hasMoreTokens()) {
					st.nextToken(); // consume delimiter
					micro = Integer.parseInt(st.nextToken());

					if (st.hasMoreTokens()) {
						throw new IllegalArgumentException("invalid format");
					}
				}
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid format");
		}
	}

	/**
	 * Returns the major version number
	 *
	 * @return The major version number
	 */
	public int getMajor() {
		return major;
	}

	/**
	 * Returns the minor version number
	 *
	 * @return The minor version number
	 */
	public int getMinor() {
		return minor;
	}

	/**
	 * Returns the micro version number
	 *
	 * @return The micro version number
	 */
	public int getMicro() {
		return micro;
	}

	/**
	 * Updates the version numbers
	 *
	 * @param major
	 *            the new major value
	 * @param minor
	 *            the new minor value
	 * @param micro
	 *            the new micro value
	 */
	public void updateVersion(int major, int minor, int micro) {
		this.major = major;
		this.minor = minor;
		this.micro = micro;
	}

	// org.osgi.framework.Version
	/**
	 * Creates a version given the specific String
	 *
	 * @param version
	 *            the string to parse
	 * @return the version value corresponding to the String
	 */
	public static Version parseVersion(String version) throws IllegalArgumentException {
		if (version == null) {
			return emptyVersion;
		}

		version = version.trim();
		if (version.length() == 0) {
			return emptyVersion;
		}
		return new Version(version);
	}

	/**
	 * Returns the string corresponding to the version
	 */
	@Override
	public String toString() {
		return major + SEPARATOR + minor + SEPARATOR + micro;
	}
}
