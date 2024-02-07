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
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtend.expression.ExecutionContext;

public class ExtensionImportProposalComputer {
	private final static Pattern p = Pattern.compile("extension\\s+([\\w\\:]*)\\z", Pattern.CASE_INSENSITIVE);

	protected Pattern getPattern() {
		return p;
	}

	public List<Object> computeProposals(String part, ExecutionContext ctx, ProposalFactory factory, Set<String> extensionFileNames) {
		String prefix = computePrefix(part);
		List<Object> result = new ArrayList<Object>();
		if (prefix==null)
			return result;
		for (String s : extensionFileNames) {
			if (s.startsWith(prefix))
				result.add(factory.createExtensionImportProposal(s, s, prefix, s.length(), 0));
		}
		return result;
	}

	protected String computePrefix(String part) {
		Matcher m = getPattern().matcher(part);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	public String test__computePrefix(String part){
		return computePrefix(part);
	}

}
