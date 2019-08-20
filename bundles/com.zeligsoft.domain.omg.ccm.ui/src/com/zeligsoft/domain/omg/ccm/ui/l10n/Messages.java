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
package com.zeligsoft.domain.omg.ccm.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class Messages 
	extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getName();
	public static final String CommandLabel_SCAComponentPartEditHelperAdvice_getAfterCreateCommand = null;
	

	private Messages() {
		// Do not instantiate
	}

	public static String Wizard__Default_Model_name;
	public static String Wizard__NewModelPage_description;
	public static String Wizard__NewModelPage_title;
	public static String Wizard__NewProjectPage_description;
	public static String Wizard__NewProjectPage_title;
	
	public static String AddCCMAssemblyImplementationToComponent;
	public static String AddCCMAssemblyImplementationToComponent_FailedLog;
	
	public static String AddMonolithicImplementation_CommandLabel;
	
	public static String CCMComponentDragDropPolicy_CommandLabel;
	
	public static String CCMComponentWizard_CommandLabel;
	public static String CCMComponentWizard_ErrorMsg;
	public static String CCMComponentWizard_Title;
	
	public static String CCMComponentWizardPage_kind;
	public static String CCMComponentWizardPage_assembly;
	public static String CCMComponentWizardPage_monolithic;
	public static String CCMComponentWizardPage_CreateImplementationButtonLabel;
	public static String CCMComponentWizardPage_ImplNameErrorMsg;
	public static String CCMComponentWizardPage_ImplNameLabel;
	public static String CCMComponentWizardPage_ImplOptionGroupLabel;
	public static String CCMComponentWizardPage_AutoCreatePkgButtonLabel;
	public static String CCMComponentWizardPage_AutoDiagramButtonLabel;
	public static String CCMComponentWizardPage_AutoStructureDiagramButtonLabel;	
	public static String CCMComponentWizardPage_ComponentNameLabel;
	public static String CCMComponentWizardPage_CreateOptionGroupLabel;
	public static String CCMComponentWizardPage_Description;
	public static String CCMComponentWizardPage_DiagramNameErrorMsg;
	public static String CCMComponentWizardPage_DiagramNameLabel;
	public static String CCMComponentWizardPage_NameErrorMsg;
	public static String CCMComponentWizardPage_PackageNameErrorMsg;
	public static String CCMComponentWizardPage_PackageNameLabel;
	public static String CCMComponentWizardPage_showAssembly;
	public static String CCMComponentWizardPage_StructureDiagramNameErrorMsg;
	public static String CCMComponentWizardPage_Title;
	public static String CCMComponentWizardPage_UseDefaultButtonLabel;
	public static String CCMComponentWizardPage_addSubpackage;
	public static String CCMComponentWizardPage_subpackageName;
	public static String CCMComponentWizardPage_SubpackageNameErrorMsg;
		
	public static String CCMModelingPreferencePage_AssemblySuffixLabel;
	public static String CCMModelingPreferencePage_MonolithicSuffixLabel;
	public static String CCMModelingPreferencePage_ComponentWizardSettingGroupLabel;
	public static String CCMModelingPreferencePage_DiagramSuffixLabel;
	public static String CCMModelingPreferencePage_PackageSuffixLabel;
	public static String CCMModelingPreferencePage_TypeSelectionDialogButtonLabel;
	public static String CCMModelingPreferencePage_Suffixes;
	public static String CCMModelingPreferencePage_MonoImpl;
	public static String CCMModelingPreferencePage_SubpackageName;
	
	public static String CCMPropertiesDialog_ActionLabel;
	public static String CCMPropertiesDialog_ErrorMsg;
	public static String CCMPropertiesDialog_InstancePostFix;
	public static String CCMPropertiesDialog_Title;
	
	public static String CCMPropertyEditingSupport_CellValidationError;
	public static String CCMPropertyEditingSupport_defaultValueLabel;
	public static String CCMPropertyEntry_DefaultValueLabel;
	public static String CCMPropertyEntry_NumEntrySuffix;
	public static String CCMPropertyEntry_SaveErrorMessage;
	public static String CCMPropertyEntry_TypeUndefinedLabel;
	
	public static String PartEditPolicy_CreateQuestion;
	public static String PartEditPolicy_CreateStructureDiagramTitle;
	public static String PartEditPolicy_PopupMessage;
	public static String PartEditPolicy_ViewStructureDiagramTitle;
	
	public static String RegenerateUUIDAction_ActionLabel;
	public static String RegenerateUUIDAction_ErrorMessage;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
