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
package com.zeligsoft.domain.sca.example.installer;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExampleInstallerPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.domain.sca.example.installer"; //$NON-NLS-1$

	// The shared instance
	public static final ExampleInstallerPlugin INSTANCE = new ExampleInstallerPlugin();
	
	/**
	 * The constructor
	 */
	protected ExampleInstallerPlugin() {
	}


	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExampleInstallerPlugin getDefault() {
		return INSTANCE;
	}
	
	public void log(Object logEntry) {
		// TODO : Add implementation for logging. 
	}

}
