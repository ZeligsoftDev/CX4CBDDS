/**
 */
package dds4ccm;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Default Value Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ConnectorDefaultValueBinding#getDefinition <em>Definition</em>}</li>
 *   <li>{@link dds4ccm.ConnectorDefaultValueBinding#getConnectorInstance <em>Connector Instance</em>}</li>
 *   <li>{@link dds4ccm.ConnectorDefaultValueBinding#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getConnectorDefaultValueBinding()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ConnectorDefaultValueBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(ConnectorDef)
	 * @see dds4ccm.DDS4CCMPackage#getConnectorDefaultValueBinding_Definition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectorDef getDefinition();

	/**
	 * Sets the value of the '{@link dds4ccm.ConnectorDefaultValueBinding#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(ConnectorDef value);

	/**
	 * Returns the value of the '<em><b>Connector Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Instance</em>' reference.
	 * @see #setConnectorInstance(NamedElement)
	 * @see dds4ccm.DDS4CCMPackage#getConnectorDefaultValueBinding_ConnectorInstance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getConnectorInstance();

	/**
	 * Sets the value of the '{@link dds4ccm.ConnectorDefaultValueBinding#getConnectorInstance <em>Connector Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Instance</em>' reference.
	 * @see #getConnectorInstance()
	 * @generated
	 */
	void setConnectorInstance(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see dds4ccm.DDS4CCMPackage#getConnectorDefaultValueBinding_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link dds4ccm.ConnectorDefaultValueBinding#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // ConnectorDefaultValueBinding
