/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reception Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The declaration of the ability of an active class to receive a signal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ReceptionDefinition#getSignalName <em>Signal Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ReceptionDefinition#getSignal <em>Signal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReceptionDefinition()
 * @model
 * @generated
 */
public interface ReceptionDefinition extends MemberDefinition {
	/**
	 * Returns the value of the '<em><b>Signal Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the signal to be received.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signal Name</em>' containment reference.
	 * @see #setSignalName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReceptionDefinition_SignalName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getSignalName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ReceptionDefinition#getSignalName <em>Signal Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal Name</em>' containment reference.
	 * @see #getSignalName()
	 * @generated
	 */
	void setSignalName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signal</em>' reference.
	 * @see #setSignal(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getReceptionDefinition_Signal()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n                        let referents = self.signalName.referent->select(isSignal()) in\n                          if referents->size() = 1 then\n                            referents->any(true)\n                          else\n                            null\n                          endif'"
	 * @generated
	 */
	ElementReference getSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ReceptionDefinition#getSignal <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' reference.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.signalName.unqualifiedName.toName()'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Reception.
	 * <!-- end-model-doc -->
	 * @model required="true" annotationRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                        /* TODO: Allow reception stereoype annotations. \052/\n                        false'"
	 * @generated
	 */
	boolean annotationAllowed(StereotypeAnnotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return true if the given member is either a ReceptionDefinition, a SignalReceptionDefinition or an
	 * imported member whose referent is a ReceptionDefinition, a SignalReceptionDefinition or a Reception.
	 * <!-- end-model-doc -->
	 * @model required="true" memberRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='member.isReception()'"
	 * @generated
	 */
	boolean isSameKindAs(ElementReference member);

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
	 * The signal name for a reception definition must have a single referent that is a signal. This referent must not be a template.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                      self.signal <> null and not self.signal.isTemplate()'"
	 * @generated
	 */
	boolean receptionDefinitionSignalName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The signal for a reception definition is the signal referent of the signal name for the reception definition.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean receptionDefinitionSignalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reception definition is a feature.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean receptionDefinitionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ReceptionDefinition
