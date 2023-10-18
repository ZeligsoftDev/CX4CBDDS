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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.IBreakpointManagerListener;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.BreakpointError;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.VMEventListener;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMSuspension;
import org.eclipse.ocl.examples.debug.vm.event.VMDisconnectEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMResumeEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMStartEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMSuspendEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMTerminateEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMBreakpointRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMResumeRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMStartRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMSuspendRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMTerminateRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMBreakpointResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.utils.DebugOptions;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public abstract class VMDebugTarget extends VMDebugElement implements IVMDebugTarget, IDebugEventSetListener, IBreakpointManagerListener {

	private final Map<Long, VMLineBreakpoint> fID2Breakpoint = new HashMap<Long, VMLineBreakpoint>();

	private final ILaunch fLaunch;

	private final IProcess fProcess;

	private VMThread fMainThread;

	private String fMainModuleName;

	private boolean fIsStarting;
	private boolean fIsSuspended = false;

	private final IVMVirtualMachineShell fVM;
	private final List<VMEventListener> fEventListener = new LinkedList<VMEventListener>();

	private final Object fVMStartMonitor = new Object();
	private Thread eventDispatcherThread;

	public VMDebugTarget(IProcess process, IVMVirtualMachineShell vm) {
		super(null);

		fLaunch = process.getLaunch();
		fProcess = process;
		fVM = vm;
		fIsStarting = true;
		fEventListener.add(createVMEventListener());

		EventDispatchJob dispatcher = new EventDispatchJob();
		eventDispatcherThread = new Thread(dispatcher, getDebugCore().getDebugThreadName());
		eventDispatcherThread.setDaemon(true);
		eventDispatcherThread.start();

		try {
			// start transformation execution
			sendRequest(new VMStartRequest(true));
		} catch (DebugException e) {
			getDebugCore().log(e.getStatus());
			// FIXME - consult status handler to give UI feedback
			return;
		}

		joinStartOrTerminate();
		// Note: VM is still suspended and waiting for resume
		// => do whatever initialization we need now
		// install VM breakpoints
		installVMBreakpoints();

		DebugEvent createEvent = new DebugEvent(this, DebugEvent.CREATE);
		createEvent.setData(new HashMap<Long, VMLineBreakpoint>(fID2Breakpoint));

		fMainThread = new VMThread(this);
		fLaunch.addDebugTarget(this);
		System.setProperty(getDebugCore().getDebuggerActiveProperty(), Boolean.TRUE.toString());

		try {
			// wake up so far suspended VM unless suspendOnStart
			if (!fIsSuspended) {
				fVM.sendRequest(new VMResumeRequest(VMSuspension.UNSPECIFIED));
			}
		} catch (IOException e) {
			getDebugCore().log(e);
		}

		IBreakpointManager breakpointManager = DebugPlugin.getDefault().getBreakpointManager();
		breakpointManager.addBreakpointManagerListener(this);
		breakpointManager.addBreakpointListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);

		fireEvent(createEvent);
	}

	protected @NonNull URI computeBreakpointURI(@NonNull URI sourceURI) {
		return sourceURI;
	}

	private void installVMBreakpoints() {
		HashMap<Long, VMLineBreakpoint> installedBreakpoints = new HashMap<>();
		List<@NonNull VMNewBreakpointData> allBpData = new ArrayList<>();

		for (@NonNull VMLineBreakpoint vmBp : getDebugCore().getLineBreakpoints()) {
			boolean enabled = false;
			try {
				enabled = vmBp.isEnabled();
			} catch (CoreException e) {
				getDebugCore().log(e.getStatus());
			}

			if (enabled) {
				installedBreakpoints.put(Long.valueOf(vmBp.getID()),
						vmBp);
				try {
					String unitURI = vmBp.getUnitURI().toString();
					@SuppressWarnings("null")@NonNull String targetURI = computeBreakpointURI(ClassUtil.nonNullEMF(URI.createURI(unitURI, true))).toString();
					VMNewBreakpointData data = vmBp.createNewBreakpointData(targetURI);

					allBpData.add(data);
				} catch (CoreException e) {
					getDebugCore().log(e.getStatus());
				}
			}
		}

		if (!allBpData.isEmpty()) {
			@SuppressWarnings("null")@NonNull VMNewBreakpointData @NonNull [] bpData = allBpData.toArray(new VMNewBreakpointData[allBpData.size()]);
			VMBreakpointRequest breakpointRequest = VMBreakpointRequest.createAdd(bpData);
			try {
				VMResponse response = fVM.sendRequest(breakpointRequest);
				//
				fID2Breakpoint.clear();
				if(response instanceof VMBreakpointResponse) {
					VMBreakpointResponse bpResponse = (VMBreakpointResponse) response;

					for(long addedID : bpResponse.getAddedBreakpointsIDs()) {
						Long key = Long.valueOf(addedID);
						VMLineBreakpoint bp = installedBreakpoints.get(key);
						if(bp != null) {
							fID2Breakpoint.put(key, bp);
						}
					}
				}
			} catch (IOException e) {
				getDebugCore().log(e);
			}
		}
	}

	public Collection<? extends IBreakpoint> getInstalledBreakpoints() {
		return Collections.unmodifiableCollection(fID2Breakpoint.values());
	}

	@Override
	public VMResponse sendRequest(@NonNull VMRequest request) throws DebugException {
		try {
			VMResponse response = fVM.sendRequest(request);
			return response;
		} catch (IOException e) {
			throw new DebugException(getDebugCore().createDebugError("Send debug request failed", e));
		}
	}

	@Override
	public synchronized boolean isSuspended() {
		return !isTerminated() && fIsSuspended;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public ILaunch getLaunch() {
		return fLaunch;
	}

	public IVMVirtualMachineShell getVM() {
		return fVM;
	}

	@Override
	public IProcess getProcess() {
		IProcess[] processes = getLaunch().getProcesses();
		if (processes != null && processes.length > 0) {
			return processes[0];
		}

		return null;
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !isTerminated();
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		return (fMainThread != null) ? new IThread[] { fMainThread }
		: new IThread[0];
	}

	@Override
	public @NonNull String getName() {
		return getDebugCore().getDebugTargetName();
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().equals(getModelIdentifier());
	}

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public boolean isTerminated() {
		return fVM.isTerminated();
	}

	/**
	 * This very brute force methhod is solely to clean up at the end of a test.
	 *
	 * It does not seem necessary when using JUnit plugin testing. But it helps for Tycho.
	 */
	@SuppressWarnings("deprecation")
	public void killAfterTest() {
		if ((fMainThread != null) && !fMainThread.isTerminated()) {
			try {
				fMainThread.terminate();
			} catch (DebugException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fMainThread = null;
		}
		if ((eventDispatcherThread != null) && eventDispatcherThread.isAlive()) {
			eventDispatcherThread.stop();
			eventDispatcherThread = null;
		}
	}

	@Override
	public void terminate() throws DebugException {
		sendRequest(new VMTerminateRequest());
	}

	protected void started(String mainModuleName) {
		setMainModuleName(mainModuleName);
		setStarting(false);
	}

	synchronized protected void setMainModuleName(String mainModuleName) {
		fMainModuleName = mainModuleName;
	}

	synchronized public String getMainModuleName() {
		return fMainModuleName;
	}

	protected void terminated() {
		getDebugCore().getTrace().trace(DebugOptions.TARGET, "Debug target terminated"); //$NON-NLS-1$
		System.setProperty(getDebugCore().getDebuggerActiveProperty(), Boolean.FALSE.toString());

		setStarting(false);

		fMainThread = null;

		DebugPlugin debugPlugin = DebugPlugin.getDefault();
		if (debugPlugin != null) {
			IBreakpointManager breakpointManager = debugPlugin.getBreakpointManager();
			breakpointManager.removeBreakpointListener(this);
			breakpointManager.removeBreakpointManagerListener(this);

			debugPlugin.removeDebugEventListener(this);
		}

		fID2Breakpoint.clear();

		fireTerminateEvent();
		if (fProcess instanceof VMVirtualProcess) {
			VMVirtualProcess vp = (VMVirtualProcess) fProcess;
			vp.terminated();
		}
	}

	@Override
	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		sendRequest(new VMResumeRequest(VMSuspension.UNSPECIFIED));
	}

	@Override
	public void suspend() throws DebugException {
		sendRequest(new VMSuspendRequest(VMSuspension.UNSPECIFIED));
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (breakpoint instanceof VMLineBreakpoint == false
				|| !DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			return;
		}

		VMLineBreakpoint vmBreakpoint = (VMLineBreakpoint) breakpoint;
		try {
			VMNewBreakpointData bpData = vmBreakpoint.createNewBreakpointData();
			VMBreakpointRequest addBreakpointRequest = VMBreakpointRequest.createAdd(bpData);

			VMResponse response = sendRequest(addBreakpointRequest);
			if(response instanceof VMBreakpointResponse) {
				VMBreakpointResponse bpResponse = (VMBreakpointResponse) response;
				long[] addedIDs = bpResponse.getAddedBreakpointsIDs();
				if(addedIDs.length > 0) {
					fID2Breakpoint.put(Long.valueOf(addedIDs[0]), vmBreakpoint);
				}
			}
		} catch (CoreException e) {
			getDebugCore().log(e.getStatus());
		}
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof VMLineBreakpoint == false
				|| !DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			return;
		}

		boolean nowEnabled = false;
		try {
			nowEnabled = breakpoint.isEnabled();
		} catch (CoreException e1) {
			// do nothing
		}
		boolean beforeEnabled = delta.getAttribute(IBreakpoint.ENABLED, false);

		VMBreakpointRequest changeRequest = null;
		try {
			VMLineBreakpoint vmBreakpoint = (VMLineBreakpoint) breakpoint;
			if (nowEnabled && !beforeEnabled) {
				// just to be added to VM
				changeRequest = VMBreakpointRequest.createAdd(new @NonNull VMNewBreakpointData[] { vmBreakpoint.createNewBreakpointData() });
			} else if (!nowEnabled && beforeEnabled) {
				// just to be removed from VM
				changeRequest = VMBreakpointRequest.createRemove(vmBreakpoint.getID());
			} else {
				// modify existing data
				changeRequest = VMBreakpointRequest.createChange(vmBreakpoint.getID(), vmBreakpoint.createBreakpointData());
			}

		} catch (CoreException e) {
			getDebugCore().log(e);
		}

		if (changeRequest != null) {
			try {
				fVM.sendRequest(changeRequest);
			} catch (IOException e) {
				getDebugCore().log(e);
			}
		}
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof VMLineBreakpoint) {
			if (delta == null) {
				IMarker marker = breakpoint.getMarker();
				if (marker.exists()) {
					try {
						marker.delete();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			VMLineBreakpoint vmBreakpoint = (VMLineBreakpoint) breakpoint;
			fID2Breakpoint.remove(Long.valueOf(((VMLineBreakpoint) breakpoint)
					.getID()));

			VMBreakpointRequest removeRequest = VMBreakpointRequest
					.createRemove(vmBreakpoint.getID());
			try {
				fVM.sendRequest(removeRequest);
			} catch (IOException e) {
				getDebugCore().log(e);
			}
		}
	}

	@Override
	public boolean canDisconnect() {
		return false;
	}

	@Override
	public void disconnect() throws DebugException {
	}

	@Override
	public boolean isDisconnected() {
		return false;
	}

	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	@Override
	public void handleDebugEvents(DebugEvent[] events) {
		for (int i = 0; i < events.length; i++) {
			DebugEvent event = events[i];

			if (event.getKind() == DebugEvent.TERMINATE) {
				// respond
				if ((fMainThread != null && event.getSource() == fMainThread)
						|| (event.getSource() == fProcess)) {
					if(!isTerminated()) {
						terminated();
					}
				}
			}
		}
	}

	@Override
	public void breakpointManagerEnablementChanged(boolean enabled) {
		for (IBreakpoint breakpoint : getDebugCore().getOCLBreakpoints(IBreakpoint.class)) {
			if (enabled) {
				breakpointAdded(breakpoint);
			} else {
				breakpointRemoved(breakpoint, null);
			}
		}
	}

	private void joinStartOrTerminate() {
		synchronized (fVMStartMonitor) {
			while(fIsStarting) {
				try {
					// wait until we receive VM startup event
					fVMStartMonitor.wait();
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
		}
	}


	private void setStarting(boolean isStarting) {
		synchronized (fVMStartMonitor) {
			fIsStarting = isStarting;
			fVMStartMonitor.notify();
		}
	}

	private void handleBreakpointConditionError(VMSuspendEvent suspend) {
		IStatus breakpointStatus = new BreakpointError(suspend
				.getBreakpointID(), suspend.getReason(),
				suspend.getReasonDetail());

		IStatusHandler handler = DebugPlugin.getDefault().getStatusHandler(breakpointStatus);
		if(handler != null) {
			try {
				handler.handleStatus(breakpointStatus, VMDebugTarget.this);
			} catch (CoreException e) {
				getDebugCore().log(e.getStatus());
			}
		} else {
			// no custom handler found, at least log the status
			getDebugCore().log(breakpointStatus);
		}
	}

	private VMEventListener createVMEventListener() {
		return new VMEventListener() {

			@Override
			public void handleEvent(VMEvent event) {
				if (event instanceof VMResumeEvent) {
					fIsSuspended = false;
					fireResumeEvent(0);
				} else if (event instanceof VMSuspendEvent) {
					fIsSuspended = true;

					VMSuspendEvent suspend = (VMSuspendEvent) event;
					fireSuspendEvent(suspend.suspension.getDebugEventDetail());

					if (suspend.suspension == VMSuspension.BREAKPOINT_CONDITION_ERR) {
						handleBreakpointConditionError(suspend);
					}

				} else if (event instanceof VMTerminateEvent) {
					fIsSuspended = false;
					terminated();
				} else if (event instanceof VMDisconnectEvent) {
					fIsSuspended = false;
					terminated();
				} else if (event instanceof VMStartEvent) {
					VMStartEvent startEvent = (VMStartEvent) event;
					started(startEvent.mainModuleName);
					fIsSuspended = startEvent.suspendOnStartup;
					if (fIsSuspended) {
						fireSuspendEvent(VMSuspension.STEP_INTO.getDebugEventDetail());
					}
				}
			}

		};
	}

	@Override
	public void addVMEventListener(@NonNull VMEventListener listener) {
		synchronized (fEventListener) {
			fEventListener.add(listener);
		}
	}

	@Override
	public boolean removeVMEventListener(@NonNull VMEventListener listener) {
		synchronized (fEventListener) {
			return fEventListener.remove(listener);
		}
	}

	void handleVMEvent(VMEvent event) {
		List<VMEventListener> listeners;
		synchronized (fEventListener) {
			listeners = new ArrayList<VMEventListener>(fEventListener);
		}

		for (VMEventListener vmEventListener : listeners) {
			try {
				vmEventListener.handleEvent(event);
			} catch (Exception e) {
				getDebugCore().log(e);
			}
		}
	}

	public IValue evaluate(@NonNull String expressionText, long frameID) throws CoreException {
		if (getVM() instanceof VMVirtualMachine) {
			return ((VMVirtualMachine) getVM()).evaluate(expressionText, this, frameID);
		}
		return null;
	}

	private class EventDispatchJob implements Runnable {

		EventDispatchJob() {
			super();
		}

		@Override
		public void run() {
			while (!isTerminated()) {
				VMEvent event;
				try {
					event = fVM.readVMEvent();
				} catch (IOException e) {
					break;
				}
				if (VMVirtualMachine.VM_EVENT.isActive()) {
					VMVirtualMachine.VM_EVENT.println(">[" + Thread.currentThread().getName() + "] " + event);
				}
				if (event != null) {
					handleVMEvent(event);
				}
			}

			getDebugCore().getTrace().trace(DebugOptions.TARGET,
					"Debug target VMEvent dispatcher shutdown"); //$NON-NLS-1$
		}
	}

}
