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
 * A representation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getBundleId <em>Bundle Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getEditor()
 * @model
 * @generated
 */
public interface Editor extends EObject {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getEditor_Class()
	 * @model required="true"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Bundle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Id</em>' attribute.
	 * @see #setBundleId(String)
	 * @see org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesPackage#getEditor_BundleId()
	 * @model
	 * @generated
	 */
	String getBundleId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.properties.languagepreferences.Editor#getBundleId <em>Bundle Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Id</em>' attribute.
	 * @see #getBundleId()
	 * @generated
	 */
	void setBundleId(String value);

} // Editor
