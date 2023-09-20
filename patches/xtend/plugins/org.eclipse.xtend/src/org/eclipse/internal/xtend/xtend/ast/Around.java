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
package org.eclipse.internal.xtend.xtend.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.types.AdviceContextType;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

public class Around extends SyntaxElement {
	private static final List<DeclaredParameter> EMPTY_DECLAREDPARAMETERS = Collections.<DeclaredParameter> emptyList();
	public static final String CONTEXT_PARAM_NAME = "ctx";
	private final Identifier pointcut;
	private final List<DeclaredParameter> params;
	private final boolean wildparams;
	private final Expression expression;

	public Around(final Identifier pointcut, final List<DeclaredParameter> params, final boolean wildparams, final Expression expr) {
		this.pointcut = pointcut;
		this.params = ((params != null) && !params.isEmpty()) ? params : EMPTY_DECLAREDPARAMETERS;
		this.wildparams = wildparams;
		expression = expr;
	}

	public Identifier getPointCut() {
		return pointcut;
	}

	public boolean isWildparams() {
		return wildparams;
	}

	public Expression getExpression() {
		return expression;
	}

	public List<DeclaredParameter> getParams() {
		return params;
	}

	private XtendFile parent = null;
	private Pattern p;

	public void setParent(final XtendFile parent) {
		this.parent = parent;
	}

	public XtendFile getParent() {
		return parent;
	}

	public List<Type> getParamTypes(final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx.cloneWithResource(getParent());
		List<Type> result = new ArrayList<Type>();
		for (DeclaredParameter dp : getParams()) {
			result.add(_ctx.getTypeForName(dp.getType().toString()));
		}
		return result;
	}

	public boolean nameMatches(final String fqn) {
		if (p == null) {
			p = Pattern.compile(pointcut.toString().replaceAll("\\*", ".*"));
		}
		final Matcher m = p.matcher(fqn);
		return m.matches();
	}

	public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ExecutionContext _ctx = ctx.cloneWithoutVariables();
		_ctx = _ctx.cloneWithResource(getParent());
		for (DeclaredParameter dp : getParams()) {
			final String name = dp.getName().toString();
			if (name.equals(CONTEXT_PARAM_NAME)) {
				issues.add(new AnalysationIssue(AnalysationIssue.SYNTAX_ERROR, "The variable name 'ctx' is not allowed here!", dp.getName()));
			}
			final Type t = _ctx.getTypeForName(dp.getType().toString());
			_ctx = _ctx.cloneWithVariable(new Variable(name, t));
		}
		_ctx = _ctx.cloneWithVariable(new Variable(CONTEXT_PARAM_NAME, _ctx.getTypeForName(AdviceContextType.TYPE_NAME)));
		expression.analyze(_ctx, issues);
	}

	@Override
	public String toString() {
		return " around " + pointcut + "(" + paramsToString() + (isWildparams() ? " * " : "") + ") from " + getParent().getFullyQualifiedName();
	}

	private String paramsToString() {
		StringBuffer b = new StringBuffer("");
		for (Iterator<DeclaredParameter> iter = getParams().iterator(); iter.hasNext();) {
			DeclaredParameter dp = iter.next();
			b.append(dp.getType() + " " + dp.getName());
			if (iter.hasNext()) {
				b.append(",");
			}
		}
		return b.toString();
	}

}
