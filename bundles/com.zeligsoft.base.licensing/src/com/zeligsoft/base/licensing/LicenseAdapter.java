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
 * Convenient superclass for license listeners.  Subclasses need only to
 * override the callbacks of interest to them.
 *
 * @author Christian W. Damus (cdamus)
 */
public class LicenseAdapter
		implements LicenseListener {

	/**
	 * Initializes me.
	 */
	public LicenseAdapter() {
		super();
	}

	@Override
	public void licenseFailed(String bundleName, IStatus status, String errorMessage) {
		// no-op
	}
	
	@Override
	public void licenseFailed(String bundleName, IStatus status) {
		licenseFailed(bundleName, status, null);
	}
	
	@Override
	public void licenseImportFailed(String errorMessage) {
		//no-op
	}

	@Override
	public void licenseVerified(String bundleName, String okMessage) {
		// no-op
	}
	
	@Override
	public void licenseVerified(String bundleName) {
		licenseVerified(bundleName, null);
	}
	
	@Override
	public void licenseInfo(String bundleName, IStatus status, String infoMessage){
		// no-op
	}

}
