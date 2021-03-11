/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.InterfacePort#getConnectorType <em>Connector Type</em>}</li>
 *   <li>{@link dds4ccm.InterfacePort#isAsynchronous <em>Is Asynchronous</em>}</li>
 *   <li>{@link dds4ccm.InterfacePort#isHasCSL <em>Has CSL</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getInterfacePort()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface InterfacePort extends MessagePort, ConjugatedPort, WorkerFunctionIdentifiable {
	/**
	 * Returns the value of the '<em><b>Connector Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Type</em>' reference.
	 * @see #setConnectorType(ComponentInterface)
	 * @see dds4ccm.DDS4CCMPackage#getInterfacePort_ConnectorType()
	 * @model ordered="false"
	 * @generated
	 */
	ComponentInterface getConnectorType();

	/**
	 * Sets the value of the '{@link dds4ccm.InterfacePort#getConnectorType <em>Connector Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Type</em>' reference.
	 * @see #getConnectorType()
	 * @generated
	 */
	void setConnectorType(ComponentInterface value);

	/**
	 * Returns the value of the '<em><b>Is Asynchronous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Asynchronous</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Asynchronous</em>' attribute.
	 * @see #setIsAsynchronous(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getInterfacePort_IsAsynchronous()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAsynchronous();

	/**
	 * Sets the value of the '{@link dds4ccm.InterfacePort#isAsynchronous <em>Is Asynchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Asynchronous</em>' attribute.
	 * @see #isAsynchronous()
	 * @generated
	 */
	void setIsAsynchronous(boolean value);

	/**
	 * Returns the value of the '<em><b>Has CSL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has CSL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has CSL</em>' attribute.
	 * @see #setHasCSL(boolean)
	 * @see dds4ccm.DDS4CCMPackage#getInterfacePort_HasCSL()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isHasCSL();

	/**
	 * Sets the value of the '{@link dds4ccm.InterfacePort#isHasCSL <em>Has CSL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has CSL</em>' attribute.
	 * @see #isHasCSL()
	 * @generated
	 */
	void setHasCSL(boolean value);

} // InterfacePort
