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
package com.zeligsoft.cx.ui.properties;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator
		extends ZeligsoftAbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.cx.ui.properties"; //$NON-NLS-1$

	// Port type extension point
	public static final String PROPERTY_TAB_EXTPT = "propertyTab"; //$NON-NLS-1$

	// Custom property section extension point
	public static final String CUSTOM_PROPERTY_SECTION_EXTPT = "customPropertySection"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context)
			throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
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
	public static Activator getDefault() {
		return plugin;
	}

}
