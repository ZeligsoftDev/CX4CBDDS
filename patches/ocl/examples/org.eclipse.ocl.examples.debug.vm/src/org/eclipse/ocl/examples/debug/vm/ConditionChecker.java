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
package org.eclipse.ocl.examples.debug.vm;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMEvaluationStepper;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;

public class ConditionChecker {

	public static final int ERR_CODE_COMPILATION = 100;
	public static final int ERR_CODE_EVALUATION = 110;
	
//	private final @NonNull String fConditionBody;
//	private final @NonNull Element fTargetASTElement;
	
//	private OCLExpression fConditionAST;
	private IStatus fConditionError;


	public ConditionChecker(@NonNull String conditionBody, @NonNull Element targetASTElement) {
//		fConditionBody = conditionBody;
//		fTargetASTElement = targetASTElement;
	}
		
	public Object evaluate(@NonNull VMEvaluationStepper mainEvaluator) throws CoreException {
		OCLExpression condition = null; //getConditionAST();
		if (fConditionError != null) {
			throw new CoreException(fConditionError);
		}
		
		assert condition != null;
		// FIXME - use a watching thread to interrupt infinite loop execution
		EvaluationVisitor dedicatedVisitor = mainEvaluator.getEvaluationVisitor(); /*getClonedEvaluator();*/

		try {
			return condition.accept(dedicatedVisitor);
		} catch (Throwable e) {
			throw new CoreException(new Status(IStatus.ERROR, mainEvaluator.getVMExecutor().getPluginId(), ERR_CODE_EVALUATION, e.toString(), e));
		}
	}

	public boolean checkCondition(@NonNull VMEvaluationStepper mainEvaluator) throws CoreException {
		return Boolean.TRUE.equals(evaluate(mainEvaluator));
	}
	
	public EClassifier getConditionType() {
//		if (fConditionAST != null) { 
//			return fConditionAST.getType();
//		}
		return null;
	}
}
