/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.properties.languagepreferences.*;
import org.eclipse.papyrus.uml.properties.languagepreferences.Editor;
import org.eclipse.papyrus.uml.properties.languagepreferences.Language;
import org.eclipse.papyrus.uml.properties.languagepreferences.Preferences;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesFactory;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class languagepreferencesFactoryImpl extends EFactoryImpl implements languagepreferencesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static languagepreferencesFactory init() {
		try {
			languagepreferencesFactory thelanguagepreferencesFactory = (languagepreferencesFactory)EPackage.Registry.INSTANCE.getEFactory(languagepreferencesPackage.eNS_URI);
			if (thelanguagepreferencesFactory != null) {
				return thelanguagepreferencesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new languagepreferencesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public languagepreferencesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case languagepreferencesPackage.LANGUAGE: return createLanguage();
			case languagepreferencesPackage.EDITOR: return createEditor();
			case languagepreferencesPackage.PREFERENCES: return createPreferences();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language createLanguage() {
		LanguageImpl language = new LanguageImpl();
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preferences createPreferences() {
		PreferencesImpl preferences = new PreferencesImpl();
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public languagepreferencesPackage getlanguagepreferencesPackage() {
		return (languagepreferencesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static languagepreferencesPackage getPackage() {
		return languagepreferencesPackage.eINSTANCE;
	}

} // languagepreferencesFactoryImpl
