/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A conditional statement that executes (at most) one of a set of clauses based on boolean conditions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IfStatement#getNonFinalClauses <em>Non Final Clauses</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IfStatement#getFinalClause <em>Final Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IfStatement#isIsAssured <em>Is Assured</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IfStatement#isIsDeterminate <em>Is Determinate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Non Final Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ConcurrentClauses}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of groupings of concurrent clauses that are to be checked
	 * sequentially for a successful condition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Final Clauses</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIfStatement_NonFinalClauses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConcurrentClauses> getNonFinalClauses();

	/**
	 * Returns the value of the '<em><b>Final Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence of statements to be executed if no other clause has a
	 * successful condition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Final Clause</em>' containment reference.
	 * @see #setFinalClause(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIfStatement_FinalClause()
	 * @model containment="true"
	 * @generated
	 */
	Block getFinalClause();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IfStatement#getFinalClause <em>Final Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Clause</em>' containment reference.
	 * @see #getFinalClause()
	 * @generated
	 */
	void setFinalClause(Block value);

	/**
	 * Returns the value of the '<em><b>Is Assured</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether at least one condition in the if statement is assured to evaluate
	 * to true.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Assured</em>' attribute.
	 * @see #setIsAssured(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIfStatement_IsAssured()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SwitchStatement'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SwitchStatement'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'assured\')'"
	 * @generated
	 */
	boolean isIsAssured();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IfStatement#isIsAssured <em>Is Assured</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Assured</em>' attribute.
	 * @see #isIsAssured()
	 * @generated
	 */
	void setIsAssured(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Determinate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether at most one condition in the if statement will ever to evaluate
	 * to true.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Determinate</em>' attribute.
	 * @see #setIsDeterminate(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIfStatement_IsDeterminate()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'determinate\')'"
	 * @generated
	 */
	boolean isIsDeterminate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IfStatement#isIsDeterminate <em>Is Determinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Determinate</em>' attribute.
	 * @see #isIsDeterminate()
	 * @generated
	 */
	void setIsDeterminate(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        let blocks =\n                          if self.finalClause = null then self.nonFinalClauses.clause.body\n                          else self.nonFinalClauses.clause.body->including(self.finalClause)\n                          endif\n                        in\n                          self.updateAll(\n                            self.Statement_assignmentsAfter(), \n                            self.mergeAssignments(blocks->asBag())\n                        )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before all the non-final clauses of an if statement are
	 * the same as the assignments before the if statement. If the statement has
	 * a final clause, then the assignments before that clause are also the same
	 * as the assignments before the if statement.
	 * (See assignmentBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ifStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If an if statement does not have a final else clause, then any name that
	 * is not an out parameter and is unassigned before the if statement is
	 * unassigned after the if statement. If an if statement does have a final
	 * else clause, then any name that is unassigned before the if statement and
	 * is assigned after any one clause of the if statement must also be assigned
	 * after every other clause. The type of such names after the if statement is
	 * the effective common ancestor of the types of the name in each clause with
	 * a multiplicity lower bound that is the minimum of the lower bound for the
	 * name in each clause and a multiplicity upper bound that is the maximum for
	 * the name in each clause. For a name that has an assigned source after any
	 * clause of an if statement that is different than before that clause, then
	 * the assigned source after the if statement is the if statement. Otherwise,
	 * the assigned source of a name after the if statement is the same as before
	 * the if statement.
	 * (See assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ifStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enclosing statement of all the statements in the bodies of all
	 * non-final clauses and in the final clause (if any) of an if statement is
	 * the if statement.
	 * (See SyntaxElement::enclosingStatement() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ifStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An if statement is assured if it has an @assured annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ifStatementIsAssuredDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An if statement is determinate if it has an @determinate annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ifStatementIsDeterminateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to an @isolated annotation, an if statement may have @assured
	 * and @determinate annotations. They may not have arguments.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Statement_annotationAllowed(annotation) or\n                  (annotation.identifier = \'assured\' or annotation.identifier = \'determinate\') and \n                    annotation.argument->isEmpty()'"
	 * @generated
	 */
	boolean annotationAllowed(Annotation annotation);

} // IfStatement
