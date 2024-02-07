/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An invocation of a behavior referenced by name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBehaviorInvocationExpression()
 * @model
 * @generated
 */
public interface BehaviorInvocationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name of the behavior to be invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBehaviorInvocationExpression_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" targetExpressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.feature <> null then false\n        else\n          let collectionFunctionAdd = self.collectionFunctionAdd() in\n            if collectionFunctionAdd = null then false\n            else\n              let parameters = collectionFunctionAdd.parameters() in\n                if parameters->isEmpty() then false\n                else\n                  collectionFunctionAdd.containedIn(self.target.referent->asBag()) and\n                  self.tuple.outputFor(parameters)->exists(\n                    name = parameters->at(1).name() and\n                    expression = targetExpression\n                  )\n                endif\n              endif\n          endif'"
	 * @generated
	 */
	boolean isAddTarget(Expression targetExpression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='referent1()'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference referent1();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature() in\n          if feature <> null then feature.behavioralFeatureReferent(self)\n          else\n            let referents = self.target.referent in\n              if referents->select(isBehavior())->size() = 1 then\n                let referent = referents->any(isBehavior()) in\n                  if referent.isTemplate() then \n                    self.bindTemplateImplicitArguments(referent, null)\n                  else referent\n                  endif\n              else if referents->select(isAssociationEnd())->size() = 1 then\n                referents->any(isAssociationEnd())\n              else\n                null\n              endif endif\n          endif'"
	 * @generated
	 */
	ElementReference BehaviorInvocation_referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.target.disambiguation'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target of a behavior invocation expression resolves to a behavior,
	 * then the referent of the expression is that behavior. If the target
	 * disambiguates to a feature reference, then the reference is the operation
	 * or signal being invoked. Otherwise, if the target resolves to a property
	 * that is an association end, then the referent is that property.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean behaviorInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target qualified name disambiguates to a feature reference, then
	 * the feature of a behavior invocation expression is that feature reference.
	 * (See the feature() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean behaviorInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target qualified name does not disambiguate to a feature reference,
	 * then it must resolve to a behavior or an association end. Otherwise it
	 * must resolve to a single feature referent according to the overloading
	 * resolution rules, unless it is an implicit destructor call (in which case
	 * it has no referent).
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isImplicit or \n        let referent = self.referent in\n          referent <> null and \n          -- NOTE: This check prevents the invocation from disambiguating to an \n          -- illegal constructor invocation.\n          not referent.isConstructor() and\n          -- Also check that the association owns all its ends.\n          referent.isAssociationEnd() implies\n          \treferent.association().properties()->forAll(isAssociationEnd())'"
	 * @generated
	 */
	boolean behaviorInvocationExpressionReferentConstraint(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target qualified name does not disambiguate to a feature reference,
	 * then each input argument expression must be assignable to its corresponding
	 * parameter and each output argument expression must be assignable from its
	 * corresponding parameter. (Note that this implies that the type of an
	 * argument expression for an inout parameter must be the same as the type
	 * of that parameter.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- TODO: Handle overloading for feature invocations.\n        self.tuple.size() <= self.parameterCount() and\n        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))'"
	 * @generated
	 */
	boolean behaviorInvocationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent may only be a constructor (as a result of the target
	 * disambiguating to a feature reference) if this behavior invocation
	 * expression is the expression of an expression statement that is the first
	 * statement in the definition for the method of a constructor operation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.alternativeConstructorIsValid()'"
	 * @generated
	 */
	boolean behaviorInvocationExpressionAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BehaviorInvocationExpression
