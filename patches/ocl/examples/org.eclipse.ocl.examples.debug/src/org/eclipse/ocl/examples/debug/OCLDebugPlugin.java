/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.BundleContext;

public class OCLDebugPlugin extends Plugin
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.examples.debug";
	
	private static OCLDebugPlugin plugin;

	public static OCLDebugPlugin getDefault() {
		return plugin;
	}

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
//		CompleteOCLASResourceFactory.getInstance();		// FIXME An extension point should do this
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}
}
