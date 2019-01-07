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
package com.zeligsoft.base.ui.menus.l10;

import org.eclipse.osgi.util.NLS;

/**
 * The localization class for this plug-in.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class Messages 
	extends NLS {

	private static final String BUNDLE_NAME =
		"com.zeligsoft.base.ui.menus.l10.messages"; //$NON-NLS-1$
	public static String JavaDelegate_classAccess = null;
	public static String AddElementActionProvider_AddElementTitle;
	public static String GenericCreateConceptAction_label;
	public static String GenericCreateConceptAction_failed;
	public static String CreateConceptAction_NoLabel_msg;
	public static String DomainSpecificContributionItemProvider_action_label;
	public static String DomainSpecificContributionItemProvider_add_cx_submenu_label;
	public static String ZDLProjectExplorerMenuFactory_ErrorCalculatingConcept_msg;
	public static String JavaDelegate_noBundle;
	public static String JavaDelegate_noSuchClass;
	public static String JavaDelegate_instantiation;
	
	/**
	 * 
	 */
	private Messages() {
		super();
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
}
