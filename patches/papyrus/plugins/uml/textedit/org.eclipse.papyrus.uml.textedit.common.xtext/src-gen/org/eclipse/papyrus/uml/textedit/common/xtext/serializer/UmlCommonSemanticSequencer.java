/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlCommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlCommonGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UmlCommonPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UmlCommonPackage.BOUND_SPECIFICATION:
				sequence_BoundSpecification(context, (BoundSpecification) semanticObject);
				return;
			case UmlCommonPackage.MULTIPLICITY_RULE:
				sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject);
				return;
			case UmlCommonPackage.QUALIFIED_NAME:
				sequence_QualifiedName(context, (QualifiedName) semanticObject);
				return;
			case UmlCommonPackage.TYPE_RULE:
				sequence_TypeRule(context, (TypeRule) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * BoundSpecification returns BoundSpecification
	 *
	 * Constraint:
	 * value=UnlimitedLiteral
	 */
	protected void sequence_BoundSpecification(ISerializationContext context, BoundSpecification semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UmlCommonPackage.Literals.BOUND_SPECIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlCommonPackage.Literals.BOUND_SPECIFICATION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}


	/**
	 * Contexts:
	 * MultiplicityRule returns MultiplicityRule
	 *
	 * Constraint:
	 * (bounds+=BoundSpecification bounds+=BoundSpecification?)
	 */
	protected void sequence_MultiplicityRule(ISerializationContext context, MultiplicityRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * QualifiedName returns QualifiedName
	 *
	 * Constraint:
	 * (path=[Namespace|ID] remaining=QualifiedName?)
	 */
	protected void sequence_QualifiedName(ISerializationContext context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Contexts:
	 * TypeRule returns TypeRule
	 *
	 * Constraint:
	 * (path=QualifiedName? type=[Type|ID])
	 */
	protected void sequence_TypeRule(ISerializationContext context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}