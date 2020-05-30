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
package com.zeligsoft.cx.ui;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class ZeligsoftCXUIPlugin
		extends ZeligsoftAbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.cx.ui"; //$NON-NLS-1$

	// Port type extension point
	public static final String PORT_TYPE_EXTPT = "portTypeWizard"; //$NON-NLS-1$
	
	// Workflow Override extension point
	public static final String WORKFLOW_OVERRIDE_EXTPT = "workflowOverride"; //$NON-NLS-1$

	// The shared instance
	private static ZeligsoftCXUIPlugin plugin;

	/**
	 * The constructor
	 */
	public ZeligsoftCXUIPlugin() {
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
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ZeligsoftCXUIPlugin getDefault() {
		return plugin;
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
