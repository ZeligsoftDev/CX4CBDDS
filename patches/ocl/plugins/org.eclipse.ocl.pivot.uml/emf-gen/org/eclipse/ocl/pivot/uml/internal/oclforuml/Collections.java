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
 * A representation of the model object '<em><b>Collections</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies the default null-free-ness of Collections defined by composed properties of child Packages and/or Classes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollections()
 * @model
 * @generated
 */
public interface Collections
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollections_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

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
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollections_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the type of the TypedElement is a null-free Collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #isSetIsNullFree()
	 * @see #unsetIsNullFree()
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollections_IsNullFree()
	 * @model default="false" unsettable="true" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#isNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isSetIsNullFree()
	 * @see #unsetIsNullFree()
	 * @see #isNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#isNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsNullFree()
	 * @see #isNullFree()
	 * @see #setIsNullFree(boolean)
	 * @generated
	 */
	void unsetIsNullFree();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collections#isNullFree <em>Is Null Free</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Null Free</em>' attribute is set.
	 * @see #unsetIsNullFree()
	 * @see #isNullFree()
	 * @see #setIsNullFree(boolean)
	 * @generated
	 */
	boolean isSetIsNullFree();

} // Collections
