/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.Configuration#getConfigurationPoints <em>Configuration Points</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.Configuration#isGenerateDescriptors <em>Generate Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfiguration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueConfigurationName ConfigurationNameNotEmpty ConfigurationFileNameContainsNoIllegalCharacters'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UniqueConfigurationName='\n\t\tConfiguration.allInstances()->forAll(pc | pc <> self implies pc.name <> self.name)' ConfigurationNameNotEmpty='name.size() >0'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/Java ConfigurationFileNameContainsNoIllegalCharacters='[a-zA-Z0-9_-]*'"
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration Points</b></em>' containment reference list.
	 * The list contents are of type {@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Points</em>' containment reference list.
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfiguration_ConfigurationPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigurationPoint> getConfigurationPoints();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"VPModelConfig_"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfiguration_Name()
	 * @model default="VPModelConfig_" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Generate Descriptors</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Descriptors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Descriptors</em>' attribute.
	 * @see #setGenerateDescriptors(boolean)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfiguration_GenerateDescriptors()
	 * @model default="false"
	 * @generated
	 */
	boolean isGenerateDescriptors();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.Configuration#isGenerateDescriptors <em>Generate Descriptors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Descriptors</em>' attribute.
	 * @see #isGenerateDescriptors()
	 * @generated
	 */
	void setGenerateDescriptors(boolean value);

} // Configuration
