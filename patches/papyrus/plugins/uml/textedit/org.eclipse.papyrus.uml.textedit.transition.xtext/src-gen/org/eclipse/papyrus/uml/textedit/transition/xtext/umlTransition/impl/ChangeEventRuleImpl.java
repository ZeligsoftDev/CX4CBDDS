/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Event Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.ChangeEventRuleImpl#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangeEventRuleImpl extends EventRuleImpl implements ChangeEventRule {
	/**
	 * The default value of the '{@link #getExp() <em>Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected static final String EXP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected String exp = EXP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ChangeEventRuleImpl() {
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
		return UmlTransitionPackage.Literals.CHANGE_EVENT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExp(String newExp) {
		String oldExp = exp;
		exp = newExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.CHANGE_EVENT_RULE__EXP, oldExp, exp));
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
		case UmlTransitionPackage.CHANGE_EVENT_RULE__EXP:
			return getExp();
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
		case UmlTransitionPackage.CHANGE_EVENT_RULE__EXP:
			setExp((String) newValue);
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
		case UmlTransitionPackage.CHANGE_EVENT_RULE__EXP:
			setExp(EXP_EDEFAULT);
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
		case UmlTransitionPackage.CHANGE_EVENT_RULE__EXP:
			return EXP_EDEFAULT == null ? exp != null : !EXP_EDEFAULT.equals(exp);
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
		result.append(" (exp: ");
		result.append(exp);
		result.append(')');
		return result.toString();
	}

} // ChangeEventRuleImpl
