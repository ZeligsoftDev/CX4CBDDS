/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.TypedConnector#getConnectorType <em>Connector Type</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getTypedConnector()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface TypedConnector extends AssemblyConnector {
	/**
	 * Returns the value of the '<em><b>Connector Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Type</em>' reference.
	 * @see #setConnectorType(ConnectorDef)
	 * @see dds4ccm.DDS4CCMPackage#getTypedConnector_ConnectorType()
	 * @model ordered="false"
	 * @generated
	 */
	ConnectorDef getConnectorType();

	/**
	 * Sets the value of the '{@link dds4ccm.TypedConnector#getConnectorType <em>Connector Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Type</em>' reference.
	 * @see #getConnectorType()
	 * @generated
	 */
	void setConnectorType(ConnectorDef value);

} // TypedConnector
