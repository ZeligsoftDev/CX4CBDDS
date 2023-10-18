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

import java.io.Serializable;

import org.eclipse.jdt.annotation.Nullable;


public class VMStackFrameRequest extends VMRequest implements Serializable
{
	private static final long serialVersionUID = 7494309845104435913L;

	public final long frameID;
	
	public final @Nullable String variableURI;
	
	public VMStackFrameRequest(long frameID) {
		this(frameID, null);
	}
	
	public VMStackFrameRequest(long frameID, @Nullable String variableURI) {
		this.frameID = frameID;
		this.variableURI = variableURI;
	}
	
	public boolean rootVariablesRequest() {
		return variableURI == null;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "(" + frameID + ", " + variableURI + ")";
	}
}
