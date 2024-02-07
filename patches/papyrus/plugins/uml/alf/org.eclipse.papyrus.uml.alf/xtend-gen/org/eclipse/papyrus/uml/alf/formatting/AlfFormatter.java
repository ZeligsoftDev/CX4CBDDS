/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Ed Seidewitz
 */
package org.eclipse.papyrus.uml.alf.formatting;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class AlfFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private AlfGrammarAccess _alfGrammarAccess;

  @Override
  protected void configureFormatting(final FormattingConfig c) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this._alfGrammarAccess.findKeywordPairs("(", ")");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        c.setNoSpace().after(pair.getFirst());
        c.setNoSpace().before(pair.getSecond());
      }
    }
    List<Pair<Keyword, Keyword>> _findKeywordPairs_1 = this._alfGrammarAccess.findKeywordPairs("<", ">");
    for (final Pair<Keyword, Keyword> pair_1 : _findKeywordPairs_1) {
      {
        c.setNoSpace().before(pair_1.getFirst());
        c.setNoLinewrap().around(pair_1.getFirst());
        c.setNoLinewrap().before(pair_1.getSecond());
      }
    }
    List<Keyword> _findKeywords = this._alfGrammarAccess.findKeywords("[");
    for (final Keyword openBracket : _findKeywords) {
      c.setNoSpace().around(openBracket);
    }
    List<Keyword> _findKeywords_1 = this._alfGrammarAccess.findKeywords("]");
    for (final Keyword closeBracket : _findKeywords_1) {
      c.setNoSpace().before(closeBracket);
    }
    List<Keyword> _findKeywords_2 = this._alfGrammarAccess.findKeywords(".");
    for (final Keyword dot : _findKeywords_2) {
      c.setNoSpace().around(dot);
    }
    List<Keyword> _findKeywords_3 = this._alfGrammarAccess.findKeywords("..");
    for (final Keyword dots : _findKeywords_3) {
      c.setNoSpace().around(dots);
    }
    List<Keyword> _findKeywords_4 = this._alfGrammarAccess.findKeywords("->");
    for (final Keyword arrow : _findKeywords_4) {
      c.setNoSpace().around(arrow);
    }
    List<Keyword> _findKeywords_5 = this._alfGrammarAccess.findKeywords("=>");
    for (final Keyword arrow_1 : _findKeywords_5) {
      c.setNoSpace().around(arrow_1);
    }
    List<Keyword> _findKeywords_6 = this._alfGrammarAccess.findKeywords(",");
    for (final Keyword comma : _findKeywords_6) {
      c.setNoSpace().before(comma);
    }
    List<Keyword> _findKeywords_7 = this._alfGrammarAccess.findKeywords(":");
    for (final Keyword colon : _findKeywords_7) {
      {
        c.setNoSpace().before(colon);
        c.setNoLinewrap().after(colon);
      }
    }
    List<Keyword> _findKeywords_8 = this._alfGrammarAccess.findKeywords("::");
    for (final Keyword colons : _findKeywords_8) {
      c.setNoSpace().around(colons);
    }
    List<Keyword> _findKeywords_9 = this._alfGrammarAccess.findKeywords(";");
    for (final Keyword semicolon : _findKeywords_9) {
      {
        c.setLinewrap().after(semicolon);
        c.setNoSpace().before(semicolon);
      }
    }
    List<Keyword> _findKeywords_10 = this._alfGrammarAccess.findKeywords("@");
    for (final Keyword atSign : _findKeywords_10) {
      c.setNoSpace().after(atSign);
    }
    c.setLinewrap(0, 1, 2).before(this._alfGrammarAccess.getSL_COMMENTRule());
    c.setLinewrap(0, 1, 2).before(this._alfGrammarAccess.getML_COMMENTRule());
    c.setLinewrap(0, 1, 1).after(this._alfGrammarAccess.getML_COMMENTRule());
    c.setLinewrap(0, 2, 2).before(this._alfGrammarAccess.getDOCUMENTATION_COMMENTRule());
    c.setLinewrap(0, 1, 1).after(this._alfGrammarAccess.getDOCUMENTATION_COMMENTRule());
    c.setNoSpace().before(this._alfGrammarAccess.getTupleAccess().getLeftParenthesisKeyword_0());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getTupleAccess().getLeftParenthesisKeyword_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getTupleAccess().getRightParenthesisKeyword_2());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().after(this._alfGrammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap(2).after(this._alfGrammarAccess.getNamespaceDeclarationRule());
    c.setLinewrap(0, 1, 1).before(this._alfGrammarAccess.getNamespaceDefinitionRule());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getPackageDefinitionAccess().getLeftCurlyBracketKeyword_2());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getPackageDefinitionAccess().getRightCurlyBracketKeyword_4());
    c.setLinewrap(2).after(this._alfGrammarAccess.getPackageDefinitionAccess().getLeftCurlyBracketKeyword_2());
    c.setLinewrap(2).before(this._alfGrammarAccess.getPackageDefinitionAccess().getRightCurlyBracketKeyword_4());
    c.setLinewrap().after(this._alfGrammarAccess.getPackageDefinitionAccess().getRightCurlyBracketKeyword_4());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getPackageDefinitionOrStubAccess().getLeftCurlyBracketKeyword_2_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getPackageDefinitionOrStubAccess().getRightCurlyBracketKeyword_2_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getPackageDefinitionOrStubAccess().getLeftCurlyBracketKeyword_2_1_0());
    c.setLinewrap(2).before(this._alfGrammarAccess.getPackageDefinitionOrStubAccess().getRightCurlyBracketKeyword_2_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getPackageDefinitionOrStubAccess().getRightCurlyBracketKeyword_2_1_2());
    c.setLinewrap(0, 1, 1).before(this._alfGrammarAccess.getImportVisibilityIndicatorRule());
    c.setNoSpace().after(this._alfGrammarAccess.getClassDeclarationAccess().getLessThanSignKeyword_3_0());
    c.setNoSpace().before(this._alfGrammarAccess.getClassDeclarationAccess().getGreaterThanSignKeyword_3_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getClassDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap(2).after(this._alfGrammarAccess.getClassDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap(2).before(this._alfGrammarAccess.getClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getClassDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getClassDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).before(this._alfGrammarAccess.getClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap().before(this._alfGrammarAccess.getVisibilityIndicatorRule());
    c.setNoSpace().after(this._alfGrammarAccess.getActiveClassDeclarationAccess().getLessThanSignKeyword_4_0());
    c.setNoSpace().before(this._alfGrammarAccess.getActiveClassDeclarationAccess().getGreaterThanSignKeyword_4_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getActiveClassDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getActiveClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap(2).after(this._alfGrammarAccess.getActiveClassDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap(2).before(this._alfGrammarAccess.getActiveClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getActiveClassDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setNoLinewrap().before(this._alfGrammarAccess.getActiveClassDefinitionAccess().getDoKeyword_4_0());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).before(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setNoLinewrap().before(this._alfGrammarAccess.getActiveClassDefinitionOrStubAccess().getDoKeyword_1_1_3_0());
    c.setLinewrap(2).after(this._alfGrammarAccess.getBehaviorClauseRule());
    c.setNoSpace().after(this._alfGrammarAccess.getDataTypeDeclarationAccess().getLessThanSignKeyword_3_0());
    c.setNoSpace().before(this._alfGrammarAccess.getDataTypeDeclarationAccess().getGreaterThanSignKeyword_3_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getDataTypeDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getDataTypeDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getDataTypeDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().after(this._alfGrammarAccess.getDataTypeDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap().after(this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).after(this._alfGrammarAccess.getDataTypeDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setNoSpace().after(this._alfGrammarAccess.getAssociationDeclarationAccess().getLessThanSignKeyword_3_0());
    c.setNoSpace().before(this._alfGrammarAccess.getAssociationDeclarationAccess().getGreaterThanSignKeyword_3_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getAssociationDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getAssociationDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getAssociationDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().after(this._alfGrammarAccess.getAssociationDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getAssociationDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getAssociationDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap().after(this._alfGrammarAccess.getAssociationDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).after(this._alfGrammarAccess.getAssociationDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setNoSpace().after(this._alfGrammarAccess.getSignalDeclarationAccess().getLessThanSignKeyword_3_0());
    c.setNoSpace().before(this._alfGrammarAccess.getSignalDeclarationAccess().getGreaterThanSignKeyword_3_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getSignalDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getSignalDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getSignalDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().after(this._alfGrammarAccess.getSignalDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getSignalDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getSignalDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap().after(this._alfGrammarAccess.getSignalDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).after(this._alfGrammarAccess.getSignalDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap().after(this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setLinewrap(2).after(this._alfGrammarAccess.getSignalReceptionDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().after(this._alfGrammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_1());
    c.setLinewrap().before(this._alfGrammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_3());
    c.setLinewrap().after(this._alfGrammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_2_1_0());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess().getLeftCurlyBracketKeyword_1_1_0());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setLinewrap(2).after(this._alfGrammarAccess.getEnumerationDefinitionOrStubAccess().getRightCurlyBracketKeyword_1_1_2());
    c.setNoSpace().after(this._alfGrammarAccess.getActivityDeclarationAccess().getLessThanSignKeyword_2_0());
    c.setNoSpace().before(this._alfGrammarAccess.getActivityDeclarationAccess().getGreaterThanSignKeyword_2_3());
    c.setNoSpace().before(this._alfGrammarAccess.getActivityDeclarationAccess().getLeftParenthesisKeyword_3());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getActivityDeclarationAccess().getLeftParenthesisKeyword_3());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getActivityDeclarationAccess().getRightParenthesisKeyword_5());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getReturnParameterDefinitionAccess().getColonKeyword_0());
    c.setIndentationDecrement().after(this._alfGrammarAccess.getReturnParameterDefinitionRule());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getPropertyDeclarationAccess().getColonKeyword_1());
    c.setIndentationDecrement().after(this._alfGrammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_1());
    c.setIndentationDecrement().after(this._alfGrammarAccess.getAttributeDefinitionAccess().getSemicolonKeyword_2());
    c.setNoSpace().before(this._alfGrammarAccess.getOperationDeclarationAccess().getLeftParenthesisKeyword_2());
    c.setIndentationIncrement().after(this._alfGrammarAccess.getOperationDeclarationAccess().getLeftParenthesisKeyword_2());
    c.setIndentationDecrement().before(this._alfGrammarAccess.getOperationDeclarationAccess().getRightParenthesisKeyword_4());
    c.setNoLinewrap().after(this._alfGrammarAccess.getParameterDirectionRule());
  }
}
