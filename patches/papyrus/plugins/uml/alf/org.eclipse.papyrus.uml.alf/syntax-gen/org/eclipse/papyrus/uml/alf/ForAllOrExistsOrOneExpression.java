/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For All Or Exists Or One Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sequence expansion expression with a forAll, exists or one operation.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getForAllOrExistsOrOneExpression()
 * @model
 * @generated
 */
public interface ForAllOrExistsOrOneExpression extends SequenceExpansionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A forAll, exists or one expression has the type Boolean.
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
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of a forAll, exists or one expression must have type Boolean and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean forAllOrExistsOrOneExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ForAllOrExistsOrOneExpression
