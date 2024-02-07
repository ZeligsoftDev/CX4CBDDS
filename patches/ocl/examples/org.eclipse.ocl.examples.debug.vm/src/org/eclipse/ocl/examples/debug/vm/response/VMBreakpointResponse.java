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
package org.eclipse.ocl.examples.debug.vm.response;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public class VMBreakpointResponse extends VMResponse
{
	private static final long serialVersionUID = -8865684549088598599L;

	private long[] fAddedBreakpointsIDs;
	
	public VMBreakpointResponse() {
		super();
	}

	public VMBreakpointResponse(@NonNull List<Long> addedBreakpointIDs) {
		if(addedBreakpointIDs == null || addedBreakpointIDs.contains(null)) {
			throw new IllegalArgumentException("invalid installed breakpoints"); //$NON-NLS-1$
		}
		
		fAddedBreakpointsIDs = new long[addedBreakpointIDs.size()];
		int i = 0;
		for (Long id : addedBreakpointIDs) {
			fAddedBreakpointsIDs[i++] = id.longValue();
		}
	}

	public long[] getAddedBreakpointsIDs() {
		return fAddedBreakpointsIDs != null ? fAddedBreakpointsIDs.clone() : new long[0];
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		s.append(", {");
		for (int i = 0; i < fAddedBreakpointsIDs.length; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append(fAddedBreakpointsIDs[i]);
		}
		s.append("}");
		return s.toString();
	}
}