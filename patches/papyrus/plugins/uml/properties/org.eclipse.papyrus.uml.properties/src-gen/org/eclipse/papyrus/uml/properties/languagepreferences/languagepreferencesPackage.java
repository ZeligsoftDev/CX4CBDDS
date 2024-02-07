/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesFactory
 * @model kind="package"
 * @generated
 */
public interface languagepreferencesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "languagepreferences";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/uml/languagePreferences";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lgpref";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	languagepreferencesPackage eINSTANCE = org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl <em>Language</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Prefered Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE__PREFERED_EDITOR = 1;

	/**
	 * The number of structural features of the '<em>Language</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 1;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__CLASS = 0;

	/**
	 * The feature id for the '<em><b>Bundle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__BUNDLE_ID = 1;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl <em>Preferences</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getPreferences()
	 * @generated
	 */
	int PREFERENCES = 2;

	/**
	 * The feature id for the '<em><b>Languages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__LANGUAGES = 0;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__EDITORS = 1;

	/**
	 * The feature id for the '<em><b>Default Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES__DEFAULT_EDITOR = 2;

	/**
	 * The number of structural features of the '<em>Preferences</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCES_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Language
	 * @generated
	 */
	EClass getLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Language#getName()
	 * @see #getLanguage()
	 * @generated
	 */
	EAttribute getLanguage_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getPreferedEditor <em>Prefered Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prefered Editor</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Language#getPreferedEditor()
	 * @see #getLanguage()
	 * @generated
	 */
	EReference getLanguage_PreferedEditor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getClass_()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getBundleId <em>Bundle Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Id</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getBundleId()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_BundleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preferences</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Preferences
	 * @generated
	 */
	EClass getPreferences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getLanguages <em>Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Languages</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getLanguages()
	 * @see #getPreferences()
	 * @generated
	 */
	EReference getPreferences_Languages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getEditors()
	 * @see #getPreferences()
	 * @generated
	 */
	EReference getPreferences_Editors();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getDefaultEditor <em>Default Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Editor</em>'.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getDefaultEditor()
	 * @see #getPreferences()
	 * @generated
	 */
	EReference getPreferences_DefaultEditor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	languagepreferencesFactory getlanguagepreferencesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl <em>Language</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.LanguageImpl
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getLanguage()
		 * @generated
		 */
		EClass LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE__NAME = eINSTANCE.getLanguage_Name();

		/**
		 * The meta object literal for the '<em><b>Prefered Editor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE__PREFERED_EDITOR = eINSTANCE.getLanguage_PreferedEditor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.EditorImpl
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__CLASS = eINSTANCE.getEditor_Class();

		/**
		 * The meta object literal for the '<em><b>Bundle Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__BUNDLE_ID = eINSTANCE.getEditor_BundleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl <em>Preferences</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.PreferencesImpl
		 * @see org.eclipse.papyrus.uml.properties.languagepreferences.impl.languagepreferencesPackageImpl#getPreferences()
		 * @generated
		 */
		EClass PREFERENCES = eINSTANCE.getPreferences();

		/**
		 * The meta object literal for the '<em><b>Languages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCES__LANGUAGES = eINSTANCE.getPreferences_Languages();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCES__EDITORS = eINSTANCE.getPreferences_Editors();

		/**
		 * The meta object literal for the '<em><b>Default Editor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFERENCES__DEFAULT_EDITOR = eINSTANCE.getPreferences_DefaultEditor();

	}

} // languagepreferencesPackage
