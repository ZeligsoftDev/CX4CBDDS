/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.services.UMLConnectionPointReferenceGrammarAccess;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UMLConnectionPointReferenceSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UMLConnectionPointReferenceGrammarAccess grammarAccess;

	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UMLConnectionPointReferencePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE:
				sequence_ConnectionPointReferenceRule(context, (ConnectionPointReferenceRule) semanticObject);
				return;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}

	/**
	 * Contexts:
	 * ConnectionPointReferenceRule returns ConnectionPointReferenceRule
	 *
	 * Constraint:
	 * ((entry+=[Pseudostate|ID] entry+=[Pseudostate|ID]*) | (exit+=[Pseudostate|ID] exit+=[Pseudostate|ID]*))
	 */
	protected void sequence_ConnectionPointReferenceRule(ISerializationContext context, ConnectionPointReferenceRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


}