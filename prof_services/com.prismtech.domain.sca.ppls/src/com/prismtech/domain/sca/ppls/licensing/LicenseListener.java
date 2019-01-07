/**
 * The Software and documentation are Copyright 2014 PrismTech Canada Inc. All rights reserved.
 */

package com.prismtech.domain.sca.ppls.licensing;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.prismtech.domain.sca.ppls.Activator;
import com.zeligsoft.base.licensing.LicenseExtensionListener;

/**
 * @author mciobanu
 */
public class LicenseListener implements LicenseExtensionListener {

	private boolean needsLicense = true;
	
	public boolean needsLicense() {
		return needsLicense;
	}

	public boolean cancelOnError() {
		return true;
	}

	public Bundle getBundle() {
		BundleContext bc = Activator.getBundleContext();
		return (bc == null) ? null : bc.getBundle();
	}

	public String getName() {
		return "com.prismtech.domain.sca.plm";
	}

	public String getVersion() {
		return "1.00";
	}

	public void licenseValidated() {
		// we've validated - so don't need to check again
		this.needsLicense = false;
	}

}
