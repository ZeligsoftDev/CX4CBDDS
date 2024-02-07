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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.core.OCLDebugTarget;
import org.eclipse.ocl.examples.debug.core.OCLEvaluationContext;
import org.eclipse.ocl.examples.debug.core.OCLVirtualProcess;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.core.VMVirtualProcess;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunnerFactory;
import org.eclipse.ocl.examples.debug.vm.launching.VMLaunchConfigurationDelegate;
import org.eclipse.ocl.pivot.ExpressionInOCL;

public class OCLVMLaunchConfigurationDelegate extends VMLaunchConfigurationDelegate<OCLEvaluationContext> implements OCLLaunchConstants
{
	public static final IStatus MODIFIED_SOURCE_STATUS = OCLDebugCore.INSTANCE.createError("", 300, null); //$NON-NLS-1$

	@Override
	protected @NonNull OCLDebugTarget createDebugTarget(@NonNull IVMVirtualMachineShell vm, @NonNull VMVirtualProcess process) {
		return new OCLDebugTarget(process, vm);
	}

	@Override
	protected @NonNull DebuggableRunnerFactory createDebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceURI) {
		return new OCLDebuggableRunnerFactory(packageRegistry, modelURIs, null);
	}

	@Override
	protected @NonNull OCLEvaluationContext createEvaluationContext(@NonNull ILaunchConfiguration configuration) throws CoreException {
		Map<String, Object> attributes = configuration.getAttributes();
		Object contextObject = attributes.get(CONTEXT_OBJECT);
		Object expressionObject = attributes.get(EXPRESSION_OBJECT);
		if (((contextObject == null) || (contextObject instanceof EObject)) && (expressionObject instanceof ExpressionInOCL)) {
			return new OCLEvaluationContext((ExpressionInOCL)expressionObject, (EObject)contextObject);
		}
		String expressionUri = configuration.getAttribute(CONSTRAINT_URI, "");
		@NonNull URI expressionURI = URI.createURI(expressionUri, true);
		String contextUri = configuration.getAttribute(CONTEXT_URI, "");
		@NonNull URI contextURI = URI.createURI(contextUri, true);
		return new OCLEvaluationContext(expressionURI, contextURI);
	}

	@Override
	protected @NonNull OCLVMVirtualMachine createVirtualMachine(@NonNull OCLEvaluationContext evaluationContext, @NonNull DebuggableRunner runner) {
		return new OCLVMVirtualMachine(runner, evaluationContext);
	}

	@Override
	protected @NonNull OCLVirtualProcess createVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm) {
		return new OCLVirtualProcess(launch, vm);
	}

	@Override
	protected @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}
}