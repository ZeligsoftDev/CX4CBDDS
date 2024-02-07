/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reference to a structural or behavioral feature of the type of its target
 * expression or a binary association end the opposite end of which is typed
 * by the type of its target expression.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FeatureReference#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FeatureReference#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FeatureReference#getNameBinding <em>Name Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureReference()
 * @model
 * @generated
 */
public interface FeatureReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureReference_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FeatureReference#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The features referenced by this feature reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureReference_Referent()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.referentCached()'"
	 * @generated
	 */
	EList<ElementReference> getReferent();

	/**
	 * Returns the value of the '<em><b>Name Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name Binding</em>' containment reference.
	 * @see #setNameBinding(NameBinding)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureReference_NameBinding()
	 * @model containment="true"
	 * @generated
	 */
	NameBinding getNameBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FeatureReference#getNameBinding <em>Name Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Binding</em>' containment reference.
	 * @see #getNameBinding()
	 * @generated
	 */
	void setNameBinding(NameBinding value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model invocationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        -- TODO: Handle overloading resolution.\n        let referents = self.referent->select(isOperation() or isReception()) in\n          if referents->size() <> 1 then null\n          else if referents->forAll(isReception()) then\n            referents->any(true).signal()\n          else\n            referents->any(true)\n          endif endif'"
	 * @generated
	 */
	ElementReference behavioralFeatureReferent(InvocationExpression invocation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The features referenced by a feature reference include the features of
	 * the type of the target expression and the association ends of any binary
	 * associations whose opposite ends are typed by the type of the target
	 * expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureReferenceReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target expression of the feature reference may not be untyped, nor
	 * may it have a primitive or enumeration type.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = self.expression.type in\n          type <> null and not type.isPrimitiveType() and not type.isEnumeration()'"
	 * @generated
	 */
	boolean featureReferenceTargetType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ElementReference> referentCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.FeatureReference_referent()'"
	 * @generated
	 */
	EList<ElementReference> referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = self.expression.type in\n        let name = self.nameBinding.toName() in\n          if type = null then Set(ElementReference){}\n          else\n            let currentScope = self.currentScope() in\n            let features = type.resolveVisible(name, currentScope) in\n              if currentScope = null then features\n              else features->union(currentScope.resolveAssociationEnd(type, name))\n              endif\n          endif'"
	 * @generated
	 */
	EList<ElementReference> FeatureReference_referent();

} // FeatureReference
