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
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.ocl.examples.debug.vm.data.VMVariableData;

public class VMVariable extends VMDebugElement implements IVariable {
	
	final VMVariableData vmVar;
	private final long fFrameID;
	protected IValue fValue;

	
	VMVariable(IVMDebugTarget debugTarget, final VMVariableData vmVar, long frameID) {
		super(debugTarget);
		
		this.vmVar = vmVar;			
		this.fFrameID = frameID;
	}

	public boolean isModelParameter() {
		return vmVar.kind == VMVariableData.MODEL_PARAMETER;
	}
	
	public boolean isLocalVariable() {
		return vmVar.kind == VMVariableData.LOCAL;
	}
	
	public boolean isCollectionElement() {
		return vmVar.kind == VMVariableData.COLLECTION_ELEMENT;
	}	

	public boolean isPredefinedVariable() {
		return vmVar.kind == VMVariableData.PREDEFINED_VAR;
	}		
	
	public boolean isIntermProperty() {
		return vmVar.kind == VMVariableData.INTERM_PROPERTY;
	}	

	public boolean isAttribute() {
		return vmVar.kind == VMVariableData.ATTRIBUTE;
	}	
	
	public boolean isReference() {
		return vmVar.kind == VMVariableData.REFERENCE;
	}
	
	public IValue getValue() throws DebugException {
		if (fValue == null) {
			fValue = new VMValue(getOCLDebugTarget(), vmVar, fFrameID);
		}
		return fValue;
	}

	public String getName() throws DebugException {
		return vmVar.name;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return this.vmVar.type.declaringType;
	}	

	public VMVariableData getVmVar() {
		return vmVar;
	}

	public boolean hasValueChanged() throws DebugException {
		return false;
	}

	public boolean supportsValueModification() {
		return false;
	}

	public void setValue(String expression) throws DebugException {
	}

	public void setValue(IValue value) throws DebugException {
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}
}