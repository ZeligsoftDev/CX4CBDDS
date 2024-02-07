/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.CSSPackage;
import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.IntegerTok;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Tok</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl.IntegerTokImpl#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerTokImpl extends CssTokImpl implements IntegerTok {
	/**
	 * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVal()
	 * @generated
	 * @ordered
	 */
	protected static final int VAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVal()
	 * @generated
	 * @ordered
	 */
	protected int val = VAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IntegerTokImpl() {
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
		return CSSPackage.Literals.INTEGER_TOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getVal() {
		return val;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVal(int newVal) {
		int oldVal = val;
		val = newVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSSPackage.INTEGER_TOK__VAL, oldVal, val));
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
		case CSSPackage.INTEGER_TOK__VAL:
			return getVal();
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
		case CSSPackage.INTEGER_TOK__VAL:
			setVal((Integer) newValue);
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
		case CSSPackage.INTEGER_TOK__VAL:
			setVal(VAL_EDEFAULT);
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
		case CSSPackage.INTEGER_TOK__VAL:
			return val != VAL_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (val: ");
		result.append(val);
		result.append(')');
		return result.toString();
	}

} // IntegerTokImpl
