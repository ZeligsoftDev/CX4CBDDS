/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage
 * @generated
 */
public interface VpmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VpmFactory eINSTANCE = com.prismtech.domain.sca.ppls.vpm.impl.VpmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Variation Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Point</em>'.
	 * @generated
	 */
	VariationPoint createVariationPoint();

	/**
	 * Returns a new object of class '<em>Variation Point With Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Point With Value</em>'.
	 * @generated
	 */
	VariationPointWithValue createVariationPointWithValue();

	/**
	 * Returns a new object of class '<em>Variation Point With Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variation Point With Settings</em>'.
	 * @generated
	 */
	VariationPointWithSettings createVariationPointWithSettings();

	/**
	 * Returns a new object of class '<em>Constrained Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constrained Element</em>'.
	 * @generated
	 */
	ConstrainedElement createConstrainedElement();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>VP Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VP Model</em>'.
	 * @generated
	 */
	VPModel createVPModel();

	/**
	 * Returns a new object of class '<em>Configuration Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Point</em>'.
	 * @generated
	 */
	ConfigurationPoint createConfigurationPoint();

	/**
	 * Returns a new object of class '<em>Configuration Point With Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Point With Value</em>'.
	 * @generated
	 */
	ConfigurationPointWithValue createConfigurationPointWithValue();

	/**
	 * Returns a new object of class '<em>Configuration Point With Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Point With Settings</em>'.
	 * @generated
	 */
	ConfigurationPointWithSettings createConfigurationPointWithSettings();

	/**
	 * Returns a new object of class '<em>Settable Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settable Attribute</em>'.
	 * @generated
	 */
	SettableAttribute createSettableAttribute();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VpmPackage getVpmPackage();

} //VpmFactory
