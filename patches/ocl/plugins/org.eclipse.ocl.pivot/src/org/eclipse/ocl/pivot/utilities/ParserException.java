/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * Exception indicating a failure to parse or validate OCL constraints.
 * Since the 1.2 release, the parser exception includes also a {@link Diagnostic}
 * carrying details of the one or more parse problems.
 * 
 * @author Christian Vogt (cvogt)
 */
public class ParserException extends Exception {

	private static final long serialVersionUID = -4457105668114213310L;

	private final Diagnostic diagnostic;
	
	/**
	 * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
	 * 
	 * @param msg the exception message
	 */
	public ParserException(String msg) {
		this(null, msg);
	}
	public ParserException(String messageTemplate, Object... bindings) {
		this(null, StringUtil.bind(messageTemplate, bindings));
	}

    /**
     * Initializes me with a message and an exception that caused the parse
     * failure.
     * 
     * @param msg my user-friendly message
     * @param cause the cause of the parse failure
     */
	public ParserException(Throwable cause, String msg) {
		super(msg, cause);
		
		diagnostic = createDiagnostic(msg);
	}
	public ParserException(Throwable cause, String messageTemplate, Object... bindings) {
		this(cause, StringUtil.bind(messageTemplate, bindings));
	}
	
	/**
	 * Initializes me with a diagnostic obtained from a problem handler.
	 * 
	 * @param problem the diagnostic
	 */
	public ParserException(Diagnostic problem) {
		super(problem.getMessage());
		
		this.diagnostic = problem;
	}
	
	/**
	 * Obtains the diagnostic describing one or more parse problems that I
	 * signal.
	 * 
	 * @return the diagnostic, which may be a chain of multiple problems or
	 * even just an "OK" diagnostic indicating an absence of parse problems
	 */
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
	
	/**
	 * Creates a default diagnostic for construction of an exception with just
	 * a message.
	 * 
	 * @param message the message
	 * @return a diagnostic
	 */
	private Diagnostic createDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.ERROR, PivotPlugin.PLUGIN_ID,
			StatusCodes.ERROR, message, null);
	}
}
