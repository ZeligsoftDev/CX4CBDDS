/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Term Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequencialOrder <em>Sequencial Order</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequenceName <em>Sequence Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getRecurrence <em>Recurrence</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getSequenceTermRule()
 * @model
 * @generated
 */
public interface SequenceTermRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Sequencial Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequencial Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sequencial Order</em>' attribute.
	 * @see #setSequencialOrder(int)
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getSequenceTermRule_SequencialOrder()
	 * @model
	 * @generated
	 */
	int getSequencialOrder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequencialOrder <em>Sequencial Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Sequencial Order</em>' attribute.
	 * @see #getSequencialOrder()
	 * @generated
	 */
	void setSequencialOrder(int value);

	/**
	 * Returns the value of the '<em><b>Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sequence Name</em>' attribute.
	 * @see #setSequenceName(String)
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getSequenceTermRule_SequenceName()
	 * @model
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Recurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recurrence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Recurrence</em>' attribute.
	 * @see #setRecurrence(String)
	 * @see org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage#getSequenceTermRule_Recurrence()
	 * @model
	 * @generated
	 */
	String getRecurrence();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule#getRecurrence <em>Recurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Recurrence</em>' attribute.
	 * @see #getRecurrence()
	 * @generated
	 */
	void setRecurrence(String value);

} // SequenceTermRule
