/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xpand2.ast;

import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class ExpressionStatement extends org.eclipse.internal.xpand2.ast.Statement {

    private Expression expression;

    public ExpressionStatement( final Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
	public void analyzeInternal(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
        getExpression().analyze(ctx, issues);
    }

    @Override
    public void evaluateInternal(final XpandExecutionContext ctx) {
        final Object val = getExpression().evaluate(ctx);
        if (val != null) {
            ctx.getOutput().write(val.toString());
        }
    }

	@Override
	public String getNameString(ExecutionContext context) {
		if (expression != null)
			return "EXPRESSION: " + expression.getNameString(context);
		return super.toString();
	}

	@Override
	public String toString() {
		if (expression != null)
			return "EXPRESSION: " + expression.toString();
		return super.toString();
	}


}
