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
package com.zeligsoft.cx.ui.properties.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * External strings
 * 
 * @author ysroh
 * 
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.cx.ui.properties.l10n.messages"; //$NON-NLS-1$

	public static String CXCustomPropertySectionProvider_commandLabel;

	public static String CXPropertyCollectionPage_AddButtonLabel;

	public static String CXPropertyCollectionPage_AddButtonTooltip;

	public static String CXPropertyCollectionPage_DependencyLabelEnclosure;

	public static String CXPropertyCollectionPage_EditButtonTooltip;

	public static String CXPropertyCollectionPage_IndexColumnLabel;

	public static String CXPropertyCollectionPage_RemoveButtonLabel;

	public static String CXPropertyCollectionPage_RemoveButtonTooltip;

	public static String CXPropertyCollectionPage_ValueColumnLabel;

	public static String CXPropertyDefinitionManager_LoadingFailedLog;

	public static String CXPropertyDescriptor_ChangePropertyValueTransactionLabel;

	public static String CXPropertyDescriptor_ChangingPropertyValueFailedLog;

	public static String CXPropertyDescriptor_CreateConceptTransactionLabel;

	public static String CXPropertyDescriptor_ElementCreationFailedLog;

	public static String CXPropertyDescriptor_RemovePropertyValueTransactionLabel;

	public static String CXPropertyDescriptor_RemovePropertyValueFailedLog;

	public static String CXWidgetFactory_CollectionButtonLabel;

	public static String CXWidgetFactory_DeleteButtonTooltip;

	public static String CXWidgetFactory_EditButtonTooltip;
	
	public static String CXWidgetFactory_GenerateIdTooltip;
	
	public static String CXWidgetFactory_DeleteIdTooltip;
	
	public static String CXWidgetFactory_OverrideIdTooltip;

	public static String CXWidgetFactory_EditorOpenFailedLog;

	public static String CXWidgetFactory_ElementSelectionDialogTitle;

	public static String CXWidgetFactory_InvalidPropertyMessageLabel;

	public static String CXWidgetFactory_MultivalueEntriesLabel;

	public static String CXWidgetFactory_NullValueString;

	public static String CXWidgetFactory_ShowPropertiesToolTip;

	public static String DeploymentPropertiesCustomSection_IndexColumnLabel;

	public static String DeploymentPropertiesCustomSection_propertiesLabel;

	public static String DeploymentPropertiesCustomSection_ValueColumnLabel;

	public static String DomainPropertySection_EmptyTabMsg;
	
	public static String CXPropertyCollectionPage_ColumnLabel;

	public static String CXPropertyCollectionPage_FailedMsg;

	public static String CXPropertyCollectionPage_MoveDownCmdMsg;

	public static String CXPropertyCollectionPage_MoveUpCmdLabel;

	public static String PropertiesUtil_LoadingIconFailedLog;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// do nothing
	}
}
