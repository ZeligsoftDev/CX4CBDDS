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

package org.eclipse.internal.xpand2.codeassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xtend.expression.codeassist.ProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.xtend.expression.ExecutionContext;

public class NamespaceProposalComputer implements ProposalComputer {

	public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
		final Set<String> namespaces = ctx.getNamespaces();
		final List<Object> result = new ArrayList<Object>();

		String prefix = findPrefix(txt);
		for (String namespace : namespaces) {
			String insertText = namespace;
			if (insertText.startsWith(prefix)) {
				result.add(factory.createNamespaceProposal(insertText, insertText, prefix));
			}
		}
		return result;
	}

	private String findPrefix(String txt) {
		String prefix = "";
		if (txt != null) {
			int lastIndexOf = txt.lastIndexOf(" ", txt.length());
			prefix = txt.substring(lastIndexOf + 1);
		}
		return prefix;
	}
}
