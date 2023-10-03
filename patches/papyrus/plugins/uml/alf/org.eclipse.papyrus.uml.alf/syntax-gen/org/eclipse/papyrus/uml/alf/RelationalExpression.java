/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A binary expression with a relational operator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.RelationalExpression#isIsUnlimitedNatural <em>Is Unlimited Natural</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Is Unlimited Natural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this is an UnlimitedNatural comparison.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Unlimited Natural</em>' attribute.
	 * @see #setIsUnlimitedNatural(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getRelationalExpression_IsUnlimitedNatural()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n\t\t\t\tlet type1 = self.operand1.type in\n\t\t\t\t\tself.isUnlimitedNaturalType(type1) and not self.isNaturalType(type1) or \n\t\t\t\tlet type2 = self.operand2.type in\n\t\t\t\t\tself.isUnlimitedNaturalType(type2) and not self.isNaturalType(type2)'"
	 * @generated
	 */
	boolean isIsUnlimitedNatural();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.RelationalExpression#isIsUnlimitedNatural <em>Is Unlimited Natural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unlimited Natural</em>' attribute.
	 * @see #isIsUnlimitedNatural()
	 * @generated
	 */
	void setIsUnlimitedNatural(boolean value);

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
	 * A relational expression is an UnlimitedNatural comparison if either one
	 * of its operands has type UnlimitedNatural.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean relationalExpressionIsUnlimitedNaturalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a relational expression is Boolean.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean relationalExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A relational expression has a multiplicity lower bound of 0 if the lower
	 * bound if either operand expression is 0 and 1 otherwise.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean relationalExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A relational expression has a multiplicity upper bound of 1.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean relationalExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operand expressions for a comparison operator must have type Integer,
	 * UnlimitedNatural or Natural. However, it is not allowed to have one
	 * operand expression be Integer and the other be UnlimitedNatural.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type1 = self.operand1.type in\n        let type2 = self.operand2.type in\n          self.isNaturalType(type1) and self.isNumericType(type2) or\n          self.isIntegerType(type1) and self.isIntegerType(type2) or\n          self.isUnlimitedNaturalType(type1) and self.isUnlimitedNaturalType(type2)'"
	 * @generated
	 */
	boolean relationalExpressionOperandTypes(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelationalExpression
