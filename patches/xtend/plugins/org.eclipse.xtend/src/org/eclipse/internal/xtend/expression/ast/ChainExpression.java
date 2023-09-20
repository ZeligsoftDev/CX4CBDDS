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
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class ChainExpression extends Expression {

    private Expression first;

    private Expression next;

    public ChainExpression(final Expression first, final Expression next) {
        this.first = first;
        this.next = next;
    }

    @Override
    protected Object evaluateInternal(final ExecutionContext ctx) {
        getFirst().evaluate(ctx);
        return getNext().evaluate(ctx);
    }

    @Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        getFirst().analyze(ctx, issues);
        return getNext()!=null ? getNext().analyze(ctx, issues) : null;
    }

    public Expression getFirst() {
        return first;
    }

    public Expression getNext() {
        return next;
    }

    @Override
	protected String toStringInternal() {
    	return getFirst() + "->" + getNext();
    }
}
