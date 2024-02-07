/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effect Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getKind <em>Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getBehaviorName <em>Behavior Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getEffectRule()
 * @model
 * @generated
 */
public interface EffectRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind
	 * @see #setKind(BehaviorKind)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getEffectRule_Kind()
	 * @model
	 * @generated
	 */
	BehaviorKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(BehaviorKind value);

	/**
	 * Returns the value of the '<em><b>Behavior Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Behavior Name</em>' attribute.
	 * @see #setBehaviorName(String)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getEffectRule_BehaviorName()
	 * @model
	 * @generated
	 */
	String getBehaviorName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getBehaviorName <em>Behavior Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Behavior Name</em>' attribute.
	 * @see #getBehaviorName()
	 * @generated
	 */
	void setBehaviorName(String value);

} // EffectRule
