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
package org.eclipse.ocl.xtext.base.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.base.services.BaseGrammarAccess;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractBaseSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BaseGrammarAccess grammarAccess;

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
				else break;
			case BaseCSPackage.PATH_NAME_CS:
				if (rule == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject);
					return;
				}
				else if (rule == grammarAccess.getUnreservedPathNameCSRule()) {
					sequence_UnreservedPathNameCS(context, (PathNameCS) semanticObject);
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
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * <pre>
	 * Contexts:
	 *     FirstPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnrestrictedName]
	 * </pre>
	 */
	protected void sequence_FirstPathElementCS(ISerializationContext context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementUnrestrictedNameParserRuleCall_0_1(), semanticObject.eGet(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MultiplicityBoundsCS returns MultiplicityBoundsCS
	 *
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER?)
	 * </pre>
	 */
	protected void sequence_MultiplicityBoundsCS(ISerializationContext context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MultiplicityCS returns MultiplicityBoundsCS
	 *
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER? isNullFree?='|1'?)
	 * </pre>
	 */
	protected void sequence_MultiplicityBoundsCS_MultiplicityCS(ISerializationContext context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MultiplicityCS returns MultiplicityStringCS
	 *
	 * Constraint:
	 *     ((stringBounds='*' | stringBounds='+' | stringBounds='?') isNullFree?='|1'?)
	 * </pre>
	 */
	protected void sequence_MultiplicityCS_MultiplicityStringCS(ISerializationContext context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     MultiplicityStringCS returns MultiplicityStringCS
	 *
	 * Constraint:
	 *     (stringBounds='*' | stringBounds='+' | stringBounds='?')
	 * </pre>
	 */
	protected void sequence_MultiplicityStringCS(ISerializationContext context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     NextPathElementCS returns PathElementCS
	 *
	 * Constraint:
	 *     referredElement=[NamedElement|UnreservedName]
	 * </pre>
	 */
	protected void sequence_NextPathElementCS(ISerializationContext context, PathElementCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementUnreservedNameParserRuleCall_0_1(), semanticObject.eGet(BaseCSPackage.Literals.PATH_ELEMENT_CS__REFERRED_ELEMENT, false));
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     PathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=FirstPathElementCS ownedPathElements+=NextPathElementCS*)
	 * </pre>
	 */
	protected void sequence_PathNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TemplateBindingCS returns TemplateBindingCS
	 *
	 * Constraint:
	 *     (ownedSubstitutions+=TemplateParameterSubstitutionCS ownedSubstitutions+=TemplateParameterSubstitutionCS* ownedMultiplicity=MultiplicityCS?)
	 * </pre>
	 */
	protected void sequence_TemplateBindingCS(ISerializationContext context, TemplateBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TemplateParameterSubstitutionCS returns TemplateParameterSubstitutionCS
	 *
	 * Constraint:
	 *     ownedActualParameter=TypeRefCS
	 * </pre>
	 */
	protected void sequence_TemplateParameterSubstitutionCS(ISerializationContext context, TemplateParameterSubstitutionCS semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0(), semanticObject.getOwnedActualParameter());
		feeder.finish();
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TemplateSignatureCS returns TemplateSignatureCS
	 *
	 * Constraint:
	 *     (ownedParameters+=TypeParameterCS ownedParameters+=TypeParameterCS*)
	 * </pre>
	 */
	protected void sequence_TemplateSignatureCS(ISerializationContext context, TemplateSignatureCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeParameterCS returns TypeParameterCS
	 *
	 * Constraint:
	 *     (name=UnrestrictedName (ownedExtends+=TypedRefCS ownedExtends+=TypedRefCS*)?)
	 * </pre>
	 */
	protected void sequence_TypeParameterCS(ISerializationContext context, TypeParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeRefCS returns TypedTypeRefCS
	 *     TypedRefCS returns TypedTypeRefCS
	 *     TypedTypeRefCS returns TypedTypeRefCS
	 *
	 * Constraint:
	 *     (ownedPathName=PathNameCS ownedBinding=TemplateBindingCS?)
	 * </pre>
	 */
	protected void sequence_TypedTypeRefCS(ISerializationContext context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     UnreservedPathNameCS returns PathNameCS
	 *
	 * Constraint:
	 *     (ownedPathElements+=NextPathElementCS ownedPathElements+=NextPathElementCS*)
	 * </pre>
	 */
	protected void sequence_UnreservedPathNameCS(ISerializationContext context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * <pre>
	 * Contexts:
	 *     TypeRefCS returns WildcardTypeRefCS
	 *     WildcardTypeRefCS returns WildcardTypeRefCS
	 *
	 * Constraint:
	 *     ownedExtends=TypedRefCS?
	 * </pre>
	 */
	protected void sequence_WildcardTypeRefCS(ISerializationContext context, WildcardTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}
