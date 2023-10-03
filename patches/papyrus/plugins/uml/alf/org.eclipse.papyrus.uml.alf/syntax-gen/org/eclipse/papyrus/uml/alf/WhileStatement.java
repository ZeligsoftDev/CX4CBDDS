/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A looping statement for which the continuation condition is first tested
 * before the first iteration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.WhileStatement#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.WhileStatement#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of statements to be iteratively executed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getWhileStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.WhileStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to determine whether to continue looping.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getWhileStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.WhileStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self'"
	 * @generated
	 */
	Statement enclosingLoopStatement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n     if self.body <> element then self.assignmentBefore\n     else self.condition.assignmentAfter \n     endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n     let assignmentsBeforeBlock = self.body.assignmentBefore in\n       self.body.newAssignments()->\n         reject(a | assignmentsBeforeBlock.name->excludes(a.name))->\n         iterate(a, assignments : Set(AssignedSource) = assignmentsBeforeBlock |\n           AssignedSource{\n             name = a.name,\n             source = self,\n             type = a.type,\n             lower = a.lower,\n             upper = a.upper\n            }.update(assignments)\n         )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the condition expression of a while statement
	 * are the same as the assignments before the while statement. The
	 * assignments before the block of the while statement are the same as the
	 * assignments after the condition expression.
	 * (See assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean whileStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name is assigned before the block, but the assigned source for the
	 * name after the block is different than before the block, then the assigned
	 * source of the name after the while statement is the while statement.
	 * Otherwise it is the same as before the block. If a name is unassigned
	 * before the block of a while statement, then it is unassigned after the
	 * while statement, even if it is assigned after the block.
	 * (See assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean whileStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The condition expression of a while statement must have type Boolean and
	 * a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = self.condition.type in\n          type <> null and self.isBooleanType(type) and self.condition.upper = 1'"
	 * @generated
	 */
	boolean whileStatementCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enclosing statement for all statements in the body of a while
	 * statement are the while statement.
	 * (See the SyntaxElement::enclosingStatement() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean whileStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

} // WhileStatement
