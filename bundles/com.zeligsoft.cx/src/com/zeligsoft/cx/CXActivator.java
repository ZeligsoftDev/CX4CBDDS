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
package com.zeligsoft.cx;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;


public class CXActivator extends ZeligsoftAbstractPlugin {
	/** The plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.cx"; //$NON-NLS-1$

	// The shared instance
	private static CXActivator plugin;

	/**
	 * The constructor
	 */
	public CXActivator() {
		super();
	}

	@Override
	public void start(BundleContext context)
			throws Exception {
		
		super.start(context);
		plugin = this;
		initializePreferences();
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
	public static CXActivator getDefault() {
		return plugin;
	}

	@SuppressWarnings("deprecation")
	private void initializePreferences(){
		plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.GENERATE_IDL_COMMENT,
				CXPreferenceConstants.GENERATE_IDL_COMMENT_DEFAULT);
		plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.CDT_PROJECT_SUFFIX,
				CXPreferenceConstants.DEFAULT_CDT_PROJECT_SUFFIX);
		    plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.GENERATED_FILE_COMMENT,
				CXPreferenceConstants.DEFAULT_GENERATED_FILE_COMMENT);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.PREFERENCE_PORTTYPE_SUFFIX,
				CXPreferenceConstants.DEFAULT_PREFERENCE_PORTTYPE_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.MAKE_LOCATION,
				CXPreferenceConstants.DEFAULT_MAKE_LOCATION);

			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.COMPONENT_INTERFACE_SUFFIX,
				CXPreferenceConstants.DEFAULT_COMPONENT_INTERFACE_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.IMPLEMENTATION_SUFFIX,
				CXPreferenceConstants.DEFAULT_IMPLEMENTATION_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.PACKAGE_SUFFIX,
				CXPreferenceConstants.DEFAULT_PACKAGE_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.DIAGRAM_SUFFIX,
				CXPreferenceConstants.DEFAULT_DIAGRAM_SUFFIX);

			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.AUTO_CREATE_COMPONENT_INTERFACE,
				CXPreferenceConstants.DEFAULT_AUTO_CREATE_COMPONENT_INTERFACE);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.AUTO_CREATE_IMPLEMENTATION,
				CXPreferenceConstants.DEFAULT_AUTO_CREATE_IMPLEMENTATION);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.AUTO_CREATE_PACKAGE,
				CXPreferenceConstants.DEFAULT_AUTO_CREATE_PACKAGE);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.AUTO_CREATE_DIAGRAM,
				CXPreferenceConstants.DEFAULT_AUTO_CREATE_DIAGRAM);

			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.USE_DEFAULT_CI_SUFFIX,
				CXPreferenceConstants.DEFAULT_USE_DEFAULT_CI_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.USE_DEFAULT_IMPL_SUFFIX,
				CXPreferenceConstants.DEFAULT_USE_DEFAULT_IMPL_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.USE_DEFAULT_PKG_SUFFIX,
				CXPreferenceConstants.DEFAULT_USE_DEFAULT_PKG_SUFFIX);
			plugin.getPluginPreferences().setDefault(
				CXPreferenceConstants.USE_DEFAULT_DIAG_SUFFIX,
				CXPreferenceConstants.DEFAULT_USE_DEFAULT_DIAG_SUFFIX);
	}
}
