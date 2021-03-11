/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>rl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.rlQosPolicy#getMax_instances <em>Max instances</em>}</li>
 *   <li>{@link dds4ccm.rlQosPolicy#getMax_samples <em>Max samples</em>}</li>
 *   <li>{@link dds4ccm.rlQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getrlQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface rlQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Max instances</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max instances</em>' attribute.
	 * @see #setMax_instances(int)
	 * @see dds4ccm.DDS4CCMPackage#getrlQosPolicy_Max_instances()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_instances();

	/**
	 * Sets the value of the '{@link dds4ccm.rlQosPolicy#getMax_instances <em>Max instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max instances</em>' attribute.
	 * @see #getMax_instances()
	 * @generated
	 */
	void setMax_instances(int value);

	/**
	 * Returns the value of the '<em><b>Max samples</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max samples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max samples</em>' attribute.
	 * @see #setMax_samples(int)
	 * @see dds4ccm.DDS4CCMPackage#getrlQosPolicy_Max_samples()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_samples();

	/**
	 * Sets the value of the '{@link dds4ccm.rlQosPolicy#getMax_samples <em>Max samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max samples</em>' attribute.
	 * @see #getMax_samples()
	 * @generated
	 */
	void setMax_samples(int value);

	/**
	 * Returns the value of the '<em><b>Max samples per instance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max samples per instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max samples per instance</em>' attribute.
	 * @see #setMax_samples_per_instance(int)
	 * @see dds4ccm.DDS4CCMPackage#getrlQosPolicy_Max_samples_per_instance()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_samples_per_instance();

	/**
	 * Sets the value of the '{@link dds4ccm.rlQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max samples per instance</em>' attribute.
	 * @see #getMax_samples_per_instance()
	 * @generated
	 */
	void setMax_samples_per_instance(int value);

} // rlQosPolicy
