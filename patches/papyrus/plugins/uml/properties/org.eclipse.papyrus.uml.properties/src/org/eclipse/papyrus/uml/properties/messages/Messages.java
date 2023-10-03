/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.properties.messages.messages"; //$NON-NLS-1$

	/**
	 * @since 3.1
	 */
	public static String EObjectContentsEditor_CreateElement;

	/**
	 * @since 3.1
	 */
	public static String EObjectContentsEditor_UnsetValue;

	public static String ExpressionLanguageFactory_EditLanguage;

	public static String ExpressionLanguageFactory_LanguageDuplicateError;

	public static String ExpressionLanguageFactory_SetNewLanguage;

	public static String UMLNotationModelElement_DepthFull;

	public static String UMLNotationModelElement_DepthNone;

	public static String ExpressionEditor_BodyLabel;

	public static String ImportedPackageLocationObservableValue_Unknown;

	public static String ProfileApplicationEditor_ApplyProfile;

	public static String ProfileApplicationEditor_ApplyProfilesDialogDescription;

	public static String ProfileApplicationEditor_ApplyProfilesDialogTitle;

	public static String ProfileApplicationEditor_ApplyRegisteredProfile;

	public static String ProfileApplicationEditor_WaitMessage;

	public static String ProfileApplicationEditor_WaitMessageTitle;
	
	public static String ProfileExplorerDialog_Message;

	public static String ProfileExplorerDialog_Title;
	/** The multiplicity Editor string text label. */
	public static String MultiplicityPreference_MultiplicityEditor;
	
	/** The simple mode description. */
	public static String MultiplicityPreference_SimpleModeDescription;
	
	/** The advanced mode description. */
	public static String MultiplicityPreference_AdvancedModeDescription;
	
	/** The multiplicity Editor string text label. */
	public static String MultiplicityPreference_fieldEditorMode;

	public static String StereotypeExplorerDialog_Message;

	public static String StereotypeExplorerDialog_OnlyApplicableStereotypesLabel;

	public static String StereotypeExplorerDialog_PluginContributionSeparatorLabel;

	public static String StereotypeExplorerDialog_Title;

	public static String StereotypeExplorerDialog_WokspaceContributionSeparator;

	public static String StereotypeQualifyNameValueEditor_browseStereotypeButtonLabel;

	public static String StereotypeQualifyNameValueEditor_ReturnErrorMessage;
	
	public static String ProfileTabPreferencePage_NumberOfCharToKeep;

	public static String ProfileTabPreferencePage_ShowTheValueOfTheStereotypeProperties;

	public static String ProfileTabPreferencePage_TruncateLabel;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
