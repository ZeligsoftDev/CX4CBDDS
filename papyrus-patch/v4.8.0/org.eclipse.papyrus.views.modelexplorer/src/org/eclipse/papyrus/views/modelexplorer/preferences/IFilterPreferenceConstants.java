/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.preferences;

/**
 * Interface to define preference constants for the filter field.
 * @since 3.0
 */
public interface IFilterPreferenceConstants {

	/** The preference if the filter is in live validation. */
	public static final String PREF_FILTER_LIVE_VALIDATION = "liveValidation"; //$NON-NLS-1$

	/** The preference of the delay of live validation. */
	public static final String PREF_FILTER_VALIDATION_DELAY = "validateDelay"; //$NON-NLS-1$

	/** The preference if the filter is in live validation. */
	public static final String PREF_FILTER_STEREOTYPE_REPLACED = "replaceStrereotypeDelimiter"; //$NON-NLS-1$

	/** the default value for validation delay. */
	public static final int DEFAULT_VALIDATION_DELAY_VALUE = 600;

	/** the default value for the use of live validation in filter. */
	public static final boolean DEFAULT_FILTER_LIVE_VALIDATION_VALUE = true;

	/** the default value for the replacement of stereotype delimiters. */
	public static final boolean DEFAULT_FILTER_STEREOTYPE_REPLACED_VALUE = true;

	/**
	 * The left stereotype delimiter
	 */
	public static final String ST_LEFT = "\u00AB";//$NON-NLS-1$

	/**
	 * The right stereotype delimiter
	 */
	public static final String ST_RIGHT = "\u00BB";//$NON-NLS-1$
	
	/**
	 * The right stereotype delimiter to be replaced in Text
	 */
	public static final String ST_RIGHT_BEFORE = ">>";//$NON-NLS-1$

	/**
	 * The left stereotype delimiter to be replaced in fields
	 */
	public static final String ST_LEFT_BEFORE = "<<";//$NON-NLS-1$

}
