/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>liveliness Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.livelinessQosPolicy#getLease_duration <em>Lease duration</em>}</li>
 *   <li>{@link dds4ccm.livelinessQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getlivelinessQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface livelinessQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Lease duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lease duration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lease duration</em>' containment reference.
	 * @see #setLease_duration(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getlivelinessQosPolicy_Lease_duration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getLease_duration();

	/**
	 * Sets the value of the '{@link dds4ccm.livelinessQosPolicy#getLease_duration <em>Lease duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lease duration</em>' containment reference.
	 * @see #getLease_duration()
	 * @generated
	 */
	void setLease_duration(Duration value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"AUTOMATIC"</code>.
	 * The literals are from the enumeration {@link dds4ccm.LivelinessQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.LivelinessQosPolicyKind
	 * @see #setKind(LivelinessQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getlivelinessQosPolicy_Kind()
	 * @model default="AUTOMATIC" required="true" ordered="false"
	 * @generated
	 */
	LivelinessQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.livelinessQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.LivelinessQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(LivelinessQosPolicyKind value);

} // livelinessQosPolicy
