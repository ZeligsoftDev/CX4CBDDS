/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Point With Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPointWithValue()
 * @model
 * @generated
 */
public interface ConfigurationPointWithValue extends ConfigurationPoint {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPointWithValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ConfigurationPointWithValue
