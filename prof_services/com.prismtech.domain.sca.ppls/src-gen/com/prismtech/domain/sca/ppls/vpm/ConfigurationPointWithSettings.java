/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Point With Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.ConfigurationPointWithSettings#getSettableAttributes <em>Settable Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPointWithSettings()
 * @model
 * @generated
 */
public interface ConfigurationPointWithSettings extends ConfigurationPoint {
	/**
	 * Returns the value of the '<em><b>Settable Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link com.prismtech.domain.sca.ppls.vpm.SettableAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settable Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settable Attributes</em>' containment reference list.
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getConfigurationPointWithSettings_SettableAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SettableAttribute> getSettableAttributes();

} // ConfigurationPointWithSettings
