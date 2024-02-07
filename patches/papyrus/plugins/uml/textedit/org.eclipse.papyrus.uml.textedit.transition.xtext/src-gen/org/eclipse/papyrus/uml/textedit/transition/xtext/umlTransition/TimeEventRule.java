/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Event Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTimeEventRule()
 * @model
 * @generated
 */
public interface TimeEventRule extends EventRule {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expr</em>' attribute.
	 * @see #setExpr(String)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTimeEventRule_Expr()
	 * @model
	 * @generated
	 */
	String getExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule#getExpr <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Expr</em>' attribute.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(String value);

} // TimeEventRule
