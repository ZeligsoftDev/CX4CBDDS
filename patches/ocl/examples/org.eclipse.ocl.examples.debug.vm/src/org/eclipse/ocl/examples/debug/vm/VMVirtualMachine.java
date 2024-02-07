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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.core.VMLocalValue;
import org.eclipse.ocl.examples.debug.vm.core.VMLocalValue.LocalValue;
import org.eclipse.ocl.examples.debug.vm.data.VMBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.evaluator.IDebuggableRunnerFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMStartEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMTerminateEvent;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.launching.VMDebuggableExecutorAdapter;
import org.eclipse.ocl.examples.debug.vm.request.VMBreakpointRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMBreakpointRequest.ActionKind;
import org.eclipse.ocl.examples.debug.vm.request.VMDetailRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMStackFrameRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMStartRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMVariableRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMBreakpointResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMDetailResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMStackFrameResponse;
import org.eclipse.ocl.examples.debug.vm.utils.DebugOptions;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;

public abstract class VMVirtualMachine implements IVMVirtualMachineShell
{
	public static final @NonNull TracingOption LOCATION = new TracingOption(DebugVMPlugin.PLUGIN_ID, "location");
	public static final @NonNull TracingOption PRE_VISIT = new TracingOption(DebugVMPlugin.PLUGIN_ID, "pre-visit");
	public static final @NonNull TracingOption POST_VISIT = new TracingOption(DebugVMPlugin.PLUGIN_ID, "post-visit");
	public static final @NonNull TracingOption VISITOR_STACK = new TracingOption(DebugVMPlugin.PLUGIN_ID, "visitorStack");
	public static final @NonNull TracingOption VM_EVENT = new TracingOption(DebugVMPlugin.PLUGIN_ID, "vmEvent");
	public static final @NonNull TracingOption VM_REQUEST = new TracingOption(DebugVMPlugin.PLUGIN_ID, "vmRequest");
	public static final @NonNull TracingOption VM_RESPONSE = new TracingOption(DebugVMPlugin.PLUGIN_ID, "vmResponse");

	public static final @NonNull String EXCEPTION_NAME = "$invalid";
	public static final @NonNull String PC_NAME = "$pc";

	static {
		//		LOCATION.setState(true);
		//		PRE_VISIT.setState(true);
		//		POST_VISIT.setState(true);
		//		VISITOR_STACK.setState(true);
		//		VM_EVENT.setState(true);
		//		VM_REQUEST.setState(true);
		//		VM_RESPONSE.setState(true);
	}

	private class DebuggerShell implements IVMDebuggerShell
	{
		@Override
		public @NonNull VMBreakpointManager getBreakPointManager() {
			return VMVirtualMachine.this.fBreakpointManager;
		}

		@Override
		public void handleVMEvent(@NonNull VMEvent event) {
			if (VM_EVENT.isActive()) {
				VM_EVENT.println("?[" + Thread.currentThread().getName() + "] " + event.toString());
			}
			if(event instanceof VMStartEvent) {
				// first start event
				synchronized (fStateMonitor) {
					fRunning = true;
					fStateMonitor.notify();
				}
			} else if(event instanceof VMTerminateEvent) {
				synchronized (fStateMonitor) {
					fRunning = false;
					fTerminated = true;
					fExitCode = ((VMTerminateEvent)event).getExitCode();
					fInterpreter = null;			// Needed to workaround BUG 468902
					fExecutor = null;				// Needed to workaround BUG 468902
					runner = null;					// Needed to workaround BUG 468902
					fStateMonitor.notify();
				}
			}

			try {
				fEvents.add(event);
			} catch(IllegalStateException e) {
				// FIXME
				System.err.println("Event queue full!!!!");
			}
		}

		@Override
		public boolean isSessionStarted() {
			return fInterpreter != null;
		}

		@Override
		public VMRequest peekRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.get(0);
			}
		}

		@Override
		public @Nullable VMRequest popRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.remove(0);
			}
		}

		@Override
		public void sessionStarted(@NonNull VMEvaluationStepper evaluator) {
			fInterpreter = evaluator;
		}

		@Override
		public @Nullable VMRequest waitAndPopRequest(@NonNull VMEvent suspend) throws InterruptedException {
			// FIXME - should be locked to ensure none can really send a request until
			// we deliver the event
			handleVMEvent(suspend);

			synchronized (fLock) {
				while(fRequests.isEmpty()) {
					fLock.wait();
				}
				VMRequest request = fRequests.remove(0);
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				return request;
			}
		}
	}

	private static int execute(@NonNull VMDebuggableExecutorAdapter executorAdapter, @NonNull VMStartRequest startRequest) {
		int exitCode = 0;
		try {
			Diagnostic diagnostic = executorAdapter.execute(startRequest);
			int severity = diagnostic.getSeverity();
			if(severity == Diagnostic.ERROR || severity == Diagnostic.CANCEL) {
				System.err.println(diagnostic.toString());
				exitCode = -1;
			}
		} catch (Throwable e) {
			exitCode = -2;
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}

		return exitCode;
	}

	public static @Nullable UnitLocation lookupEnvironmentByID(long id, @NonNull List<UnitLocation> stack) {
		for (UnitLocation location : stack) {
			VMEvaluationEnvironment evalEnv = location.getEvalEnv();
			if (evalEnv.getID() == id) {
				return location;
			}
		}
		return null;
	}

	private final List<VMRequest> fRequests = new ArrayList<VMRequest>();
	private final BlockingQueue<VMEvent> fEvents = new ArrayBlockingQueue<VMEvent>(50);

	private /*final @NonNull*/ DebuggableRunner runner;
	private final @NonNull IVMDebuggerShell fDebuggerShell;

	private final @NonNull VMBreakpointManager fBreakpointManager;
	private @Nullable VMEvaluationStepper fInterpreter;
	private /*final @NonNull*/ VMDebuggableExecutorAdapter fExecutor;

	private boolean fRunning;
	private boolean fTerminated;
	private int fExitCode = -3;

	private Object fStateMonitor = new Object();
	private final Object fLock = new Object();

	protected VMVirtualMachine(@NonNull DebuggableRunner runner, @NonNull VMDebuggableExecutorAdapter executorAdapter) {
		this.runner = runner;
		fExecutor = executorAdapter;
		fDebuggerShell = new DebuggerShell();
		fBreakpointManager = new VMBreakpointManager(this, executorAdapter.getUnit());
		fTerminated = false;
	}

	private @NonNull Runnable createVMRunnable(final @NonNull VMStartRequest startRequest) {
		return new Runnable() {
			@Override
			public void run() {
				int exitCode = -1;
				try {
					fExecutor.connect(fDebuggerShell);
					exitCode = execute(ClassUtil.nonNullState(fExecutor), startRequest);
				} catch(Throwable e) {
					getDebugCore().log(e);
				} finally {
					fDebuggerShell.handleVMEvent(new VMTerminateEvent(exitCode));
				}
			}
		};
	}

	public abstract @NonNull VMBreakpoint createBreakpoint(@NonNull Element element, @NonNull VMNewBreakpointData data, boolean isTemporary);

	public abstract @NonNull VMBreakpoint createBreakpoint(@NonNull Element element, long id, int line, @NonNull String targetURI, boolean isTemporary);

	public @Nullable VMStackFrameData createStackFrame(long frameID, @NonNull List<UnitLocation> stack) {
		UnitLocation location = lookupEnvironmentByID(frameID, stack);
		if (location != null) {
			return createStackFrame(location);
		}

		// invalid stack frame
		return null;
	}

	protected abstract @Nullable VMStackFrameData createStackFrame(@NonNull UnitLocation location);

	public IValue evaluate(@NonNull String expressionText, VMDebugTarget debugTarget, long frameID) throws CoreException {
		VMEvaluationStepper fInterpreter2 = fInterpreter;
		if (fInterpreter2 == null) {
			return null;
		}

		Element astNode = fInterpreter2.getCurrentLocation().getElement();
		if (astNode == null) {
			return null;
		}

		ConditionChecker localChecker = new ConditionChecker(expressionText, astNode);
		LocalValue lv = new LocalValue();
		lv.valueObject = localChecker.evaluate(fInterpreter2);
		lv.valueType = localChecker.getConditionType();

		return new VMLocalValue(debugTarget, frameID, new @NonNull String @NonNull [] {expressionText}, lv,
				fInterpreter2.getVMEvaluationEnvironment());
	}

	public @Nullable EvaluationEnvironment getEvaluationEnv() {
		VMEvaluationStepper fInterpreter2 = fInterpreter;
		if (fInterpreter2 == null) {
			return null;
		}
		return fInterpreter2.getVMEvaluationEnvironment();
	}

	public int getExitCode() {
		return fExitCode;
	}

	public @NonNull DebuggableRunner getRunner() {
		return ClassUtil.nonNullState(runner);
	}

	public @NonNull IDebuggableRunnerFactory getRunnerFactory() {
		return runner.getRunnerFactory();
	}

	private @NonNull VMBreakpointResponse handleBreakPointRequest(@NonNull VMBreakpointRequest request) {
		ActionKind actionKind = request.getActionKind();

		if(actionKind == VMBreakpointRequest.ActionKind.ADD) {
			List<VMBreakpointData> allBpData = request.getBreakpointData();
			if(allBpData != null) {
				List<Long> addedBpIDs = new ArrayList<Long>();
				for (VMBreakpointData bpData : allBpData) {
					if(bpData instanceof VMNewBreakpointData == false) {
						continue;
					}

					VMNewBreakpointData newBreakpoint = (VMNewBreakpointData) bpData;
					VMBreakpoint breakpoint = fBreakpointManager.createBreakpoint(newBreakpoint);

					if(breakpoint != null) {
						addedBpIDs.add(Long.valueOf(newBreakpoint.getID()));

						getDebugCore().getTrace().trace(DebugOptions.VM,
								"Installing breakpoint: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.getLine() + " " //$NON-NLS-1$
										+ newBreakpoint.getTargetURI());
					} else {
						getDebugCore().getTrace().trace(DebugOptions.VM,
								"Failed to create breakpoint: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.getLine() + " " //$NON-NLS-1$
										+ newBreakpoint.getTargetURI());
					}
				}

				return new VMBreakpointResponse(addedBpIDs);
			}
		} else if(actionKind == VMBreakpointRequest.ActionKind.REMOVE) {
			fBreakpointManager.removeBreakpoint(request.getBreakpointID());
		} else if(actionKind == VMBreakpointRequest.ActionKind.CHANGE) {
			fBreakpointManager.changeBreakpoint(request.getBreakpointID(), request.getFirstBreakpointData());
		}

		// TODO
		return new VMBreakpointResponse();
	}

	private @NonNull VMResponse handleStackFrameRequest(@NonNull VMStackFrameRequest request) {
		VMEvaluationStepper fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			List<UnitLocation> locationStack = fInterpreter2.getLocationStack();
			VMStackFrameData frame = createStackFrame(request.frameID, locationStack);
			if (frame != null) {
				VMStackFrameResponse response = new VMStackFrameResponse(frame);
				if (!locationStack.isEmpty()) {
					UnitLocation topLocation = locationStack.get(0);
					response.isDeferredExecution = topLocation.isDeferredExecution();
				}
				return response;
			}

		}

		// FIXME
		return VMResponse.createERROR();
	}

	private @Nullable VMResponse handleValueDetailRequest(@NonNull VMDetailRequest request) {
		// FIXME - ensure VM is in SUSPEND state, otherwise report fError
		VMEvaluationStepper fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			VMEvaluationEnvironment vmEvaluationEnvironment = fInterpreter2.getCurrentLocation().getEvalEnv();
			VariableFinder variableFinder = VariableFinder.newInstance(vmEvaluationEnvironment, true);
			String detail = variableFinder.computeDetail(request.getVariableURI());
			return new VMDetailResponse(detail != null ? detail : ""); //$NON-NLS-1$
		}
		else {
			return null;
		}
	}

	private @Nullable VMResponse handleVariableRequest(@NonNull VMVariableRequest request) {
		// FIXME - ensure VM is in SUSPEND state, otherwise report fError
		VMEvaluationStepper fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			VMEvaluationEnvironment vmEvaluationEnvironment = fInterpreter2.getCurrentLocation().getEvalEnv();
			VariableFinder variableFinder = VariableFinder.newInstance(vmEvaluationEnvironment, true);
			return variableFinder.process(request, fInterpreter2.getLocationStack());
		}
		else {
			return null;
		}
	}

	@Override
	public boolean isTerminated() {
		return fTerminated;
	}

	@Override
	public VMEvent readVMEvent() throws IOException {
		try {
			return fEvents.take();
		} catch(InterruptedException e) {
			throw new IOException("Waiting for event interrupted");
		}
	}

	@Override
	public @NonNull VMResponse sendRequest(@NonNull VMRequest request) throws IOException {
		VMResponse response = null;
		try {
			if(request instanceof VMStartRequest) {
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				response = start((VMStartRequest)request);
			} else if(request instanceof VMBreakpointRequest) {
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				response = handleBreakPointRequest((VMBreakpointRequest) request);
			} else if(request instanceof VMStackFrameRequest) {
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				response = handleStackFrameRequest((VMStackFrameRequest) request);
			} else if(request instanceof VMVariableRequest) {
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				response = handleVariableRequest((VMVariableRequest) request);
			} else if(request instanceof VMDetailRequest) {
				if (VM_REQUEST.isActive()) {
					VM_REQUEST.println(">[" + Thread.currentThread().getName() + "] " + request);
				}
				response = handleValueDetailRequest((VMDetailRequest) request);
			}
		} catch (RuntimeException e) {
			getDebugCore().log(e);
			response = VMResponse.createERROR();
		}
		if (response != null) {
			if (VM_RESPONSE.isActive()) {
				VM_RESPONSE.println("<[" + Thread.currentThread().getName() + "] " + response);
			}
			return response;
		}
		if (VM_REQUEST.isActive()) {
			VM_REQUEST.println("?[" + Thread.currentThread().getName() + "] " + request);
		}
		synchronized (fLock) {
			fRequests.add(request);
			fLock.notifyAll();
		}
		response = VMResponse.createOK();
		if (VM_RESPONSE.isActive()) {
			VM_RESPONSE.println("<[" + Thread.currentThread().getName() + "] " + response);
		}
		return response;
	}

	private @NonNull VMResponse start(@NonNull VMStartRequest startRequest) {
		Thread executorThread = new Thread(createVMRunnable(startRequest), getDebugCore().getVMThreadName());

		synchronized (fStateMonitor) {
			if(fRunning) {
				return VMResponse.createERROR();
			}

			executorThread.start();

			while(!(fRunning || fTerminated)) {
				try {
					fStateMonitor.wait();
				} catch (InterruptedException e) {
					getDebugCore().log(getDebugCore().createStatus(IStatus.ERROR, "VM startup process interrupted"));
				}
			}
		}
		return VMResponse.createOK();
	}
}
