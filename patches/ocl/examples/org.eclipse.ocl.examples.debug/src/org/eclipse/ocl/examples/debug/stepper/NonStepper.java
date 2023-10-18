/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.stepper;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;

public class NonStepper extends AbstractStepper
{
	public static @NonNull NonStepper INSTANCE = new NonStepper();
	
	@Override
	public @Nullable Element isPostStoppable(@NonNull VMEvaluationStepper rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		return null;
	}
}
