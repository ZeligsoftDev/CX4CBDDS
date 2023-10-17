/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.context.ClassContext;
import org.eclipse.ocl.pivot.internal.context.ModelContext;
import org.eclipse.ocl.pivot.internal.context.OperationContext;
import org.eclipse.ocl.pivot.internal.context.PropertyContext;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 * Implementation of the {@link OCLHelper} convenience interface.
 */
public class OCLHelperImpl implements OCLHelper
{
	protected final @NonNull OCL ocl;
	protected final @Nullable EObject context;
	//	private Diagnostic problems;
	private org.eclipse.ocl.pivot.@Nullable Class contextClass = null;
	private @Nullable Operation contextOperation = null;
	private @Nullable Property contextProperty = null;

	/**
	 * Initializes me with my environment.
	 *
	 * @param ocl the OCL environment
	 */
	public OCLHelperImpl(@NonNull OCL ocl, @Nullable EObject context) throws ParserException {
		this.ocl = ocl;
		this.context = context;
		Element asContext;
		if (context instanceof Element) {
			asContext =  (Element)context;
		}
		else {
			asContext = ((EnvironmentFactoryInternalExtension)getEnvironmentFactory()).getASOf(Element.class, context);
		}
		if (asContext instanceof org.eclipse.ocl.pivot.Class) {
			contextClass = (org.eclipse.ocl.pivot.Class)asContext;
		}
		else if (asContext instanceof Operation) {
			contextOperation = (Operation)asContext;
			contextClass = contextOperation.getOwningClass();
		}
		else if (asContext instanceof Property) {
			contextProperty = (Property)asContext;
			contextClass = contextProperty.getOwningClass();
		}
	}

	@Override
	public @NonNull ExpressionInOCL createBodyCondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getContextOperation();
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(getEnvironmentFactory(), null, contextOperation, null);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createDerivedValueExpression(@NonNull String expression) throws ParserException {
		Property contextProperty = getContextProperty();
		if (contextProperty == null) {
			throw new IllegalStateException("Undefined contextProperty");
		}
		ParserContext parserContext = new PropertyContext(getEnvironmentFactory(), null, contextProperty);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createInvariant(@NonNull String expression) throws ParserException {
		if (contextClass == null) {
			throw new IllegalStateException("Undefined contextClass");
		}
		ParserContext parserContext = new ClassContext(getEnvironmentFactory(), null, contextClass, null);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createPostcondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getContextOperation();
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(getEnvironmentFactory(), null, contextOperation, PivotConstants.RESULT_NAME);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createPrecondition(@NonNull String expression) throws ParserException {
		Operation contextOperation = getContextOperation();
		if (contextOperation == null) {
			throw new IllegalStateException("Undefined contextOperation");
		}
		ParserContext parserContext = new OperationContext(getEnvironmentFactory(), null, contextOperation, null);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @NonNull ExpressionInOCL createQuery(@NonNull String expression) throws ParserException {
		ParserContext parserContext ;
		if (contextClass != null) {
			parserContext = new ClassContext(getEnvironmentFactory(), null, contextClass, null);
		}
		else {
			parserContext = new ModelContext(getEnvironmentFactory(), null);
		}
		return parserContext.parse(contextClass, expression);
	}

	protected @NonNull ExpressionInOCL createSpecification(@NonNull String expression) throws ParserException {
		if (contextClass == null) {
			throw new IllegalStateException("Undefined contextClassifier");
		}
		ParserContext parserContext = new ClassContext(getEnvironmentFactory(), null, contextClass, null);
		return parserContext.parse(contextClass, expression);
	}

	@Override
	public @Nullable Type getContextClass() {
		return contextClass;
	}

	@Override
	public @Nullable Property getContextProperty() {
		return contextProperty;
	}

	@Override
	public @Nullable Operation getContextOperation() {
		return contextOperation;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return ocl.getEnvironmentFactory();
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return ocl.getMetamodelManager();
	}

	@Override
	public @NonNull OCL getOCL() {
		return ocl;
	}

	//	@Override
	//	public Resource.Diagnostic getProblems() {
	//		parserContext.createBaseResource(expression)
	//		return problems;
	//	}

	//	@Override
	//	public boolean isValidating() {
	//		return validating;
	//	}

	//	@Override
	//	public void setValidating(boolean validating) {
	//		this.validating = validating;
	//	}
}
