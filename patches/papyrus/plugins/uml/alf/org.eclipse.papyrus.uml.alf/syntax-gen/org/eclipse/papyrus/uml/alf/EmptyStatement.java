/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement that has no affect when executed.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getEmptyStatement()
 * @model
 * @generated
 */
public interface EmptyStatement extends Statement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after and empty statement are the same as the assignments before the statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean emptyStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EmptyStatement
