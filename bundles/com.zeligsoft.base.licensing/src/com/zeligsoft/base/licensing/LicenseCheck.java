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

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.licensing.exceptions.LicenseException;

/**
 * Static utility class for verifying the licenses governing key ("trigger")
 * bundles.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class LicenseCheck {
	@SuppressWarnings("unused")
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$
	
	@SuppressWarnings("unused")
	private static final String EXTENSION_NAME = "com.zeligsoft.base.licensing.license_check"; //$NON-NLS-1$
	
	/**
	 * Not instantiable by clients.
	 */
	private LicenseCheck() {
		super();
	}

	/**
	 * Asserts that the license for the specified bundle is available.
	 * 
	 * @param bundle
	 *            a bundle
	 * 
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle)
			throws LicenseException {
		require(bundle, null);
	}
	
	/**
	 * Asserts that the license for the specified bundle is available.
	 * 
	 * @param bundle
	 *            a bundle
	 *            
	 * @param notifyListeners
	 * 			  whether or not listeners should be notified
	 * 
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle, boolean notifyListeners)
			throws LicenseException {
		require(bundle, null, false, null, notifyListeners);
	}
	
	/**
	 * Asserts that the license for the specified bundle is available.
	 * 
	 * @param bundle
	 *            a bundle
	 *            
	 * @param bundleName
	 * 			  Name of bundle to display in any messages to user
	 * 
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle, String bundleName)
			throws LicenseException {
		require(bundle, bundleName, false);
	}
	
	/**
	 * Asserts that the license for the specified bundle is available.
	 * 
	 * @param bundle
	 *            a bundle
	 * @param bundleName
	 * 			  Name of bundle to display in any messages to user
	 * @param cancelOnError
	 * 			  determines whether CANCEL IStatus should be used in place
	 * 			of the ERROR IStatus
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle, String bundleName, boolean cancelOnError)
			throws LicenseException {
		require(bundle, bundleName, cancelOnError, null);
	}
	
	public static void require(Bundle bundle, String bundleName, boolean cancelOnError, String message)
			throws LicenseException{
		require(bundle, bundleName, cancelOnError, message, true);
	}
	
	/**
	 * Asserts that the license for the specified bundle is available.
	 * 
	 * @param bundle
	 *            a bundle
	 * @param bundleName
	 * 			  Name of bundle to display in any messages to user
	 * @param cancelOnError
	 * 			  determines whether CANCEL IStatus should be used in place
	 * 			of the ERROR IStatus
	 * @param message
	 *			  optional message to display to users on failure
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle, String bundleName, boolean cancelOnError, String message, boolean notifyListeners)
			throws LicenseException {
		// no-op: all licensing removed
	}
	
	/**
	 * Asserts that the license for the specified product is available.
	 * 
	 * @param bundle
	 *            a bundle
	 * @param productName
	 *            the name of the product that we're attempting to license
	 * @param version
	 *            the version of the product that we're attempting to license
	 * @param cancelOnError
	 * 			  determines whether CANCEL IStatus should be used in place
	 * 			of the ERROR IStatus
	 * @param message
	 *			  optional message to display to users on failure
	 * @throws LicenseException
	 *             if the license is not available for any reason
	 */
	public static void require(Bundle bundle, String productName, String version, boolean cancelOnError, String message)
			throws LicenseException {
		// no-op: all licensing removed
	}
	
	/**
	 * Verify the license status of a given client bundle.
	 * 
	 * @param featureName
	 *            the name of the feature that we're checking to license, used
	 *            in error messages displayed to the user
	 * @param features
	 *            A list of features with versions to check for licensing.  If one
	 *            feature produces an OK status for license check, the return of the
	 *            method is an OK status
	 * 
	 * @return the status of the license check, which will either be OK on
	 *         success or an error status on failure to verify the license
	 */
	public static IStatus checkForWorkflowEntryLicense(String featureName, LinkedHashMap<String, String> features){
		// no-op: all licensing removed
		return Status.OK_STATUS;
	}
	
	/**
	 * Summarizes the current license state of all known features for both
	 * Flex and Rlm based licenses
	 * 
	 * @return a list of the statuses of currently known features
	 */
	public static List<FeatureStatus> summarizeFeatures() {
		// no-op: all licensing removed
		return Collections.emptyList();
	}

	/**
	 * Imports the licenses in the specified file into the current license file.
	 * We first check that it is a sensible Zeligsoft license file.
	 * 
	 * @param fileToImport
	 *            the license file to import
	 */
	public static void importLicenseFile(File fileToImport) {
		// no-op: all licensing removed
	}
	
	
	/**
	 * Imports an activation key for RLM
	 * 
	 * @param key
	 *            the activation key to use
	 */
	public static boolean importActivationKey(String key, String server) {
		// no-op: all licensing removed
		return true;
	}
	
	/**
	 * Validates a resource against a given license listener associated with the resource
	 * 
	 * @param resource
	 * 			  the resource to check the license for
	 * 
	 * @param errorMessage
	 * 			  an error message to display to the user in the event of failure
	 * 
	 * @param licenseListenerRequired
	 *            if true, throws a runtime exception if the license listener can not be found
	 */
	public static void checkRegisteredLicensees(String modelLocation, String errorMessage, boolean licenseListenerRequired) throws LicenseException {
		// no-op: all licensing removed
	}
	
	public static void checkRegisteredLicensees(String modelLocation, String errorMessage) throws LicenseException {
		checkRegisteredLicensees(modelLocation, errorMessage, false);
	}
}
