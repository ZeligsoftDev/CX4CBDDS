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
package org.eclipse.ocl.examples.debug.vm;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class BreakpointError extends Status {
	
	public static final int BREAKPOINT_CONDITION_ERR = 200;
	
	private long fBreakpointID;
	private String fDetail;
	
	public BreakpointError(long breakpointID, String message, String detail) {
		super(IStatus.ERROR, DebugVMPlugin.PLUGIN_ID, BREAKPOINT_CONDITION_ERR, message, null);
		
		fBreakpointID = breakpointID;
		fDetail = detail;
	}
	
	public long getfBreakpointID() {
		return fBreakpointID;
	}
	
	public String getDetail() {
		return fDetail;
	}
}
