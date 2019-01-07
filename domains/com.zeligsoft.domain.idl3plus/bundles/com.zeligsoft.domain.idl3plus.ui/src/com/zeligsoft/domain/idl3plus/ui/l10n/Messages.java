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
package com.zeligsoft.domain.idl3plus.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages 
	extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getName();
	public static final String CommandLabel_ComponentPartEditHelperAdvice_getAfterCreateCommand = null;
	

	private Messages() {
		// Do not instantiate
	}

	public static String AbstractSetElementLabelDisplayActionDelegate_CommandErrorMsg;
	public static String ConnectorDefaultValueBinding_CreateCommandLabel;
	public static String ConnectorDefaultValueBinding_ErrorMessage;
	public static String CreateTemplateParameter__Error_CreatingTypeParameter;
	public static String CreateTemplateParameter_CommandLabel;
	public static String CreateTemplateParameterDialog_DialogTitle;
	public static String CreateTemplateParameterDialog_Label_NameTextArea;
	public static String CreateTemplateParameterDialog_Label_TypeConstraint;
	public static String IDL3PlusConnectorEditHelperAdvice_CommandLabel;
	public static String IDL3PlusConnectorEditHelperAdvice_ConnectionErrorDialogTitle;
	public static String IDL3PlusConnectorEditHelperAdvice_ConnectionErrorMsg;
	public static String IDL3PlusDataSpaceCustomPropertySectionProvider_Label;
	public static String IDL3PlusWizardPageCreator_ModelPageName;
	public static String IDL3PlusWizardPageCreator_ProjectPageName;
	public static String InstantiateTemplateModule_CommandLabel;
	public static String InstantiateTemplateModule_DialogTitle;
	public static String InstantiateTemplateModuleDialog_DialogTitle;
	public static String InstantiateTemplateModuleDialog_NameColumnLabel;
	public static String InstantiateTemplateModuleDialog_ParameterColumnLabel;
	public static String InstantiateTemplateModuleDialog_ParameterTypeSelectionDialogTitle;
	public static String TemplateModuleSelectDialog_Label_TemplateModulesList0;
	public static String TemplateModuleSelectDialog_Label_TemplateModulesList1;
	public static String ToggleLogicalDiagramViewAction_ExtendeViewActionLabel;
	public static String ToggleLogicalDiagramViewAction_LogicalViewActionLabel;
	public static String Wizard__Default_Model_name;
	public static String Wizard__NewModelPage_description;
	public static String Wizard__NewModelPage_title;
	public static String Wizard__NewProjectPage_description;
	public static String Wizard__NewProjectPage_title;
	
	public static String IDLImportWizard_ImportIDLOperationName;
	public static String IDLImportWizard_ErrorNoBundle;
	public static String IDLImportWizard_ErrorNoURL;
	public static String IDLImportWizard_Failure;
	public static String RepairAllModuleInstantiationsAction_ErrorRepairingAllModuleInstantiations;
	public static String RepairAllModuleInstantiationsAction_JobTitle;
	public static String RepairAllModuleInstantiationsAction_RepairAllCommandLabel;
	public static String RepairAllModuleInstantiationsAction_TaskName;
	
	public static String RefactorContainerProcess_DialogTitle;	
	public static String ConvertStructToField_DialogTitle;
	public static String AddRegisterNaming_DialogTitle;
	public static String Migrate_OK;	
	public static String Migrate_Noop;	
	public static String Migrate_Error;
	public static String PortDecorationImages_IconNotFoundError;

	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
