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
package org.eclipse.ocl.examples.debug.vm;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.data.VMNewBreakpointData;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;


public abstract class VMBreakpoint {

	private final long fID;
	private final @NonNull String fTargetURI;
	private final int fLineNumber;

	private final int fHitCount;
	private final @NonNull Element fElement;
	private final boolean fIsTemporary;
	private final @Nullable String fConditionBody;

	// intermediate calculated values
	private int fCurrentHitCount;
	private boolean fConditionEnabled;
	private boolean fConditionSuspendOnTrue;
	private boolean fLastValue;
	private ConditionChecker fChecker;


	public VMBreakpoint(@NonNull Element element, @NonNull VMNewBreakpointData data, boolean isTemporary)  {
		fID = data.getID();
		fTargetURI = data.getTargetURI();
		fElement = element;
		fLineNumber = data.getLine();
		fIsTemporary = isTemporary;

		fHitCount = data.getHitCount();
		fCurrentHitCount = 0;

		fConditionBody = data.getCondition();
		fConditionEnabled = data.getConditionEnabled();
		fConditionSuspendOnTrue = data.getConditionSuspendOnTrue();
	}

	public VMBreakpoint(@NonNull Element element, long id, int line, @NonNull String targetURI, boolean isTemporary)  {
		fID = id;
		fTargetURI = targetURI;
		fElement = element;
		fLineNumber = line;
		fIsTemporary = isTemporary;

		fHitCount = 0;
		fCurrentHitCount = 0;

		fConditionBody = null;
		fConditionEnabled = false;
		fConditionSuspendOnTrue = false;
	}

	public @NonNull String getUri() {
		return fTargetURI;
	}

	public long getID() {
		return fID;
	}

	public @NonNull Element getElement() {
		return fElement;
	}

	public boolean isTemporary() {
		return fIsTemporary;
	}

	public int getLineNumber() {
		return fLineNumber;
	}

	public int getHitCount() {
		return fCurrentHitCount;
	}

	public boolean expired() {
		return fHitCount > 0 && fCurrentHitCount >= fHitCount;
	}

	public boolean hitAndCheckIfTriggered(@NonNull VMEvaluationStepper visitor) throws CoreException {
		if(expired()) {
			return false;
		}

		if (fConditionBody != null) {
			if(!fConditionEnabled || !checkCondition(visitor)) {
				return false;
			}
		}

		if(fHitCount > 0) {
			return (++fCurrentHitCount == fHitCount);
		}

		return true;
	}

	private boolean checkCondition(@NonNull VMEvaluationStepper visitor) throws CoreException {
		String fConditionBody2 = fConditionBody;
		if ((fChecker == null) && (fConditionBody2 != null)) {
			fChecker = new ConditionChecker(fConditionBody2, fElement);
		}

		boolean prevValue = fLastValue;
		fLastValue = fChecker.checkCondition(visitor);

		if (fConditionSuspendOnTrue) {
			return fLastValue;
		}

		return fLastValue == prevValue;
	}

	@Override
	public String toString() {
		return "VM Breakpoint:" + fLineNumber + ", isTemp:" + fIsTemporary; //$NON-NLS-1$ //$NON-NLS-2$
	}
}