/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ownership Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ownershipQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getownershipQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ownershipQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"SHARED"</code>.
	 * The literals are from the enumeration {@link dds4ccm.OwnershipQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.OwnershipQosPolicyKind
	 * @see #setKind(OwnershipQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getownershipQosPolicy_Kind()
	 * @model default="SHARED" required="true" ordered="false"
	 * @generated
	 */
	OwnershipQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.ownershipQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.OwnershipQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OwnershipQosPolicyKind value);

} // ownershipQosPolicy
