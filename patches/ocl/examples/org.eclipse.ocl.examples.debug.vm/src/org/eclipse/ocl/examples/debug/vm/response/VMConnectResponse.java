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

public class VMConnectResponse extends VMResponse
{
	private static final long serialVersionUID = -5645434708867846363L;

	private final int fEventPort;
	
	public VMConnectResponse(int eventPort) {
		fEventPort = eventPort;
	}
	
	public int getEventPort() {
		return fEventPort;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toStatusString(status) + ", " + fEventPort + ")";  //$NON-NLS-1$
	}
}