/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 * @author Karsten Thoms (itemis) - maintenance
 * @author Aykut Kilic (itemis) - Bug#480645
 *******************************************************************************/
package org.eclipse.internal.xtend.xtend.ast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

public class CreateExtensionStatement extends AbstractExtensionDefinition {

	private final Expression expression;

	private final String returnVarName;

	public CreateExtensionStatement(final Identifier name, final Identifier returnType, final Identifier rtName,
			final List<DeclaredParameter> params, final Expression expr, final boolean isPrivate) {
		super(name, returnType, params, true, isPrivate);
		expression = expr;
		returnVarName = rtName != null ? rtName.toString() : "this";
	}

	public String getReturnVarName() {
		return returnVarName;
	}

	@Override
	public Expression getExpression() {
		return expression;
	}

	@Override
	protected Type internalGetReturnType(final Type[] parameters, final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		return ctx.getTypeForName(getReturnTypeIdentifier().toString());
	}

	@Override
	public void analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx;
		final Type t = _ctx.getTypeForName(returnType.toString());
		if (t == null) {
			issues.add(new AnalysationIssue(AnalysationIssue.TYPE_NOT_FOUND, "Couldn't resolve type " + returnType + "!", returnType));
			return;
		}
		if (t.isAbstract()) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Cannot create instance of " + returnType
					+ " because it is declared abstract!", returnType));
		}
		_ctx = _ctx.cloneWithVariable(new Variable(returnVarName, t));
		expression.analyze(_ctx, issues);
	}

	private final Map<List<Object>, Object> cache = new HashMap<List<Object>, Object>();

	@Override
	public Object evaluate(final Object[] parameters, final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final List<Object> l = Arrays.asList(parameters);
		if (cache.containsKey(l)) {
			return cache.get(l);
		}
		_ctx = _ctx.cloneWithResource(getExtensionFile());
		final Type t = _ctx.getTypeForName(returnType.toString());
		if (t == null) {
			throw new EvaluationException("Couldn't resolve type " + returnType, returnType, _ctx);
		}
		if (t.isAbstract()) {
			throw new EvaluationException("Cannot create instance of abstract class " + returnType, returnType, _ctx);
		}
		final Object inst = t.newInstance();
		cache.put(l, inst);
		_ctx = _ctx.cloneWithVariable(new Variable(returnVarName, inst));
		for (int i = 0; i < parameters.length; i++) {
			final Object object = parameters[i];
			_ctx = _ctx.cloneWithVariable(new Variable(getParameterNames().get(i), object));
		}
		_ctx.preTask(this);
		expression.evaluate(_ctx);
		_ctx.postTask(this);
		return inst;
	}

	@Override
	protected Object evaluateInternal(final Object[] parameters, final ExecutionContext ctx) {
		throw new UnsupportedOperationException();
	}

}
