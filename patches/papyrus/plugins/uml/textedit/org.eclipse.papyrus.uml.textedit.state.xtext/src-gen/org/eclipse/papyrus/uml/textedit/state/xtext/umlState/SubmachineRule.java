/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.StateMachine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Submachine Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule#getSubmachine <em>Submachine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getSubmachineRule()
 * @model
 * @generated
 */
public interface SubmachineRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Path</em>' containment reference.
	 * @see #setPath(QualifiedName)
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getSubmachineRule_Path()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule#getPath <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Path</em>' containment reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Submachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submachine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Submachine</em>' reference.
	 * @see #setSubmachine(StateMachine)
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getSubmachineRule_Submachine()
	 * @model
	 * @generated
	 */
	StateMachine getSubmachine();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule#getSubmachine <em>Submachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Submachine</em>' reference.
	 * @see #getSubmachine()
	 * @generated
	 */
	void setSubmachine(StateMachine value);

} // SubmachineRule
