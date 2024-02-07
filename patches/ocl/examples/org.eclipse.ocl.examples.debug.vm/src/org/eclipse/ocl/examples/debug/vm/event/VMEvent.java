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
package org.eclipse.ocl.examples.debug.vm.event;

import java.io.Serializable;

/**
 * VMEvents are sent by the VM to announce some occurence, such as suspension at a breakpoint or termination.
 */
public abstract class VMEvent implements Serializable
{
	private static final long serialVersionUID = 7444073052177307234L;

	protected VMEvent() {
		super();
	}
	
	public String toString() {
		return getClass().getSimpleName() + "()";
	}
}