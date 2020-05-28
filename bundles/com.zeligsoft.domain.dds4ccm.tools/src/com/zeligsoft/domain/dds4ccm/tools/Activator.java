/**
 * Copyright 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.domain.dds4ccm.tools;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.domain.dds4ccm.tools"; //$NON-NLS-1$

	/**
	 *  The shared instance.
	 */
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
		super();
	}

	@Override
	public void start(BundleContext context)
			throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context)
			throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Creates an IStatus and writes it to the log.
	 * 
	 * @param e The exception to log.
	 * @param message The message to write with the exception.
	 */
	public static void log(final Exception e, final String message) {
		IStatus status;

		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		} else {
			status = new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		}

		log(status);
	}

	/**
	 * Write a status to the log associated with this plugin.
	 * 
	 * @param status The status object to write to the log.
	 */
	public static void log(final IStatus status) {
		getDefault().getLog().log(status);
	}

	/**
	 * Retrieve a preference that is a boolean value.
	 * 
	 * @param key The identifier of the preference.
	 * @return The boolean value of the preference.
	 */
	public static boolean getBooleanPreference(final String key) {
		return getDefault().getPreferenceStore().getBoolean(key);
	}
	
	/**
	 * Set the value of a boolean preference.
	 * 
	 * @param key The identifier of the preference.
	 * @param value The boolean value to set the preference to.
	 */
	public static void setPreference(final String key, final boolean value) {
		getDefault().getPreferenceStore().setValue(key, value);
	}

}
