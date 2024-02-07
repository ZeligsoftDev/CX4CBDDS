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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.core.VMVirtualProcess;
import org.eclipse.ocl.examples.debug.vm.utils.StreamsProxy;
import org.eclipse.ocl.examples.debug.vm.utils.WriterLog;

public abstract class VMLaunchConfigurationDelegate<EC extends EvaluationContext> extends LaunchConfigurationDelegate
{

	/*
	 * TODO - handle multiple files involved in the transformation
	 */
	protected void addSourceModificationListener(final @NonNull IFile unitFile, final @NonNull ITerminate terminate) {
		final SourceModificationListener listener = new SourceModificationListener(getDebugCore(), unitFile, terminate);

		unitFile.getProject().getWorkspace().addResourceChangeListener(listener, IResourceChangeEvent.POST_CHANGE);

		DebugPlugin.getDefault().addDebugEventListener(
				new IDebugEventSetListener() {
					@Override
					public void handleDebugEvents(DebugEvent[] events) {
						for (int i = 0; i < events.length; i++) {
							DebugEvent event = events[i];

							if (event.getKind() == DebugEvent.TERMINATE && event.getSource().equals(terminate)) {
								// unregister myself
								DebugPlugin.getDefault().removeDebugEventListener(this);
								// unregister workspace listener
								unitFile.getProject().getWorkspace().removeResourceChangeListener(listener);
							}
						}
					}
				});

	}

	protected abstract @NonNull VMDebugTarget createDebugTarget(@NonNull IVMVirtualMachineShell vm, @NonNull VMVirtualProcess process);

	protected abstract @NonNull DebuggableRunnerFactory createDebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceURI);

	protected abstract @NonNull EC createEvaluationContext(@NonNull ILaunchConfiguration configuration) throws CoreException;

	protected EPackage.@NonNull Registry createPackageRegistry(String debuggableUri) {
		URI debuggableURI = URI.createURI(debuggableUri);
		try {
			if(debuggableURI.isPlatformResource()) {
				IFile file = getDebugCore().toFile(debuggableURI);
				if(file != null && file.exists()) {
//					return MetamodelURIMappingHelper.mappingsToEPackageRegistry(file.getProject(), new ResourceSetImpl());
				}
			}
		} catch(Exception e) {
			// FIXME
			getDebugCore().log(e);
		}

		return new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
	}

	private DebuggableRunner createRunner(@NonNull EC evaluationContext) throws CoreException {
		URI debuggableURI = evaluationContext.getDebuggableURI();
		@SuppressWarnings("null")@NonNull String uri = debuggableURI.toString();
		EPackage.Registry packageRegistry = createPackageRegistry(uri);

		List<String> modelURIs = new ArrayList<String>();
		DebuggableRunnerFactory runnerFactory = createDebuggableRunnerFactory(packageRegistry, modelURIs, null);

		try {
			return runnerFactory.createRunner(evaluationContext);
		} catch (DiagnosticException e) {
			throw new CoreException(BasicDiagnostic.toIStatus(e.getDiagnostic()));
		}
	}

	protected abstract @NonNull VMVirtualMachine createVirtualMachine(@NonNull EC evaluationContext, @NonNull DebuggableRunner runner);

	protected abstract @NonNull VMVirtualProcess createVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm);

	protected abstract @NonNull VMDebugCore getDebugCore();

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		assert configuration != null;
		assert launch != null;
		EC evaluationContext = createEvaluationContext(configuration);
		StreamsProxy streamsProxy = new StreamsProxy();
		evaluationContext.setLog(new WriterLog(getDebugCore(), streamsProxy.getOutputWriter(), true));

		DebuggableRunner runner = createRunner(evaluationContext);
		runner.setErrorLog(new PrintWriter(streamsProxy.getErrWriter(), true));

		Diagnostic initDiagnostic = runner.initialize();
		if (initDiagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new CoreException(BasicDiagnostic.toIStatus(initDiagnostic));
		}

		IVMVirtualMachineShell vm = createVirtualMachine(evaluationContext, runner);

		VMVirtualProcess process = createVirtualProcess(launch, vm);
		process.setStreamsProxy(streamsProxy);

		try {
			List<IFile> transformationWsFile = getDebugCore().toFiles(runner.getDebuggableURI());
			if (!transformationWsFile.isEmpty()) {
				IFile unitFile = transformationWsFile.get(0);
				if (unitFile != null) {
					addSourceModificationListener(unitFile, process);
				}
			}
		}
		catch (IllegalArgumentException e) {
			// FIXME happens for Console input 'file'
		}

		IDebugTarget debugTarget = createDebugTarget(vm, process);
		launch.addDebugTarget(debugTarget);
		debugTarget.getThreads()[0].stepInto();
		evaluationContext.detachEnvironmentFactory();		// Release EnvironmentFactory attach by main Thread
	}

/*	private URI toURI(String uriStr, String uriType) throws DiagnosticException {
		IllegalArgumentException exc = null;
		if(uriStr != null) {
			try {
				return URI.createURI(uriStr);
			} catch(IllegalArgumentException e) {
				exc = e;
			}
		}

		String message = NLS.bind("Invalid {0} URI : ''{1}''", uriType, uriStr);
		throw new DiagnosticException(OCLDebugUIPlugin.createErrorDiagnostic(message, exc));
	} */
}