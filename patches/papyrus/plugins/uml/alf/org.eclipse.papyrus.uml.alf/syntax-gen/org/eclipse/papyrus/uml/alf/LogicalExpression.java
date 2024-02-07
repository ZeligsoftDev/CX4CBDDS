/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A binary expression with a logical operator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitWise <em>Is Bit Wise</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitStringConversion1 <em>Is Bit String Conversion1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitStringConversion2 <em>Is Bit String Conversion2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLogicalExpression()
 * @model
 * @generated
 */
public interface LogicalExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Is Bit Wise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is a bit-wise logical operation on bit strings.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit Wise</em>' attribute.
	 * @see #setIsBitWise(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLogicalExpression_IsBitWise()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SequenceConstructionExpression'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SequenceConstructionExpression'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='not self.isBooleanType(self.operand1.type)'"
	 * @generated
	 */
	boolean isIsBitWise();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitWise <em>Is Bit Wise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit Wise</em>' attribute.
	 * @see #isIsBitWise()
	 * @generated
	 */
	void setIsBitWise(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the first operand expression requires BitString conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion1</em>' attribute.
	 * @see #setIsBitStringConversion1(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLogicalExpression_IsBitStringConversion1()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isIntegerType(self.operand1.type)'"
	 * @generated
	 */
	boolean isIsBitStringConversion1();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitStringConversion1 <em>Is Bit String Conversion1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion1</em>' attribute.
	 * @see #isIsBitStringConversion1()
	 * @generated
	 */
	void setIsBitStringConversion1(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Bit String Conversion2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the second operand expression requires BitString conversion.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Bit String Conversion2</em>' attribute.
	 * @see #setIsBitStringConversion2(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLogicalExpression_IsBitStringConversion2()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SequenceConstructionExpression'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SequenceConstructionExpression'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.isIntegerType(self.operand2.type)'"
	 * @generated
	 */
	boolean isIsBitStringConversion2();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LogicalExpression#isIsBitStringConversion2 <em>Is Bit String Conversion2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bit String Conversion2</em>' attribute.
	 * @see #isIsBitStringConversion2()
	 * @generated
	 */
	void setIsBitStringConversion2(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isBitWise then self.bitStringType()\n        else self.booleanType()\n        endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.operand1.lower = 0 or self.operand2.lower = 0 then 0 else 1 endif'"
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
	 * A logical expression has type Boolean if it is not bit-wise and type
	 * BitString if it is bit-wise.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A logical expression has a multiplicity lower bound of 0 if the lower
	 * bound if either operand expression is 0 and 1 otherwise.annotation
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A logical expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operands of a logical expression must have type Boolean, Integer or
	 * BitString. However, if one of the operands is Boolean, then the other
	 * must also be Boolean.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type1 = self.operand1.type in\n        let type2 = self.operand2.type in\n          self.isBooleanType(type1) and self.isBooleanType(type2) or\n          (self.isIntegerType(type1) or self.isBitStringType(type1)) and\n            (self.isIntegerType(type2) or self.isBitStringType(type2))'"
	 * @generated
	 */
	boolean logicalExpressionOperands(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BitString conversion is required if the first operand expression of a
	 * logical expression has type Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionIsBitStringConversion1Derivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BitString conversion is required if the second operand expression of a
	 * logical expression has type Integer.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionIsBitStringConversion2Derivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A logical expression is bit-wise if the type of its first operand is not
	 * Boolean.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean logicalExpressionIsBitWiseDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // LogicalExpression
