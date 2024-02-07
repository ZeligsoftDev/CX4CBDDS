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
package org.eclipse.ocl.examples.debug.vm.launching;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.request.VMStartRequest;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;

public interface VMDebuggableExecutorAdapter {
	/**
	 * Connects this adapter to the debugger which will partipate in the
	 * execution process
	 * 
	 * @param debugShell
	 */
	void connect(@NonNull IVMDebuggerShell debugShell);

	/**
	 * Causes to run the executor behind this adapter
	 * 
	 * @return the status of finished execution
	 * @throws IllegalStateException
	 *             if this adapter is not connected to debugger
	 */
	Diagnostic execute(@NonNull VMStartRequest startRequest) throws IllegalStateException;

	/**
	 * Gets the main compiled unit to be executed
	 * @return the unit object
	 */
	@Nullable CompiledUnit getUnit();	
}