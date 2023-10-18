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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;

public interface VMEvaluationStepper
{
	@NonNull UnitLocation getCurrentLocation();
	@NonNull EvaluationVisitor getEvaluationVisitor();
	@NonNull List<UnitLocation> getLocationStack();
	@NonNull IStepperVisitor getStepperVisitor();
	@NonNull VMEvaluationEnvironment getVMEvaluationEnvironment();
	@NonNull VMExecutor getVMExecutor();
	void postIterate(@NonNull LoopExp element);
	void preIterate(@NonNull LoopExp element);
	void start(boolean suspendOnStartup);
	@Nullable Object visiting(@NonNull Element element);
}
