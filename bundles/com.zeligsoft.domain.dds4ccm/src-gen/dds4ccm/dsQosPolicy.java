/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ds Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.dsQosPolicy#getService_cleanup_delay <em>Service cleanup delay</em>}</li>
 *   <li>{@link dds4ccm.dsQosPolicy#getHistory_kind <em>History kind</em>}</li>
 *   <li>{@link dds4ccm.dsQosPolicy#getMax_instances <em>Max instances</em>}</li>
 *   <li>{@link dds4ccm.dsQosPolicy#getMax_samples <em>Max samples</em>}</li>
 *   <li>{@link dds4ccm.dsQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}</li>
 *   <li>{@link dds4ccm.dsQosPolicy#getHistory_depth <em>History depth</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface dsQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Service cleanup delay</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service cleanup delay</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service cleanup delay</em>' containment reference.
	 * @see #setService_cleanup_delay(Duration)
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_Service_cleanup_delay()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Duration getService_cleanup_delay();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getService_cleanup_delay <em>Service cleanup delay</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service cleanup delay</em>' containment reference.
	 * @see #getService_cleanup_delay()
	 * @generated
	 */
	void setService_cleanup_delay(Duration value);

	/**
	 * Returns the value of the '<em><b>History kind</b></em>' attribute.
	 * The default value is <code>"KEEP_LAST"</code>.
	 * The literals are from the enumeration {@link dds4ccm.HistoryQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History kind</em>' attribute.
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @see #setHistory_kind(HistoryQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_History_kind()
	 * @model default="KEEP_LAST" required="true" ordered="false"
	 * @generated
	 */
	HistoryQosPolicyKind getHistory_kind();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getHistory_kind <em>History kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History kind</em>' attribute.
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @see #getHistory_kind()
	 * @generated
	 */
	void setHistory_kind(HistoryQosPolicyKind value);

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
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_Max_instances()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_instances();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getMax_instances <em>Max instances</em>}' attribute.
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
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_Max_samples()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_samples();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getMax_samples <em>Max samples</em>}' attribute.
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
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_Max_samples_per_instance()
	 * @model default="-1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMax_samples_per_instance();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getMax_samples_per_instance <em>Max samples per instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max samples per instance</em>' attribute.
	 * @see #getMax_samples_per_instance()
	 * @generated
	 */
	void setMax_samples_per_instance(int value);

	/**
	 * Returns the value of the '<em><b>History depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History depth</em>' attribute.
	 * @see #setHistory_depth(int)
	 * @see dds4ccm.DDS4CCMPackage#getdsQosPolicy_History_depth()
	 * @model default="1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getHistory_depth();

	/**
	 * Sets the value of the '{@link dds4ccm.dsQosPolicy#getHistory_depth <em>History depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History depth</em>' attribute.
	 * @see #getHistory_depth()
	 * @generated
	 */
	void setHistory_depth(int value);

} // dsQosPolicy
