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

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A VMResponse is set by the VM to respond to a VMRequest.
 */
public class VMResponse implements Serializable
{
	private static final long serialVersionUID = 8136163293629606805L;

	public static final int STATUS_OK = 0;
	public static final int STATUS_ERROR = 1;
	
	public static @NonNull VMResponse createERROR() {
		return new VMResponse(STATUS_ERROR);
	}
	
	public static @NonNull VMResponse createOK() {
		return new VMResponse();
	}

	public static @NonNull String toStatusString(int status) {
		switch (status) {
		case STATUS_OK: return "OK";
		case STATUS_ERROR: return "ERROR";
		}
		return "???";
	}
	
	public final int status;
	
	protected VMResponse() {
		this(STATUS_OK);
	}
	
	protected VMResponse(int status) {
		this.status = status;
	}
		
	public boolean isOK() {
		return status == STATUS_OK;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toStatusString(status) + ")";
	}
}