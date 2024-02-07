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

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public abstract class VMDebugElement extends DebugElement
{	
	public VMDebugElement(@Nullable IVMDebugTarget debugTarget) {
		super(debugTarget);
	}

	public @NonNull VMDebugCore getDebugCore() {
		return getOCLDebugTarget().getDebugCore();
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getModelIdentifier() {
		return getDebugTarget().getModelIdentifier();
	}	

	@SuppressWarnings("null")
	public @NonNull IVMDebugTarget getOCLDebugTarget() {
		return (IVMDebugTarget) getDebugTarget(); 
	}	
}
