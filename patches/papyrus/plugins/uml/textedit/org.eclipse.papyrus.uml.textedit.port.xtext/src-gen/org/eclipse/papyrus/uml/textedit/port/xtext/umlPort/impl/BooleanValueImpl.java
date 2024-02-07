/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanLiterals;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.BooleanValueImpl#getLiteralBoolean <em>Literal Boolean</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanValueImpl extends ValueImpl implements BooleanValue {
	/**
	 * The default value of the '{@link #getLiteralBoolean() <em>Literal Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanLiterals LITERAL_BOOLEAN_EDEFAULT = BooleanLiterals.TRUE;

	/**
	 * The cached value of the '{@link #getLiteralBoolean() <em>Literal Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLiteralBoolean()
	 * @generated
	 * @ordered
	 */
	protected BooleanLiterals literalBoolean = LITERAL_BOOLEAN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BooleanValueImpl() {
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
		return UmlPortPackage.Literals.BOOLEAN_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanLiterals getLiteralBoolean() {
		return literalBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLiteralBoolean(BooleanLiterals newLiteralBoolean) {
		BooleanLiterals oldLiteralBoolean = literalBoolean;
		literalBoolean = newLiteralBoolean == null ? LITERAL_BOOLEAN_EDEFAULT : newLiteralBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.BOOLEAN_VALUE__LITERAL_BOOLEAN, oldLiteralBoolean, literalBoolean));
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
		case UmlPortPackage.BOOLEAN_VALUE__LITERAL_BOOLEAN:
			return getLiteralBoolean();
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
		case UmlPortPackage.BOOLEAN_VALUE__LITERAL_BOOLEAN:
			setLiteralBoolean((BooleanLiterals) newValue);
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
		case UmlPortPackage.BOOLEAN_VALUE__LITERAL_BOOLEAN:
			setLiteralBoolean(LITERAL_BOOLEAN_EDEFAULT);
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
		case UmlPortPackage.BOOLEAN_VALUE__LITERAL_BOOLEAN:
			return literalBoolean != LITERAL_BOOLEAN_EDEFAULT;
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
		result.append(" (literalBoolean: ");
		result.append(literalBoolean);
		result.append(')');
		return result.toString();
	}

} // BooleanValueImpl
