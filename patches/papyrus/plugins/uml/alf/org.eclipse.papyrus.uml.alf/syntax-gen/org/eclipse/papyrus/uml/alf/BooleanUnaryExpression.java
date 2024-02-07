/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A unary expression with a Boolean operator.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBooleanUnaryExpression()
 * @model
 * @generated
 */
public interface BooleanUnaryExpression extends UnaryExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.booleanType()'"
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
	 * A Boolean unary expression has type Boolean.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean booleanUnaryExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Boolean unary expression has the same multiplicity lower bound
	 * as its operand expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean booleanUnaryExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Boolean unary expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean booleanUnaryExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression of a Boolean unary expression must have type
	 * Boolean and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isBooleanType(self.operand.type) and self.operand.upper = 1'"
	 * @generated
	 */
	boolean booleanUnaryExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BooleanUnaryExpression
