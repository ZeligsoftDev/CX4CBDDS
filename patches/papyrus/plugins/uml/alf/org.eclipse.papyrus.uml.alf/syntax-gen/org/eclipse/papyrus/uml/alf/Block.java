/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A grouped sequence of statements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Block#getStatement <em>Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Block#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Block#getAssignmentBefore <em>Assignment Before</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AnnotatedStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered sequence of statements in the block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBlock_Statement()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotatedStatement> getStatement();

	/**
	 * Returns the value of the '<em><b>Assignment After</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically after this block.
	 * This includes not only any assignments made within the block, but also
	 * any assignments that are unchanged from before the block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment After</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBlock_AssignmentAfter()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                  if self.statement->isEmpty() then self.assignmentBefore\n                  else self.statement->last().statement.assignmentAfter\n                  endif'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentAfter();

	/**
	 * Returns the value of the '<em><b>Assignment Before</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically before this block.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment Before</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBlock_AssignmentBefore()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentBefore();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n    if not self.statement->includes(element) then Set(AssignedSource){}\n    else\n      let i = self.statement->indexOf(element) in\n        if i = 1 then self.assignmentBefore\n        else \n          let statementBefore = self.statement->at(i-1) in\n            -- NOTE: Xtext editor will try to semantically validate even\n            -- when there are syntax errors.\n            if statementBefore.statement = null then\n              self.assignmentsBefore(statementBefore)\n            else\n              statementBefore.statement.assignmentAfter\n            endif\n        endif\n    endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the assigned sources for assignments made within this block.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignmentsBefore = self.assignmentBefore in\n          self.assignmentAfter->select(isNew(assignmentsBefore))'"
	 * @generated
	 */
	EList<AssignedSource> newAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before each statement in a block other than the first are
	 * the same as the assignments after the previous statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean blockAssignmentsBeforeStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the first statement of a block are the same as the
	 * assignments before the block.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean blockAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a block is not empty, then the assignments after the block are the same
	 * as the assignments after the last statement of the block. Otherwise they
	 * are the same as the assignments before the block.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean blockAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Block
