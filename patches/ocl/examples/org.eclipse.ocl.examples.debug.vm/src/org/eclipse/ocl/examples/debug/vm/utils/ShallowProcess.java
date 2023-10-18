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
package org.eclipse.ocl.examples.debug.vm.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.ocl.examples.debug.vm.DebugVMPlugin;
import org.eclipse.ocl.examples.debug.vm.messages.VMMessages;

public class ShallowProcess extends BaseProcess {
    public ShallowProcess(ILaunch launch, IRunnable r) {
        myLaunch = launch;
        myRunnable = r;
    }
    
    public void run() throws Exception {
        run(null);
    }
    
    public void run(IDebugTarget debugTarget) throws Exception {
        myLaunch.addProcess(this);
        try {
            if(debugTarget != null) {
                myLaunch.addDebugTarget(debugTarget);
            }
            myRunnable.run();
        }
        finally {
            myRunnable = null;
            if (DebugPlugin.getDefault() != null) {
                DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.TERMINATE)});
            }
        }
    }
    
    public String getLabel() {
        return VMMessages.ShallowProcess_Label;
    }

    public ILaunch getLaunch() {
        return myLaunch;
    }

    public void setAttribute(String key, String value) {
    }

    public String getAttribute(String key) {
        return null;
    }

    public int getExitValue() throws DebugException {
        if(!isTerminated()) {
            throw new DebugException(new Status(IStatus.ERROR, DebugVMPlugin.PLUGIN_ID, 1, VMMessages.ShallowProcess_InvalidState, null));
        }
        
        return 0;
    }

    public boolean canTerminate() {
        return !isTerminated();
    }

    public boolean isTerminated() {
        return myRunnable == null;
    }

    public void terminate() throws DebugException {
    }
    
    private final ILaunch myLaunch;
    private IRunnable myRunnable;
}
