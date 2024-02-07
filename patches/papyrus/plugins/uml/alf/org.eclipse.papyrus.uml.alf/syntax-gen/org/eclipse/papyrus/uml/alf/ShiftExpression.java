/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ShiftExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getShiftExpression()
 * @model
 * @generated
 */
public interface ShiftExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the first operand expression requires BitString conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion</em>' attribute.
	 * @see #setIsBitStringConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getShiftExpression_IsBitStringConversion()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isIntegerType(self.operand1.type)'"
	 * @generated
	 */
	boolean isIsBitStringConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ShiftExpression#isIsBitStringConversion <em>Is Bit String Conversion</em>}' attribute.
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.operand1.lower = 0 or self.operand2.lower = 0 then 0\n        else 1\n        endif'"
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
	 * A shift expression has type BitString.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean shiftExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A shift expression has a multiplicity lower bound of 0 if the lower bound
	 * if either operand expression is 0 and 1 otherwise.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean shiftExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A shift expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean shiftExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first operand expression of a shift expression must have the type
	 * BitString or Integer. The second operand expression must have the type
	 * Integer.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type1 = self.operand1.type in\n        let type2 = self.operand2.type in\n          (self.isBitStringType(type1) or self.isIntegerType(type1)) and self.isIntegerType(type2)'"
	 * @generated
	 */
	boolean shiftExpressionOperands(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BitString conversion is required if the first operand expression of a
	 * shift expression has type Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean shiftExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ShiftExpression
