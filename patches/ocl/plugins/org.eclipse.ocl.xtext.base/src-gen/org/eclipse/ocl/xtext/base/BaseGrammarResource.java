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
 * from: E:\GIT\org.eclipse.ocl\plugins..\..\plugins\org.eclipse.ocl.xtext.base\src-gen\org\eclipse\ocl\xtext\base\Base.xtextbin
 * by: org.eclipse.ocl.examples.build.xtend.generateGrammar.xtend
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.base;

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
 * BaseGrammarResource provides a programmatically initialized org.eclipse.ocl.xtext.base.Base Grammar model avoiding
 * the speed limitations of the pre-Xtext 2.4 *.xmi models and the binary incompatibilities between differing *.xtextbin versions.
 * <p>
 * The grammar is immutable and is available as static INSTANCE and GRAMMAR fields.
 */
public class BaseGrammarResource extends AbstractGrammarResource
{
	private static final @NonNull Grammar G_Base = createGrammar("org.eclipse.ocl.xtext.base.Base");

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.base.Base Grammar resource.
	 */
	public static final @NonNull BaseGrammarResource INSTANCE = new BaseGrammarResource();

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.base.Base Grammar model.
	 */
	public static final @NonNull Grammar GRAMMAR = (Grammar)INSTANCE.getContents().get(0);

	/**
	 *	The name of the language supported by this grammar.
	 */
	public static final @NonNull String LANGUAGE_NAME = "org.eclipse.ocl.xtext.base.Base";

	protected BaseGrammarResource() {
		super(URI.createURI(LANGUAGE_NAME));
		List<EObject> contents = getContents();
		contents.add(_Base.initGrammar());
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
			return BaseGrammarResource.GRAMMAR;
		}
	}

	private static class _Base
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot

		private static final @NonNull TerminalRule TR_ANY_OTHER = createTerminalRule("ANY_OTHER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_DOUBLE_QUOTED_STRING = createTerminalRule("DOUBLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_CHARACTER = createTerminalRule("ESCAPED_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_ID = createTerminalRule("ESCAPED_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_INT = createTerminalRule("INT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_LETTER_CHARACTER = createTerminalRule("LETTER_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_COMMENT = createTerminalRule("ML_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_SINGLE_QUOTED_STRING = createTerminalRule("ML_SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SIMPLE_ID = createTerminalRule("SIMPLE_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SINGLE_QUOTED_STRING = createTerminalRule("SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SL_COMMENT = createTerminalRule("SL_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_WS = createTerminalRule("WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initTerminalRules() {
			TR_ANY_OTHER.setAlternatives(
				createWildcard());
			TR_DOUBLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("\""),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_ESCAPED_CHARACTER),
						createNegatedToken(createAlternatives(
							createKeyword("\\"),
							createKeyword("\""))))),
					createKeyword("\"")));
			TR_ESCAPED_CHARACTER.setFragment(true);
			TR_ESCAPED_CHARACTER.setAlternatives(
				createGroup(
					createKeyword("\\"),
					createAlternatives(
						createKeyword("b"),
						createKeyword("t"),
						createKeyword("n"),
						createKeyword("f"),
						createKeyword("r"),
						createKeyword("u"),
						createKeyword("\""),
						createKeyword("\'"),
						createKeyword("\\"))));
			TR_ESCAPED_ID.setAlternatives(
				createGroup(
					createKeyword("_"),
					createRuleCall(TR_SINGLE_QUOTED_STRING)));
			TR_INT.setAlternatives(
				setCardinality("+", createCharacterRange(createKeyword("0"), createKeyword("9"))));
			TR_LETTER_CHARACTER.setFragment(true);
			TR_LETTER_CHARACTER.setAlternatives(
				createAlternatives(
					createCharacterRange(createKeyword("a"), createKeyword("z")),
					createCharacterRange(createKeyword("A"), createKeyword("Z")),
					createKeyword("_")));
			TR_ML_COMMENT.setAlternatives(
				createGroup(
					createKeyword("/*"),
					createUntilToken(createKeyword("*/"))));
			TR_ML_SINGLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("/\'"),
					createUntilToken(createKeyword("\'/"))));
			TR_SIMPLE_ID.setAlternatives(
				createGroup(
					createRuleCall(TR_LETTER_CHARACTER),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_LETTER_CHARACTER),
						createCharacterRange(createKeyword("0"), createKeyword("9"))))));
			TR_SINGLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("\'"),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_ESCAPED_CHARACTER),
						createNegatedToken(createAlternatives(
							createKeyword("\\"),
							createKeyword("\'"))))),
					createKeyword("\'")));
			TR_SL_COMMENT.setAlternatives(
				createGroup(
					createKeyword("--"),
					setCardinality("*", createNegatedToken(createAlternatives(
						createKeyword("\n"),
						createKeyword("\r")))),
					setCardinality("?", createGroup(
						setCardinality("?", createKeyword("\r")),
						createKeyword("\n")))));
			TR_WS.setAlternatives(
				setCardinality("+", createAlternatives(
					createKeyword(" "),
					createKeyword("\t"),
					createKeyword("\r"),
					createKeyword("\n"))));
		}

		private static final @NonNull ParserRule PR_FirstPathElementCS = createParserRule("FirstPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_ID = createParserRule("ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_Identifier = createParserRule("Identifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_LOWER = createParserRule("LOWER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_MultiplicityBoundsCS = createParserRule("MultiplicityBoundsCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS));
		private static final @NonNull ParserRule PR_MultiplicityCS = createParserRule("MultiplicityCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_CS));
		private static final @NonNull ParserRule PR_MultiplicityStringCS = createParserRule("MultiplicityStringCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_STRING_CS));
		private static final @NonNull ParserRule PR_NUMBER_LITERAL = createParserRule("NUMBER_LITERAL", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.BIG_NUMBER));
		private static final @NonNull ParserRule PR_NextPathElementCS = createParserRule("NextPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_PathNameCS = createParserRule("PathNameCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_StringLiteral = createParserRule("StringLiteral", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_TemplateBindingCS = createParserRule("TemplateBindingCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_BINDING_CS));
		private static final @NonNull ParserRule PR_TemplateParameterSubstitutionCS = createParserRule("TemplateParameterSubstitutionCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS));
		private static final @NonNull ParserRule PR_TemplateSignatureCS = createParserRule("TemplateSignatureCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS));
		private static final @NonNull ParserRule PR_TypeParameterCS = createParserRule("TypeParameterCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_PARAMETER_CS));
		private static final @NonNull ParserRule PR_TypeRefCS = createParserRule("TypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_REF_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRefCS = createParserRule("TypedTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_UPPER = createParserRule("UPPER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_URI = createParserRule("URI", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnreservedPathNameCS = createParserRule("UnreservedPathNameCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_WildcardTypeRefCS = createParserRule("WildcardTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS));

		private static void initParserRules() {
			PR_FirstPathElementCS.setAlternatives(
				createAssignment("referredElement", "=", createCrossReference(
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(PR_UnrestrictedName))));
			PR_ID.setAlternatives(
				createAlternatives(
					createRuleCall(TR_SIMPLE_ID),
					createRuleCall(TR_ESCAPED_ID)));
			PR_Identifier.setAlternatives(
				createRuleCall(PR_ID));
			PR_LOWER.setAlternatives(
				createRuleCall(TR_INT));
			PR_MultiplicityBoundsCS.setAlternatives(
				createGroup(
					createAssignment("lowerBound", "=", createRuleCall(PR_LOWER)),
					setCardinality("?", createGroup(
						createKeyword(".."),
						createAssignment("upperBound", "=", createRuleCall(PR_UPPER))))));
			PR_MultiplicityCS.setAlternatives(
				createGroup(
					createKeyword("["),
					createAlternatives(
						createRuleCall(PR_MultiplicityBoundsCS),
						createRuleCall(PR_MultiplicityStringCS)),
					setCardinality("?", createAlternatives(
						createKeyword("|?"),
						createAssignment("isNullFree", "?=", createKeyword("|1")))),
					createKeyword("]")));
			PR_MultiplicityStringCS.setAlternatives(
				createAssignment("stringBounds", "=", createAlternatives(
					createKeyword("*"),
					createKeyword("+"),
					createKeyword("?"))));
			PR_NUMBER_LITERAL.setAlternatives(
				createRuleCall(TR_INT));
			PR_NextPathElementCS.setAlternatives(
				createAssignment("referredElement", "=", createCrossReference(
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(PR_UnreservedName))));
			PR_PathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_FirstPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_StringLiteral.setAlternatives(
				createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_TemplateBindingCS.setAlternatives(
				createGroup(
					createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)))),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(PR_MultiplicityCS)))));
			PR_TemplateParameterSubstitutionCS.setAlternatives(
				createAssignment("ownedActualParameter", "=", createRuleCall(PR_TypeRefCS)));
			PR_TemplateSignatureCS.setAlternatives(
				createGroup(
					createKeyword("("),
					createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)))),
					createKeyword(")")));
			PR_TypeParameterCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "+=", createRuleCall(PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword("&&"),
							createAssignment("ownedExtends", "+=", createRuleCall(PR_TypedRefCS))))))));
			PR_TypeRefCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_TypedRefCS),
					createRuleCall(PR_WildcardTypeRefCS)));
			PR_TypedRefCS.setAlternatives(
				createRuleCall(PR_TypedTypeRefCS));
			PR_TypedTypeRefCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(PR_PathNameCS)),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedBinding", "=", createRuleCall(PR_TemplateBindingCS)),
						createKeyword(")")))));
			PR_UPPER.setAlternatives(
				createAlternatives(
					createRuleCall(TR_INT),
					createKeyword("*")));
			PR_URI.setAlternatives(
				createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_UnreservedName.setAlternatives(
				createRuleCall(PR_UnrestrictedName));
			PR_UnreservedPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_UnrestrictedName.setAlternatives(
				createRuleCall(PR_Identifier));
			PR_WildcardTypeRefCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS)),
					createKeyword("?"),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "=", createRuleCall(PR_TypedRefCS))))));
		}

		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_Base;
			grammar.setDefinesHiddenTokens(true);
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_MultiplicityBoundsCS);
				rules.add(PR_MultiplicityCS);
				rules.add(PR_MultiplicityStringCS);
				rules.add(PR_PathNameCS);
				rules.add(PR_UnreservedPathNameCS);
				rules.add(PR_FirstPathElementCS);
				rules.add(PR_NextPathElementCS);
				rules.add(PR_TemplateBindingCS);
				rules.add(PR_TemplateParameterSubstitutionCS);
				rules.add(PR_TemplateSignatureCS);
				rules.add(PR_TypeParameterCS);
				rules.add(PR_TypeRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_TypedTypeRefCS);
				rules.add(PR_UnreservedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_WildcardTypeRefCS);
				rules.add(PR_ID);
				rules.add(PR_Identifier);
				rules.add(PR_LOWER);
				rules.add(PR_NUMBER_LITERAL);
				rules.add(PR_StringLiteral);
				rules.add(PR_UPPER);
				rules.add(PR_URI);
				rules.add(TR_ESCAPED_CHARACTER);
				rules.add(TR_LETTER_CHARACTER);
				rules.add(TR_DOUBLE_QUOTED_STRING);
				rules.add(TR_SINGLE_QUOTED_STRING);
				rules.add(TR_ML_SINGLE_QUOTED_STRING);
				rules.add(TR_SIMPLE_ID);
				rules.add(TR_ESCAPED_ID);
				rules.add(TR_INT);
				rules.add(TR_ML_COMMENT);
				rules.add(TR_SL_COMMENT);
				rules.add(TR_WS);
				rules.add(TR_ANY_OTHER);
			}
			{
				List<AbstractRule> hiddenTokens = grammar.getHiddenTokens();
				hiddenTokens.add(TR_WS);
				hiddenTokens.add(TR_ML_COMMENT);
				hiddenTokens.add(TR_SL_COMMENT);
			}
			return grammar;
		}
	}
}
