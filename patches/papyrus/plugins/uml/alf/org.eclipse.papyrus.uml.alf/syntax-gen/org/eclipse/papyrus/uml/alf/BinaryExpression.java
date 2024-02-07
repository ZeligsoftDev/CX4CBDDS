/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression consisting of an operator acting on two operand expressions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperand2 <em>Operand2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBinaryExpression()
 * @model abstract="true"
 * @generated
 */
public interface BinaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression giving the first operand.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand1</em>' containment reference.
	 * @see #setOperand1(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBinaryExpression_Operand1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand1();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperand1 <em>Operand1</em>}' containment reference.
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
	 * The expression giving the second operand.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand2</em>' containment reference.
	 * @see #setOperand2(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBinaryExpression_Operand2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOperand2();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperand2 <em>Operand2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand2</em>' containment reference.
	 * @see #getOperand2()
	 * @generated
	 */
	void setOperand2(Expression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The symbol representing the operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBinaryExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BinaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In general the assignments before the operand expressions of a binary
	 * expression are the same as those before the binary expression and, if an
	 * assignment for a name is changed in one operand expression, then the
	 * assignment for that name may not change in the other operand expression.
	 * (This is overridden for conditional logical expressions.)
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand1.newAssignments().name->excludesAll(self.operand2.newAssignments().name)'"
	 * @generated
	 */
	boolean validateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * By default, null arguments are not allowed for binary expressions.
	 * (This is overridden for equality expressions.)
	 * <!-- end-model-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean noNullArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operands of a binary expression must both have a multiplicity upper
	 * bound no greater than 1. If null arguments are not allowed (as given by
	 * the noNullArguments helper operation), then the upper bounds must be
	 * exactly 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    if self.noNullArguments() then\n      self.operand1.upper = 1 and self.operand2.upper = 1\n    else\n      self.operand1.upper <= 1 and self.operand2.upper <= 2\n    endif'"
	 * @generated
	 */
	boolean binaryExpressionOperandMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments in the operand expressions of a binary expression must be
	 * valid (as determined by the validateAssignments helper operation).
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.validateAssignments()'"
	 * @generated
	 */
	boolean binaryExpressionOperandAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a binary expression include all the assignments
	 * before the expression that are not reassigned in either operand
	 * expression, plus the new assignments from each of the operand expressions.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.updateAll(\n          self.assignmentBefore,\n          self.operand1.newAssignments()->union(operand2.newAssignments())\n        )'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // BinaryExpression
