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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * ClassContext supports parsing OCL expressions in the context of a Class.
 */
public class ClassContext extends AbstractParserContext
{
	protected final org.eclipse.ocl.pivot.@Nullable Class classContext;
	protected final @Nullable Type instanceContext;
	private @NonNull String selfName = PivotConstants.SELF_NAME;

	public ClassContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, org.eclipse.ocl.pivot.@Nullable Class classContext, @Nullable Type instanceContext) {
		super(environmentFactory, uri);
		this.classContext = classContext != null ? getMetamodelManager().getPrimaryClass(classContext) : null;
		this.instanceContext = instanceContext;
	}

	@Override
	public org.eclipse.ocl.pivot.@Nullable Class getClassContext() {
		return classContext;
	}

	@Override
	public @Nullable Type getInstanceContext() {
		return instanceContext;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		conversion.getHelper().setContextVariable(expression, selfName, classContext, instanceContext);
	}

	/**
	 * @since 1.3
	 */
	public void setSelfName(@NonNull String selfName) {
		this.selfName = selfName;
	}
}
