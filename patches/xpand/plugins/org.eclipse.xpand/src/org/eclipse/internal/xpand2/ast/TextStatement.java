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

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.AnalysationIssue;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class TextStatement extends Statement {
    private String value;

    private boolean deleteLine;

    public TextStatement(final String text, final boolean nonl) {
        deleteLine = nonl;
        value = text;
    }

    public String getValue() {
        return value;
    }

    public boolean isDeleteLine() {
        return deleteLine;
    }

    @Override
	public void analyzeInternal(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {
        // Nothing to check here
    }

    @Override
    public void evaluateInternal(final XpandExecutionContext ctx) {
        ctx.getOutput().write(getValue());
    }
    
    @Override
    public String toString() {
    	return value.replace("\n", "\\n");
    }

}
