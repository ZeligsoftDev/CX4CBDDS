/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationException;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.context.EInvocationContext;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateDomain;
import org.eclipse.ocl.pivot.internal.delegate.OCLDelegateException;
import org.eclipse.ocl.pivot.internal.delegate.OCLQueryDelegateFactory;
import org.eclipse.ocl.pivot.internal.helper.BasicQueryImpl;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.Query;
import org.eclipse.ocl.pivot.utilities.SemanticException;
import org.eclipse.ocl.pivot.utilities.StringUtil;

/**
 * An implementation of a query delegate for OCL expressions.
 *
 * @see OCLQueryDelegateFactory
 * @since 3.1
 */
public class OCLQueryDelegate implements QueryDelegate
{
	protected @NonNull OCLDelegateDomain delegateDomain;
	protected final @NonNull EInvocationContext parserContext;
	protected final @NonNull String expression;
	private ExpressionInOCL specification = null;

	/**
	 * Initializes me with my domain, context, variables, and expression.
	 *
	 * @param delegateDomain
	 *            my domain
	 * @param context
	 *            my context
	 * @param parameters
	 *            name and types of variables used in my expression
	 * @param expression
	 *            the expression that I handle
	 */
	public OCLQueryDelegate(@NonNull OCLDelegateDomain delegateDomain, @NonNull EClassifier context, @Nullable Map<String, EClassifier> parameters, @NonNull String expression) {
		this.delegateDomain = delegateDomain;
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(context);
		this.parserContext = new EInvocationContext(environmentFactory, null, context, parameters);
		this.expression = expression;
	}

	/**
	 * Executes the query for the specified <tt>target</tt> object. The result
	 * is the OCL evaluation result which may be a Number, String, Collection or
	 * other object for normal returns or a NullLiteralExp for null, or an
	 * InvalidLiteralExp for invalid.
	 *
	 * @param target
	 *            the object on which to execute the query; this must be an
	 *            instance of the context with which the delegate was created
	 * @param arguments
	 *            a map of variable names to values; these must correspond to
	 *            the variables with which the delegate was created
	 * @return the query's result
	 * @throws InvocationTargetException
	 *             in case of failure to prepare or execute the query, usually
	 *             because of an exception
	 */
	@Override
	public Object execute(@Nullable Object target, Map<String, ?> arguments) throws InvocationTargetException {
		@NonNull Map<String, ?> nonNullArguments = (arguments != null ? arguments : (Map<String, ?>)Collections.<String, Object>emptyMap());
		try {
			if (specification == null) {
				prepare();
			}
			@SuppressWarnings("null")
			@NonNull ExpressionInOCL nonNullSpecification = specification;
			EnvironmentFactoryInternal environmentFactory = parserContext.getEnvironmentFactory();
			IdResolver idResolver = environmentFactory.getIdResolver();
			Object targetValue = idResolver.boxedValueOf(target);
			Type requiredType = PivotUtil.getType(PivotUtil.getOwnedContext(nonNullSpecification));
			Type targetType = idResolver.getStaticTypeOfValue(requiredType, targetValue);
			if ((requiredType == null) || !targetType.conformsTo(environmentFactory.getStandardLibrary(), requiredType)) {
				String message = StringUtil.bind(PivotMessagesInternal.WrongContextClassifier_ERROR_, targetType, requiredType);
				throw new OCLDelegateException(new SemanticException(message));
			}
			List<Variable> parameterVariables = nonNullSpecification.getOwnedParameters();
			int argCount = arguments != null ? arguments.size() : 0;
			if (parameterVariables.size() != argCount) {
				String message = StringUtil.bind(PivotMessagesInternal.MismatchedArgumentCount_ERROR_, argCount, parameterVariables.size());
				throw new OCLDelegateException(new SemanticException(message));
			}
			Query query = new BasicQueryImpl(environmentFactory, nonNullSpecification);
			EvaluationEnvironment env = query.getEvaluationEnvironment(target);
			for (Variable parameterVariable : parameterVariables) {
				// bind arguments to parameter names
				String name = parameterVariable.getName();
				Object object = nonNullArguments.get(name);
				if ((object == null) && !nonNullArguments.containsKey(name)) {
					String message = StringUtil.bind(PivotMessagesInternal.EvaluationResultIsInvalid_ERROR_, nonNullSpecification.getBody());
					throw new OCLDelegateException(new SemanticException(message));
				}
				Object value = idResolver.boxedValueOf(object);
				requiredType = PivotUtil.getType(parameterVariable);
				targetType = idResolver.getStaticTypeOfValue(requiredType, value);
				if (!targetType.conformsTo(environmentFactory.getStandardLibrary(), requiredType)) {
					String message = StringUtil.bind(PivotMessagesInternal.MismatchedArgumentType_ERROR_, name, targetType, requiredType);
					throw new OCLDelegateException(new SemanticException(message));
				}
				env.add(parameterVariable, value);
			}
			Object result = query.evaluateEcore(target);
			return result;
		}
		catch (InvocationTargetException e) {
			throw e;
		}
		catch (EvaluationException e) {
			String message = StringUtil.bind(PivotMessagesInternal.EvaluationResultIsInvalid_ERROR_, expression);
			throw new InvocationTargetException(new EvaluationException(message));
		}
		catch (WrappedException e) {
			throw new InvocationTargetException(e.getCause());
		}
		catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

	/**
	 * Prepares the query wrapping any exceptions as InvocationTargetException.
	 * This method is lazily invoked from execute, but may be invoked eagerly
	 * to detect compilation errors earlier or incur compilation costs at a more
	 * convenient time.
	 *
	 * @throws InvocationTargetException wrapping any parser, io exceptions
	 */
	@Override
	public void prepare() throws InvocationTargetException {
		try {
			specification = parserContext.parse(parserContext.getClassContext(), expression);
		} catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

	@Override
	public String toString() {
		ExpressionInOCL specification2 = specification;
		OCLExpression bodyExpression = specification2 != null ? specification2.getOwnedBody() : null;
		if (bodyExpression != null) {
			return "<" + delegateDomain.getURI() + ":query> " + bodyExpression; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return "<" + delegateDomain.getURI() + ":query> " + expression; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
