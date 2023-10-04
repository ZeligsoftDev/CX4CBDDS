/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effect Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl#getEffectKind <em>Effect Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EffectRuleImpl extends MinimalEObjectImpl.Container implements EffectRule {
	/**
	 * The default value of the '{@link #getEffectKind() <em>Effect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEffectKind()
	 * @generated
	 * @ordered
	 */
	protected static final EffectKind EFFECT_KIND_EDEFAULT = EffectKind.CREATE;

	/**
	 * The cached value of the '{@link #getEffectKind() <em>Effect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEffectKind()
	 * @generated
	 * @ordered
	 */
	protected EffectKind effectKind = EFFECT_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EffectRuleImpl() {
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
		return UmlParameterPackage.Literals.EFFECT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectKind getEffectKind() {
		return effectKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEffectKind(EffectKind newEffectKind) {
		EffectKind oldEffectKind = effectKind;
		effectKind = newEffectKind == null ? EFFECT_KIND_EDEFAULT : newEffectKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.EFFECT_RULE__EFFECT_KIND, oldEffectKind, effectKind));
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
		case UmlParameterPackage.EFFECT_RULE__EFFECT_KIND:
			return getEffectKind();
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
		case UmlParameterPackage.EFFECT_RULE__EFFECT_KIND:
			setEffectKind((EffectKind) newValue);
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
		case UmlParameterPackage.EFFECT_RULE__EFFECT_KIND:
			setEffectKind(EFFECT_KIND_EDEFAULT);
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
		case UmlParameterPackage.EFFECT_RULE__EFFECT_KIND:
			return effectKind != EFFECT_KIND_EDEFAULT;
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
		result.append(" (effectKind: ");
		result.append(effectKind);
		result.append(')');
		return result.toString();
	}

} // EffectRuleImpl
