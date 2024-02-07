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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.pivot.NamedElement;

public abstract class VMNestedEvaluationEnvironment extends AbstractVMEvaluationEnvironment
{
	protected final @NonNull VMEvaluationEnvironment rootVMEvaluationEnvironment;

	public VMNestedEvaluationEnvironment(@NonNull VMEvaluationEnvironment vmEvaluationEnvironment, @NonNull NamedElement executableObject, @Nullable Object caller) {
		super(vmEvaluationEnvironment, executableObject, caller);
		rootVMEvaluationEnvironment = vmEvaluationEnvironment.getVMRootEvaluationEnvironment();
	}

	@Override
	public @NonNull VMDebugCore getDebugCore() {
		return rootVMEvaluationEnvironment.getDebugCore();
	}

	@Override
	public @NonNull NamedElement getDebuggableElement() {
		return rootVMEvaluationEnvironment.getDebuggableElement();
	}

	public @NonNull VMEvaluationEnvironment getRootVMEvaluationEnvironment() {
		return rootVMEvaluationEnvironment;
	}
}
