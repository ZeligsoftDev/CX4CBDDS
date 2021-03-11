/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>do Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.doQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getdoQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface doQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"BY_RECEPTION_TIMESTAMP"</code>.
	 * The literals are from the enumeration {@link dds4ccm.DestinationOrderQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.DestinationOrderQosPolicyKind
	 * @see #setKind(DestinationOrderQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getdoQosPolicy_Kind()
	 * @model default="BY_RECEPTION_TIMESTAMP" required="true" ordered="false"
	 * @generated
	 */
	DestinationOrderQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.doQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.DestinationOrderQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DestinationOrderQosPolicyKind value);

} // doQosPolicy
