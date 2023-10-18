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
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMLocationData;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.request.VMStackFrameRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMStackFrameResponse;

public class VMStackFrame extends VMDebugElement implements IStackFrame
{
	private final @NonNull VMThread fThread;
	private @NonNull VMStackFrameData fUnderlyingFrame;
	private boolean fDeferredExecution;	

	public VMStackFrame(@NonNull VMThread thread, @NonNull VMStackFrameData frame) {
		super(thread.getOCLDebugTarget());
		
		if(thread == null || frame == null) {
			throw new IllegalArgumentException();
		}

		fThread = thread;
		fUnderlyingFrame = frame;
	}

	public boolean canResume() {
		return getThread().canResume();
	}

	public boolean canStepInto() {
		return getThread().canStepInto();
	}

	public boolean canStepOver() {
		return getThread().canStepOver();
	}

	public boolean canStepReturn() {
		return getThread().canStepReturn();
	}

	public boolean canSuspend() {
		return getThread().canSuspend();
	}

	public boolean canTerminate() {
		return getThread().canTerminate();
	}

	public IValue evaluate(@NonNull String expressionText) throws CoreException {
		return ((VMDebugTarget) getOCLDebugTarget()).evaluate(expressionText, fUnderlyingFrame.id);
	}

	public int getCharEnd() throws DebugException {
//		 int endPos = getLocation().getElement().getEndPosition();
//		 return (endPos >= 0) ? endPos + 1 : -1;
		return getLocation().getCharEnd();
//		return -1;
	}

	public int getCharStart() throws DebugException {		
//		return getLocation().getElement().getStartPosition();
		return getLocation().getCharStart();
//		return -1;
	}
	
	public int getLineNumber() {
		return getLocation().getLineNum();
	}

	public VMLocationData getLocation() {
		return fUnderlyingFrame.getLocation();
	}

	public String getName() throws DebugException {
		int line = getLineNumber();
		String fileName = getUnitURI().lastSegment();
		return line < -1 ? fileName : fileName + "(" + line + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	public @NonNull IThread getThread() {
		return fThread;
	}
		
	public @NonNull URI getUnitURI() {
		return URI.createURI(getLocation().getURI());
	}
	
	public IVariable[] getVariables() throws DebugException {
		List<IVariable> result = new ArrayList<IVariable>();
		for (VMVariableData next : fUnderlyingFrame.getVisibleVariables()) {
			final VMVariableData vmVar = next;
			
			result.add(new VMVariable(getOCLDebugTarget(), vmVar, fUnderlyingFrame.id));
		}
		
		IVariable[] allVars = result.toArray(new IVariable[result.size()]);
		Arrays.sort(allVars, new Comparator<IVariable>() {
			public int compare(IVariable var1, IVariable var2) {
				try {
					String n1 = var1.getName();
					String n2 = var2.getName();
					if (n1 == null) n1 = "";
					if (n2 == null) n2 = "";
					return n1.compareTo(n2);
				} catch (DebugException e) {
					getDebugCore().log(e);
				}
				
				return 0;
			}
		});
		
		return allVars;
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public boolean hasVariables() throws DebugException {
		return !fUnderlyingFrame.getVisibleVariables().isEmpty();  
	}
	
	public boolean isDeferredExecution() {
		return fDeferredExecution;
	}	

	public boolean isStepping() {
		return getThread().isStepping();
	}

	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	VMStackFrameData requestStackFrame() throws DebugException {
		VMStackFrameData frame = null;
		
		VMStackFrameRequest frameRequest = new VMStackFrameRequest(fUnderlyingFrame.id);
		VMResponse response = getOCLDebugTarget().sendRequest(frameRequest);
		if(response instanceof VMStackFrameResponse) {
			VMStackFrameResponse stackFrameResponse = (VMStackFrameResponse) response;
			fDeferredExecution = stackFrameResponse.isDeferredExecution;
			frame = stackFrameResponse.getFrame();
		}
		
		if(frame == null) {
			throw new DebugException(fThread.getDebugCore().createStatus(
					IStatus.ERROR, "VMStackFrame request failure")); //$NON-NLS-1$
		}
		
		return frame;
	}

	public void resume() throws DebugException {
		getThread().resume();
	}
	
	public void setDeferredExecution(boolean isDeferred) {
		this.fDeferredExecution = isDeferred;
	}
	
	protected void setLocation(@NonNull VMStackFrameData frame) {
		fUnderlyingFrame = frame;
	}

	public void stepInto() throws DebugException {
		getThread().stepInto();
	}

	public void stepOver() throws DebugException {
		getThread().stepOver();
	}

	public void stepReturn() throws DebugException {
		getThread().stepReturn();
	}

	public void suspend() throws DebugException {
		getThread().suspend();
	}	

	public void terminate() throws DebugException {
		getThread().terminate();
	}
}
