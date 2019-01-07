package com.prismtech.spectracx.target.eorb_linux_gcc_arm;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.zeligsoft.base.licensing.LicenseExtensionListener;

public class LicenseListener implements LicenseExtensionListener {

	private boolean needsLicense = true;
	
	@Override
	public boolean needsLicense() {
		return needsLicense;
	}

	@Override
	public boolean cancelOnError() {
		return true;
	}
	
	@Override
	public Bundle getBundle() {
		BundleContext bc = Activator.getBundleContext();
		return (bc == null) ? null : bc.getBundle();
	}

	@Override
	public String getName() {
		return "eorb-linux-gcc-arm"; //$NON-NLS-1$
	}

	@Override
	public void licenseValidated() {
		//we've validated - so don't need to check again
		this.needsLicense = false;
	}

	@Override
	public String getVersion() {
		return "1.00"; //$NON-NLS-1$
	}
}
