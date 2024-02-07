/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getTriggers <em>Triggers</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getGuard <em>Guard</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTransitionRule()
 * @model
 * @generated
 */
public interface TransitionRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Triggers</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTransitionRule_Triggers()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventRule> getTriggers();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(GuardRule)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTransitionRule_Guard()
	 * @model containment="true"
	 * @generated
	 */
	GuardRule getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(GuardRule value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(EffectRule)
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#getTransitionRule_Effect()
	 * @model containment="true"
	 * @generated
	 */
	EffectRule getEffect();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(EffectRule value);

} // TransitionRule
