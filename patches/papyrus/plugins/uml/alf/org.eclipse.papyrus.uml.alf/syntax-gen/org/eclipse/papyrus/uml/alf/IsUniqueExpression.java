/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Is Unique Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A sequence expansion expression with a isUnique.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getIsUniqueExpression()
 * @model
 * @generated
 */
public interface IsUniqueExpression extends SequenceExpansionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has the type Boolean.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has a multiplicity lower bound of 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An isUnique expression has a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The argument of an isUnique expression must have a multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isUniqueExpressionExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context);

} // IsUniqueExpression
