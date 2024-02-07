/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A clause in a switch statement with a set of cases and a sequence of
 * statements that may be executed if one of the cases matches the switch value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchClause#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SwitchClause#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchClause()
 * @model
 * @generated
 */
public interface SwitchClause extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expressions to be evaluated to provide values to test against the switch value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Case</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchClause_Case()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getCase();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of statements that may be executed if one of the cases matches the switch value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSwitchClause_Block()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SwitchClause#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                                if self.block <> element then \n                                  self.assignmentsBefore()\n                                else\n                                  self.updateAll(\n                                    self.assignmentsBefore(),\n                                    self.case.newAssignments()->asSet()\n                                  )\n                                endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before a switch clause are the assignments before any
	 * case expression of the clause.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.SyntaxElement_assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a switch clause are the assignments after the block
	 * of the switch clause.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.block.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before any case expression of a switch clause are the
	 * same as the assignments before the clause. The assignments before the
	 * block of a switch clause are the assignments after all case expressions.
	 * (See assignmentsBefore(element) operation.)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean switchClauseAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name is unassigned before a switch clause, then it must be
	 * unassigned after all case expressions of the clause (i.e., new local
	 * names may not be defined in case expressions).
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentsBefore().name->includesAll(self.case.assignmentAfter.name)'"
	 * @generated
	 */
	boolean switchClauseCaseLocalNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the case expressions of a switch clause must have a multiplicity
	 * no greater than 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.case->forAll(upper <= 1)'"
	 * @generated
	 */
	boolean switchClauseCases(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SwitchClause
