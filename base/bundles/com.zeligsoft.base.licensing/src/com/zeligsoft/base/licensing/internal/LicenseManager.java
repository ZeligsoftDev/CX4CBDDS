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
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.licensing.LicenseListener;
import com.zeligsoft.base.licensing.exceptions.LicenseException;
import com.zeligsoft.base.licensing.internal.l10n.Messages;

/**
 * The license manager.
 * 
 * @author mtate
 */
public abstract class LicenseManager {
	
	protected List<LicenseListener> listeners = new java.util.ArrayList<LicenseListener>(1);
	
	protected static int BUNDLE_AVAILABLE = Bundle.ACTIVE | Bundle.RESOLVED
	| Bundle.STARTING;
	
	protected static final boolean DEBUG_MODE;
	
	static {
		DEBUG_MODE = Boolean.parseBoolean(Platform
			.getDebugOption("com.zeligsoft.base.licensing/debug")); //$NON-NLS-1$
	}
	
	/**
	 * Obtains the singleton license manager object.
	 * To be overridden in the inheriting class
	 * 
	 * @return the license manager
	 */
	static LicenseManager getInstance(){return null;}
	
	/**
	 * Checks the license status of a given client bundle.
	 * 
	 * @param bundle
	 *            the licensed client bundle to verify
	 * @param bundleName
	 *            the localized name to show for the bundle in the event of a
	 *            problem
	 * @param cancelOnError
	 * 			  if we should have an IStatus of severity cancel instead of error
	 * 			when failing checks
	 * 
	 * @return the status of the license check, which will either be OK on
	 *         success or an error status on failure to verify the license
	 */
	abstract IStatus check(Bundle bundle, String bundleName, boolean cancelOnError, String message, boolean notifyListeners);
	
	
	/**
	 * Lists all of the currently known features with a license
	 * 
	 * @return a list of all features with a license
	 */
	abstract List<String> listFeatures();
	
	
	protected void initializeUIListener() {
		Bundle uiBundle = Platform.getBundle("com.zeligsoft.base.licensing.ui"); //$NON-NLS-1$
		if ((uiBundle != null) && (uiBundle.getState() & BUNDLE_AVAILABLE) != 0) {
			try {
				@SuppressWarnings("unchecked")
				Class<? extends LicenseListener> clazz = (Class<? extends LicenseListener>) uiBundle
					.loadClass("com.zeligsoft.base.licensing.ui.internal.UILicenseListener"); //$NON-NLS-1$
				addLicenseListener(clazz.newInstance());
			} catch (Exception e) {
				// nothing to do
			}
		}
	}
	
	
	protected void notifyListeners(String bundleName, IStatus status, String message) {
		LicenseListener[] array;

		synchronized (listeners) {
			if (listeners.isEmpty()) {
				return;
			}

			array = listeners.toArray(new LicenseListener[listeners.size()]);
		}

		if (status.isOK()) {
			for (LicenseListener next : array) {
				try {
					next.licenseVerified(bundleName);
				} catch (Throwable t) {
					// cannot allow Errors to disrupt control
					error(Messages.LicenseManager_listenerFailed, t);
				}
			}
		} 
		//treat CANCEL and INFO status as the same for now for listeners- difference being that 
		//if we have a status of CANCEL, we will still throw a LicenseException when actually checking the license
		else if (status.getSeverity() == IStatus.INFO || status.getSeverity() == IStatus.CANCEL) {
			for (LicenseListener next : array) {
				try {
					next.licenseInfo(bundleName, status, message);
				} catch (Throwable t) {
					// cannot allow Errors to disrupt control
					error(Messages.LicenseManager_listenerFailed, t);
				}
			}
		}
		else {
			for (LicenseListener next : array) {
				try {
					next.licenseFailed(bundleName, status);
				} catch (Throwable t) {
					// cannot allow Errors to disrupt control
					error(Messages.LicenseManager_listenerFailed, t);
				}
			}
		}
	}
	
	public void notifyInvalidImport(String message) {
		LicenseListener[] array;

		synchronized (listeners) {
			if (listeners.isEmpty()) {
				return;
			}

			array = listeners.toArray(new LicenseListener[listeners.size()]);
		}
		
		for (LicenseListener next : array) {
			try {
				next.licenseImportFailed(message);
			} catch (Throwable t) {
				// cannot allow Errors to disrupt control
				error(Messages.LicenseManager_listenerFailed, t);
			}
		}
	}
	
	/**
	 * Adds the specified listener if it is not already attached to me.
	 * 
	 * @param l
	 *            a listener to add, if necessary
	 */
	public void addLicenseListener(LicenseListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l)) {
				listeners.add(l);
			}
		}
	}

	/**
	 * Removes the specified listener from me if it is attached to me.
	 * 
	 * @param l
	 *            a listener to remove, if necessary
	 */
	public void removeLicenseListener(LicenseListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}
	
	
	/**
	 * Obtains a handle to the license file.
	 * 
	 * @param licenseName
	 * 			The filename of the license to look for
	 * 
	 * @return the license file, or <code>null</code> if there is none
	 * 
	 * @throws IOException on any failure to obtain a path to the license file.
	 *   It does not mean that the file does not exist at the expected location
	 */
	protected File getLicenseFile(String licenseName) throws IOException {
		File license = getDevLicenseFile(licenseName);
		if (license == null) {
			license = getDefaultLicenseFile(licenseName);
		}
		return license;		
	}
	
	private File getDefaultLicenseFile(String licenseName) throws IOException {
		String path = null;
		URL resolved = FileLocator.toFileURL(new URL(
				"platform:/config/com.zeligsoft.base.licensing/"+licenseName)); //$NON-NLS-1$

		if (resolved != null) {
			resolved = FileLocator.toFileURL(resolved);
			
			if (resolved != null) {
				path = resolved.getPath();
			}
		}
		
		return (path == null)? null : new File(path);		
	}
	
	private File getDevLicenseFile(String licenseName) throws IOException {
		String path = null;
		URL resolved = FileLocator.find(Platform
			.getBundle("com.zeligsoft.base.licensing"), //$NON-NLS-1$
			new Path("/license/"), null); //$NON-NLS-1$

		if (resolved != null) {
			resolved = FileLocator.toFileURL(resolved);
			
			if (resolved != null) {
				path = resolved.getPath();
			}
		}
		
		return (path == null)? null : new File(path + licenseName);
	}
	
	
	/**
	 * Logs an error status for some exception.
	 * 
	 * @param message
	 *            a user-meaningful description of the context in which the
	 *            exception occurred
	 * @param t
	 *            the exception to log
	 */
	static void error(String message, Throwable t) {
		IStatus status;

		if (t instanceof LicenseException) {
			status = ((LicenseException) t).getStatus();
		} else {
			status = new Status(IStatus.ERROR,
				"com.zeligsoft.base.licensing", message, t); //$NON-NLS-1$
		}

		Platform.getLog(Platform.getBundle(status.getPlugin())).log(status);
	}
	
	
	/**
	 * Prints a debug message, if debugging is enabled.
	 * 
	 * @param message
	 *            the debug message
	 */
	static void debug(String message) {
		if (DEBUG_MODE) {
			System.out.println("[licensing] " + message); //$NON-NLS-1$
		}
	}

	
}
