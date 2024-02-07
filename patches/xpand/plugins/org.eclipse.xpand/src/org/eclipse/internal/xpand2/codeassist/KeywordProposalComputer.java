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

import org.eclipse.internal.xpand2.XpandTokens;
import org.eclipse.internal.xtend.expression.codeassist.ProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.xtend.expression.ExecutionContext;

/**
 * Responsible for proposals of Xpand keywords.
 * @since 4.0
 */
public class KeywordProposalComputer implements ProposalComputer {

    public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
        final String prefix = getPrefix(txt);
        final List<Object> result = new ArrayList<Object>();
        if (prefix.length() > 0) {
            final String[] kw = XpandTokens.ALLKEYWORDS;
            for (int i = 0; i < kw.length; i++) {
                final String string = kw[i];
                if (string.toLowerCase().startsWith(prefix.toLowerCase())) {
                	result.add(factory.createKeywordProposal(string + getInsertionSuffix(string), string, prefix));
                }
            }
        }
        return result;
    }

    /** Match capital letters at the end of some string */
    private final static Pattern PREFIX = Pattern.compile("([A-Z]+)\\z");

    /**
     * @param txt Some text
     * @return The capital letters (A-Z) at the end of <tt>txt</tt>
     * @since 2.0
     */
    protected String getPrefix(final String txt) {
        final Matcher m = PREFIX.matcher(txt);
        if (m.find())
            return m.group(1);
        return "";
    }

    /**
     * Returns the character to insert after a specific keyword.
     * For all closing keywords (ENDFOREACH, ENDDEFINE) this will be the closing bracket.
     * The same for REM, since it does not contain anything.
     * For all other keywords a space character will be returned.
     * @param keyword Xpand keyword
     * @return Whitespace or Xpand closing bracket
     * @see XpandTokens
	 * @since 2.0
     */
    protected String getInsertionSuffix (final String keyword) {
    	if (keyword.startsWith("END") || XpandTokens.REM.equals(keyword)) {
    		return XpandTokens.RT;
    	}
		return " ";
    }

}
