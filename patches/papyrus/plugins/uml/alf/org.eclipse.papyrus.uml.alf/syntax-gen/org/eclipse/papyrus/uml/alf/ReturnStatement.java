/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement that provides a value for the return parameter of an activity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ReturnStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ReturnStatement#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReturnStatement()
 * @model
 * @generated
 */
public interface ReturnStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to provide the returned value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReturnStatement_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ReturnStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to the enclosing behavior for this return statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Behavior</em>' reference.
	 * @see #setBehavior(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReturnStatement_Behavior()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.currentScope()'"
	 * @generated
	 */
	ElementReference getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ReturnStatement#getBehavior <em>Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.expression = null then self.assignmentBefore\n        else self.expression.assignmentAfter\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the behavior containing the return statement has a return parameter,
	 * then the return statement must have an expression, and the expression
	 * must be assignable to that return parameter.
	 * (And, if the behavior does not have a return parameter, then the return
	 * statement must not have an expression.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let behavior = self.behavior in\n          if behavior = null then false\n          else\n            let returnParameter = behavior.returnParameter() in\n              self.expression = null and returnParameter = null or\n              self.expression <> null and returnParameter <> null and\n              returnParameter.isAssignableFrom(self.expression)\n          endif'"
	 * @generated
	 */
	boolean returnStatementContext(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expression of a return statement are the same
	 * as the assignments before the statement.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean returnStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a return statement are the same as the assignments
	 * after the expression of the return statement.
	 * (Or, if the statement has no expression, the same as the assignments
	 * before the statement.)
	 * (See the assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean returnStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ReturnStatement
