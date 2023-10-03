/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An invocation expression used to invoke an operation of a superclass.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SuperInvocationExpression#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSuperInvocationExpression()
 * @model
 * @generated
 */
public interface SuperInvocationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the operation to be invoked, optionally qualified with the
	 * name of the appropriate superclass.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSuperInvocationExpression_Target()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SuperInvocationExpression#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let context = self.currentScope().namespace() in\n              if context = null or not context.isClass() then\n                null\n              else\n                let superclasses =\n                  if target = null or target.qualification = null then\n                    context.parents()\n                  else\n                    target.qualification.referent->select(isClass())\n                  endif\n                in\n                  if (target = null or target.qualification <> null) and\n                    superclasses->size() <> 1 then null\n                  else\n                    let name =\n                      if target = null then superclasses->any(true).name()\n                      else target.unqualifiedName.toName()\n                      endif\n                    in\n                      let referents = superclasses.base().members()->\n                        select(isOperation() and name() = name) \n                      in\n                        -- TODO: Handle overloading resolution.\n                        if referents->size() <> 1 then\n                          null\n                        else\n                          referents->any(true)\n                        endif\n                  endif\n              endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let currentScope = self.currentScope() in\n          if currentScope = null then null\n          else if currentScope.isClassifier() and not currentScope.isMethod() and\n            not currentScope.isActiveBehavior() then\n            currentScope\n          else if currentScope.isActiveBehavior() then\n            currentScope.activeClass()\n          else\n            let outerScope = currentScope.namespace() in\n              if outerScope = null or not outerScope.isClassifier() then null\n              else outerScope\n              endif\n          endif endif endif'"
	 * @generated
	 */
	ElementReference context();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent of a super invocation expression is the method behavior of
	 * the operation identified using the overloading resolution rules.
	 * (See the referent() operation. Actually returns the operation, not the
	 * method.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean superInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no feature for a super invocation.
	 * (See the feature() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean superInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target has a qualification, then this must resolve to one of the
	 * superclasses of the current context class.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.target = null or\n        let qualification = self.target.qualification in\n          qualification <> null implies\n            let superclass = qualification.referent->select(isClass()) in\n            let context = self.context() in\n              superclass->size() = 1 and context <> null and\n              superclass->forAll(containedIn(context.parents()->asBag()))'"
	 * @generated
	 */
	boolean superInvocationExpressionQualification(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target is empty, the referent must be the method for a constructor
	 * operation and the context class for the behavior containing the super
	 * invocation expression must have exactly one superclass.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.target = null implies\n          let referent = self.referent in\n          let context = self.context() in\n            referent <> null and referent.isConstructor() and\n            context <> null and context.parents()->size() = 1'"
	 * @generated
	 */
	boolean superInvocationExpressionImplicitTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent is the method of a constructor operation, the super
	 * invocation expression must occur in an expression statement at the start
	 * of the definition for the method of a constructor operation, such that
	 * any statements preceding it are also super constructor invocations.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n        let context = self.context() in\n          referent <> null and referent.isConstructor() and context <> null implies\n          let operation = self.currentScope().specification() in\n            operation.isConstructor() and\n            let statement = self.enclosingStatement() in\n              statement <> null and statement.oclIsKindOf(ExpressionStatement) and\n                let annotatedStatement = statement.owner() in\n                let owner = annotatedStatement.owner() in\n                  owner <> null implies owner.oclIsKindOf(Block) and\n                    let block = owner.oclAsType(Block) in\n                      block.enclosingStatement() = null and\n                      let classReference = referent.namespace() in\n                      let i = block.statement->indexOf(annotatedStatement) in\n                        i = 1 or\n                        block.statement->subOrderedSet(1, i-1).statement->forAll(\n                          oclIsKindOf(ExpressionStatement) and\n                          let expression = oclAsType(ExpressionStatement).expression in\n                            expression.oclIsKindOf(SuperInvocationExpression) and\n                            -- NOTE: This checks to ensure that no previous\n                            -- super-constructor invocation is for the same\n                            -- superclass\n                            not expression.oclAsType(SuperInvocationExpression).\n                              referent.namespace().equals(classReference)\n                        )'"
	 * @generated
	 */
	boolean superInvocationExpressionConstructorCall(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the referent is the method of a destructor operation, the super
	 * invocation expression must occur within the method of a destructor
	 * operation.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          referent <> null and referent.isDestructor() implies\n            let operation = self.currentScope() in\n              operation <> null and operation.isDestructor()'"
	 * @generated
	 */
	boolean superInvocationExpressionDestructorCall(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * It must be possible to identify a single valid operation denoted by the
	 * target of a super invocation expression that satisfies the overloading
	 * resolution rules.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.referent <> null and\n        -- TODO: Remove this check once overloading resolution is implemented.\n        self.tuple.size() <= self.parameterCount() and\n        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))'"
	 * @generated
	 */
	boolean superInvocationExpressionOperation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SuperInvocationExpression
