/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.IntValue;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.IntValueImpl#getLiteralInteger <em>Literal Integer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntValueImpl extends ValueImpl implements IntValue {
	/**
	 * The default value of the '{@link #getLiteralInteger() <em>Literal Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralInteger()
	 * @generated
	 * @ordered
	 */
	protected static final int LITERAL_INTEGER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLiteralInteger() <em>Literal Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralInteger()
	 * @generated
	 * @ordered
	 */
	protected int literalInteger = LITERAL_INTEGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IntValueImpl() {
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
		return UmlParameterPackage.Literals.INT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getLiteralInteger() {
		return literalInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLiteralInteger(int newLiteralInteger) {
		int oldLiteralInteger = literalInteger;
		literalInteger = newLiteralInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.INT_VALUE__LITERAL_INTEGER, oldLiteralInteger, literalInteger));
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
		case UmlParameterPackage.INT_VALUE__LITERAL_INTEGER:
			return getLiteralInteger();
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
		case UmlParameterPackage.INT_VALUE__LITERAL_INTEGER:
			setLiteralInteger((Integer) newValue);
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
		case UmlParameterPackage.INT_VALUE__LITERAL_INTEGER:
			setLiteralInteger(LITERAL_INTEGER_EDEFAULT);
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
		case UmlParameterPackage.INT_VALUE__LITERAL_INTEGER:
			return literalInteger != LITERAL_INTEGER_EDEFAULT;
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
		result.append(" (literalInteger: ");
		result.append(literalInteger);
		result.append(')');
		return result.toString();
	}

} // IntValueImpl
