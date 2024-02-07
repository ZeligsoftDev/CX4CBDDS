/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Event Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getChangeEventRule()
 * @model
 * @generated
 */
public interface ChangeEventRule extends EventRule {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exp</em>' attribute.
	 * @see #setExp(String)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getChangeEventRule_Exp()
	 * @model
	 * @generated
	 */
	String getExp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule#getExp <em>Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Exp</em>' attribute.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(String value);

} // ChangeEventRule
