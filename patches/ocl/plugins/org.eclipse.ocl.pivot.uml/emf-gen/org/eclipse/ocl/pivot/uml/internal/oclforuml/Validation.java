/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Controls the validation of an InstanceSpecification.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation#isValidate <em>Validate</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidation()
 * @model
 * @generated
 */
public interface Validation
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidation_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Validate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the instance(s) should be validated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validate</em>' attribute.
	 * @see #setValidate(boolean)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidation_Validate()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isValidate();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validation#isValidate <em>Validate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate</em>' attribute.
	 * @see #isValidate()
	 * @generated
	 */
	void setValidate(boolean value);

} // Validation
