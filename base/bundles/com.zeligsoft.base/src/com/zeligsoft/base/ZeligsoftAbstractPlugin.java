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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

/**
 * Base error handling class. All Zeligsoft's non UI contribution Plug-ins
 * should extend this class to make use of error handling tools.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public abstract class ZeligsoftAbstractPlugin
		extends Plugin {

	/**
	 * Write error log
	 * 
	 * @param plugin
	 *            source plug-in
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public static void error(Plugin plugin, String message, Throwable e) {
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

	/**
	 * Write error log
	 * 
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public void error(String message, Throwable e) {
		error(this, message, e);
	}

	/**
	 * Write warning log
	 * 
	 * @param plugin
	 *            source plug-in
	 * @param message
	 *            human readable message for this exception cause
	 * @param e
	 *            Exception thrown
	 */
	public static void warning(Plugin plugin, String message, Throwable e) {
		Status status;
		if (e == null) {
			status = new Status(IStatus.WARNING, plugin.getBundle()
				.getSymbolicName(), message);
		} else {
			status = new Status(IStatus.WARNING, plugin.getBundle()
				.getSymbolicName(), IStatus.WARNING, message
				+ "(" + e.getStackTrace()[0].getClassName() + ")", e); //$NON-NLS-1$//$NON-NLS-2$
		}
		plugin.getLog().log(status);
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
		warning(this, message, e);
	}

	/**
	 * Write warning log to the workbench
	 * 
	 * @param message
	 *            Warning message
	 */
	public void warning(String message) {
		warning(this, message, null);
	}
}
