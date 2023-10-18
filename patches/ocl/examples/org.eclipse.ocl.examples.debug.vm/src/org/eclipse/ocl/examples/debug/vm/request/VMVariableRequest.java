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

import org.eclipse.jdt.annotation.NonNull;

public class VMVariableRequest extends VMRequest implements Serializable
{
	private static final long serialVersionUID = 5127428629243920154L;

	public final @NonNull String variableURI;
	public final long frameID;
	public final boolean includeChildVars;
	
	public VMVariableRequest(long frameID, @NonNull String variableURI, boolean includeChildVars) {
		this.frameID = frameID;
		this.variableURI = variableURI;
		this.includeChildVars = includeChildVars;
	}
	
	public VMVariableRequest(long frameID, @NonNull String variableURI) {
		this(frameID, variableURI, false);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + frameID + "," + variableURI + ", " + includeChildVars + ")";
	}
}
