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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;

public abstract class VMRootEvaluationEnvironment extends AbstractVMEvaluationEnvironment
{
    public VMRootEvaluationEnvironment(@NonNull VMExecutor vmExecutor, @NonNull NamedElement executableObject) {
		super(vmExecutor, executableObject);
	}

	public @NonNull NamedElement getDebuggableElement() {
		return executableObject;
	}

	public @NonNull VMRootEvaluationEnvironment getVMRootEvaluationEnvironment() {
		return this;
	}
}
