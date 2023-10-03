/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Test Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression that uses the value of one operand expression to condition
 * the evaluation of one of two other operand expressions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand2 <em>Operand2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand3 <em>Operand3</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getConditionalTestExpression()
 * @model
 * @generated
 */
public interface ConditionalTestExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first operand expression, which provides the condition to be tested.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand1</em>' containment reference.
	 * @see #setOperand1(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getConditionalTestExpression_Operand1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand1();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand1 <em>Operand1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand1</em>' containment reference.
	 * @see #getOperand1()
	 * @generated
	 */
	void setOperand1(Expression value);

	/**
	 * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The second operand expression, to be evaluated if the condition is true.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand2</em>' containment reference.
	 * @see #setOperand2(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getConditionalTestExpression_Operand2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand2();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand2 <em>Operand2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand2</em>' containment reference.
	 * @see #getOperand2()
	 * @generated
	 */
	void setOperand2(Expression value);

	/**
	 * Returns the value of the '<em><b>Operand3</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The third operand expression, to be evaluated if the condition is false.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand3</em>' containment reference.
	 * @see #setOperand3(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getConditionalTestExpression_Operand3()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand3();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ConditionalTestExpression#getOperand3 <em>Operand3</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand3</em>' containment reference.
	 * @see #getOperand3()
	 * @generated
	 */
	void setOperand3(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.commonAncestor(Set{self.operand2.type, self.operand3.type})'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand2.lower.min(self.operand3.lower)'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.operand2.upper = -1 or self.operand2.upper = -1 then -1\n        else self.operand2.upper.max(self.operand3.upper)\n        endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.operand2 = element or self.operand3 = element then\n          self.operand1.assignmentAfter\n        else\n          self.assignmentBefore\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a conditional-test operator expression is the effective
	 * common ancestor (if one exists) of the types of its second and third
	 * operand expressions.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean conditionalTestExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of a conditional-test operator expression is
	 * the minimum of the multiplicity lower bounds of its second and third
	 * operand expressions.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean conditionalTestExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of a conditional-test operator expression is
	 * the maximum of the multiplicity upper bounds of its second and third
	 * operand expressions.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean conditionalTestExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first operand expression of a conditional-test expression must be of
	 * type Boolean and have a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isBooleanType(self.operand1.type) and self.operand1.upper = 1'"
	 * @generated
	 */
	boolean conditionalTestExpressionCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the first operand expression of a conditional-test
	 * expression are the same as those before the conditional-test expression.
	 * The assignments before the second and third operand expressions are the
	 * same as those after the first operand expression.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean conditionalTestExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name is unassigned after the first operand expression and has an
	 * assigned source after one of the other operand expression, then it must
	 * have an assigned source after both of those expressions.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.operand1.assignmentAfter.name->includesAll(\n          self.operand2.assignmentAfter.name->asSet()->\n            symmetricDifference(self.operand3.assignmentAfter.name->asSet())\n        )'"
	 * @generated
	 */
	boolean conditionalTestExpressionAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the assignments after the first operand expression, plus
	 * assignments for any newly defined local names in the second and
	 * third operand expressions. Local names that exist after the first operand
	 * expression but are reassigned in the second or third operand expressions
	 * are adjusted to have the conditional-test expression as their assigned
	 * source. Local names that are newly defined in the second and third
	 * operand expressions have the conditional-text expression as their source
	 * and a type that is the effective common ancestor (if one exists) of the
	 * types from the assignments after each of the second and third operands.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignments1 = self.operand1.assignmentAfter in\n        let assignments2 = self.operand2.newAssignments() in\n        let assignments3 = self.operand3.newAssignments() in\n        let reassignments = assignments1->\n          select(\n            assignments2.name->includes(name) or \n            assignments3.name->includes(name)\n          ).copy(self, null)->asSet() in\n        let newAssignments = assignments2->\n          select(\n            assignments1.name->excludes(name) and\n            assignments3.name->includes(name)\n          )->collect(assignment |\n            let otherAssignment = assignments3->any(name = assignment.name) in\n              AssignedSource{\n                name = assignment.name,\n                source = self,\n                type = self.commonAncestor(Set{assignment.type, otherAssignment.type}),\n                lower = assignment.lower.min(otherAssignment.lower),\n                upper = \n                  if assignment.upper = -1 or otherAssignment.upper = -1 then -1\n                  else assignment.upper.max(otherAssignment.upper)\n                  endif\n              }\n          )->asSet()\n        in\n          self.updateAll(assignments1, reassignments->union(newAssignments))'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // ConditionalTestExpression
