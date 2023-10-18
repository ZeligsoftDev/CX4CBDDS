/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Obeo - New File Wizard
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class BaseUIMessages
{
	static {
		NLS.initializeMessages(BaseUIMessages.class.getName(), BaseUIMessages.class);
	}

	/**
	 * @since 1.4
	 */
	public static String ExportError_Title;
	/**
	 * @since 1.4
	 */
	public static String Export_Description;
	/**
	 * @since 1.4
	 */
	public static String Export_ShellTitle;
	/**
	 * @since 1.4
	 */
	public static String Export_Title;

	public static String LoadError_Title;

	/**
	 * @since 1.4
	 */
	public static String MissingSelection;
	/**
	 * @since 1.4
	 */
	public static String MissingSelectionResourceSet;

	public static String NewWizardPage_errorTitle;
	public static String NewWizardPage_file;
	public static String NewWizardPage_internalErrorTitle;
	public static String NewWizardPage_internalErrorMessage;
	public static String NewWizardPage_nameExists;
	public static String NewWizardPage_newFileWizardContextId;
	public static String NewWizardPage_pageName;
	public static String NewWizardPage_resourceURIs_label;
	public static String NewWizardPage_resourceWillBeFilteredWarning;

	public static String SaveAS_ShellTitle;
	public static String SaveAS_Title;
	public static String SaveAS_Description;
	public static String SaveCS_ShellTitle;
	public static String SaveCS_Title;
	public static String SaveCS_Description;
	public static String SaveError_Title;

	public static String OCLNatureAddingEditorCallback_MessageDialog_Message;
	public static String OCLNatureAddingEditorCallback_MessageDialog_Title;

	public static String MultiValidationJob_Name;
	public static String MultiValidationJob_Validating;

	public static String MultiValidationJob_Initializing;
	public static String MultiValidationJob_Queuing;
	public static String MultiValidationJob_Selecting;

	// source IDEWorkbenchMessages
	public static String ContainerGroup_message;
	public static String ContainerGroup_selectFolder;

	public static String ResourceGroup_resource;
	public static String ResourceGroup_nameExists;
	public static String ResourceGroup_folderEmpty;
	public static String ResourceGroup_noProject;
	public static String ResourceGroup_emptyName;
	public static String ResourceGroup_invalidFilename;
	public static String ResourceGroup_pathOccupied;

	/*
	 * @deprecated no longer used
	 */
	@Deprecated
	public static String DeferredDocumentProvider_PleaseWait;
}
