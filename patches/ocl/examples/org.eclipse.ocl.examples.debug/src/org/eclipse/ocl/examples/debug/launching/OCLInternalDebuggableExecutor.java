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

import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.OCLEvaluationContext;
import org.eclipse.ocl.examples.debug.evaluator.OCLVMExecutor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.launching.InternalDebuggableExecutor;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.utilities.ParserException;

/**
 * Internal transformation executor
 */
public class OCLInternalDebuggableExecutor extends InternalDebuggableExecutor
{
	protected final @NonNull OCLEvaluationContext evaluationContext;
	
	public OCLInternalDebuggableExecutor(@NonNull OCLEvaluationContext evaluationContext, @NonNull IVMContext vmContext) {
		super(vmContext, evaluationContext.getConstraintURI());
		this.evaluationContext = evaluationContext;
	}

	protected @NonNull OCLVMExecutor createVMExecutor() throws IOException, ParserException {
		ExpressionInOCL expressionObject = evaluationContext.getExpressionObject();
		if (expressionObject != null) {
			return new OCLVMExecutor(vmContext, expressionObject, evaluationContext.getContextObject());
		}
		else {
			return new OCLVMExecutor(vmContext, evaluationContext.getConstraintURI(), evaluationContext.getContextURI());
		}
	}
}
