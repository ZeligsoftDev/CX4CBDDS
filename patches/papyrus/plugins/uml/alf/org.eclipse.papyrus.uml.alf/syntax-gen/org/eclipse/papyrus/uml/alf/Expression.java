/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model of the common properties derived for any Alf expression.
 * NOTE: The derivations for all properties of Expression except
 * AssignmentsAfter are specific to its various subclasses.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Expression#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.Expression#getAssignmentAfter <em>Assignment After</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends AssignableElement {
	/**
	 * Returns the value of the '<em><b>Assignment Before</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically before this
	 * expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment Before</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExpression_AssignmentBefore()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentBefore();

	/**
	 * Returns the value of the '<em><b>Assignment After</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically after this
	 * expression. This includes not only any assignments made within the
	 * expression, but also any assignments that are unchanged from before the
	 * expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment After</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getExpression_AssignmentAfter()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.updateAssignmentsCached()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ExpressionReference{expression = self}'"
	 * @generated
	 */
	ExpressionReference reference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the assigned sources for assignments made within this expression.
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
	 * Returns the assignments from before this expression updated for any
	 * assignments made in the expression. By default, this is the same set as
	 * the assignments before the expression. This operation is redefined only
	 * in subclasses of Expression for kinds of expressions that make assignments.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Expression_updateAssignments()'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentBefore'"
	 * @generated
	 */
	EList<AssignedSource> Expression_updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<AssignedSource> updateAssignmentsCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return the assigned source element for the given name before this
	 * expression, if any.
	 * <!-- end-model-doc -->
	 * @model nameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignment = self.assignmentBefore->select(a | a.name = name) in\n          if assignment->isEmpty() then null\n          else assignment->any(true).source\n          endif'"
	 * @generated
	 */
	SyntaxElement resolve(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return whether the given expression is the first argument of an
	 * invocation of CollectionFunctions::add. This is false by default and
	 * is overidden for relevant invocation expressions.
	 * <!-- end-model-doc -->
	 * @model required="true" targetExpressionRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='false'"
	 * @generated
	 */
	boolean isAddTarget(Expression targetExpression);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after an expression are given by the result of the
	 * updateAssignments helper operation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean expressionAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No name may be assigned more than once before or after an expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentBefore->isUnique(name) and self.assignmentAfter->isUnique(name)'"
	 * @generated
	 */
	boolean expressionUniqueAssignments(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Expression
