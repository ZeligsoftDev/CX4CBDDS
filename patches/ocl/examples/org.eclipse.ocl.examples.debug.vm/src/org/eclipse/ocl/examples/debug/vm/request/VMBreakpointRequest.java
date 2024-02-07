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
package org.eclipse.ocl.examples.debug.vm.request;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;

public class VMBreakpointRequest extends VMRequest
{
	private static final long serialVersionUID = -1085845926381930847L;

	public static enum ActionKind {
		ADD,
		REMOVE,
		CHANGE
	}	
	
	public static @NonNull VMBreakpointRequest createAdd(@NonNull VMNewBreakpointData bpData) {
		return new VMBreakpointRequest(-1, new @NonNull VMNewBreakpointData @NonNull [] { bpData }, ActionKind.ADD);
	}	

	public static @NonNull VMBreakpointRequest createAdd(@NonNull VMNewBreakpointData @Nullable  [] bpData) {
		return new VMBreakpointRequest(-1, bpData, ActionKind.ADD);
	}

	public static @NonNull VMBreakpointRequest createChange(long id, @NonNull VMBreakpointData bpData) {
		return new VMBreakpointRequest((long)-1, new @NonNull VMBreakpointData @NonNull [] { bpData }, ActionKind.CHANGE);
	}	
	
	public static @NonNull VMBreakpointRequest createRemove(long id) {
		return new VMBreakpointRequest(id, null, ActionKind.REMOVE);
	}
	
	private final long fBreakpointID;
	private final @NonNull ActionKind actionKind;	
	private final @NonNull VMBreakpointData data @Nullable [];
	
	private VMBreakpointRequest(long uniqueID, @NonNull VMBreakpointData data @Nullable [], @NonNull ActionKind actionKind) {
		this.fBreakpointID = uniqueID;
		this.data = data;
		this.actionKind = actionKind;
	}
	
	public long getBreakpointID() {
		return fBreakpointID;
	}

	public @NonNull ActionKind getActionKind() {
		return actionKind;
	}
	
	public List<VMBreakpointData> getBreakpointData() {
		VMBreakpointData[] data2 = data;
		if (data2 != null) {
			return Collections.unmodifiableList(Arrays.asList(data2));
		}
		else {
			return Collections.emptyList();
		}
	}
	
	public @Nullable VMBreakpointData getFirstBreakpointData() {
		VMBreakpointData[] data2 = data;
		return data2 != null && data2.length > 0 ? data2[0] : null;
	}
	
	@Override
	public String toString() {	
		return getClass().getSimpleName() + "(fBreakpointID:" + fBreakpointID + " action:" + actionKind + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}