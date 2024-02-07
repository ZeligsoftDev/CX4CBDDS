/*******************************************************************************
 * Copyright (c) 2010, 2018 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.stepper.OCLStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.evaluator.AbstractVMEvaluationStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.pivot.internal.evaluation.OCLEvaluationVisitor;

public class OCLVMEvaluationStepper extends AbstractVMEvaluationStepper
{
	public OCLVMEvaluationStepper(@NonNull OCLEvaluationVisitor evaluationVisitor, @NonNull IVMContext vmContext) {
		super(evaluationVisitor, vmContext, OCLStepperVisitor.INSTANCE);
	}

	protected @NonNull VMStackFrameData @NonNull [] createStackFrame() {
		return OCLVMVirtualMachine.createStackFrame(getLocationStack());
	}

    protected void log(IStatus status) {
    	OCLDebugCore.INSTANCE.log(status);
    }

	protected void trace(String option, String message) {
		OCLDebugCore.TRACE.trace(option, message);
	}
}
