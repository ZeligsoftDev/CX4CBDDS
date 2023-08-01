/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.views.modelexplorer.messages"; //$NON-NLS-1$
	/**
	 * @since 3.0
	 */
	public static String ExpandPreferencesGroup_ExpandGroupLabel;
	/**
	 * @since 3.0
	 */
	public static String ExpandPreferencesGroup_ExpandGroupTooltip;
	/**
	 * @since 3.0
	 */
	public static String ExpandPreferencesGroup_MaxLevelLabel;
	/**
	 * @since 3.0
	 */
	public static String FilterFieldPreferencesGroup_groupTitle;
	/**
	 * @since 3.0
	 */
	public static String FilterFieldPreferencesGroup_replaceDelimiterLabel;
	/**
	 * @since 3.0
	 */
	public static String FilterFieldPreferencesGroup_UseValidationPreferenceLabel;
	/**
	 * @since 3.0
	 */
	public static String FilterFieldPreferencesGroup_ValidationDelayPreferenceLabel;
	/**
	 * @since 3.0
	 */
	public static String ModelExplorerView_CaseSensitiveCheckBoxLabel;
	/**
	 * @since 3.0
	 */
	public static String ModelExplorerView_CaseSensitiveCheckBoxTooltip;
	/**
	 * @since 3.0
	 */
	public static String ModelExplorerView_SearchTextFieldTooltip;
	/**
	 * @since 3.0
	 */
	public static String MoDiscoLabelProvider_ProxyLabel;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
