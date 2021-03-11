/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>reliability Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.reliabilityQosPolicy#getMax_blocking_time <em>Max blocking time</em>}</li>
 *   <li>{@link dds4ccm.reliabilityQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getreliabilityQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface reliabilityQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Max blocking time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max blocking time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max blocking time</em>' containment reference.
	 * @see #setMax_blocking_time(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getreliabilityQosPolicy_Max_blocking_time()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getMax_blocking_time();

	/**
	 * Sets the value of the '{@link dds4ccm.reliabilityQosPolicy#getMax_blocking_time <em>Max blocking time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max blocking time</em>' containment reference.
	 * @see #getMax_blocking_time()
	 * @generated
	 */
	void setMax_blocking_time(Duration value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"BEST_EFFORT"</code>.
	 * The literals are from the enumeration {@link dds4ccm.RealiabilityQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.RealiabilityQosPolicyKind
	 * @see #setKind(RealiabilityQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getreliabilityQosPolicy_Kind()
	 * @model default="BEST_EFFORT" required="true" ordered="false"
	 * @generated
	 */
	RealiabilityQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.reliabilityQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.RealiabilityQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(RealiabilityQosPolicyKind value);

} // reliabilityQosPolicy
