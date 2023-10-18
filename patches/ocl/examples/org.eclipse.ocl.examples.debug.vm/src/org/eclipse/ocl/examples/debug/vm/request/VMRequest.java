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

/**
 * VMRequests are sent to the VM to request some action such as StepInto or Variable report.
 * <p>
 * A VMRequest result in a synchronous VMResponse or an asynchronous VMEvent.
 */
public abstract class VMRequest implements Serializable
{
	private static final long serialVersionUID = 336624316734916662L;

	protected VMRequest() {
		super();
	}
	
	public String toString() {
		return getClass().getSimpleName() + "()";
	}
}