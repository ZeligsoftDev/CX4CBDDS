/**
 */
package dds4ccm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Deployment Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dds4ccm.ComponentDeploymentPart#getSelectedImplementation <em>Selected Implementation</em>}</li>
 *   <li>{@link dds4ccm.ComponentDeploymentPart#getImplementationConfiguration <em>Implementation Configuration</em>}</li>
 * </ul>
 *
 * @see dds4ccm.DDS4CCMPackage#getComponentDeploymentPart()
 * @model annotation="uml2.extensions suppressed='true'"
 * @generated
 */
public interface ComponentDeploymentPart extends DeploymentPart {
	/**
	 * Returns the value of the '<em><b>Selected Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Implementation</em>' reference.
	 * @see #setSelectedImplementation(Implementation)
	 * @see dds4ccm.DDS4CCMPackage#getComponentDeploymentPart_SelectedImplementation()
	 * @model ordered="false"
	 * @generated
	 */
	Implementation getSelectedImplementation();

	/**
	 * Sets the value of the '{@link dds4ccm.ComponentDeploymentPart#getSelectedImplementation <em>Selected Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected Implementation</em>' reference.
	 * @see #getSelectedImplementation()
	 * @generated
	 */
	void setSelectedImplementation(Implementation value);

	/**
	 * Returns the value of the '<em><b>Implementation Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Configuration</em>' reference.
	 * @see #setImplementationConfiguration(Configuration)
	 * @see dds4ccm.DDS4CCMPackage#getComponentDeploymentPart_ImplementationConfiguration()
	 * @model ordered="false"
	 * @generated
	 */
	Configuration getImplementationConfiguration();

	/**
	 * Sets the value of the '{@link dds4ccm.ComponentDeploymentPart#getImplementationConfiguration <em>Implementation Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Configuration</em>' reference.
	 * @see #getImplementationConfiguration()
	 * @generated
	 */
	void setImplementationConfiguration(Configuration value);

} // ComponentDeploymentPart
