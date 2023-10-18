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
package org.eclipse.ocl.examples.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMNestedEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.utils.VMStackTraceBuilder;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;

public class OCLVMNestedEvaluationEnvironment extends VMNestedEvaluationEnvironment implements OCLVMEvaluationEnvironment
{
	private @NonNull Element myCurrentIP;
	private @NonNull NamedElement myOperation;		// Redundant if final
	private final int myStackDepth;
	private final long id;

	public OCLVMNestedEvaluationEnvironment(@NonNull OCLVMEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller, long id) {
		super(evaluationEnvironment, executableObject, caller);
		myStackDepth = evaluationEnvironment.getDepth() + 1;
		this.id = id;
		this.myOperation = executableObject;
		this.myCurrentIP = executableObject;
	}

	@Override
	public @NonNull OCLVMEvaluationEnvironment createClonedEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Element getCurrentIP() {
		return myCurrentIP;
	}

	@Override
	public @NonNull UnitLocation getCurrentLocation() {
		//		if (myCurrentIP == null) {
		//			return null;
		//		}
		//		else {
		int startPosition = ASTBindingHelper.getStartPosition(myCurrentIP);
		int endPosition = ASTBindingHelper.getEndPosition(myCurrentIP);
		return new UnitLocation(startPosition, endPosition, this, myCurrentIP);
		//		}
	}

	@Override
	public int getDepth() {
		return myStackDepth;
	}

	@Override
	public long getID() {
		return id;
	}

	@Override
	public @NonNull NamedElement getOperation() {
		return myOperation;
	}

	@Override
	@NonNull public Variable getPCVariable() {
		return rootVMEvaluationEnvironment.getPCVariable();
	}

	@Override
	public @Nullable OCLVMEvaluationEnvironment getVMParentEvaluationEnvironment() {
		return (OCLVMEvaluationEnvironment) super.getVMParentEvaluationEnvironment();
	}

	@Override
	public @NonNull OCLVMRootEvaluationEnvironment getVMRootEvaluationEnvironment() {
		return (OCLVMRootEvaluationEnvironment) rootVMEvaluationEnvironment;
	}

	@Override
	public boolean isDeferredExecution() {
		return getVMRootEvaluationEnvironment().isDeferredExecution();
	}

	@Override
	public void processDeferredTasks() {
		getVMRootEvaluationEnvironment().processDeferredTasks();
	}

	@Override
	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	public void setOperation(@NonNull NamedElement operation) {
		this.myCurrentIP = operation;
		this.myOperation = operation;
	}

	@Override
	public void throwVMException(@NonNull VMRuntimeException exception) throws VMRuntimeException {
		try {
			getVMRootEvaluationEnvironment().saveThrownException(exception);
			exception.setStackVMTrace(new VMStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			getDebugCore().error("Failed to build VM stack trace", e); //$NON-NLS-1$
		}

		throw exception;
	}
}
