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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.VMEventListener;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMSuspension;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMSuspendEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMResumeRequest;

public class VMThread extends VMDebugElement implements IThread, VMEventListener {

	private List<VMStackFrame> fFrames;
	private List<VMStackFrameData> fUnderlyingFrames;
	
	private VMStackFrameData fLastSuspendedFrame;
	private boolean fIsStepping; 
	
	public VMThread(IVMDebugTarget target) {
		super(target);
		
		fFrames = new ArrayList<VMStackFrame>();
		fIsStepping = false;
		
		target.addVMEventListener(this);
		
		fireCreationEvent();
	}
		
	public boolean isDeferredExecution() {
		// TODO
		return false;
	}
	        
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}
	
	public IStackFrame[] getStackFrames() throws DebugException {
		if(isSuspended()) {
			if(fFrames.size() == 0) {
				fillFrames();
			}
		}
		
		return fFrames.toArray(new VMStackFrame[fFrames.size()]);
	}

	public @NonNull VMDebugCore getDebugCore() {
		return getOCLDebugTarget().getDebugCore();
	}
	
	public int getPriority() throws DebugException {
		return 0; // not it use at the moment //myWorker.getPriority();
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		if(!hasStackFrames()) {
			return null;
		}
		
		IStackFrame[] frames = getStackFrames();
		return frames.length > 0 ? frames[0] : null;
	}

	public String getName() throws DebugException {
		// no underlying thread ID
		return "OCLThread"; //$NON-NLS-1$  
	}

	public IBreakpoint[] getBreakpoints() {
		IBreakpoint[] hostBreakpoints = new IBreakpoint[0];
		// FIXME  - add suspedendedBy(IBreakpoint); to be called by the debugger
		return hostBreakpoints;
	}

	public boolean canResume() {
		return isSuspended();
	}

	public boolean canSuspend() {
		return !isSuspended();
	}

	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	public void resume() throws DebugException {
		setStepping(false);		
		getDebugTarget().resume();
		fireResumeEvent(DebugEvent.CLIENT_REQUEST);
	}

	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	public boolean canStepInto() {
		return isSuspended();
	}
	
	public void stepInto() throws DebugException {
		if(!canStepInto()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_INTO);

		getOCLDebugTarget().sendRequest(new VMResumeRequest(VMSuspension.STEP_INTO));
	}

	public boolean canStepOver() {
		return isSuspended();
	}
	
	public void stepOver() throws DebugException {
		if(!canStepOver()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_OVER);

		getOCLDebugTarget().sendRequest(new VMResumeRequest(VMSuspension.STEP_OVER));
	}

	public boolean canStepReturn() {
		return isSuspended();
	}
	
	public void stepReturn() throws DebugException {
		if(!canStepReturn()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_RETURN);

		getOCLDebugTarget().sendRequest(new VMResumeRequest(VMSuspension.STEP_RETURN));
	}

	public boolean isStepping() {
		return fIsStepping;
	}
	
	private void setStepping(boolean isStepping) {
		fIsStepping = isStepping;
	}

	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	public void terminate() throws DebugException {
		getDebugTarget().terminate();
		fFrames.clear();
	}
    	
	public void handleEvent(VMEvent event) {
		if(event instanceof VMSuspendEvent) {
			VMSuspendEvent suspendEvent = (VMSuspendEvent) event;
 			
			if(!isStepping()) {
				fFrames.clear();
			} else {				

				VMStackFrameData suspendedAtLocation = suspendEvent.stackFrames[0];
				
				if(fLastSuspendedFrame != null && suspendedAtLocation != null &&					
					suspendedAtLocation.id == fLastSuspendedFrame.id && !fFrames.isEmpty()) {
					fFrames.get(0).setLocation(suspendedAtLocation);
				} else {
					// stepped across stack frames since the last suspended
					fFrames.clear();
				}				
			}
			
			fUnderlyingFrames = Arrays.asList(suspendEvent.stackFrames);			
			
			setStepping(false);

			DebugEvent debugEvent = new DebugEvent(this, DebugEvent.SUSPEND, suspendEvent.suspension.getDebugEventDetail());
			debugEvent.setData(suspendEvent.location);
	        fireEvent(debugEvent);
		}
	}

	private void fillFrames() {
		if(fUnderlyingFrames == null) {
			return;
		}
		for (VMStackFrameData frame : fUnderlyingFrames) {
			if (frame != null) {
				fFrames.add(new VMStackFrame(this, frame));
			}
		}
		
		if(!fUnderlyingFrames.isEmpty()) {
			fLastSuspendedFrame = fUnderlyingFrames.get(0);
		}
	}
	
}
