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
package com.zeligsoft.base.licensing.ui.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages for the licensing UI plug-in.
 *
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.base.licensing.ui.internal.l10n.messages"; //$NON-NLS-1$

	public static String ManageLicensesDialog_featureCol;

	public static String ManageLicensesDialog_importBtn;
	
	public static String ManageLicensesDialog_reportBtn;
	
	public static String ManageLicensesDialog_importKeyBtn;

	public static String ManageLicensesDialog_importDlg;

	public static String ManageLicensesDialog_restart;

	public static String ManageLicensesDialog_statusCol;

	public static String ManageLicensesDialog_summary;

	public static String ManageLicensesDialog_title;
	
	public static String ImportActivationKeyDialog_title;
	
	public static String ImportActivationKeyDialog_keyMessage;

	public static String ImportActivationKeyDialog_serverMessage;

	public static String UILicenseListener_0;

	public static String UILicenseListener_1;

	public static String UILicenseListener_2;

	public static String UILicenseListener_3;
	
	public static String UILicenseListener_TrialLicense;
	
	public static String ManageLicensesDialog_licenseImportFailed;
	
	public static String GenerateInstalledPluginsReport_title;
	
	public static String GenerateLicenseReport_title;
	
	public static String GenerateInstalledPluginsReport_fileExtension;
	
	public static String GenerateInstalledPluginsReport_fileHeader;
	
	public static String GenerateLicenseReport_fileExtension;
	
	public static String GenerateLicenseReport_fileHeader;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
