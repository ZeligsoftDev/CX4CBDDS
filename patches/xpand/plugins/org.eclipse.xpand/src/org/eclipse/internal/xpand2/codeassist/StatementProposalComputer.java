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
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xtend.expression.codeassist.ProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.xtend.expression.ExecutionContext;

public class StatementProposalComputer implements ProposalComputer {

	public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
		final List<Object> result = new ArrayList<Object>();
		final String prefix = "";
		final String ws = findTrailingWhitespace(txt);

		final Stack<StackElement> s = FastAnalyzer.computeStack(txt);
		if (s.size() > 0) {
			final StackElement se = s.peek();
			result.add(factory.createStatementProposal(XpandTokens.LT + "END" + se.block + XpandTokens.RT, "END"
					+ se.block, prefix));
			if (contains(XpandTokens.IF, s)) {
				result.add(factory.createStatementProposal(XpandTokens.LT + "ELSE" + XpandTokens.RT, "ELSE", prefix));
				result.add(factory.createStatementProposal(XpandTokens.LT + "ELSEIF statement" + XpandTokens.RT,
						"ELSEIF", prefix));
			}
			if (!contains(XpandTokens.FILE, s)) {
				result.add(fileBlockProposal(ws, factory));
			}
			if (!contains(XpandTokens.PROTECT, s)) {
				result.add(protectBlockProposal(ws, factory));
			}
			result.add(foreachBlockProposal(ws, factory));
			result.add(ifBlockProposal(ws, factory));
			result.add(letBlockProposal(ws, factory));
			result.add(expandStatementProposal(ws, factory));
			result.add(remBlockProposal(ws, factory));
		} else {
			if (txt.indexOf(XpandTokens.LT + XpandTokens.DEFINE) == -1) {
				if (txt.indexOf(XpandTokens.LT + XpandTokens.EXTENSION) == -1) {
					result.add(importStatementProposal(factory));
				}
				result.add(extensionStatementProposal(factory));
			}
			result.add(defineBlockProposal(ws, factory));
			result.add(aroundBlockProposal(ws, factory));
			result.add(remBlockProposal(ws, factory));
		}
		return result;
	}

	private Object importStatementProposal(final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + XpandTokens.IMPORT + " my::imported::namespace" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "IMPORT statement", "", insertString
				.indexOf("my::imported::namespace"), "my::imported::namespace".length());
	}

	private Object extensionStatementProposal(final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + XpandTokens.EXTENSION + " path::to::AbstractExtension"
				+ XpandTokens.RT;
		return factory.createStatementProposal(insertString, "EXTENSION statement", "", insertString
				.indexOf("path::to::AbstractExtension"), "path::to::AbstractExtension".length());
	}

	private final static Pattern WS_PATTERN = Pattern.compile("(\\n?[\\t ]*)\\z");

	/**
	 * @since 2.0
	 */
	protected String findTrailingWhitespace(final String txt) {
		final Matcher m = StatementProposalComputer.WS_PATTERN.matcher(txt);
		m.find();
		return m.group(1);
	}

	private Object expandStatementProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "EXPAND definition FOR this" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "EXPAND statement", "",
				insertString.indexOf("definition"), "definition".length());
	}

	private Object letBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "LET expression AS e" + XpandTokens.RT + ws + XpandTokens.LT
				+ "ENDLET" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "LET block", "", insertString.indexOf("expression"),
				"expression".length());
	}

	private Object ifBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "IF condition" + XpandTokens.RT + ws + XpandTokens.LT + "ENDIF"
				+ XpandTokens.RT;
		return factory.createStatementProposal(insertString, "IF block", "", insertString.indexOf("condition"),
				"condition".length());
	}

	private Object foreachBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "FOREACH elements AS e" + XpandTokens.RT + ws + XpandTokens.LT
				+ "ENDFOREACH" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "FOREACH block", "", insertString.indexOf("elements"),
				"elements".length());
	}

	private Object protectBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "PROTECT CSTART '/*' CEND '*/' ID uniqueId"
				+ XpandTokens.RT + ws + XpandTokens.LT + "ENDPROTECT" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "PROTECT region", "", insertString.indexOf("uniqueId"),
				"uniqueId".length());
	}

	private Object fileBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "FILE fileName" + XpandTokens.RT + ws + XpandTokens.LT + "ENDFILE"
				+ XpandTokens.RT;
		return factory.createStatementProposal(insertString, "FILE block", "", insertString.indexOf("fileName"),
				"fileName".length());
	}

	private Object defineBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "DEFINE definionName FOR Type" + XpandTokens.RT + ws
				+ XpandTokens.LT + "ENDDEFINE" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "new DEFINE", "", insertString.indexOf("definionName"),
				"definionName".length());
	}

	private Object aroundBlockProposal(final String ws, final ProposalFactory factory) {
		final String insertString = XpandTokens.LT + "AROUND fullyQualifiedDefinionName FOR Type" + XpandTokens.RT + ws
				+ XpandTokens.LT + "ENDAROUND" + XpandTokens.RT;
		return factory.createStatementProposal(insertString, "new AROUND", "", insertString
				.indexOf("fullyQualifiedDefinionName"), "fullyQualifiedDefinionName".length());
	}

	/**
	 * Creates a proposal for a REM block
	 * 
	 * @param ws
	 * @param factory
	 * @return
	 * @since 4.2
	 */
	private Object remBlockProposal(final String ws, final ProposalFactory factory) {
		final String blockContent = "comment";
		final String insertString = XpandTokens.LT + "REM" + XpandTokens.RT + blockContent + XpandTokens.LT + "ENDREM"
				+ XpandTokens.RT;
		return factory.createStatementProposal(insertString, "REM block", "", insertString.indexOf(blockContent),
				blockContent.length());
	}

	private boolean contains(final String blockName, final Stack<StackElement> s) {
		for (StackElement element : s) {
			if (element.block.equals(blockName)) {
				return true;
			}
		}
		return false;
	}

	protected String findPrefix(final String txt) {
		final StringBuffer result = new StringBuffer();
		int i = txt.length() - 1;
		char c = txt.charAt(i);
		while (i > 0 && Character.isJavaIdentifierStart(c)) {
			result.append(c);
			c = txt.charAt(--i);
		}
		return result.reverse().toString();
	}
}
