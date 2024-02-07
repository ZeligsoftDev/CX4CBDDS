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
package org.eclipse.ocl.xtext.completeocl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.ocl.xtext.completeocl.services.CompleteOCLGrammarAccess;

public class CompleteOCLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private CompleteOCLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}

	@Override
	protected org.eclipse.ocl.xtext.completeocl.parser.antlr.internal.InternalCompleteOCLParser createParser(XtextTokenStream stream) {
		return new org.eclipse.ocl.xtext.completeocl.parser.antlr.internal.InternalCompleteOCLParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "CompleteOCLDocumentCS";
	}

	public CompleteOCLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CompleteOCLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
