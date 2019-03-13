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
package com.zeligsoft.base.zdl.oaw;

/**
 * An exception indicating that ZDL models are currently unavailable. Usually
 * results either from interruption of the job that scans the workspace for ZDL
 * models, or from some kind of problem in analyzing the Java classpath.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("serial")
public class ZDLsNotAvailableException
		extends Exception {

	/**
	 * Initializes me with a user-friendly message.
	 * 
	 * @param message
	 *            my user-friendly message
	 */
	public ZDLsNotAvailableException(String message) {
		super(message);
	}

	/**
	 * Initializes me with a user-friendly message and an exception that
	 * triggered me.
	 * 
	 * @param message
	 *            my user-friendly message
	 * @param cause
	 *            my cause
	 */
	public ZDLsNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

}
