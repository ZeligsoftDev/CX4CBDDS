/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.rsm.tooling.l10n;

import org.eclipse.osgi.util.NLS;

public class ZDLMessages
		extends NLS {

	private static final String BUNDLE_NAME = ZDLMessages.class.getName();

	private ZDLMessages() {
		// Do not instantiate
	}

	public static String ZDLModelWizard_ModelWizardPageTitle;

	public static String ZDLModelWizard_ZDLDefaultModelName;

	public static String ZDLModelWizard_ModelWizardPageDescription;

	public static String ZeligsoftModelWizard_ProjectTitle;

	public static String ZeligsoftModelWizard_ProjectPageDescription;

	public static String ZDLModelWizard_ModelWizardWindowTitle;

	public static String ZeligsoftModelWizardContentCreator_ModelOpenFailedLog;

	public static String ZeligsoftModelWizardContentCreator_ProjectCreateionFailedLog;

	public static String ZeligsoftModelWizardContentCreator_ResourceSaveFailedLog;

	public static String ZeligsoftModelWizardContentCreator_ZeligsoftDefaultProjectName;

	public static String ZeligsoftModelWizardPage_BrowseButtonLabel;

	public static String ZeligsoftModelWizardPage_DestinationFolderLabel;

	public static String ZeligsoftModelWizardPage_BrowseFolderDialogDescriptionLabel;

	public static String ZeligsoftModelWizardPage_FolderErrorMessage;

	public static String ZeligsoftModelWizardPage_ModelNameErrorMessage;

	public static String ZeligsoftModelWizardPage_ModelNameLabel;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ZDLMessages.class);
	}
}