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
package com.zeligsoft.base.licensing;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/** 
 * We can't extend the ZeligsoftAbstractPlugin as com.zeligsoft.base depends on us.
 * Instead, we re-implement the error logging functionality as that's all we really need
 * 
 * @author mtate
 */
public class Activator extends Plugin{

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.base.licensing"; //$NON-NLS-1$

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
	}

	@Override
	public void stop(BundleContext context)
			throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Write to the error log
	 * 
	 * @param plugin
	 *            source plug-in
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public static void error(String message, Throwable e) {
		Status status;
		if (e == null) {
			status = new Status(IStatus.ERROR, plugin.getBundle()
				.getSymbolicName(), message);
		} else {
			status = new Status(IStatus.ERROR, plugin.getBundle()
				.getSymbolicName(), IStatus.ERROR, message
				+ "(" + e.getStackTrace()[0].getClassName() + ")", e); //$NON-NLS-1$//$NON-NLS-2$
		}
		plugin.getLog().log(status);
	}
}
