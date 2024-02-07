/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An invocation of a feature referenced on a sequence of instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FeatureInvocationExpression#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureInvocationExpression()
 * @model
 * @generated
 */
public interface FeatureInvocationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A feature reference to the target feature to be invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(FeatureReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureInvocationExpression_Target()
	 * @model containment="true"
	 * @generated
	 */
	FeatureReference getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FeatureInvocationExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(FeatureReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.target <> null then self.target\n        else\n          let outerScope = self.currentScope().namespace() in\n            if outerScope = null or not outerScope.isClass() then null\n            else\n              FeatureReference{\n                expression = ThisExpression{},\n                nameBinding = NameBinding{name = outerScope.name()},\n                owner = self\n              }\n            endif\n        endif'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature in\n          if feature = null then null\n          else feature.behavioralFeatureReferent(self)\n          endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature invocation expression is an implicit object destruction, it
	 * has no referent. Otherwise, its referent is the operation or signal being
	 * invoked.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature invocation expression has an explicit target, then that is
	 * its feature. Otherwise, it is an alternative constructor call with
	 * its feature determined implicitly.
	 * (See the feature() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature invocation expression is not an implicit destructor call,
	 * then it must be possible to determine a single valid referent for it
	 * according to the overloading resolution rules.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.isImplicit or self.referent <> null and\n          -- TODO: Remove this check once overloading resolution is implemented.\n          self.tuple.size() <= self.parameterCount() and\n          self.tuple.input()->forAll(input | self.parameterIsAssignableFrom(input)) and\n          self.tuple.output()->forAll(output | self.parameterIsAssignableTo(output))'"
	 * @generated
	 */
	boolean featureInvocationExpressionReferentExists(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An alternative constructor invocation may only occur in an expression
	 * statement as the first statement in the definition for the method of a
	 * constructor operation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.alternativeConstructorIsValid()'"
	 * @generated
	 */
	boolean featureInvocationExpressionAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If there is no target feature expression, then the implicit feature with
	 * the same name as the target type must be a constructor.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.target = null implies\n          let referent = self.referent in\n            referent <> null and referent.isConstructor()'"
	 * @generated
	 */
	boolean featureInvocationExpressionImplicitAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FeatureInvocationExpression
