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

import java.util.Arrays;
import java.util.List;


public abstract class StatementWithBody extends Statement{
	
    protected Statement[] body;

    public StatementWithBody(final Statement[] body) {
        this.body = body;
    }

    public Statement[] getBody() {
        return body;
    }

    public List<Statement> getBodyAsList() {
        return Arrays.asList(body);
    }
    
	@Override
	public void setContainingDefinition(AbstractDefinition definition) {
		super.setContainingDefinition(definition);
		for (Statement element : body) {
			element.setContainingDefinition(definition);
		}
	}
    
}
