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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IDebuggableRunnerFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.request.VMStartRequest;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.ExecutionDiagnostic;
import org.eclipse.ocl.examples.debug.vm.utils.IVMStackTraceElement;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

public class DebuggableRunner
{
	/**
	 * Successfully finished execution, no errors and user interruption
	 */
	protected static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity != Diagnostic.ERROR && severity != Diagnostic.CANCEL;
	}

	protected final @NonNull IDebuggableRunnerFactory debuggableRunnerFactory;
	protected final @NonNull URI debuggableURI;
	protected final @NonNull InternalDebuggableExecutor executor;
//	private final List<URI> fModelParamURIs;
	private URI fTraceFileURI;

	private BasicDiagnostic fDiagnostic;
//	private List<ModelExtent> fModelParams;
//	private ModelExtentHelper fExtentHelper;
	private @Nullable IVMDebuggerShell fDebugShell;
	private PrintWriter fErrorLog;

	public DebuggableRunner(@NonNull IDebuggableRunnerFactory debuggableRunnerFactory, @NonNull URI debuggableURI, @NonNull InternalDebuggableExecutor executor) {
		this.debuggableRunnerFactory = debuggableRunnerFactory;
		this.debuggableURI = debuggableURI;
		this.executor = executor;
//		fModelParamURIs = modelParamURIs;

		fErrorLog = new PrintWriter(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// do nothing I'm a <null> log
			}
		}, true);
	}

	public @NonNull VMDebuggableExecutorAdapter createDebuggableAdapter(final @NonNull EvaluationContext evaluationContext) {
		return new VMDebuggableExecutorAdapter() {
			@Override
			public Diagnostic execute(@NonNull VMStartRequest startRequest) throws IllegalStateException {
				if (fDebugShell == null) {
					throw new IllegalStateException("Executor not connected to debugger"); //$NON-NLS-1$
				}

				CompiledUnit mainUnit = getUnit();
				if (mainUnit != null) {
//					OCLDebugUtil.attachEnvironment(mainUnit);
				}
				evaluationContext.attachEnvironmentFactory();
				try {
					Diagnostic execDiagnostic = DebuggableRunner.this.execute(startRequest, evaluationContext);
					if (execDiagnostic.getSeverity() != Diagnostic.OK) {
						fErrorLog.println(execDiagnostic);
					}
					return execDiagnostic;
				}
				finally {
					evaluationContext.detachEnvironmentFactory();
				}
			}

			@Override
			public @Nullable CompiledUnit getUnit() {
				return executor.getUnit();
			}

			@Override
			public void connect(@NonNull IVMDebuggerShell debugShell) {
				fDebugShell = debugShell;
			}
		};
	}

	public Diagnostic execute(@NonNull VMStartRequest startRequest, @NonNull EvaluationContext evaluationContext) {
		Diagnostic diagnostic = initialize();

		if(!isSuccess(diagnostic)) {
			return diagnostic;
		}

//		fExecutor.setEnvironmentFactory(getEnvFactory());
		try {
//			ModelExtent[] params = fModelParams.toArray(new ModelExtent[fModelParams.size()]);
			ExecutionDiagnostic execDiagnostic = executor.execute(startRequest, evaluationContext); //, params);
			handleExecution(execDiagnostic);

//			Trace traces = fExecutor.fTraces;
//			executor.resetTraces();

			if(!isSuccess(execDiagnostic)) {
				// skip saving any output
				return execDiagnostic;
			}

			// can continue and save output
//			Diagnostic saveExtentsDiagnostic = fExtentHelper.saveExtents();
//			handleSaveExtents(saveExtentsDiagnostic);
			executor.getVMExecutor().saveModels();

//			if(!isSuccess(saveExtentsDiagnostic)) {
//				return saveExtentsDiagnostic;
//			}

//			Diagnostic saveTracesDiagnostic = saveTraces(traces);
//			if(!isSuccess(saveTracesDiagnostic)) {
//				return saveTracesDiagnostic;
//			}

			return execDiagnostic;
		} finally {
			executor.cleanup();
		}
	}

	public @NonNull URI getDebuggableURI() {
		return debuggableURI;
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return executor.getVMExecutor().getEnvironmentFactory().getMetamodelManager();
	}

	public @NonNull IDebuggableRunnerFactory getRunnerFactory() {
		return debuggableRunnerFactory;
	}

	public URI getTraceFileURI() {
		return fTraceFileURI;
	}

	protected CompiledUnit getUnit() {
		return executor.getUnit();
	}

	protected @NonNull IVMContext getVMContext() {
		return executor.getVMContext();
	}

	protected void handleLoadExtents(Diagnostic diagnostic) {
	// do nothing
	}

	protected void handleExecution(ExecutionDiagnostic execDiagnostic) {
		List<IVMStackTraceElement> stackTrace = execDiagnostic.getStackTrace();
		if(stackTrace != null && execDiagnostic.getCode() != ExecutionDiagnostic.USER_INTERRUPTED) {
			fErrorLog.println(execDiagnostic);

			if (!stackTrace.isEmpty()) {
				fErrorLog.println("[OCL Stack trace:]");
				execDiagnostic.printStackTrace(fErrorLog);
				fErrorLog.println();
			}
		}

		if(execDiagnostic.getException() != null) {
			fErrorLog.println("[Java cause:]");
			execDiagnostic.getException().printStackTrace(fErrorLog);
		}

		fErrorLog.flush();
	}

	protected void handleLoadDebuggable(Diagnostic diagnostic) {
		// do nothing
	}

	protected void handleSaveExtents(Diagnostic diagnostic) {
	// do nothing
	}

	public Diagnostic initialize() {		// FIXME This is called twice, first time from LaunchConfigDelegate fDebugShell is still null
		IVMContext vmContext = getVMContext();
		vmContext.setShell(fDebugShell);
		if(fDiagnostic != null) {
			return fDiagnostic;
		}

		fDiagnostic = debuggableRunnerFactory.createDiagnostic("Transformation runner initiliaze");

		Diagnostic loadDiagnostic = executor.loadDebuggable();
		if (!isSuccess(loadDiagnostic)) {
			fDiagnostic.add(loadDiagnostic);
		}

		handleLoadDebuggable(loadDiagnostic);

		NamedElement debuggable = executor.getDebuggable();
		if (debuggable == null) {
			return fDiagnostic;
		}

		// Note: initialized here already loaded transformation is required
//		fExtentHelper = new ModelExtentHelper(transformation, fModelParamURIs, fExecutor.getResourceSet());

//		Diagnostic extentsDiagnostic = Diagnostic.OK_INSTANCE;
//		try {
//			fModelParams = fExtentHelper.loadExtents();
//		} catch (DiagnosticException e) {
//			extentsDiagnostic = e.getDiagnostic();
//		}

//		handleLoadExtents(extentsDiagnostic);
//		if(!OCLDebugUIPlugin.isSuccess(extentsDiagnostic)) {
//			fDiagnostic.add(extentsDiagnostic);
//		}

		// FIXME -
		// add validation for configuration properties and param count
		// into the internal executor

		// TODO - collect WARN, INFO diagnostics?
		return fDiagnostic;
	}

/*	private Diagnostic saveTraces(Trace trace) {
		if(fTraceFileURI != null) {
			Resource resource = new ResourceSetImpl().createResource(fTraceFileURI);
			resource.getContents().add(trace);
			try {
		        Map<String, String> options = new HashMap<String, String>();
		        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
				resource.save(options);
			} catch (IOException e) {
				String message = NLS.bind("Failed to save trace model uri={0}", fTraceFileURI);
				return new BasicDiagnostic(Diagnostic.ERROR, OCLDebugUIPlugin.PLUGIN_ID, 0,
						message, new Object[] { e });
			}
		}

		return Diagnostic.OK_INSTANCE;
	} */

	public void setErrorLog(@NonNull PrintWriter errorLog) {
		this.fErrorLog = errorLog;
	}

	public void setTraceFile(URI traceFileURI) {
		fTraceFileURI = traceFileURI;
	}
}