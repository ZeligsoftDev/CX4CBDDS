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

package com.zeligsoft.cx.deployment.treeeditor.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * NLS Implementation for Deployment messages
 * @author ysroh
 *
 */
public class DeploymentEditorMessages extends NLS
{
	private static final String BUNDLE_NAME = "com.zeligsoft.cx.deployment.treeeditor.l10n.messages"; //$NON-NLS-1$

	public static String DeleteDeploymentPartActionHandler_DeletePartCmd;
	public static String DeleteDeploymentPartActionHandler_DeletePartErrorTitle;
	public static String DeleteDeploymentPartActionHandler_DeletePartErrorMsg;
	
	public static String DeploymentCreationPopupAction_OpenEditorErrorTitle;
	public static String DeploymentCreationPopupAction_OpenEditorErrorMsg;
	
	public static String DeploymentFormPage_LeftTitle;
	public static String DeploymentFormPage_RightTitle;
	
	public static String DeploymentFormPage_DeleteDlg;
	public static String DeploymentFormPage_ExpandAllDlg;
	public static String DeploymentFormPage_RemoveDlg;	
	public static String DeploymentFormPage_UndeployDlg;
	public static String DeploymentFormPage_ZeligsoftGenDlg;
	public static String DeploymentFormPage_ShowInMenu_text;
	
	public static String ShowInDeployPaneAction_ShowInDeployPaneActionLabel;

	public static String ShowInProjectExplorerAction_text;

	public static String DeploymentTreeGlobalOpenActionHandler_OpenDeploymentEditorActionLabel;
	public static String DeploymentTreeGlobalOpenActionHandler_OpenDeploymentEditorCommandLabel;

	public static String DeploymentTreeGlobalOpenActionHandler_OpeningEditorErrorTitle;
	public static String DeploymentTreeGlobalOpenActionHandler_OpeningEditorErrorMessage;
	
	public static String LeftTreeContentProvider_ReadingFromModelErrorTitle;
	public static String LeftTreeContentProvider_ReadingFromModelErrorMsg;
	
	public static String LeftTreeListener_AddComponentCmd;
	public static String LeftTreeListener_AddingPartErrorTitle;
	public static String LeftTreeListener_AddingPartErrorMsg;
	public static String LeftTreeListener_SelectStructuralRealizationDlg;
	
	public static String RemoveFromDeployPaneActionHandler_UndeployErrorTitle;
	public static String RemoveFromDeployPaneActionHandler_UndeployErrorMsg;
	
	public static String RightTreeContentProvider_ReadingFromModelErrorTitle;
	public static String RightTreeContentProvider_ReadingFromModelErrorMsg;
	
	public static String RightTreeListener_AllocationErrorTitle;
	public static String RightTreeListener_AllocationErrorMessage;	

	public static String RightTreeListener_DeployCmd;		
	
	public static String RightTreeListener_DeploymentCycleErrorTitle;
	public static String RightTreeListener_DeploymentCycleErrorMsg;
	public static String RightTreeListener_DeploymentCycleErrorReason;
	
	public static String RightTreeListener_InvalidRedeployErrorTitle;
	public static String RightTreeListener_InvalidRedeployErrorMsg;
	public static String RightTreeListener_InvalidRedeployErrorReason;
	
	public static String RightTreeListener_RedeployCmd;
	
	public static String DeploymentView_UndeployCmd;
	
	public static String UndeployActionHandler_UndeployErrorTitle;
	public static String UndeployActionHandler_UndeployErrorMsg;
	
	public static String DeploymentTreeEditor_DeploymentPageFailedLog;
	public static String DeploymentTreeEditor_SaveFailed;
	
	public static String ShowInProjectExplorer_ErrorMsg;
	
	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DeploymentEditorMessages.class);
	}

	private DeploymentEditorMessages()
	{
		super();
	}
}

