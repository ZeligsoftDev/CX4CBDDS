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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.TypeNameUtil;
import org.eclipse.xtend.typesystem.Type;

public class TypeProposalComputer implements ProposalComputer {

    public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
        final String prefix = findPrefix(txt);
        final Type[] types = ctx.findTypesForPrefix(prefix);
        final List<Object> result = new ArrayList<Object>();
        List<String> namespaces = Arrays.asList(ctx.currentResource().getImportedNamespaces());
        for (int i = 0; i < types.length; i++) {
            final Type type = types[i];
            String insertString = type.getName();
            if (insertString.startsWith(prefix)) {
            	result.add(factory.createTypeProposal(insertString, type, prefix));
            } else {
            	String simpleName = TypeNameUtil.getSimpleName(insertString);
            	if (simpleName.startsWith(prefix) && namespaces.contains(TypeNameUtil.getPackage(insertString))) {
            		result.add(factory.createTypeProposal(simpleName, type, prefix));
            	}
            }
        }
        return result;
    }

    public String findPrefix(final String txt) {
        final StringBuffer result = new StringBuffer();
        int i = txt.length() - 1;
        char c = txt.charAt(i);
        while (i > 0 && (Character.isJavaIdentifierStart(c) || c == ':')) {
            result.append(c);
            c = txt.charAt(--i);
        }
        return result.reverse().toString();
    }

}
