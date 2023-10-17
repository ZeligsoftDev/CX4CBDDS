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
package org.eclipse.ocl.xtext.essentialocl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.base.serializer.BaseSemanticSequencer;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
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
import org.eclipse.ocl.xtext.essentialocl.services.EssentialOCLGrammarAccess;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
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
public abstract class AbstractEssentialOCLSemanticSequencer extends BaseSemanticSequencer {

	@Inject
	private EssentialOCLGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BaseCSPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
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
				if (rule == grammarAccess.getTupleTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
				if (rule == grammarAccess.getMapTypeCSRule()
						|| rule == grammarAccess.getTypeLiteralCSRule()
						|| rule == grammarAccess.getTypeExpWithoutMultiplicityCSRule()) {
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns BooleanLiteralExpCS
	 *     BooleanLiteralExpCS returns BooleanLiteralExpCS
	 *     ExpCS returns BooleanLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns BooleanLiteralExpCS
	 *     PrefixedPrimaryExpCS returns BooleanLiteralExpCS
	 *     PrimaryExpCS returns BooleanLiteralExpCS
	 *     NavigatingArgExpCS returns BooleanLiteralExpCS
	 *
	 * Constraint:
	 *     (symbol='true' | symbol='false')
	 * </pre>
	 */
	protected void sequence_BooleanLiteralExpCS(ISerializationContext context, BooleanLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CoIteratorVariableCS returns VariableCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS?)
	 * </pre>
	 */
	protected void sequence_CoIteratorVariableCS(ISerializationContext context, VariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CollectionLiteralExpCS returns CollectionLiteralExpCS
	 *     ExpCS returns CollectionLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns CollectionLiteralExpCS
	 *     PrefixedPrimaryExpCS returns CollectionLiteralExpCS
	 *     PrimaryExpCS returns CollectionLiteralExpCS
	 *     NavigatingArgExpCS returns CollectionLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=CollectionLiteralPartCS ownedParts+=CollectionLiteralPartCS*)?)
	 * </pre>
	 */
	protected void sequence_CollectionLiteralExpCS(ISerializationContext context, CollectionLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CollectionLiteralPartCS returns CollectionLiteralPartCS
	 *
	 * Constraint:
	 *     ((ownedExpression=ExpCS ownedLastExpression=ExpCS?) | ownedExpression=PatternExpCS)
	 * </pre>
	 */
	protected void sequence_CollectionLiteralPartCS(ISerializationContext context, CollectionLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CollectionPatternCS returns CollectionPatternCS
	 *     TypeExpWithoutMultiplicityCS returns CollectionPatternCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)?)
	 * </pre>
	 */
	protected void sequence_CollectionPatternCS(ISerializationContext context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns CollectionPatternCS
	 *
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=PatternExpCS ownedParts+=PatternExpCS* restVariableName=Identifier)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_CollectionPatternCS_TypeExpCS(ISerializationContext context, CollectionPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CollectionTypeCS returns CollectionTypeCS
	 *     TypeLiteralCS returns CollectionTypeCS
	 *     TypeExpWithoutMultiplicityCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (name=CollectionTypeIdentifier (ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?)?)
	 * </pre>
	 */
	protected void sequence_CollectionTypeCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name=CollectionTypeIdentifier
	 *         (ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?)?
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 * </pre>
	 */
	protected void sequence_CollectionTypeCS_TypeExpCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns CollectionTypeCS
	 *
	 * Constraint:
	 *     (
	 *         name=CollectionTypeIdentifier
	 *         (ownedType=TypeExpWithoutMultiplicityCS ownedCollectionMultiplicity=MultiplicityCS?)?
	 *         ownedMultiplicity=MultiplicityCS?
	 *     )
	 * </pre>
	 */
	protected void sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(ISerializationContext context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     CurlyBracketedClauseCS returns CurlyBracketedClauseCS
	 *
	 * Constraint:
	 *     (ownedParts+=ShadowPartCS ownedParts+=ShadowPartCS*)?
	 * </pre>
	 */
	protected void sequence_CurlyBracketedClauseCS(ISerializationContext context, CurlyBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ElseIfThenExpCS returns IfThenExpCS
	 *
	 * Constraint:
	 *     (ownedCondition=ExpCS ownedThenExpression=ExpCS)
	 * </pre>
	 */
	protected void sequence_ElseIfThenExpCS(ISerializationContext context, IfThenExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_CONDITION));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS__OWNED_THEN_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0(), semanticObject.getOwnedCondition());
		feeder.accept(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0(), semanticObject.getOwnedThenExpression());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns InfixExpCS
	 *     NavigatingArgExpCS returns InfixExpCS
	 *
	 * Constraint:
	 *     (ownedLeft=ExpCS_InfixExpCS_0_1_0 name=BinaryOperatorName ownedRight=ExpCS)
	 * </pre>
	 */
	protected void sequence_ExpCS(ISerializationContext context, InfixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.INFIX_EXP_CS__OWNED_LEFT));
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(), semanticObject.getOwnedLeft());
		feeder.accept(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns IfExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns IfExpCS
	 *     PrefixedPrimaryExpCS returns IfExpCS
	 *     PrimaryExpCS returns IfExpCS
	 *     NavigatingArgExpCS returns IfExpCS
	 *     IfExpCS returns IfExpCS
	 *
	 * Constraint:
	 *     (
	 *         (ownedCondition=ExpCS | ownedCondition=PatternExpCS)
	 *         ownedThenExpression=ExpCS
	 *         ownedIfThenExpressions+=ElseIfThenExpCS*
	 *         ownedElseExpression=ExpCS
	 *     )
	 * </pre>
	 */
	protected void sequence_IfExpCS(ISerializationContext context, IfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns InvalidLiteralExpCS
	 *     InvalidLiteralExpCS returns InvalidLiteralExpCS
	 *     ExpCS returns InvalidLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns InvalidLiteralExpCS
	 *     PrefixedPrimaryExpCS returns InvalidLiteralExpCS
	 *     PrimaryExpCS returns InvalidLiteralExpCS
	 *     NavigatingArgExpCS returns InvalidLiteralExpCS
	 *
	 * Constraint:
	 *     {InvalidLiteralExpCS}
	 * </pre>
	 */
	protected void sequence_InvalidLiteralExpCS(ISerializationContext context, InvalidLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LambdaLiteralExpCS returns LambdaLiteralExpCS
	 *     ExpCS returns LambdaLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns LambdaLiteralExpCS
	 *     PrefixedPrimaryExpCS returns LambdaLiteralExpCS
	 *     PrimaryExpCS returns LambdaLiteralExpCS
	 *     NavigatingArgExpCS returns LambdaLiteralExpCS
	 *
	 * Constraint:
	 *     ownedExpressionCS=ExpCS
	 * </pre>
	 */
	protected void sequence_LambdaLiteralExpCS(ISerializationContext context, LambdaLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS__OWNED_EXPRESSION_CS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0(), semanticObject.getOwnedExpressionCS());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns LetExpCS
	 *     PrefixedLetExpCS returns LetExpCS
	 *     NavigatingArgExpCS returns LetExpCS
	 *     LetExpCS returns LetExpCS
	 *
	 * Constraint:
	 *     (ownedVariables+=LetVariableCS ownedVariables+=LetVariableCS* ownedInExpression=ExpCS)
	 * </pre>
	 */
	protected void sequence_LetExpCS(ISerializationContext context, LetExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     LetVariableCS returns LetVariableCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedRoundBracketedClause=RoundBracketedClauseCS? ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 * </pre>
	 */
	protected void sequence_LetVariableCS(ISerializationContext context, LetVariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MapLiteralExpCS returns MapLiteralExpCS
	 *     ExpCS returns MapLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns MapLiteralExpCS
	 *     PrefixedPrimaryExpCS returns MapLiteralExpCS
	 *     PrimaryExpCS returns MapLiteralExpCS
	 *     NavigatingArgExpCS returns MapLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedType=MapTypeCS (ownedParts+=MapLiteralPartCS ownedParts+=MapLiteralPartCS*)?)
	 * </pre>
	 */
	protected void sequence_MapLiteralExpCS(ISerializationContext context, MapLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MapLiteralPartCS returns MapLiteralPartCS
	 *
	 * Constraint:
	 *     (ownedKey=ExpCS ownedValue=ExpCS)
	 * </pre>
	 */
	protected void sequence_MapLiteralPartCS(ISerializationContext context, MapLiteralPartCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_KEY));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS__OWNED_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0(), semanticObject.getOwnedKey());
		feeder.accept(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0(), semanticObject.getOwnedValue());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MapTypeCS returns MapTypeCS
	 *     TypeLiteralCS returns MapTypeCS
	 *     TypeExpWithoutMultiplicityCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)?)
	 * </pre>
	 */
	protected void sequence_MapTypeCS(ISerializationContext context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_MapTypeCS_TypeExpCS(ISerializationContext context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns MapTypeCS
	 *
	 * Constraint:
	 *     (name='Map' (ownedKeyType=TypeExpCS ownedValueType=TypeExpCS)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_MapTypeCS_TypeLiteralWithMultiplicityCS(ISerializationContext context, MapTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     Model returns ContextCS
	 *
	 * Constraint:
	 *     ownedExpression=ExpCS
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, ContextCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.CONTEXT_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getModelAccess().getOwnedExpressionExpCSParserRuleCall_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns NameExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NameExpCS
	 *     PrefixedPrimaryExpCS returns NameExpCS
	 *     PrimaryExpCS returns NameExpCS
	 *     NameExpCS returns NameExpCS
	 *     NavigatingArgExpCS returns NameExpCS
	 *
	 * Constraint:
	 *     (
	 *         ownedPathName=PathNameCS
	 *         ownedSquareBracketedClauses+=SquareBracketedClauseCS*
	 *         ownedRoundBracketedClause=RoundBracketedClauseCS?
	 *         ownedCurlyBracketedClause=CurlyBracketedClauseCS?
	 *         isPre?='@'?
	 *     )
	 * </pre>
	 */
	protected void sequence_NameExpCS(ISerializationContext context, NameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     NavigatingArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             ownedNameExpression=NavigatingArgExpCS
	 *             (
	 *                 (ownedCoIterator=CoIteratorVariableCS ownedInitExpression=ExpCS?) |
	 *                 (ownedType=TypeExpCS ownedCoIterator=CoIteratorVariableCS? ownedInitExpression=ExpCS?) |
	 *                 (ownedType=TypeExpCS? ownedCoIterator=CoIteratorVariableCS? ownedInitExpression=ExpCS)
	 *             )?
	 *         ) |
	 *         ownedType=TypeExpCS
	 *     )
	 * </pre>
	 */
	protected void sequence_NavigatingArgCS(ISerializationContext context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     NavigatingBarArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (prefix='|' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 * </pre>
	 */
	protected void sequence_NavigatingBarArgCS(ISerializationContext context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     NavigatingCommaArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (
	 *         prefix=','
	 *         ownedNameExpression=NavigatingArgExpCS
	 *         (
	 *             (ownedCoIterator=CoIteratorVariableCS ownedInitExpression=ExpCS?) |
	 *             (ownedType=TypeExpCS ownedCoIterator=CoIteratorVariableCS? ownedInitExpression=ExpCS?) |
	 *             (ownedType=TypeExpCS? ownedCoIterator=CoIteratorVariableCS? ownedInitExpression=ExpCS)
	 *         )?
	 *     )
	 * </pre>
	 */
	protected void sequence_NavigatingCommaArgCS(ISerializationContext context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     NavigatingSemiArgCS returns NavigatingArgCS
	 *
	 * Constraint:
	 *     (prefix=';' ownedNameExpression=NavigatingArgExpCS (ownedType=TypeExpCS ownedInitExpression=ExpCS?)?)
	 * </pre>
	 */
	protected void sequence_NavigatingSemiArgCS(ISerializationContext context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns NestedExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NestedExpCS
	 *     PrefixedPrimaryExpCS returns NestedExpCS
	 *     PrimaryExpCS returns NestedExpCS
	 *     NavigatingArgExpCS returns NestedExpCS
	 *     NestedExpCS returns NestedExpCS
	 *
	 * Constraint:
	 *     ownedExpression=ExpCS
	 * </pre>
	 */
	protected void sequence_NestedExpCS(ISerializationContext context, NestedExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.NESTED_EXP_CS__OWNED_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0(), semanticObject.getOwnedExpression());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns NullLiteralExpCS
	 *     NullLiteralExpCS returns NullLiteralExpCS
	 *     ExpCS returns NullLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NullLiteralExpCS
	 *     PrefixedPrimaryExpCS returns NullLiteralExpCS
	 *     PrimaryExpCS returns NullLiteralExpCS
	 *     NavigatingArgExpCS returns NullLiteralExpCS
	 *
	 * Constraint:
	 *     {NullLiteralExpCS}
	 * </pre>
	 */
	protected void sequence_NullLiteralExpCS(ISerializationContext context, NullLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns NumberLiteralExpCS
	 *     NumberLiteralExpCS returns NumberLiteralExpCS
	 *     ExpCS returns NumberLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns NumberLiteralExpCS
	 *     PrefixedPrimaryExpCS returns NumberLiteralExpCS
	 *     PrimaryExpCS returns NumberLiteralExpCS
	 *     NavigatingArgExpCS returns NumberLiteralExpCS
	 *
	 * Constraint:
	 *     symbol=NUMBER_LITERAL
	 * </pre>
	 */
	protected void sequence_NumberLiteralExpCS(ISerializationContext context, NumberLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS__SYMBOL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0(), semanticObject.getSymbol());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PatternExpCS returns PatternExpCS
	 *
	 * Constraint:
	 *     (patternVariableName=UnrestrictedName? ownedPatternType=TypeExpCS)
	 * </pre>
	 */
	protected void sequence_PatternExpCS(ISerializationContext context, PatternExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrefixedLetExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedLetExpCS)
	 * </pre>
	 */
	protected void sequence_PrefixedLetExpCS(ISerializationContext context, PrefixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns PrefixExpCS
	 *     NavigatingArgExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     ((name=UnaryOperatorName ownedRight=PrefixedLetExpCS) | (name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS))
	 * </pre>
	 */
	protected void sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(ISerializationContext context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS.InfixExpCS_0_1_0 returns PrefixExpCS
	 *     PrefixedPrimaryExpCS returns PrefixExpCS
	 *
	 * Constraint:
	 *     (name=UnaryOperatorName ownedRight=PrefixedPrimaryExpCS)
	 * </pre>
	 */
	protected void sequence_PrefixedPrimaryExpCS(ISerializationContext context, PrefixExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.NAMED_ELEMENT_CS__NAME));
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS__OWNED_RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0(), semanticObject.getOwnedRight());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveTypeCS returns PrimitiveTypeRefCS
	 *     TypeLiteralCS returns PrimitiveTypeRefCS
	 *     TypeExpWithoutMultiplicityCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     name=PrimitiveTypeIdentifier
	 * </pre>
	 */
	protected void sequence_PrimitiveTypeCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_PrimitiveTypeCS_TypeExpCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns PrimitiveTypeRefCS
	 *
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(ISerializationContext context, PrimitiveTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     RoundBracketedClauseCS returns RoundBracketedClauseCS
	 *
	 * Constraint:
	 *     (
	 *         ownedArguments+=NavigatingArgCS
	 *         (ownedArguments+=NavigatingCommaArgCS | ownedArguments+=NavigatingSemiArgCS | ownedArguments+=NavigatingBarArgCS)*
	 *     )?
	 * </pre>
	 */
	protected void sequence_RoundBracketedClauseCS(ISerializationContext context, RoundBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ExpCS returns SelfExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns SelfExpCS
	 *     PrefixedPrimaryExpCS returns SelfExpCS
	 *     PrimaryExpCS returns SelfExpCS
	 *     NavigatingArgExpCS returns SelfExpCS
	 *     SelfExpCS returns SelfExpCS
	 *
	 * Constraint:
	 *     {SelfExpCS}
	 * </pre>
	 */
	protected void sequence_SelfExpCS(ISerializationContext context, SelfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     ShadowPartCS returns ShadowPartCS
	 *
	 * Constraint:
	 *     (
	 *         (referredProperty=[Property|UnrestrictedName] (ownedInitExpression=ExpCS | ownedInitExpression=PatternExpCS)) |
	 *         ownedInitExpression=StringLiteralExpCS
	 *     )
	 * </pre>
	 */
	protected void sequence_ShadowPartCS(ISerializationContext context, ShadowPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     SimplePathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     ownedPathElements+=FirstPathElementCS
	 * </pre>
	 */
	protected void sequence_SimplePathNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     SquareBracketedClauseCS returns SquareBracketedClauseCS
	 *
	 * Constraint:
	 *     (ownedTerms+=ExpCS ownedTerms+=ExpCS*)
	 * </pre>
	 */
	protected void sequence_SquareBracketedClauseCS(ISerializationContext context, SquareBracketedClauseCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns StringLiteralExpCS
	 *     StringLiteralExpCS returns StringLiteralExpCS
	 *     ExpCS returns StringLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns StringLiteralExpCS
	 *     PrefixedPrimaryExpCS returns StringLiteralExpCS
	 *     PrimaryExpCS returns StringLiteralExpCS
	 *     NavigatingArgExpCS returns StringLiteralExpCS
	 *
	 * Constraint:
	 *     segments+=StringLiteral+
	 * </pre>
	 */
	protected void sequence_StringLiteralExpCS(ISerializationContext context, StringLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TupleLiteralExpCS returns TupleLiteralExpCS
	 *     ExpCS returns TupleLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns TupleLiteralExpCS
	 *     PrefixedPrimaryExpCS returns TupleLiteralExpCS
	 *     PrimaryExpCS returns TupleLiteralExpCS
	 *     NavigatingArgExpCS returns TupleLiteralExpCS
	 *
	 * Constraint:
	 *     (ownedParts+=TupleLiteralPartCS ownedParts+=TupleLiteralPartCS*)
	 * </pre>
	 */
	protected void sequence_TupleLiteralExpCS(ISerializationContext context, TupleLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TupleLiteralPartCS returns TupleLiteralPartCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS? ownedInitExpression=ExpCS)
	 * </pre>
	 */
	protected void sequence_TupleLiteralPartCS(ISerializationContext context, TupleLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TuplePartCS returns TuplePartCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
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
		feeder.accept(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TupleTypeCS returns TupleTypeCS
	 *     TypeLiteralCS returns TupleTypeCS
	 *     TypeExpWithoutMultiplicityCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)?)
	 * </pre>
	 */
	protected void sequence_TupleTypeCS(ISerializationContext context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_TupleTypeCS_TypeExpCS(ISerializationContext context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeLiteralWithMultiplicityCS returns TupleTypeCS
	 *
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(ISerializationContext context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeExpCS returns TypeNameExpCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)? ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_TypeExpCS_TypeNameExpCS(ISerializationContext context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeLiteralExpCS returns TypeLiteralExpCS
	 *     ExpCS returns TypeLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns TypeLiteralExpCS
	 *     PrefixedPrimaryExpCS returns TypeLiteralExpCS
	 *     PrimaryExpCS returns TypeLiteralExpCS
	 *     NavigatingArgExpCS returns TypeLiteralExpCS
	 *
	 * Constraint:
	 *     ownedType=TypeLiteralWithMultiplicityCS
	 * </pre>
	 */
	protected void sequence_TypeLiteralExpCS(ISerializationContext context, TypeLiteralExpCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0(), semanticObject.getOwnedType());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeNameExpCS returns TypeNameExpCS
	 *     TypeExpWithoutMultiplicityCS returns TypeNameExpCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS (ownedCurlyBracketedClause=CurlyBracketedClauseCS ownedPatternGuard=ExpCS?)?)
	 * </pre>
	 */
	protected void sequence_TypeNameExpCS(ISerializationContext context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     URIFirstPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 * </pre>
	 */
	protected void sequence_URIFirstPathElementCS(ISerializationContext context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_0_1(), semanticObject.eGet(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     URIFirstPathElementCS returns PathElementWithURICS
	 *
	 * Constraint:
	 *     referredElement=[Namespace|URI]
	 * </pre>
	 */
	protected void sequence_URIFirstPathElementCS(ISerializationContext context, PathElementWithURICS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceURIParserRuleCall_1_1_0_1(), semanticObject.eGet(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     URIPathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=URIFirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 * </pre>
	 */
	protected void sequence_URIPathNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PrimitiveLiteralExpCS returns UnlimitedNaturalLiteralExpCS
	 *     UnlimitedNaturalLiteralExpCS returns UnlimitedNaturalLiteralExpCS
	 *     ExpCS returns UnlimitedNaturalLiteralExpCS
	 *     ExpCS.InfixExpCS_0_1_0 returns UnlimitedNaturalLiteralExpCS
	 *     PrefixedPrimaryExpCS returns UnlimitedNaturalLiteralExpCS
	 *     PrimaryExpCS returns UnlimitedNaturalLiteralExpCS
	 *     NavigatingArgExpCS returns UnlimitedNaturalLiteralExpCS
	 *
	 * Constraint:
	 *     {UnlimitedNaturalLiteralExpCS}
	 * </pre>
	 */
	protected void sequence_UnlimitedNaturalLiteralExpCS(ISerializationContext context, UnlimitedNaturalLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
