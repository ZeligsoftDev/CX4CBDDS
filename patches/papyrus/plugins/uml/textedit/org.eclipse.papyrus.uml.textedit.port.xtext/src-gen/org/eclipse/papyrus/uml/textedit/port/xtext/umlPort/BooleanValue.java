/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue#getLiteralBoolean <em>Literal Boolean</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getBooleanValue()
 * @model
 * @generated
 */
public interface BooleanValue extends Value {
	/**
	 * Returns the value of the '<em><b>Literal Boolean</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanLiterals}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Boolean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal Boolean</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanLiterals
	 * @see #setLiteralBoolean(BooleanLiterals)
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getBooleanValue_LiteralBoolean()
	 * @model
	 * @generated
	 */
	BooleanLiterals getLiteralBoolean();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanValue#getLiteralBoolean <em>Literal Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Literal Boolean</em>' attribute.
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BooleanLiterals
	 * @see #getLiteralBoolean()
	 * @generated
	 */
	void setLiteralBoolean(BooleanLiterals value);

} // BooleanValue
