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
package org.eclipse.ocl.examples.debug.vm.data;

import java.io.Serializable;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.jdt.annotation.NonNull;

/**
 * VMSuspension codes the accompanying detail for a VMResumeRequest or VMSuspendEvent.
 */
public class VMSuspension implements Serializable
{
	private static final long serialVersionUID = -2766529485709163635L;
	
	public static final @NonNull VMSuspension UNSPECIFIED = new VMSuspension(DebugEvent.UNSPECIFIED);
	public static final @NonNull VMSuspension STEP_INTO = new VMSuspension(DebugEvent.STEP_INTO);
	public static final @NonNull VMSuspension STEP_OVER = new VMSuspension(DebugEvent.STEP_OVER);
	public static final @NonNull VMSuspension STEP_RETURN = new VMSuspension(DebugEvent.STEP_RETURN);
	public static final @NonNull VMSuspension STEP_END = new VMSuspension(DebugEvent.STEP_END);
	public static final @NonNull VMSuspension BREAKPOINT = new VMSuspension(DebugEvent.BREAKPOINT);
	public static final @NonNull VMSuspension BREAKPOINT_CONDITION_ERR = new VMSuspension(DebugEvent.MODEL_SPECIFIC + 10);		// FIXME Irregular

	private final int detail;

	private VMSuspension(int detail) {
		this.detail = detail;
	}

	/**
	 * Return the underlying framework DebugEvent detail for the suspension.
	 */
	public int getDebugEventDetail() {
		return detail;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		toString(s);
		return s.toString();
	}

	public void toString(@NonNull StringBuilder s) {
		String prefix = "";
		if ((detail & DebugEvent.STEP_INTO) != 0) {
			s.append(prefix); s.append("STEP_INTO");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_OVER) != 0) {
			s.append(prefix); s.append("STEP_OVER");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_RETURN) != 0) {
			s.append(prefix); s.append("STEP_RETURN");
			prefix = "+";
		}
		if ((detail & DebugEvent.STEP_END) != 0) {
			s.append(prefix); s.append("STEP_END");
			prefix = "+";
		}
		if ((detail & DebugEvent.BREAKPOINT) != 0) {
			s.append(prefix); s.append("BREAKPOINT");
			prefix = "+";
		}
		if (prefix.equals("")) {
			s.append("UNSPECIFIED");
		}
	}
}