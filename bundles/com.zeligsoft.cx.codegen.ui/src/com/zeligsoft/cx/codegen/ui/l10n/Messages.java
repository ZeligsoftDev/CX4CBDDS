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

package com.zeligsoft.cx.codegen.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.cx.codegen.ui.l10n.messages"; //$NON-NLS-1$

	public static String EditSourceActionDelegate_0;

	public static String EditSourceActionDelegate_BadFileName_dlgTitle;

	public static String EditSourceActionDelegate_CreateFolderFailedLog;

	public static String AbstractEditSourceActionDelegate_SaveStereotypePropertyCommand;

	public static String AbstractEditSourceActionDelegate_SaveWorkerCodeFailedLog;

	public static String EditSourceActionDelegate_StereotypeApplyQuestion_dglMessage;

	public static String EditSourceActionDelegate_StereotypeNotApplicable_dlgMessage;

	public static String EditSourceActionDelegate_StereotypeNotApplied_dlgMessage;

	public static String EditSourceActionDelegate_StereotypeValidation_dlgTitle;

	public static String EditSourceActionDelegate_WorkerCodeOpenFailedLog;

	public static String EditSourceActionDelegate_WorkerCodeReadFailedLog;

	public static String GenerateActionProvider_CodeGenMenuManagerTitle;

	public static String EditSourceAction_Message;
	public static String EditSourceAction_MultiStatus_Message;
	public static String EditSourceAction_CannotCreateProject;
	public static String EditSourceAction_InvalidExtension;
	public static String EditSourceAction_CannotGenerate;
	public static String EditSourceActionProvider_EditSourceTitle;
	public static String EditSourceActionProvider_CodeLocatorWrongClass;
	public static String EditSourceActionProvider_ExtensionBadValidationFactory;
	public static String EditSourceActionProvider_ValidationFactoryWrongClass;
	public static String EditSourceActionProvider_LicenserWrongClass;
	
	public static String UserEditableElement_ExtensionMissingAttribute;
	public static String UserEditableElement_BadOrderInteger;
	public static String UserEditableElement_BadClassName;
	public static String UserEditableElement_OnlyOneM2MSupported;
	public static String UserEditableElement_ExactlyOneM2TSupported;
	public static String UserEditableElement_CannotFindMetaModelClass;
	public static String UserEditableElement_CannotCreateMetaModelInstance;

	public static String EObjectEditorOpener_OpeningFile;

	public static String GenerateOperation_GeneratingCode;

	// public static String GenerateAction_label;

	public static String GenerateContributionItemProvider_Zeligsoft_Generate;

	public static String GenerateContributionItemProvider_All;

	public static String GenerateJob_RunOne;
	public static String GenerateJob_RunNonOne;
	public static String GenerateJob_ResultMessage;
	
	public static String GenerateMessage_0;
	public static String GenerateMessage_1;
	public static String GenerateMessage_2;
	public static String GenerateMessage_3;

	public static String TransformAction_ProjectRefreshFailedLog;
	
	public static String TransformAction_ThreadJoinFailedLog;
	
	public static String TransformRegistry_InvalidWorkflowPathLog;
	
	public static String TransformRegistry_InvalidWorkflowValidationFactory;
	
	public static String TransformRegistry_InvalidVisibilityTestClass;
	
	public static String TransformRegistry_InvalidWorkflowEntryLicenser;
	
	public static String TransformRegistry_ClassNotFound;

	public static String WorkerCodeStorage_SaveCommandLabel;

	public static String WorkerCodeStorage_SaveFailedLog;

	public static String CXCodegenPreferencePage_Description;
	
	public static String CXCodegenReportPreferencePage_FileCollectorGroup;
	public static String CXCodegenReportPreferencePage_FileCollectorQuestion;
	public static String CXCodegenReportPreferencePage_FilesAddedCheckbox;
	public static String CXCodegenReportPreferencePage_FilesChangedCheckbox;
	public static String CXCodegenReportPreferencePage_FilesRemovedCheckbox;
	public static String CXCodegenReportPreferencePage_FilesUnchangedCheckbox;
	public static String CXCodegenReportPreferencePage_FilesBeforeCheckbox;
	public static String CXCodegenReportPreferencePage_FilesAfterCheckbox;
	public static String CXCodegenReportPreferencePage_Saving;
	public static String CXCodegenReportPreferencePage_Cancelling;
	public static String CXCodegenReportPreferencePage_ErrorSaving;

	public static String FileCollector_NullProject;
	public static String FileCollector_CoreException;
	public static String FileCollector_ResourceListener_CoreException;
	public static String FileCollector_FilesUpdatedTitleMessage;
	public static String FileCollector_SeparatorLine;
	public static String FileCollector_Warning_StillCollecting;
	public static String FileCollector_FilesBeforeTitleMessage;
	public static String FileCollector_FilesAfterTitleMessage;
	public static String FileCollector_FilesAddedTitleMessage;
	public static String FileCollector_FilesChangedTitleMessage;
	public static String FileCollector_FilesRemovedTitleMessage;
	public static String FileCollector_FilesUnchangedTitleMessage;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// do nothing
	}
}
