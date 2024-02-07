/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 * @author Karsten Thoms
 * @author Ed Merks - Bug#418156
 */
public class OperationCall extends FeatureCall {
	private static final Expression[] NO_EXPRESSION = new Expression[0];
	private static final Object[] NO_PARAMS = new Object[0];
	private static final Set<String> OPERATORS = new HashSet<String>();
	static {
		OPERATORS.add("+");
		OPERATORS.add("-");
		OPERATORS.add("*");
		OPERATORS.add("/");
		OPERATORS.add("==");
		OPERATORS.add("!=");
		OPERATORS.add(">");
		OPERATORS.add(">=");
		OPERATORS.add("<");
		OPERATORS.add("<=");
		OPERATORS.add("!");
	}

	private final Expression[] params;

	public OperationCall(final Identifier name, final Expression target, final Expression... params) {
		super(name, target);
		this.params = params.length > 0 ? params : NO_EXPRESSION;
	}

	public Expression[] getParams() {
		return params;
	}

	public List<Expression> getParamsAsList() {
		return Arrays.asList(params);
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		// evaluate from left to right
		// first the target
		Object targetObj = null;
		if (getTarget() != null) {
			targetObj = getTarget().evaluate(ctx);
		}
		// then the parameters in the defined order
		Object[] evaluatedParams = NO_PARAMS;
		if (getParams().length > 0) {
			evaluatedParams = new Object[getParams().length];
			for (int i = 0; i < getParams().length; i++) {
				evaluatedParams[i] = getParams()[i].evaluate(ctx);
			}
		}

		final String nameValue = getName().toString();
		if (getTarget() == null) {
			// extension
			final Extension f = ctx.getExtension(nameValue, evaluatedParams);
			if (f != null) {
				try {
					return evaluate(f, evaluatedParams, ctx);
				} catch (EvaluationException e) {
					e.addStackElement(this, ctx);
					throw e;
				}
			}

			// implicit
			final Variable var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
			if (var == null) {
				throw new EvaluationException("Couldn't find extension '" + nameValue + getParamTypes(evaluatedParams, ctx) + "'!", this, ctx);
			}
			targetObj = var.getValue();
		}

		// operation
		Operation op = ctx.findOperation(nameValue, targetObj, evaluatedParams);
		if (op != null) {
			return evaluate(op, targetObj, evaluatedParams, ctx);
		}
		// extension as members
		Object[] ps = new Object[evaluatedParams.length + 1];
		ps[0] = targetObj;
		System.arraycopy(evaluatedParams, 0, ps, 1, evaluatedParams.length);
		Extension f = ctx.getExtension(getName().toString(), ps);
		if (f != null) {
			try {
				return evaluate(f, ps, ctx);
			} catch (EvaluationException e) {
				e.addStackElement(this, ctx);
				throw e;
			}
		}

		if (targetObj instanceof Collection<?>) {
			final List<Object> result = new ArrayList<Object>();
			final Collection<?> col = (Collection<?>) targetObj;
			for (Object element : col) {
				// operation
				op = ctx.findOperation(nameValue, element, evaluatedParams);
				if (op != null) {
					final Object r = evaluate(op, element, evaluatedParams, ctx);
					if (r instanceof Collection<?>) {
						result.addAll((Collection<?>) r);
					} else {
						result.add(r);
					}
				} else if (element == null) {
					// collection contains null elements
					// add null as result or throw exception, depending on
					// NullEvaluationHandler
					result.add(ctx.handleNullEvaluation(this));
				} else {
					// extension as members
					ps = new Object[evaluatedParams.length + 1];
					ps[0] = element;
					System.arraycopy(evaluatedParams, 0, ps, 1, evaluatedParams.length);
					f = ctx.getExtension(nameValue, ps);
					if (f != null) {
						Object r = null;
						try {
							r = evaluate(f, ps, ctx);
						} catch (EvaluationException e) {
							e.addStackElement(this, ctx);
							throw e;
						}
						if (r instanceof Collection<?>) {
							result.addAll((Collection<?>) r);
						} else {
							result.add(r);
						}
					} else {
						throw new EvaluationException("Couldn't find operation '" + nameValue + getParamTypes(evaluatedParams, ctx) + "' for "
								+ ctx.getType(targetObj).getName() + "!", this, ctx);
					}
				}
			}
			return result;
		}

		if (targetObj != null) {
			throw new EvaluationException("Couldn't find operation '" + nameValue + getParamTypes(evaluatedParams, ctx) + "' for "
					+ ctx.getType(targetObj).getName() + ".", this, ctx);
		}
		return ctx.handleNullEvaluation(this);

	}

	private String getParamTypes(final Object[] params2, final ExecutionContext ctx) {
		final StringBuffer buff = new StringBuffer("(");
		for (int i = 0; i < params2.length; i++) {
			final Type type = ctx.getType(params2[i]);
			buff.append(type.getName());
			if ((i + 1) < params2.length) {
				buff.append(",");
			}
		}
		return buff.append(")").toString();
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type[] paramTypes = new Type[params.length];
		if (params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				if (params[i] == null) {
					return null;
				}
				paramTypes[i] = params[i].analyze(ctx, issues);
				if (paramTypes[i] == null) {
					return null;
				}
			}
		}

		// extension
		Type targetType = null;
		if (getTarget() == null) {
			Extension f = null;
			try {
				f = ctx.getExtensionForTypes(getName().toString(), paramTypes);
			} catch (final Exception e) {
				issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Error parsing extensions : " + e.getMessage(), this));
			}
			if (f != null) {
				return ctx.getReturnType(f, paramTypes, issues);
			}
			final Variable var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
			if (var != null) {
				targetType = (Type) var.getValue();
			} else {
				issues.add(new AnalysationIssue(AnalysationIssue.FEATURE_NOT_FOUND, "Couldn't find extension : " + toString(), this));
			}
		} else {
			targetType = getTarget().analyze(ctx, issues);
		}
		if (targetType == null) {
			return null;
		}
		// operation
		Operation op = targetType.getOperation(getName().toString(), paramTypes);
		if (op != null) {
			return op.getReturnType(targetType, paramTypes);
		}
		// extension as members
		final int issueSize = issues.size();
		Type rt = getExtensionsReturnType(ctx, issues, paramTypes, targetType);
		if (rt != null) {
			return rt;
		} else if (issueSize < issues.size()) {
			// Internal error was added, most probably broken extension
			return null;
		}
		String additionalMsg = "";
		if (targetType instanceof ParameterizedType) {
			final Type innerType = ((ParameterizedType) targetType).getInnerType();
			op = innerType.getOperation(getName().toString(), paramTypes);
			if (op != null) {
				rt = op.getReturnType();
				if (rt instanceof ParameterizedType) {
					rt = ((ParameterizedType) rt).getInnerType();
				}
				return ctx.getListType(rt);
			}
			rt = getExtensionsReturnType(ctx, issues, paramTypes, innerType);
			if (rt != null) {
				if (rt instanceof ParameterizedType) {
					rt = ((ParameterizedType) rt).getInnerType();
				}
				return ctx.getListType(rt);
			}
			additionalMsg = " or type '" + innerType + "'";
		}

		issues.add(new AnalysationIssue(AnalysationIssue.FEATURE_NOT_FOUND, "Couldn't find operation '" + getName().toString()
				+ getParamsString(paramTypes) + "' for type '" + targetType.getName() + "'" + additionalMsg, this));
		return null;

	}

	private Type getExtensionsReturnType(final ExecutionContext ctx, final Set<AnalysationIssue> issues, final Type[] paramTypes,
			final Type targetType) {
		Type returnType = null;
		final Type[] pts = new Type[paramTypes.length + 1];
		final Set<AnalysationIssue> internalIssues = new HashSet<AnalysationIssue>();
		pts[0] = targetType;
		System.arraycopy(paramTypes, 0, pts, 1, paramTypes.length);
		Extension f = null;
		try {
			f = ctx.getExtensionForTypes(getName().toString(), pts);
		} catch (final Exception e) {
			internalIssues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Error parsing extensions : " + e.getMessage(), this));
		}
		if (f != null) {
			returnType = ctx.getReturnType(f, pts, internalIssues);
		} else if (getTarget() == null) { // try without implicite this
			try {
				f = ctx.getExtensionForTypes(getName().toString(), paramTypes);
			} catch (final Exception e) {
				internalIssues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR, "Error parsing extensions : " + e.getMessage(), this));
			}
			if (f != null) {
				returnType = ctx.getReturnType(f, pts, internalIssues);
			}
		}
		return returnType;
	}

	private String getParamsString(final Type[] paramTypes) {
		final StringBuffer buff = new StringBuffer("(");
		for (int i = 0; i < paramTypes.length; i++) {
			final Type type = paramTypes[i];
			buff.append(type.getName());
			if ((i + 1) < paramTypes.length) {
				buff.append(",");
			}
		}
		return buff.append(")").toString();
	}

	@Override
	protected String toStringInternal() {
		StringBuilder b = new StringBuilder();
		if (getTarget() != null) {
			b.append(getTarget().toStringInternal());
		}
		boolean operatorCall = OPERATORS.contains(getName().toString());
		if (!operatorCall) {
			b.append(".");
		}
		b.append(getName());
		b.append(getParamsExpressionString(getParams(), !operatorCall));
		return b.toString();
	}

	@Override
	public String getNameString(final ExecutionContext context) {
		final StringBuffer buff = new StringBuffer();
		buff.append(getName().toString());
		buff.append("(");
		if (params.length > 0) {
			if (context != null) {
				buff.append(getParamTypesString(context));
			} else {
				// TODO: CK low: Get parameter types from OawModelManager for
				// Breakpoints
				buff.append("..");
			}
		}
		return buff.append(")").toString();
	}

	private String getParamTypesString(final ExecutionContext context) {
		final ExecutionContext ctx = context.cloneWithoutMonitor();
		final StringBuffer buff = new StringBuffer();
		for (int i = 0; i < getParams().length; i++) {
			Type type = ctx.getType(params[i].evaluate(ctx));
			String name = type.getName();
			int pos = name.lastIndexOf("::");
			if (pos < 0) {
				buff.append(name);
			} else {
				buff.append(name.substring(pos + 2));
			}
			if ((i + 1) < params.length) {
				buff.append(",");
			}
		}
		return buff.toString();
	}

	private String getParamsExpressionString(final Expression[] params2, final boolean parenthesis) {
		final StringBuffer buff = new StringBuffer();
		if (parenthesis) {
			buff.append("(");
		}
		for (int i = 0; i < params2.length; i++) {
			buff.append(params2[i]);
			if ((i + 1) < params2.length) {
				buff.append(",");
			}
		}
		if (parenthesis) {
			buff.append(")");
		}
		return buff.toString();
	}

	private Object evaluate(final Extension ext, final Object[] parameters, final ExecutionContext ctx) {
		ctx.preTask(this);
		Object result = ext.evaluate(parameters, ctx);
		ctx.postTask(this);
		return result;
	}

	private Object evaluate(final Operation op, final Object targetObj, final Object[] parameters, final ExecutionContext ctx) {
		ctx.preTask(this);
		Object result = op.evaluate(targetObj, parameters);
		ctx.postTask(this);
		return result;
	}
}
