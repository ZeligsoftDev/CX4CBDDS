/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.DomainDefinition#getDeployments <em>Deployments</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getDomainDefinition()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface DomainDefinition extends Domain {

	/**
	 * Returns the value of the '<em><b>Deployments</b></em>' reference list.
	 * The list contents are of type {@link dds4ccm.DomainDeployment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployments</em>' reference list.
	 * @see dds4ccm.DDS4CCMPackage#getDomainDefinition_Deployments()
	 * @model ordered="false"
	 * @generated
	 */
	EList<DomainDeployment> getDeployments();
} // DomainDefinition
