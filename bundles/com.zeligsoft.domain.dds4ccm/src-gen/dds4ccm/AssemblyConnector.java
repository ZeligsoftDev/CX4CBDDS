/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Connector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.AssemblyConnector#getPortEnd <em>Port End</em>}</li>
 *   <li>{@link dds4ccm.AssemblyConnector#getBase_Connector <em>Base Connector</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getAssemblyConnector()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL end='end'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface AssemblyConnector extends EObject {
	/**
	 * Returns the value of the '<em><b>Port End</b></em>' reference list.
	 * The list contents are of type {@link dds4ccm.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port End</em>' reference list.
	 * @see dds4ccm.DDS4CCMPackage#getAssemblyConnector_PortEnd()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Port> getPortEnd();

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see dds4ccm.DDS4CCMPackage#getAssemblyConnector_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link dds4ccm.AssemblyConnector#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

} // AssemblyConnector
