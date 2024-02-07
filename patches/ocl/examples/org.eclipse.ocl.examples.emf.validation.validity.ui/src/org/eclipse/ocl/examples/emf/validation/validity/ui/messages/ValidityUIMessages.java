/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class ValidityUIMessages
{	
	static {
		NLS.initializeMessages(ValidityUIMessages.class.getName(), ValidityUIMessages.class);
	}

	public static String ValidityView_viewTitle;
	public static String ValidityView_validatableNodesSectionName;
	public static String ValidityView_constrainingNodesSectionName;
	
	public static String ValidityView_Messages_NoModelElement;
	public static String ValidityView_Messages_NoConstraints;
	public static String ValidityView_Messages_NoSelection;

	public static String ValidityView_Action_ShowInEditor_Title;
	public static String ValidityView_Action_ShowInEditor_ToolTipText;
	public static String ValidityView_Action_ShowInEditor_ImageLocation;

	public static String ValidityView_Action_ForceRefresh_Title;
	public static String ValidityView_Action_ForceRefresh_ImageLocation;
	public static String ValidityView_Action_ForceRefresh_ToolTipText;

	public static String ValidityView_Action_RunValidity_Title;
	public static String ValidityView_Action_RunValidity_ImageLocation;
	public static String ValidityView_Action_RunValidity_ToolTipText;

	public static String ValidityView_Action_DebugValidity_Title;
	public static String ValidityView_Action_DebugValidity_ImageLocation;
	public static String ValidityView_Action_DebugValidity_ToolTipText;
	
	public static String ValidityView_Action_ExportResult_Title;
	public static String ValidityView_Action_ExportResult_ImageLocation;
	public static String ValidityView_Action_ExportResult_ToolTipText;

	public static String ValidityView_Action_ExportError_NoResults;

	public static String ValidityView_Action_FilterResult_Title;
	public static String ValidityView_Action_FilterResult_ImageLocation;
	public static String ValidityView_Action_FilterResult_ToolTipText;


	public static String ValidityView_Action_ExpandAllNodes_Title;
	public static String ValidityView_Action_ExpandAllNodes_ImageLocation;
	public static String ValidityView_Action_ExpandAllNodes_ToolTipText;
	public static String ValidityView_Action_ExpandAllConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_ExpandAllValidatableNodes_ToolTipText;
	

	public static String ValidityView_Action_CollapseAllNodes_Title;
	public static String ValidityView_Action_CollapseAllNodes_ImageLocation;
	public static String ValidityView_Action_CollapseAllNodes_ToolTipText;
	public static String ValidityView_Action_CollapseAllConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_CollapseAllValidatableNodes_ToolTipText;
	
	public static String ValidityView_Action_SelectAllNodes_Title;
	public static String ValidityView_Action_SelectAllConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_SelectAllValidatableNodes_ToolTipText;
	public static String ValidityView_Action_SelectAllNodes_ImageLocation;

	public static String ValidityView_Action_DeselectAllNodes_Title;
	public static String ValidityView_Action_DeselectAllConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_DeselectAllValidatableNodes_ToolTipText;
	public static String ValidityView_Action_DeselectAllNodes_ImageLocation;
	
	public static String ValidityView_Action_ShowHideUnusedNodes_Title;
	public static String ValidityView_Action_HideUnusedConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_HideUnusedValidatableNodes_ToolTipText;
	public static String ValidityView_Action_ShowUnusedConstrainingNodes_ToolTipText;
	public static String ValidityView_Action_ShowUnusedValidatableNodes_ToolTipText;
	public static String ValidityView_Action_ShowUnusedNodes_ImageLocation;
	public static String ValidityView_Action_HideUnusedNodes_ImageLocation;

	public static String ValidityView_Action_ShowHideProfileNodes_Title;
	public static String ValidityView_Action_HideProfileValidatableNodes_ToolTipText;
	public static String ValidityView_Action_ShowProfileValidatableNodes_ToolTipText;
	public static String ValidityView_Action_ShowProfileNodes_ImageLocation;
	public static String ValidityView_Action_HideProfileNodes_ImageLocation;

	public static String ValidityView_Action_ShowNodesByKind_Title;
	public static String ValidityView_Action_ShowNodesByKind_Kind_Failure;
	public static String ValidityView_Action_ShowNodesByKind_Kind_Error;
	public static String ValidityView_Action_ShowNodesByKind_Kind_Warning;
	public static String ValidityView_Action_ShowNodesByKind_Kind_Info;
	public static String ValidityView_Action_ShowNodesByKind_Kind_OK;
	public static String ValidityView_Action_ShowNodesByKind_ToolTipText;
	public static String ValidityView_Action_ShowFailedElementsNodes_ToolTipText;
	
	// Export Validation Results
	public static String ExportValidationResultsDialog_title;
	public static String ExportValidationResultsDialog_fileNameLabel;
	public static String ExportValidationResultsDialog_defaultFileName;
	public static String ExportValidationResultsDialog_exportedFileContextId;
	public static String ExportValidationResultsDialog_file;
	public static String ExportValidationResultsDialog_warningMessage;
	
	public static String ResourceContainerGroupDestination_label;
	public static String ResourceContainerGroupSelection_message;
	
	// source IDEWorkbenchMessages	
	public static String ContainerGroup_message;
	public static String ContainerGroup_selectFolder;
	
	public static String NewWizardPage_errorTitle;
	public static String NewWizardPage_internalErrorTitle;
	public static String NewWizardPage_file;
	public static String NewWizardPage_internalErrorMessage;
	public static String NewWizardPage_nameExists;
	public static String NewWizardPage_wrongExtension;
	public static String NewWizardPage_newFileWizardContextId;
	public static String NewWizardPage_pageName;
	public static String NewWizardPage_resourceWillBeFilteredWarning;

	public static String NewWizardPage_defaultFileName;
	public static String NewWizardPage_fileNameLabel;
	public static String NewWizardPage_pageDescription;
	public static String NewWizardPage_pageSummary;
	public static String NewWizardPage_pageTitle;

	public static String NewWizardPage_exists;
	public static String NewWizardPage_overwrite;
	
	public static String ResourceGroup_resource;
	public static String ResourceGroup_nameExists;
	public static String ResourceGroup_folderEmpty;
	public static String ResourceGroup_noProject;
	public static String ResourceGroup_emptyName;
	public static String ResourceGroup_invalidFilename;
	public static String ResourceGroup_pathOccupied;
}
