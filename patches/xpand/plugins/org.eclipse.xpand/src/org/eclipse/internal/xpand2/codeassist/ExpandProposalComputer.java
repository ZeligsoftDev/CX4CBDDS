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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.codeassist.ProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.ExecutionContext;

public class ExpandProposalComputer implements ProposalComputer {
	private final static Pattern p = FastAnalyzer.EXPAND_PATTERN;

	public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
		final List<Object> result = new ArrayList<Object>();

		Matcher m = p.matcher(txt);
		if (m.find()) {
			String prefix = m.group(1);
			if (ctx instanceof XpandExecutionContext) {
				XpandExecutionContext xpandCtx = (XpandExecutionContext) ctx;
				List<XpandDefinition> allDefinitions = xpandCtx.getAllDefinitions();
				if (allDefinitions != null) {
					for (XpandDefinition xpandDefinition : allDefinitions) {
						String defineName = xpandDefinition.getName();
						StringBuilder displayString = new StringBuilder (defineName);
						DeclaredParameter[] params = xpandDefinition.getParams();
						if (params.length>0) {
							displayString.append("(");
							for (int i=0; i<params.length; i++) {
								if (i>0) displayString.append(",");
								displayString.append(params[i].getType());
							}
							
							displayString.append(")");
						}
						displayString.append(" - ").append(xpandDefinition.getTargetType());
						result.add(factory.createDefinitionProposal(defineName, displayString.toString(), prefix));
					}
				}
			}
		}

		return result;
	}
}
