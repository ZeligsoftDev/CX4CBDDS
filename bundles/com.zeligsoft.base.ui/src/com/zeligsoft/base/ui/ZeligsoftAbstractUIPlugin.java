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
package com.zeligsoft.base.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;

/**
 * Base error handling class. All Plug-ins that make contributions to the UI
 * should extend this class to make use of error handling tools.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class ZeligsoftAbstractUIPlugin
		extends AbstractUIPlugin {

	/**
	 * Write error log with the given exception
	 * 
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public void error(String message, Throwable e) {
		ZeligsoftAbstractPlugin.error(this, message, e);
	}

	/**
	 * Write warning log with the given exception
	 * 
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public void warning(String message, Throwable e) {
		ZeligsoftAbstractPlugin.warning(this, message, e);
	}

	/**
	 * Write warning log
	 * 
	 * @param message
	 *            Warning message
	 */
	public void warning(String message) {
		warning(message, null);
	}
}
