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
package com.zeligsoft.base.licensing.ui;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	/** The plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.base.licensing.ui"; //$NON-NLS-1$
	
	private static BundleContext context;
	
	@Override
	public void start(BundleContext context)
			throws Exception {
		super.start(context);
		Activator.context = context;
	}

	@Override
	public void stop(BundleContext context)
			throws Exception {
		Activator.context = null;
		super.stop(context);
	}
	
	public static BundleContext getContext(){
		return context;
	}
}
