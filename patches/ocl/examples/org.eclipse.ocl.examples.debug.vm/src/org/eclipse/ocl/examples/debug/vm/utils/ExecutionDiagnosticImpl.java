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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;

public class ExecutionDiagnosticImpl extends BasicDiagnostic implements ExecutionDiagnostic
{
	public static final ExecutionDiagnosticImpl OK_INSTANCE = new ExecutionDiagnosticImpl(
			Diagnostic.OK, 0, "OK", null); //$NON-NLS-1$

	private List<IVMStackTraceElement> fStackTrace;

	public ExecutionDiagnosticImpl(int severity, int code, String message, Object[] data) {
		super(severity, SOURCE, code, message, data);
	}

	public ExecutionDiagnosticImpl(int severity, int code, String message) {
		super(severity, SOURCE, code, message, null);
	}

	/**
	 * Gets the stack trace that resulted from interrupted execution either by
	 * user termination request or exception thrown
	 * 
	 * @return list of trace elements or an empty list
	 */
	public List<IVMStackTraceElement> getStackTrace() {
		return fStackTrace != null ? Collections.unmodifiableList(fStackTrace)
				: Collections.<IVMStackTraceElement> emptyList();
	}

	/**
	 * Prints the execution stack-trace (if available) of this diagnostic to the
	 * specified print writer.
	 * 
	 * @param writer
	 *            <code>PrintWriter</code> to use for output
	 */
	public void printStackTrace(PrintWriter writer) {
		if (fStackTrace != null) {
			VMRuntimeException.printVMStackTrace(writer, fStackTrace);
		}
	}

	public void setStackTrace(List<? extends IVMStackTraceElement> stackElements) {
		fStackTrace = new ArrayList<IVMStackTraceElement>(stackElements);
	}

}
