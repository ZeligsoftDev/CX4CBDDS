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
package org.eclipse.ocl.examples.debug.vm;

import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;

/**
 * IVMVirtualMachineShell ,defines the very limited VMVirtualMachine API accessible from the main UI shell.
 */
public interface IVMVirtualMachineShell
{
	@NonNull VMDebugCore getDebugCore();

	boolean isTerminated();
	
	VMEvent readVMEvent() throws IOException;
	
	VMResponse sendRequest(@NonNull VMRequest request) throws IOException;
}
