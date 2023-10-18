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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;

public class OperationCallExpStepper extends CallExpStepper
{
	public static @NonNull OperationCallExpStepper INSTANCE = new OperationCallExpStepper();

	@Override
	public @Nullable Element isPostStoppable(@NonNull VMEvaluationStepper vmEvaluationVisitor, @NonNull Element childElement, @Nullable Object result) {
		EObject parentElement = childElement.eContainer();
		if (parentElement instanceof OperationCallExp) {
			OperationCallExp callExp = (OperationCallExp)parentElement;
			List<OCLExpression> arguments = callExp.getOwnedArguments();
			int size = arguments.size();
			if (size <= 0) {									// No arguments so just done source
				return callExp;
			}
			int index = arguments.indexOf(childElement);
			if (index >= size-1) {								// Just done last argument
				return callExp;
			}
			else {
				return getFirstElement(vmEvaluationVisitor, arguments.get(index >= 0 ? index+1 : 0));
			}
		}
		return super.isPostStoppable(vmEvaluationVisitor, childElement, result);
	}
}
