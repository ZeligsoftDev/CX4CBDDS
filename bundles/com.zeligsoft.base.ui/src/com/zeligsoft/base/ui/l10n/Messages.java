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
package com.zeligsoft.base.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localizable strings for the Zeligsoft Base UI plug-in.
 *
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.base.ui.l10n.messages"; //$NON-NLS-1$

	public static String RootPreferencePage_labelSeeNested;

	public static String GenericPaletteCreationTool_label;

	public static String AddZDLFailed_error;
	
	public static String ShowInProjectExplorer_ErrorMsg;
	
	public static String CommandLabel_PaletteEditHelperAdvice_getAfterCreateCommand;

	public static String PreferencePageValidStringListener_InvalidStringError;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
