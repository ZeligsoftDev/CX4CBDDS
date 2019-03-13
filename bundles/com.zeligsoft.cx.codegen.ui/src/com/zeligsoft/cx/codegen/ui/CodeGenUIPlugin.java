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

package com.zeligsoft.cx.codegen.ui;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;


/**
 * The main plugin class to be used in the desktop.
 */
public class CodeGenUIPlugin
		extends ZeligsoftAbstractUIPlugin {

	public static final String PLUGIN_ID = "com.zeligsoft.cx.codegen.ui";//$NON-NLS-1$

	public static final String EDITSOURCE_M2MWORKFLOW_RELPATH = "workflow/m2m-edit-source.oaw"; //$NON-NLS-1$
	public static final String EDITSOURCE_M2TWORKFLOW_RELPATH = "workflow/m2t-edit-source.oaw"; //$NON-NLS-1$

	public static final String EDITSOURCE_EP_ID = "editsource"; //$NON-NLS-1$

	// The shared instance.
	private static CodeGenUIPlugin plugin;

	/**
	 * The constructor.
	 */
	public CodeGenUIPlugin() {
		super();
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static CodeGenUIPlugin getDefault() {
		return plugin;
	}
}
