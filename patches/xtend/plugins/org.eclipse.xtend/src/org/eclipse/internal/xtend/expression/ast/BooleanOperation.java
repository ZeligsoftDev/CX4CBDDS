/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
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
 * @author Sven Efftinge
 * @author Bernd Kolb
 * @author Karsten Thoms - maintenance
 * @author Ed Merks - Bug#418156
 */
public class BooleanOperation extends Expression {

	private static final String IMPLIES = "implies";

	private static final String OR = "||";

	private static final String AND = "&&";

	private final Expression left;

	private final Expression right;

	private final Identifier operator;

	public BooleanOperation(final Identifier operator, final Expression e, final Expression r) {
		this.operator = operator;
		left = e;
		right = r;
	}

	public Expression getLeft() {
		return left;
	}

	public Identifier getOperator() {
		return operator;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	protected Object evaluateInternal(final ExecutionContext ctx) {
		final Boolean l = evaluateToBoolean(left, ctx);
		if (l == null) {
			return ctx.handleNullEvaluation(this);
		}
		final String operatorValue = operator.toString();
		if (operatorValue.equals(AND)) {
			if (!l.booleanValue()) {
				return Boolean.FALSE;
			}
			final Boolean r = evaluateToBoolean(right, ctx);
			if (r == null) {
				return ctx.handleNullEvaluation(this);
			}
			return Boolean.valueOf(l.booleanValue() && r.booleanValue());
		} else if (operatorValue.equals(OR)) {
			if (l.booleanValue()) {
				return Boolean.TRUE;
			}

			final Boolean r = evaluateToBoolean(right, ctx);
			if (r == null) {
				return ctx.handleNullEvaluation(this);
			}
			return Boolean.valueOf(l.booleanValue() || r.booleanValue());
		} else if (operatorValue.equals(IMPLIES)) {
			if (!l.booleanValue()) {
				return Boolean.TRUE;
			}
			Boolean b = evaluateToBoolean(right, ctx);
			if (b == null) {
				return ctx.handleNullEvaluation(this);
			}
			return b;
		} else {
			throw new EvaluationException("Unknown Boolean operator " + operatorValue, this, ctx);
		}
	}

	private Boolean evaluateToBoolean(final Expression expr, final ExecutionContext ctx) {
		final Object l = expr.evaluate(ctx);
		if (l == null) {
			return null;
		}
		if (!(l instanceof Boolean)) {
			final Type t = ctx.getType(l);
			throw new EvaluationException("Boolean expected but was " + t.getName(), expr, ctx);
		}
		final Boolean result = (Boolean) l;
		return result;
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		final Type l = left.analyze(ctx, issues);
		final Type r = right.analyze(ctx, issues);
		if ((l == null) || (r == null)) {
			return null;
		}

		if (!ctx.getBooleanType().equals(l)) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Boolean expected! Found : " + l.getName(), left));
		}
		if (!ctx.getBooleanType().equals(r)) {
			issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Boolean expected! Found : " + r.getName(), right));
		}

		return ctx.getBooleanType();
	}

	@Override
	protected String toStringInternal() {
		return left.toStringInternal() + operator.toString() + right.toStringInternal();
	}

}
