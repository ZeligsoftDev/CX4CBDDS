/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.uml.properties.languagepreferences.Editor;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl#getBundleId <em>Bundle Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditorImpl extends EObjectImpl implements Editor {
	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundleId() <em>Bundle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleId()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleId() <em>Bundle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleId()
	 * @generated
	 * @ordered
	 */
	protected String bundleId = BUNDLE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return languagepreferencesPackage.Literals.EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, languagepreferencesPackage.EDITOR__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleId() {
		return bundleId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleId(String newBundleId) {
		String oldBundleId = bundleId;
		bundleId = newBundleId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, languagepreferencesPackage.EDITOR__BUNDLE_ID, oldBundleId, bundleId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case languagepreferencesPackage.EDITOR__CLASS:
				return getClass_();
			case languagepreferencesPackage.EDITOR__BUNDLE_ID:
				return getBundleId();
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
			case languagepreferencesPackage.EDITOR__CLASS:
				setClass((String)newValue);
				return;
			case languagepreferencesPackage.EDITOR__BUNDLE_ID:
				setBundleId((String)newValue);
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
			case languagepreferencesPackage.EDITOR__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case languagepreferencesPackage.EDITOR__BUNDLE_ID:
				setBundleId(BUNDLE_ID_EDEFAULT);
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
			case languagepreferencesPackage.EDITOR__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case languagepreferencesPackage.EDITOR__BUNDLE_ID:
				return BUNDLE_ID_EDEFAULT == null ? bundleId != null : !BUNDLE_ID_EDEFAULT.equals(bundleId);
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
		result.append(" (class: "); //$NON-NLS-1$
		result.append(class_);
		result.append(", bundleId: "); //$NON-NLS-1$
		result.append(bundleId);
		result.append(')');
		return result.toString();
	}

} // EditorImpl
