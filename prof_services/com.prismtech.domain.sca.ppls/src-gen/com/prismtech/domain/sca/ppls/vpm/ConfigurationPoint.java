/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#isGenerate <em>Generate</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getName <em>Name</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getVariationPoint <em>Variation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPoint()
 * @model
 * @generated
 */
public interface ConfigurationPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Generate</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate</em>' attribute.
	 * @see #setGenerate(boolean)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPoint_Generate()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerate();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#isGenerate <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate</em>' attribute.
	 * @see #isGenerate()
	 * @generated
	 */
	void setGenerate(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPoint_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Variation Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point</em>' reference.
	 * @see #setVariationPoint(VariationPoint)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPoint_VariationPoint()
	 * @model required="true"
	 * @generated
	 */
	VariationPoint getVariationPoint();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPoint#getVariationPoint <em>Variation Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variation Point</em>' reference.
	 * @see #getVariationPoint()
	 * @generated
	 */
	void setVariationPoint(VariationPoint value);

} // ConfigurationPoint
