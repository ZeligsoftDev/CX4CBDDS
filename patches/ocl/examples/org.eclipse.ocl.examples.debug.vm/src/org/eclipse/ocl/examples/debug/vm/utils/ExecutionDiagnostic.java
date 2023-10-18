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

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

public interface ExecutionDiagnostic extends Diagnostic {
	/**
	 * The execution was terminated by failed VM assertion.
	 */
	public static final int FATAL_ASSERTION = 100;

	/**
	 * The execution received user interruption request
	 */
	public static final int USER_INTERRUPTED = 110;

	public static final int EXCEPTION_THROWN = 120;

	public static final int VALIDATION = 130;

	public static final int MODEL_PARAMETER_MISMATCH = 140;

	public static final int TRANSFORMATION_LOAD_FAILED = 200;

	public static final String SOURCE = "org.eclipse.ocl.examples.debug.evaluation"; //$NON-NLS-1$

	public static final ExecutionDiagnostic OK_INSTANCE = ExecutionDiagnosticImpl.OK_INSTANCE;
	
	/**
	 * Gets the stack trace that resulted from interrupted execution either by
	 * user termination request or exception thrown
	 * 
	 * @return list of trace elements or an empty list
	 */
	public List<IVMStackTraceElement> getStackTrace();

	/**
	 * Prints the execution stack-trace (if available) of this diagnostic to the
	 * specified print writer.
	 * 
	 * @param writer
	 *            <code>PrintWriter</code> to use for output
	 */
	public void printStackTrace(PrintWriter writer);
}
