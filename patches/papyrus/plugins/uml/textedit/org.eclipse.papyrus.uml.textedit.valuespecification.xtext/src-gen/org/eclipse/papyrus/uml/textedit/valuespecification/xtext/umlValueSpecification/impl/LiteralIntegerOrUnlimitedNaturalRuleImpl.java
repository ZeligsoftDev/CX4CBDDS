/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Integer Or Unlimited Natural Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.LiteralIntegerOrUnlimitedNaturalRuleImpl#getUnlimited <em>Unlimited</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralIntegerOrUnlimitedNaturalRuleImpl extends MinimalEObjectImpl.Container implements LiteralIntegerOrUnlimitedNaturalRule {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnlimited() <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUnlimited()
	 * @generated
	 * @ordered
	 */
	protected static final String UNLIMITED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnlimited() <em>Unlimited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUnlimited()
	 * @generated
	 * @ordered
	 */
	protected String unlimited = UNLIMITED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LiteralIntegerOrUnlimitedNaturalRuleImpl() {
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
		return UmlValueSpecificationPackage.Literals.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUnlimited() {
		return unlimited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUnlimited(String newUnlimited) {
		String oldUnlimited = unlimited;
		unlimited = newUnlimited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED, oldUnlimited, unlimited));
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
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE:
			return getValue();
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED:
			return getUnlimited();
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
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE:
			setValue((Integer) newValue);
			return;
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED:
			setUnlimited((String) newValue);
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
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED:
			setUnlimited(UNLIMITED_EDEFAULT);
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
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE:
			return value != VALUE_EDEFAULT;
		case UmlValueSpecificationPackage.LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED:
			return UNLIMITED_EDEFAULT == null ? unlimited != null : !UNLIMITED_EDEFAULT.equals(unlimited);
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
		result.append(" (value: ");
		result.append(value);
		result.append(", unlimited: ");
		result.append(unlimited);
		result.append(')');
		return result.toString();
	}

} // LiteralIntegerOrUnlimitedNaturalRuleImpl
