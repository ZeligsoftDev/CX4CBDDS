/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Or Signal Event Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule#getOperationOrSignal <em>Operation Or Signal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getCallOrSignalEventRule()
 * @model
 * @generated
 */
public interface CallOrSignalEventRule extends EventRule {
	/**
	 * Returns the value of the '<em><b>Operation Or Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Or Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation Or Signal</em>' reference.
	 * @see #setOperationOrSignal(NamedElement)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getCallOrSignalEventRule_OperationOrSignal()
	 * @model
	 * @generated
	 */
	NamedElement getOperationOrSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule#getOperationOrSignal <em>Operation Or Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Operation Or Signal</em>' reference.
	 * @see #getOperationOrSignal()
	 * @generated
	 */
	void setOperationOrSignal(NamedElement value);

} // CallOrSignalEventRule
