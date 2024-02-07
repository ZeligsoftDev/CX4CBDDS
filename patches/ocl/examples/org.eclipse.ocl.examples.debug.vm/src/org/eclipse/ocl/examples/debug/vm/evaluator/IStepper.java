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
package org.eclipse.ocl.examples.debug.vm.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.pivot.Element;

/**
 * An IStepper provides the element-type specific strategy for a variety of actions while stepping through source code.
 */
public interface IStepper
{
	/**
	 * Return the source descriptor for element.
	 */
	@NonNull UnitLocation createUnitLocation(@NonNull VMEvaluationEnvironment evalEnv, @NonNull Element element);

	@Nullable Element getFirstElement(@NonNull VMEvaluationStepper vmEvaluationVisitor, @Nullable Element element);
	
	/**
	 * Return null if no suspension is required after execution of childElement gave result, else return the next element to be executed. 
	 */
	@Nullable Element isPostStoppable(@NonNull VMEvaluationStepper rootVMEvaluationVisitor, @NonNull Element childElement, @Nullable Object result);

	/**
	 * Return true if execution may be suspended before executing element.
	 */
	boolean isPreStoppable(@NonNull VMEvaluationStepper rootVMEvaluationVisitor, @NonNull Element element);
}
