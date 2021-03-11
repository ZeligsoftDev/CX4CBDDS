/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.Property#getValue <em>Value</em>}</li>
 *   <li>{@link dds4ccm.Property#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getProperty()
 * @model annotation="uml2.extensions suppressed='true'"
 *        annotation="http://www.zeligsoft.com/zdl/2008/ZDL type='type'"
 * @generated
 */
public interface Property extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see dds4ccm.DDS4CCMPackage#getProperty_Value()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link dds4ccm.Property#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(org.eclipse.uml2.uml.Property)
	 * @see dds4ccm.DDS4CCMPackage#getProperty_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Property getBase_Property();

	/**
	 * Sets the value of the '{@link dds4ccm.Property#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(org.eclipse.uml2.uml.Property value);

} // Property
