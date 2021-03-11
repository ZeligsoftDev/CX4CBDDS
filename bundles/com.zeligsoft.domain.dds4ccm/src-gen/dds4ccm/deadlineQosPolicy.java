/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>deadline Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.deadlineQosPolicy#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getdeadlineQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface deadlineQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' containment reference.
	 * @see #setPeriod(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getdeadlineQosPolicy_Period()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getPeriod();

	/**
	 * Sets the value of the '{@link dds4ccm.deadlineQosPolicy#getPeriod <em>Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' containment reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Duration value);

} // deadlineQosPolicy
