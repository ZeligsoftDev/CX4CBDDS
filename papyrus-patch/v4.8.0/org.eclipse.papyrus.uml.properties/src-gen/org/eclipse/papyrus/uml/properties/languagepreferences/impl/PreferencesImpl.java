/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.properties.languagepreferences.Editor;
import org.eclipse.papyrus.uml.properties.languagepreferences.Language;
import org.eclipse.papyrus.uml.properties.languagepreferences.Preferences;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl#getLanguages <em>Languages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl#getDefaultEditor <em>Default Editor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreferencesImpl extends EObjectImpl implements Preferences {
	/**
	 * The cached value of the '{@link #getLanguages() <em>Languages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguages()
	 * @generated
	 * @ordered
	 */
	protected EList<Language> languages;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

	/**
	 * The cached value of the '{@link #getDefaultEditor() <em>Default Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultEditor()
	 * @generated
	 * @ordered
	 */
	protected Editor defaultEditor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferencesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return languagepreferencesPackage.Literals.PREFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Language> getLanguages() {
		if (languages == null) {
			languages = new EObjectContainmentEList<Language>(Language.class, this, languagepreferencesPackage.PREFERENCES__LANGUAGES);
		}
		return languages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectContainmentEList<Editor>(Editor.class, this, languagepreferencesPackage.PREFERENCES__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getDefaultEditor() {
		if (defaultEditor != null && defaultEditor.eIsProxy()) {
			InternalEObject oldDefaultEditor = (InternalEObject)defaultEditor;
			defaultEditor = (Editor)eResolveProxy(oldDefaultEditor);
			if (defaultEditor != oldDefaultEditor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR, oldDefaultEditor, defaultEditor));
			}
		}
		return defaultEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor basicGetDefaultEditor() {
		return defaultEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultEditor(Editor newDefaultEditor) {
		Editor oldDefaultEditor = defaultEditor;
		defaultEditor = newDefaultEditor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR, oldDefaultEditor, defaultEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case languagepreferencesPackage.PREFERENCES__LANGUAGES:
				return ((InternalEList<?>)getLanguages()).basicRemove(otherEnd, msgs);
			case languagepreferencesPackage.PREFERENCES__EDITORS:
				return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case languagepreferencesPackage.PREFERENCES__LANGUAGES:
				return getLanguages();
			case languagepreferencesPackage.PREFERENCES__EDITORS:
				return getEditors();
			case languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR:
				if (resolve) return getDefaultEditor();
				return basicGetDefaultEditor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case languagepreferencesPackage.PREFERENCES__LANGUAGES:
				getLanguages().clear();
				getLanguages().addAll((Collection<? extends Language>)newValue);
				return;
			case languagepreferencesPackage.PREFERENCES__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR:
				setDefaultEditor((Editor)newValue);
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
			case languagepreferencesPackage.PREFERENCES__LANGUAGES:
				getLanguages().clear();
				return;
			case languagepreferencesPackage.PREFERENCES__EDITORS:
				getEditors().clear();
				return;
			case languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR:
				setDefaultEditor((Editor)null);
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
			case languagepreferencesPackage.PREFERENCES__LANGUAGES:
				return languages != null && !languages.isEmpty();
			case languagepreferencesPackage.PREFERENCES__EDITORS:
				return editors != null && !editors.isEmpty();
			case languagepreferencesPackage.PREFERENCES__DEFAULT_EDITOR:
				return defaultEditor != null;
		}
		return super.eIsSet(featureID);
	}

} // PreferencesImpl
