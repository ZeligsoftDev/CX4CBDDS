/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.uml.properties.languagepreferences.Editor;
import org.eclipse.papyrus.uml.properties.languagepreferences.Language;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl#getPreferedEditor <em>Prefered Editor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageImpl extends EObjectImpl implements Language {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreferedEditor() <em>Prefered Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferedEditor()
	 * @generated
	 * @ordered
	 */
	protected Editor preferedEditor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return languagepreferencesPackage.Literals.LANGUAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, languagepreferencesPackage.LANGUAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getPreferedEditor() {
		if (preferedEditor != null && preferedEditor.eIsProxy()) {
			InternalEObject oldPreferedEditor = (InternalEObject)preferedEditor;
			preferedEditor = (Editor)eResolveProxy(oldPreferedEditor);
			if (preferedEditor != oldPreferedEditor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR, oldPreferedEditor, preferedEditor));
			}
		}
		return preferedEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor basicGetPreferedEditor() {
		return preferedEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferedEditor(Editor newPreferedEditor) {
		Editor oldPreferedEditor = preferedEditor;
		preferedEditor = newPreferedEditor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR, oldPreferedEditor, preferedEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case languagepreferencesPackage.LANGUAGE__NAME:
				return getName();
			case languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR:
				if (resolve) return getPreferedEditor();
				return basicGetPreferedEditor();
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
			case languagepreferencesPackage.LANGUAGE__NAME:
				setName((String)newValue);
				return;
			case languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR:
				setPreferedEditor((Editor)newValue);
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
			case languagepreferencesPackage.LANGUAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR:
				setPreferedEditor((Editor)null);
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
			case languagepreferencesPackage.LANGUAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case languagepreferencesPackage.LANGUAGE__PREFERED_EDITOR:
				return preferedEditor != null;
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // LanguageImpl
