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
package com.zeligsoft.base.licensing.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.macrovision.flexlm.Feature;
import com.macrovision.flexlm.FeatureSpecifier;
import com.macrovision.flexlm.FlexlmException;
import com.macrovision.flexlm.FlexlmListException;
import com.macrovision.flexlm.License;
import com.macrovision.flexlm.LicenseSource;
import com.macrovision.flexlm.VendorInfo;
import com.zeligsoft.base.licensing.FeatureStatus;
import com.zeligsoft.base.licensing.internal.l10n.Messages;

/**
 * The Flex license manager.
 * 
 * @author mtate
 */
public class FlexLicenseManager extends LicenseManager{

	private File licenseFile;
	
	private static final String FLEX_LICENSE_FILE_NAME = "Zeligsoft.lic"; //$NON-NLS-1$
	
	private static FlexLicenseManager INSTANCE = new FlexLicenseManager();
	
	private final Object licenseSourceLock = new Object();
	
	private LicenseSource licenseSource;
	
	/**
	 * Not instantiable by clients.
	 */
	private FlexLicenseManager() {
		super();

		initializeUIListener();
	}

	/**
	 * Obtains the singleton license manager object.
	 * 
	 * @return the license manager
	 */
	public static FlexLicenseManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Checks the license status of a given client bundle.
	 * 
	 * @param bundle
	 *            the licensed client bundle to verify
	 * @param bundleName
	 *            the localized name to show for the bundle in the event of a
	 *            problem
	 * @param message
	 *			  optional message to display to users on failure
	 * @param cancelOnError
	 * 			  determines if we should have an IStatus of severity cancel instead of error
	 * 			when failing checks
	 * 
	 * @return the status of the license check, which will either be OK on
	 *         success or an error status on failure to verify the license
	 */
	@Override
	public IStatus check(Bundle bundle, String bundleName, boolean cancelOnError, String message, boolean notifyListeners) {
		IStatus result;
		String bundleID = bundle.getSymbolicName();
		
		if (bundleName == null) {
			bundleName = bundle.getHeaders().get("Bundle-Name"); //$NON-NLS-1$
		}

		try {
			FeatureInfo featureInfo = new FeatureInfo(bundle);

			LicenseSource source = getLicenseSource();
			FeatureSpecifier spec = new FeatureSpecifier(featureInfo
				.getFeatureName(), featureInfo.getFeatureVersion());
			License license = new License(spec, source);

			if (!license.checkout(1)) {
				result = new Status(IStatus.ERROR, bundleID, NLS.bind(
					Messages.LicenseManager_0, bundleName));
			} else {
				// the license is uncounted, so may as well clean up
				license.checkin();
				result = Status.OK_STATUS;

				debug("License verified for " + bundleID); //$NON-NLS-1$
			}
		} catch (FlexlmException e) {
			result = new Status(IStatus.ERROR, bundleID, NLS.bind(
				Messages.LicenseManager_1, bundleName, e.getLocalizedMessage()));
		} catch (Exception e) {
			result = new Status(IStatus.ERROR, bundleID, NLS.bind(
				Messages.LicenseManager_2, bundleName, e.getLocalizedMessage()));
		}
		
		//we don't notify listeners yet as we want to check the Rlm result first
		//notifyListeners(bundle, bundleName, result);
		return result;
	}

	/**
	 * Obtains the cached license source.
	 * 
	 * @return the license source
	 * 
	 * @throws FlexlmException
	 *             on failure to construct the license source due to some FLEX
	 *             problem
	 * @throws IOException
	 *             on failure to construct the license source due to I/O
	 *             problems
	 */
	private LicenseSource getLicenseSource()
			throws FlexlmException, IOException {

		synchronized (licenseSourceLock) {
			if (licenseSource == null) {
				VendorInfo vInfo = new zeligInfo();
				licenseSource = LicenseSource.createLicenseSource(
					getLicenseFile().getAbsolutePath(), vInfo, null);
			}
		}

		return licenseSource;
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
	public IStatus checkForWorkflowEntryLicense(String featureName, LinkedHashMap<String, String> features){
		for (String productName : features.keySet()) {
			String productVersion = features.get(productName);
			if (productName != null && !productName.isEmpty()){
				try {
					LicenseSource source = getLicenseSource();
					FeatureSpecifier spec = new FeatureSpecifier(productName, productVersion);
					License license = new License(spec, source);

					if (license.checkout(1)) {
						return Status.OK_STATUS;
					}
				} catch (Exception e){
					//simply catch the exception so that we continue iterating,
					//checking to see if the next productName is licensed
				}
			}	
		}
		
		return new Status(IStatus.CANCEL, featureName, NLS.bind(
			Messages.LicenseManager_0, featureName));
	}

	
	/**
	 * Summarizes the current license state of all known features.
	 * 
	 * @return a list of the statuses of currently known features
	 */
	public List<FeatureStatus> summarizeFeatures() {
		List<FeatureStatus> result = new java.util.ArrayList<FeatureStatus>();

		try {
			LicenseSource source = getLicenseSource();

			String[] featureNames = source.getFeatureList();
			for (String next : featureNames) {
				Feature[] details = source.getFeatureDetails(next);

				if ((details == null) || (details.length == 0)) {
					result.add(new FeatureStatus(next,
						FeatureStatus.EXPIRY_INVALID, FeatureStatus.FLEX_LICENSE));
				} else {
					for (Feature detail : details) {
						if (detail.isAFeature()) {
							FeatureStatus toAdd = new FeatureStatus(next, detail.daysUntilExpiration(), FeatureStatus.FLEX_LICENSE);
							// we only want to show the expiry with the longest time remaining
							boolean add = true;
							FeatureStatus toRemove = null;
							for (FeatureStatus fs : result) {
								if (fs.getFeature().equals(toAdd.getFeature())) {
									if ((fs.getExpiry() != FeatureStatus.EXPIRY_NEVER) && 
															(fs.getExpiry() < toAdd.getExpiry())) {
										toRemove = fs;
									}
									else {
										add = false;
									}
								}
							}
							if (add) {
								result.remove(toRemove);
								result.add(toAdd);
							}
						}
					}
				}
			}
		} catch (FlexlmListException ex) {
			// This occurs when there is no flex license file, eat silently
		}
		catch (Exception e) {
			error(Messages.LicenseManager_licenseDetailsExc, e);
		}

		return result;
	}
	
	/**
	 * Summarizes the current license state of all known features.
	 * 
	 * @return a list of the statuses of currently known features
	 */
	@Override
	public List<String> listFeatures(){
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			LicenseSource source = getLicenseSource();

			String[] featureNames = source.getFeatureList();

			for (String next : featureNames) {
				result.add(next);
			}
		} 
		catch (FlexlmListException ex) {
			// This occurs when there is no flex license file, eat silently
		}
		catch (Exception e) {
			error(Messages.LicenseManager_licenseDetailsExc, e);
		}
		return result;
	}

	/**
	 * Imports the licenses in the specified file into the current license file.
	 * We first check that it is a sensible Zeligsoft license file.
	 * 
	 * @param fileToImport
	 *            the license file to import
	 */
	public void importLicenseFile(File fileToImport)
			throws Exception{
		try {
			// creating a license source will fail if it isn't a valid Flex
			// license file
			VendorInfo vInfo = new zeligInfo();
			LicenseSource.createLicenseSource(fileToImport.getAbsolutePath(),
				vInfo, null);

			File current = getLicenseFile();
			if (!current.exists()) {
				FileUtil.create(current, fileToImport);
			} else {
				FileUtil.append(current, fileToImport);
			}
		} catch (FlexlmListException flexEx){
			// no need to log the error as we may be attempting to import
			// an RLM license
			throw flexEx;
		} catch (Exception e) {
			error(Messages.LicenseManager_importFailed, e);
			throw e;
		} finally {
			// will have to rebuild the license source
			synchronized (licenseSourceLock) {
				licenseSource = null;
			}
		}
	}

	private synchronized File getLicenseFile()
			throws IOException {
		if (licenseFile == null) {
			licenseFile = getLicenseFile(FLEX_LICENSE_FILE_NAME);
		}
		return licenseFile;
	}
	
	/**
	 * Notifies listeners of the check result.
	 * We need this so that we can integrate with Rlm
	 * and use that status as well
	 * 
	 * @param bundle
	 *            the bundle we're checking the license for
	 * @param bundleName
	 *            the name of bundle we're checking the license for
	 * @param message
	 *            optional message to be used to take place of dialog message
	 * @param status
	 *            the result status of the license check
	 */
	public void notify(Bundle bundle, String bundleName, IStatus status, String message){
		notifyListeners(bundleName, status, message);
	}
	
	public void notify(Bundle bundle, String bundleName, IStatus status){
		notifyListeners(bundleName, status, null);
	}
}