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

import org.eclipse.ocl.pivot.evaluation.EvaluationHaltedException;

/**
* Represents a runtime (unchecked) exception possibly thrown during OCL code execution.
*/
public class VMRuntimeException extends EvaluationHaltedException {

	private static final long serialVersionUID = -8903219155434276631L;
	
	private List<VMStackTraceElement> fVMStackTrace;
	
	
	public VMRuntimeException() {
		this(null,null);
	}	
	
	public VMRuntimeException(String message) {
		this(message,null);
	}
		
	public VMRuntimeException(Exception cause) {
		this(null,cause);
	}

	public VMRuntimeException(String message, Exception cause) {
		super(message, cause);
	}	
		
    public void printVMStackTrace(PrintWriter pw) {
       synchronized (pw) {
            pw.println(this);
            printVMStackTrace(pw, getVMStackTrace());
       }
    }
    
    public static void printVMStackTrace(PrintWriter pw, List<? extends IVMStackTraceElement> elements) {
        synchronized (pw) {
             int counter = 0;
             for(IVMStackTraceElement trace : elements) {
             	if(counter++ > 0) {
             		pw.println();
             	}
             	pw.print("\tat " + trace); //$NON-NLS-1$
             }
        }
     }    
	
	public List<VMStackTraceElement> getVMStackTrace() {		
		if(fVMStackTrace != null) {
			return Collections.unmodifiableList(fVMStackTrace);
		}
		return Collections.emptyList();
	}
	
	public void setStackVMTrace(List<VMStackTraceElement> stackTrace) {
		if(fVMStackTrace != null) {
			throw new IllegalStateException("Can't reassign stack elements"); //$NON-NLS-1$
		}
		
		fVMStackTrace = null;
		if(stackTrace != null) {
			fVMStackTrace = new ArrayList<VMStackTraceElement>(stackTrace);
		}
	}		
}
