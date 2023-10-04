/**
 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Point Reference Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getEntry <em>Entry</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule#getExit <em>Exit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage#getConnectionPointReferenceRule()
 * @model
 * @generated
 */
public interface ConnectionPointReferenceRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entry</em>' reference list.
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage#getConnectionPointReferenceRule_Entry()
	 * @model
	 * @generated
	 */
	EList<Pseudostate> getEntry();

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Pseudostate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exit</em>' reference list.
	 * @see org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage#getConnectionPointReferenceRule_Exit()
	 * @model
	 * @generated
	 */
	EList<Pseudostate> getExit();

} // ConnectionPointReferenceRule
