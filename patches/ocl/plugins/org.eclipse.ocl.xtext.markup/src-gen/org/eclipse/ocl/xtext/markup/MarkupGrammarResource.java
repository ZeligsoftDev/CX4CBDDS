/*******************************************************************************
 * Copyright (c) 2015, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: E:\GIT\org.eclipse.ocl\plugins..\..\plugins\org.eclipse.ocl.xtext.markup\src-gen\org\eclipse\ocl\xtext\markup\Markup.xtextbin
 * by: org.eclipse.ocl.examples.build.xtend.generateGrammar.xtend
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.markup;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.utilities.AbstractGrammarResource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * MarkupGrammarResource provides a programmatically initialized org.eclipse.ocl.xtext.markup.Markup Grammar model avoiding
 * the speed limitations of the pre-Xtext 2.4 *.xmi models and the binary incompatibilities between differing *.xtextbin versions.
 * <p>
 * The grammar is immutable and is available as static INSTANCE and GRAMMAR fields.
 */
public class MarkupGrammarResource extends AbstractGrammarResource
{
	private static final @NonNull Grammar G_Markup = createGrammar("org.eclipse.ocl.xtext.markup.Markup");

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.markup.Markup Grammar resource.
	 */
	public static final @NonNull MarkupGrammarResource INSTANCE = new MarkupGrammarResource();

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.markup.Markup Grammar model.
	 */
	public static final @NonNull Grammar GRAMMAR = (Grammar)INSTANCE.getContents().get(0);

	/**
	 *	The name of the language supported by this grammar.
	 */
	public static final @NonNull String LANGUAGE_NAME = "org.eclipse.ocl.xtext.markup.Markup";

	protected MarkupGrammarResource() {
		super(URI.createURI(LANGUAGE_NAME));
		List<EObject> contents = getContents();
		contents.add(_Markup.initGrammar());
	}

	/*
	 * This class should be bound to org.eclipse.xtext.service.GrammarProvider.
	 */
	@Singleton
	public static class GrammarProvider extends org.eclipse.xtext.service.GrammarProvider
	{
		@Inject
		public GrammarProvider(Provider<XtextResourceSet> resourceSetProvider) {
			super(LANGUAGE_NAME, resourceSetProvider);
		}

		@Override
		public Grammar getGrammar(Object requestor) {
			return MarkupGrammarResource.GRAMMAR;
		}
	}

	private static class _Markup
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.markupcs.MarkupPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/MarkupCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore

		private static final @NonNull TerminalRule TR_ANY_OTHER = createTerminalRule("ANY_OTHER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED = createTerminalRule("ESCAPED", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_HORIZONTAL_WS = createTerminalRule("HORIZONTAL_WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ID = createTerminalRule("ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_INT = createTerminalRule("INT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_LETTER = createTerminalRule("LETTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_NL = createTerminalRule("NL", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_NUMBER = createTerminalRule("NUMBER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_STRING = createTerminalRule("STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_VERTICAL_WS = createTerminalRule("VERTICAL_WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_WORD = createTerminalRule("WORD", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_WS = createTerminalRule("WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initTerminalRules() {
			TR_ANY_OTHER.setAlternatives(
				createWildcard());
			TR_ESCAPED.setFragment(true);
			TR_ESCAPED.setAlternatives(
				createGroup(
					createKeyword("\\"),
					createAlternatives(
						createKeyword("b"),
						createKeyword("t"),
						createKeyword("n"),
						createKeyword("f"),
						createKeyword("r"),
						createKeyword("\""),
						createKeyword("\'"),
						createKeyword("\\"),
						createKeyword("<"),
						createKeyword(">"),
						createKeyword("["),
						createKeyword("]"))));
			TR_HORIZONTAL_WS.setFragment(true);
			TR_HORIZONTAL_WS.setAlternatives(
				createAlternatives(
					createKeyword(" "),
					createKeyword("\t")));
			TR_ID.setAlternatives(
				createGroup(
					createRuleCall(TR_LETTER),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_LETTER),
						createRuleCall(TR_NUMBER)))));
			TR_INT.setAlternatives(
				setCardinality("+", createRuleCall(TR_NUMBER)));
			TR_LETTER.setFragment(true);
			TR_LETTER.setAlternatives(
				createAlternatives(
					createCharacterRange(createKeyword("a"), createKeyword("z")),
					createCharacterRange(createKeyword("A"), createKeyword("Z")),
					createKeyword("_")));
			TR_NL.setAlternatives(
				setCardinality("+", createGroup(
					setCardinality("*", createRuleCall(TR_HORIZONTAL_WS)),
					createRuleCall(TR_VERTICAL_WS))));
			TR_NUMBER.setFragment(true);
			TR_NUMBER.setAlternatives(
				createCharacterRange(createKeyword("0"), createKeyword("9")));
			TR_STRING.setAlternatives(
				createGroup(
					createKeyword("\""),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_ESCAPED),
						createNegatedToken(createAlternatives(
							createKeyword("\\"),
							createKeyword("\""))))),
					createKeyword("\"")));
			TR_VERTICAL_WS.setFragment(true);
			TR_VERTICAL_WS.setAlternatives(
				createAlternatives(
					createKeyword("\n"),
					createKeyword("\r")));
			TR_WORD.setAlternatives(
				setCardinality("+", createAlternatives(
					createRuleCall(TR_ESCAPED),
					createNegatedToken(createAlternatives(
						createKeyword("\\"),
						createKeyword("\""),
						createKeyword("["),
						createKeyword("]"),
						createKeyword(":"),
						createKeyword("#"),
						createKeyword(","),
						createRuleCall(TR_HORIZONTAL_WS),
						createRuleCall(TR_VERTICAL_WS))))));
			TR_WS.setAlternatives(
				setCardinality("+", createRuleCall(TR_HORIZONTAL_WS)));
		}

		private static final @NonNull ParserRule PR_BulletElement = createParserRule("BulletElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.BULLET_ELEMENT));
		private static final @NonNull ParserRule PR_FigureElement = createParserRule("FigureElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FIGURE_ELEMENT));
		private static final @NonNull ParserRule PR_FigureRefElement = createParserRule("FigureRefElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FIGURE_REF_ELEMENT));
		private static final @NonNull ParserRule PR_FontElement = createParserRule("FontElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FONT_ELEMENT));
		private static final @NonNull ParserRule PR_FootnoteElement = createParserRule("FootnoteElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FOOTNOTE_ELEMENT));
		private static final @NonNull ParserRule PR_HeadingElement = createParserRule("HeadingElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.HEADING_ELEMENT));
		private static final @NonNull ParserRule PR_Markup = createParserRule("Markup", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.MARKUP));
		private static final @NonNull ParserRule PR_MarkupElement = createParserRule("MarkupElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.MARKUP_ELEMENT));
		private static final @NonNull ParserRule PR_MarkupKeyword = createParserRule("MarkupKeyword", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_NewLineElement = createParserRule("NewLineElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.NEW_LINE_ELEMENT));
		private static final @NonNull ParserRule PR_NullElement = createParserRule("NullElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.NULL_ELEMENT));
		private static final @NonNull ParserRule PR_OCLCodeElement = createParserRule("OCLCodeElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_CODE_ELEMENT));
		private static final @NonNull ParserRule PR_OCLEvalElement = createParserRule("OCLEvalElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_EVAL_ELEMENT));
		private static final @NonNull ParserRule PR_OCLTextElement = createParserRule("OCLTextElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_TEXT_ELEMENT));
		private static final @NonNull ParserRule PR_TextElement = createParserRule("TextElement", createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.TEXT_ELEMENT));

		private static void initParserRules() {
			PR_BulletElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.BULLET_ELEMENT)),
					createKeyword("bullet"),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("level", "=", createRuleCall(TR_INT)))),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_FigureElement.setAlternatives(
				createGroup(
					createKeyword("figure"),
					setCardinality("?", createGroup(
						createKeyword("#"),
						createAssignment("def", "=", createRuleCall(TR_ID)))),
					createKeyword("["),
					createAssignment("src", "=", createRuleCall(TR_STRING)),
					setCardinality("?", createGroup(
						createKeyword(","),
						createAssignment("alt", "=", createRuleCall(TR_STRING)),
						setCardinality("?", createGroup(
							createKeyword(","),
							createAssignment("requiredWidth", "=", createRuleCall(TR_INT)),
							setCardinality("?", createGroup(
								createKeyword(","),
								createAssignment("requiredHeight", "=", createRuleCall(TR_INT)))))))),
					createKeyword("]")));
			PR_FigureRefElement.setAlternatives(
				createGroup(
					createKeyword("figureRef"),
					createKeyword("["),
					createAssignment("ref", "=", createCrossReference(
						createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FIGURE_ELEMENT), createRuleCall(TR_ID))),
					createKeyword("]")));
			PR_FontElement.setAlternatives(
				createGroup(
					createAssignment("font", "=", createAlternatives(
						createKeyword("b"),
						createKeyword("e"))),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_FootnoteElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.FOOTNOTE_ELEMENT)),
					createKeyword("footnote"),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_HeadingElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.HEADING_ELEMENT)),
					createKeyword("heading"),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("level", "=", createRuleCall(TR_INT)))),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_Markup.setAlternatives(
				setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))));
			PR_MarkupElement.setAlternatives(
				createAlternatives(
					createRuleCall(PR_FontElement),
					createRuleCall(PR_NewLineElement),
					createRuleCall(PR_BulletElement),
					createRuleCall(PR_FigureElement),
					createRuleCall(PR_FigureRefElement),
					createRuleCall(PR_FootnoteElement),
					createRuleCall(PR_HeadingElement),
					createRuleCall(PR_NullElement),
					createRuleCall(PR_OCLCodeElement),
					createRuleCall(PR_OCLEvalElement),
					createRuleCall(PR_OCLTextElement),
					createRuleCall(PR_TextElement)));
			PR_MarkupKeyword.setAlternatives(
				createAlternatives(
					createKeyword("b"),
					createKeyword("e"),
					createKeyword("bullet"),
					createKeyword("figure"),
					createKeyword("figureRef"),
					createKeyword("footnote"),
					createKeyword("heading"),
					createKeyword("oclCode"),
					createKeyword("oclEval"),
					createKeyword("oclText")));
			PR_NewLineElement.setAlternatives(
				createAssignment("text", "=", createRuleCall(TR_NL)));
			PR_NullElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.NULL_ELEMENT)),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_OCLCodeElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_CODE_ELEMENT)),
					createKeyword("oclCode"),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_OCLEvalElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_EVAL_ELEMENT)),
					createKeyword("oclEval"),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_OCLTextElement.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.markupcs.MarkupPackage.Literals.OCL_TEXT_ELEMENT)),
					createKeyword("oclText"),
					createKeyword("["),
					setCardinality("*", createAssignment("elements", "+=", createRuleCall(PR_MarkupElement))),
					createKeyword("]")));
			PR_TextElement.setAlternatives(
				createAlternatives(
					setCardinality("+", createAssignment("text", "+=", createAlternatives(
						createRuleCall(TR_ID),
						createRuleCall(TR_WORD),
						createRuleCall(TR_INT),
						createRuleCall(TR_WS),
						createKeyword(":"),
						createKeyword("#"),
						createKeyword(",")))),
					createAssignment("text", "+=", createRuleCall(PR_MarkupKeyword))));
		}

		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_Markup;
			grammar.setDefinesHiddenTokens(true);
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_Markup);
				rules.add(TR_NUMBER);
				rules.add(TR_LETTER);
				rules.add(TR_ESCAPED);
				rules.add(TR_VERTICAL_WS);
				rules.add(TR_HORIZONTAL_WS);
				rules.add(TR_INT);
				rules.add(TR_STRING);
				rules.add(TR_ID);
				rules.add(TR_WORD);
				rules.add(TR_NL);
				rules.add(TR_WS);
				rules.add(TR_ANY_OTHER);
				rules.add(PR_MarkupKeyword);
				rules.add(PR_MarkupElement);
				rules.add(PR_BulletElement);
				rules.add(PR_FontElement);
				rules.add(PR_FigureElement);
				rules.add(PR_FigureRefElement);
				rules.add(PR_FootnoteElement);
				rules.add(PR_HeadingElement);
				rules.add(PR_NewLineElement);
				rules.add(PR_NullElement);
				rules.add(PR_OCLCodeElement);
				rules.add(PR_OCLEvalElement);
				rules.add(PR_OCLTextElement);
				rules.add(PR_TextElement);
			}
			return grammar;
		}
	}
}
