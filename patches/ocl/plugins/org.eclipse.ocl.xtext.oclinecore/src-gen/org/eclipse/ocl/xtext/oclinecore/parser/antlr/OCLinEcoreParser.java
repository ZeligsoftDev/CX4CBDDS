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
package org.eclipse.ocl.xtext.oclinecore.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreGrammarAccess;

public class OCLinEcoreParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private OCLinEcoreGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}

	@Override
	protected org.eclipse.ocl.xtext.oclinecore.parser.antlr.internal.InternalOCLinEcoreParser createParser(XtextTokenStream stream) {
		return new org.eclipse.ocl.xtext.oclinecore.parser.antlr.internal.InternalOCLinEcoreParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "TopLevelCS";
	}

	public OCLinEcoreGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OCLinEcoreGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
