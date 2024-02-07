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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class SwitchExpression extends Expression {
	private static final List<Case> EMPTY_CASES = Collections.emptyList();
	private Expression switchExpr = null;

	private Expression defaultExpr = null;

	private List<Case> cases = null;

	public SwitchExpression(final Expression switchExpr, final List<Case> cases, final Expression defaultExpr) {
		this.switchExpr = switchExpr;
		this.cases = (cases != null) && !cases.isEmpty() ? cases : EMPTY_CASES;
		this.defaultExpr = defaultExpr;
	}

	@Override
	protected Object evaluateInternal(final ExecutionContext ctx) {
		Object switchVal = Boolean.TRUE;
		if (switchExpr != null) {
			switchVal = switchExpr.evaluate(ctx);
		}
		for (Case c : cases) {
			final Object caseCondVal = c.getCondition().evaluate(ctx);
			if ((switchVal == caseCondVal) || ((switchVal != null) && equals(switchVal, caseCondVal, ctx))) {
				return c.getThenPart().evaluate(ctx);
			}
		}
		return defaultExpr.evaluate(ctx);
	}

	private boolean equals(final Object switchVal, final Object caseCondVal, final ExecutionContext ctx) {

		Object[] params = new Object[] { caseCondVal };
		Operation op = ctx.findOperation("==", switchVal, params);
		if (op != null) {
			return (Boolean) op.evaluate(switchVal, params);
		}
		throw new UnsupportedOperationException("'==' not found.");
	}

	@Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		Type condType = ctx.getBooleanType();
		if (switchExpr != null) {
			condType = switchExpr.analyze(ctx, issues);
		}
		if (condType == null) {
			return null;
		}
		Type returnType = defaultExpr.analyze(ctx, issues);
		if (returnType == null) {
			return null;
		}
		for (Case c : cases) {
			final Type caseCondType = c.getCondition().analyze(ctx, issues);
			if (caseCondType != null) {
				if (!condType.isAssignableFrom(caseCondType)) {
					issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, condType.getName() + " expected!", c.getCondition()));
				}
			}
			final Type caseThenType = c.getThenPart().analyze(ctx, issues);
			if (caseThenType != null) {
				if (!returnType.isAssignableFrom(caseThenType)) {
					if (caseThenType.isAssignableFrom(returnType)) {
						returnType = caseThenType;
					} else {
						returnType = ctx.getObjectType();
					}
				}
			}
		}
		return returnType;
	}

	public List<Case> getCases() {
		return cases;
	}

	public Expression getDefaultExpr() {
		return defaultExpr;
	}

	public Expression getSwitchExpr() {
		return switchExpr;
	}

	@Override
	protected String toStringInternal() {
		return "switch " + switchExpr.toStringInternal();
	}
}
