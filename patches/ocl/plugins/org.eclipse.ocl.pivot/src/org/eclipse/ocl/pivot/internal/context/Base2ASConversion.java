/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.PivotHelper;

public interface Base2ASConversion
{
	/**
	 * @since 1.18
	 */
	@NonNull PivotHelper getHelper();
	void setContextVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull String selfVariableName, @Nullable Type contextType, @Nullable Type contextInstance);
	void setClassifierContext(@NonNull ExpressionInOCL pivotSpecification, @NonNull Type contextType);
	void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull List<Parameter> operationParameterVariables);
	void setParameterVariables(@NonNull ExpressionInOCL pivotSpecification, @NonNull Map<String, Type> parameters);
	void setResultVariable(@NonNull ExpressionInOCL pivotSpecification, @NonNull Operation contextOperation, @NonNull String resultName);
}