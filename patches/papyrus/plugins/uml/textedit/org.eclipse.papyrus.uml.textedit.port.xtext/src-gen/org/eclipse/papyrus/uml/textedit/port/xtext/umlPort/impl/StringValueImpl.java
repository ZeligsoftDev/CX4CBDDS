/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.StringValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.StringValueImpl#getLiteralString <em>Literal String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringValueImpl extends ValueImpl implements StringValue {
	/**
	 * The default value of the '{@link #getLiteralString() <em>Literal String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralString()
	 * @generated
	 * @ordered
	 */
	protected static final String LITERAL_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiteralString() <em>Literal String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralString()
	 * @generated
	 * @ordered
	 */
	protected String literalString = LITERAL_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StringValueImpl() {
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
		return UmlPortPackage.Literals.STRING_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteralString() {
		return literalString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLiteralString(String newLiteralString) {
		String oldLiteralString = literalString;
		literalString = newLiteralString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.STRING_VALUE__LITERAL_STRING, oldLiteralString, literalString));
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
		case UmlPortPackage.STRING_VALUE__LITERAL_STRING:
			return getLiteralString();
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
		case UmlPortPackage.STRING_VALUE__LITERAL_STRING:
			setLiteralString((String) newValue);
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
		case UmlPortPackage.STRING_VALUE__LITERAL_STRING:
			setLiteralString(LITERAL_STRING_EDEFAULT);
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
		case UmlPortPackage.STRING_VALUE__LITERAL_STRING:
			return LITERAL_STRING_EDEFAULT == null ? literalString != null : !LITERAL_STRING_EDEFAULT.equals(literalString);
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
		result.append(" (literalString: ");
		result.append(literalString);
		result.append(')');
		return result.toString();
	}

} // StringValueImpl
