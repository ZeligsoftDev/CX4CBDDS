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
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepper;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class OCLStepperVisitor extends AbstractExtendingVisitor<@Nullable IStepper, @NonNull Object> implements IStepperVisitor
{
	public static @NonNull OCLStepperVisitor INSTANCE = new OCLStepperVisitor(OCLStepperVisitor.class);
	
	protected OCLStepperVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @NonNull IStepper getStepper(@NonNull Element object) {
		return ClassUtil.nonNullState(object.accept(this));
	}

	@Override
	public @Nullable IStepper visitElement(@NonNull Element object) {
		return NonStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		return ExpressionInOCLStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIfExp(@NonNull IfExp object) {
		return IfExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIterateExp(@NonNull IterateExp object) {
		return IterateExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitIteratorExp(@NonNull IteratorExp object) {
		return LoopExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitLetExp(@NonNull LetExp object) {
		return LetExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitOCLExpression(@NonNull OCLExpression object) {
		return PostStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitOperationCallExp(@NonNull OperationCallExp object) {
		return OperationCallExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitPropertyCallExp(@NonNull PropertyCallExp object) {
		return PropertyCallExpStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visitVariable(@NonNull Variable object) {
		return VariableStepper.INSTANCE;
	}

	@Override
	public @Nullable IStepper visiting(@NonNull Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for OCLStepperVisitor");
	}
}
