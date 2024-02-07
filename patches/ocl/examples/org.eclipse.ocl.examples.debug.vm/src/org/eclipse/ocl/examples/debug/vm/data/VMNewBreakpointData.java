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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public class VMNewBreakpointData extends VMBreakpointData
{
	private static final long serialVersionUID = -8614925057936040002L;

	private final long ID;
	private final int line;// = -1;
	private final @NonNull String targetURI;
	
	public VMNewBreakpointData(boolean conditionEnabled, @Nullable String condition, boolean conditionSuspendOnTrue, int hitCount,
			long id, int line, @NonNull String targetURI) {
		super(conditionEnabled, condition, conditionSuspendOnTrue, hitCount);
		this.ID = id;
		this.line = line;
		this.targetURI = targetURI;			
	}
	
	public VMNewBreakpointData(@NonNull VMBreakpointData data, long id, int line, @NonNull String targetURI) {
		super(data);
		this.ID = id;
		this.line = line;
		this.targetURI = targetURI;			
	}

	public long getID() {
		return ID;
	}

	public int getLine() {
		return line;
	}

	public @NonNull String getTargetURI() {
		return targetURI;
	}
}