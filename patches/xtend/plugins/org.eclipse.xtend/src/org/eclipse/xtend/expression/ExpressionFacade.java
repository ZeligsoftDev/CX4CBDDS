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

package org.eclipse.xtend.expression;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.xtend.parser.ParseFacade;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class ExpressionFacade {

    private ExecutionContext execContext;

    public ExecutionContext getExecContext() {
        return execContext;
    }

    public ExpressionFacade(final ExecutionContext execCtx) {
        execContext = execCtx;
    }

    public Type analyze(final String expression, final Set<AnalysationIssue> issues) {
        final Expression expr = parse(expression);
        return expr.analyze(execContext, issues);
    }

    public Object evaluate(final String expression) {
        return evaluate(expression, Collections.<String,Object>emptyMap());
    }

    public Object evaluate(final String expression, final Map<String, ?> context) {
        final Expression expr = parse(expression);
        ExecutionContext ctx = execContext;
        for (final Iterator<String> iter = context.keySet().iterator(); iter.hasNext();) {
            final String key = iter.next();
            final Variable v = new Variable(key, context.get(key));
            ctx = ctx.cloneWithVariable(v);
        }
        return expr.evaluate(ctx);
    }

    public Expression parse(final String expression) {
        return ParseFacade.expression(expression);
    }

    public ExpressionFacade cloneWithVariable(final Variable variable) {
        final ExecutionContext ctx = execContext.cloneWithVariable(variable);
        return new ExpressionFacade(ctx);
    }

}
