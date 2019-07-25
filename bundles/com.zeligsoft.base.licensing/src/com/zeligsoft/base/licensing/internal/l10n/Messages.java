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
package com.zeligsoft.base.licensing.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * Localized messages for the base licensing plug-in.
 *
 * @author Christian W. Damus (cdamus)
 */
public class Messages
		extends NLS {

	private static final String BUNDLE_NAME = "com.zeligsoft.base.licensing.internal.l10n.messages"; //$NON-NLS-1$

	public static String FeatureStatus_days;

	public static String FeatureStatus_expired;

	public static String FeatureStatus_invalid;

	public static String FeatureStatus_permanent;

	public static String FeatureStatus_today;

	public static String LicenseManager_0;

	public static String LicenseManager_1;

	public static String LicenseManager_2;
	
	public static String LicenseManager_trialLicense;

	public static String LicenseManager_importFailed;
	
	public static String LicenseManager_importFailed_fileError;

	public static String LicenseManager_licenseDetailsExc;

	public static String LicenseManager_listenerFailed;
	
	public static String LicenseManager_BuildConfigLicenseException;
	
	public static String LicenseManager_importFailed_No_Valid_Licenses;
	
	public static String LicenseManager_licenseFeatureFailed;
	
	public static String LicenseManager_rlmHandleFailure;
	
	public static String LicenseManager_rlmDefaultHandleFailure;
	
	public static String LicenseManager_rlmHandleRefreshFailure;
	
	public static String LicenseManager_BuildConfigLicenserRequired;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		super();
	}
}
