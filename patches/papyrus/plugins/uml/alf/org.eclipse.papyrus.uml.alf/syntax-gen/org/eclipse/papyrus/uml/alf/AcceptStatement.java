/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accept Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement used to accept the receipt of instances of one or more signals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptStatement#getAcceptBlock <em>Accept Block</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptStatement#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AcceptStatement#isIsSimple <em>Is Simple</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptStatement()
 * @model
 * @generated
 */
public interface AcceptStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Accept Block</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AcceptBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One or more blocks for accepting alternate groups of signals.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Accept Block</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptStatement_AcceptBlock()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<AcceptBlock> getAcceptBlock();

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The behavior containing the accept statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Behavior</em>' reference.
	 * @see #setBehavior(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptStatement_Behavior()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.currentScope()'"
	 * @generated
	 */
	ElementReference getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AcceptStatement#getBehavior <em>Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the accept statement is simple or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Simple</em>' attribute.
	 * @see #setIsSimple(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAcceptStatement_IsSimple()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='let acceptBlocks = self.acceptBlock in\n                    acceptBlocks->size() = 1 and acceptBlocks->forAll(block = null)'"
	 * @generated
	 */
	boolean isIsSimple();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AcceptStatement#isIsSimple <em>Is Simple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Simple</em>' attribute.
	 * @see #isIsSimple()
	 * @generated
	 */
	void setIsSimple(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='let assignmentsAfter = self.Statement_assignmentsAfter() in\n                    if self.isSimple then\n                      let acceptBlock : AcceptBlock = self.acceptBlock->any(true) in\n                      let name = acceptBlock.actualName() in\n                        if (name = null) then assignmentsAfter\n                        else \n                          AssignedSource{\n                            name = name,\n                            source = self,\n                            type = self.commonAncestor(acceptBlock.signal),\n                            lower = 1,\n                            upper = 1\n                          }.update(assignmentsAfter)\n                        endif\n                    else\n                      self.mergeAssignments(self.acceptBlock.block)->\n                        iterate(\n                          assignment : AssignedSource; \n                          assignments : Set(AssignedSource) = assignmentsAfter |\n                          if self.acceptBlock.actualName()->includes(assignment.name) then \n                            assignments\n                          else \n                            assignment.update(assignments)\n                          endif\n                        )\n                    endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the behavior for this accept statement is a subunit, then return the
	 * corresponding stub. Note that, if the original behavior is an Alf
	 * activity definition, the "stub" may be an external operation or activity.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	ElementReference effectiveBehavior();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n         let behavior = self.behavior in\n           if behavior = null then null\n           else\n             let stub = behavior.stub() in\n               if stub = null then behavior\n               else stub\n               endif\n           endif'"
	 * @generated
	 */
	ElementReference effectiveBehavior_();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An accept statement can only be used within the definition of an active
	 * behavior or the classifier behavior of an active class.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      let behavior = self.effectiveBehavior() in\n                        behavior <> null and behavior.isActiveBehavior()'"
	 * @generated
	 */
	boolean acceptStatementContext(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing behavior of an accept statement must have receptions for
	 * all signals from all accept blocks of the accept statement. No signal may
	 * be referenced in more than one accept block of an accept statement.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      let signals : Bag(ElementReference) = self.acceptBlock.signal in\n                      let behavior = self.effectiveBehavior() in\n                      let activeClass = \n                        if behavior = null then null \n                        else behavior.activeClass() \n                        endif \n                      in\n                        signals->forAll(s | signals->select(equals(s))->size() = 1) and\n                        (activeClass = null or  -- Let the acceptStatementContext constraint catch a null active class.\n                            signals->forAll(containedIn(self.receivedSignals(activeClass))))'"
	 * @generated
	 */
	boolean acceptStatementSignals(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" ordered="false" activeClassRequired="true"
	 * @generated
	 */
	EList<ElementReference> receivedSignals(ElementReference activeClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" ordered="false" activeClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='activeClass.receptions().signal()'"
	 * @generated
	 */
	EList<ElementReference> receivedSignals_(ElementReference activeClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Any name defined in an accept block of an accept statement must be
	 * unassigned before the accept statement.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      let namesBefore = self.assignmentBefore.name in\n                        self.acceptBlock.actualName()->excludesAll(namesBefore)'"
	 * @generated
	 */
	boolean acceptStatementNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A local name specified in the accept block of a simple accept statement
	 * has the accept statement as its assigned source after the accept statement.
	 * The type of the local name is the effective common ancestor of the specified
	 * signals, if one exists, and it is untyped otherwise.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementSimpleAcceptLocalName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a compound accept statement, a local name defined in an accept block
	 * has the accept block as its assigned source before the block associated
	 * with the accept block. The type of the local name is the effective common
	 * ancestor of the specified signals for that accept clause, if one exists,
	 * and it is untyped otherwise. However, the local name is considered
	 * unassigned after the accept statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementCompoundAcceptLocalName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before any block of an accept statement are the assignments
	 * before the accept statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name is assigned in any block of an accept statement, then the
	 * assigned source of the name after the accept statement is the accept
	 * statement itself.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name is unassigned before an accept statement and assigned in any
	 * block of an accept statement, then it must be assigned in every block.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      if self.acceptBlock->size() = 1 then true\n                      else\n                        let namesBefore = self.assignmentBefore.name in\n                        let newNames : Bag(String) = \n                          self.acceptBlock.block.newAssignments().name in\n                          newNames->forAll(name | \n                            namesBefore->excludes(name) implies \n                            newNames->count(name) = self.acceptBlock->size()\n                          )\n                      endif'"
	 * @generated
	 */
	boolean acceptStatementNewAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An accept statement is simple if it has exactly one accept block and that
	 * accept block does not have a block.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementIsSimpleDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enclosing statement for all statements in the blocks of all accept
	 * blocks of an accept statement is the accept statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean acceptStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

} // AcceptStatement
