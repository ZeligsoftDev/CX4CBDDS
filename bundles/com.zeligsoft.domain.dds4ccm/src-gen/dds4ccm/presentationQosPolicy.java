/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>presentation Qos Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.presentationQosPolicy#getAccess_scope <em>Access scope</em>}</li>
 *   <li>{@link dds4ccm.presentationQosPolicy#isCoherent_access <em>Coherent access</em>}</li>
 *   <li>{@link dds4ccm.presentationQosPolicy#isOrdered_access <em>Ordered access</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getpresentationQosPolicy()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface presentationQosPolicy extends qosPolicy {
	/**
	 * Returns the value of the '<em><b>Access scope</b></em>' attribute.
	 * The default value is <code>"INSTANCE"</code>.
	 * The literals are from the enumeration {@link dds4ccm.PresentationQosPolicyAccessScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access scope</em>' attribute.
	 * @see dds4ccm.PresentationQosPolicyAccessScopeKind
	 * @see #setAccess_scope(PresentationQosPolicyAccessScopeKind)
	 * @see dds4ccm.DDS4CCMPackage#getpresentationQosPolicy_Access_scope()
	 * @model default="INSTANCE" required="true" ordered="false"
	 * @generated
	 */
	PresentationQosPolicyAccessScopeKind getAccess_scope();

	/**
	 * Sets the value of the '{@link dds4ccm.presentationQosPolicy#getAccess_scope <em>Access scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access scope</em>' attribute.
	 * @see dds4ccm.PresentationQosPolicyAccessScopeKind
	 * @see #getAccess_scope()
	 * @generated
	 */
	void setAccess_scope(PresentationQosPolicyAccessScopeKind value);

	/**
	 * Returns the value of the '<em><b>Coherent access</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coherent access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coherent access</em>' attribute.
	 * @see #setCoherent_access(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getpresentationQosPolicy_Coherent_access()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCoherent_access();

	/**
	 * Sets the value of the '{@link dds4ccm.presentationQosPolicy#isCoherent_access <em>Coherent access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coherent access</em>' attribute.
	 * @see #isCoherent_access()
	 * @generated
	 */
	void setCoherent_access(boolean value);

	/**
	 * Returns the value of the '<em><b>Ordered access</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered access</em>' attribute.
	 * @see #setOrdered_access(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getpresentationQosPolicy_Ordered_access()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isOrdered_access();

	/**
	 * Sets the value of the '{@link dds4ccm.presentationQosPolicy#isOrdered_access <em>Ordered access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered access</em>' attribute.
	 * @see #isOrdered_access()
	 * @generated
	 */
	void setOrdered_access(boolean value);

} // presentationQosPolicy
