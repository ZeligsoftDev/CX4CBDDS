/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Reduction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to reduce a sequence of values effectively by inserting
 * a binary operation between the values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getBehaviorName <em>Behavior Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceReductionExpression()
 * @model
 * @generated
 */
public interface SequenceReductionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Referent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the behavior to be used as the reducer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referent</em>' reference.
	 * @see #setReferent(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceReductionExpression_Referent()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let referents = self.behaviorName.referent->select(isBehavior()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference getReferent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getReferent <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referent</em>' reference.
	 * @see #getReferent()
	 * @generated
	 */
	void setReferent(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an ordered reduction or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceReductionExpression_IsOrdered()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target class name or primary expression for the reduction.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' containment reference.
	 * @see #setPrimary(ExtentOrExpression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceReductionExpression_Primary()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExtentOrExpression getPrimary();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getPrimary <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' containment reference.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(ExtentOrExpression value);

	/**
	 * Returns the value of the '<em><b>Behavior Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the behavior to be used as the reducer.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Behavior Name</em>' containment reference.
	 * @see #setBehaviorName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceReductionExpression_BehaviorName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getBehaviorName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceReductionExpression#getBehaviorName <em>Behavior Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Name</em>' containment reference.
	 * @see #getBehaviorName()
	 * @generated
	 */
	void setBehaviorName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primary.expression.type'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='1'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='1'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent for a sequence reduction expression is the behavior denoted
	 * by the behavior name of the expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceReductionExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence reduction expression has the same type as its primary
	 * expression.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceReductionExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence reduction expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceReductionExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence reduction expression has a multiplicity lower bound of 1.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceReductionExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The behavior name in a sequence reduction expression must denote a behavior.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          referent <> null and not referent.isTemplate()'"
	 * @generated
	 */
	boolean sequenceReductionExpressionBehavior(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent behavior must have two in parameters, a return parameter and
	 * no other parameters. The parameters must all have the same type as the
	 * argument expression and multiplicity [1..1].
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        referent <> null implies\n          let parameters = referent.parameters() in\n          let returnParameter = referent.returnParameter() in\n          let type = self.type in\n            parameters->size() = 2 and returnParameter <> null and\n            parameters->forAll(direction() = \'in\') and\n            parameters->including(returnParameter)->forAll(\n              lower() = 1 and upper() = 1 and\n              let parameterType = type() in\n                parameterType = null and type = null or\n                parameterType <> null and parameterType.equals(type) \n            )'"
	 * @generated
	 */
	boolean sequenceReductionExpressionBehaviorParameters(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the target expression of a sequence reduction
	 * expression are the same as the assignments before the sequence reduction
	 * expression.
	 * (See the SyntaxElement::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceReductionExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a sequence reduction expression are the same as
	 * after its primary expression.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.primary.expression.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // SequenceReductionExpression
