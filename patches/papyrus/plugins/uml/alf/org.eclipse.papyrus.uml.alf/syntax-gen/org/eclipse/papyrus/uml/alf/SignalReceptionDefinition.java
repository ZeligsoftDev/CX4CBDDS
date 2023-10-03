/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Reception Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of both a signal and a reception of that signal as a feature of the containing active class.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSignalReceptionDefinition()
 * @model
 * @generated
 */
public interface SignalReceptionDefinition extends SignalDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='true'"
	 * @generated
	 */
	boolean isFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A signal reception definition is a feature.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean signalReceptionDefinitionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SignalReceptionDefinition
