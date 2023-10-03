/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Increment Or Decrement Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A unary expression with either an increment or decrement operator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsPrefix <em>Is Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsFeature <em>Is Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsIndexed <em>Is Indexed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsDataValueUpdate <em>Is Data Value Update</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression()
 * @model
 * @generated
 */
public interface IncrementOrDecrementExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the operand is a name, then the new assigned source for that name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment</em>' reference.
	 * @see #setAssignment(AssignedSource)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_Assignment()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.isFeature then null\n        else\n          let assignments = \n            self.assignmentBefore->select(name = self.operand.localName()) in\n            if assignments->isEmpty() then null\n            else assignments->any(true).copy(self, null)\n            endif\n        endif'"
	 * @generated
	 */
	AssignedSource getAssignment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getAssignment <em>Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' reference.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(AssignedSource value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand, which must have the form of an assignment left-hand side.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(LeftHandSide)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_Operand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LeftHandSide getOperand();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(LeftHandSide value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effective expression used to obtain the original value of the operand
	 * to be updated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_Expression()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operand.expression()'"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the operand is a feature, then the referent for that feature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_Feature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if not self.isFeature then null\n        else self.operand.referent()\n        endif'"
	 * @generated
	 */
	ElementReference getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Prefix</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operator is being used as a prefix or a postfix.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Prefix</em>' attribute.
	 * @see #setIsPrefix(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_IsPrefix()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsPrefix <em>Is Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Prefix</em>' attribute.
	 * @see #isIsPrefix()
	 * @generated
	 */
	void setIsPrefix(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operand is a feature or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Feature</em>' attribute.
	 * @see #setIsFeature(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_IsFeature()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operand.feature() <> null'"
	 * @generated
	 */
	boolean isIsFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsFeature <em>Is Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Feature</em>' attribute.
	 * @see #isIsFeature()
	 * @generated
	 */
	void setIsFeature(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Indexed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operand has an index or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Indexed</em>' attribute.
	 * @see #setIsIndexed(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_IsIndexed()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operand.index() <> null'"
	 * @generated
	 */
	boolean isIsIndexed();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsIndexed <em>Is Indexed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Indexed</em>' attribute.
	 * @see #isIsIndexed()
	 * @generated
	 */
	void setIsIndexed(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Data Value Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this expression updates an attribute of a data value held in a
	 * local name or parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Data Value Update</em>' attribute.
	 * @see #setIsDataValueUpdate(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_IsDataValueUpdate()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operand.isDataValueUpdate()'"
	 * @generated
	 */
	boolean isIsDataValueUpdate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#isIsDataValueUpdate <em>Is Data Value Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Data Value Update</em>' attribute.
	 * @see #isIsDataValueUpdate()
	 * @generated
	 */
	void setIsDataValueUpdate(boolean value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The increment ("++") or decrement ("--") operator for this expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIncrementOrDecrementExpression_Operator()
	 * @model
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.integerType()'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.operand.lower'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='1'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the operand of an increment or decrement expression is a name, then
	 * the assignment for the expression is a new assigned source for the name
	 * with the expression as the source.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionAssignmentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression has a feature as its operand if the
	 * operand is a kind of FeatureLeftHandSide.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression is indexed if its operand is indexed.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionIsIndexedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression is a data value update if its
	 * operand is an attribute of a data value held in a local name or parameter.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionIsDataValueUpdateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the operand of an increment or decrement expression is a feature,
	 * then the referent for the operand.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The effective expression for the operand of an increment or decrement
	 * expression is the operand treated as a name expression, property access
	 * expression or sequence access expression, as appropriate for evaluation
	 * to obtain the original value to be updated.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression has type Integer.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression has the same multiplicity lower
	 * bound as its operand expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An increment or decrement expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression must have type Integer and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isIntegerType(self.operand.type) and self.operand.upper = 1'"
	 * @generated
	 */
	boolean incrementOrDecrementExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the operand of an increment or decrement
	 * expression are the same as those before the increment or decrement
	 * expression.
	 * (See the SyntaxElement::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean incrementOrDecrementExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after an increment and decrement expression include all
	 * those after its operand expression. Further, if the operand expression,
	 * considered as a left hand side, is a local name, then this is reassigned.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                                            let assignment = self.assignment in\n                                              if assignment = null then self.operand.assignmentAfter\n                                              else assignment.update(self.operand.assignmentAfter)\n                                              endif'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // IncrementOrDecrementExpression
