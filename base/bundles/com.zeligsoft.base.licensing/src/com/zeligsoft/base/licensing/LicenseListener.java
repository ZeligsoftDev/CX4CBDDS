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
package com.zeligsoft.base.licensing;

import org.eclipse.core.runtime.IStatus;

/**
 * Protocol for notifications of license verification, successful or otherwise.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface LicenseListener {

	/**
	 * Notifies me that license verification succeeded for the specified bundle.
	 * 
	 * @param bundle
	 *            a licensed bundle
	 * @param bundleName
	 *            the preferred display name for the bundle
	 * @param okMessage
	 *            message to display to users
	 */
	void licenseVerified(String bundleName, String okMessage);

	/**
	 * Notifies me that license verification succeeded for the specified bundle.
	 * 
	 * @param bundle
	 *            a licensed bundle
	 * @param bundleName
	 *            the preferred display name for the bundle
	 */
	void licenseVerified(String bundleName);

	/**
	 * Notifies me that license verification failed for the specified bundle.
	 * 
	 * @param bundle
	 *            an unlicensed bundle
	 * @param bundleName
	 *            the preferred display name for the bundle
	 * @param status
	 *            the reason why the license check failed
	 * @param errorMessage
	 *            message to display to users
	 */
	void licenseFailed(String bundleName, IStatus status, String errorMessage);
	
	/**
	 * Notifies me that license verification failed for the specified bundle.
	 * 
	 * @param bundle
	 *            an unlicensed bundle
	 * @param bundleName
	 *            the preferred display name for the bundle
	 * @param status
	 *            the reason why the license check failed
	 */
	void licenseFailed(String bundleName, IStatus status);
	
	/**
	 * Notifies me that license import failed
	 * 
	 * @param errorMessage
	 *            message to display to users
	 */
	void licenseImportFailed(String errorMessage);
	
	/**
	 * Notifies me that license verification indicated an informational message needs
	 * to be shown.
	 * 
	 * @param bundle
	 *            an unlicensed bundle
	 * @param bundleName
	 *            the preferred display name for the bundle
	 * @param status
	 *            the reason why the license check failed
	 * @param infoMessage
	 *            message to display to users
	 */
	void licenseInfo(String bundleName, IStatus status, String infoMessage);
}
