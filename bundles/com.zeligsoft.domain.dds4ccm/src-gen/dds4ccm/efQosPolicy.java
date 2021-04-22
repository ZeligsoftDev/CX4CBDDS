/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ef Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.efQosPolicy#isAutoenable_created_entities <em>Autoenable created entities</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getefQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface efQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Autoenable created entities</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autoenable created entities</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autoenable created entities</em>' attribute.
	 * @see #setAutoenable_created_entities(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getefQosPolicy_Autoenable_created_entities()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAutoenable_created_entities();

	/**
	 * Sets the value of the '{@link dds4ccm.efQosPolicy#isAutoenable_created_entities <em>Autoenable created entities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autoenable created entities</em>' attribute.
	 * @see #isAutoenable_created_entities()
	 * @generated
	 */
	void setAutoenable_created_entities(boolean value);

} // efQosPolicy
