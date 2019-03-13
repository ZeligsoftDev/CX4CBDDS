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
package com.zeligsoft.cx.codegen.editor;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.eclipse.core.runtime.IStatus;

import com.zeligsoft.base.licensing.LicenseCheck;

public abstract class UIProviderLicenser {

	private LinkedHashMap<String, String> features;
	
	//cache the result based on featureName, and group version with license result
	private static final HashMap<String, HashMap<String, IStatus>> licenseCache = new HashMap<String, HashMap<String, IStatus>>();
	
	public UIProviderLicenser(){
		features = new LinkedHashMap<String, String>();
	}
	
	public IStatus check(){
		IStatus result = null;
		HashMap<String, IStatus> cachedResult = licenseCache.get(getFeatureName());
		if (cachedResult != null) {
			IStatus cachedStatus = cachedResult.get(getLicenseVersion());
			if (cachedStatus != null) {
				return cachedStatus;
			} 
		}
		result = LicenseCheck.checkForWorkflowEntryLicense(getFeatureName(), features);
		if (licenseCache.get(getFeatureName()) != null){
			licenseCache.get(getFeatureName()).put(getLicenseVersion(), result);
		} else {
			HashMap<String, IStatus> versionCache = new HashMap<String,IStatus>();
			versionCache.put(getLicenseVersion(), result);
			licenseCache.put(getFeatureName(), versionCache);
		}
		return result;
	}
	
	protected void addFeature(String feature, String version){
		if (version == null || version.isEmpty()){ version = getLicenseVersion(); }
		features.put(feature, version);
	}
	
	protected String getLicenseVersion(){
		return "0.01"; //$NON-NLS-1$
	}
	
	protected abstract String getFeatureName();
}
