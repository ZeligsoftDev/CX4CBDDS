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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;

public class VMStackFrameResponse extends VMResponse
{
	private static final long serialVersionUID = -731807514003839012L;

	public final @NonNull VMStackFrameData @Nullable [] frames;
	public final @NonNull VMVariableData @Nullable [] variables;
	public boolean isDeferredExecution;
	
	public VMStackFrameResponse(@NonNull VMStackFrameData frame) {
		this(new @NonNull VMStackFrameData @NonNull [] { frame });
	}

	public VMStackFrameResponse(@NonNull VMStackFrameData @NonNull [] frames) {
		this.frames = frames; 
		this.variables = null;
	}
	
	public VMStackFrameResponse(@NonNull VMVariableData @NonNull [] variables) {
		this.variables = variables;
		this.frames = null;
	}
	
	public @Nullable VMStackFrameData getFrame() {
		VMStackFrameData[] frames2 = frames;
		return frames2 != null && frames2.length > 0 ? frames2[0] : null;
	}
	
	public boolean isDeferredExecution() {
		return isDeferredExecution;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		VMStackFrameData[] frames2 = frames;
		if (frames2 != null) {
			s.append(", {");
			for (int i = 0; i < frames2.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(frames2[i]);
			}
			s.append("}");
		}
		VMVariableData[] variables2 = variables;
		if (variables2 != null) {
			s.append(", {");
			for (int i = 0; i < variables2.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(variables2[i]);
			}
			s.append("}");
		}
		s.append(", deferred = " + isDeferredExecution);
		return s.toString();
	}
}