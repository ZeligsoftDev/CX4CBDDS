/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit String Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.BitStringUnaryExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBitStringUnaryExpression()
 * @model
 * @generated
 */
public interface BitStringUnaryExpression extends UnaryExpression {
	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether BitString conversion is required on the operand expression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getBitStringUnaryExpression_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isIntegerType(self.operand.type)'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.BitStringUnaryExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #isIsBitStringConversion()
	 * @generated
	 */
	void setIsBitStringConversion(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.bitStringType()'"
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
	 * A BitString unary expression has type BitString.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean bitStringUnaryExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A BitString unary expression has the same multiplicity lower bound as its
	 * operand expression.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean bitStringUnaryExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A BitString unary expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean bitStringUnaryExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expression of a BitString unary expression must have type
	 * BitString or Integer and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                let operandType = self.operand.type in\n                  (self.isBitStringType(operandType) or self.isIntegerType(operandType)) and\n                  self.operand.upper = 1'"
	 * @generated
	 */
	boolean bitStringUnaryExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BitString conversion is required if the operand expression of a BitString
	 * unary expression has type Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean bitStringUnaryExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BitStringUnaryExpression
