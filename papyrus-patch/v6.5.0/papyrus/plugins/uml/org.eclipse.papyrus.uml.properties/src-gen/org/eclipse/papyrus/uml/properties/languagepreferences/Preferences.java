/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preferences</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getLanguages <em>Languages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getDefaultEditor <em>Default Editor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getPreferences()
 * @model
 * @generated
 */
public interface Preferences extends EObject {
	/**
	 * Returns the value of the '<em><b>Languages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.properties.languagepreferences.Language}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Languages</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Languages</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getPreferences_Languages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Language> getLanguages();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getPreferences_Editors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Default Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Editor</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Editor</em>' reference.
	 * @see #setDefaultEditor(Editor)
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getPreferences_DefaultEditor()
	 * @model required="true"
	 * @generated
	 */
	Editor getDefaultEditor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Preferences#getDefaultEditor <em>Default Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Editor</em>' reference.
	 * @see #getDefaultEditor()
	 * @generated
	 */
	void setDefaultEditor(Editor value);

} // Preferences
