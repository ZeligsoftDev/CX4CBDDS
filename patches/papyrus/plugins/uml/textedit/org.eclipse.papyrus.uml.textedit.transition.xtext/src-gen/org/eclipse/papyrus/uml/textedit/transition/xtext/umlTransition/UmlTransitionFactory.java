/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage
 * @generated
 */
public interface UmlTransitionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlTransitionFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transition Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Transition Rule</em>'.
	 * @generated
	 */
	TransitionRule createTransitionRule();

	/**
	 * Returns a new object of class '<em>Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Event Rule</em>'.
	 * @generated
	 */
	EventRule createEventRule();

	/**
	 * Returns a new object of class '<em>Call Or Signal Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Call Or Signal Event Rule</em>'.
	 * @generated
	 */
	CallOrSignalEventRule createCallOrSignalEventRule();

	/**
	 * Returns a new object of class '<em>Any Receive Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Any Receive Event Rule</em>'.
	 * @generated
	 */
	AnyReceiveEventRule createAnyReceiveEventRule();

	/**
	 * Returns a new object of class '<em>Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Event Rule</em>'.
	 * @generated
	 */
	TimeEventRule createTimeEventRule();

	/**
	 * Returns a new object of class '<em>Relative Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Relative Time Event Rule</em>'.
	 * @generated
	 */
	RelativeTimeEventRule createRelativeTimeEventRule();

	/**
	 * Returns a new object of class '<em>Absolute Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Absolute Time Event Rule</em>'.
	 * @generated
	 */
	AbsoluteTimeEventRule createAbsoluteTimeEventRule();

	/**
	 * Returns a new object of class '<em>Change Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Change Event Rule</em>'.
	 * @generated
	 */
	ChangeEventRule createChangeEventRule();

	/**
	 * Returns a new object of class '<em>Guard Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Guard Rule</em>'.
	 * @generated
	 */
	GuardRule createGuardRule();

	/**
	 * Returns a new object of class '<em>Effect Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Effect Rule</em>'.
	 * @generated
	 */
	EffectRule createEffectRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlTransitionPackage getUmlTransitionPackage();

} // UmlTransitionFactory
