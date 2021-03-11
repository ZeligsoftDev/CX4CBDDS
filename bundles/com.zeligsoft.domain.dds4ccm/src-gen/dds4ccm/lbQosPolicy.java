/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>lb Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.lbQosPolicy#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getlbQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface lbQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' containment reference.
	 * @see #setDuration(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getlbQosPolicy_Duration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getDuration();

	/**
	 * Sets the value of the '{@link dds4ccm.lbQosPolicy#getDuration <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' containment reference.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Duration value);

} // lbQosPolicy
