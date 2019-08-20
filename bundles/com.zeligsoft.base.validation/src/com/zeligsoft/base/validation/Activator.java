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
package com.zeligsoft.base.validation;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;
import com.zeligsoft.base.validation.links.LinkConstraintManager;
import com.zeligsoft.base.validation.links.ocl.OCLLinkConstraintFactory;
import com.zeligsoft.base.validation.provider.ZDLConstraintManager;
import com.zeligsoft.base.validation.provider.java.JavaConstraintFactory;
import com.zeligsoft.base.validation.provider.ocl.OCLConstraintFactory;
import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator
		extends ZeligsoftAbstractPlugin {

	/** This bundle's symbolic name. */
	public static final String PLUGIN_ID = "com.zeligsoft.base.validation"; //$NON-NLS-1$

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
		super.start(context);
		plugin = this;

		ZDLConstraintManager master = ZDLConstraintManager.getInstance();
		master.addConstraintFactory(new JavaConstraintFactory());
		master.addConstraintFactory(new OCLConstraintFactory());

		LinkConstraintManager linkMaster = LinkConstraintManager.getInstance();
		linkMaster.registerFactory(new OCLLinkConstraintFactory(
				LinkConstraintContext.DIAGRAM));
		linkMaster.registerFactory(new OCLLinkConstraintFactory(
			LinkConstraintContext.DEPLOYMENT));		
		linkMaster.registerFactory(new OCLLinkConstraintFactory(
				LinkConstraintContext.DEPLOYMENT_CONTAINER));
		linkMaster.registerFactory(new OCLLinkConstraintFactory(
				LinkConstraintContext.DEPLOYMENT_PART));
		linkMaster.registerFactory(new OCLLinkConstraintFactory(
				LinkConstraintContext.DEPLOYMENT_PART_CONFIGURE));
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
