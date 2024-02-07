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
package org.eclipse.ocl.examples.debug.vm.event;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMSuspension;

public class VMSuspendEvent extends VMEvent
{
	private static final long serialVersionUID = 2494519177689939386L;

	public @NonNull VMLocationData location;
	public @NonNull VMStackFrameData @NonNull [] stackFrames;
	public Long breakpointID;

	// TODO - currently using DebugEvent constants, OCL should define its own
	public final @NonNull VMSuspension suspension;
	
	public String reason;
	public String reasonDetail;

	public VMSuspendEvent(@NonNull VMStackFrameData @NonNull [] stack, @NonNull VMSuspension suspension) {
		if (stack.length == 0) {
			throw new IllegalArgumentException("empty stack"); //$NON-NLS-1$
		}
		
		this.stackFrames = stack;
		this.location = stack[0].getLocation();
		this.suspension = suspension;
	}
		
	public Long getBreakpointID() {
		return breakpointID;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getReasonDetail() {
		return reasonDetail;
	}
	
	public void setBreakpointID(Long breakpointID) {
		this.breakpointID = breakpointID;
	}
	
	public void setReason(String reason, String reasonDetail) {
		if(reason == null && reasonDetail != null) {
			throw new IllegalArgumentException();
		}
		this.reason = reason;
		this.reasonDetail = reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		this.reasonDetail = reasonDetail;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(");
		suspension.toString(s);
		if (breakpointID != null) {
			s.append(" breakpointID:").append(breakpointID); //$NON-NLS-1$
		}
		if (reason != null) {
			s.append(" reason:").append( //$NON-NLS-1$
					reason.substring(0, Math.min(50, reason.length())));
		}
		if (stackFrames != null) {
			s.append(", {");
			for (int i = 0; i < stackFrames.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(stackFrames[i]);
			}
			s.append("}");
		}
		s.append(")");
		return s.toString();
	}
}