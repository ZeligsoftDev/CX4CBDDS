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
package org.eclipse.ocl.xtext.oclstdlib.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.basecs.AnnotationCS;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.DetailCS;
import org.eclipse.ocl.xtext.basecs.DocumentationCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LambdaTypeCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.serializer.EssentialOCLSemanticSequencer;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.MapTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.ShadowPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.ocl.xtext.oclstdlib.services.OCLstdlibGrammarAccess;
import org.eclipse.ocl.xtext.oclstdlibcs.LibClassCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibCoercionCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibConstraintCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibIterationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOperationCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibOppositeCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibPropertyCS;
import org.eclipse.ocl.xtext.oclstdlibcs.LibRootPackageCS;
import org.eclipse.ocl.xtext.oclstdlibcs.OCLstdlibCSPackage;
import org.eclipse.ocl.xtext.oclstdlibcs.PrecedenceCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractOCLstdlibSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private OCLstdlibGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.ANNOTATION_CS:
				sequence_AnnotationCS(context, (AnnotationCS) semanticObject);
				return;
			case BaseCSPackage.DETAIL_CS:
				sequence_DetailCS(context, (DetailCS) semanticObject);
				return;
			case BaseCSPackage.DOCUMENTATION_CS:
				sequence_DocumentationCS(context, (DocumentationCS) semanticObject);
				return;
			case BaseCSPackage.IMPORT_CS:
				sequence_ImportCS(context, (ImportCS) semanticObject);
				return;
			case BaseCSPackage.LAMBDA_TYPE_CS:
				if (rule == grammarAccess.getLambdaTypeCSRule()
						|| rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_LambdaTypeCS(context, (LambdaTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_LambdaTypeCS_TypedMultiplicityRefCS(context, (LambdaTypeCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if (rule == grammarAccess.getMultiplicityBoundsCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS_MultiplicityCS(context, (MultiplicityBoundsCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if (rule == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityCS_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.PACKAGE_CS:
				sequence_PackageCS(context, (PackageCS) semanticObject);
				return;
			case BaseCSPackage.PARAMETER_CS:
				if (rule == grammarAccess.getAccumulatorCSRule()) {
					sequence_AccumulatorCS(context, (ParameterCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getIteratorCSRule()) {
					sequence_IteratorCS(context, (ParameterCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getParameterCSRule()) {
					sequence_ParameterCS(context, (ParameterCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_CS:
				if (rule == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getLibPathElementCSRule()) {
					sequence_LibPathElementCS(context, (PathElementCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject);
				return;
			case BaseCSPackage.PATH_NAME_CS:
				if (rule == grammarAccess.getLibPathNameCSRule()) {
					sequence_LibPathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getSimplePathNameCSRule()) {
					sequence_SimplePathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getUnreservedPathNameCSRule()) {
					sequence_UnreservedPathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if (rule == grammarAccess.getPrimitiveTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeRefCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				sequence_TemplateBindingCS(context, (TemplateBindingCS) semanticObject);
				return;
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				sequence_TemplateParameterSubstitutionCS(context, (TemplateParameterSubstitutionCS) semanticObject);
				return;
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				sequence_TemplateSignatureCS(context, (TemplateSignatureCS) semanticObject);
				return;
			case BaseCSPackage.TUPLE_PART_CS:
				sequence_TuplePartCS(context, (TuplePartCS) semanticObject);
				return;
			case BaseCSPackage.TUPLE_TYPE_CS:
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTupleTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TupleTypeCS_TypedMultiplicityRefCS(context, (TupleTypeCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				if (rule == grammarAccess.getLambdaContextTypeRefCSRule()) {
					sequence_LambdaContextTypeRefCS(context, (TypedTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_TypedMultiplicityRefCS_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getTypedTypeRefCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject);
					return;
				}
				else break;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject);
				return;
			}
		else if (epackage == EssentialOCLCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
				sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
				sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
				sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject);
				return;
			case EssentialOCLCSPackage.COLLECTION_PATTERN_CS:
				if (rule == grammarAccess.getCollectionPatternCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_CollectionPatternCS(context, (CollectionPatternCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionPatternCS_TypeExpCS(context, (CollectionPatternCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if (rule == grammarAccess.getCollectionTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				sequence_Model(context, (ContextCS) semanticObject);
				return;
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS:
				sequence_CurlyBracketedClauseCS(context, (CurlyBracketedClauseCS) semanticObject);
				return;
			case EssentialOCLCSPackage.EXP_SPECIFICATION_CS:
				sequence_SpecificationCS(context, (ExpSpecificationCS) semanticObject);
				return;
			case EssentialOCLCSPackage.IF_EXP_CS:
				sequence_IfExpCS(context, (IfExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.IF_THEN_EXP_CS:
				sequence_ElseIfThenExpCS(context, (IfThenExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.INFIX_EXP_CS:
				sequence_ExpCS(context, (InfixExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.LAMBDA_LITERAL_EXP_CS:
				sequence_LambdaLiteralExpCS(context, (LambdaLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.LET_EXP_CS:
				sequence_LetExpCS(context, (LetExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
				sequence_LetVariableCS(context, (LetVariableCS) semanticObject);
				return;
			case EssentialOCLCSPackage.MAP_LITERAL_EXP_CS:
				sequence_MapLiteralExpCS(context, (MapLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.MAP_LITERAL_PART_CS:
				sequence_MapLiteralPartCS(context, (MapLiteralPartCS) semanticObject);
				return;
			case EssentialOCLCSPackage.MAP_TYPE_CS:
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getMapTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
					sequence_MapTypeCS(context, (MapTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_MapTypeCS_TypeExpCS(context, (MapTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(context, (MapTypeCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypedMultiplicityRefCSRule()) {
					sequence_MapTypeCS_TypedMultiplicityRefCS(context, (MapTypeCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				sequence_NameExpCS(context, (NameExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if (rule == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.NESTED_EXP_CS:
				sequence_NestedExpCS(context, (NestedExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
				sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
				sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.PATTERN_EXP_CS:
				sequence_PatternExpCS(context, (PatternExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
				if (rule == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_PrefixedLetExpCS(context, (PrefixExpCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getExpCSRule()
						|| rule == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject);
					return;
				}
				else if (action == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0()
						|| rule == grammarAccess.getPrefixedPrimaryExpCSRule()) {
					sequence_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS:
				sequence_RoundBracketedClauseCS(context, (RoundBracketedClauseCS) semanticObject);
				return;
			case EssentialOCLCSPackage.SELF_EXP_CS:
				sequence_SelfExpCS(context, (SelfExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.SHADOW_PART_CS:
				sequence_ShadowPartCS(context, (ShadowPartCS) semanticObject);
				return;
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS:
				sequence_SquareBracketedClauseCS(context, (SquareBracketedClauseCS) semanticObject);
				return;
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
				sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
				sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
				sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject);
				return;
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
				sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
				if (rule == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getTypeNameExpCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject);
					return;
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject);
				return;
			case EssentialOCLCSPackage.VARIABLE_CS:
				sequence_CoIteratorVariableCS(context, (VariableCS) semanticObject);
				return;
			}
		else if (epackage == OCLstdlibCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case OCLstdlibCSPackage.LIB_CLASS_CS:
				sequence_LibClassCS(context, (LibClassCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_COERCION_CS:
				sequence_LibCoercionCS(context, (LibCoercionCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_CONSTRAINT_CS:
				if (rule == grammarAccess.getInvCSRule()) {
					sequence_InvCS(context, (LibConstraintCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getPostCSRule()) {
					sequence_PostCS(context, (LibConstraintCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getPreCSRule()) {
					sequence_PreCS(context, (LibConstraintCS) semanticObject);
					return;
				}
				else break;
			case OCLstdlibCSPackage.LIB_ITERATION_CS:
				sequence_LibIterationCS(context, (LibIterationCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_OPERATION_CS:
				sequence_LibOperationCS(context, (LibOperationCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_OPPOSITE_CS:
				sequence_LibOppositeCS(context, (LibOppositeCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_PACKAGE_CS:
				sequence_LibPackageCS(context, (LibPackageCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_PROPERTY_CS:
				sequence_LibPropertyCS(context, (LibPropertyCS) semanticObject);
				return;
			case OCLstdlibCSPackage.LIB_ROOT_PACKAGE_CS:
				sequence_Library(context, (LibRootPackageCS) semanticObject);
				return;
			case OCLstdlibCSPackage.PRECEDENCE_CS:
				sequence_PrecedenceCS(context, (PrecedenceCS) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * <pre>
	 * Contexts:
	 *     AccumulatorCS returns ParameterCS
	 *
	 * Constraint:
	 *     (name=Identifier ownedType=TypedMultiplicityRefCS)
	 * </pre>
	 */
	protected void sequence_AccumulatorCS(ISerializationContext context, ParameterCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAccumulatorCSAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAccumulatorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     AnnotationCS returns AnnotationCS
	 *     AnnotationElementCS returns AnnotationCS
	 *
	 * Constraint:
	 *     ((name=Identifier | name=SINGLE_QUOTED_STRING) (ownedDetails+=DetailCS ownedDetails+=DetailCS*)? ownedAnnotations+=AnnotationElementCS?)
	 * </pre>
	 */
	protected void sequence_AnnotationCS(ISerializationContext context, AnnotationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     DetailCS returns DetailCS
	 *
	 * Constraint:
	 *     ((name=Name | name=SINGLE_QUOTED_STRING) values+=SINGLE_QUOTED_STRING? (values+=ML_SINGLE_QUOTED_STRING? values+=SINGLE_QUOTED_STRING?)*)
	 * </pre>
	 */
	protected void sequence_DetailCS(ISerializationContext context, DetailCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     AnnotationElementCS returns DocumentationCS
	 *     DocumentationCS returns DocumentationCS
	 *
	 * Constraint:
	 *     (value=SINGLE_QUOTED_STRING? (ownedDetails+=DetailCS ownedDetails+=DetailCS*)?)
	 * </pre>
	 */
	protected void sequence_DocumentationCS(ISerializationContext context, DocumentationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ImportCS returns ImportCS
	 *
	 * Constraint:
	 *     (name=Identifier? ownedPathName=URIPathNameCS isAll?='::*'?)
	 * </pre>
	 */
	protected void sequence_ImportCS(ISerializationContext context, ImportCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     InvCS returns LibConstraintCS
	 *
	 * Constraint:
	 *     (stereotype='inv' (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS)
	 * </pre>
	 */
	protected void sequence_InvCS(ISerializationContext context, LibConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     IteratorCS returns ParameterCS
	 *
	 * Constraint:
	 *     (name=Identifier ownedType=TypedMultiplicityRefCS)
	 * </pre>
	 */
	protected void sequence_IteratorCS(ISerializationContext context, ParameterCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIteratorCSAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getIteratorCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LambdaContextTypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     ownedPathName=LibPathNameCS
	 * </pre>
	 */
	protected void sequence_LambdaContextTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_TYPE_REF_CS__OWNED_PATH_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLambdaContextTypeRefCSAccess().getOwnedPathNameLibPathNameCSParserRuleCall_0(), semanticObject.getOwnedPathName());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LambdaTypeCS returns LambdaTypeCS
	 *     TypedRefCS returns LambdaTypeCS
	 *     TypeRefCS returns LambdaTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name='Lambda'
	 *         ownedSignature=TemplateSignatureCS?
	 *         ownedContextType=LambdaContextTypeRefCS
	 *         (ownedParameterTypes+=TypedMultiplicityRefCS ownedParameterTypes+=TypedMultiplicityRefCS*)?
	 *         ownedResultType=TypedRefCS
	 *     )
	 * </pre>
	 */
	protected void sequence_LambdaTypeCS(ISerializationContext context, LambdaTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypedMultiplicityRefCS returns LambdaTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name='Lambda'
	 *         ownedSignature=TemplateSignatureCS?
	 *         ownedContextType=LambdaContextTypeRefCS
	 *         (ownedParameterTypes+=TypedMultiplicityRefCS ownedParameterTypes+=TypedMultiplicityRefCS*)?
	 *         ownedResultType=TypedRefCS
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 * </pre>
	 */
	protected void sequence_LambdaTypeCS_TypedMultiplicityRefCS(ISerializationContext context, LambdaTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibClassCS returns LibClassCS
	 *     ClassCS returns LibClassCS
	 *
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'?
	 *         name=AnyName
	 *         ownedSignature=TemplateSignatureCS?
	 *         metaclassName=[MetaclassNameCS|AnyName]?
	 *         (ownedSuperTypes+=TypedRefCS ownedSuperTypes+=TypedRefCS*)?
	 *         implementation=[JavaClassCS|SINGLE_QUOTED_STRING]?
	 *         (ownedOperations+=OperationCS | ownedProperties+=LibPropertyCS | ownedConstraints+=InvCS | ownedAnnotations+=AnnotationElementCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibClassCS(ISerializationContext context, LibClassCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibCoercionCS returns LibCoercionCS
	 *     OperationCS returns LibCoercionCS
	 *
	 * Constraint:
	 *     (
	 *         name=Name
	 *         ownedType=TypedMultiplicityRefCS
	 *         implementation=[JavaClassCS|SINGLE_QUOTED_STRING]?
	 *         (ownedAnnotations+=AnnotationElementCS | ownedPreconditions+=PostCS | ownedPostconditions+=PreCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibCoercionCS(ISerializationContext context, LibCoercionCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibIterationCS returns LibIterationCS
	 *     OperationCS returns LibIterationCS
	 *
	 * Constraint:
	 *     (
	 *         name=Name
	 *         ownedSignature=TemplateSignatureCS?
	 *         ownedIterators+=IteratorCS
	 *         ownedIterators+=IteratorCS*
	 *         (ownedAccumulators+=AccumulatorCS ownedAccumulators+=AccumulatorCS*)?
	 *         (ownedParameters+=ParameterCS ownedParameters+=ParameterCS*)?
	 *         ownedType=TypedMultiplicityRefCS
	 *         isInvalidating?='invalidating'?
	 *         isValidating?='validating'?
	 *         implementation=[JavaClassCS|SINGLE_QUOTED_STRING]?
	 *         (ownedAnnotations+=AnnotationElementCS | ownedPreconditions+=PostCS | ownedPostconditions+=PreCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibIterationCS(ISerializationContext context, LibIterationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     OperationCS returns LibOperationCS
	 *     LibOperationCS returns LibOperationCS
	 *
	 * Constraint:
	 *     (
	 *         isStatic?='static'?
	 *         name=Name
	 *         ownedSignature=TemplateSignatureCS?
	 *         (ownedParameters+=ParameterCS ownedParameters+=ParameterCS*)?
	 *         ownedType=TypedMultiplicityRefCS
	 *         isValidating?='validating'?
	 *         isInvalidating?='invalidating'?
	 *         precedence=[Precedence|Name]?
	 *         implementation=[JavaClassCS|SINGLE_QUOTED_STRING]?
	 *         (ownedAnnotations+=AnnotationElementCS | ownedBodyExpressions+=SpecificationCS | ownedPostconditions+=PostCS | ownedPreconditions+=PreCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibOperationCS(ISerializationContext context, LibOperationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibOppositeCS returns LibOppositeCS
	 *
	 * Constraint:
	 *     (name=Name ownedType=TypedMultiplicityRefCS)
	 * </pre>
	 */
	protected void sequence_LibOppositeCS(ISerializationContext context, LibOppositeCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLibOppositeCSAccess().getNameNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLibOppositeCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_3_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibPackageCS returns LibPackageCS
	 *
	 * Constraint:
	 *     (
	 *         name=Name
	 *         (nsPrefix=Identifier nsURI=URI)?
	 *         (ownedPackages+=PackageCS | ownedPrecedences+=PrecedenceCS | ownedClasses+=ClassCS | ownedAnnotations+=AnnotationElementCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibPackageCS(ISerializationContext context, LibPackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|Name]
	 * </pre>
	 */
	protected void sequence_LibPathElementCS(ISerializationContext context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLibPathElementCSAccess().getReferredElementNamedElementNameParserRuleCall_0_1(), semanticObject.eGet(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibPathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=LibPathElementCS ownedPathElements+=LibPathElementCS*)
	 * </pre>
	 */
	protected void sequence_LibPathNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LibPropertyCS returns LibPropertyCS
	 *
	 * Constraint:
	 *     (
	 *         isStatic?='static'?
	 *         name=Name
	 *         ownedType=TypedMultiplicityRefCS
	 *         ownedOpposite=LibOppositeCS?
	 *         implementation=[JavaClassCS|SINGLE_QUOTED_STRING]?
	 *         ownedAnnotations+=AnnotationElementCS*
	 *     )
	 * </pre>
	 */
	protected void sequence_LibPropertyCS(ISerializationContext context, LibPropertyCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     Library returns LibRootPackageCS
	 *
	 * Constraint:
	 *     ((ownedImports+=ImportCS+ ownedPackages+=LibPackageCS+) | ownedPackages+=LibPackageCS+)?
	 * </pre>
	 */
	protected void sequence_Library(ISerializationContext context, LibRootPackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypedMultiplicityRefCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_MapTypeCS_TypedMultiplicityRefCS(ISerializationContext context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PackageCS returns PackageCS
	 *
	 * Constraint:
	 *     (name=Name (nsPrefix=Identifier nsURI=URI)? (ownedPackages+=PackageCS | ownedClasses+=ClassCS | ownedAnnotations+=AnnotationElementCS)*)
	 * </pre>
	 */
	protected void sequence_PackageCS(ISerializationContext context, PackageCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ParameterCS returns ParameterCS
	 *
	 * Constraint:
	 *     (name=Identifier ownedType=TypedMultiplicityRefCS)
	 * </pre>
	 */
	protected void sequence_ParameterCS(ISerializationContext context, ParameterCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParameterCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PostCS returns LibConstraintCS
	 *
	 * Constraint:
	 *     (stereotype='post' (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS)
	 * </pre>
	 */
	protected void sequence_PostCS(ISerializationContext context, LibConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PreCS returns LibConstraintCS
	 *
	 * Constraint:
	 *     (stereotype='pre' (name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS)
	 * </pre>
	 */
	protected void sequence_PreCS(ISerializationContext context, LibConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrecedenceCS returns PrecedenceCS
	 *
	 * Constraint:
	 *     (isRightAssociative?='right'? name=Name)
	 * </pre>
	 */
	protected void sequence_PrecedenceCS(ISerializationContext context, PrecedenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     SpecificationCS returns ExpSpecificationCS
	 *
	 * Constraint:
	 *     ownedExpression=ExpCS
	 * </pre>
	 */
	protected void sequence_SpecificationCS(ISerializationContext context, ExpSpecificationCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSpecificationCSAccess().getOwnedExpressionExpCSParserRuleCall_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TuplePartCS returns TuplePartCS
	 *
	 * Constraint:
	 *     (name=Identifier ownedType=TypedMultiplicityRefCS)
	 * </pre>
	 */
	protected void sequence_TuplePartCS(ISerializationContext context, TuplePartCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTuplePartCSAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypedMultiplicityRefCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypedMultiplicityRefCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_TupleTypeCS_TypedMultiplicityRefCS(ISerializationContext context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypedMultiplicityRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (
	 *         ((isTypeof?='typeof' ownedPathName=LibPathNameCS) | (ownedPathName=LibPathNameCS ownedBinding=TemplateBindingCS?))
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 * </pre>
	 */
	protected void sequence_TypedMultiplicityRefCS_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypedRefCS returns TypedTypeRefCS
	 *     TypedTypeRefCS returns TypedTypeRefCS
	 *     TypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     ((isTypeof?='typeof' ownedPathName=LibPathNameCS) | (ownedPathName=LibPathNameCS ownedBinding=TemplateBindingCS?))
	 * </pre>
	 */
	protected void sequence_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
