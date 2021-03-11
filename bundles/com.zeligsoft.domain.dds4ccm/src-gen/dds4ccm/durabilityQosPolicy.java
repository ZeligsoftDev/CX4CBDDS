/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>durability Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.durabilityQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getdurabilityQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface durabilityQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"VOLATILE"</code>.
	 * The literals are from the enumeration {@link dds4ccm.DurabilityQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.DurabilityQosPolicyKind
	 * @see #setKind(DurabilityQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getdurabilityQosPolicy_Kind()
	 * @model default="VOLATILE" required="true" ordered="false"
	 * @generated
	 */
	DurabilityQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.durabilityQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.DurabilityQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DurabilityQosPolicyKind value);

} // durabilityQosPolicy
