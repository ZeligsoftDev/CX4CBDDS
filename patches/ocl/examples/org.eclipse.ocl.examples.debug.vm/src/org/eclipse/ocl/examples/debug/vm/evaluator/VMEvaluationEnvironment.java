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

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;

public interface VMEvaluationEnvironment extends EvaluationEnvironment.EvaluationEnvironmentExtension
{
	public class StepperEntry
	{
		public final @NonNull IStepper stepper;
		public final @NonNull Element element;
		private @Nullable Map<TypedElement, Object> partialResults;
		
		public StepperEntry(@NonNull IStepper stepper, @NonNull Element element) {
			this.stepper = stepper;
			this.element = element;
		}

		public void popFrom(@NonNull VMEvaluationEnvironment evaluationEnvironment) {
			Map<TypedElement, Object> partialResults2 = partialResults;
			if (partialResults2 != null) {
				for (TypedElement element : partialResults2.keySet()) {
					if (element != null) {
						evaluationEnvironment.remove(element);
					}
				}
				partialResults2.clear();
				partialResults = null;
			}
		}

		public void pushTo(@NonNull VMEvaluationEnvironment evaluationEnvironment, @NonNull TypedElement element, @Nullable Object value) {
			Map<TypedElement, Object> partialResults2 = partialResults;
			if (partialResults2 == null) {
				partialResults = partialResults2 = new HashMap<TypedElement, Object>();
			}
			partialResults2.put(element, value);
			evaluationEnvironment.replace(element, value);
		}
	}

	@NonNull VariableFinder createVariableFinder(boolean isStoreValues);
	@NonNull Element getCurrentIP();
	@NonNull UnitLocation getCurrentLocation();
	@NonNull VMDebugCore getDebugCore();
	@NonNull NamedElement getDebuggableElement();
	int getDepth();
	long getID();
	@NonNull NamedElement getOperation();
	@NonNull Variable getPCVariable();
	@Nullable VMEvaluationEnvironment getVMParentEvaluationEnvironment();
	@NonNull VMEvaluationEnvironment getVMRootEvaluationEnvironment();
	@NonNull Stack<StepperEntry> getStepperStack();
//	@NonNull IVMContext getVMContext();
	boolean isDeferredExecution();
	void processDeferredTasks();
	@NonNull Element setCurrentIP(@NonNull Element element);
	void throwVMException(@NonNull VMRuntimeException vmRuntimeException);
}
