/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A looping statement that gives successive values to one or more loop variables on each iteration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ForStatement#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ForStatement#getVariableDefinition <em>Variable Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ForStatement#isIsParallel <em>Is Parallel</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sequence of statements to be iteratively executed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getForStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Variable Definition</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of definitions of one or more loop variables.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Definition</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getForStatement_VariableDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<LoopVariableDefinition> getVariableDefinition();

	/**
	 * Returns the value of the '<em><b>Is Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the for statement is parallel.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Parallel</em>' attribute.
	 * @see #setIsParallel(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getForStatement_IsParallel()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='LoopVariableDefinition'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='LoopVariableDefinition'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.hasAnnotation(\'parallel\')'"
	 * @generated
	 */
	boolean isIsParallel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ForStatement#isIsParallel <em>Is Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Parallel</em>' attribute.
	 * @see #isIsParallel()
	 * @generated
	 */
	void setIsParallel(boolean value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.body <> element then\n          self.assignmentBefore\n        else\n          let assignments = \n            self.variableDefinition.assignmentAfter->asSet() in\n            if not self.isParallel then\n              assignments\n            else\n              let parallelNames = self.parallelNames() in\n                self.updateAll(\n                  assignments,\n                  assignments->select(a | parallelNames->includes(a.name)).\n                    copy(self, true)->asSet()\n                )\n\n            endif\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.variableDefinition->iterate(\n          v, assignments : Set(AssignedSource) = self.assignmentBefore |\n          self.updateAll(assignments, v.newAssignments())\n        )'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfterVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let namesBefore = self.assignmentBefore.name in\n        let newAssignments =\n          self.body.newAssignments()->\n            select(a | namesBefore->includes(a.name)).\n            copy(self, null)->asSet()\n        in\n        let variables = self.variableDefinition.variable in\n        let assignmentsAfter = \n          self.updateAll(\n            self.variableDefinition.assignmentAfter->asSet(), \n            newAssignments\n          )->reject(a | variables->includes(a.name)) in\n        let parallelNames = self.parallelNames() in\n        let parallelNameAssignments =\n          assignmentsAfter->\n            select(a | parallelNames->includes(a.name)).\n            copy(self, false)->asSet()\n        in\n          self.updateAll(assignmentsAfter, parallelNameAssignments)'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isParallel then\n          Set(String){}\n        else\n          self.annotation()->select(identifier = \'parallel\').oclAsType(Annotation).argument->asSet()\n        endif'"
	 * @generated
	 */
	EList<String> parallelNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before a loop variable definition in a for statement are
	 * the same as before the for statement. The assignments before the body of
	 * the statement include all the assignments before the statement plus any
	 * new assignments from the loop variable definitions, except that, if the
	 * statement is parallel, the assigned sources of any names given in @parallel
	 * annotations are changed to be the for statement itself.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The loop variables are unassigned after a for statement. Other than the
	 * loop variables, if the assigned source for a name after the body of a for
	 * statement is the same as after the for variable definitions, then the
	 * assigned source for the name after the for statement is the same as after
	 * the for variable definitions. If a name is unassigned after the for
	 * variable definitions, then it is unassigned after the for statement (even
	 * if it is assigned in the body of the for statement). If, after the loop
	 * variable definitions, a name has an assigned source, and it has a
	 * different assigned source after the body of the for statement, then the
	 * assigned source after the for statement is the for statement itself.
	 * (See the assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A @parallel annotation of a for statement may include a list of names.
	 * Each such name must be already assigned after the loop variable definitions
	 * of the for statement, with a multiplicity of [0..*]. These names may only
	 * be used within the body of the for statement as the first argument to for
	 * the CollectionFunctions::add behavior.
	 * (Note: Checking that @parallel annotation names are only used with add
	 * behaviors is done in NameExpression, BehaviorInvocationExpression and
	 * SequenceOperationExpression.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignments = self.variableDefinition.assignmentAfter in\n          self.parallelNames()->forAll(n |\n            assignments->exists(name = n and lower = 0 and upper = -1)\n          )'"
	 * @generated
	 */
	boolean forStatementParallelAnnotationNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If, after the loop variable definitions of a parallel for statement, a
	 * name has an assigned source, then it must have the same assigned source
	 * after the block of the for statement. Other than for names defined in the
	 * @parallel annotation of the for statement, the assigned source for such
	 * names is the same after the for statement as before it. Any names defined
	 * in the @parallel annotation have the for statement itself as their assigned
	 * source after the for statement. Other than names given in the @parallel
	 * annotation, if a name is unassigned after the loop variable definitions,
	 * then it is considered unassigned after the for statement, even if it is
	 * assigned in the block of the for statement.
	 * (See also the assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.isParallel then true\n        else\n          self.body.newAssignments().name->\n            excludesAll(self.variableDefinition.assignmentAfter.name)\n          /*\n           * The following is guaranteed by assignmentsAfter():\n          let parallelNames = self.parallelNames() in\n            self.assignmentAfter->forAll(a |\n              assignmentsAfterVariables->exists(name = a.name) and\n              if parallelNames->includes(a.name) then a.source = self \n              else a.source = assignmentsAfterVariables->any(name = a.name).source \n              endif\n            )\n          \052/\n        endif'"
	 * @generated
	 */
	boolean forStatementParallelAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The isFirst attribute of the first loop variable definition for a for
	 * statement is true while the isFirst attribute is false for any other
	 * definitions.
	 * (See derivation of VariableDefinition::isFirst.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementVariableDefinitions(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for loop variables after the body of a for statement
	 * must be the for statement (the same as before the body).
	 * (See the assignmentAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementLoopVariables(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A for statement is parallel if it has a @parallel annotation.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementIsParallelDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enclosing statement for all statements in the body of a for statement
	 * are the for statement.
	 * (See the SyntaxElement::enclosingStatement() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In addition to an @isolated annotation, a for statement may have a
	 * @parallel annotation.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.Statement_annotationAllowed(annotation) or\n                  annotation.identifier = \'parallel\''"
	 * @generated
	 */
	boolean annotationAllowed(Annotation annotation);

} // ForStatement
