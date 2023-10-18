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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMValueData;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;
import org.eclipse.ocl.examples.debug.vm.request.VMDetailRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMVariableRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMDetailResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMVariableResponse;

public class VMValue extends VMDebugElement implements IValue {
			
	final VMVariableData vmVar;
	private VMValueData vmValue;
	private long frameID;

	VMValue(IVMDebugTarget debugTarget, VMVariableData vmVar, long frameID) {
		super(debugTarget);
		this.vmVar = vmVar;
		this.vmValue = vmVar.value;
		this.frameID = frameID;
	}
	
	public boolean hasVariables() throws DebugException {
		return vmValue != null && vmValue.hasVariables;
	}

	public IVariable[] getVariables() throws DebugException {
		List<VMVariableData> variables = requestVariables();
		List<IVariable> result = new ArrayList<IVariable>();
		
		for (VMVariableData nextVar : variables) {
			result.add(new VMVariable(getOCLDebugTarget(), nextVar, this.frameID));
		}					
		
		return result.toArray(new IVariable[result.size()]);
	}

	public String getValueString() throws DebugException {
		return (vmValue != null) ? String.valueOf(vmValue.value) : "null"; //$NON-NLS-1$
	}

	public String getReferenceTypeName() throws DebugException {
		return this.vmVar.type.actualType;
	}		
	
    public String computeDetail() throws DebugException {
    	@NonNull URI varURI = URI.createURI(getVariableURIForVMRequest());
    	VMDetailRequest request = new VMDetailRequest(varURI);
    	
    	VMResponse response = getOCLDebugTarget().sendRequest(request);
    	if(response instanceof VMDetailResponse) {
    		VMDetailResponse detailResponse = (VMDetailResponse) response;
    		return detailResponse.getDetail();
    	}
    	return ""; //$NON-NLS-1$
    }
	
    private @NonNull String getVariableURIForVMRequest() {
		String variableURI = vmVar.variableURI;
		if (variableURI == null) {
			variableURI = vmVar.name;
		}
		return variableURI;
    }
    
	List<@NonNull VMVariableData> requestVariables() throws DebugException {
		String variableURI = getVariableURIForVMRequest();
		
		VMVariableRequest request = new VMVariableRequest(frameID, variableURI, true);
		
		VMResponse response = getOCLDebugTarget().sendRequest(request);

		if(response instanceof VMVariableResponse) {
			VMVariableResponse variableResponse = (VMVariableResponse) response;
			if(variableResponse.childVariables != null) {
				return Arrays.asList(variableResponse.childVariables);
			}
		}
		
		return Collections.emptyList();
	}
	
	public boolean isAllocated() throws DebugException {
		return true;
	}
	
}