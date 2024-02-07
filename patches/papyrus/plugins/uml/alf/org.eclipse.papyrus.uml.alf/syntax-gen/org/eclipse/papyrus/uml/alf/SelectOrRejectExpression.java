/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Or Reject Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sequence expansion expression with a select or reject operation.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSelectOrRejectExpression()
 * @model
 * @generated
 */
public interface SelectOrRejectExpression extends SequenceExpansionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A select or reject expression has the same type as its primary expression.
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
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean selectOrRejectExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of a select or reject expression must have type Boolean and a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean selectOrRejectExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SelectOrRejectExpression
