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
package org.eclipse.ocl.examples.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;

public class OCLLineBreakpoint extends VMLineBreakpoint
{  
    public static @NonNull OCLLineBreakpoint createRunToLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
    	return new OCLLineBreakpoint(sourceURI, lineNumber, true);
    }
    
    public static OCLLineBreakpoint getBreakpointByID(long id) {
    	for (OCLLineBreakpoint oclBreakpoint : OCLDebugCore.INSTANCE.getOCLBreakpoints(OCLLineBreakpoint.class)) {
			if (oclBreakpoint.getID() == id) {
				return oclBreakpoint;
			}
		}
    	
    	return null;
    }

    /* 
     * Remark: Keep the default constructor to allow the breakpoint manager to create breakpoint from markers
     */
    public OCLLineBreakpoint() {
    	super();
    }

    public OCLLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
		this(sourceURI, lineNumber, false);
	}
    
    private OCLLineBreakpoint(@NonNull URI sourceURI, int lineNumber, boolean isRunToLine) throws CoreException {  
    	super(sourceURI, lineNumber, isRunToLine);
    }

	protected @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}
}