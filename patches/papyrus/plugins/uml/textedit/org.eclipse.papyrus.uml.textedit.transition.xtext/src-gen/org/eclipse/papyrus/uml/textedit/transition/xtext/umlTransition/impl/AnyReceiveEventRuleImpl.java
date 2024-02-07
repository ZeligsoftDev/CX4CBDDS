/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Receive Event Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AnyReceiveEventRuleImpl#getIsAReceiveEvent <em>Is AReceive Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnyReceiveEventRuleImpl extends EventRuleImpl implements AnyReceiveEventRule {
	/**
	 * The default value of the '{@link #getIsAReceiveEvent() <em>Is AReceive Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIsAReceiveEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_ARECEIVE_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAReceiveEvent() <em>Is AReceive Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIsAReceiveEvent()
	 * @generated
	 * @ordered
	 */
	protected String isAReceiveEvent = IS_ARECEIVE_EVENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AnyReceiveEventRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlTransitionPackage.Literals.ANY_RECEIVE_EVENT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getIsAReceiveEvent() {
		return isAReceiveEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsAReceiveEvent(String newIsAReceiveEvent) {
		String oldIsAReceiveEvent = isAReceiveEvent;
		isAReceiveEvent = newIsAReceiveEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT, oldIsAReceiveEvent, isAReceiveEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT:
			return getIsAReceiveEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT:
			setIsAReceiveEvent((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT:
			setIsAReceiveEvent(IS_ARECEIVE_EVENT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT:
			return IS_ARECEIVE_EVENT_EDEFAULT == null ? isAReceiveEvent != null : !IS_ARECEIVE_EVENT_EDEFAULT.equals(isAReceiveEvent);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isAReceiveEvent: ");
		result.append(isAReceiveEvent);
		result.append(')');
		return result.toString();
	}

} // AnyReceiveEventRuleImpl
