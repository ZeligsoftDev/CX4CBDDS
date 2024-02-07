/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Namespace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName#getRemaining <em>Remaining</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Path</em>' reference.
	 * @see #setPath(Namespace)
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getQualifiedName_Path()
	 * @model
	 * @generated
	 */
	Namespace getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName#getPath <em>Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Path</em>' reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(Namespace value);

	/**
	 * Returns the value of the '<em><b>Remaining</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Remaining</em>' containment reference.
	 * @see #setRemaining(QualifiedName)
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#getQualifiedName_Remaining()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getRemaining();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName#getRemaining <em>Remaining</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Remaining</em>' containment reference.
	 * @see #getRemaining()
	 * @generated
	 */
	void setRemaining(QualifiedName value);

} // QualifiedName
