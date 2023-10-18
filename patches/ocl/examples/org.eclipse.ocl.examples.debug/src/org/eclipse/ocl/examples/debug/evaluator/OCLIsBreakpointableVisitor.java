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
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;

public class OCLIsBreakpointableVisitor extends AbstractExtendingVisitor<Boolean, Object>
{
	public static final @NonNull OCLIsBreakpointableVisitor INSTANCE = new OCLIsBreakpointableVisitor(OCLIsBreakpointableVisitor.class);
	
	private OCLIsBreakpointableVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitElement(@NonNull Element object) {
		return ValidBreakpointLocator.IS_START; //null;
	}

	@Override
	public @Nullable Boolean visitLoopExp(@NonNull LoopExp object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitOCLExpression(@NonNull OCLExpression object) {
		return ValidBreakpointLocator.IS_START;
	}

	@Override
	public @Nullable Boolean visitOperationCallExp(@NonNull OperationCallExp object) {
		return ValidBreakpointLocator.IS_END;
	}

	@Override
	public @Nullable Boolean visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unimplemented " + getClass().getName() + " for " + visitable.eClass().getName());
	}
}
