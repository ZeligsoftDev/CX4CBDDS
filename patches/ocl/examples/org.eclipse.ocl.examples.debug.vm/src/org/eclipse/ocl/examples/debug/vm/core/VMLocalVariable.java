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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.core.VMLocalValue.LocalValue;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;

public class VMLocalVariable extends VMVariable
{
	VMLocalVariable(IVMDebugTarget debugTarget, VMVariableData vmVar, long frameID, @NonNull VMEvaluationEnvironment evaluationEnvironment) {
		super(debugTarget, vmVar, frameID);
		myFrameID = frameID;
		this.evaluationEnvironment = evaluationEnvironment;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		if (fValue == null) {
			LocalValue lv = new LocalValue();
			lv.valueObject = vmVar.valueObject;
			lv.valueType = null; // FIXME vmVar.valueObject instanceof EObject ? ((EObject) vmVar.valueObject).eClass() : null;
			fValue = new VMLocalValue(getOCLDebugTarget(), myFrameID,
					VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), lv, evaluationEnvironment);
		}
		return fValue;
	}
	
	private final long myFrameID;
	private final @NonNull VMEvaluationEnvironment evaluationEnvironment;
}
