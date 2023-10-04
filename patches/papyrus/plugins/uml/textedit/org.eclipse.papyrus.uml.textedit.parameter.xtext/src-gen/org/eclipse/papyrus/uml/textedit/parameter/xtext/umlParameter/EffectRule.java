/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effect Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind <em>Effect Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getEffectRule()
 * @model
 * @generated
 */
public interface EffectRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Effect Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Effect Kind</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
	 * @see #setEffectKind(EffectKind)
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getEffectRule_EffectKind()
	 * @model
	 * @generated
	 */
	EffectKind getEffectKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind <em>Effect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Effect Kind</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
	 * @see #getEffectKind()
	 * @generated
	 */
	void setEffectKind(EffectKind value);

} // EffectRule
