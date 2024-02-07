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

public class VMStartRequest extends VMRequest
{
	private static final long serialVersionUID = -3733108336049294291L;

	public final boolean suspendOnStartup;
	
	public VMStartRequest(boolean suspendOnStartup) {
		super();
		this.suspendOnStartup = suspendOnStartup;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "(suspendOnStartup=" + suspendOnStartup + ")";
	}
}
