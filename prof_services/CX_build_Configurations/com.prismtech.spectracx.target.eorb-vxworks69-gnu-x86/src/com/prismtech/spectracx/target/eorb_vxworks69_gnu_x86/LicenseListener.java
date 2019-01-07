package com.prismtech.spectracx.target.eorb_vxworks69_gnu_x86;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.zeligsoft.base.licensing.LicenseExtensionListener;

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
		return "eorb-vxworks69-gnu-x86"; //$NON-NLS-1$
	}

	public void licenseValidated() {
		//we've validated - so don't need to check again
		this.needsLicense = false;
	}

	public String getVersion() {
		return "1.00"; //$NON-NLS-1$
	}
}
