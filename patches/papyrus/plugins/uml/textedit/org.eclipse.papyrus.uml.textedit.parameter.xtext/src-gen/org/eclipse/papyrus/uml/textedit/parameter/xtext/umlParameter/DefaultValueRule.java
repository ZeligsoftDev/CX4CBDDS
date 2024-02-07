/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Value Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getDefaultValueRule()
 * @model
 * @generated
 */
public interface DefaultValueRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Value)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getDefaultValueRule_Default()
	 * @model containment="true"
	 * @generated
	 */
	Value getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Value value);

} // DefaultValueRule
