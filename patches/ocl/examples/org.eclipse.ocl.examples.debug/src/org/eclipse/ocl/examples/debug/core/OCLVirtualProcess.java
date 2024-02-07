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
package org.eclipse.ocl.examples.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.launching.OCLLaunchConstants;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.core.VMVirtualProcess;

public class OCLVirtualProcess extends VMVirtualProcess
{
	public OCLVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm) {
		super(launch, vm);
	}

	public @NonNull String getLabel() {
		String debuggableURI = null;
		ILaunchConfiguration configuration = fLaunch.getLaunchConfiguration();
		if(configuration != null) {
			try {
				debuggableURI = configuration.getAttribute(OCLLaunchConstants.OCL_KEY, "");
			} catch (CoreException e) {
				OCLDebugCore.INSTANCE.log(e.getStatus());
			}
		}
		
		return debuggableURI != null ? debuggableURI : "OCL Process"; //$NON-NLS-1$
	}
}
