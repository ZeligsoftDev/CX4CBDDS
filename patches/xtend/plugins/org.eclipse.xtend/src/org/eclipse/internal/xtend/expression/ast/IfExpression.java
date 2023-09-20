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
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class IfExpression extends Expression {

	private final Expression condition;

	private final Expression thenPart;

	private final Expression elsePart;

	public IfExpression(final Expression condition, final Expression thenPart, final Expression elsePart) {
		this.condition = condition;
		this.thenPart = thenPart;
		this.elsePart = elsePart;
	}

	public Expression getCondition() {
		return condition;
	}

	public Expression getElsePart() {
		return elsePart;
	}

	public Expression getThenPart() {
		return thenPart;
	}

	@Override
	public Object evaluateInternal(final ExecutionContext ctx) {
		Object val = getCondition().evaluate(ctx);
		if (val == null) {
			val = Boolean.FALSE;
		}

		if (!(val instanceof Boolean)) {
			throw new EvaluationException("Boolean expected!", getCondition(), ctx);
		}

		if (((Boolean) val).booleanValue()) {
			return getThenPart().evaluate(ctx);
		}
		if (getElsePart() == null) {
			return null;
		}
		return getElsePart().evaluate(ctx);
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type conditionType = getCondition().analyze(ctx, issues);
		if ((conditionType != null) && !conditionType.equals(ctx.getBooleanType())) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Boolean expected", getCondition()));
		}

		final Type thenPartType = getThenPart().analyze(ctx, issues);
		final Type elsePartType = getElsePart() != null ? getElsePart().analyze(ctx, issues) : ctx.getVoidType();
		if ((thenPartType == null) || (elsePartType == null)) {
			return null;
		}
		if (thenPartType.isAssignableFrom(elsePartType)) {
			return elsePartType;
		} else if (elsePartType.isAssignableFrom(thenPartType)) {
			return thenPartType;
		} else {
			return ctx.getObjectType();
		}
	}

	@Override
	protected String toStringInternal() {
		return "if " + condition.toString() + " then " + thenPart + (elsePart != null ? " else " + elsePart : "");
	}

}
