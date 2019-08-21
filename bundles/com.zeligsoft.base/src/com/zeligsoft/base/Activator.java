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
package com.zeligsoft.base;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.licensing.LicenseCheck;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator
		extends ZeligsoftAbstractPlugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.base"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	@Override
	public void start(BundleContext context)
			throws Exception {
		
		LicenseCheck.require(context.getBundle(), PLUGIN_ID, "0.01", false, null); //$NON-NLS-1$
	
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
	public static Activator getDefault() {
		return plugin;
	}

}
