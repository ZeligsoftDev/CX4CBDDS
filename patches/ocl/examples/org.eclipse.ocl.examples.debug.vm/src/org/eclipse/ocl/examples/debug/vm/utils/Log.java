/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.utils;

/**
 * A log interface is used to log messages along with parameter data. A particular 
 * logging level may be specified for additional filtering capability.
 * It provides a simple logger functionality as required by the ImperativeOCL::LogExp,
 * which is intended the main client to this interface.
 * 
 * @author dvorak
 */
public interface Log {
	/**
	 * The <code>null</code> log instance, which has no real receiver of the 
	 * logged entries.
	 */
	Log NULL_LOG = new Log() {
		
		public void log(int level, String message) {
			// do nothing;
		}
		
		public void log(int level, String message, Object param) {
			// do nothing;
		}
		
		
		public void log(String message) {
			// do nothing;
		}
		
		public void log(String message, Object param) {
			// do nothing;			
		}		
	};
	
	/**
	 * Logs a message with additional parameter at the specified logging level.
	 * 
	 * @param level
	 *            the level value to which the resulting log record should apply
	 * @param message
	 *            the textual message to be logged
	 * @param param
	 *            the parameter object to the message
	 */
	void log(int level, String message, Object param);
	
	/**
	 * Logs a message at the specified logging level.
	 * 
	 * @param level
	 *            the level value to which the resulting log record should apply
	 * @param message
	 *            the textual message to be logged
	 */	
	void log(int level, String message);
	
	/**
	 * Logs a message with additional parameter.
	 * 
	 * @param message
	 *            the textual message to be logged
	 * @param param
	 *            the parameter object to the message
	 */	
	void log(String message, Object param);
	
	/**
	 * Logs a message.
	 * 
	 * @param message
	 *            the textual message to be logged
	 */		
	void log(String message);	
}
