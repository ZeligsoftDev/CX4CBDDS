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

package com.zeligsoft.ddk.zdlgen2umlprofile.l10n;

import org.eclipse.osgi.util.NLS;


/** 
 * Define the string resources.
 * 
 * @author tmcclean
 */
public class ZDLGen2UMLProfileMessages extends NLS {
    
    private static final String BUNDLE_NAME = "com.zeligsoft.ddk.zdlgen2umlprofile.l10n.ZDLGen2UMLProfileMessages";//$NON-NLS-1$

    private ZDLGen2UMLProfileMessages() {
        // Singleton
    }
    
    static {
        NLS.initializeMessages(BUNDLE_NAME, ZDLGen2UMLProfileMessages.class);
    }
   
    public static String GenerateModelLibraryNamesPopupAction_0;

	public static String GenerateProfilePopupAction_0;

	public static String GenerateProfilePopupAction_1;

	public static String GenerateProfilePopupAction_2;

	public static String GenerateProfilePopupAction_confirmMergePrompt;

	public static String GenerateProfilePopupAction_confirmMergeTitle;
	
	public static String GenerateProfilePopupAction_errorDlgTitle;

	/**
     * The message presented to the user to select a destination for the result of their transformation.
     */
    public static String GenerateProfilePopupAction_folder_selection_message;
    
	public static String GenerateProfilePopupAction_badFileName_dlgMessage;
	public static String GenerateProfilePopupAction_badFileName_dlgTitle;
	public static String GenerateProfilePopupAction_badFolder_dlgMessage;
	public static String GenerateProfilePopupAction_badFolder_dlgTitle;
	
	public static String RSMProfilingExtensions_ecoreProfile;
	public static String RSMProfilingExtensions_stdProfile;
	public static String RSMProfilingExtensions_umlMetamodel;
	public static String RSMProfilingExtensions_umlPrimitiveTypes;

	public static String InitializeMenuModelPopupAction_badFileName_dlgTitle;
	public static String InitializeMenuModelPopupAction_badFileName_dlgMessage;
	public static String InitializeMenuModelPopupAction_badFolder_dlgTitle;
	public static String InitializeMenuModelPopupAction_badFolder_dlgMessage;
	public static String InitializeMenuModelPopupAction_confirmMergeTitle;
	public static String InitializeMenuModelPopupAction_confirmMergePrompt;

	public static String InitializeMenuModelPopupAction_folder_selection_message;

	public static String ProfileKey_NeedEPackageStereotypeApplied;

    
}
