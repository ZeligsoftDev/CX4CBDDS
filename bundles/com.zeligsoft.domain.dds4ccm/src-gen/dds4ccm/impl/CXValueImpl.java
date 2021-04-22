/**
 */
package dds4ccm.impl;

import dds4ccm.CXValue;
import dds4ccm.DDS4CCMPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CX Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.impl.CXValueImpl#isCustom <em>Is Custom</em>}</li>
 *   <li>{@link dds4ccm.impl.CXValueImpl#isTruncatable <em>Is Truncatable</em>}</li>
 *   <li>{@link dds4ccm.impl.CXValueImpl#getBase_Interface <em>Base Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CXValueImpl extends ContainedImpl implements CXValue {
	/**
	 * The default value of the '{@link #isCustom() <em>Is Custom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCustom()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CUSTOM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCustom() <em>Is Custom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCustom()
	 * @generated
	 * @ordered
	 */
	protected boolean isCustom = IS_CUSTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #isTruncatable() <em>Is Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRUNCATABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTruncatable() <em>Is Truncatable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTruncatable()
	 * @generated
	 * @ordered
	 */
	protected boolean isTruncatable = IS_TRUNCATABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Interface() <em>Base Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Interface()
	 * @generated
	 * @ordered
	 */
	protected Interface base_Interface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CXValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DDS4CCMPackage.eINSTANCE.getCXValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCustom() {
		return isCustom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCustom(boolean newIsCustom) {
		boolean oldIsCustom = isCustom;
		isCustom = newIsCustom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_VALUE__IS_CUSTOM, oldIsCustom, isCustom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTruncatable() {
		return isTruncatable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTruncatable(boolean newIsTruncatable) {
		boolean oldIsTruncatable = isTruncatable;
		isTruncatable = newIsTruncatable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_VALUE__IS_TRUNCATABLE, oldIsTruncatable, isTruncatable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getBase_Interface() {
		if (base_Interface != null && base_Interface.eIsProxy()) {
			InternalEObject oldBase_Interface = (InternalEObject)base_Interface;
			base_Interface = (Interface)eResolveProxy(oldBase_Interface);
			if (base_Interface != oldBase_Interface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DDS4CCMPackage.CX_VALUE__BASE_INTERFACE, oldBase_Interface, base_Interface));
			}
		}
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetBase_Interface() {
		return base_Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Interface(Interface newBase_Interface) {
		Interface oldBase_Interface = base_Interface;
		base_Interface = newBase_Interface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DDS4CCMPackage.CX_VALUE__BASE_INTERFACE, oldBase_Interface, base_Interface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DDS4CCMPackage.CX_VALUE__IS_CUSTOM:
				return isCustom();
			case DDS4CCMPackage.CX_VALUE__IS_TRUNCATABLE:
				return isTruncatable();
			case DDS4CCMPackage.CX_VALUE__BASE_INTERFACE:
				if (resolve) return getBase_Interface();
				return basicGetBase_Interface();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DDS4CCMPackage.CX_VALUE__IS_CUSTOM:
				setIsCustom((Boolean)newValue);
				return;
			case DDS4CCMPackage.CX_VALUE__IS_TRUNCATABLE:
				setIsTruncatable((Boolean)newValue);
				return;
			case DDS4CCMPackage.CX_VALUE__BASE_INTERFACE:
				setBase_Interface((Interface)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DDS4CCMPackage.CX_VALUE__IS_CUSTOM:
				setIsCustom(IS_CUSTOM_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_VALUE__IS_TRUNCATABLE:
				setIsTruncatable(IS_TRUNCATABLE_EDEFAULT);
				return;
			case DDS4CCMPackage.CX_VALUE__BASE_INTERFACE:
				setBase_Interface((Interface)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DDS4CCMPackage.CX_VALUE__IS_CUSTOM:
				return isCustom != IS_CUSTOM_EDEFAULT;
			case DDS4CCMPackage.CX_VALUE__IS_TRUNCATABLE:
				return isTruncatable != IS_TRUNCATABLE_EDEFAULT;
			case DDS4CCMPackage.CX_VALUE__BASE_INTERFACE:
				return base_Interface != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isCustom: ");
		result.append(isCustom);
		result.append(", isTruncatable: ");
		result.append(isTruncatable);
		result.append(')');
		return result.toString();
	}

} //CXValueImpl
