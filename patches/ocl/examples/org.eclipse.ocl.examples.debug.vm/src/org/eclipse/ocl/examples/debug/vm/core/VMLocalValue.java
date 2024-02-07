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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationEnvironment;

public class VMLocalValue extends VMValue {
	
	public static class LocalValue {
		public Object valueObject;
		public EClassifier valueType;
	}
	
	public VMLocalValue(IVMDebugTarget debugTarget, long frameID,
			@NonNull String @NonNull [] varPath, LocalValue evalResult, @NonNull VMEvaluationEnvironment evaluationEnvironment) {
		super(debugTarget, createVmVar(varPath, evalResult, evaluationEnvironment), frameID);
		myFrameID = frameID;
		this.evaluationEnvironment = evaluationEnvironment;
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		List<VMVariableData> variables = requestVariables();
		List<IVariable> result = new ArrayList<IVariable>();
		
		for (VMVariableData nextVar : variables) {
			result.add(new VMLocalVariable(getOCLDebugTarget(), nextVar, myFrameID, evaluationEnvironment));
		}					
		
		return result.toArray(new IVariable[result.size()]);
	}
	
	@Override
	protected List<@NonNull VMVariableData> requestVariables() throws DebugException {
		List<@NonNull VMVariableData> vars = new ArrayList<@NonNull VMVariableData>();
		VariableFinder.newInstance(evaluationEnvironment, true).collectChildVars(vmVar.valueObject,
				VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), null, vars);
		return vars;
	}
	
	private static VMVariableData createVmVar(@NonNull String @NonNull [] varPath, LocalValue evalResult, @NonNull VMEvaluationEnvironment evalEnv) {
		@NonNull String varName = String.valueOf(varPath.length > 0 ? varPath[varPath.length-1] : null);
		VMVariableData var = new VMVariableData(varName, VariableFinder.createURI(varPath).toString());
		var.kind = VMVariableData.LOCAL;
		var.valueObject = evalResult.valueObject;
		EClassifier valueType = evalResult.valueType;
		String declaredTypeName = (valueType != null) ? valueType.getName() : null;
		VariableFinder.newInstance(evalEnv, true).setValueAndType(var, evalResult.valueObject, declaredTypeName);
		return var;
	}

	private final long myFrameID;
	private final @NonNull VMEvaluationEnvironment evaluationEnvironment;
}
