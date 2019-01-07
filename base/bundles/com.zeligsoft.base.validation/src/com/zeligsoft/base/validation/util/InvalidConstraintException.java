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
package com.zeligsoft.base.validation.util;


/**
 * Exception indicating that the definition of a constraint in a ZDL model
 * is invalid.  Either it specifies an unsupported language, or it is missing
 * some required metadata.
 *
 * @author Christian W. Damus (cdamus)
 */
public class InvalidConstraintException
		extends Exception {

	private static final long serialVersionUID = -4940453602542349702L;

	/**
	 * Initializes me with a message describing the problem.
	 * 
	 * @param message a human-readable and useful message
	 */
	public InvalidConstraintException(String message) {
		super(message);
	}

	/**
	 * Initializes me with a message describing the problem and an exception
	 * that caused the initialization of the constraint to fail.
	 * 
	 * @param message a human-readable and useful message
	 * @param cause the root cause
	 */
	public InvalidConstraintException(String message, Throwable cause) {
		super(message, cause);
	}

}
