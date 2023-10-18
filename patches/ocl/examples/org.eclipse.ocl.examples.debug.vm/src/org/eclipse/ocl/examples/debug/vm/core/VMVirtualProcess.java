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
package org.eclipse.ocl.examples.debug.vm.core;

import java.io.IOException;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.request.VMTerminateRequest;

public abstract class VMVirtualProcess extends PlatformObject implements IProcess {

	protected final @NonNull ILaunch fLaunch;
	private final @NonNull IVMVirtualMachineShell fVM;
    private IStreamsProxy fStreamsPxy;	
	
	public VMVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm) {
		fLaunch = launch;
		fVM = vm;
		fLaunch.addProcess(this);
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}
	
    public IStreamsProxy getStreamsProxy() {
    	return fStreamsPxy;
    }	

	public abstract @NonNull String getLabel();

	public @NonNull ILaunch getLaunch() {
		return fLaunch;
	}

	public boolean isTerminated() {
		return fVM.isTerminated();
	}

	public void setAttribute(String key, String value) {
	}
	
	public void setStreamsProxy(@NonNull IStreamsProxy streamsProxy) {
		fStreamsPxy = streamsProxy;
	}
	
	public void terminate() throws DebugException {
		try {
			fVM.sendRequest(new VMTerminateRequest());
		} catch (IOException e) {
			throw new DebugException(fVM.getDebugCore().createDebugError("Process termination Failed", e));
		}			
	}
	
	protected void terminated() {
		DebugPlugin manager = DebugPlugin.getDefault();
		if (manager != null) {
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			manager.fireDebugEventSet(new DebugEvent[]{ event });
		}
	}
	
}
