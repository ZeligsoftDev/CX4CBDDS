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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * EClassContext supports parsing OCL expressions in the context of an Ecore Class.
 */
public class EClassContext extends AbstractParserContext
{
	protected final @Nullable EClassifier eClassContext;
	private Type classContext = null;

	public EClassContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, @Nullable EClassifier eClassContext) {
		super(environmentFactory, uri);
		this.eClassContext = eClassContext;
	}

	@Override
	public @Nullable Type getClassContext() {
		if (classContext == null) {
			classContext = getMetamodelManager().getASOfEcore(Type.class, eClassContext);
		}
		return classContext;
	}

	@Override
	public void initialize(@NonNull Base2ASConversion conversion, @NonNull ExpressionInOCL expression) {
		super.initialize(conversion, expression);
		Type classContext = getClassContext();
		if (classContext != null) {
			conversion.getHelper().setContextVariable(expression, PivotConstants.SELF_NAME, classContext, null);
		}
	}
}
