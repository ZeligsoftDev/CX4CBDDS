/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Expansion Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to carry out one of a predefined set of operations over each of the elements in a sequence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getVariableSource <em>Variable Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsSelectOrReject <em>Is Select Or Reject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsCollectOrIterate <em>Is Collect Or Iterate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsForAllOrExistsOrOne <em>Is For All Or Exists Or One</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsIsUnique <em>Is Is Unique</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression()
 * @model
 * @generated
 */
public interface SequenceExpansionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the operation to be carried out.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_Operation()
	 * @model required="true"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the expansion variable available as a local name within the
	 * argument expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_Variable()
	 * @model required="true"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

	/**
	 * Returns the value of the '<em><b>Variable Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned source for the expansion variable within the argument
	 * expression. The source is actually the sequence expansion expression
	 * itself.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Source</em>' reference.
	 * @see #setVariableSource(AssignedSource)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_VariableSource()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let expression = self.primary.expression in\n          AssignedSource{\n              name = variable,\n              source = self,\n              type = if expression = null then null else expression.type endif,\n              lower = 1,\n              upper = 1\n          }'"
	 * @generated
	 */
	AssignedSource getVariableSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getVariableSource <em>Variable Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Source</em>' reference.
	 * @see #getVariableSource()
	 * @generated
	 */
	void setVariableSource(AssignedSource value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument expression. The exact form required for this expression
	 * depends on which expansion operation is being carried out.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference.
	 * @see #setArgument(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_Argument()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getArgument <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' containment reference.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(Expression value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The class name or primary expression that evaluates to the sequence to
	 * be acted on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary</em>' containment reference.
	 * @see #setPrimary(ExtentOrExpression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_Primary()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExtentOrExpression getPrimary();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#getPrimary <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' containment reference.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(ExtentOrExpression value);

	/**
	 * Returns the value of the '<em><b>Is Select Or Reject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Select Or Reject</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Select Or Reject</em>' attribute.
	 * @see #setIsSelectOrReject(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_IsSelectOrReject()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'select\' or self.operation = \'reject\''"
	 * @generated
	 */
	boolean isIsSelectOrReject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsSelectOrReject <em>Is Select Or Reject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Select Or Reject</em>' attribute.
	 * @see #isIsSelectOrReject()
	 * @generated
	 */
	void setIsSelectOrReject(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Collect Or Iterate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Collect Or Iterate</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Collect Or Iterate</em>' attribute.
	 * @see #setIsCollectOrIterate(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_IsCollectOrIterate()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'collect\' or self.operation = \'iterate\''"
	 * @generated
	 */
	boolean isIsCollectOrIterate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsCollectOrIterate <em>Is Collect Or Iterate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collect Or Iterate</em>' attribute.
	 * @see #isIsCollectOrIterate()
	 * @generated
	 */
	void setIsCollectOrIterate(boolean value);

	/**
	 * Returns the value of the '<em><b>Is For All Or Exists Or One</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is For All Or Exists Or One</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is For All Or Exists Or One</em>' attribute.
	 * @see #setIsForAllOrExistsOrOne(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_IsForAllOrExistsOrOne()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'forAll\' or self.operation = \'exists\' or self.operation = \'one\''"
	 * @generated
	 */
	boolean isIsForAllOrExistsOrOne();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsForAllOrExistsOrOne <em>Is For All Or Exists Or One</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is For All Or Exists Or One</em>' attribute.
	 * @see #isIsForAllOrExistsOrOne()
	 * @generated
	 */
	void setIsForAllOrExistsOrOne(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Is Unique</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Is Unique</em>' attribute.
	 * @see #setIsIsUnique(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceExpansionExpression_IsIsUnique()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'isUnique\''"
	 * @generated
	 */
	boolean isIsIsUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceExpansionExpression#isIsIsUnique <em>Is Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Is Unique</em>' attribute.
	 * @see #isIsIsUnique()
	 * @generated
	 */
	void setIsIsUnique(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" elementRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.argument <> element then self.assignmentBefore\n        else\n          self.variableSource.update(self.assignmentsAfterPrimary())\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsBefore(SyntaxElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.primary.expression in\n          if expression = null then self.assignmentBefore\n          else expression.assignmentAfter\n          endif'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfterPrimary();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isSelectOrReject then\n          let expression = self.primary.expression in\n            if expression = null then null else expression.type endif\n        else if self.isCollectOrIterate then\n          if self.argument = null then null else self.argument.type endif\n        else if self.isForAllOrExistsOrOne or self.isIsUnique then\n          self.booleanType()\n        else\n          null\n        endif endif endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isSelectOrReject then 0\n        else if self.isCollectOrIterate then\n          let expression = self.primary.expression in\n            if expression = null or self.argument = null then 0\n            else expression.lower * self.argument.lower\n            endif\n        else if self.isForAllOrExistsOrOne or self.isIsUnique then 1\n        else 0\n        endif endif endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isSelectOrReject then -1\n        else if self.isCollectOrIterate then\n          let expression = self.primary.expression in\n            if expression = null or self.argument = null then 0\n            else \n              let upper1 = expression.upper in\n              let upper2 = self.argument.upper in\n                if upper1 = -1 or upper2 = -1 then -1 else upper1 * upper2 endif\n            endif\n        else if self.isForAllOrExistsOrOne or self.isIsUnique then 1\n        else 0\n        endif endif endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned source for the expansion variable of a sequence expansion
	 * expression is the expression itself. The type for the assignment is the
	 * type of the primary expression of the sequence expansion expression and
	 * the multiplicity lower and upper bounds are 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceExpansionExpressionVariableSourceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the primary expression of a sequence expansion
	 * expression are the same as the assignments before the sequence expansion
	 * expression.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceExpansionExpressionAssignmentsBeforePrimary(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the argument expression of a sequence expansion
	 * expression include those after the primary expression plus one for the
	 * expansion variable.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceExpansionExpressionAssignmentsBeforeArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expansion variable name may not conflict with any name already
	 * assigned after the primary expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        not self.assignmentsAfterPrimary()->exists(name = self.variable)'"
	 * @generated
	 */
	boolean sequenceExpansionExpressionVariableName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after the argument expression of a sequence expansion
	 * expression must be the same as the assignments before the argument
	 * expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.argument <> null implies self.argument.newAssignments()->isEmpty()'"
	 * @generated
	 */
	boolean sequenceExpansionExpressionAssignmentsAfterArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A select or reject expression has the same type as its primary expression.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean selectOrRejectExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A select or reject expression has a multiplicity lower bound of 0.
	 * (See the lower operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean selectOrRejectExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A select or reject expression has a multiplicity upper bound of *.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean selectOrRejectExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of a select or reject expression must have type Boolean and
	 * a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        (self.isSelectOrReject and self.argument <> null) implies\n          self.isBooleanType(self.argument.type) and\n          self.argument.upper = 1'"
	 * @generated
	 */
	boolean selectOrRejectExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has the same type as its argument
	 * expression.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has a multiplicity lower bound that is
	 * the product of the bounds of its primary and argument expressions.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has a multiplicity upper bound that is
	 * the product of the bounds of its primary and argument expressions.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A forAll, exists or one expression has the type Boolean.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A forAll, exists or one expression has a multiplicity lower bound of 1.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A forAll, exists or one expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of a forAll, exists or one expression must have type Boolean
	 * and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n          (self.isForAllOrExistsOrOne and self.argument <> null) implies\n            self.isBooleanType(self.argument.type) and\n            self.argument.upper = 1'"
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has the type Boolean.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has a multiplicity lower bound of 1.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of an isUnique expression must have a multiplicity upper
	 * bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        (self.isIsUnique and self.argument <> null) implies \n          self.argument.upper = 1'"
	 * @generated
	 */
	boolean isUniqueExpressionExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a sequence expansion expression are the same as
	 * after its primary expression.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.assignmentsAfterPrimary()'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      self.isSelectOrReject or self.isCollectOrIterate or \n      self.isForAllOrExistsOrOne or self.isIsUnique'"
	 * @generated
	 */
	boolean sequenceExpansionExpressionOperation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SequenceExpansionExpression
