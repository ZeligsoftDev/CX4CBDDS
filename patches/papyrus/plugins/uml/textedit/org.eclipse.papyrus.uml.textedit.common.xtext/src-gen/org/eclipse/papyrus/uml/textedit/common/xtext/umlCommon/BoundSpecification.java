/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage#getBoundSpecification()
 * @model
 * @generated
 */
public interface BoundSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage#getBoundSpecification_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // BoundSpecification
