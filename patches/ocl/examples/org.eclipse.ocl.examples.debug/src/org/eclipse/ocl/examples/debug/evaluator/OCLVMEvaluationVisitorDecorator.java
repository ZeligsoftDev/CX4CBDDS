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
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.AbstractEvaluationVisitorDecorator;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

/**
 * OCLVMEvaluationVisitorDecorator is the class for ...
 */
public abstract class OCLVMEvaluationVisitorDecorator extends AbstractEvaluationVisitorDecorator<EvaluationVisitor>
        implements EvaluationVisitor {
	
	
	public OCLVMEvaluationVisitorDecorator(@NonNull EvaluationVisitor decorated) {
		super(decorated);
	}

	/**
     * Delegates to my decorated visitor.
     */
//	public @NonNull EvaluationVisitor getEvaluator() {
//		return delegate.getEvaluator();
//	}
	
	@Override
	public Object safeVisit(@Nullable Visitable v) {
		if (v == null) {
			throw new InvalidValueException("null expression");
		}
		try {
			Object result = v.accept(delegate);
			assert ValueUtil.isBoxed(result);	// Make sure Integer/Real are boxed, invalid is an exception, null is null
			return result;
		} catch (InvalidValueException e) {
			throw e;
		} catch (Exception e) {
			throw new InvalidValueException(e, "Evaluation Failure");
		}
	}

    /**
     * Delegates to my decorated visitor.
     */
    @Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
    	return delegate.visiting(visitable);
	}
}
