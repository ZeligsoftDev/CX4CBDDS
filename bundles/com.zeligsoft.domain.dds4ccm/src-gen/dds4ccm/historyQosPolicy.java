/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>history Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.historyQosPolicy#getDepth <em>Depth</em>}</li>
 *   <li>{@link dds4ccm.historyQosPolicy#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#gethistoryQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface historyQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth</em>' attribute.
	 * @see #setDepth(int)
	 * @see dds4ccm.DDS4CCMPackage#gethistoryQosPolicy_Depth()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getDepth();

	/**
	 * Sets the value of the '{@link dds4ccm.historyQosPolicy#getDepth <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth</em>' attribute.
	 * @see #getDepth()
	 * @generated
	 */
	void setDepth(int value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"KEEP_LAST"</code>.
	 * The literals are from the enumeration {@link dds4ccm.HistoryQosPolicyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @see #setKind(HistoryQosPolicyKind)
	 * @see dds4ccm.DDS4CCMPackage#gethistoryQosPolicy_Kind()
	 * @model default="KEEP_LAST" required="true" ordered="false"
	 * @generated
	 */
	HistoryQosPolicyKind getKind();

	/**
	 * Sets the value of the '{@link dds4ccm.historyQosPolicy#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see dds4ccm.HistoryQosPolicyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(HistoryQosPolicyKind value);

} // historyQosPolicy
