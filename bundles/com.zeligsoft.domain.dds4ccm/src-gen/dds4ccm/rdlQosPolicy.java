/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>rdl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.rdlQosPolicy#getAutopurge_nowriter_samples_delay <em>Autopurge nowriter samples delay</em>}</li>
 *   <li>{@link dds4ccm.rdlQosPolicy#getAutopurge_disposed_samples_delay <em>Autopurge disposed samples delay</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getrdlQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface rdlQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Autopurge nowriter samples delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autopurge nowriter samples delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autopurge nowriter samples delay</em>' containment reference.
	 * @see #setAutopurge_nowriter_samples_delay(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getrdlQosPolicy_Autopurge_nowriter_samples_delay()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getAutopurge_nowriter_samples_delay();

	/**
	 * Sets the value of the '{@link dds4ccm.rdlQosPolicy#getAutopurge_nowriter_samples_delay <em>Autopurge nowriter samples delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autopurge nowriter samples delay</em>' containment reference.
	 * @see #getAutopurge_nowriter_samples_delay()
	 * @generated
	 */
	void setAutopurge_nowriter_samples_delay(Duration value);

	/**
	 * Returns the value of the '<em><b>Autopurge disposed samples delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autopurge disposed samples delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autopurge disposed samples delay</em>' containment reference.
	 * @see #setAutopurge_disposed_samples_delay(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getrdlQosPolicy_Autopurge_disposed_samples_delay()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getAutopurge_disposed_samples_delay();

	/**
	 * Sets the value of the '{@link dds4ccm.rdlQosPolicy#getAutopurge_disposed_samples_delay <em>Autopurge disposed samples delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autopurge disposed samples delay</em>' containment reference.
	 * @see #getAutopurge_disposed_samples_delay()
	 * @generated
	 */
	void setAutopurge_disposed_samples_delay(Duration value);

} // rdlQosPolicy
