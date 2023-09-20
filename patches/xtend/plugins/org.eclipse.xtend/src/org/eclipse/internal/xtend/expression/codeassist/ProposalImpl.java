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

package org.eclipse.internal.xtend.expression.codeassist;

public class ProposalImpl implements Proposal {
    private String prefix;

    private Object proposedElement;

    private String insertString;

    private String displayString;

    public ProposalImpl(final String prefix, final String insertString, final String displayString, final Object element) {
        this.prefix = prefix;
        proposedElement = element;
        this.insertString = insertString;
        this.displayString = displayString;
    }

    public String getPrefix() {
        return prefix;
    }

    public Object getProposedElement() {
        return proposedElement;
    }

    public String getDisplayString() {
        return displayString;
    }

    public String getInsertString() {
        return insertString;
    }
}
