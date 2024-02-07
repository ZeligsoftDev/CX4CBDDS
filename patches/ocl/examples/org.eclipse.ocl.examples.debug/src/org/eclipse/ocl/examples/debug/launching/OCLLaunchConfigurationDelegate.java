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
package org.eclipse.ocl.examples.debug.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMExecutor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMContext;
import org.eclipse.ocl.examples.debug.vm.utils.MiscUtil;
import org.eclipse.ocl.examples.debug.vm.utils.SafeRunner;
import org.eclipse.ocl.examples.debug.vm.utils.ShallowProcess;
import org.eclipse.ocl.examples.debug.vm.utils.StreamsProxy;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.OCL;

public class OCLLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements OCLLaunchConstants
{
	protected static final int LAUNCH_ERROR_CODE = 210;
	protected static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, OCLDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$

	// FIXME - do refactoring of this area
	@Override
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {

		try {
			String oclName = configuration.getAttribute(CONSTRAINT_URI, "");
			final @NonNull URI oclURI = URI.createURI(oclName, true);
			String elementName = configuration.getAttribute(CONTEXT_URI, "");
			final @NonNull URI elementURI = URI.createURI(elementName, true);
			final Monitor execMonitor = new BasicMonitor();

			final StreamsProxy streamsProxy = new StreamsProxy();

			ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {

				@Override
				public void run() throws Exception {
					EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(OCL.NO_PROJECTS, null);
					IVMContext vmContext = new VMContext(environmentFactory);
					OCLVMExecutor vmExecutor = new OCLVMExecutor(vmContext, oclURI, elementURI);
					vmExecutor.execute();
				}
			};


			r = SafeRunner.getSafeRunnable(r);
			final ShallowProcess process = new ShallowProcess(launch, r) {
				boolean isTerminated = false;
				@Override
				public void terminate() throws DebugException {
					execMonitor.setCanceled(true);
					isTerminated = true;
					super.terminate();
				}

				@Override
				public boolean isTerminated() {
					return isTerminated || super.isTerminated();
				}

				@Override
				public boolean canTerminate() {
					return !isTerminated();
				}
			};

			process.setStreamsProxy(streamsProxy);

			Thread processThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						process.run();
					} catch (Exception e) {
						if(e instanceof VMRuntimeException == false) {
							// VM runtime exception are legal VM transformation level errors

							IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(fgLaunchErrorStatus);
							if(statusHandler != null) {
								IStatus actualStatus = new Status(IStatus.ERROR, OCLDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE,
										e.getMessage(), e.getMessage() == null ? e : null);
								try {
									statusHandler.handleStatus(actualStatus, configuration);
								} catch (CoreException coreExc) {
									getDebugCore().log(coreExc.getStatus());
								}
							}

							getDebugCore().error(e);
						}
					}

					try {
						launch.terminate();
					} catch (DebugException e) {
						getDebugCore().log(e.getStatus());
					}
				}
			}, "OCL Run"); //$NON-NLS-1$

			processThread.start();
		}
		catch(Exception e) {
			throw new CoreException(MiscUtil.makeErrorStatus(e));
		}
	}

	protected @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}

	/*	@Override
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}

	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}

	@Override
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
//		((EvlModule)module).setUnsatisfiedConstraintFixer(new ValidationViewFixer());
	} */
}

