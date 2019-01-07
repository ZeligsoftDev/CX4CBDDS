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
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.licensing.exceptions.LicenseException;
import com.zeligsoft.base.licensing.exceptions.RuntimeLicenseException;
import com.zeligsoft.base.licensing.internal.FlexLicenseManager;
import com.zeligsoft.base.licensing.internal.RlmLicenseManager;
import com.zeligsoft.base.licensing.internal.l10n.Messages;

/**
 * Static utility class for verifying the licenses governing key ("trigger")
 * bundles.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class LicenseCheck {
	private static final boolean IS_LICENSE_REQUIRED = false;

	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$
	
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
		if(!IS_LICENSE_REQUIRED){
			return;
		}
		
		if (bundleName == null){ bundleName = "CX"; } //$NON-NLS-1$
		IStatus result = FlexLicenseManager.getInstance().check(bundle, bundleName, cancelOnError, message, notifyListeners);

		if (result.getSeverity() >= IStatus.ERROR) {
			result = RlmLicenseManager.getInstance().check(bundle, bundleName, cancelOnError, message, notifyListeners);
				
			if (result.getSeverity() >= IStatus.ERROR) {		
				//if still an error - throw exception
				throw new LicenseException(result);
			}
		} else {
			//only notify listeners for FlexLM if result is OK,
			//otherwise we delegate to Rlm
			FlexLicenseManager.getInstance().notify(bundle, bundleName, result, message);
		}
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
		
		if(!IS_LICENSE_REQUIRED){
			return;
		}
		//We only check RLM as we're phasing Flex out
		IStatus 	result = RlmLicenseManager.getInstance().checkProduct(bundle, productName, version, cancelOnError, message);
				
		if (result.getSeverity() >= IStatus.ERROR) {		
			//if still an error - throw exception
			throw new LicenseException(result);
		}
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
		IStatus result = FlexLicenseManager.getInstance().checkForWorkflowEntryLicense(featureName, features);
		if (result.getSeverity() == IStatus.OK) { return result; }
		return RlmLicenseManager.getInstance().checkForWorkflowEntryLicense(featureName, features);
	}
	
	/**
	 * Summarizes the current license state of all known features for both
	 * Flex and Rlm based licenses
	 * 
	 * @return a list of the statuses of currently known features
	 */
	public static List<FeatureStatus> summarizeFeatures() {
		List<FeatureStatus> summary = FlexLicenseManager.getInstance().summarizeFeatures();
		RlmLicenseManager.getInstance().summarizeFeatures(summary);
		return summary;
	}

	/**
	 * Imports the licenses in the specified file into the current license file.
	 * We first check that it is a sensible Zeligsoft license file.
	 * 
	 * @param fileToImport
	 *            the license file to import
	 */
	public static void importLicenseFile(File fileToImport) {
		try {
			FlexLicenseManager.getInstance().importLicenseFile(fileToImport);
		}catch (Exception e) {
			RlmLicenseManager.getInstance().importLicenseFile(fileToImport);
		}
	}
	
	
	/**
	 * Imports an activation key for RLM
	 * 
	 * @param key
	 *            the activation key to use
	 */
	public static boolean importActivationKey(String key, String server) {
		return RlmLicenseManager.getInstance().importActivationKey(key, server);
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
		
		//we have the location to the model, the bundle location will be the first element after the
		//first '/'
		String bundleLocation = modelLocation.split("/")[1]; //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleLocation);
		
		if (bundle == null) {return;}
		
		try {
						
			IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_NAME);
			boolean licenseListenerFound = false;
			for (IConfigurationElement element : extensions){
				Object o = element.createExecutableExtension(CLASS_ATTR);
				if (o instanceof LicenseExtensionListener){
					LicenseExtensionListener lel = (LicenseExtensionListener)o;
					if (bundle == lel.getBundle()){
						licenseListenerFound = true;
						if (lel.needsLicense()) {
							// There's currently an error with the RLM license signer where if the product name is too long in 
							// the license file, the product name is truncated.  This gives us a useless product string to compare to, 
							// for now, we have a temporary alternate method. 
							// when fixed, we can revert back to require(lel.getBundle(), lel.getName(), lel.cancelOnError(), errorMessage);
							require (lel.getBundle(), lel.getName(), lel.getVersion(), lel.cancelOnError(), errorMessage);
							lel.licenseValidated();
						}
					}
				} 
			}
			if (!licenseListenerFound && licenseListenerRequired){
				throw new RuntimeLicenseException(NLS.bind(Messages.LicenseManager_BuildConfigLicenserRequired, bundleLocation));
			}
		}
		catch (LicenseException ce){
			//re-throw the exception, this is an expected exception if the licensing fails
			throw ce;
		}
		catch (Exception e) {
			//something unexpected has happened - log the error and fail the licensing check, notify the user that
			//their license is invalid, even if it may not be
			//log the exception
			Activator.error(NLS.bind(Messages.LicenseManager_BuildConfigLicenseException, bundleLocation), e);
			Status result = new Status(IStatus.CANCEL, e.toString(), NLS.bind(Messages.LicenseManager_BuildConfigLicenseException, bundleLocation));
			RlmLicenseManager.getInstance().notifyListeners(bundleLocation, result, Messages.LicenseManager_BuildConfigLicenseException);
			throw new LicenseException(result);
		}
	}
	
	public static void checkRegisteredLicensees(String modelLocation, String errorMessage) throws LicenseException {
		checkRegisteredLicensees(modelLocation, errorMessage, false);
	}
}
