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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMExecutor;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMRootEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.utils.VMStackTraceBuilder;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class OCLVMRootEvaluationEnvironment extends VMRootEvaluationEnvironment implements OCLVMEvaluationEnvironment
{
	//	private IContext myContext;
	private List<Runnable> myDeferredTasks;
	//    private EObjectEStructuralFeaturePair myLastAssignLvalue;
	//    private ModelParameterExtent myUnboundExtent;
	private boolean myIsDeferedExecution;
	//    private VMRuntimeException myException;
	//    private Trace myTraces;
	private @NonNull Element myCurrentIP;
	private @NonNull NamedElement myOperation;		// FIXME redundant if final
	private final long id;
	private final @NonNull Variable pcVariable;

	public OCLVMRootEvaluationEnvironment(@NonNull VMExecutor vmExecutor, @NonNull ExpressionInOCL executableObject, long id) {
		super(vmExecutor, executableObject);
		myCurrentIP = executableObject;
		myOperation = executableObject;
		this.id = id;
		pcVariable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
		pcVariable.setName(VMVirtualMachine.PC_NAME);
		String typeName = ClassUtil.nonNullEMF(PivotPackage.Literals.OCL_EXPRESSION.getName());
		pcVariable.setType(((EnvironmentFactoryInternalExtension)environmentFactory).getASClass(typeName));
	}

	@Override
	public @NonNull OCLVMEvaluationEnvironment createClonedEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	//    @Override
	//    IContext getContext() {
	//    	return myContext;
	//    }

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
	public @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}

	@Override
	public int getDepth() {
		return 1;
	}

	//    @Override
	//    public VMRuntimeException getException() {
	//    	return myException;
	//    }


	@Override
	public long getID() {
		return id;
	}

	@Override
	public @NonNull NamedElement getOperation() {
		return myOperation;
	}

	@Override
	public @Nullable OCLVMRootEvaluationEnvironment getVMParentEvaluationEnvironment() {
		return (OCLVMRootEvaluationEnvironment) super.getVMParentEvaluationEnvironment();
	}

	@Override
	@NonNull public Variable getPCVariable() {
		return pcVariable;
	}

	@Override
	public @NonNull OCLVMRootEvaluationEnvironment getVMRootEvaluationEnvironment() {
		return this;
	}

	@Override
	public boolean isDeferredExecution() {
		return myIsDeferedExecution;
	}

	@Override
	public void processDeferredTasks() {
		if (myDeferredTasks != null) {
			try {
				myIsDeferedExecution = true;
				// make me re-entrant in case of errorenous call to #addDeferredTask()
				// from running the task => concurrent modification exception
				// This error condition should be handled elsewhere
				List<Runnable> tasksCopy = new ArrayList<Runnable>(myDeferredTasks);
				for (Runnable task : tasksCopy) {
					task.run();
				}
			} finally {
				myIsDeferedExecution = false;
			}
		}
	}

	protected void saveThrownException(@NonNull VMRuntimeException exception) {
		//    	myException = exception;
	}

	@Override
	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	public void setException(@NonNull VMRuntimeException exception) {
		saveThrownException(exception);
	}

	@Override
	public void throwVMException(@NonNull VMRuntimeException exception) throws VMRuntimeException {
		try {
			saveThrownException(exception);
			exception.setStackVMTrace(new VMStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			getDebugCore().error("Failed to build VM stack trace", e); //$NON-NLS-1$
		}

		throw exception;
	}
}
