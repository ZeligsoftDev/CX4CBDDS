/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr;

import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

public class UmlTransitionParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private UmlTransitionGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}

	@Override
	protected org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal.InternalUmlTransitionParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal.InternalUmlTransitionParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "TransitionRule";
	}

	public UmlTransitionGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(UmlTransitionGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}