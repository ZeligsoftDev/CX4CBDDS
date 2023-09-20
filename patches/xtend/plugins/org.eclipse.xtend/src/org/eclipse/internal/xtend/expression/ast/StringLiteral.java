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

import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class StringLiteral extends Literal {

    public StringLiteral(final Identifier literalValue) {
        super(literalValue);
    }

    @Override
    public Object evaluateInternal(final ExecutionContext ctx) {
        return getValue();
    }

    @Override
	public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        return ctx.getStringType();
    }

    public String getValue() {
        return StringHelper.strip(StringHelper.unescape(getLiteralValue().toString()), 1, 1);
    }

}
