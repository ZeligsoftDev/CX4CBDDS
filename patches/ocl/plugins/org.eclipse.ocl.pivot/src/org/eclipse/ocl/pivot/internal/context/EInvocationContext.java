/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * EInvocationContext supports parsing OCL expressions in the context of a query,
 * which is an Ecore Class and Ecore Parameters.
 */
public class EInvocationContext extends EClassContext
{
	private final Map<String, EClassifier> eParameters;
	private Map<String, Type> parameters = null;

	public EInvocationContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, @Nullable EClassifier eClassContext, @Nullable Map<String, EClassifier> eParameters) {
		super(environmentFactory, uri, eClassContext);
		this.eParameters = eParameters;
	}

	public @NonNull Map<String, Type> getParameters() {
		if (parameters == null) {
			parameters = new HashMap<String, Type>();
			if (eParameters != null) {
				for (Map.Entry<String, EClassifier> entry : eParameters.entrySet()) {
					Type type = getMetamodelManager().getASOfEcore(Type.class, entry.getValue());
					parameters.put(entry.getKey(), type);
				}
			}
		}
		@SuppressWarnings("null")
		@NonNull Map<String, Type> nonNullParameters = parameters;
		return nonNullParameters;
	}

	/**
	 * @since 1.4
	 */
	@Override
	protected @NonNull String getRole() {
		return PivotConstantsInternal.QUERY_ROLE;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.setParameterVariables(expression, getParameters());
	}
}
