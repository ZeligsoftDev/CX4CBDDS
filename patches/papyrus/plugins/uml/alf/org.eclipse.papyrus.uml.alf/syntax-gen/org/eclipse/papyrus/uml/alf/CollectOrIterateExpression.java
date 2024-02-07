/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collect Or Iterate Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sequence expansion expression with a collect or iterate operation.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getCollectOrIterateExpression()
 * @model
 * @generated
 */
public interface CollectOrIterateExpression extends SequenceExpansionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has the same type as its argument expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has a multiplicity lower bound that is the product of the bounds of its primary and argument expressions.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collect or iterate expression has a multiplicity upper bound that is the product of the bounds of its primary and argument expressions.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean collectOrIterateExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollectOrIterateExpression
