/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model of an Alf statement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Statement#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Statement#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Statement#getEnclosingStatement <em>Enclosing Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Statement#isIsIsolated <em>Is Isolated</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStatement()
 * @model abstract="true"
 * @generated
 */
public interface Statement extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Assignment Before</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically before this statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment Before</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStatement_AssignmentBefore()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentBefore();

	/**
	 * Returns the value of the '<em><b>Assignment After</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically after this statement.
	 * This includes not only any assignments made within the statement, but also
	 * any assignments that are unchanged from before the statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment After</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStatement_AssignmentAfter()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsAfterCached()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentAfter();

	/**
	 * Returns the value of the '<em><b>Enclosing Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statement immediately enclosing this statement, if any.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enclosing Statement</em>' reference.
	 * @see #setEnclosingStatement(Statement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStatement_EnclosingStatement()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.enclosingStatement()'"
	 * @generated
	 */
	Statement getEnclosingStatement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Statement#getEnclosingStatement <em>Enclosing Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosing Statement</em>' reference.
	 * @see #getEnclosingStatement()
	 * @generated
	 */
	void setEnclosingStatement(Statement value);

	/**
	 * Returns the value of the '<em><b>Is Isolated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this statement should be executed in isolation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Isolated</em>' attribute.
	 * @see #setIsIsolated(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getStatement_IsIsolated()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'isolated\')'"
	 * @generated
	 */
	boolean isIsIsolated();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.Statement#isIsIsolated <em>Is Isolated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Isolated</em>' attribute.
	 * @see #isIsIsolated()
	 * @generated
	 */
	void setIsIsolated(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the nearest enclosing loop statement, or this statement, if it is
	 * a loop statement. (This operation is overridden for loop statements.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='let enclosingStatement = self.enclosingStatement() in\n        if enclosingStatement = null then null\n        else enclosingStatement.enclosingLoopStatement()\n        endif'"
	 * @generated
	 */
	Statement enclosingLoopStatement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the given annotation is allowed for this kind of statement.
	 * By default, only an @isolated annotation is allowed, with no arguments.
	 * This operation is redefined only in subclasses of Statement for kinds of
	 * statements that allow different annotations than this default.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Statement_annotationAllowed(annotation)'"
	 * @generated
	 */
	boolean annotationAllowed(Annotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='annotation.identifier = \'isolated\' and annotation.argument->isEmpty()'"
	 * @generated
	 */
	boolean Statement_annotationAllowed(Annotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let container = self.oclContainer() in\n              if container = null or not container.oclIsKindOf(AnnotatedStatement) then\n                Set(Annotation){}\n              else\n                container.oclAsType(AnnotatedStatement).annotations()->collect(a |\n                  Annotation{text = a}->asSet()\n                )->asSet()\n              endif'"
	 * @generated
	 */
	EList<Annotation> annotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.annotation()->exists(identifier = name)'"
	 * @generated
	 */
	boolean hasAnnotation(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the assigned sources for assignments made within this statement.
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
	 * Return the source of the given local name in the assignments before this
	 * statement, if any.
	 * <!-- end-model-doc -->
	 * @model nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let assignment = self.assignmentBefore->select(a | a.name = name) in\n              if assignment->isEmpty() then null\n              else assignment->any(true).source\n              endif'"
	 * @generated
	 */
	SyntaxElement resolve(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * By default, the assignments after are the same as the assignments
	 * before.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Statement_assignmentsAfter()'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentBefore'"
	 * @generated
	 */
	EList<AssignedSource> Statement_assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfterCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Merge the assignments made in a collection of blocks, such as occur in an
	 * accept or if statement.
	 * <!-- end-model-doc -->
	 * @model ordered="false" blocksUnique="false" blocksMany="true" blocksOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n             let newAssignments = blocks->collect(b | \n               if b = null then Set(AssignedSource){}\n               else b.assignmentAfter->select(isNew(b.assignmentBefore))\n               endif\n             )->asSet() in\n               newAssignments.name->asSet()->collect(n | \n                 self.merge(n, newAssignments->select(name = n))\n               )->asSet()'"
	 * @generated
	 */
	EList<AssignedSource> mergeAssignments(EList<Block> blocks);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true" assignmentsMany="true" assignmentsOrdered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n             AssignedSource{\n               name = name,\n               source = self,\n               type = self.commonAncestor(assignments.type->asSet()),\n               lower = assignments.lower->min(),\n               upper = \n                if assignments.upper->exists(n | n = -1) then -1\n                else assignments.upper->max()\n                endif\n             }'"
	 * @generated
	 */
	AssignedSource merge(String name, EList<AssignedSource> assignments);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the annotations of a statement must be allowed, as given by the annotationAllowed operation for the statement.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.annotation()->forAll(a | self.annotationAllowed(a))'"
	 * @generated
	 */
	boolean statementAnnotationsAllowed(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No name may be assigned more than once before or after a statement.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentBefore->isUnique(name) and self.assignmentAfter->isUnique(name)'"
	 * @generated
	 */
	boolean statementUniqueAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A statement is isolated if it has an @isolated annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean statementIsIsolatedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Statement
