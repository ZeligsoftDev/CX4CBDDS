/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>tbf Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.tbfQosPolicy#getMinimum_separation <em>Minimum separation</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#gettbfQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface tbfQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Minimum separation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum separation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum separation</em>' containment reference.
	 * @see #setMinimum_separation(Duration)
	 * @see dds4ccm.DDS4CCMPackage#gettbfQosPolicy_Minimum_separation()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getMinimum_separation();

	/**
	 * Sets the value of the '{@link dds4ccm.tbfQosPolicy#getMinimum_separation <em>Minimum separation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum separation</em>' containment reference.
	 * @see #getMinimum_separation()
	 * @generated
	 */
	void setMinimum_separation(Duration value);

} // tbfQosPolicy
