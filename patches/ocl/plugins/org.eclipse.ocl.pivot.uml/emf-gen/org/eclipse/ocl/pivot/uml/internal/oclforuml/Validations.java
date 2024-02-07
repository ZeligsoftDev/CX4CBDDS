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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Controls the default validation of all InstanceSpecifications within a Package and its nested Packages.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations#isValidateInstanceSpecifications <em>Validate Instance Specifications</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidations()
 * @model
 * @generated
 */
public interface Validations
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidations_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Validate Instance Specifications</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether child instanceSpecifications should be validated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validate Instance Specifications</em>' attribute.
	 * @see #setValidateInstanceSpecifications(boolean)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getValidations_ValidateInstanceSpecifications()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isValidateInstanceSpecifications();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Validations#isValidateInstanceSpecifications <em>Validate Instance Specifications</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Instance Specifications</em>' attribute.
	 * @see #isValidateInstanceSpecifications()
	 * @generated
	 */
	void setValidateInstanceSpecifications(boolean value);

} // Validations
