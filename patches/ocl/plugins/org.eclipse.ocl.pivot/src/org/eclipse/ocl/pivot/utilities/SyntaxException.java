/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Exception indicating a syntax error in parsing OCL expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class SyntaxException
	extends ParserException {

   private static final long serialVersionUID = -2386296449957566297L;

	/**
     * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
     * 
     * @param msg the exception message
     */
	public SyntaxException(String msg) {
		super(null, msg);
	}
	
    /**
     * Initializes me with a message and an exception that caused the parse
     * failure.
     * 
     * @param msg my user-friendly message
     * @param cause the cause of the parse failure
     */
	public SyntaxException(String msg, Throwable cause) {
		super(cause, msg);
	}
	
	/**
	 * Initializes me with a diagnostic obtained from a problem handler.
	 * 
	 * @param problem the diagnostic
	 */
	public SyntaxException(Diagnostic problem) {
		super(problem);
	}
}
