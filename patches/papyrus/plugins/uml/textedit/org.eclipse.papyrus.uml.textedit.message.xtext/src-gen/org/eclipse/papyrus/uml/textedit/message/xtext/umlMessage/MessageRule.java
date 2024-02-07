/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getSequenceTerm <em>Sequence Term</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getMessageRule()
 * @model
 * @generated
 */
public interface MessageRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Sequence Term</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Term</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sequence Term</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getMessageRule_SequenceTerm()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceTermRule> getSequenceTerm();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getMessageRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MessageRule
