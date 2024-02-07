/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.properties.languagepreferences;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getPreferedEditor <em>Prefered Editor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getLanguage()
 * @model
 * @generated
 */
public interface Language extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getLanguage_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Prefered Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefered Editor</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefered Editor</em>' reference.
	 * @see #setPreferedEditor(Editor)
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getLanguage_PreferedEditor()
	 * @model
	 * @generated
	 */
	Editor getPreferedEditor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Language#getPreferedEditor <em>Prefered Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefered Editor</em>' reference.
	 * @see #getPreferedEditor()
	 * @generated
	 */
	void setPreferedEditor(Editor value);

} // Language
