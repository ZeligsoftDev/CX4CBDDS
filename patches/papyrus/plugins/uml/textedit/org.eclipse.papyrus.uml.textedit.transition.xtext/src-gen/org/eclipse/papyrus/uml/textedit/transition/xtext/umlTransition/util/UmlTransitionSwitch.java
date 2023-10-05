/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage
 * @generated
 */
public class UmlTransitionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlTransitionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlTransitionSwitch() {
		if (modelPackage == null) {
			modelPackage = UmlTransitionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param ePackage
	 *            the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case UmlTransitionPackage.TRANSITION_RULE: {
			TransitionRule transitionRule = (TransitionRule) theEObject;
			T result = caseTransitionRule(transitionRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.EVENT_RULE: {
			EventRule eventRule = (EventRule) theEObject;
			T result = caseEventRule(eventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE: {
			CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule) theEObject;
			T result = caseCallOrSignalEventRule(callOrSignalEventRule);
			if (result == null)
				result = caseEventRule(callOrSignalEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE: {
			AnyReceiveEventRule anyReceiveEventRule = (AnyReceiveEventRule) theEObject;
			T result = caseAnyReceiveEventRule(anyReceiveEventRule);
			if (result == null)
				result = caseEventRule(anyReceiveEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.TIME_EVENT_RULE: {
			TimeEventRule timeEventRule = (TimeEventRule) theEObject;
			T result = caseTimeEventRule(timeEventRule);
			if (result == null)
				result = caseEventRule(timeEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.RELATIVE_TIME_EVENT_RULE: {
			RelativeTimeEventRule relativeTimeEventRule = (RelativeTimeEventRule) theEObject;
			T result = caseRelativeTimeEventRule(relativeTimeEventRule);
			if (result == null)
				result = caseTimeEventRule(relativeTimeEventRule);
			if (result == null)
				result = caseEventRule(relativeTimeEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.ABSOLUTE_TIME_EVENT_RULE: {
			AbsoluteTimeEventRule absoluteTimeEventRule = (AbsoluteTimeEventRule) theEObject;
			T result = caseAbsoluteTimeEventRule(absoluteTimeEventRule);
			if (result == null)
				result = caseTimeEventRule(absoluteTimeEventRule);
			if (result == null)
				result = caseEventRule(absoluteTimeEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.CHANGE_EVENT_RULE: {
			ChangeEventRule changeEventRule = (ChangeEventRule) theEObject;
			T result = caseChangeEventRule(changeEventRule);
			if (result == null)
				result = caseEventRule(changeEventRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.GUARD_RULE: {
			GuardRule guardRule = (GuardRule) theEObject;
			T result = caseGuardRule(guardRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case UmlTransitionPackage.EFFECT_RULE: {
			EffectRule effectRule = (EffectRule) theEObject;
			T result = caseEffectRule(effectRule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionRule(TransitionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventRule(EventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Or Signal Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Or Signal Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallOrSignalEventRule(CallOrSignalEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Receive Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Receive Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyReceiveEventRule(AnyReceiveEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeEventRule(TimeEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relative Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relative Time Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelativeTimeEventRule(RelativeTimeEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Absolute Time Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Absolute Time Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbsoluteTimeEventRule(AbsoluteTimeEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Event Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Event Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeEventRule(ChangeEventRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardRule(GuardRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effect Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effect Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffectRule(EffectRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // UmlTransitionSwitch
