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
package com.zeligsoft.ddk.rsm.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized strings for the plug-in.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.ddk.rsm.ui.l10n.messages"; //$NON-NLS-1$

	public static String DDKNewProjectWizard__Error_During_Finish_Title;

	public static String DDKProjectCreator__Failed_to_Create_Project_Error_Message;

	public static String DDKProjectCreator__Failed_to_Load_ZDL_into_ZDLGen_Message;

	public static String DDKProjectCreator__Monitor_Creating_Project_Message;

	public static String DDKProjectCreator__Monitor_Cleaning_ResourceSet_Message;

	public static String DDKProjectCreator__Monitor_Copying_ZDL_Template_Message;

	public static String DDKProjectCreator__Monitor_Creating_ZDLGen_Message;

	public static String DDKProjectCreator__Monitor_Exporting_UML_Message;

	public static String DDKProjectCreator__Monitor_Importing_UML_Message;

	public static String DDKProjectCreator__Monitor_Loading_ZDL_Template_Message;

	public static String DDKProjectCreator__Monitor_Populating_Project_Message;

	public static String DDKProjectCreator__Monitor_Saving_ZDL_Message;

	public static String DDKProjectCreator__Monitor_Saving_ZDLGen_Message;

	public static String DDKProjectCreator__Resource_Save_Failed_Log_Message;

	public static String DefaultProjectCreator__Monitor_Check_Project_Exists_Message;

	public static String DefaultProjectCreator__Monitor_Creating_Physical_Project_Message;

	public static String DefaultProjectCreator__Monitor_Creating_Project_Message;

	public static String DefaultProjectCreator__Monitor_Opening_Project_Message;

	public static String DefaultProjectCreator__Monitor_Refreshing_Project_Message;

	public static String DefaultProjectCreator__Monitor_Setting_Project_Builders_Message;

	public static String DefaultProjectCreator__Monitor_Setting_Project_Location_Message;

	public static String DefaultProjectCreator__Monitor_Setting_Project_Natures_Message;

	public static String SpecifySubsetActionDelegate_errorDlgTitle;

	public static String SpecifySubsetActionDelegate_subsetFailed;

	public static String SpecifySubsetActionDelegate_noSubsetContext;

	public static String SpecifyRedefinitionActionDelegate_errorDlgTitle;

	public static String SpecifyRedefinitionActionDelegate_redefFailed;

	public static String SpecifyRedefinitionActionDelegate_noRedefContext;
	
	public static String SpecifyRedefinitionActionDelegate_incompatibleElements;
	
	public static String ZDLConstantsGenerationActionDelegate_selectionDlgTitle;
	
	public static String ZDLConstantsGenerationActionDelegate_selectionDlgDescription;
	
	public static String ZDLConstantsGenerationActionDelegate_workspaceSearchException;
	
	public static String ZDLConstantsGenerationActionDelegate_multipleMatches;
	
	public static String ZDLConstantsGenerationActionDelegate_namesPackageFilterLabel;
	
	public static String ZDLConstantsGenerationActionDelegate_exception_refreshing_Workspace_resource;	


	public static String ZDLNewProjectMainPage__Domain_Configuration_group_label;

	public static String ZDLNewProjectMainPage__Domain_Name_label;

	public static String ZDLNewProjectMainPage__Gen_Resource_label;

	public static String ZDLNewProjectMainPage__Model_Name_Error_message;

	public static String ZDLNewProjectMainPage__Namespace_URI_label;

	public static String ZDLNewProjectMainPage__Organization_label;

	public static String ZDLNewProjectMainPage__Project_Configuration_group_label;

	public static String ZDLNewProjectMainPage__Project_Name_label;

	public static String ZDLNewProjectMainPage__Resource_Location_group_label;

	public static String ZDLNewProjectMainPage__UML_Resource_label;

	public static String ZDLNewProjectMainPage__Use_Default_Checkbox_label;

	public static String ZDLNewProjectMainPage__ZDL_Resource_label;

	public static String ZDLNewProjectWizard__Wizard_Window_title;

	public static String DefaultProjectCreator__Monitor_Creating_META_INF;


	private Messages() {
		super();
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
