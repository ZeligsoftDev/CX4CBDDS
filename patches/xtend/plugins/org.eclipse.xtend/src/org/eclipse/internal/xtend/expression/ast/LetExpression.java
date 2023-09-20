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

import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class LetExpression extends Expression {

	private final Expression varExpression;

	private final Expression targetExpression;

	private final Identifier varName;

	public LetExpression(final Identifier varName, final Expression varExpression, final Expression target) {
		this.varName = varName;
		this.varExpression = varExpression;
		targetExpression = target;
	}

	public Expression getVarExpression() {
		return varExpression;
	}

	public Expression getTargetExpression() {
		return targetExpression;
	}

	public String getName() {
		return varName.toString();
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		ExecutionContext _ctx = ctx;
		final Object o = varExpression.evaluate(_ctx);
		_ctx = _ctx.cloneWithVariable(new Variable(varName.toString(), o));
		
		_ctx.preTask(this);
		Object result = targetExpression.evaluate(_ctx);
		_ctx.postTask(this);
		return result;
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		if ((varExpression == null) || (targetExpression == null)) {
			issues.add(new AnalysationIssue(AnalysationIssue.SYNTAX_ERROR, "Syntax error in expression", this));
			return null;
		}
		ExecutionContext _ctx = ctx;
		final Type t = varExpression.analyze(_ctx, issues);
		if (t == null) {
			return null;
		}
		_ctx = _ctx.cloneWithVariable(new Variable(varName.toString(), t));
		return targetExpression.analyze(_ctx, issues);

	}

	@Override
	protected String toStringInternal() {
		return "let " + varName + "=" + varExpression + " : " + targetExpression;
	}

}
