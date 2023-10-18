/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.launching;

import org.eclipse.jdt.annotation.NonNull;

public interface OCLLaunchConstants
{
	static final @NonNull String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.ocl.examples.debug.launching.OCLLaunchConfigurationDelegate";

	/**
	 * ILaunchConfiguration String attribute for the OCL constraint passed as a URI string.
	 */
	static final @NonNull String CONSTRAINT_URI = "constraint";

	/**
	 * ILaunchConfiguration String attribute for the context element passed in memory as an EObject.
	 */
	static final @NonNull String CONTEXT_OBJECT = "contextObject";

	/**
	 * ILaunchConfiguration String attribute for the context element passed as a URI string.
	 */
	static final @NonNull String CONTEXT_URI = "context";

	/**
	 * ILaunchConfiguration String attribute for the OCL expression passed in memory as an ExpressionInOCL.
	 */
	static final @NonNull String EXPRESSION_OBJECT = "expressionObject";

	/**
	 * ILaunchConfiguration String attribute for the resource containing the context element when the element has not been selected.
	 */
	static final @NonNull String MODEL_URI = "model";
	/**
	 * ILaunchConfiguration String attribute for the OCL resource containing the constraint when the constraint has not been selected.
	 */
	static final @NonNull String OCL_KEY = "ocl";
}
