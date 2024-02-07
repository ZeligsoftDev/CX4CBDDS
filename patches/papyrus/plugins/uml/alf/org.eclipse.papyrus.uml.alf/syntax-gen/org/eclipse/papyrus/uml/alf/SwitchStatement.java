/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement that executes (at most) one of a set of statement sequences
 * based on matching a switch value to a set of test cases.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchStatement#getNonDefaultClause <em>Non Default Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchStatement#getDefaultClause <em>Default Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchStatement#isIsAssured <em>Is Assured</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchStatement#isIsDeterminate <em>Is Determinate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Non Default Clause</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.SwitchClause}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of switch clauses whose cases are to be tested against the switch
	 * value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Non Default Clause</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement_NonDefaultClause()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SwitchClause> getNonDefaultClause();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to provide the switch value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SwitchStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Default Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence of statements to be executed if no switch clause case matches
	 * the switch value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Clause</em>' containment reference.
	 * @see #setDefaultClause(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement_DefaultClause()
	 * @model containment="true"
	 * @generated
	 */
	Block getDefaultClause();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SwitchStatement#getDefaultClause <em>Default Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Clause</em>' containment reference.
	 * @see #getDefaultClause()
	 * @generated
	 */
	void setDefaultClause(Block value);

	/**
	 * Returns the value of the '<em><b>Is Assured</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether at least one case in the switch statement is assured to match.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Assured</em>' attribute.
	 * @see #setIsAssured(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement_IsAssured()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'assured\')'"
	 * @generated
	 */
	boolean isIsAssured();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SwitchStatement#isIsAssured <em>Is Assured</em>}' attribute.
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
	 * Whether at most one case in the if statement will ever to match.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Determinate</em>' attribute.
	 * @see #setIsDeterminate(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchStatement_IsDeterminate()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'determinate\')'"
	 * @generated
	 */
	boolean isIsDeterminate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SwitchStatement#isIsDeterminate <em>Is Determinate</em>}' attribute.
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
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                            if self.nonDefaultClause->includes(element) or \n                              self.defaultClause = element then\n                              self.expression.assignmentAfter\n                            else\n                              self.assignmentBefore\n                            endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                            let blocks =\n                              if self.defaultClause = null then\n                                self.nonDefaultClause.block\n                              else\n                                self.nonDefaultClause.block->including(self.defaultClause)\n                              endif\n                            in\n                              self.updateAll(\n                                self.Statement_assignmentsAfter(),\n                                self.mergeAssignments(blocks)\n                              )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before all clauses of a switch statement are the same as
	 * the assignments after the expression of the switch statement.
	 * (See assignmentBefore(element) expression.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The same local name may not be assigned in more than one case expression
	 * in a switch statement.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                            self.nonDefaultClause.case.newAssignments()->isUnique(name)'"
	 * @generated
	 */
	boolean switchStatementCaseAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name has an assigned source after any clause of a switch statement
	 * that is different than before that clause (including newly defined names),
	 * the assigned source after the switch statement is the switch statement.
	 * Otherwise, the assigned source of a name after the switch statement is
	 * the same as before the switch statement.
	 * (See assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a switch statement does not have a final default clause, then any name
	 * that is not an out parameter and is unassigned before the switch statement
	 * is unassigned after the switch statement. If a switch statement does have
	 * a final default clause, then any name that is unassigned before the switch
	 * statement and is assigned after any one clause of the switch statement
	 * must also be assigned after every other clause. The type of such names
	 * after the switch statement is the effective common ancestor of the types
	 * of the name in each clause with a multiplicity lower bound that is the
	 * minimum of the lower bound for the name in each clause and a multiplicity
	 * upper bound that is the maximum for the name in each clause.
	 * (See also assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                            let newNames = self.assignmentAfter.name->excludingAll(self.assignmentBefore.name) in\n\t                            if self.defaultClause = null then\n\t                              newNames->isEmpty()\n\t                            else\n\t                              self.nonDefaultClause.block->including(self.defaultClause)->forAll(\n\t                              \tassignmentAfter.name->includesAll(newNames)\n\t                              )\n\t                            endif'"
	 * @generated
	 */
	boolean switchStatementAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A switch statement expression must have a multiplicity no greater than 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression.upper <= 1'"
	 * @generated
	 */
	boolean switchStatementExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A switch statement is the enclosing statement for the statements in all
	 * of its switch clauses.
	 * (See SyntaxElement::enclosingStatement() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A switch statement is determinate if it has a @determinate annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchStatementIsDeterminateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A switch statement is assured if it has an @assured annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchStatementIsAssuredDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to an @isolated annotation, a switch statement may have
	 * @assured and @determinate annotations. They may not have arguments.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Statement_annotationAllowed(annotation) or\n                  (annotation.identifier = \'assured\' or annotation.identifier = \'determinate\') and \n                    annotation.argument->isEmpty()'"
	 * @generated
	 */
	boolean annotationAllowed(Annotation annotation);

} // SwitchStatement
