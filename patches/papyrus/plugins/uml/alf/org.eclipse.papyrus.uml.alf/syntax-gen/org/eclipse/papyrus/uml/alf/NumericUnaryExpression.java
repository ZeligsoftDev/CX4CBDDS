/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A unary expression with a numeric operator.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNumericUnaryExpression()
 * @model
 * @generated
 */
public interface NumericUnaryExpression extends UnaryExpression {
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
	 * A numeric unary expression must have type Integer.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean numericUnaryExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A numeric unary expression has the same multiplicity lower bound as its
	 * operand expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean numericUnaryExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A numeric unary expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean numericUnaryExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression must have type Integer and a multiplicity upper
	 * bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.isIntegerType(self.operand.type) and self.operand.upper = 1'"
	 * @generated
	 */
	boolean numericUnaryExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context);

} // NumericUnaryExpression
