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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Variable;

public class IterateExpStepper extends LoopExpStepper
{
	public static @NonNull IterateExpStepper INSTANCE = new IterateExpStepper();

	@Override
	public @Nullable Element isPostStoppable(@NonNull VMEvaluationStepper vmEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		EObject parentElement = childElement.eContainer();
		if (parentElement instanceof Variable) {
			parentElement = parentElement.eContainer();
		}
		if (parentElement instanceof IterateExp) {
			IterateExp iterateExp = (IterateExp)parentElement;
			if (childElement == iterateExp.getOwnedSource()) {
				Variable accumulator = iterateExp.getOwnedResult();
				if (accumulator != null) {
					return getFirstElement(vmEvaluationVisitor, accumulator);
				}
			}
		}
		return super.isPostStoppable(vmEvaluationVisitor, childElement, result);
	}
}
