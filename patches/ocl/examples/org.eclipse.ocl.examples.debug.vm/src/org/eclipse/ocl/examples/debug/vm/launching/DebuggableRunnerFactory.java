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

import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IDebuggableRunnerFactory;

public abstract class DebuggableRunnerFactory implements IDebuggableRunnerFactory
{	
	protected final EPackage.@NonNull Registry packageRegistry;	
	protected final @NonNull List<String> modelURIs;
	protected final @Nullable String traceFileURI;

	protected DebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceFileURI) {
		this.packageRegistry = packageRegistry;
		this.modelURIs = modelURIs;
		this.traceFileURI = traceFileURI;
	}
	
	public @NonNull BasicDiagnostic createDiagnostic(@NonNull String message) {
		return new BasicDiagnostic(Diagnostic.OK, getPluginId(), 0, message, null);
	}

	protected abstract @NonNull DebuggableRunner createRunner(@NonNull EvaluationContext evaluationContext) throws DiagnosticException;

	protected abstract @NonNull String getPluginId();
	
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
