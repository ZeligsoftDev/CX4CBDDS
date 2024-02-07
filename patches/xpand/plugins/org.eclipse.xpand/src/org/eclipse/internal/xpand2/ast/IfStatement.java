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
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.typesystem.Type;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class IfStatement extends StatementWithBody {

    private Expression condition;

    private IfStatement upperIf;

    private IfStatement elseIf;

    public IfStatement(final Expression condition,
            final Statement[] body) {
        super(body);
        this.condition = condition;
    }

    public Expression getCondition() {
        return condition;
    }

    public IfStatement getElseIf() {
        return elseIf;
    }

    public void setElseIf(final IfStatement elseIf) {
        this.elseIf = elseIf;
        elseIf.setUpperIf(this);
    }

    private void setUpperIf(final IfStatement upperIf) {
		this.upperIf = upperIf;
    }

    public boolean isElseIf() {
    	return upperIf != null && elseIf != null;
    }

    public boolean isElse() {
    	return upperIf != null && elseIf == null;
    }

    @Override
	public void analyzeInternal(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
        if (condition != null) {
            final Type conType = getCondition().analyze(ctx, issues);
            if (conType != null && !ctx.getBooleanType().isAssignableFrom(conType)) {
                issues.add(new AnalysationIssue(AnalysationIssue.INCOMPATIBLE_TYPES, "Boolean expected!",
                        getCondition()));
            }
        }
        for (int i = 0; i < body.length; i++) {
            body[i].analyze(ctx, issues);
        }
        if (getElseIf() != null) {
            getElseIf().analyze(ctx, issues);
        }
    }

    @Override
    public void evaluateInternal(final XpandExecutionContext ctx) {
        if (condition != null) {
            final Object result = getCondition().evaluate(ctx);
            if (result == null)
                throw new EvaluationException("Nullevaluation!", getCondition(), ctx);
            if (!(result instanceof Boolean))
                throw new EvaluationException("Boolean expected!", getCondition(), ctx);
            if (((Boolean) result).booleanValue()) {
                for (int i = 0; i < body.length; i++) {
                    body[i].evaluate(ctx);
                }
            } else if (getElseIf() != null) {
                getElseIf().evaluate(ctx);
            }
        } else {
        	// the else portion is an IfStatement with a null condition
            for (int i = 0; i < body.length; i++) {
                body[i].evaluate(ctx);
            }
        }
    }
    
	@Override
	public void setContainingDefinition(AbstractDefinition definition) {
		super.setContainingDefinition(definition);
		if (elseIf != null) {
			elseIf.setContainingDefinition(definition);
		}
	}
	
}
