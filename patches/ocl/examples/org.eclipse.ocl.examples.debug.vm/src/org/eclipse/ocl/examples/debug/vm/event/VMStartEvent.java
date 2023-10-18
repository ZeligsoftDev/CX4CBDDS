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

import org.eclipse.jdt.annotation.NonNull;

public class VMStartEvent extends VMEvent
{
	private static final long serialVersionUID = -3472484933976352536L;

	public final @NonNull String mainModuleName;
	public final boolean suspendOnStartup;
	
	public VMStartEvent(@NonNull String mainModuleName, boolean suspendOnStartup) {
		this.mainModuleName = mainModuleName;
		this.suspendOnStartup = suspendOnStartup;
	}
	
	public String toString() {
		return getClass().getSimpleName() + "(" + mainModuleName + ", suspendOnStartup=" + suspendOnStartup + ")";
	}
}