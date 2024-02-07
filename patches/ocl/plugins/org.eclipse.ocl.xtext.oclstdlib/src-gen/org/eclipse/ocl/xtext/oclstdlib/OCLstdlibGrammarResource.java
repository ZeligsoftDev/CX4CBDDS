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
 * from: E:\GIT\org.eclipse.ocl\plugins..\..\plugins\org.eclipse.ocl.xtext.oclstdlib\src-gen\org\eclipse\ocl\xtext\oclstdlib\OCLstdlib.xtextbin
 * by: org.eclipse.ocl.examples.build.xtend.generateGrammar.xtend
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.ocl.xtext.oclstdlib;

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
 * OCLstdlibGrammarResource provides a programmatically initialized org.eclipse.ocl.xtext.oclstdlib.OCLstdlib Grammar model avoiding
 * the speed limitations of the pre-Xtext 2.4 *.xmi models and the binary incompatibilities between differing *.xtextbin versions.
 * <p>
 * The grammar is immutable and is available as static INSTANCE and GRAMMAR fields.
 */
public class OCLstdlibGrammarResource extends AbstractGrammarResource
{
	private static final @NonNull Grammar G_OCLstdlib = createGrammar("org.eclipse.ocl.xtext.oclstdlib.OCLstdlib");
	private static final @NonNull Grammar G_EssentialOCL = createGrammar("org.eclipse.ocl.xtext.essentialocl.EssentialOCL");
	private static final @NonNull Grammar G_Base = createGrammar("org.eclipse.ocl.xtext.base.Base");

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.oclstdlib.OCLstdlib Grammar resource.
	 */
	public static final @NonNull OCLstdlibGrammarResource INSTANCE = new OCLstdlibGrammarResource();

	/**
	 *	The shared immutable instance of the org.eclipse.ocl.xtext.oclstdlib.OCLstdlib Grammar model.
	 */
	public static final @NonNull Grammar GRAMMAR = (Grammar)INSTANCE.getContents().get(0);

	/**
	 *	The name of the language supported by this grammar.
	 */
	public static final @NonNull String LANGUAGE_NAME = "org.eclipse.ocl.xtext.oclstdlib.OCLstdlib";

	protected OCLstdlibGrammarResource() {
		super(URI.createURI(LANGUAGE_NAME));
		List<EObject> contents = getContents();
		contents.add(_OCLstdlib.initGrammar());
		contents.add(_EssentialOCL.initGrammar());
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
			return OCLstdlibGrammarResource.GRAMMAR;
		}
	}

	private static class _OCLstdlib
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/OCLstdlibCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_essentialocl = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, "essentialocl"); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot

		private static final @NonNull ParserRule PR_AccumulatorCS = createParserRule("AccumulatorCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PARAMETER_CS));
		private static final @NonNull ParserRule PR_AnnotationCS = createParserRule("AnnotationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ANNOTATION_CS));
		private static final @NonNull ParserRule PR_AnnotationElementCS = createParserRule("AnnotationElementCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ANNOTATION_ELEMENT_CS));
		private static final @NonNull ParserRule PR_AnyName = createParserRule("AnyName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ClassCS = createParserRule("ClassCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.CLASS_CS));
		private static final @NonNull ParserRule PR_DetailCS = createParserRule("DetailCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.DETAIL_CS));
		private static final @NonNull ParserRule PR_DocumentationCS = createParserRule("DocumentationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.DOCUMENTATION_CS));
		private static final @NonNull ParserRule PR_Identifier = createParserRule("Identifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ImportCS = createParserRule("ImportCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.IMPORT_CS));
		private static final @NonNull ParserRule PR_InvCS = createParserRule("InvCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_CONSTRAINT_CS));
		private static final @NonNull ParserRule PR_IteratorCS = createParserRule("IteratorCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PARAMETER_CS));
		private static final @NonNull ParserRule PR_LambdaContextTypeRefCS = createParserRule("LambdaContextTypeRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_LambdaTypeCS = createParserRule("LambdaTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.LAMBDA_TYPE_CS));
		private static final @NonNull ParserRule PR_LibClassCS = createParserRule("LibClassCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_CLASS_CS));
		private static final @NonNull ParserRule PR_LibCoercionCS = createParserRule("LibCoercionCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_COERCION_CS));
		private static final @NonNull ParserRule PR_LibIterationCS = createParserRule("LibIterationCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_ITERATION_CS));
		private static final @NonNull ParserRule PR_LibOperationCS = createParserRule("LibOperationCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_OPERATION_CS));
		private static final @NonNull ParserRule PR_LibOppositeCS = createParserRule("LibOppositeCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_OPPOSITE_CS));
		private static final @NonNull ParserRule PR_LibPackageCS = createParserRule("LibPackageCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_PACKAGE_CS));
		private static final @NonNull ParserRule PR_LibPathElementCS = createParserRule("LibPathElementCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_LibPathNameCS = createParserRule("LibPathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_LibPropertyCS = createParserRule("LibPropertyCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_PROPERTY_CS));
		private static final @NonNull ParserRule PR_Library = createParserRule("Library", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_ROOT_PACKAGE_CS));
		private static final @NonNull ParserRule PR_Name = createParserRule("Name", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_OperationCS = createParserRule("OperationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.OPERATION_CS));
		private static final @NonNull ParserRule PR_PackageCS = createParserRule("PackageCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PACKAGE_CS));
		private static final @NonNull ParserRule PR_ParameterCS = createParserRule("ParameterCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PARAMETER_CS));
		private static final @NonNull ParserRule PR_PostCS = createParserRule("PostCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_CONSTRAINT_CS));
		private static final @NonNull ParserRule PR_PreCS = createParserRule("PreCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.LIB_CONSTRAINT_CS));
		private static final @NonNull ParserRule PR_PrecedenceCS = createParserRule("PrecedenceCS", createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.PRECEDENCE_CS));
		private static final @NonNull ParserRule PR_RestrictedKeywords = createParserRule("RestrictedKeywords", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_SpecificationCS = createParserRule("SpecificationCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS));
		private static final @NonNull ParserRule PR_TuplePartCS = createParserRule("TuplePartCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_PART_CS));
		private static final @NonNull ParserRule PR_TypedMultiplicityRefCS = createParserRule("TypedMultiplicityRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRefCS = createParserRule("TypedTypeRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));

		private static void initParserRules() {
			PR_AccumulatorCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_Identifier)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS))));
			PR_AnnotationCS.setAlternatives(
				createGroup(
					createKeyword("annotation"),
					createAssignment("name", "=", createAlternatives(
						createRuleCall(PR_Identifier),
						createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedDetails", "+=", createRuleCall(PR_DetailCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedDetails", "+=", createRuleCall(PR_DetailCS)))),
						createKeyword(")"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)),
							createKeyword("}")),
						createKeyword(";"))));
			PR_AnnotationElementCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_AnnotationCS),
					createRuleCall(PR_DocumentationCS)));
			PR_AnyName.setAlternatives(
				createAlternatives(
					createRuleCall(PR_Name),
					createKeyword("Lambda"),
					createKeyword("Map"),
					createKeyword("Tuple")));
			PR_ClassCS.setAlternatives(
				createRuleCall(PR_LibClassCS));
			PR_DetailCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createAlternatives(
						createRuleCall(PR_Name),
						createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))),
					createKeyword("="),
					setCardinality("*", createAssignment("values", "+=", createAlternatives(
						createRuleCall(_Base.TR_SINGLE_QUOTED_STRING),
						createRuleCall(_Base.TR_ML_SINGLE_QUOTED_STRING))))));
			PR_DocumentationCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.DOCUMENTATION_CS)),
					createKeyword("documentation"),
					setCardinality("?", createAssignment("value", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedDetails", "+=", createRuleCall(PR_DetailCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedDetails", "+=", createRuleCall(PR_DetailCS)))),
						createKeyword(")"))),
					createKeyword(";")));
			PR_Identifier.setAlternatives(
				createAlternatives(
					createRuleCall(_Base.PR_ID),
					createRuleCall(PR_RestrictedKeywords)));
			addAnnotation(PR_Identifier, "Override");
			PR_ImportCS.setAlternatives(
				createGroup(
					createKeyword("import"),
					setCardinality("?", createGroup(
						createAssignment("name", "=", createRuleCall(PR_Identifier)),
						createKeyword(":"))),
					createAssignment("ownedPathName", "=", createRuleCall(_EssentialOCL.PR_URIPathNameCS)),
					setCardinality("?", createAssignment("isAll", "?=", createKeyword("::*")))));
			PR_InvCS.setAlternatives(
				createGroup(
					createAssignment("stereotype", "=", createKeyword("inv")),
					setCardinality("?", createGroup(
						createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)),
						setCardinality("?", createGroup(
							createKeyword("("),
							createAssignment("ownedMessageSpecification", "=", createRuleCall(PR_SpecificationCS)),
							createKeyword(")"))))),
					createKeyword(":"),
					createAssignment("ownedSpecification", "=", createRuleCall(PR_SpecificationCS)),
					createKeyword(";")));
			PR_IteratorCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_Identifier)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS))));
			PR_LambdaContextTypeRefCS.setAlternatives(
				createAssignment("ownedPathName", "=", createRuleCall(PR_LibPathNameCS)));
			PR_LambdaTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createKeyword("Lambda")),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					createAssignment("ownedContextType", "=", createRuleCall(PR_LambdaContextTypeRefCS)),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedParameterTypes", "+=", createRuleCall(PR_TypedMultiplicityRefCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParameterTypes", "+=", createRuleCall(PR_TypedMultiplicityRefCS)))))),
					createKeyword(")"),
					createKeyword(":"),
					createAssignment("ownedResultType", "=", createRuleCall(PR_TypedRefCS))));
			PR_LibClassCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isAbstract", "?=", createKeyword("abstract"))),
					createKeyword("type"),
					createAssignment("name", "=", createRuleCall(PR_AnyName)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("metaclassName", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.METACLASS_NAME_CS), createRuleCall(PR_AnyName))))),
					setCardinality("?", createGroup(
						createKeyword("conformsTo"),
						createAssignment("ownedSuperTypes", "+=", createRuleCall(PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedSuperTypes", "+=", createRuleCall(PR_TypedRefCS)))))),
					setCardinality("?", createGroup(
						createKeyword("=>"),
						createAssignment("implementation", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))))),
					createKeyword("{"),
					setCardinality("*", createAlternatives(
						createAssignment("ownedOperations", "+=", createRuleCall(PR_OperationCS)),
						createAssignment("ownedProperties", "+=", createRuleCall(PR_LibPropertyCS)),
						createAssignment("ownedConstraints", "+=", createRuleCall(PR_InvCS)),
						createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)))),
					createKeyword("}")));
			PR_LibCoercionCS.setAlternatives(
				createGroup(
					createKeyword("coercion"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					createKeyword("("),
					createKeyword(")"),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)),
					setCardinality("?", createGroup(
						createKeyword("=>"),
						createAssignment("implementation", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)),
								createAssignment("ownedPreconditions", "+=", createRuleCall(PR_PostCS)),
								createAssignment("ownedPostconditions", "+=", createRuleCall(PR_PreCS)))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_LibIterationCS.setAlternatives(
				createGroup(
					createKeyword("iteration"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					createKeyword("("),
					createAssignment("ownedIterators", "+=", createRuleCall(PR_IteratorCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedIterators", "+=", createRuleCall(PR_IteratorCS)))),
					setCardinality("?", createGroup(
						createKeyword(";"),
						createAssignment("ownedAccumulators", "+=", createRuleCall(PR_AccumulatorCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedAccumulators", "+=", createRuleCall(PR_AccumulatorCS)))))),
					setCardinality("?", createGroup(
						createKeyword("|"),
						createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)))))),
					createKeyword(")"),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)),
					setCardinality("?", createAssignment("isInvalidating", "?=", createKeyword("invalidating"))),
					setCardinality("?", createAssignment("isValidating", "?=", createKeyword("validating"))),
					setCardinality("?", createGroup(
						createKeyword("=>"),
						createAssignment("implementation", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)),
								createAssignment("ownedPreconditions", "+=", createRuleCall(PR_PostCS)),
								createAssignment("ownedPostconditions", "+=", createRuleCall(PR_PreCS)))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_LibOperationCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isStatic", "?=", createKeyword("static"))),
					createKeyword("operation"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)))))),
					createKeyword(")"),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)),
					setCardinality("?", createAssignment("isValidating", "?=", createKeyword("validating"))),
					setCardinality("?", createAssignment("isInvalidating", "?=", createKeyword("invalidating"))),
					setCardinality("?", createGroup(
						createKeyword("precedence"),
						createKeyword("="),
						createAssignment("precedence", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PRECEDENCE), createRuleCall(PR_Name))))),
					setCardinality("?", createGroup(
						createKeyword("=>"),
						createAssignment("implementation", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)),
								createGroup(
									createKeyword("body"),
									setCardinality("?", createRuleCall(_EssentialOCL.PR_UnrestrictedName)),
									createKeyword(":"),
									createAssignment("ownedBodyExpressions", "+=", createRuleCall(PR_SpecificationCS)),
									createKeyword(";")),
								createAssignment("ownedPostconditions", "+=", createRuleCall(PR_PostCS)),
								createAssignment("ownedPreconditions", "+=", createRuleCall(PR_PreCS)))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_LibOppositeCS.setAlternatives(
				createGroup(
					createKeyword("opposite"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS))));
			PR_LibPackageCS.setAlternatives(
				createGroup(
					createKeyword("library"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("nsPrefix", "=", createRuleCall(PR_Identifier)),
						createKeyword("="),
						createAssignment("nsURI", "=", createRuleCall(_Base.PR_URI)))),
					createKeyword("{"),
					setCardinality("*", createAlternatives(
						createAssignment("ownedPackages", "+=", createRuleCall(PR_PackageCS)),
						createGroup(
							createKeyword("precedence"),
							setCardinality("+", createAssignment("ownedPrecedences", "+=", createRuleCall(PR_PrecedenceCS))),
							createKeyword(";")),
						createAssignment("ownedClasses", "+=", createRuleCall(PR_ClassCS)),
						createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)))),
					createKeyword("}")));
			PR_LibPathElementCS.setAlternatives(
				createAssignment("referredElement", "=", createCrossReference(
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(PR_Name))));
			PR_LibPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_LibPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_LibPathElementCS))))));
			PR_LibPropertyCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isStatic", "?=", createKeyword("static"))),
					createKeyword("property"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)),
					setCardinality("?", createAssignment("ownedOpposite", "=", createRuleCall(PR_LibOppositeCS))),
					setCardinality("?", createGroup(
						createKeyword("=>"),
						createAssignment("implementation", "=", createCrossReference(
							createTypeRef(MM, org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_Library.setAlternatives(
				createGroup(
					setCardinality("*", createGroup(
						createAssignment("ownedImports", "+=", createRuleCall(PR_ImportCS)),
						createKeyword(";"))),
					setCardinality("*", createAssignment("ownedPackages", "+=", createRuleCall(PR_LibPackageCS)))));
			PR_Name.setAlternatives(
				createAlternatives(
					createRuleCall(PR_Identifier),
					createRuleCall(_Base.TR_DOUBLE_QUOTED_STRING),
					createRuleCall(_EssentialOCL.PR_EssentialOCLReservedKeyword),
					createRuleCall(_EssentialOCL.PR_PrimitiveTypeIdentifier),
					createRuleCall(_EssentialOCL.PR_CollectionTypeIdentifier)));
			PR_OperationCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_LibCoercionCS),
					createRuleCall(PR_LibIterationCS),
					createRuleCall(PR_LibOperationCS)));
			PR_PackageCS.setAlternatives(
				createGroup(
					createKeyword("package"),
					createAssignment("name", "=", createRuleCall(PR_Name)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("nsPrefix", "=", createRuleCall(PR_Identifier)),
						createKeyword("="),
						createAssignment("nsURI", "=", createRuleCall(_Base.PR_URI)))),
					createKeyword("{"),
					setCardinality("*", createAlternatives(
						createAssignment("ownedPackages", "+=", createRuleCall(PR_PackageCS)),
						createAssignment("ownedClasses", "+=", createRuleCall(PR_ClassCS)),
						createAssignment("ownedAnnotations", "+=", createRuleCall(PR_AnnotationElementCS)))),
					createKeyword("}")));
			PR_ParameterCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_Identifier)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS))));
			PR_PostCS.setAlternatives(
				createGroup(
					createAssignment("stereotype", "=", createKeyword("post")),
					setCardinality("?", createGroup(
						createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)),
						setCardinality("?", createGroup(
							createKeyword("("),
							createAssignment("ownedMessageSpecification", "=", createRuleCall(PR_SpecificationCS)),
							createKeyword(")"))))),
					createKeyword(":"),
					createAssignment("ownedSpecification", "=", createRuleCall(PR_SpecificationCS)),
					createKeyword(";")));
			PR_PreCS.setAlternatives(
				createGroup(
					createAssignment("stereotype", "=", createKeyword("pre")),
					setCardinality("?", createGroup(
						createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)),
						setCardinality("?", createGroup(
							createKeyword("("),
							createAssignment("ownedMessageSpecification", "=", createRuleCall(PR_SpecificationCS)),
							createKeyword(")"))))),
					createKeyword(":"),
					createAssignment("ownedSpecification", "=", createRuleCall(PR_SpecificationCS)),
					createKeyword(";")));
			PR_PrecedenceCS.setAlternatives(
				createGroup(
					createAlternatives(
						createKeyword("left"),
						createAssignment("isRightAssociative", "?=", createKeyword("right"))),
					createKeyword(":"),
					createAssignment("name", "=", createRuleCall(PR_Name))));
			PR_RestrictedKeywords.setAlternatives(
				createAlternatives(
					createKeyword("abstract"),
					createKeyword("annotation"),
					createKeyword("conformsTo"),
					createKeyword("documentation"),
					createKeyword("extends"),
					createKeyword("import"),
					createKeyword("inv"),
					createKeyword("invalidating"),
					createKeyword("iteration"),
					createKeyword("left"),
					createKeyword("library"),
					createKeyword("operation"),
					createKeyword("opposite"),
					createKeyword("package"),
					createKeyword("post"),
					createKeyword("pre"),
					createKeyword("precedence"),
					createKeyword("property"),
					createKeyword("right"),
					createKeyword("static"),
					createKeyword("type"),
					createKeyword("validating")));
			PR_SpecificationCS.setAlternatives(
				createAssignment("ownedExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)));
			PR_TuplePartCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_Identifier)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS))));
			addAnnotation(PR_TuplePartCS, "Override");
			PR_TypedMultiplicityRefCS.setAlternatives(
				createGroup(
					createAlternatives(
						createRuleCall(_EssentialOCL.PR_MapTypeCS),
						createRuleCall(_EssentialOCL.PR_TupleTypeCS),
						createRuleCall(PR_TypedTypeRefCS),
						createRuleCall(PR_LambdaTypeCS)),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypedRefCS.setAlternatives(
				createAlternatives(
					createRuleCall(_EssentialOCL.PR_MapTypeCS),
					createRuleCall(_EssentialOCL.PR_TupleTypeCS),
					createRuleCall(PR_TypedTypeRefCS),
					createRuleCall(PR_LambdaTypeCS)));
			addAnnotation(PR_TypedRefCS, "Override");
			PR_TypedTypeRefCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("isTypeof", "?=", createKeyword("typeof")),
						createKeyword("("),
						createAssignment("ownedPathName", "=", createRuleCall(PR_LibPathNameCS)),
						createKeyword(")")),
					createGroup(
						createAssignment("ownedPathName", "=", createRuleCall(PR_LibPathNameCS)),
						setCardinality("?", createGroup(
							createKeyword("("),
							createAssignment("ownedBinding", "=", createRuleCall(_Base.PR_TemplateBindingCS)),
							createKeyword(")"))))));
			addAnnotation(PR_TypedTypeRefCS, "Override");
		}

		private static @NonNull Grammar initGrammar() {
			initParserRules();
			Grammar grammar = G_OCLstdlib;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM_essentialocl);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_Library);
				rules.add(PR_Identifier);
				rules.add(PR_RestrictedKeywords);
				rules.add(PR_Name);
				rules.add(PR_AnyName);
				rules.add(PR_LibPathNameCS);
				rules.add(PR_LibPathElementCS);
				rules.add(PR_AccumulatorCS);
				rules.add(PR_AnnotationCS);
				rules.add(PR_AnnotationElementCS);
				rules.add(PR_LibClassCS);
				rules.add(PR_ClassCS);
				rules.add(PR_DetailCS);
				rules.add(PR_DocumentationCS);
				rules.add(PR_ImportCS);
				rules.add(PR_InvCS);
				rules.add(PR_LibCoercionCS);
				rules.add(PR_LibIterationCS);
				rules.add(PR_IteratorCS);
				rules.add(PR_LambdaTypeCS);
				rules.add(PR_LambdaContextTypeRefCS);
				rules.add(PR_OperationCS);
				rules.add(PR_LibOperationCS);
				rules.add(PR_LibOppositeCS);
				rules.add(PR_LibPackageCS);
				rules.add(PR_PackageCS);
				rules.add(PR_ParameterCS);
				rules.add(PR_LibPropertyCS);
				rules.add(PR_PostCS);
				rules.add(PR_PreCS);
				rules.add(PR_PrecedenceCS);
				rules.add(PR_SpecificationCS);
				rules.add(PR_TypedMultiplicityRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_TypedTypeRefCS);
				rules.add(PR_TuplePartCS);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_EssentialOCL);
			}
			return grammar;
		}
	}

	private static class _EssentialOCL
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot

		private static final @NonNull ParserRule PR_BinaryOperatorName = createParserRule("BinaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_BooleanLiteralExpCS = createParserRule("BooleanLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CoIteratorVariableCS = createParserRule("CoIteratorVariableCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.VARIABLE_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralExpCS = createParserRule("CollectionLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralPartCS = createParserRule("CollectionLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_CollectionPatternCS = createParserRule("CollectionPatternCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS));
		private static final @NonNull ParserRule PR_CollectionTypeCS = createParserRule("CollectionTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS));
		private static final @NonNull ParserRule PR_CollectionTypeIdentifier = createParserRule("CollectionTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_CurlyBracketedClauseCS = createParserRule("CurlyBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_ElseIfThenExpCS = createParserRule("ElseIfThenExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS));
		private static final @NonNull ParserRule PR_EssentialOCLInfixOperatorName = createParserRule("EssentialOCLInfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLNavigationOperatorName = createParserRule("EssentialOCLNavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLReservedKeyword = createParserRule("EssentialOCLReservedKeyword", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnaryOperatorName = createParserRule("EssentialOCLUnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnreservedName = createParserRule("EssentialOCLUnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnrestrictedName = createParserRule("EssentialOCLUnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ExpCS = createParserRule("ExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_IfExpCS = createParserRule("IfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_EXP_CS));
		private static final @NonNull ParserRule PR_InfixOperatorName = createParserRule("InfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_InvalidLiteralExpCS = createParserRule("InvalidLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LambdaLiteralExpCS = createParserRule("LambdaLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LetExpCS = createParserRule("LetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_EXP_CS));
		private static final @NonNull ParserRule PR_LetVariableCS = createParserRule("LetVariableCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_VARIABLE_CS));
		private static final @NonNull ParserRule PR_MapLiteralExpCS = createParserRule("MapLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_MapLiteralPartCS = createParserRule("MapLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_MapTypeCS = createParserRule("MapTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_TYPE_CS));
		private static final @NonNull ParserRule PR_Model = createParserRule("Model", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CONTEXT_CS));
		private static final @NonNull ParserRule PR_NameExpCS = createParserRule("NameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAME_EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingArgCS = createParserRule("NavigatingArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingArgExpCS = createParserRule("NavigatingArgExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingBarArgCS = createParserRule("NavigatingBarArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingCommaArgCS = createParserRule("NavigatingCommaArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingSemiArgCS = createParserRule("NavigatingSemiArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigationOperatorName = createParserRule("NavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_NestedExpCS = createParserRule("NestedExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NESTED_EXP_CS));
		private static final @NonNull ParserRule PR_NullLiteralExpCS = createParserRule("NullLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_NumberLiteralExpCS = createParserRule("NumberLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PatternExpCS = createParserRule("PatternExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PATTERN_EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedLetExpCS = createParserRule("PrefixedLetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedPrimaryExpCS = createParserRule("PrefixedPrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimaryExpCS = createParserRule("PrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveLiteralExpCS = createParserRule("PrimitiveLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PRIMITIVE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeCS = createParserRule("PrimitiveTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeIdentifier = createParserRule("PrimitiveTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_RoundBracketedClauseCS = createParserRule("RoundBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_SelfExpCS = createParserRule("SelfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS));
		private static final @NonNull ParserRule PR_ShadowPartCS = createParserRule("ShadowPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SHADOW_PART_CS));
		private static final @NonNull ParserRule PR_SimplePathNameCS = createParserRule("SimplePathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_SquareBracketedClauseCS = createParserRule("SquareBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_StringLiteralExpCS = createParserRule("StringLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralExpCS = createParserRule("TupleLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralPartCS = createParserRule("TupleLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_TuplePartCS = createParserRule("TuplePartCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_PART_CS));
		private static final @NonNull ParserRule PR_TupleTypeCS = createParserRule("TupleTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_TYPE_CS));
		private static final @NonNull ParserRule PR_TypeExpCS = createParserRule("TypeExpCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeExpWithoutMultiplicityCS = createParserRule("TypeExpWithoutMultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralCS = createParserRule("TypeLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralExpCS = createParserRule("TypeLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TypeLiteralWithMultiplicityCS = createParserRule("TypeLiteralWithMultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeNameExpCS = createParserRule("TypeNameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS));
		private static final @NonNull ParserRule PR_URIFirstPathElementCS = createParserRule("URIFirstPathElementCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_URIPathNameCS = createParserRule("URIPathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_UnaryOperatorName = createParserRule("UnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnlimitedNaturalLiteralExpCS = createParserRule("UnlimitedNaturalLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initParserRules() {
			PR_BinaryOperatorName.setAlternatives(
				createAlternatives(
					createRuleCall(PR_InfixOperatorName),
					createRuleCall(PR_NavigationOperatorName)));
			PR_BooleanLiteralExpCS.setAlternatives(
				createAlternatives(
					createAssignment("symbol", "=", createKeyword("true")),
					createAssignment("symbol", "=", createKeyword("false"))));
			PR_CoIteratorVariableCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS))))));
			PR_CollectionLiteralExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)))))),
					createKeyword("}")));
			PR_CollectionLiteralPartCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)),
						setCardinality("?", createGroup(
							createKeyword(".."),
							createAssignment("ownedLastExpression", "=", createRuleCall(PR_ExpCS))))),
					createAssignment("ownedExpression", "=", createRuleCall(PR_PatternExpCS))));
			PR_CollectionPatternCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)))),
						createGroup(
							createKeyword("++"),
							createAssignment("restVariableName", "=", createRuleCall(_OCLstdlib.PR_Identifier))))),
					createKeyword("}")));
			PR_CollectionTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_CollectionTypeIdentifier)),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpWithoutMultiplicityCS)),
						setCardinality("?", createAssignment("ownedCollectionMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS))),
						createKeyword(")")))));
			PR_CollectionTypeIdentifier.setAlternatives(
				createAlternatives(
					createKeyword("Set"),
					createKeyword("Bag"),
					createKeyword("Sequence"),
					createKeyword("Collection"),
					createKeyword("OrderedSet")));
			PR_CurlyBracketedClauseCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)))))),
					createKeyword("}")));
			PR_ElseIfThenExpCS.setAlternatives(
				createGroup(
					createKeyword("elseif"),
					createAssignment("ownedCondition", "=", createRuleCall(PR_ExpCS)),
					createKeyword("then"),
					createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS))));
			PR_EssentialOCLInfixOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("*"),
					createKeyword("/"),
					createKeyword("+"),
					createKeyword("-"),
					createKeyword(">"),
					createKeyword("<"),
					createKeyword(">="),
					createKeyword("<="),
					createKeyword("="),
					createKeyword("<>"),
					createKeyword("and"),
					createKeyword("and2"),
					createKeyword("implies"),
					createKeyword("implies2"),
					createKeyword("or"),
					createKeyword("or2"),
					createKeyword("xor"),
					createKeyword("xor2")));
			PR_EssentialOCLNavigationOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("."),
					createKeyword("->"),
					createKeyword("?."),
					createKeyword("?->")));
			PR_EssentialOCLReservedKeyword.setAlternatives(
				createAlternatives(
					createKeyword("and"),
					createKeyword("and2"),
					createKeyword("else"),
					createKeyword("endif"),
					createKeyword("if"),
					createKeyword("implies"),
					createKeyword("implies2"),
					createKeyword("in"),
					createKeyword("let"),
					createKeyword("not"),
					createKeyword("not2"),
					createKeyword("or"),
					createKeyword("or2"),
					createKeyword("then"),
					createKeyword("with"),
					createKeyword("xor"),
					createKeyword("xor2")));
			PR_EssentialOCLUnaryOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("-"),
					createKeyword("not"),
					createKeyword("not2")));
			PR_EssentialOCLUnreservedName.setAlternatives(
				createAlternatives(
					createRuleCall(PR_UnrestrictedName),
					createRuleCall(PR_CollectionTypeIdentifier),
					createRuleCall(PR_PrimitiveTypeIdentifier),
					createKeyword("Map"),
					createKeyword("Tuple")));
			PR_EssentialOCLUnrestrictedName.setAlternatives(
				createRuleCall(_OCLstdlib.PR_Identifier));
			PR_ExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createRuleCall(PR_PrefixedPrimaryExpCS),
						setCardinality("?", createGroup(
							createAction("ownedLeft", "=", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INFIX_EXP_CS)),
							createAssignment("name", "=", createRuleCall(PR_BinaryOperatorName)),
							createAssignment("ownedRight", "=", createRuleCall(PR_ExpCS))))),
					createRuleCall(PR_PrefixedLetExpCS)));
			PR_IfExpCS.setAlternatives(
				createGroup(
					createKeyword("if"),
					createAssignment("ownedCondition", "=", createAlternatives(
						createRuleCall(PR_ExpCS),
						createRuleCall(PR_PatternExpCS))),
					createKeyword("then"),
					createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS)),
					setCardinality("*", createAssignment("ownedIfThenExpressions", "+=", createRuleCall(PR_ElseIfThenExpCS))),
					createKeyword("else"),
					createAssignment("ownedElseExpression", "=", createRuleCall(PR_ExpCS)),
					createKeyword("endif")));
			PR_InfixOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLInfixOperatorName));
			PR_InvalidLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS)),
					createKeyword("invalid")));
			PR_LambdaLiteralExpCS.setAlternatives(
				createGroup(
					createKeyword("Lambda"),
					createKeyword("{"),
					createAssignment("ownedExpressionCS", "=", createRuleCall(PR_ExpCS)),
					createKeyword("}")));
			PR_LetExpCS.setAlternatives(
				createGroup(
					createKeyword("let"),
					createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)))),
					createKeyword("in"),
					createAssignment("ownedInExpression", "=", createRuleCall(PR_ExpCS))));
			PR_LetVariableCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
					createKeyword("="),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_MapLiteralExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_MapTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)))))),
					createKeyword("}")));
			PR_MapLiteralPartCS.setAlternatives(
				createGroup(
					createAssignment("ownedKey", "=", createRuleCall(PR_ExpCS)),
					createAlternatives(
						createKeyword("with"),
						createKeyword("<-")),
					createAssignment("ownedValue", "=", createRuleCall(PR_ExpCS))));
			PR_MapTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createKeyword("Map")),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedKeyType", "=", createRuleCall(PR_TypeExpCS)),
						createKeyword(","),
						createAssignment("ownedValueType", "=", createRuleCall(PR_TypeExpCS)),
						createKeyword(")")))));
			PR_Model.setAlternatives(
				createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)));
			PR_NameExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)),
					setCardinality("*", createAssignment("ownedSquareBracketedClauses", "+=", createRuleCall(PR_SquareBracketedClauseCS))),
					setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))),
					setCardinality("?", createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS))),
					setCardinality("?", createGroup(
						createAssignment("isPre", "?=", createKeyword("@")),
						createKeyword("pre")))));
			PR_NavigatingArgCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
						setCardinality("?", createAlternatives(
							createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)),
								setCardinality("?", createGroup(
									createKeyword("="),
									createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
							createGroup(
								createKeyword(":"),
								createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
								setCardinality("?", createGroup(
									createAlternatives(
										createKeyword("with"),
										createKeyword("<-")),
									createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
								setCardinality("?", createGroup(
									createKeyword("="),
									createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
							createGroup(
								setCardinality("?", createGroup(
									createKeyword(":"),
									createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
								setCardinality("?", createGroup(
									createAlternatives(
										createKeyword("with"),
										createKeyword("<-")),
									createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
								createKeyword("in"),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))),
					createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))));
			PR_NavigatingArgExpCS.setAlternatives(
				createRuleCall(PR_ExpCS));
			PR_NavigatingBarArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword("|")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
						setCardinality("?", createGroup(
							createKeyword("="),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigatingCommaArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword(",")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createAlternatives(
						createGroup(
							createAlternatives(
								createKeyword("with"),
								createKeyword("<-")),
							createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)),
							setCardinality("?", createGroup(
								createKeyword("="),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
						createGroup(
							createKeyword(":"),
							createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
							setCardinality("?", createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
							setCardinality("?", createGroup(
								createKeyword("="),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
						createGroup(
							setCardinality("?", createGroup(
								createKeyword(":"),
								createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
							setCardinality("?", createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
							createKeyword("in"),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))));
			PR_NavigatingSemiArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword(";")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
						setCardinality("?", createGroup(
							createKeyword("="),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigationOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLNavigationOperatorName));
			PR_NestedExpCS.setAlternatives(
				createGroup(
					createKeyword("("),
					createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)),
					createKeyword(")")));
			PR_NullLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS)),
					createKeyword("null")));
			PR_NumberLiteralExpCS.setAlternatives(
				createAssignment("symbol", "=", createRuleCall(_Base.PR_NUMBER_LITERAL)));
			PR_PatternExpCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("patternVariableName", "=", createRuleCall(PR_UnrestrictedName))),
					createKeyword(":"),
					createAssignment("ownedPatternType", "=", createRuleCall(PR_TypeExpCS))));
			PR_PrefixedLetExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)),
						createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)),
						createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedLetExpCS))),
					createRuleCall(PR_LetExpCS)));
			PR_PrefixedPrimaryExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)),
						createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)),
						createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedPrimaryExpCS))),
					createRuleCall(PR_PrimaryExpCS)));
			PR_PrimaryExpCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_NestedExpCS),
					createRuleCall(PR_IfExpCS),
					createRuleCall(PR_SelfExpCS),
					createRuleCall(PR_PrimitiveLiteralExpCS),
					createRuleCall(PR_TupleLiteralExpCS),
					createRuleCall(PR_MapLiteralExpCS),
					createRuleCall(PR_CollectionLiteralExpCS),
					createRuleCall(PR_LambdaLiteralExpCS),
					createRuleCall(PR_TypeLiteralExpCS),
					createRuleCall(PR_NameExpCS)));
			PR_PrimitiveLiteralExpCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_NumberLiteralExpCS),
					createRuleCall(PR_StringLiteralExpCS),
					createRuleCall(PR_BooleanLiteralExpCS),
					createRuleCall(PR_UnlimitedNaturalLiteralExpCS),
					createRuleCall(PR_InvalidLiteralExpCS),
					createRuleCall(PR_NullLiteralExpCS)));
			PR_PrimitiveTypeCS.setAlternatives(
				createAssignment("name", "=", createRuleCall(PR_PrimitiveTypeIdentifier)));
			PR_PrimitiveTypeIdentifier.setAlternatives(
				createAlternatives(
					createKeyword("Boolean"),
					createKeyword("Integer"),
					createKeyword("Real"),
					createKeyword("String"),
					createKeyword("UnlimitedNatural"),
					createKeyword("OclAny"),
					createKeyword("OclInvalid"),
					createKeyword("OclVoid")));
			PR_RoundBracketedClauseCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS)),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingArgCS)),
						setCardinality("*", createAssignment("ownedArguments", "+=", createAlternatives(
							createRuleCall(PR_NavigatingCommaArgCS),
							createRuleCall(PR_NavigatingSemiArgCS),
							createRuleCall(PR_NavigatingBarArgCS)))))),
					createKeyword(")")));
			PR_SelfExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS)),
					createKeyword("self")));
			PR_ShadowPartCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("referredProperty", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(PR_UnrestrictedName))),
						createKeyword("="),
						createAssignment("ownedInitExpression", "=", createAlternatives(
							createRuleCall(PR_ExpCS),
							createRuleCall(PR_PatternExpCS)))),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_StringLiteralExpCS))));
			PR_SimplePathNameCS.setAlternatives(
				createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_FirstPathElementCS)));
			PR_SquareBracketedClauseCS.setAlternatives(
				createGroup(
					createKeyword("["),
					createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)))),
					createKeyword("]")));
			PR_StringLiteralExpCS.setAlternatives(
				setCardinality("+", createAssignment("segments", "+=", createRuleCall(_Base.PR_StringLiteral))));
			PR_TupleLiteralExpCS.setAlternatives(
				createGroup(
					createKeyword("Tuple"),
					createKeyword("{"),
					createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)))),
					createKeyword("}")));
			PR_TupleLiteralPartCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
					createKeyword("="),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_TuplePartCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS))));
			PR_TupleTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createKeyword("Tuple")),
					setCardinality("?", createGroup(
						createKeyword("("),
						setCardinality("?", createGroup(
							createAssignment("ownedParts", "+=", createRuleCall(_OCLstdlib.PR_TuplePartCS)),
							setCardinality("*", createGroup(
								createKeyword(","),
								createAssignment("ownedParts", "+=", createRuleCall(_OCLstdlib.PR_TuplePartCS)))))),
						createKeyword(")")))));
			PR_TypeExpCS.setAlternatives(
				createGroup(
					createRuleCall(PR_TypeExpWithoutMultiplicityCS),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypeExpWithoutMultiplicityCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_TypeNameExpCS),
					createRuleCall(PR_TypeLiteralCS),
					createRuleCall(PR_CollectionPatternCS)));
			PR_TypeLiteralCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_PrimitiveTypeCS),
					createRuleCall(PR_CollectionTypeCS),
					createRuleCall(PR_MapTypeCS),
					createRuleCall(PR_TupleTypeCS)));
			PR_TypeLiteralExpCS.setAlternatives(
				createAssignment("ownedType", "=", createRuleCall(PR_TypeLiteralWithMultiplicityCS)));
			PR_TypeLiteralWithMultiplicityCS.setAlternatives(
				createGroup(
					createRuleCall(PR_TypeLiteralCS),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypeNameExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)),
					setCardinality("?", createGroup(
						createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS)),
						setCardinality("?", createGroup(
							createKeyword("{"),
							createAssignment("ownedPatternGuard", "=", createRuleCall(PR_ExpCS)),
							createKeyword("}")))))));
			PR_URIFirstPathElementCS.setAlternatives(
				createAlternatives(
					createAssignment("referredElement", "=", createCrossReference(
						createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(PR_UnrestrictedName))),
					createGroup(
						createAction(null, null, createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS)),
						createAssignment("referredElement", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(_Base.PR_URI))))));
			PR_URIPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_URIFirstPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_NextPathElementCS))))));
			PR_UnaryOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnaryOperatorName));
			PR_UnlimitedNaturalLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS)),
					createKeyword("*")));
			PR_UnreservedName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnreservedName));
			addAnnotation(PR_UnreservedName, "Override");
			PR_UnrestrictedName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnrestrictedName));
			addAnnotation(PR_UnrestrictedName, "Override");
		}

		private static @NonNull Grammar initGrammar() {
			initParserRules();
			Grammar grammar = G_EssentialOCL;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_Model);
				rules.add(PR_EssentialOCLReservedKeyword);
				rules.add(PR_EssentialOCLUnaryOperatorName);
				rules.add(PR_EssentialOCLInfixOperatorName);
				rules.add(PR_EssentialOCLNavigationOperatorName);
				rules.add(PR_BinaryOperatorName);
				rules.add(PR_InfixOperatorName);
				rules.add(PR_NavigationOperatorName);
				rules.add(PR_UnaryOperatorName);
				rules.add(PR_EssentialOCLUnrestrictedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_EssentialOCLUnreservedName);
				rules.add(PR_UnreservedName);
				rules.add(PR_URIPathNameCS);
				rules.add(PR_URIFirstPathElementCS);
				rules.add(PR_SimplePathNameCS);
				rules.add(PR_PrimitiveTypeIdentifier);
				rules.add(PR_PrimitiveTypeCS);
				rules.add(PR_CollectionTypeIdentifier);
				rules.add(PR_CollectionTypeCS);
				rules.add(PR_MapTypeCS);
				rules.add(PR_TupleTypeCS);
				rules.add(PR_TuplePartCS);
				rules.add(PR_CollectionLiteralExpCS);
				rules.add(PR_CollectionLiteralPartCS);
				rules.add(PR_CollectionPatternCS);
				rules.add(PR_ShadowPartCS);
				rules.add(PR_PatternExpCS);
				rules.add(PR_LambdaLiteralExpCS);
				rules.add(PR_MapLiteralExpCS);
				rules.add(PR_MapLiteralPartCS);
				rules.add(PR_PrimitiveLiteralExpCS);
				rules.add(PR_TupleLiteralExpCS);
				rules.add(PR_TupleLiteralPartCS);
				rules.add(PR_NumberLiteralExpCS);
				rules.add(PR_StringLiteralExpCS);
				rules.add(PR_BooleanLiteralExpCS);
				rules.add(PR_UnlimitedNaturalLiteralExpCS);
				rules.add(PR_InvalidLiteralExpCS);
				rules.add(PR_NullLiteralExpCS);
				rules.add(PR_TypeLiteralCS);
				rules.add(PR_TypeLiteralWithMultiplicityCS);
				rules.add(PR_TypeLiteralExpCS);
				rules.add(PR_TypeNameExpCS);
				rules.add(PR_TypeExpWithoutMultiplicityCS);
				rules.add(PR_TypeExpCS);
				rules.add(PR_ExpCS);
				rules.add(PR_PrefixedLetExpCS);
				rules.add(PR_PrefixedPrimaryExpCS);
				rules.add(PR_PrimaryExpCS);
				rules.add(PR_NameExpCS);
				rules.add(PR_CurlyBracketedClauseCS);
				rules.add(PR_RoundBracketedClauseCS);
				rules.add(PR_SquareBracketedClauseCS);
				rules.add(PR_NavigatingArgCS);
				rules.add(PR_NavigatingBarArgCS);
				rules.add(PR_NavigatingCommaArgCS);
				rules.add(PR_NavigatingSemiArgCS);
				rules.add(PR_NavigatingArgExpCS);
				rules.add(PR_CoIteratorVariableCS);
				rules.add(PR_IfExpCS);
				rules.add(PR_ElseIfThenExpCS);
				rules.add(PR_LetExpCS);
				rules.add(PR_LetVariableCS);
				rules.add(PR_NestedExpCS);
				rules.add(PR_SelfExpCS);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_Base);
			}
			return grammar;
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
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_EssentialOCL.PR_UnrestrictedName))));
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
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_EssentialOCL.PR_UnreservedName))));
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
					createAssignment("name", "=", createRuleCall(_EssentialOCL.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "+=", createRuleCall(_OCLstdlib.PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword("&&"),
							createAssignment("ownedExtends", "+=", createRuleCall(_OCLstdlib.PR_TypedRefCS))))))));
			PR_TypeRefCS.setAlternatives(
				createAlternatives(
					createRuleCall(_OCLstdlib.PR_TypedRefCS),
					createRuleCall(PR_WildcardTypeRefCS)));
			PR_TypedRefCS.setAlternatives(
				createRuleCall(_OCLstdlib.PR_TypedTypeRefCS));
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
				createRuleCall(_EssentialOCL.PR_UnrestrictedName));
			PR_UnreservedPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_UnrestrictedName.setAlternatives(
				createRuleCall(_OCLstdlib.PR_Identifier));
			PR_WildcardTypeRefCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS)),
					createKeyword("?"),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "=", createRuleCall(_OCLstdlib.PR_TypedRefCS))))));
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
