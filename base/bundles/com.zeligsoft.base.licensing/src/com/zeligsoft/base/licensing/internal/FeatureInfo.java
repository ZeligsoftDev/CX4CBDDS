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

import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * License-manager feature information for a licensed OSGi bundle.
 * 
 * @author Christian W. Damus (cdamus)
 */
final class FeatureInfo {

	private String featureName;

	private String featureVersion;
	
	private static final String LICENSE_FEATURE_VERSION = "1.000"; //$NON-NLS-1$
	
	private static final String SEPARATOR = "."; //$NON-NLS-1$

	/**
	 * Initializes me with my bundle.
	 * 
	 * @param bundle
	 *            the licensed bundle
	 */
	public FeatureInfo(Bundle bundle) {
		featureName = bundle.getSymbolicName();
		featureVersion = LICENSE_FEATURE_VERSION;		
	}

	@SuppressWarnings("unused")
	private void parseVersion() {
		Version version = new Version(featureVersion);

		featureVersion = version.getMajor() + SEPARATOR + version.getMinor()
				+ version.getMicro() + "0"; //$NON-NLS-1$
	}

	/**
	 * Queries the bundle's license feature name.
	 * 
	 * @return the feature name
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * Queries the bundle's license feature version.
	 * 
	 * @return the feature version
	 */
	public String getFeatureVersion() {
		return featureVersion;
	}
}
