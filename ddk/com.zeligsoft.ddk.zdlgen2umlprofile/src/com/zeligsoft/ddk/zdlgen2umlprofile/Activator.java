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

package com.zeligsoft.ddk.zdlgen2umlprofile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * 
 * 
 * @author tmcclean
 *
 */
public class Activator extends AbstractUIPlugin {

	/** My plug-in ID. */
	public static final String PLUGIN_ID = "com.zeligsoft.ddk.zdlgen2umlprofile"; //$NON-NLS-1$
	
	//The shared instance.
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return my instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/**
	 * Logs the specified status object.
	 * 
	 * @param status a status to log
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

}
