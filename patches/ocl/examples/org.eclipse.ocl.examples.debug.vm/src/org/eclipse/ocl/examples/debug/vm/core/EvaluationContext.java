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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.utils.Log;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

public abstract class EvaluationContext
{
	protected final @NonNull IVMContext vmContext;
	private @Nullable Log log;

	protected EvaluationContext(@NonNull IVMContext vmContext) {
		this.vmContext = vmContext;
	}

	/**
	 * Attach the EnvironmentFactory to the VM's thread.
	 */
	public void attachEnvironmentFactory() {
		ThreadLocalExecutor.attachEnvironmentFactory(vmContext.getEnvironmentFactory());
	}

	/**
	 * Detach the EnvironmentFactory from the current thread. This is initially called on the
	 * main Thread once a call to attachEnvironmentFactory has acquired an attach on the VM thread.
	 * The initial call releases the temporary attach by the main Thread for launch. A second call on
	 * the VM thread once debugging/evaluation has completed releases the EnviromentFactory completely.
	 */
	public void detachEnvironmentFactory() {
		ThreadLocalExecutor.detachEnvironmentFactory(vmContext.getEnvironmentFactory());
	}

	public @Nullable Log getLog() {
		return log;
	}

	public abstract @NonNull URI getDebuggableURI();

	public @NonNull IVMContext getVMContext() {
	//	assert debugVMThread == Thread.currentThread();
		return vmContext;
	}

	public void setLog(@NonNull Log log) {
		this.log = log;
	}
}
