/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.plugin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;

/**
 * @author prismtech
 *
 */
public class ZDLGenPlugin extends ZeligsoftAbstractPlugin implements BundleActivator {

	
	/** The plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.ddk.zdl.zdlgen"; //$NON-NLS-1$

	// The shared instance
	private static ZDLGenPlugin plugin;

	/**
	 * The constructor
	 */
	public ZDLGenPlugin() {
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
	public static ZDLGenPlugin getDefault() {
		return plugin;
	}
}
