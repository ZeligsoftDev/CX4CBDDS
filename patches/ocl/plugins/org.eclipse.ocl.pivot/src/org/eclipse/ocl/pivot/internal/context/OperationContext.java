/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * OperationContext supports parsing OCL expressions in the context of an Operation.
 */
public class OperationContext extends ClassContext
{
	private final @NonNull Operation operation;
	private final @Nullable String resultVariableName;		// Null for none

	public OperationContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, @NonNull Operation operation, @Nullable String resultVariableName) {
		super(environmentFactory, uri, ClassUtil.nonNullModel(operation.getOwningClass()), null);
		this.operation = operation;
		this.resultVariableName = resultVariableName;
	}

	@Override
	public @Nullable Element getElementContext() {
		return operation;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.setParameterVariables(expression, ClassUtil.nonNullEMF(operation.getOwnedParameters()));
		String resultVariableName2 = resultVariableName;
		if (resultVariableName2 != null) {
			conversion.setResultVariable(expression, operation, resultVariableName2);
		}
	}

	/**
	 * @since 1.4
	 */
	@Override
	protected Element getMessageContext() {
		return getOperation();
	}

	public @NonNull Operation getOperation() {
		return operation;
	}
}
