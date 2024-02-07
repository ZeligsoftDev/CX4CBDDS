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
package org.eclipse.ocl.xtext.completeocl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
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
import org.eclipse.ocl.xtext.completeocl.services.CompleteOCLGrammarAccess;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLCSPackage;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.DefOperationCS;
import org.eclipse.ocl.xtext.completeoclcs.DefPropertyCS;
import org.eclipse.ocl.xtext.completeoclcs.OCLMessageArgCS;
import org.eclipse.ocl.xtext.completeoclcs.OperationContextDeclCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.xtext.completeoclcs.PropertyContextDeclCS;
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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractCompleteOCLSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private CompleteOCLGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.CONSTRAINT_CS:
				sequence_ConstraintCS(context, (ConstraintCS) semanticObject);
				return;
			case BaseCSPackage.IMPORT_CS:
				sequence_ImportCS(context, (ImportCS) semanticObject);
				return;
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
			case BaseCSPackage.PARAMETER_CS:
				if (rule == grammarAccess.getDefParameterCSRule()) {
					sequence_DefParameterCS(context, (ParameterCS) semanticObject);
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
				if (rule == grammarAccess.getPathNameCSRule()) {
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
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getPrimitiveTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject);
				return;
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject);
				return;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject);
				return;
			}
		else if (epackage == CompleteOCLCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CompleteOCLCSPackage.CLASSIFIER_CONTEXT_DECL_CS:
				sequence_ClassifierContextDeclCS(context, (ClassifierContextDeclCS) semanticObject);
				return;
			case CompleteOCLCSPackage.COMPLETE_OCL_DOCUMENT_CS:
				sequence_CompleteOCLDocumentCS(context, (CompleteOCLDocumentCS) semanticObject);
				return;
			case CompleteOCLCSPackage.DEF_OPERATION_CS:
				sequence_DefOperationCS(context, (DefOperationCS) semanticObject);
				return;
			case CompleteOCLCSPackage.DEF_PROPERTY_CS:
				sequence_DefPropertyCS(context, (DefPropertyCS) semanticObject);
				return;
			case CompleteOCLCSPackage.OCL_MESSAGE_ARG_CS:
				sequence_NavigatingArgExpCS(context, (OCLMessageArgCS) semanticObject);
				return;
			case CompleteOCLCSPackage.OPERATION_CONTEXT_DECL_CS:
				sequence_OperationContextDeclCS(context, (OperationContextDeclCS) semanticObject);
				return;
			case CompleteOCLCSPackage.PACKAGE_DECLARATION_CS:
				sequence_PackageDeclarationCS(context, (PackageDeclarationCS) semanticObject);
				return;
			case CompleteOCLCSPackage.PROPERTY_CONTEXT_DECL_CS:
				sequence_PropertyContextDeclCS(context, (PropertyContextDeclCS) semanticObject);
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
				if (rule == grammarAccess.getTypedRefCSRule()
						|| rule == grammarAccess.getCollectionTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()
						|| rule == grammarAccess.getTypeRefCSRule()) {
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
				else if (rule == grammarAccess.getNavigatingArgExpCSRule()
						|| rule == grammarAccess.getExpCSRule()) {
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * <pre>
	 * Contexts:
	 *     ClassifierContextDeclCS returns ClassifierContextDeclCS
	 *     ContextDeclCS returns ClassifierContextDeclCS
	 *
	 * Constraint:
	 *     (
	 *         ownedSignature=TemplateSignatureCS?
	 *         selfName=UnrestrictedName?
	 *         ownedPathName=UnreservedPathNameCS
	 *         (ownedInvariants+=ConstraintCS | ownedDefinitions+=DefCS)+
	 *     )
	 * </pre>
	 */
	protected void sequence_ClassifierContextDeclCS(ISerializationContext context, ClassifierContextDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CompleteOCLDocumentCS returns CompleteOCLDocumentCS
	 *
	 * Constraint:
	 *     (ownedImports+=ImportCS+ | (ownedImports+=ImportCS+ (ownedPackages+=PackageDeclarationCS | ownedContexts+=ContextDeclCS)+))?
	 * </pre>
	 */
	protected void sequence_CompleteOCLDocumentCS(ISerializationContext context, CompleteOCLDocumentCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ConstraintCS returns ConstraintCS
	 *
	 * Constraint:
	 *     ((name=UnrestrictedName ownedMessageSpecification=SpecificationCS?)? ownedSpecification=SpecificationCS)
	 * </pre>
	 */
	protected void sequence_ConstraintCS(ISerializationContext context, ConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     DefCS returns DefOperationCS
	 *     DefOperationCS returns DefOperationCS
	 *
	 * Constraint:
	 *     (
	 *         isStatic?='static'?
	 *         ownedSignature=TemplateSignatureCS?
	 *         name=UnrestrictedName
	 *         (ownedParameters+=DefParameterCS ownedParameters+=DefParameterCS*)?
	 *         ownedType=TypeExpCS?
	 *         ownedSpecification=SpecificationCS
	 *     )
	 * </pre>
	 */
	protected void sequence_DefOperationCS(ISerializationContext context, DefOperationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     DefParameterCS returns ParameterCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 * </pre>
	 */
	protected void sequence_DefParameterCS(ISerializationContext context, ParameterCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TYPED_ELEMENT_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDefParameterCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     DefCS returns DefPropertyCS
	 *     DefPropertyCS returns DefPropertyCS
	 *
	 * Constraint:
	 *     (isStatic?='static'? name=UnrestrictedName ownedType=TypeExpCS ownedSpecification=SpecificationCS)
	 * </pre>
	 */
	protected void sequence_DefPropertyCS(ISerializationContext context, DefPropertyCS semanticObject) {
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
	 *     NavigatingArgExpCS returns OCLMessageArgCS
	 *
	 * Constraint:
	 *     {OCLMessageArgCS}
	 * </pre>
	 */
	protected void sequence_NavigatingArgExpCS(ISerializationContext context, OCLMessageArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ContextDeclCS returns OperationContextDeclCS
	 *     OperationContextDeclCS returns OperationContextDeclCS
	 *
	 * Constraint:
	 *     (
	 *         ownedSignature=TemplateSignatureCS?
	 *         ownedPathName=UnreservedPathNameCS
	 *         (ownedParameters+=ParameterCS ownedParameters+=ParameterCS*)?
	 *         ownedType=TypeExpCS?
	 *         (ownedPreconditions+=ConstraintCS | ownedPostconditions+=ConstraintCS | ownedBodies+=SpecificationCS)*
	 *     )
	 * </pre>
	 */
	protected void sequence_OperationContextDeclCS(ISerializationContext context, OperationContextDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PackageDeclarationCS returns PackageDeclarationCS
	 *
	 * Constraint:
	 *     (ownedPathName=UnreservedPathNameCS ownedInvariants+=ConstraintCS* ownedContexts+=ContextDeclCS*)
	 * </pre>
	 */
	protected void sequence_PackageDeclarationCS(ISerializationContext context, PackageDeclarationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ParameterCS returns ParameterCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName? ownedType=TypeExpCS)
	 * </pre>
	 */
	protected void sequence_ParameterCS(ISerializationContext context, ParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ContextDeclCS returns PropertyContextDeclCS
	 *     PropertyContextDeclCS returns PropertyContextDeclCS
	 *
	 * Constraint:
	 *     (ownedPathName=UnreservedPathNameCS ownedType=TypeExpCS (ownedDefaultExpressions+=SpecificationCS | ownedDefaultExpressions+=SpecificationCS)*)
	 * </pre>
	 */
	protected void sequence_PropertyContextDeclCS(ISerializationContext context, PropertyContextDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     SpecificationCS returns ExpSpecificationCS
	 *
	 * Constraint:
	 *     (ownedExpression=ExpCS | exprString=UNQUOTED_STRING)
	 * </pre>
	 */
	protected void sequence_SpecificationCS(ISerializationContext context, ExpSpecificationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TemplateSignatureCS returns TemplateSignatureCS
	 *
	 * Constraint:
	 *     ((ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*) | (ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*))
	 * </pre>
	 */
	protected void sequence_TemplateSignatureCS(ISerializationContext context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
