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
 * A representation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getName <em>Name</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getConstrainedElements <em>Constrained Elements</em>}</li>
 *   <li>{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends EObject {
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
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getVariationPoint_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constrained Elements</b></em>' containment reference list.
	 * The list contents are of type {@link com.prismtech.domain.sca.ppls.vpm.ConstrainedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Elements</em>' containment reference list.
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getVariationPoint_ConstrainedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstrainedElement> getConstrainedElements();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.prismtech.domain.sca.ppls.vpm.VpmPackage#getVariationPoint_Id()
	 * @model default="" id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.prismtech.domain.sca.ppls.vpm.VariationPoint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // VariationPoint
