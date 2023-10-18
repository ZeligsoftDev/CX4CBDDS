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
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class VMContext implements IVMContext
{
	protected final EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension environmentFactory;
	private IVMDebuggerShell shell;
	
	public VMContext(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = (EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension)environmentFactory;
	}

	public EnvironmentFactoryInternal.@NonNull EnvironmentFactoryInternalExtension getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull IVMDebuggerShell getShell() {
		return ClassUtil.nonNullState(shell);
	}

	public boolean keepDebug() {
		return true;
	}

	public void setShell(@Nullable IVMDebuggerShell shell) {
		this.shell = shell;
	}
}
