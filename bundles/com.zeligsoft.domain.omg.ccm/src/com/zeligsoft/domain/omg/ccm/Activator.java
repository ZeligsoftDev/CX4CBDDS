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
package com.zeligsoft.domain.omg.ccm;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends ZeligsoftAbstractPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.domain.omg.ccm"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		initPreferences();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	

	@SuppressWarnings("deprecation")
	private void initPreferences() {
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.EXPECTED_COMPONENT_SUFFIX,
				CCMPreferenceConstants.DEFAULT_EXPECTED_COMPONENT_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.ASSEMBLY_IMPLEMENTATION_SUFFIX,
				CCMPreferenceConstants.DEFAULT_ASSEMBLY_IMPLEMENTATION_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.MONOLITHIC_IMPLEMENTATION_SUFFIX,
				CCMPreferenceConstants.DEFAULT_MONOLITHIC_IMPLEMENTATION_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.IMPLEMENTATION_SUFFIX,
				CCMPreferenceConstants.DEFAULT_IMPLEMENTATION_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.PACKAGE_SUFFIX,
				CCMPreferenceConstants.DEFAULT_PACKAGE_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.SUBPACKAGE_NAME_CONSTANT ,
				CCMPreferenceConstants.DEFAULT_SUBPACKAGE_NAME_CONSTANT);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.DIAGRAM_SUFFIX,
				CCMPreferenceConstants.DEFAULT_DIAGRAM_SUFFIX);
		plugin.getPluginPreferences().setDefault(
				CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG,
				CCMPreferenceConstants.DEFAULT_AUTO_TYPE_SELECTION_DIALOG);
	}
}
