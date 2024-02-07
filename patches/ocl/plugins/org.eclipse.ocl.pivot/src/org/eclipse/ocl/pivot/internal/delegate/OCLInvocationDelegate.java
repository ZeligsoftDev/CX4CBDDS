/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicInvocationDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.utilities.PivotConstantsInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.SemanticException;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

/**
 * An implementation of an operation-invocation delegate for OCL body
 * expressions.
 */
public class OCLInvocationDelegate extends BasicInvocationDelegate
{
	protected final @NonNull OCLDelegateDomain delegateDomain;
	private Operation operation = null;
	private @Nullable ExpressionInOCL query = null;

	/**
	 * Initializes me with my operation.
	 *
	 * @param operation
	 *            the operation that I handle
	 */
	public OCLInvocationDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EOperation operation) {
		super(operation);
		this.delegateDomain = delegateDomain;
	}

	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		assert target != null;
		try {
			EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(target);
			Executor executor = PivotUtil.getExecutor(target);
			ModelManager modelManager = executor.getModelManager();
			MetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
			ExpressionInOCL query2 = query;
			if (query2 == null) {
				Operation operation2 = operation;
				NamedElement namedElement = delegateDomain.getPivot(NamedElement.class, ClassUtil.nonNullEMF(eOperation));
				if (namedElement instanceof Operation) {
					operation2 = operation = (Operation) namedElement;
					query2 = query = InvocationBehavior.INSTANCE.getQueryOrThrow(metamodelManager, operation2);
					InvocationBehavior.INSTANCE.validate(operation2);
				}
				else if (namedElement instanceof Constraint) {
					Constraint constraint = (Constraint)namedElement;
					query2 = query = ValidationBehavior.INSTANCE.getQueryOrThrow(metamodelManager, constraint);
					ValidationBehavior.INSTANCE.validate(constraint);
				}
				else if (namedElement != null) {
					throw new OCLDelegateException(new SemanticException("Unsupported InvocationDelegate for a " + namedElement.eClass().getName())) ;
				}
				else {
					throw new OCLDelegateException(new SemanticException("Unsupported InvocationDelegate for a null")) ;
				}
			}
			return evaluate(environmentFactory, modelManager, target, arguments);
		}
		catch (EvaluationException e) {
			throw new OCLDelegateException(new EvaluationException(e, PivotMessagesInternal.EvaluationResultIsInvalid_ERROR_, operation));
		}
	}

	@Deprecated /* @deprecated not usedc */
	protected Object evaluate(@NonNull OCL ocl, @NonNull ExpressionInOCL query2, InternalEObject ecoreObject, List<?> arguments) {
		return null;
	}

	/**
	 * @since 1.7
	 */
	protected Object evaluate(@NonNull EnvironmentFactory environmentFactory, @NonNull ModelManager modelManager, InternalEObject ecoreObject, List<?> arguments) {
		ExpressionInOCL query2 = query;
		assert query2 != null;
		Executor savedExecutor = ThreadLocalExecutor.basicGetExecutor();
		try {
			if (savedExecutor != null) {
				ThreadLocalExecutor.setExecutor(null);		// New evaluation needs new root EvaluationEnvironment and so new Executor, but old modelManager
			}
			IdResolver idResolver = environmentFactory.getIdResolver();
			EvaluationEnvironment evaluationEnvironment = environmentFactory.createEvaluationEnvironment(query2, modelManager);
			Object boxedObject = idResolver.boxedValueOf(ecoreObject);
			VariableDeclaration contextVariable = PivotUtil.getOwnedContext(query2);
			OCLExpression expression = PivotUtil.getOwnedBody(query2);
			evaluationEnvironment.add(contextVariable, boxedObject);
			List<Variable> parms =  query2.getOwnedParameters();
			if (!parms.isEmpty()) {
				// bind arguments to parameter names
				for (int i = 0; i < parms.size(); i++) {
					Object argument = arguments.get(i);
					Object boxedArgument = idResolver.boxedValueOf(argument);
					evaluationEnvironment.add(ClassUtil.nonNullModel(parms.get(i)), boxedArgument);
				}
			}
			//			Variable resultVariable = specification.getResultVariable();
			//			if (resultVariable != null) {
			//				myEnv.add(resultVariable, null);
			//			}
			EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(evaluationEnvironment);
			//	try {
			Object boxedResult = expression.accept(evaluationVisitor);
			return idResolver.ecoreValueOf(eOperation.getEType().getInstanceClass(), boxedResult);
			//	} catch (EvaluationHaltedException e) {
			//		throw e;
			//	}
		}
		finally {
			ThreadLocalExecutor.setExecutor(savedExecutor);		// Restore invoker's executor
		}
	}

	public @NonNull Operation getOperation() {
		Operation operation2 = operation;
		if (operation2 == null) {
			NamedElement pivot = delegateDomain.getPivot(NamedElement.class, ClassUtil.nonNullEMF(eOperation));
			if (pivot instanceof Operation) {
				operation2 = operation = (Operation) pivot;
			}
			if (operation2 == null) {
				throw new OCLDelegateException(new SemanticException("No pivot property for " + eOperation)) ;
			}
		}
		return operation2;
	}

	public @NonNull ExpressionInOCL getQueryOrThrow(@NonNull MetamodelManager metamodelManager, @NonNull Constraint constraint) {
		LanguageExpression specification = constraint.getOwnedSpecification();
		if (specification == null) {
			throw new OCLDelegateException(new SemanticException(PivotMessagesInternal.MissingSpecificationBody_ERROR_, constraint.getContext(), PivotConstantsInternal.BODY_ROLE));
		}
		try {
			return ((EnvironmentFactoryInternalExtension)metamodelManager.getEnvironmentFactory()).parseSpecification(specification);
		} catch (ParserException e) {
			throw new OCLDelegateException(e);
		}
	}

	@Override
	public String toString() {
		if (operation != null) {
			return "<" + delegateDomain.getURI() + ":invocation> " + operation; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			String name = eOperation.getEContainingClass().getEPackage().getName()
					+ "::" + eOperation.getEContainingClass().getName()
					+ "." + eOperation.getName();
			return "<" + delegateDomain.getURI() + ":invocation> " + name; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
