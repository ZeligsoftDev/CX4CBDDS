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
package org.eclipse.ocl.examples.debug.core;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.EvaluationContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMContext;
import org.eclipse.ocl.examples.debug.vm.evaluator.VMContext;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

public class OCLEvaluationContext extends EvaluationContext
{
	protected static @NonNull IVMContext createVMContext(@Nullable ExpressionInOCL expressionObject, @Nullable EObject contextObject) {
		EnvironmentFactoryInternal environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
		if (environmentFactory == null) {
			environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(OCL.NO_PROJECTS, null);
		}
		return new VMContext(environmentFactory);
	}

	private final @Nullable ExpressionInOCL expressionObject;
	private final @Nullable EObject contextObject;
	private final @NonNull URI constraintURI;
	private final @Nullable URI contextURI;

	public OCLEvaluationContext(@NonNull ExpressionInOCL expressionObject, @Nullable EObject contextObject) {
		super(createVMContext(expressionObject, contextObject));
		this.expressionObject = expressionObject;
		this.contextObject = contextObject;
		this.constraintURI = ClassUtil.nonNullState(EcoreUtil.getURI(expressionObject));
		this.contextURI = contextObject != null ? EcoreUtil.getURI(contextObject) : null;
	}

	public OCLEvaluationContext(@NonNull URI constraintURI, @NonNull URI contextURI) {
		super(createVMContext(null, null));
		this.expressionObject = null;
		this.contextObject = null;
		this.constraintURI = constraintURI;
		this.contextURI = contextURI;
	}

/*	protected @Nullable MetamodelManager findMetamodelManager() {
		ExpressionInOCL expressionObject2 = expressionObject;
		if (expressionObject2 != null) {
			Resource eResource = expressionObject2.eResource();
			if (eResource != null) {
				MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(eResource);
				if (metamodelManager != null) {
					return metamodelManager;
				}
			}
		}
		EObject contextObject2 = contextObject;
		if (contextObject2 != null) {
			Resource eResource = contextObject2.eResource();
			if (eResource != null) {
				MetamodelManager metamodelManager = PivotUtilInternal.getMetamodelManager(eResource);
				if (metamodelManager != null) {
					return metamodelManager;
				}
			}
		}
		return null;
	} */

	public @NonNull URI getConstraintURI() {
		return constraintURI;
	}

	public @Nullable EObject getContextObject() {
		return contextObject;
	}

	public @Nullable URI getContextURI() {
		return contextURI;
	}

	@Override
	public @NonNull URI getDebuggableURI() {
		return constraintURI;
	}

	public @Nullable ExpressionInOCL getExpressionObject() {
		return expressionObject;
	}
}
