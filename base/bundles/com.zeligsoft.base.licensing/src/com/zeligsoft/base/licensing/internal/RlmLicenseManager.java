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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.reprisesoftware.rlm.RlmAvailableProduct;
import com.reprisesoftware.rlm.RlmException;
import com.reprisesoftware.rlm.RlmHandle;
import com.reprisesoftware.rlm.RlmLicense;
import com.zeligsoft.base.licensing.FeatureStatus;
import com.zeligsoft.base.licensing.internal.l10n.Messages;

/**
 * The RLM license manager.
 * 
 * @author mtate
 */
public class RlmLicenseManager extends LicenseManager {

	private static final String ver = "0.01"; //minimum required version to check out //$NON-NLS-1$
	
	private static final String availableProducts = ""; //string to use for handle to check what available products available  //$NON-NLS-1$
	
	private static final String RLM_LICENSE_FILE_NAME = "Zeligsoft_rlm.lic"; //$NON-NLS-1$
	
	private static String libName = "rlm902"; //$NON-NLS-1$
	
	private File licenseFile;
	
	private RlmHandle handle;
	
	HashMap <String, String> currentlyCheckedOut = new HashMap <String, String> ();
	
	private static RlmLicenseManager INSTANCE = new RlmLicenseManager();
	
	
	/**
	 * Not instantiable by clients.
	 */
	private RlmLicenseManager() {
		super();
		if (System.getProperty("org.osgi.framework.processor").equals("x86-64")){ //$NON-NLS-1$ //$NON-NLS-2$
			libName = "64".concat(libName); //$NON-NLS-1$
		}
		if (System.getProperty("os.name").toLowerCase().contains("windows")){ //$NON-NLS-1$ //$NON-NLS-2$
			libName = libName.concat(".dll"); //$NON-NLS-1$
		}else {
			libName = libName.concat(".so"); //$NON-NLS-1$
		}
		initializeUIListener();
	}
	
	public static RlmLicenseManager getInstance(){
		return INSTANCE;
	}
	
	private RlmHandle getHandle(String location){
		RlmHandle result = null;
		try{
			if (location == null) {
				location = getLicenseFile().getAbsolutePath(); 
			}
			result = new RlmHandle(location,"","", libName); //$NON-NLS-1$ //$NON-NLS-2$
		} 
		catch (Exception e){
			error(NLS.bind(Messages.LicenseManager_rlmHandleFailure, location), e); 
		}		
		return result;
	}
	
	private RlmHandle getDefaultHandle(){
		if (handle == null) {
			try{
				handle = new RlmHandle(getLicenseFile().getAbsolutePath(),"","", libName); //$NON-NLS-1$ //$NON-NLS-2$
			}
			catch (Exception e){
				error(Messages.LicenseManager_rlmDefaultHandleFailure, e); 
			}
		}
		return handle;
	}
	
	private void refreshDefaultHandle(){
		RlmHandle defaultHandle = getDefaultHandle();
		// Doing this may cause our currently
		// checked out licenses to be checked back in, however, it is more
		// beneficial that we show than changes as we've already confirmed that
		// the user has licenses for the other products.
		
		// check-in all the licenses first as we'll have to check them back out in a second
		if (defaultHandle != null){
			defaultHandle.close();
			handle = null;
			getDefaultHandle();
			reCheckoutLicenses();
		}
	}
	
	private RlmLicense getLicense(RlmHandle handle, String featureName, String version)
		throws RlmException {
		//check out a single license
		return new RlmLicense(handle, featureName, version, 1);
	}
	
	
	/**
	 * Verify the license status of a given client bundle.
	 * 
	 * @param bundle
	 *            the licensed client bundle to verify
	 * @param bundleName
	 *            the localized name to show for the bundle in the event of a
	 *            problem
	 * @param cancelOnError
	 * 			  if we should have an IStatus of severity cancel instead of error
	 * 			when failing checks
	 * @param message
	 *			  optional message to display to users on failure
	 * 
	 * @return the status of the license check, which will either be OK on
	 *         success or an error status on failure to verify the license
	 */
	@Override
	public IStatus check(Bundle bundle, String bundleName, boolean cancelOnError, String message, boolean notifyListeners){
		IStatus result;
		String bundleID = bundle.getSymbolicName();
		
		if (bundleName == null) {
			bundleName = bundle.getHeaders().get("Bundle-Name"); //$NON-NLS-1$
		}
		
		try {
			FeatureInfo featureInfo = new FeatureInfo(bundle);
			String featureName = featureInfo.getFeatureName();
			String featureVersion = featureInfo.getFeatureVersion();
			getLicense(getDefaultHandle(), featureName, featureVersion);
			
			result = Status.OK_STATUS;
			currentlyCheckedOut.put(featureName, featureVersion);
			
		} catch (RlmException e){
			if (notifyListeners) error(NLS.bind(Messages.LicenseManager_licenseFeatureFailed, bundleName), e);
			result = new Status(cancelOnError ? IStatus.CANCEL : IStatus.ERROR, bundleName, NLS.bind(
								Messages.LicenseManager_0, bundleName));
		}catch (Exception e) {
			result = new Status(cancelOnError ? IStatus.CANCEL : IStatus.ERROR, bundleID, NLS.bind(
				Messages.LicenseManager_2, bundleName, e.getLocalizedMessage()));
		}
		if (notifyListeners) notifyListeners(bundleName, result, message);
		return result;
	}
	
	
	public IStatus checkProduct(Bundle bundle, String productName, String productVersion, boolean cancelOnError, String message){
		IStatus result;
		try {
			getLicense(getDefaultHandle(), productName, productVersion);
			result = Status.OK_STATUS;
			currentlyCheckedOut.put(productName, productVersion);
		}
		catch (RlmException e) {
			error(NLS.bind(Messages.LicenseManager_licenseFeatureFailed, productName), e);
			result = new Status(cancelOnError ? IStatus.CANCEL : IStatus.ERROR, productName, NLS.bind(
								Messages.LicenseManager_0, productName));
		} catch (Exception e) {
			result = new Status(cancelOnError ? IStatus.CANCEL : IStatus.ERROR, productName, NLS.bind(
					Messages.LicenseManager_2, productName, e.getLocalizedMessage()));
		}
		notifyListeners(productName, result, message);
		return result;
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
					getLicense(getDefaultHandle(), productName, productVersion);
					currentlyCheckedOut.put(productName, productVersion);
					return Status.OK_STATUS;
				} catch (Exception e){
					//simply catch the exception so that we continue iterating,
					//checking to see if the next productName is licensed
				}
			}	
		}
		
		error(NLS.bind(Messages.LicenseManager_licenseFeatureFailed, featureName), null);
		return new Status(IStatus.CANCEL, featureName, NLS.bind(
			Messages.LicenseManager_0, featureName));
	}
	
	/**
	 * Summarizes the current license state of all known features for RLM.
	 * If there is more than one license for a product available, only the
	 * one with the shortest amount of time to expiry will be shown
	 * 
	 */
	public void summarizeFeatures(List <FeatureStatus> summary){
		RlmHandle handle = getDefaultHandle();
		if (handle == null || handle.getAvailableProducts(availableProducts, ver) == null) { return; } 
		for (Object product : handle.getAvailableProducts(availableProducts, ver)) { 
			if (product instanceof RlmAvailableProduct){
				RlmAvailableProduct prod = (RlmAvailableProduct)product;
				FeatureStatus toAdd = new FeatureStatus(prod.getName(), prod.getExpiration(), prod.getCount(), FeatureStatus.RLM_LICENSE);
				//check if it's already in the summary, only add if it's not
				boolean add = true;
				FeatureStatus toRemove = null;
				for (FeatureStatus fs : summary) {
					if (fs.getFeature().equals(prod.getName())) {
						//only show the expiry with the furthest expiration date
						if ((fs.getExpiry() != FeatureStatus.EXPIRY_NEVER) && (fs.getExpiry() < toAdd.getExpiry())){
							toRemove = fs;
						}else {
							add = false;
						}
					}
				}
				if (add) {
					summary.remove(toRemove);
					summary.add(toAdd);
				}
			}
		}
	}
	
	/**
	 * Summarizes the current license state of all known features.
	 * 
	 * @return a list of the statuses of currently known features
	 */
	@Override
	public List<String> listFeatures(){
		RlmHandle defaultHandle = getDefaultHandle();
		ArrayList<String> licenses = new ArrayList<String>();
		if (defaultHandle != null && defaultHandle.getAvailableProducts(availableProducts, ver) != null) { 
			for (Object product : defaultHandle.getAvailableProducts(availableProducts, ver)) { 
				if (product instanceof RlmAvailableProduct){
					RlmAvailableProduct prod = (RlmAvailableProduct)product;
					licenses.add(prod.getName());
				}
			}
		}
		return licenses;
	}

	/**
	 * Imports the licenses in the specified file into the current RLM license file.
	 * If there is already a license for the product in the RLM license file,
	 * we will not import that license. 
	 * 
	 * @param fileToImport
	 *            the license file to import
	 */
	public void importLicenseFile(File fileToImport){
		try {
			
			File current = getLicenseFile();

			RlmHandle handle = getHandle(fileToImport.getPath());
			//getting available products will ensure that we are only importing valid
			//licenses
			HashSet <String> productsImported = new HashSet <String>();
			Vector<?> availProd = handle.getAvailableProducts(availableProducts, ver);
			if (availProd == null) {
				//there are no valid licenses to be imported into the tool by the given license,
				//notify the user
				notifyInvalidImport(Messages.LicenseManager_importFailed_No_Valid_Licenses);
			}
			else {
				for (Object product : availProd) { 
					if (product instanceof RlmAvailableProduct){
						RlmAvailableProduct prod = (RlmAvailableProduct)product;
						//we need to read the license file, find the correct
						//license definition and append it to our license file
						if (! productsImported.contains(prod.getName())){
							FileUtil.appendRlmLicense(prod.getName(), current, fileToImport);
							productsImported.add(prod.getName());
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) { 
			error(Messages.LicenseManager_importFailed_fileError, e);
			MessageDialog.openError(null, Messages.LicenseManager_importFailed, Messages.LicenseManager_importFailed_fileError);
		} catch (Exception e) {
			error(Messages.LicenseManager_importFailed, e);
		}
		//we need to refresh the handle so that our newly imported licenses
		//will show up in the summary.  
		refreshDefaultHandle();
	}
	
	
	private void reCheckoutLicenses(){
		for (String product : currentlyCheckedOut.keySet()){
			try {
				getLicense(getDefaultHandle(), product, currentlyCheckedOut.get(product));
			} catch (RlmException e) {
				error(NLS.bind(Messages.LicenseManager_rlmHandleRefreshFailure, product), e);
			}
		}
	}
	
	/**
	 * Imports a license file from the activation server using an activation key
	 * 
	 * @param key
	 *            the activation key to use
	 */
	public boolean importActivationKey(String key, String server){
		boolean result = false;
		try {
			String license = getDefaultHandle().actRequest(server, "prismtech", //$NON-NLS-1$ 
					key, null, null, 1, null);
			if (! license.isEmpty()) { 
				try {
					FileUtil.appendRlmLicense(getLicenseFile(), license);
					refreshDefaultHandle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					result = false;
				}
				result = true; 
			}
		} catch (RlmException e) {
			result = false;
		}
		return result;
	}
	
	
	/**
	 * Get the default license file for RLM
	 *  
	 * @return the file containing the recently activated license
	 * 
	 */
	protected synchronized File getLicenseFile()
		throws IOException {
		
		if (licenseFile == null) {
			licenseFile = getLicenseFile(RLM_LICENSE_FILE_NAME);
		}
		return licenseFile;
	}
	
	
	@Override
	public void notifyListeners(String bundleName, IStatus status, String message) {
		super.notifyListeners(bundleName, status, message);
	}
	
}