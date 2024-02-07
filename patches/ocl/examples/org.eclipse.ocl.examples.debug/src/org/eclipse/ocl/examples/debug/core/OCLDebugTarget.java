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

import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;

public class OCLDebugTarget extends VMDebugTarget
{
	public OCLDebugTarget(IProcess process, IVMVirtualMachineShell vm) {
		super(process, vm);
	}

	@Override
	public @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}

	@Override
	public @NonNull String getModelIdentifier() {
		return getDebugCore().getModelId();
	}
}
