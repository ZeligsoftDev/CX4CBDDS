/**
 */
package dds4ccm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.DeploymentPart#getNestedPart <em>Nested Part</em>}</li>
 *   <li>{@link dds4ccm.DeploymentPart#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link dds4ccm.DeploymentPart#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link dds4ccm.DeploymentPart#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getDeploymentPart()
 * @model annotation="http://www.zeligsoft.com/zdl/2008/ZDL specification='type'"
 *        annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface DeploymentPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Nested Part</b></em>' reference list.
	 * The list contents are of type {@link dds4ccm.DeploymentPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Part</em>' reference list.
	 * @see dds4ccm.DDS4CCMPackage#getDeploymentPart_NestedPart()
	 * @model ordered="false"
	 * @generated
	 */
	EList<DeploymentPart> getNestedPart();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(Configuration)
	 * @see dds4ccm.DDS4CCMPackage#getDeploymentPart_Configuration()
	 * @model ordered="false"
	 * @generated
	 */
	Configuration getConfiguration();

	/**
	 * Sets the value of the '{@link dds4ccm.DeploymentPart#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(NamedElement)
	 * @see dds4ccm.DDS4CCMPackage#getDeploymentPart_ModelElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getModelElement();

	/**
	 * Sets the value of the '{@link dds4ccm.DeploymentPart#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see dds4ccm.DDS4CCMPackage#getDeploymentPart_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link dds4ccm.DeploymentPart#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // DeploymentPart
