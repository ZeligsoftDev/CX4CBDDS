/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue#getInteger <em>Integer</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue#getFraction <em>Fraction</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getRealValue()
 * @model
 * @generated
 */
public interface RealValue extends Value {
	/**
	 * Returns the value of the '<em><b>Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Integer</em>' attribute.
	 * @see #setInteger(int)
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getRealValue_Integer()
	 * @model
	 * @generated
	 */
	int getInteger();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue#getInteger <em>Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Integer</em>' attribute.
	 * @see #getInteger()
	 * @generated
	 */
	void setInteger(int value);

	/**
	 * Returns the value of the '<em><b>Fraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fraction</em>' attribute.
	 * @see #setFraction(int)
	 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage#getRealValue_Fraction()
	 * @model
	 * @generated
	 */
	int getFraction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RealValue#getFraction <em>Fraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Fraction</em>' attribute.
	 * @see #getFraction()
	 * @generated
	 */
	void setFraction(int value);

} // RealValue
