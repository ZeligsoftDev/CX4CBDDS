/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.ocl.xtext.markup.services.MarkupGrammarAccess;

public class MarkupParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private MarkupGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens();
	}

	@Override
	protected org.eclipse.ocl.xtext.markup.parser.antlr.internal.InternalMarkupParser createParser(XtextTokenStream stream) {
		return new org.eclipse.ocl.xtext.markup.parser.antlr.internal.InternalMarkupParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "Markup";
	}

	public MarkupGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MarkupGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
