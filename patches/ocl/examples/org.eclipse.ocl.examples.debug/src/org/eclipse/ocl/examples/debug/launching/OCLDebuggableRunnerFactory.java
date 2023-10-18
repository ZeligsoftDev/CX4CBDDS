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

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.core.OCLEvaluationContext;
import org.eclipse.ocl.examples.debug.evaluator.OCLIsBreakpointableVisitor;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunnerFactory;

public class OCLDebuggableRunnerFactory extends DebuggableRunnerFactory
{
	public static final @NonNull ValidBreakpointLocator validBreakpointLocator = new ValidBreakpointLocator(OCLIsBreakpointableVisitor.INSTANCE);

	public OCLDebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceFileURI) {
		super(packageRegistry, modelURIs, traceFileURI);
	}

	public @NonNull DebuggableRunner createRunner(@NonNull EvaluationContext evaluationContext) throws DiagnosticException {
		OCLEvaluationContext oclEvaluationContext = (OCLEvaluationContext)evaluationContext;
//		BasicDiagnostic diagnostic = createDiagnostic("Expression runner problems");
		
//		URI uri = null;
//		try {
//			uri = oclEvaluationContext.getConstraintURI(); //toURI(this.transformationURI, "transformation");
//		} catch(DiagnosticException e) {
//			OCLDebugUIPlugin.createDiagnostic("Transformation runner problems").add(e.getDiagnostic());
//		}

//		List<URI> paramURIs = new ArrayList<URI>();
/*		if(this.modelParamURI != null) {
			for (String paramURIStr : this.modelParamURI) {
				try {
					paramURIs.add(toURI(paramURIStr, "model parameter"));
				} catch(DiagnosticException e) {
					diagnostic.add(e.getDiagnostic());
				}
			}
		} else {
			diagnostic.add(OCLDebugUIPlugin.createErrorDiagnostic("No model parameters passed to transformation", null));
		}

		if(diagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new DiagnosticException(diagnostic);
		} */
		IVMContext vmContext = oclEvaluationContext.getVMContext();
		OCLInternalDebuggableExecutor executor = new OCLInternalDebuggableExecutor(oclEvaluationContext, vmContext);
		DebuggableRunner runner = new DebuggableRunner(this, oclEvaluationContext.getConstraintURI(), executor);
		
/*		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(this.traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		} */

		return runner;
	}

	protected @NonNull String getPluginId() {
		return OCLDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull ValidBreakpointLocator getValidBreakpointLocator() {
		return validBreakpointLocator;
	}
}
