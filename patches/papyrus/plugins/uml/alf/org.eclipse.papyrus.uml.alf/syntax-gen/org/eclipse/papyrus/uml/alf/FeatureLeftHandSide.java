/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A left-hand side that is a property reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.FeatureLeftHandSide#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureLeftHandSide()
 * @model
 * @generated
 */
public interface FeatureLeftHandSide extends LeftHandSide {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The structural feature being assigned.
	 * property feature : FeatureReference { composes };
	 * 
	 * The actual expression parsed for this feature left-hand side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getFeatureLeftHandSide_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.FeatureLeftHandSide#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.feature().referent->select(isProperty()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.expression.oclIsKindOf(PropertyAccessExpression) then\n          self.expression.oclAsType(PropertyAccessExpression).featureReference\n        else if self.expression.oclIsKindOf(SequenceAccessExpression) then\n          let primary = self.expression.oclAsType(SequenceAccessExpression).primary in\n            if primary.oclIsKindOf(PropertyAccessExpression) then\n              primary.oclAsType(PropertyAccessExpression).featureReference\n            else\n              null\n            endif\n        else\n          null\n        endif endif'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression'"
	 * @generated
	 */
	Expression expression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.expression.oclIsKindOf(SequenceAccessExpression) then null\n        else self.expression.oclAsType(SequenceAccessExpression).index\n        endif'"
	 * @generated
	 */
	Expression index();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	String localName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expression of the feature reference of a
	 * feature left-hand side are the assignments before the feature left-hand
	 * side.
	 * (And the assignments before an index are those after the feature reference.)
	 * (See the LeftHandSide::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideAssignmentBeforeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a feature left-hand side are the assignments after
	 * the expression of the feature reference or, if there is an index, those
	 * after the index expression.
	 * (See the LeftHandSide::assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression of the feature reference of a feature left-hand side must
	 * have a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.feature().expression in\n        let type = expression.type in\n          expression.upper = 1 and\n          -- Note: The following condition ensures that a data value update will\n          -- be to an existing assigned name.\n          (type <> null and type.isDataType()) implies self.isDataValueUpdate()'"
	 * @generated
	 */
	boolean featureLeftHandSideFeatureExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature left-hand side has an index, then the assignments before the
	 * index expression are the assignments after the expression of the feature
	 * reference.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of a feature left-hand side is the structural feature to
	 * which the feature reference of the left-hand side resolves.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a feature left-hand side is the type of its referent.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature left-hand side is indexed, then its lower bound is 1.
	 * Otherwise, its lower bound is that of its referent.
	 * (see the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature left-hand side is indexed, then its upper bound is 1.
	 * Otherwise, its upper bound is that of its referent.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean featureLeftHandSideUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The feature of a feature-left hand side must have a single referent that
	 * is a structural feature.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.referent <> null'"
	 * @generated
	 */
	boolean featureLeftHandSideReferentConstraint(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a feature left-hand side has an index, then the referent of the
	 * feature must be ordered and non-unique.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.index() <> null implies\n          let referent = self.referent in\n            referent <> null and referent.isOrdered() and referent.isNonunique()'"
	 * @generated
	 */
	boolean featureLeftHandSideIndexedFeature(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FeatureLeftHandSide
