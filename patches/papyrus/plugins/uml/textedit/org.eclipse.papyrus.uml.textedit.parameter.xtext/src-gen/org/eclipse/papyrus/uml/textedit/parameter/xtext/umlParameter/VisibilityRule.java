/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visibility Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule#getVisibility <em>Visibility</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getVisibilityRule()
 * @model
 * @generated
 */
public interface VisibilityRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
	 * @see #setVisibility(VisibilityKind)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getVisibilityRule_Visibility()
	 * @model
	 * @generated
	 */
	VisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityKind value);

} // VisibilityRule
