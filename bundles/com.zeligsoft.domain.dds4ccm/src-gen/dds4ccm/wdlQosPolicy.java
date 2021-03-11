/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>wdl Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.wdlQosPolicy#isAutodispose_unregistered_instances <em>Autodispose unregistered instances</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getwdlQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface wdlQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Autodispose unregistered instances</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autodispose unregistered instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autodispose unregistered instances</em>' attribute.
	 * @see #setAutodispose_unregistered_instances(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getwdlQosPolicy_Autodispose_unregistered_instances()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAutodispose_unregistered_instances();

	/**
	 * Sets the value of the '{@link dds4ccm.wdlQosPolicy#isAutodispose_unregistered_instances <em>Autodispose unregistered instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autodispose unregistered instances</em>' attribute.
	 * @see #isAutodispose_unregistered_instances()
	 * @generated
	 */
	void setAutodispose_unregistered_instances(boolean value);

} // wdlQosPolicy
