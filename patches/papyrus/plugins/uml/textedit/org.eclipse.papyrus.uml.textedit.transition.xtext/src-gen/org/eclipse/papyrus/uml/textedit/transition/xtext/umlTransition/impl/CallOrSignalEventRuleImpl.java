/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Or Signal Event Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.CallOrSignalEventRuleImpl#getOperationOrSignal <em>Operation Or Signal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallOrSignalEventRuleImpl extends EventRuleImpl implements CallOrSignalEventRule {
	/**
	 * The cached value of the '{@link #getOperationOrSignal() <em>Operation Or Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperationOrSignal()
	 * @generated
	 * @ordered
	 */
	protected NamedElement operationOrSignal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CallOrSignalEventRuleImpl() {
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
		return UmlTransitionPackage.Literals.CALL_OR_SIGNAL_EVENT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getOperationOrSignal() {
		if (operationOrSignal != null && operationOrSignal.eIsProxy()) {
			InternalEObject oldOperationOrSignal = (InternalEObject) operationOrSignal;
			operationOrSignal = (NamedElement) eResolveProxy(oldOperationOrSignal);
			if (operationOrSignal != oldOperationOrSignal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL, oldOperationOrSignal, operationOrSignal));
			}
		}
		return operationOrSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetOperationOrSignal() {
		return operationOrSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOperationOrSignal(NamedElement newOperationOrSignal) {
		NamedElement oldOperationOrSignal = operationOrSignal;
		operationOrSignal = newOperationOrSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL, oldOperationOrSignal, operationOrSignal));
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
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL:
			if (resolve)
				return getOperationOrSignal();
			return basicGetOperationOrSignal();
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
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL:
			setOperationOrSignal((NamedElement) newValue);
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
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL:
			setOperationOrSignal((NamedElement) null);
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
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL:
			return operationOrSignal != null;
		}
		return super.eIsSet(featureID);
	}

} // CallOrSignalEventRuleImpl
