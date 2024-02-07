/**
 */
package org.eclipse.papyrus.uml.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An assignment of a value to an attribute of an applied stereotype.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TaggedValue#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TaggedValue#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.TaggedValue#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValue()
 * @model
 * @generated
 */
public interface TaggedValue extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the stereotype attribute to be assigned a value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValue_Name()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='UnitDefinition'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TaggedValue#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The string image of a literal value to be assigned to the stereotype attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValue_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TaggedValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a numeric value, an optional unary plus or minus operator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getTaggedValue_Operator()
	 * @model
	 * @generated
	 */
	String getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.TaggedValue#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(String value);

} // TaggedValue
